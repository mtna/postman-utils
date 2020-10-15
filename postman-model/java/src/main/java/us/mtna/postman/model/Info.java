
package us.mtna.postman.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Information
 * <p>
 * Detailed description of the info block
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "_postman_id", "description", "version", "schema" })
public class Info {

	/**
	 * Name of the collection
	 * <p>
	 * A collection's friendly name is defined by this field. You would want to
	 * set this field to a value that would allow you to easily identify this
	 * collection among a bunch of other collections, as such outlining its
	 * usage or content. (Required)
	 * 
	 */
	@JsonProperty("name")
	@JsonPropertyDescription("A collection's friendly name is defined by this field. You would want to set this field to a value that would allow you to easily identify this collection among a bunch of other collections, as such outlining its usage or content.")
	private String name;
	/**
	 * Every collection is identified by the unique value of this field. The
	 * value of this field is usually easiest to generate using a UID generator
	 * function. If you already have a collection, it is recommended that you
	 * maintain the same id since changing the id usually implies that is a
	 * different collection than it was originally. *Note: This field exists for
	 * compatibility reasons with Collection Format V1.*
	 * 
	 */
	@JsonProperty("_postman_id")
	@JsonPropertyDescription("Every collection is identified by the unique value of this field. The value of this field is usually easiest to generate using a UID generator function. If you already have a collection, it is recommended that you maintain the same id since changing the id usually implies that is a different collection than it was originally.\n *Note: This field exists for compatibility reasons with Collection Format V1.*")
	private String postmanId;
	/**
	 * Description
	 * <p>
	 * A Description can be a raw text, or be an object, which holds the
	 * description along with its format.
	 * 
	 */
	@JsonProperty("description")
	@JsonPropertyDescription("A Description can be a raw text, or be an object, which holds the description along with its format.")
	private Description description;
	/**
	 * Collection Version
	 * <p>
	 * Postman allows you to version your collections as they grow, and this
	 * field holds the version number. While optional, it is recommended that
	 * you use this field to its fullest extent!
	 * 
	 */
	@JsonProperty("version")
	@JsonPropertyDescription("Postman allows you to version your collections as they grow, and this field holds the version number. While optional, it is recommended that you use this field to its fullest extent!")
	private Version version;
	/**
	 * This should ideally hold a link to the Postman schema that is used to
	 * validate this collection. E.g:
	 * https://schema.getpostman.com/collection/v1 (Required)
	 * 
	 */
	@JsonProperty("schema")
	@JsonPropertyDescription("This should ideally hold a link to the Postman schema that is used to validate this collection. E.g: https://schema.getpostman.com/collection/v1")
	private String schema;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Name of the collection
	 * <p>
	 * A collection's friendly name is defined by this field. You would want to
	 * set this field to a value that would allow you to easily identify this
	 * collection among a bunch of other collections, as such outlining its
	 * usage or content. (Required)
	 * 
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * Name of the collection
	 * <p>
	 * A collection's friendly name is defined by this field. You would want to
	 * set this field to a value that would allow you to easily identify this
	 * collection among a bunch of other collections, as such outlining its
	 * usage or content. (Required)
	 * 
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Every collection is identified by the unique value of this field. The
	 * value of this field is usually easiest to generate using a UID generator
	 * function. If you already have a collection, it is recommended that you
	 * maintain the same id since changing the id usually implies that is a
	 * different collection than it was originally. *Note: This field exists for
	 * compatibility reasons with Collection Format V1.*
	 * 
	 */
	@JsonProperty("_postman_id")
	public String getPostmanId() {
		return postmanId;
	}

	/**
	 * Every collection is identified by the unique value of this field. The
	 * value of this field is usually easiest to generate using a UID generator
	 * function. If you already have a collection, it is recommended that you
	 * maintain the same id since changing the id usually implies that is a
	 * different collection than it was originally. *Note: This field exists for
	 * compatibility reasons with Collection Format V1.*
	 * 
	 */
	@JsonProperty("_postman_id")
	public void setPostmanId(String postmanId) {
		this.postmanId = postmanId;
	}

	/**
	 * Description
	 * <p>
	 * A Description can be a raw text, or be an object, which holds the
	 * description along with its format.
	 * 
	 */
	@JsonProperty("description")
	public Description getDescription() {
		return description;
	}

	/**
	 * Description
	 * <p>
	 * A Description can be a raw text, or be an object, which holds the
	 * description along with its format.
	 * 
	 */
	@JsonProperty("description")
	public void setDescription(Description description) {
		this.description = description;
	}

	/**
	 * Collection Version
	 * <p>
	 * Postman allows you to version your collections as they grow, and this
	 * field holds the version number. While optional, it is recommended that
	 * you use this field to its fullest extent!
	 * 
	 */
	@JsonProperty("version")
	public Version getVersion() {
		return version;
	}

	/**
	 * Collection Version
	 * <p>
	 * Postman allows you to version your collections as they grow, and this
	 * field holds the version number. While optional, it is recommended that
	 * you use this field to its fullest extent!
	 * 
	 */
	@JsonProperty("version")
	public void setVersion(Version version) {
		this.version = version;
	}

	/**
	 * This should ideally hold a link to the Postman schema that is used to
	 * validate this collection. E.g:
	 * https://schema.getpostman.com/collection/v1 (Required)
	 * 
	 */
	@JsonProperty("schema")
	public String getSchema() {
		return schema;
	}

	/**
	 * This should ideally hold a link to the Postman schema that is used to
	 * validate this collection. E.g:
	 * https://schema.getpostman.com/collection/v1 (Required)
	 * 
	 */
	@JsonProperty("schema")
	public void setSchema(String schema) {
		this.schema = schema;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Info.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("postmanId");
		sb.append('=');
		sb.append(((this.postmanId == null) ? "<null>" : this.postmanId));
		sb.append(',');
		sb.append("description");
		sb.append('=');
		sb.append(((this.description == null) ? "<null>" : this.description));
		sb.append(',');
		sb.append("version");
		sb.append('=');
		sb.append(((this.version == null) ? "<null>" : this.version));
		sb.append(',');
		sb.append("schema");
		sb.append('=');
		sb.append(((this.schema == null) ? "<null>" : this.schema));
		sb.append(',');
		sb.append("additionalProperties");
		sb.append('=');
		sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = ((result * 31) + ((this.schema == null) ? 0 : this.schema.hashCode()));
		result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
		result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
		result = ((result * 31) + ((this.postmanId == null) ? 0 : this.postmanId.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.version == null) ? 0 : this.version.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Info) == false) {
			return false;
		}
		Info rhs = ((Info) other);
		return (((((((this.schema == rhs.schema) || ((this.schema != null) && this.schema.equals(rhs.schema)))
				&& ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
				&& ((this.description == rhs.description)
						|| ((this.description != null) && this.description.equals(rhs.description))))
				&& ((this.postmanId == rhs.postmanId)
						|| ((this.postmanId != null) && this.postmanId.equals(rhs.postmanId))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.version == rhs.version) || ((this.version != null) && this.version.equals(rhs.version))));
	}

}
