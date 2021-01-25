
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
 * Response
 * <p>
 * A response represents an HTTP response.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "originalRequest", "responseTime", "timings", "_postman_previewlanguage", "header", "cookie", "body", "status",
		"code" })
public class Response {

	/**
	 * A unique, user defined identifier that can be used to refer to this response
	 * from requests.
	 * 
	 */
	@JsonProperty("id")
	@JsonPropertyDescription("A unique, user defined identifier that can  be used to refer to this response from requests.")
	private String id;
	/**
	 * Request
	 * <p>
	 * A request represents an HTTP request. If a string, the string is assumed to
	 * be the request URL and the method is assumed to be 'GET'.
	 * 
	 */
	@JsonProperty("originalRequest")
	@JsonPropertyDescription("A request represents an HTTP request. If a string, the string is assumed to be the request URL and the method is assumed to be 'GET'.")
	private Request originalRequest;
	/**
	 * ResponseTime
	 * <p>
	 * The time taken by the request to complete. If a number, the unit is
	 * milliseconds. If the response is manually created, this can be set to `null`.
	 * 
	 */
	@JsonProperty("responseTime")
	@JsonPropertyDescription("The time taken by the request to complete. If a number, the unit is milliseconds. If the response is manually created, this can be set to `null`.")
	private String responseTime;
	/**
	 * Response Timings
	 * <p>
	 * Set of timing information related to request and response in milliseconds
	 * 
	 */
	@JsonProperty("timings")
	@JsonPropertyDescription("Set of timing information related to request and response in milliseconds")
	private Timings timings;
	
	/**
	 * This was not in the schema. 
	 */
	@JsonProperty("_postman_previewlanguage")
	@JsonPropertyDescription("The language the saved example response will be displayed in.")
	private String postmanPreviewLanguage;
	
	/**
	 * Headers
	 * <p>
	 * No HTTP request is complete without its headers, and the same is true for a
	 * Postman request. This field is an array containing all the headers.
	 * 
	 */
	@JsonProperty("header")
	@JsonPropertyDescription("No HTTP request is complete without its headers, and the same is true for a Postman request. This field is an array containing all the headers.")
	private List<Header> header = new ArrayList<Header>();
	@JsonProperty("cookie")
	private List<Cookie> cookie = new ArrayList<Cookie>();
	/**
	 * The raw text of the response.
	 * 
	 */
	@JsonProperty("body")
	@JsonPropertyDescription("The raw text of the response.")
	private String body;
	/**
	 * The response status, e.g: '200 OK'
	 * 
	 */
	@JsonProperty("status")
	@JsonPropertyDescription("The response status, e.g: '200 OK'")
	private String status;
	/**
	 * The response status, e.g: '200 OK'
	 * 
	 */
	@JsonProperty("name")
	@JsonPropertyDescription("The response name")
	private String name;
	/**
	 * The numerical response code, example: 200, 201, 404, etc.
	 * 
	 */
	@JsonProperty("code")
	@JsonPropertyDescription("The numerical response code, example: 200, 201, 404, etc.")
	private Integer code;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * A unique, user defined identifier that can be used to refer to this response
	 * from requests.
	 * 
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * A unique, user defined identifier that can be used to refer to this response
	 * from requests.
	 * 
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Request
	 * <p>
	 * A request represents an HTTP request. If a string, the string is assumed to
	 * be the request URL and the method is assumed to be 'GET'.
	 * 
	 */
	@JsonProperty("originalRequest")
	public Request getOriginalRequest() {
		return originalRequest;
	}

	/**
	 * Request
	 * <p>
	 * A request represents an HTTP request. If a string, the string is assumed to
	 * be the request URL and the method is assumed to be 'GET'.
	 * 
	 */
	@JsonProperty("originalRequest")
	public void setOriginalRequest(Request originalRequest) {
		this.originalRequest = originalRequest;
	}

	/**
	 * ResponseTime
	 * <p>
	 * The time taken by the request to complete. If a number, the unit is
	 * milliseconds. If the response is manually created, this can be set to `null`.
	 * 
	 */
	@JsonProperty("responseTime")
	public String getResponseTime() {
		return responseTime;
	}

	/**
	 * ResponseTime
	 * <p>
	 * The time taken by the request to complete. If a number, the unit is
	 * milliseconds. If the response is manually created, this can be set to `null`.
	 * 
	 */
	@JsonProperty("responseTime")
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * Response Timings
	 * <p>
	 * Set of timing information related to request and response in milliseconds
	 * 
	 */
	@JsonProperty("timings")
	public Timings getTimings() {
		return timings;
	}

	/**
	 * Response Timings
	 * <p>
	 * Set of timing information related to request and response in milliseconds
	 * 
	 */
	@JsonProperty("timings")
	public void setTimings(Timings timings) {
		this.timings = timings;
	}

