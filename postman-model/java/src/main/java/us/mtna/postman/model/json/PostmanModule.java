package us.mtna.postman.model.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

import us.mtna.postman.model.Host;
import us.mtna.postman.model.Path;
import us.mtna.postman.model.Url;

public class PostmanModule extends SimpleModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostmanModule() {
		super(new Version(1, 0, 0, "SNAPSHOT", "us.mtna.postman.model", "postman-model"));
		this.addSerializer(Url.class, new UrlSerializer());
		this.addSerializer(Host.class, new HostSerializer());
		this.addSerializer(Path.class, new PathSerializer());
		this.addDeserializer(Url.class, new UrlDeserializer());
		this.addDeserializer(Host.class, new HostDeserializer());
		this.addDeserializer(Path.class, new PathDeserializer());
	}
}
