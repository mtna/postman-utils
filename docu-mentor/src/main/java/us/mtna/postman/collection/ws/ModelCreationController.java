package us.mtna.postman.collection.ws;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import us.mtna.postman.collection.manager.ModelCreationManager;
import us.mtna.postman.collection.model.ModelNames;
import us.mtna.postman.model.Collection;

@RestController
@RequestMapping("/api/model")
public class ModelCreationController {

	private final ModelCreationManager manager;

	public ModelCreationController(ModelCreationManager manager) {
		this.manager = manager;
	}

	/**
	 * Generate Models. <br />
	 * <p>
	 * This will evaluate the provided Postman {@link Collection}, in particular the
	 * request and response bodies that are written in JSON. It will build out
	 * models for these objects and add them to the collection in an API Models
	 * folder. The models and requests will link to each other in order to provide
	 * users with information about the models and their properties.
	 * </p>
	 * 
	 * @return The updated {@link Collection}.
	 * 
	 * @HTTP 200 Collection models added successfully.
	 */
	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public Collection generateModels(@RequestBody Collection collection) {
		return manager.addModels(collection);
	}

	/**
	 * Name Models. <br />
	 * <p>
	 * This is meant to be used after the models have been generated, in which case
	 * the models will all be named generic names like "Model 1", "Model 2", etc.
	 * This provides a way to look up the original model name and replace all the
	 * instances of it in the documentation of the requests to be the newly provided
	 * name.
	 * </p>
	 * 
	 * @return The updated {@link Collection}.
	 * 
	 * @HTTP 200 Collection models renamed successfully.
	 */
	@RequestMapping(value = "/rename", method = RequestMethod.POST)
	public Collection renameModels(@RequestBody ModelNames modelNames) {
		return manager.renameModels(modelNames);
	}

}
