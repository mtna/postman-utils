
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
 * Cookie
 * <p>
 * A Cookie, that follows the [Google Chrome
 * format](https://developer.chrome.com/extensions/cookies)
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "domain", "expires", "maxAge", "hostOnly", "httpOnly", "name", "path", "secure", "session",
		"value", "extensions" })
public class Cookie {

	/**
	 * The domain for which this cookie is valid. (Required)
	 * 
	 */
	@JsonProperty("domain")
	@JsonPropertyDescription("The domain for which this cookie is valid.")
	private String domain;
	/**
	 * When the cookie expires.
	 * 
	 */
	@JsonProperty("expires")
	@JsonPropertyDescription("When the cookie expires.")
	private String expires;
	@JsonProperty("maxAge")
	private String maxAge;
	/**
	 * True if the cookie is a host-only cookie. (i.e. a request's URL domain
	 * must exactly match the domain of the cookie).
	 * 
	 */
	@JsonProperty("hostOnly")
	@JsonPropertyDescription("True if the cookie is a host-only cookie. (i.e. a request's URL domain must exactly match the domain of the cookie).")
	private Boolean hostOnly;
	/**
	 * Indicates if this cookie is HTTP Only. (if True, the cookie is
	 * inaccessible to client-side scripts)
	 * 
	 */
	@JsonProperty("httpOnly")
	@JsonPropertyDescription("Indicates if this cookie is HTTP Only. (if True, the cookie is inaccessible to client-side scripts)")
	private Boolean httpOnly;
	/**
	 * This is the name of the Cookie.
	 * 
	 */
	@JsonProperty("name")
	@JsonPropertyDescription("This is the name of the Cookie.")
	private String name;
	/**
	 * The path associated with the Cookie. (Required)
	 * 
	 */
	@JsonProperty("path")
	@JsonPropertyDescription("The path associated with the Cookie.")
	private String path;
	/**
	 * Indicates if the 'secure' flag is set on the Cookie, meaning that it is
	 * transmitted over secure connections only. (typically HTTPS)
	 * 
	 */
	@JsonProperty("secure")
	@JsonPropertyDescription("Indicates if the 'secure' flag is set on the Cookie, meaning that it is transmitted over secure connections only. (typically HTTPS)")
	private Boolean secure;
	/**
	 * True if the cookie is a session cookie.
	 * 
	 */
	@JsonProperty("session")
	@JsonPropertyDescription("True if the cookie is a session cookie.")
	private Boolean session;
	/**
	 * The value of the Cookie.
	 * 
	 */
	@JsonProperty("value")
	@JsonPropertyDescription("The value of the Cookie.")
	private String value;
	/**
	 * Custom attributes for a cookie go here, such as the [Priority
	 * Field](https://code.google.com/p/chromium/issues/detail?id=232693)
	 * 
	 */
	@JsonProperty("extensions")
	@JsonPropertyDescription("Custom attributes for a cookie go here, such as the [Priority Field](https://code.google.com/p/chromium/issues/detail?id=232693)")
	private List<Object> extensions = new ArrayList<Object>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * The domain for which this cookie is valid. (Required)
	 * 
	 */
	@JsonProperty("domain")
	public String getDomain() {
		return domain;
	}

	/**
	 * The domain for which this cookie is valid. (Required)
	 * 
	 */
	@JsonProperty("domain")
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * When the cookie expires.
	 * 
	 */
	@JsonProperty("expires")
	public String getExpires() {
		return expires;
	}

	/**
	 * When the cookie expires.
	 * 
	 */
	@JsonProperty("expires")
	public void setExpires(String expires) {
		this.expires = expires;
	}

	@JsonProperty("maxAge")
	public String getMaxAge() {
		return maxAge;
	}

	@JsonProperty("maxAge")
	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	/**
	 * True if the cookie is a host-only cookie. (i.e. a request's URL domain
	 * must exactly match the domain of the cookie).
	 * 
	 */
	@JsonProperty("hostOnly")
	public Boolean getHostOnly() {
		return hostOnly;
	}

	/**
	 * True if the cookie is a host-only cookie. (i.e. a request's URL domain
	 * must exactly match the domain of the cookie).
	 * 
	 */
	@JsonProperty("hostOnly")
	public void setHostOnly(Boolean hostOnly) {
		this.hostOnly = hostOnly;
	}

	/**
	 * Indicates if this cookie is HTTP Only. (if True, the cookie is
	 * inaccessible to client-side scripts)
	 * 
	 */
	@JsonProperty("httpOnly")
	public Boolean getHttpOnly() {
		return httpOnly;
	}

	/**
	 * Indicates if this cookie is HTTP Only. (if True, the cookie is
	 * inaccessible to client-side scripts)
	 * 
	 */
	@JsonProperty("httpOnly")
	public void setHttpOnly(Boolean httpOnly) {
		this.httpOnly = httpOnly;
	}

	/**
	 * This is the name of the Cookie.
	 * 
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * This is the name of the Cookie.
	 * 
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The path associated with the Cookie. (Required)
	 * 
	 */
	@JsonProperty("path")
	public String getPath() {
		return path;
	}

