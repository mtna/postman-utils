package us.mtna.postman.model.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import us.mtna.postman.model.Host;
import us.mtna.postman.model.HostArray;
import us.mtna.postman.model.HostString;

public class HostSerializer extends JsonSerializer<Host> {

	protected ObjectMapper basicMapper;

	public HostSerializer() {
		// mapper that does not have this module registered
		this.basicMapper = new ObjectMapper();
	}

	@Override
	public void serialize(Host value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if (value instanceof HostString) {
			gen.writeString(((HostString) value).toString());
		} else {
			gen.writeRawValue(basicMapper.writeValueAsString(((HostArray) value).getHost()));
		}
	}

}
