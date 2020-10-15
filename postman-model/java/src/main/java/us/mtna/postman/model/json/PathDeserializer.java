package us.mtna.postman.model.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import us.mtna.postman.model.Path;
import us.mtna.postman.model.PathArray;
import us.mtna.postman.model.PathString;

public class PathDeserializer extends JsonDeserializer<Path> {

	private ObjectMapper mapper;

	public PathDeserializer() {
		this.mapper = new ObjectMapper();
	}

	@Override
	public Path deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Path path = null;
		if (p.currentToken() == JsonToken.VALUE_STRING) {
			path = new PathString(p.getValueAsString());
		} else {
			String[] pathArr = mapper.readValue(p, String[].class);
			path = new PathArray(pathArr);
		}
		return path;
	}

}
