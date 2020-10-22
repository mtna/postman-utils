
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
 * Event
 * <p>
 * Defines a script associated with an associated event name
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "listen", "script", "disabled" })
public class Event {

	/**
	 * A unique identifier for the enclosing event.
	 * 
	 */
	@JsonProperty("id")
	@JsonPropertyDescription("A unique identifier for the enclosing event.")
	private String id;
	/**
	 * Can be set to `test` or `prerequest` for test scripts or pre-request
	 * scripts respectively. (Required)
	 * 
	 */
	@JsonProperty("listen")
	@JsonPropertyDescription("Can be set to `test` or `prerequest` for test scripts or pre-request scripts respectively.")
	private String listen;
	/**
	 * Script
	 * <p>
	 * A script is a snippet of Javascript code that can be used to to perform
	 * setup or teardown operations on a particular response.
	 * 
	 */
	@JsonProperty("script")
	@JsonPropertyDescription("A script is a snippet of Javascript code that can be used to to perform setup or teardown operations on a particular response.")
	private Script script;
	/**
	 * Indicates whether the event is disabled. If absent, the event is assumed
	 * to be enabled.
	 * 
	 */
	@JsonProperty("disabled")
	@JsonPropertyDescription("Indicates whether the event is disabled. If absent, the event is assumed to be enabled.")
	private Boolean disabled = false;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * A unique identifier for the enclosing event.
	 * 
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * A unique identifier for the enclosing event.
	 * 
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Can be set to `test` or `prerequest` for test scripts or pre-request
	 * scripts respectively. (Required)
	 * 
	 */
	@JsonProperty("listen")
	public String getListen() {
		return listen;
	}

	/**
	 * Can be set to `test` or `prerequest` for test scripts or pre-request
	 * scripts respectively. (Required)
	 * 
	 */
	@JsonProperty("listen")
	public void setListen(String listen) {
		this.listen = listen;
	}

	/**
	 * Script
	 * <p>
	 * A script is a snippet of Javascript code that can be used to to perform
	 * setup or teardown operations on a particular response.
	 * 
	 */
	@JsonProperty("script")
	public Script getScript() {
		return script;
	}

	/**
	 * Script
	 * <p>
	 * A script is a snippet of Javascript code that can be used to to perform
	 * setup or teardown operations on a particular response.
	 * 
	 */
	@JsonProperty("script")
	public void setScript(Script script) {
		this.script = script;
	}

	/**
	 * Indicates whether the event is disabled. If absent, the event is assumed
	 * to be enabled.
	 * 
	 */
	@JsonProperty("disabled")
	public Boolean getDisabled() {
		return disabled;
	}

	/**
	 * Indicates whether the event is disabled. If absent, the event is assumed
	 * to be enabled.
	 * 
	 */
	@JsonProperty("disabled")
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
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
		sb.append(Event.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("listen");
		sb.append('=');
		sb.append(((this.listen == null) ? "<null>" : this.listen));
		sb.append(',');
		sb.append("script");
		sb.append('=');
		sb.append(((this.script == null) ? "<null>" : this.script));
		sb.append(',');
		sb.append("disabled");
		sb.append('=');
		sb.append(((this.disabled == null) ? "<null>" : this.disabled));
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
		result = ((result * 31) + ((this.disabled == null) ? 0 : this.disabled.hashCode()));
		result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.listen == null) ? 0 : this.listen.hashCode()));
		result = ((result * 31) + ((this.script == null) ? 0 : this.script.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Event) == false) {
			return false;
		}
		Event rhs = ((Event) other);
		return ((((((this.disabled == rhs.disabled) || ((this.disabled != null) && this.disabled.equals(rhs.disabled)))
				&& ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.listen == rhs.listen) || ((this.listen != null) && this.listen.equals(rhs.listen))))
				&& ((this.script == rhs.script) || ((this.script != null) && this.script.equals(rhs.script))));
	}

}
