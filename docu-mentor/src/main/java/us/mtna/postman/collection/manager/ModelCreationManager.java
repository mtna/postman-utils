package us.mtna.postman.collection.manager;

import us.mtna.postman.collection.model.ModelNames;
import us.mtna.postman.model.Collection;
import us.mtna.postman.model.Item;

/**
 * This manager is responsible for the evaluation of a Postman resource
 * ({@link Collection} or {@link Item}). It will run through the resource and
 * any subsequent requests that are a part of the resource and use the request
 * body and any saved example responses to create model objects and and either
 * add them to the collection as echo requests with a description of the
 * properties and where they are used.
 * 
 * @author Andrew DeCarlo
 *
 */
public interface ModelCreationManager {

	/**
	 * Runs through the entire collection and evaluates any request bodies and
	 * example responses. Builds models out of them and adds a API Model folder to
	 * the collection which will contain echo requests that describe the model
	 * properties and where they are used.
	 * 
	 * @param collection the collection to evaluate.
	 * @return a collection with an API Model folder that describes the models used
	 *         in the collection.
	 */
	Collection addModels(Collection collection);

	/**
	 * Renames the names of models in the {@link ModelNames#getCollection()} using
	 * the keys of {@link ModelNames#getModelNames()} to look up the model names and
	 * replace them with the provided values.
	 * 
	 * @param modelNames the wrapper of names and the collection to apply them to.
	 * @return the Collection with the names of the models updated.
	 */
	Collection renameModels(ModelNames modelNames);

}
