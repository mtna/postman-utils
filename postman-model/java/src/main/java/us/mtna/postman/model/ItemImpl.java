
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
 * Item
 * <p>
 * Items are entities which contain an actual HTTP request, and sample responses
 * attached to it.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "description", "variable", "event", "request", "response", "_postman_id",
		"protocolProfileBehavior" })
public class ItemImpl implements Item {

	/**
	 * A unique ID that is used to identify collections internally
	 * 
	 */
	@JsonProperty("id")
	@JsonPropertyDescription("A unique ID that is used to identify collections internally")
	private String id;
	/**
	 * A human readable identifier for the current item.
	 * 
	 */
	@JsonProperty("name")
	@JsonPropertyDescription("A human readable identifier for the current item.")
	private String name;
	/**
	 * Description
	 * <p>
	 * A Description can be a raw text, or be an object, which holds the description
	 * along with its format.
	 * 
	 */
	@JsonProperty("description")
	@JsonPropertyDescription("A Description can be a raw text, or be an object, which holds the description along with its format.")
	private Description description;
	/**
	 * Variable List
	 * <p>
	 * Collection variables allow you to define a set of variables, that are a *part
	 * of the collection*, as opposed to environments, which are separate entities.
	 * *Note: Collection variables must not contain any sensitive information.*
	 * 
	 */
	@JsonProperty("variable")
	@JsonPropertyDescription("Collection variables allow you to define a set of variables, that are a *part of the collection*, as opposed to environments, which are separate entities.\n*Note: Collection variables must not contain any sensitive information.*")
	private List<Variable> variable = new ArrayList<Variable>();
	/**
	 * Event List
	 * <p>
	 * Postman allows you to configure scripts to run when specific events occur.
	 * These scripts are stored here, and can be referenced in the collection by
	 * their ID.
	 * 
	 */
	@JsonProperty("event")
	@JsonPropertyDescription("Postman allows you to configure scripts to run when specific events occur. These scripts are stored here, and can be referenced in the collection by their ID.")
	private List<Event> event = new ArrayList<Event>();
	/**
	 * Request
	 * <p>
	 * A request represents an HTTP request. If a string, the string is assumed to
	 * be the request URL and the method is assumed to be 'GET'. (Required)
	 * 
	 */
	@JsonProperty("request")
	@JsonPropertyDescription("A request represents an HTTP request. If a string, the string is assumed to be the request URL and the method is assumed to be 'GET'.")
	private Request request;
	/**
	 * Responses
	 * <p>
	 * 
	 * 
	 */
	@JsonProperty("response")
	private List<Response> response = new ArrayList<Response>();
	@JsonProperty("_postman_id")
	@JsonPropertyDescription("An undocumented postman ID that seems to be treated with more authority than the regular ID in some circumstances (such as published docs)")
	private String postmanId;
	/**
	 * Protocol Profile Behavior
	 * <p>
	 * Set of configurations used to alter the usual behavior of sending the request
	 * 
	 */
	@JsonProperty("protocolProfileBehavior")
	@JsonPropertyDescription("Set of configurations used to alter the usual behavior of sending the request")
	private ProtocolProfileBehavior protocolProfileBehavior;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * A unique ID that is used to identify collections internally
	 * 
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * A unique ID that is used to identify collections internally
	 * 
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * A human readable identifier for the current item.
	 * 
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * A human readable identifier for the current item.
	 * 
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Description
	 * <p>
	 * A Description can be a raw text, or be an object, which holds the description
	 * along with its format.
	 * 
	 */
	@JsonProperty("description")
	public Description getDescription() {
		return description;
	}

	/**
	 * Description
	 * <p>
	 * A Description can be a raw text, or be an object, which holds the description
	 * along with its format.
	 * 
	 */
	@JsonProperty("description")
	public void setDescription(Description description) {
		this.description = description;
	}

	/**
	 * Variable List
	 * <p>
	 * Collection variables allow you to define a set of variables, that are a *part
	 * of the collection*, as opposed to environments, which are separate entities.
	 * *Note: Collection variables must not contain any sensitive information.*
	 * 
	 */
	@JsonProperty("variable")
	public List<Variable> getVariable() {
		return variable;
	}

	/**
	 * Variable List
	 * <p>
	 * Collection variables allow you to define a set of variables, that are a *part
	 * of the collection*, as opposed to environments, which are separate entities.
	 * *Note: Collection variables must not contain any sensitive information.*
	 * 
	 */
	@JsonProperty("variable")
	public void setVariable(List<Variable> variable) {
		this.variable = variable;
	}

