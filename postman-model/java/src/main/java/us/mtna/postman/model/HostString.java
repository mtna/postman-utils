package us.mtna.postman.model;

public class HostString implements Host {

	private final String host;

	public HostString(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return host.toString();
	}

}
