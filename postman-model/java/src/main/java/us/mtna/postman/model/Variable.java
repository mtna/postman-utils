
package us.mtna.postman.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Variable
 * <p>
 * Using variables in your Postman requests eliminates the need to duplicate
 * requests, which can save a lot of time. Variables can be defined, and
 * referenced to from any part of a request.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "key", "value", "type", "name", "description", "system", "disabled" })
public class Variable {

	/**
	 * A variable ID is a unique user-defined value that identifies the variable
	 * within a collection. In traditional terms, this would be a variable name.
	 * (Required)
	 * 
	 */
	@JsonProperty("id")
	@JsonPropertyDescription("A variable ID is a unique user-defined value that identifies the variable within a collection. In traditional terms, this would be a variable name.")
	private String id;
	/**
	 * A variable key is a human friendly value that identifies the variable
	 * within a collection. In traditional terms, this would be a variable name.
	 * (Required)
	 * 
	 */
	@JsonProperty("key")
	@JsonPropertyDescription("A variable key is a human friendly value that identifies the variable within a collection. In traditional terms, this would be a variable name.")
	private String key;
	/**
	 * The value that a variable holds in this collection. Ultimately, the
	 * variables will be replaced by this value, when say running a set of
	 * requests from a collection
	 * 
	 */
	@JsonProperty("value")
	@JsonPropertyDescription("The value that a variable holds in this collection. Ultimately, the variables will be replaced by this value, when say running a set of requests from a collection")
	private Object value;
	/**
	 * A variable may have multiple types. This field specifies the type of the
	 * variable.
	 * 
	 */
	@JsonProperty("type")
	@JsonPropertyDescription("A variable may have multiple types. This field specifies the type of the variable.")
	private Variable.Type type;
	/**
	 * Variable name
	 * 
	 */
	@JsonProperty("name")
	@JsonPropertyDescription("Variable name")
	private String name;
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
	 * When set to true, indicates that this variable has been set by Postman
	 * 
	 */
	@JsonProperty("system")
	@JsonPropertyDescription("When set to true, indicates that this variable has been set by Postman")
	private Boolean system = false;
	@JsonProperty("disabled")
	private Boolean disabled = false;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * A variable ID is a unique user-defined value that identifies the variable
	 * within a collection. In traditional terms, this would be a variable name.
	 * (Required)
	 * 
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * A variable ID is a unique user-defined value that identifies the variable
	 * within a collection. In traditional terms, this would be a variable name.
	 * (Required)
	 * 
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * A variable key is a human friendly value that identifies the variable
	 * within a collection. In traditional terms, this would be a variable name.
	 * (Required)
	 * 
	 */
	@JsonProperty("key")
	public String getKey() {
		return key;
	}

	/**
	 * A variable key is a human friendly value that identifies the variable
	 * within a collection. In traditional terms, this would be a variable name.
	 * (Required)
	 * 
	 */
	@JsonProperty("key")
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * The value that a variable holds in this collection. Ultimately, the
	 * variables will be replaced by this value, when say running a set of
	 * requests from a collection
	 * 
	 */
	@JsonProperty("value")
	public Object getValue() {
		return value;
	}

	/**
	 * The value that a variable holds in this collection. Ultimately, the
	 * variables will be replaced by this value, when say running a set of
	 * requests from a collection
	 * 
	 */
	@JsonProperty("value")
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * A variable may have multiple types. This field specifies the type of the
	 * variable.
	 * 
	 */
	@JsonProperty("type")
	public Variable.Type getType() {
		return type;
	}

	/**
	 * A variable may have multiple types. This field specifies the type of the
	 * variable.
	 * 
	 */
	@JsonProperty("type")
	public void setType(Variable.Type type) {
		this.type = type;
	}

	/**
	 * Variable name
	 * 
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * Variable name
	 * 
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
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
	 * When set to true, indicates that this variable has been set by Postman
	 * 
	 */
	@JsonProperty("system")
	public Boolean getSystem() {
		return system;
	}

	/**
	 * When set to true, indicates that this variable has been set by Postman
	 * 
	 */
	@JsonProperty("system")
	public void setSystem(Boolean system) {
		this.system = system;
	}

	@JsonProperty("disabled")
	public Boolean getDisabled() {
		return disabled;
	}

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
		sb.append(Variable.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("key");
		sb.append('=');
		sb.append(((this.key == null) ? "<null>" : this.key));
		sb.append(',');
		sb.append("value");
		sb.append('=');
		sb.append(((this.value == null) ? "<null>" : this.value));
		sb.append(',');
		sb.append("type");
		sb.append('=');
		sb.append(((this.type == null) ? "<null>" : this.type));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("description");
		sb.append('=');
		sb.append(((this.description == null) ? "<null>" : this.description));
		sb.append(',');
		sb.append("system");
		sb.append('=');
		sb.append(((this.system == null) ? "<null>" : this.system));
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
		result = ((result * 31) + ((this.system == null) ? 0 : this.system.hashCode()));
		result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
		result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
		result = ((result * 31) + ((this.disabled == null) ? 0 : this.disabled.hashCode()));
		result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
		result = ((result * 31) + ((this.value == null) ? 0 : this.value.hashCode()));
		result = ((result * 31) + ((this.key == null) ? 0 : this.key.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Variable) == false) {
			return false;
		}
		Variable rhs = ((Variable) other);
		return ((((((((((this.system == rhs.system) || ((this.system != null) && this.system.equals(rhs.system)))
				&& ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
				&& ((this.description == rhs.description)
						|| ((this.description != null) && this.description.equals(rhs.description))))
				&& ((this.disabled == rhs.disabled) || ((this.disabled != null) && this.disabled.equals(rhs.disabled))))
				&& ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
				&& ((this.value == rhs.value) || ((this.value != null) && this.value.equals(rhs.value))))
				&& ((this.key == rhs.key) || ((this.key != null) && this.key.equals(rhs.key))));
	}

	/**
	 * A variable may have multiple types. This field specifies the type of the
	 * variable.
	 * 
	 */
	public enum Type {

		STRING("string"), BOOLEAN("boolean"), ANY("any"), NUMBER("number");

		private final String value;
		private final static Map<String, Variable.Type> CONSTANTS = new HashMap<String, Variable.Type>();

		static {
			for (Variable.Type c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private Type(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}

		@JsonValue
		public String value() {
			return this.value;
		}

		@JsonCreator
		public static Variable.Type fromValue(String value) {
			Variable.Type constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
