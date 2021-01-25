package us.mtna.postman.collection.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import us.mtna.postman.model.Collection;
import us.mtna.postman.model.Description;
import us.mtna.postman.model.Item;
import us.mtna.postman.model.ItemGroup;
import us.mtna.postman.model.ItemImpl;

public class ModelNameUpdater {

	private final ModelNames modelNames;

	public ModelNameUpdater(ModelNames modelNames) {
		this.modelNames = modelNames;
	}

	public Collection update() {
		// get collection
		Collection collection = modelNames.getCollection();

		/* get all the items so we can search their documentation for the model name */
		List<Item> requestItems = ModelUtils.flattenItems(collection.getItem());

		// rename the model and its references
		renameModels(requestItems, modelNames.getModelNames());

		return collection;
	}

	private void renameModels(List<Item> items, Map<String, String> modelNames) {
		// we need to identify the model items, rename them, capture their request id
		Map<String, String> modelRequestIds = new HashMap<>();
		for (Item item : items) {
			if (item instanceof ItemImpl) {
				ItemImpl requestItem = (ItemImpl) item;
				if (modelNames.containsKey(requestItem.getName())) {
					// link the old name to the request id
					modelRequestIds.put(requestItem.getName(), requestItem.getId());

					// rename this request
					requestItem.setName(modelNames.get(requestItem.getName()));
				}
			}
		}

		/*
		 * we need to identify any text that matches the original model name in the form
		 * of the link [model_name](#id)
		 */
		for (Item item : items) {
			if (item instanceof ItemImpl) {
				ItemImpl requestItem = (ItemImpl) item;
				if (requestItem.getRequest() != null && requestItem.getRequest().getDescription() != null) {
					Description description = requestItem.getRequest().getDescription();
					renameModels(description, modelNames, modelRequestIds);
				}
			} else {
				ItemGroup group = (ItemGroup) item;
				if (group.getDescription() != null) {
					Description description = group.getDescription();
					renameModels(description, modelNames, modelRequestIds);
				}
			}
		}
	}

	private void renameModels(Description description, Map<String, String> modelNames,
			Map<String, String> modelRequestIds) {
		/*
		 * go through the text and build up matchers to replace any of the linked model
		 * names with the new values.
		 */
		String descriptionText = description.getContent();
		for (Entry<String, String> entry : modelRequestIds.entrySet()) {
			String replacement = "[" + modelNames.get(entry.getKey()) + "](#" + entry.getValue() + ")";
			descriptionText = descriptionText
					.replaceAll("\\[" + entry.getKey() + "\\]\\(\\#" + entry.getValue() + "\\)", replacement);
		}
		description.setContent(descriptionText);
	}

}