	/**
	 * The path associated with the Cookie. (Required)
	 * 
	 */
	@JsonProperty("path")
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Indicates if the 'secure' flag is set on the Cookie, meaning that it is
	 * transmitted over secure connections only. (typically HTTPS)
	 * 
	 */
	@JsonProperty("secure")
	public Boolean getSecure() {
		return secure;
	}

	/**
	 * Indicates if the 'secure' flag is set on the Cookie, meaning that it is
	 * transmitted over secure connections only. (typically HTTPS)
	 * 
	 */
	@JsonProperty("secure")
	public void setSecure(Boolean secure) {
		this.secure = secure;
	}

	/**
	 * True if the cookie is a session cookie.
	 * 
	 */
	@JsonProperty("session")
	public Boolean getSession() {
		return session;
	}

	/**
	 * True if the cookie is a session cookie.
	 * 
	 */
	@JsonProperty("session")
	public void setSession(Boolean session) {
		this.session = session;
	}

	/**
	 * The value of the Cookie.
	 * 
	 */
	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	/**
	 * The value of the Cookie.
	 * 
	 */
	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Custom attributes for a cookie go here, such as the [Priority
	 * Field](https://code.google.com/p/chromium/issues/detail?id=232693)
	 * 
	 */
	@JsonProperty("extensions")
	public List<Object> getExtensions() {
		return extensions;
	}

	/**
	 * Custom attributes for a cookie go here, such as the [Priority
	 * Field](https://code.google.com/p/chromium/issues/detail?id=232693)
	 * 
	 */
	@JsonProperty("extensions")
	public void setExtensions(List<Object> extensions) {
		this.extensions = extensions;
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
		sb.append(Cookie.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("domain");
		sb.append('=');
		sb.append(((this.domain == null) ? "<null>" : this.domain));
		sb.append(',');
		sb.append("expires");
		sb.append('=');
		sb.append(((this.expires == null) ? "<null>" : this.expires));
		sb.append(',');
		sb.append("maxAge");
		sb.append('=');
		sb.append(((this.maxAge == null) ? "<null>" : this.maxAge));
		sb.append(',');
		sb.append("hostOnly");
		sb.append('=');
		sb.append(((this.hostOnly == null) ? "<null>" : this.hostOnly));
		sb.append(',');
		sb.append("httpOnly");
		sb.append('=');
		sb.append(((this.httpOnly == null) ? "<null>" : this.httpOnly));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("path");
		sb.append('=');
		sb.append(((this.path == null) ? "<null>" : this.path));
		sb.append(',');
		sb.append("secure");
		sb.append('=');
		sb.append(((this.secure == null) ? "<null>" : this.secure));
		sb.append(',');
		sb.append("session");
		sb.append('=');
		sb.append(((this.session == null) ? "<null>" : this.session));
		sb.append(',');
		sb.append("value");
		sb.append('=');
		sb.append(((this.value == null) ? "<null>" : this.value));
		sb.append(',');
		sb.append("extensions");
		sb.append('=');
		sb.append(((this.extensions == null) ? "<null>" : this.extensions));
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
		result = ((result * 31) + ((this.expires == null) ? 0 : this.expires.hashCode()));
		result = ((result * 31) + ((this.session == null) ? 0 : this.session.hashCode()));
		result = ((result * 31) + ((this.hostOnly == null) ? 0 : this.hostOnly.hashCode()));
		result = ((result * 31) + ((this.secure == null) ? 0 : this.secure.hashCode()));
		result = ((result * 31) + ((this.path == null) ? 0 : this.path.hashCode()));
		result = ((result * 31) + ((this.extensions == null) ? 0 : this.extensions.hashCode()));
		result = ((result * 31) + ((this.maxAge == null) ? 0 : this.maxAge.hashCode()));
		result = ((result * 31) + ((this.domain == null) ? 0 : this.domain.hashCode()));
		result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
		result = ((result * 31) + ((this.httpOnly == null) ? 0 : this.httpOnly.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.value == null) ? 0 : this.value.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Cookie) == false) {
			return false;
		}
		Cookie rhs = ((Cookie) other);
		return (((((((((((((this.expires == rhs.expires)
				|| ((this.expires != null) && this.expires.equals(rhs.expires)))
				&& ((this.session == rhs.session) || ((this.session != null) && this.session.equals(rhs.session))))
				&& ((this.hostOnly == rhs.hostOnly) || ((this.hostOnly != null) && this.hostOnly.equals(rhs.hostOnly))))
				&& ((this.secure == rhs.secure) || ((this.secure != null) && this.secure.equals(rhs.secure))))
				&& ((this.path == rhs.path) || ((this.path != null) && this.path.equals(rhs.path))))
				&& ((this.extensions == rhs.extensions)
						|| ((this.extensions != null) && this.extensions.equals(rhs.extensions))))
				&& ((this.maxAge == rhs.maxAge) || ((this.maxAge != null) && this.maxAge.equals(rhs.maxAge))))
				&& ((this.domain == rhs.domain) || ((this.domain != null) && this.domain.equals(rhs.domain))))
				&& ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
				&& ((this.httpOnly == rhs.httpOnly) || ((this.httpOnly != null) && this.httpOnly.equals(rhs.httpOnly))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.value == rhs.value) || ((this.value != null) && this.value.equals(rhs.value))));
	}

}
