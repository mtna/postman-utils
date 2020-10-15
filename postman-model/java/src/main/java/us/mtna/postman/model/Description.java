
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
 * Description
 * <p>
 * A Description can be a raw text, or be an object, which holds the description
 * along with its format.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "content", "type", "version" })
public class Description {

	/**
	 * The content of the description goes here, as a raw string.
	 * 
	 */
	@JsonProperty("content")
	@JsonPropertyDescription("The content of the description goes here, as a raw string.")
	private String content;
	/**
	 * Holds the mime type of the raw description content. E.g: 'text/markdown'
	 * or 'text/html'. The type is used to correctly render the description when
	 * generating documentation, or in the Postman app.
	 * 
	 */
	@JsonProperty("type")
	@JsonPropertyDescription("Holds the mime type of the raw description content. E.g: 'text/markdown' or 'text/html'.\nThe type is used to correctly render the description when generating documentation, or in the Postman app.")
	private String type;
	/**
	 * Description can have versions associated with it, which should be put in
	 * this property.
	 * 
	 */
	@JsonProperty("version")
	@JsonPropertyDescription("Description can have versions associated with it, which should be put in this property.")
	private Object version;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Description() {
		// TODO Auto-generated constructor stub
	}

	public Description(String content) {
		this(content, "text/markdown");
	}

	public Description(String content, String type) {
		this.content = content;
		this.type = type;
	}

	/**
	 * The content of the description goes here, as a raw string.
	 * 
	 */
	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	/**
	 * The content of the description goes here, as a raw string.
	 * 
	 */
	@JsonProperty("content")
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Holds the mime type of the raw description content. E.g: 'text/markdown'
	 * or 'text/html'. The type is used to correctly render the description when
	 * generating documentation, or in the Postman app.
	 * 
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * Holds the mime type of the raw description content. E.g: 'text/markdown'
	 * or 'text/html'. The type is used to correctly render the description when
	 * generating documentation, or in the Postman app.
	 * 
	 */
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Description can have versions associated with it, which should be put in
	 * this property.
	 * 
	 */
	@JsonProperty("version")
	public Object getVersion() {
		return version;
	}

	/**
	 * Description can have versions associated with it, which should be put in
	 * this property.
	 * 
	 */
	@JsonProperty("version")
	public void setVersion(Object version) {
		this.version = version;
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
		sb.append(Description.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("content");
		sb.append('=');
		sb.append(((this.content == null) ? "<null>" : this.content));
		sb.append(',');
		sb.append("type");
		sb.append('=');
		sb.append(((this.type == null) ? "<null>" : this.type));
		sb.append(',');
		sb.append("version");
		sb.append('=');
		sb.append(((this.version == null) ? "<null>" : this.version));
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
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
		result = ((result * 31) + ((this.version == null) ? 0 : this.version.hashCode()));
		result = ((result * 31) + ((this.content == null) ? 0 : this.content.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Description) == false) {
			return false;
		}
		Description rhs = ((Description) other);
		return (((((this.additionalProperties == rhs.additionalProperties)
				|| ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))
				&& ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
				&& ((this.version == rhs.version) || ((this.version != null) && this.version.equals(rhs.version))))
				&& ((this.content == rhs.content) || ((this.content != null) && this.content.equals(rhs.content))));
	}

}
