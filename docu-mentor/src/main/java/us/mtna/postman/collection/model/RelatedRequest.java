package us.mtna.postman.collection.model;

import java.util.Objects;

public class RelatedRequest {

	public enum ModelLocation {
		REQUEST, RESPONSE
	}

	private final String id;
	private final String name;
	private final ModelLocation location;

	public RelatedRequest(String id, String name, ModelLocation location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ModelLocation getLocation() {
		return location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, location.name());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RelatedRequest)) {
			return false;
		}
		RelatedRequest otherRequest = (RelatedRequest) obj;
		return id.equals(otherRequest.getId()) && location == otherRequest.getLocation();
	}

}
