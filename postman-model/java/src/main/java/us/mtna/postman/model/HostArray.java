package us.mtna.postman.model;

public class HostArray implements Host {

	private final String[] host;

	public HostArray(String... host) {
		this.host = host;
	}

	public String[] getHost() {
		return host;
	}
}
