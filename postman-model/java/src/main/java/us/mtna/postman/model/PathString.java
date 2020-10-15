package us.mtna.postman.model;

public class PathString implements Path {

	private final String path;

	public PathString(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return path.toString();
	}
}
