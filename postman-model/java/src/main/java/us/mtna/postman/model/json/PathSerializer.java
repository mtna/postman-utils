package us.mtna.postman.model.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import us.mtna.postman.model.Path;
import us.mtna.postman.model.PathArray;
import us.mtna.postman.model.PathString;

public class PathSerializer extends JsonSerializer<Path> {

	protected ObjectMapper basicMapper;

	public PathSerializer() {
		// mapper that does not have this module registered
		this.basicMapper = new ObjectMapper();
	}

	@Override
	public void serialize(Path value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if (value instanceof PathString) {
			gen.writeString(((PathString) value).toString());
		} else {
			gen.writeRawValue(basicMapper.writeValueAsString(((PathArray) value).getPath()));
		}
	}

}
