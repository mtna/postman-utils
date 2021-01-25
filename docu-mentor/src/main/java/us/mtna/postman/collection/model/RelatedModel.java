package us.mtna.postman.collection.model;

import us.mtna.postman.collection.model.RelatedRequest.ModelLocation;

public class RelatedModel {

	private final String modelName;
	private final String modelId;
	private final ModelLocation location;

	public RelatedModel(CollectionModel model, ModelLocation location) {
		this.modelId = model.getUuid();
		this.modelName = model.getModelName();
		this.location = location;
	}

	public String getModelName() {
		return modelName;
	}

	public String getModelId() {
		return modelId;
	}

	public ModelLocation getLocation() {
		return location;
	}

}
