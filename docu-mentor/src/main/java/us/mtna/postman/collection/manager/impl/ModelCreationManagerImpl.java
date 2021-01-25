package us.mtna.postman.collection.manager.impl;

import us.mtna.postman.collection.manager.ModelCreationManager;
import us.mtna.postman.collection.model.CollectionModelGenerator;
import us.mtna.postman.collection.model.ModelNameUpdater;
import us.mtna.postman.collection.model.ModelNames;
import us.mtna.postman.model.Collection;

public class ModelCreationManagerImpl implements ModelCreationManager {

	@Override
	public Collection addModels(Collection collection) {
		CollectionModelGenerator generator = new CollectionModelGenerator(collection);
		return generator.generateModels();
	}

	@Override
	public Collection renameModels(ModelNames modelNames) {
		ModelNameUpdater updater = new ModelNameUpdater(modelNames);
		return updater.update();
	}

}