	@JsonProperty("_postman_previewlanguage")
	public String getPostmanPreviewLanguage() {
		return postmanPreviewLanguage;
	}
	
	@JsonProperty("_postman_previewlanguage")
	public void setPostmanPreviewLanguage(String postmanPreviewLanguage) {
		this.postmanPreviewLanguage = postmanPreviewLanguage;
	}
	
	/**
	 * Headers
	 * <p>
	 * No HTTP request is complete without its headers, and the same is true for a
	 * Postman request. This field is an array containing all the headers.
	 * 
	 */
	@JsonProperty("header")
	public List<Header> getHeader() {
		return header;
	}

	/**
	 * Headers
	 * <p>
	 * No HTTP request is complete without its headers, and the same is true for a
	 * Postman request. This field is an array containing all the headers.
	 * 
	 */
	@JsonProperty("header")
	public void setHeader(List<Header> header) {
		this.header = header;
	}

	@JsonProperty("cookie")
	public List<Cookie> getCookie() {
		return cookie;
	}

	@JsonProperty("cookie")
	public void setCookie(List<Cookie> cookie) {
		this.cookie = cookie;
	}

	/**
	 * The raw text of the response.
	 * 
	 */
	@JsonProperty("body")
	public String getBody() {
		return body;
	}

	/**
	 * The raw text of the response.
	 * 
	 */
	@JsonProperty("body")
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * The response status, e.g: '200 OK'
	 * 
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * The response status, e.g: '200 OK'
	 * 
	 */
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The numerical response code, example: 200, 201, 404, etc.
	 * 
	 */
	@JsonProperty("code")
	public Integer getCode() {
		return code;
	}

	/**
	 * The numerical response code, example: 200, 201, 404, etc.
	 * 
	 */
	@JsonProperty("code")
	public void setCode(Integer code) {
		this.code = code;
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
		sb.append(Response.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("originalRequest");
		sb.append('=');
		sb.append(((this.originalRequest == null) ? "<null>" : this.originalRequest));
		sb.append(',');
		sb.append("responseTime");
		sb.append('=');
		sb.append(((this.responseTime == null) ? "<null>" : this.responseTime));
		sb.append(',');
		sb.append("timings");
		sb.append('=');
		sb.append(((this.timings == null) ? "<null>" : this.timings));
		sb.append(',');
		sb.append("header");
		sb.append('=');
		sb.append(((this.header == null) ? "<null>" : this.header));
		sb.append(',');
		sb.append("cookie");
		sb.append('=');
		sb.append(((this.cookie == null) ? "<null>" : this.cookie));
		sb.append(',');
		sb.append("body");
		sb.append('=');
		sb.append(((this.body == null) ? "<null>" : this.body));
		sb.append(',');
		sb.append("status");
		sb.append('=');
		sb.append(((this.status == null) ? "<null>" : this.status));
		sb.append(',');
		sb.append("code");
		sb.append('=');
		sb.append(((this.code == null) ? "<null>" : this.code));
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
		result = ((result * 31) + ((this.originalRequest == null) ? 0 : this.originalRequest.hashCode()));
		result = ((result * 31) + ((this.code == null) ? 0 : this.code.hashCode()));
		result = ((result * 31) + ((this.cookie == null) ? 0 : this.cookie.hashCode()));
		result = ((result * 31) + ((this.responseTime == null) ? 0 : this.responseTime.hashCode()));
		result = ((result * 31) + ((this.timings == null) ? 0 : this.timings.hashCode()));
		result = ((result * 31) + ((this.header == null) ? 0 : this.header.hashCode()));
		result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.body == null) ? 0 : this.body.hashCode()));
		result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Response) == false) {
			return false;
		}
		Response rhs = ((Response) other);
		return (((((((((((this.originalRequest == rhs.originalRequest)
				|| ((this.originalRequest != null) && this.originalRequest.equals(rhs.originalRequest)))
				&& ((this.code == rhs.code) || ((this.code != null) && this.code.equals(rhs.code))))
				&& ((this.cookie == rhs.cookie) || ((this.cookie != null) && this.cookie.equals(rhs.cookie))))
				&& ((this.responseTime == rhs.responseTime)
						|| ((this.responseTime != null) && this.responseTime.equals(rhs.responseTime))))
				&& ((this.timings == rhs.timings) || ((this.timings != null) && this.timings.equals(rhs.timings))))
				&& ((this.header == rhs.header) || ((this.header != null) && this.header.equals(rhs.header))))
				&& ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.body == rhs.body) || ((this.body != null) && this.body.equals(rhs.body))))
				&& ((this.status == rhs.status) || ((this.status != null) && this.status.equals(rhs.status))));
	}

}
