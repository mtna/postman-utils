package us.mtna.postman.model.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import us.mtna.postman.model.Host;
import us.mtna.postman.model.Path;
import us.mtna.postman.model.UrlString;
import us.mtna.postman.model.Url;

public class UrlSerializer extends JsonSerializer<Url> {

	protected ObjectMapper basicMapper;
	
	public UrlSerializer(){
		// mapper that does not have this module registered
		this.basicMapper = new ObjectMapper();
		SimpleModule hostPathModule = new SimpleModule();
		hostPathModule.addSerializer(Host.class, new HostSerializer());
		hostPathModule.addSerializer(Path.class, new PathSerializer());
		this.basicMapper.registerModule(hostPathModule);
	}

	@Override
	public void serialize(Url value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if (value instanceof UrlString) {
			gen.writeString(((UrlString) value).toString());
		} else {
			gen.writeRawValue(basicMapper.writeValueAsString(value));
		}

	}

}
