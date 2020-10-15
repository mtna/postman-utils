
package us.mtna.postman.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Script
 * <p>
 * A script is a snippet of Javascript code that can be used to to perform setup
 * or teardown operations on a particular response.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "type", "exec", "src", "name" })
public class Script {

	/**
	 * A unique, user defined identifier that can be used to refer to this
	 * script from requests.
	 * 
	 */
	@JsonProperty("id")
	@JsonPropertyDescription("A unique, user defined identifier that can  be used to refer to this script from requests.")
	private String id;
	/**
	 * Type of the script. E.g: 'text/javascript'
	 * 
	 */
	@JsonProperty("type")
	@JsonPropertyDescription("Type of the script. E.g: 'text/javascript'")
	private String type;
	/**
	 * This is an array of strings, where each line represents a single line of
	 * code. Having lines separate makes it possible to easily track changes
	 * made to scripts.
	 * 
	 */
	@JsonProperty("exec")
	@JsonPropertyDescription("This is an array of strings, where each line represents a single line of code. Having lines separate makes it possible to easily track changes made to scripts.")
	private List<String> exec = new ArrayList<String>();
	/**
	 * Url
	 * <p>
	 * If object, contains the complete broken-down URL for this request. If
	 * string, contains the literal request URL.
	 * 
	 */
	@JsonProperty("src")
	@JsonPropertyDescription("If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.")
	private UrlImpl src;
	/**
	 * Script name
	 * 
	 */
	@JsonProperty("name")
	@JsonPropertyDescription("Script name")
	private String name;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * A unique, user defined identifier that can be used to refer to this
	 * script from requests.
	 * 
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * A unique, user defined identifier that can be used to refer to this
	 * script from requests.
	 * 
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Type of the script. E.g: 'text/javascript'
	 * 
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * Type of the script. E.g: 'text/javascript'
	 * 
	 */
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This is an array of strings, where each line represents a single line of
	 * code. Having lines separate makes it possible to easily track changes
	 * made to scripts.
	 * 
	 */
	@JsonProperty("exec")
	public List<String> getExec() {
		return exec;
	}

	/**
	 * This is an array of strings, where each line represents a single line of
	 * code. Having lines separate makes it possible to easily track changes
	 * made to scripts.
	 * 
	 */
	@JsonProperty("exec")
	public void setExec(List<String> exec) {
		this.exec = exec;
	}

	/**
	 * Url
	 * <p>
	 * If object, contains the complete broken-down URL for this request. If
	 * string, contains the literal request URL.
	 * 
	 */
	@JsonProperty("src")
	public UrlImpl getSrc() {
		return src;
	}

	/**
	 * Url
	 * <p>
	 * If object, contains the complete broken-down URL for this request. If
	 * string, contains the literal request URL.
	 * 
	 */
	@JsonProperty("src")
	public void setSrc(UrlImpl src) {
		this.src = src;
	}

	/**
	 * Script name
	 * 
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * Script name
	 * 
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
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
		sb.append(Script.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("type");
		sb.append('=');
		sb.append(((this.type == null) ? "<null>" : this.type));
		sb.append(',');
		sb.append("exec");
		sb.append('=');
		sb.append(((this.exec == null) ? "<null>" : this.exec));
		sb.append(',');
		sb.append("src");
		sb.append('=');
		sb.append(((this.src == null) ? "<null>" : this.src));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
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
		result = ((result * 31) + ((this.src == null) ? 0 : this.src.hashCode()));
		result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
		result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
		result = ((result * 31) + ((this.exec == null) ? 0 : this.exec.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Script) == false) {
			return false;
		}
		Script rhs = ((Script) other);
		return (((((((this.src == rhs.src) || ((this.src != null) && this.src.equals(rhs.src)))
				&& ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
				&& ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
				&& ((this.exec == rhs.exec) || ((this.exec != null) && this.exec.equals(rhs.exec))));
	}

}
