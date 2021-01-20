package us.mtna.postman.model.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import us.mtna.postman.model.Item;
import us.mtna.postman.model.ItemGroup;
import us.mtna.postman.model.ItemImpl;

public class ItemDeserializer extends JsonDeserializer<Item> {

	private ObjectMapper mapper;

	public ItemDeserializer() {
	}

	@Override
	public Item deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// deserialize based on the properties that are present
		TreeNode node = p.readValueAsTree();
		if ((node.get("id") != null || node.get("request") != null || node.get("response") != null)
				&& node.get("item") == null) {
			return p.getCodec().treeToValue(node, ItemImpl.class);
		} else {
			return p.getCodec().treeToValue(node, ItemGroup.class);
		}
	}

	// TODO look into doing this better
	private ObjectMapper getMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			mapper.findAndRegisterModules();
		}
		return mapper;
	}

}
