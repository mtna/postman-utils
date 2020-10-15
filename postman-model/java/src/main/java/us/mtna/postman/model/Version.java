
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
 * Collection Version
 * <p>
 * Postman allows you to version your collections as they grow, and this field
 * holds the version number. While optional, it is recommended that you use this
 * field to its fullest extent!
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "major", "minor", "patch", "identifier", "meta" })
public class Version {

	/**
	 * Increment this number if you make changes to the collection that changes
	 * its behaviour. E.g: Removing or adding new test scripts. (partly or
	 * completely). (Required)
	 * 
	 */
	@JsonProperty("major")
	@JsonPropertyDescription("Increment this number if you make changes to the collection that changes its behaviour. E.g: Removing or adding new test scripts. (partly or completely).")
	private Integer major;
	/**
	 * You should increment this number if you make changes that will not break
	 * anything that uses the collection. E.g: removing a folder. (Required)
	 * 
	 */
	@JsonProperty("minor")
	@JsonPropertyDescription("You should increment this number if you make changes that will not break anything that uses the collection. E.g: removing a folder.")
	private Integer minor;
	/**
	 * Ideally, minor changes to a collection should result in the increment of
	 * this number. (Required)
	 * 
	 */
	@JsonProperty("patch")
	@JsonPropertyDescription("Ideally, minor changes to a collection should result in the increment of this number.")
	private Integer patch;
	/**
	 * A human friendly identifier to make sense of the version numbers. E.g:
	 * 'beta-3'
	 * 
	 */
	@JsonProperty("identifier")
	@JsonPropertyDescription("A human friendly identifier to make sense of the version numbers. E.g: 'beta-3'")
	private String identifier;
	@JsonProperty("meta")
	private Object meta;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Increment this number if you make changes to the collection that changes
	 * its behaviour. E.g: Removing or adding new test scripts. (partly or
	 * completely). (Required)
	 * 
	 */
	@JsonProperty("major")
	public Integer getMajor() {
		return major;
	}

	/**
	 * Increment this number if you make changes to the collection that changes
	 * its behaviour. E.g: Removing or adding new test scripts. (partly or
	 * completely). (Required)
	 * 
	 */
	@JsonProperty("major")
	public void setMajor(Integer major) {
		this.major = major;
	}

	/**
	 * You should increment this number if you make changes that will not break
	 * anything that uses the collection. E.g: removing a folder. (Required)
	 * 
	 */
	@JsonProperty("minor")
	public Integer getMinor() {
		return minor;
	}

	/**
	 * You should increment this number if you make changes that will not break
	 * anything that uses the collection. E.g: removing a folder. (Required)
	 * 
	 */
	@JsonProperty("minor")
	public void setMinor(Integer minor) {
		this.minor = minor;
	}

	/**
	 * Ideally, minor changes to a collection should result in the increment of
	 * this number. (Required)
	 * 
	 */
	@JsonProperty("patch")
	public Integer getPatch() {
		return patch;
	}

	/**
	 * Ideally, minor changes to a collection should result in the increment of
	 * this number. (Required)
	 * 
	 */
	@JsonProperty("patch")
	public void setPatch(Integer patch) {
		this.patch = patch;
	}

	/**
	 * A human friendly identifier to make sense of the version numbers. E.g:
	 * 'beta-3'
	 * 
	 */
	@JsonProperty("identifier")
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * A human friendly identifier to make sense of the version numbers. E.g:
	 * 'beta-3'
	 * 
	 */
	@JsonProperty("identifier")
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@JsonProperty("meta")
	public Object getMeta() {
		return meta;
	}

	@JsonProperty("meta")
	public void setMeta(Object meta) {
		this.meta = meta;
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
		sb.append(Version.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("major");
		sb.append('=');
		sb.append(((this.major == null) ? "<null>" : this.major));
		sb.append(',');
		sb.append("minor");
		sb.append('=');
		sb.append(((this.minor == null) ? "<null>" : this.minor));
		sb.append(',');
		sb.append("patch");
		sb.append('=');
		sb.append(((this.patch == null) ? "<null>" : this.patch));
		sb.append(',');
		sb.append("identifier");
		sb.append('=');
		sb.append(((this.identifier == null) ? "<null>" : this.identifier));
		sb.append(',');
		sb.append("meta");
		sb.append('=');
		sb.append(((this.meta == null) ? "<null>" : this.meta));
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
		result = ((result * 31) + ((this.patch == null) ? 0 : this.patch.hashCode()));
		result = ((result * 31) + ((this.identifier == null) ? 0 : this.identifier.hashCode()));
		result = ((result * 31) + ((this.major == null) ? 0 : this.major.hashCode()));
		result = ((result * 31) + ((this.minor == null) ? 0 : this.minor.hashCode()));
		result = ((result * 31) + ((this.meta == null) ? 0 : this.meta.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Version) == false) {
			return false;
		}
		Version rhs = ((Version) other);
		return (((((((this.patch == rhs.patch) || ((this.patch != null) && this.patch.equals(rhs.patch)))
				&& ((this.identifier == rhs.identifier)
						|| ((this.identifier != null) && this.identifier.equals(rhs.identifier))))
				&& ((this.major == rhs.major) || ((this.major != null) && this.major.equals(rhs.major))))
				&& ((this.minor == rhs.minor) || ((this.minor != null) && this.minor.equals(rhs.minor))))
				&& ((this.meta == rhs.meta) || ((this.meta != null) && this.meta.equals(rhs.meta))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))));
	}

}
