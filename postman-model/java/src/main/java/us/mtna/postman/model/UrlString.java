package us.mtna.postman.model;

public class UrlString implements Url {

	private final String url;

	public UrlString(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return url.toString();
	}

}
