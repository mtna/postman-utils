package us.mtna.postman.collection.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.util.DigestUtils;

public class CollectionModel {

	private final TreeMap<String, Object> model;
	private final String originalModel;
	private final String uuid;
	private String requestId;
	private String modelName;
	private HashSet<RelatedRequest> relatedRequests;

	public CollectionModel(String originalModel, TreeMap<String, Object> model) {
		this.originalModel = originalModel;
		this.model = model;
		this.uuid = UUID.randomUUID().toString();
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void addRelatedRequest(RelatedRequest request) {
		if (relatedRequests == null) {
			setRelatedRequests(new HashSet<>());
		}
		relatedRequests.add(request);
	}

	public HashSet<RelatedRequest> getRelatedRequests() {
		return relatedRequests;
	}

	public void setRelatedRequests(HashSet<RelatedRequest> relatedRequestIds) {
		this.relatedRequests = relatedRequestIds;
	}

	public TreeMap<String, Object> getModel() {
		return model;
	}

	public String getOriginalModel() {
		return originalModel;
	}

	public String getType(String key) {
		Object value = model.get(key);
		return getType(value);
	}

	public String getUuid() {
		return uuid;
	}

	public String getModelKey() {
		StringBuilder sb = new StringBuilder();
		for (String key : model.keySet()) {
			sb.append(key);
		}
		return DigestUtils.md5DigestAsHex(sb.toString().getBytes());
	}

	private String getType(Object value) {
		if (value instanceof String) {
			return "string";
		} else if (value instanceof Number) {
			return "number";
		} else if (value instanceof Boolean) {
			return "boolean";
		} else if (value instanceof Date) {
			return "date";
		} else if (value instanceof Collection) {
			@SuppressWarnings("rawtypes")
			Collection collection = (Collection) value;
			if (collection.isEmpty()) {
				return "object[]";
			} else {
				Object v = collection.iterator().next();
				return getType(v) + "[]";
			}
		} else if (value instanceof CollectionModel) {
			CollectionModel collModel = (CollectionModel) value;
			return "[" + collModel.getModelName() + "](#" + collModel.getUuid() + ")";
		}
		return "";
	}

}
