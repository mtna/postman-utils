package us.mtna.postman.collection.model;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import us.mtna.postman.model.Collection;

public class CollectionModelGeneratorTest {

	private ObjectMapper mapper;
	private Collection collection;

	@Before
	public void setup() throws JsonParseException, JsonMappingException, IOException {
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		collection = mapper.readValue(new File("src/test/resources/demo_postman_collection.json"), Collection.class);
	}

	@Test
	public void testModelGeneration() throws Exception {
		CollectionModelGenerator modelGenerator = new CollectionModelGenerator(collection);
		Collection update = modelGenerator.generateModels();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/update.json"), update);
	}
}
