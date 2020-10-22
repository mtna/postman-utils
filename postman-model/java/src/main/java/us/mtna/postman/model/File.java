
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "src", "content" })
public class File {

	/**
	 * Contains the name of the file to upload. _Not the path_.
	 * 
	 */
	@JsonProperty("src")
	@JsonPropertyDescription("Contains the name of the file to upload. _Not the path_.")
	private String src;
	@JsonProperty("content")
	private String content;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Contains the name of the file to upload. _Not the path_.
	 * 
	 */
	@JsonProperty("src")
	public String getSrc() {
		return src;
	}

	/**
	 * Contains the name of the file to upload. _Not the path_.
	 * 
	 */
	@JsonProperty("src")
	public void setSrc(String src) {
		this.src = src;
	}

	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	@JsonProperty("content")
	public void setContent(String content) {
		this.content = content;
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
		sb.append(File.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("src");
		sb.append('=');
		sb.append(((this.src == null) ? "<null>" : this.src));
		sb.append(',');
		sb.append("content");
		sb.append('=');
		sb.append(((this.content == null) ? "<null>" : this.content));
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
		result = ((result * 31) + ((this.src == null) ? 0 : this.src.hashCode()));
		result = ((result * 31) + ((this.content == null) ? 0 : this.content.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof File) == false) {
			return false;
		}
		File rhs = ((File) other);
		return ((((this.additionalProperties == rhs.additionalProperties)
				|| ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))
				&& ((this.src == rhs.src) || ((this.src != null) && this.src.equals(rhs.src))))
				&& ((this.content == rhs.content) || ((this.content != null) && this.content.equals(rhs.content))));
	}

}
