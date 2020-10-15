package us.mtna.postman.model.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import us.mtna.postman.model.Host;
import us.mtna.postman.model.HostArray;
import us.mtna.postman.model.HostString;

public class HostDeserializer extends JsonDeserializer<Host> {

	private ObjectMapper mapper;

	public HostDeserializer() {
		this.mapper = new ObjectMapper();
	}

	@Override
	public Host deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Host host = null;
		if (p.currentToken() == JsonToken.VALUE_STRING) {
			host = new HostString(p.getValueAsString());
		} else {
			String[] hostArr = mapper.readValue(p, String[].class);
			host = new HostArray(hostArr);
		}
		return host;
	}

}
