package us.mtna.postman.model;

public class PathArray implements Path {

	private final String[] path;

	public PathArray(String... path) {
		this.path = path;
	}

	public String[] getPath() {
		return path;
	}
}