	/**
	 * Event List
	 * <p>
	 * Postman allows you to configure scripts to run when specific events occur.
	 * These scripts are stored here, and can be referenced in the collection by
	 * their ID.
	 * 
	 */
	@JsonProperty("event")
	public List<Event> getEvent() {
		return event;
	}

	/**
	 * Event List
	 * <p>
	 * Postman allows you to configure scripts to run when specific events occur.
	 * These scripts are stored here, and can be referenced in the collection by
	 * their ID.
	 * 
	 */
	@JsonProperty("event")
	public void setEvent(List<Event> event) {
		this.event = event;
	}

	/**
	 * Request
	 * <p>
	 * A request represents an HTTP request. If a string, the string is assumed to
	 * be the request URL and the method is assumed to be 'GET'. (Required)
	 * 
	 */
	@JsonProperty("request")
	public Request getRequest() {
		return request;
	}

	/**
	 * Request
	 * <p>
	 * A request represents an HTTP request. If a string, the string is assumed to
	 * be the request URL and the method is assumed to be 'GET'. (Required)
	 * 
	 */
	@JsonProperty("request")
	public void setRequest(Request request) {
		this.request = request;
	}

	/**
	 * Responses
	 * <p>
	 * 
	 * 
	 */
	@JsonProperty("response")
	public List<Response> getResponse() {
		return response;
	}

	/**
	 * Responses
	 * <p>
	 * 
	 * 
	 */
	@JsonProperty("response")
	public void setResponse(List<Response> response) {
		this.response = response;
	}

	@JsonProperty("_postman_id")
	public String getPostmanId() {
		return postmanId;
	}

	@JsonProperty("_postman_id")
	public void setPostmanId(String postmanId) {
		this.postmanId = postmanId;
	}

	/**
	 * Protocol Profile Behavior
	 * <p>
	 * Set of configurations used to alter the usual behavior of sending the request
	 * 
	 */
	@JsonProperty("protocolProfileBehavior")
	public ProtocolProfileBehavior getProtocolProfileBehavior() {
		return protocolProfileBehavior;
	}

	/**
	 * Protocol Profile Behavior
	 * <p>
	 * Set of configurations used to alter the usual behavior of sending the request
	 * 
	 */
	@JsonProperty("protocolProfileBehavior")
	public void setProtocolProfileBehavior(ProtocolProfileBehavior protocolProfileBehavior) {
		this.protocolProfileBehavior = protocolProfileBehavior;
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
		sb.append(ItemImpl.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("description");
		sb.append('=');
		sb.append(((this.description == null) ? "<null>" : this.description));
		sb.append(',');
		sb.append("variable");
		sb.append('=');
		sb.append(((this.variable == null) ? "<null>" : this.variable));
		sb.append(',');
		sb.append("event");
		sb.append('=');
		sb.append(((this.event == null) ? "<null>" : this.event));
		sb.append(',');
		sb.append("request");
		sb.append('=');
		sb.append(((this.request == null) ? "<null>" : this.request));
		sb.append(',');
		sb.append("response");
		sb.append('=');
		sb.append(((this.response == null) ? "<null>" : this.response));
		sb.append(',');
		sb.append("protocolProfileBehavior");
		sb.append('=');
		sb.append(((this.protocolProfileBehavior == null) ? "<null>" : this.protocolProfileBehavior));
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
		result = ((result * 31) + ((this.request == null) ? 0 : this.request.hashCode()));
		result = ((result * 31)
				+ ((this.protocolProfileBehavior == null) ? 0 : this.protocolProfileBehavior.hashCode()));
		result = ((result * 31) + ((this.response == null) ? 0 : this.response.hashCode()));
		result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
		result = ((result * 31) + ((this.variable == null) ? 0 : this.variable.hashCode()));
		result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
		result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.event == null) ? 0 : this.event.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ItemImpl) == false) {
			return false;
		}
		ItemImpl rhs = ((ItemImpl) other);
		return ((((((((((this.request == rhs.request) || ((this.request != null) && this.request.equals(rhs.request)))
				&& ((this.protocolProfileBehavior == rhs.protocolProfileBehavior)
						|| ((this.protocolProfileBehavior != null)
								&& this.protocolProfileBehavior.equals(rhs.protocolProfileBehavior))))
				&& ((this.response == rhs.response) || ((this.response != null) && this.response.equals(rhs.response))))
				&& ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
				&& ((this.variable == rhs.variable) || ((this.variable != null) && this.variable.equals(rhs.variable))))
				&& ((this.description == rhs.description)
						|| ((this.description != null) && this.description.equals(rhs.description))))
				&& ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.event == rhs.event) || ((this.event != null) && this.event.equals(rhs.event))));
	}

}
