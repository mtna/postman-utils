package us.mtna.postman.model.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import us.mtna.postman.model.Host;
import us.mtna.postman.model.Path;
import us.mtna.postman.model.UrlString;
import us.mtna.postman.model.Url;
import us.mtna.postman.model.UrlImpl;

public class UrlDeserializer extends JsonDeserializer<Url> {

	private ObjectMapper mapper;

	public UrlDeserializer() {
		this.mapper = new ObjectMapper();
		SimpleModule hostPathModule = new SimpleModule();
		hostPathModule.addDeserializer(Host.class, new HostDeserializer());
		hostPathModule.addDeserializer(Path.class, new PathDeserializer());
		this.mapper.registerModule(hostPathModule);
	}

	@Override
	public Url deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Url url = null;
		if (p.currentToken() == JsonToken.VALUE_STRING) {
			url = new UrlString(p.getValueAsString());
		} else {
			url = mapper.readValue(p, UrlImpl.class);
		}
		return url;
	}

}
