
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
 * UrlEncodedParameter
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "key", "value", "disabled", "description" })
public class Urlencoded {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("key")
	private String key;
	@JsonProperty("value")
	private String value;
	@JsonProperty("disabled")
	private Boolean disabled = false;
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
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("key")
	public String getKey() {
		return key;
	}

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("key")
	public void setKey(String key) {
		this.key = key;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("disabled")
	public Boolean getDisabled() {
		return disabled;
	}

	@JsonProperty("disabled")
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
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
		sb.append(Urlencoded.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("key");
		sb.append('=');
		sb.append(((this.key == null) ? "<null>" : this.key));
		sb.append(',');
		sb.append("value");
		sb.append('=');
		sb.append(((this.value == null) ? "<null>" : this.value));
		sb.append(',');
		sb.append("disabled");
		sb.append('=');
		sb.append(((this.disabled == null) ? "<null>" : this.disabled));
		sb.append(',');
		sb.append("description");
		sb.append('=');
		sb.append(((this.description == null) ? "<null>" : this.description));
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
		result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
		result = ((result * 31) + ((this.disabled == null) ? 0 : this.disabled.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.value == null) ? 0 : this.value.hashCode()));
		result = ((result * 31) + ((this.key == null) ? 0 : this.key.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Urlencoded) == false) {
			return false;
		}
		Urlencoded rhs = ((Urlencoded) other);
		return ((((((this.description == rhs.description)
				|| ((this.description != null) && this.description.equals(rhs.description)))
				&& ((this.disabled == rhs.disabled) || ((this.disabled != null) && this.disabled.equals(rhs.disabled))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.value == rhs.value) || ((this.value != null) && this.value.equals(rhs.value))))
				&& ((this.key == rhs.key) || ((this.key != null) && this.key.equals(rhs.key))));
	}

}