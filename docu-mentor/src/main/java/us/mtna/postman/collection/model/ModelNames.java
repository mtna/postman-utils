package us.mtna.postman.collection.model;

import java.util.Map;

import us.mtna.postman.model.Collection;

/**
 * Wraps a {@link Collection} with a map of model names, where the keys are the
 * original model names and the values are the names to rename them to.
 * 
 * @author andrew.decarlo
 *
 */
public class ModelNames {

	private Map<String, String> modelNames;
	private Collection collection;

	public Map<String, String> getModelNames() {
		return modelNames;
	}

	public void setModelNames(Map<String, String> modelNames) {
		this.modelNames = modelNames;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

}
