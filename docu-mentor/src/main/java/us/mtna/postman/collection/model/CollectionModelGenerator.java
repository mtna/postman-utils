package us.mtna.postman.collection.model;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import us.mtna.postman.collection.model.RelatedRequest.ModelLocation;
import us.mtna.postman.model.Body;
import us.mtna.postman.model.Collection;
import us.mtna.postman.model.Description;
import us.mtna.postman.model.Header;
import us.mtna.postman.model.Item;
import us.mtna.postman.model.ItemGroup;
import us.mtna.postman.model.ItemImpl;
import us.mtna.postman.model.Request;
import us.mtna.postman.model.Response;

public class CollectionModelGenerator {

	private static final String options = "options";
	private static final String raw = "raw";
	private static final String lang = "language";
	private static final String json = "json";

	private final Log logger = LogFactory.getLog(getClass());
	private final Collection collection;
	private final ObjectMapper mapper;
	private final VelocityEngine velocityEngine;
	private final String encoding;

	public CollectionModelGenerator(Collection collection) {
		this.collection = collection;
		// jackson setup
		this.mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule("treemaps", Version.unknownVersion());
		module.addAbstractTypeMapping(Map.class, TreeMap.class);
		mapper.registerModule(module);
		// velocity setup
		encoding = "UTF-8";
		velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, NullLogChute.class);
		velocityEngine.init();
	}

	public Collection generateModels() {
		// get the high level models from the collection.
		HashMap<String, CollectionModel> modelMap = getModels();

		// use the high level models to build out all the models
		List<CollectionModel> models = expandModels(modelMap);

		// add the models to the collection
		return addModels(models);
	}

	private Collection addModels(List<CollectionModel> models) {
		// add folder for requests
		ItemGroup modelGroup = new ItemGroup();
		modelGroup.setName("API Models");
		modelGroup.setDescription(getDescription("templates/folder_description.vm"));

		List<Item> modelItems = new ArrayList<>();
		for (CollectionModel model : models) {
			modelItems.add(getModelItem(model));
		}
		modelGroup.setItem(modelItems);
		collection.getItem().add(modelGroup);

		// aggregate the requests the models are used in and add to their descriptions
		Map<String, List<RelatedModel>> relatedModels = new HashMap<>();
		for (CollectionModel model : models) {
			if (model.getRelatedRequests() != null) {
				for (RelatedRequest related : model.getRelatedRequests()) {
					List<RelatedModel> rm = relatedModels.getOrDefault(related.getId(), new ArrayList<>());
					rm.add(new RelatedModel(model, related.getLocation()));
					relatedModels.put(related.getId(), rm);
				}
			}
		}
		List<ItemImpl> requestItems = ModelUtils.getRequestItems(collection.getItem());
		for (ItemImpl requestItem : requestItems) {
			if (relatedModels.containsKey(requestItem.getId())) {
				if (requestItem.getRequest() != null) {
					Request request = requestItem.getRequest();
					StringWriter writer = new StringWriter();
					Template template = velocityEngine.getTemplate("templates/request_model_appender.vm", encoding);
					VelocityContext context = new VelocityContext();
					context.put("relatedModels", relatedModels.get(requestItem.getId()));
					template.merge(context, writer);
					if (request.getDescription() == null) {
						request.setDescription(new Description(writer.toString()));
					} else {
						Description description = request.getDescription();
						description.setContent(description.getContent() + "\n" + writer.toString());
					}
				}
			}
		}

		return collection;
	}

	private ItemImpl getModelItem(CollectionModel model) {
		ItemImpl requestItem = new ItemImpl();
		requestItem.setId(model.getUuid());
		requestItem.setName(model.getModelName());

		Request request = new Request();
		VelocityContext context = new VelocityContext();
		context.put("model", model);
		request.setDescription(getDescription("templates/request_description.vm", context));
		requestItem.setRequest(request);
		Response response = new Response();
		response.setPostmanPreviewLanguage("json");
		Header header = new Header();
		header.setKey("Content-Type");
		header.setValue("application/json");
		response.setHeader(Arrays.asList(header));
		response.setName("Model Example");
		response.setBody(model.getOriginalModel());
		requestItem.setResponse(Arrays.asList(response));
		return requestItem;
	}

	private List<CollectionModel> expandModels(HashMap<String, CollectionModel> modelMap) {
		HashMap<String, CollectionModel> expandedMap = new HashMap<>(modelMap);
		for (CollectionModel model : modelMap.values()) {
			try {
				Map<String, Object> replacements = addChildModels(model, expandedMap);
				CollectionModel expandedModel = expandedMap.get(model.getModelKey());
				expandedModel.getModel().putAll(replacements);
				expandedMap.put(expandedModel.getModelKey(), expandedModel);
			} catch (Exception e) {
				throw new RuntimeException("could not expand models", e);
			}
		}

		List<CollectionModel> models = new ArrayList<>(expandedMap.values());
		// sort by number of properties largest to smallest.
		models.sort(new Comparator<CollectionModel>() {

			@Override
			public int compare(CollectionModel o1, CollectionModel o2) {
				return o2.getModel().size() - o1.getModel().size();
			}

		});

		// add generic name
		for (int i = 0; i < models.size(); i++) {
			models.get(i).setModelName("Model " + (i + 1));
		}

		return models;
	}

	private Map<String, Object> addChildModels(CollectionModel model, HashMap<String, CollectionModel> expandedMap)
			throws Exception {
		Map<String, Object> replacements = new HashMap<>();
		for (Entry<String, Object> entry : model.getModel().entrySet()) {
			if (entry.getValue() != null && entry.getValue() instanceof TreeMap) {
				@SuppressWarnings("unchecked")
				CollectionModel subModel = new CollectionModel(
						mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entry.getValue()),
						(TreeMap<String, Object>) entry.getValue());
				subModel = expandedMap.containsKey(subModel.getModelKey()) ? expandedMap.get(subModel.getModelKey())
						: subModel;
				replacements.put(entry.getKey(), subModel);
				addChildModels(subModel, expandedMap);
			} else if (entry.getValue() != null && entry.getValue() instanceof java.util.Collection) {
				@SuppressWarnings("rawtypes")
				java.util.Collection collection = (java.util.Collection) entry.getValue();
				if (collection.size() > 0) {
					Object value = collection.iterator().next();
					if (value != null && value instanceof TreeMap) {
						@SuppressWarnings("unchecked")
						CollectionModel subModel = new CollectionModel(
								mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value),
								(TreeMap<String, Object>) value);
						subModel = expandedMap.containsKey(subModel.getModelKey())
								? expandedMap.get(subModel.getModelKey())
								: subModel;
						replacements.put(entry.getKey(), Arrays.asList(subModel));
						addChildModels(subModel, expandedMap);
					}
				}
			}
		}
		model.getModel().putAll(replacements);
		expandedMap.put(model.getModelKey(), model);
		return replacements;
	}

	private HashMap<String, CollectionModel> getModels() {
		// iterate through all the requests and build up the models
		List<ItemImpl> requestItems = ModelUtils.getRequestItems(collection.getItem());
		HashMap<String, CollectionModel> models = new HashMap<>();
		for (ItemImpl requestItem : requestItems) {
			// if the request item doesnt have an id, set one
			if (requestItem.getId() == null) {
				if (requestItem.getPostmanId() != null) {
					requestItem.setId(requestItem.getPostmanId());
				} else {
					requestItem.setId(UUID.randomUUID().toString());
				}
			}

			// process request body
			Body body = null;
			if ((body = getBody(requestItem)) != null) {
				boolean isJson = isJson(body);
				if (!isJson) {
					logger.debug("Currently generates models for JSON request bodies only. Skipping request ["
							+ requestItem.getName() + "].");
					continue;
				}
				try {
					@SuppressWarnings("unchecked")
					TreeMap<String, Object> map = (TreeMap<String, Object>) mapper.readValue(body.getRaw(),
							TreeMap.class);

					CollectionModel model = new CollectionModel(body.getRaw(), map);
					if (models.containsKey(model.getModelKey())) {
						model = models.get(model.getModelKey());
					}
					model.addRelatedRequest(
							new RelatedRequest(requestItem.getId(), requestItem.getName(), ModelLocation.REQUEST));
					models.put(model.getModelKey(), model);
				} catch (Exception e) {
					logger.error("Could not read request body for [" + requestItem.getName() + "], skipping.");
				}
			}

			// process response body
			for (Response response : getJsonResponses(requestItem)) {
				try {
					@SuppressWarnings("unchecked")
					TreeMap<String, Object> map = (TreeMap<String, Object>) mapper.readValue(response.getBody(),
							TreeMap.class);
					CollectionModel model = new CollectionModel(response.getBody(), map);
					if (models.containsKey(model.getModelKey())) {
						model = models.get(model.getModelKey());
					}
					model.addRelatedRequest(
							new RelatedRequest(requestItem.getId(), requestItem.getName(), ModelLocation.RESPONSE));
					models.put(model.getModelKey(), model);
				} catch (Exception e) {
					logger.error("Could not read response body for [" + requestItem.getName() + "], skipping.");
				}
			}
		}
		return models;
	}

	/**
	 * Checks the {@link Body#getAdditionalProperties()} for options specifying the
	 * language is JSON.
	 * 
	 * @param body the {@link Body} to evaluate.
	 * @return {@code true} if the body is found to be a JSON object, {@code false}
	 *         otherwise.
	 */
	private boolean isJson(Body body) {
		if (body.getAdditionalProperties() != null && body.getAdditionalProperties().containsKey(options)) {
			Map<?, ?> optionMap = (Map<?, ?>) body.getAdditionalProperties().get(options);
			if (optionMap.containsKey(raw)) {
				Map<?, ?> rawMap = (Map<?, ?>) optionMap.get(raw);
				if (rawMap.containsKey(lang)) {
					Object language = rawMap.get(lang);
					return json.equals(language);
				}
			}
		}
		return false;
	}

	private Body getBody(ItemImpl requestItem) {
		Request request = requestItem.getRequest();
		return request != null && request.getBody() != null ? request.getBody() : null;
	}

	private List<Response> getJsonResponses(ItemImpl requestItem) {
		List<Response> responses = requestItem.getResponse();

		// iterate through responses and look for a JSON response
		List<Response> jsonResponses = new ArrayList<>();
		if (responses != null) {
			for (Response r : responses) {
				if (r.getHeader() != null) {
					for (Header header : r.getHeader()) {
						if ("content-type".equalsIgnoreCase(header.getKey())
								&& "application/json".equalsIgnoreCase(header.getValue())) {
							jsonResponses.add(r);
							break;
						}
					}
				} else if (r.getPostmanPreviewLanguage().equals("json")) {
					jsonResponses.add(r);
				}
			}
		}
		return jsonResponses;
	}

	private Description getDescription(String templatePath) {
		return getDescription(templatePath, new VelocityContext());
	}

	private Description getDescription(String templatePath, VelocityContext context) {
		StringWriter writer = new StringWriter();
		Template template = velocityEngine.getTemplate(templatePath, encoding);
		template.merge(context, writer);
		return new Description(writer.toString());
	}
}
