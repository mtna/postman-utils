
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
 * Url
 * <p>
 * If object, contains the complete broken-down URL for this request. If string,
 * contains the literal request URL.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "raw", "protocol", "host", "path", "port", "query", "hash", "variable" })
public class UrlImpl implements Url {

	/**
	 * The string representation of the request URL, including the protocol,
	 * host, path, hash, query parameter(s) and path variable(s).
	 * 
	 */
	@JsonProperty("raw")
	@JsonPropertyDescription("The string representation of the request URL, including the protocol, host, path, hash, query parameter(s) and path variable(s).")
	private String raw;
	/**
	 * The protocol associated with the request, E.g: 'http'
	 * 
	 */
	@JsonProperty("protocol")
	@JsonPropertyDescription("The protocol associated with the request, E.g: 'http'")
	private String protocol;
	/**
	 * Host
	 * <p>
	 * The host for the URL, E.g: api.yourdomain.com. Can be stored as a string
	 * or as an array of strings.
	 * 
	 */
	@JsonProperty("host")
	@JsonPropertyDescription("The host for the URL, E.g: api.yourdomain.com. Can be stored as a string or as an array of strings.")
	private Host host;

	@JsonProperty("path")
	private Path path;
	/**
	 * The port number present in this URL. An empty value implies 80/443
	 * depending on whether the protocol field contains http/https.
	 * 
	 */
	@JsonProperty("port")
	@JsonPropertyDescription("The port number present in this URL. An empty value implies 80/443 depending on whether the protocol field contains http/https.")
	private String port;
	/**
	 * An array of QueryParams, which is basically the query string part of the
	 * URL, parsed into separate variables
	 * 
	 */
	@JsonProperty("query")
	@JsonPropertyDescription("An array of QueryParams, which is basically the query string part of the URL, parsed into separate variables")
	private List<Query> query = new ArrayList<Query>();
	/**
	 * Contains the URL fragment (if any). Usually this is not transmitted over
	 * the network, but it could be useful to store this in some cases.
	 * 
	 */
	@JsonProperty("hash")
	@JsonPropertyDescription("Contains the URL fragment (if any). Usually this is not transmitted over the network, but it could be useful to store this in some cases.")
	private String hash;
	/**
	 * Postman supports path variables with the syntax
	 * `/path/:variableName/to/somewhere`. These variables are stored in this
	 * field.
	 * 
	 */
	@JsonProperty("variable")
	@JsonPropertyDescription("Postman supports path variables with the syntax `/path/:variableName/to/somewhere`. These variables are stored in this field.")
	private List<Variable> variable = new ArrayList<Variable>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * The string representation of the request URL, including the protocol,
	 * host, path, hash, query parameter(s) and path variable(s).
	 * 
	 */
	@JsonProperty("raw")
	public String getRaw() {
		return raw;
	}

	/**
	 * The string representation of the request URL, including the protocol,
	 * host, path, hash, query parameter(s) and path variable(s).
	 * 
	 */
	@JsonProperty("raw")
	public void setRaw(String raw) {
		this.raw = raw;
	}

	/**
	 * The protocol associated with the request, E.g: 'http'
	 * 
	 */
	@JsonProperty("protocol")
	public String getProtocol() {
		return protocol;
	}

	/**
	 * The protocol associated with the request, E.g: 'http'
	 * 
	 */
	@JsonProperty("protocol")
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * Host
	 * <p>
	 * The host for the URL, E.g: api.yourdomain.com. Can be stored as a string
	 * or as an array of strings.
	 * 
	 */
	@JsonProperty("host")
	public Host getHost() {
		return host;
	}

	/**
	 * Host
	 * <p>
	 * The host for the URL, E.g: api.yourdomain.com. Can be stored as a string
	 * or as an array of strings.
	 * 
	 */
	@JsonProperty("host")
	public void setHost(Host host) {
		this.host = host;
	}

	@JsonProperty("path")
	public Path getPath() {
		return path;
	}

	@JsonProperty("path")
	public void setPath(Path path) {
		this.path = path;
	}

	/**
	 * The port number present in this URL. An empty value implies 80/443
	 * depending on whether the protocol field contains http/https.
	 * 
	 */
	@JsonProperty("port")
	public String getPort() {
		return port;
	}

	/**
	 * The port number present in this URL. An empty value implies 80/443
	 * depending on whether the protocol field contains http/https.
	 * 
	 */
	@JsonProperty("port")
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * An array of QueryParams, which is basically the query string part of the
	 * URL, parsed into separate variables
	 * 
	 */
	@JsonProperty("query")
	public List<Query> getQuery() {
		return query;
	}

	/**
	 * An array of QueryParams, which is basically the query string part of the
	 * URL, parsed into separate variables
	 * 
	 */
	@JsonProperty("query")
	public void setQuery(List<Query> query) {
		this.query = query;
	}

	/**
	 * Contains the URL fragment (if any). Usually this is not transmitted over
	 * the network, but it could be useful to store this in some cases.
	 * 
	 */
	@JsonProperty("hash")
	public String getHash() {
		return hash;
	}

	/**
	 * Contains the URL fragment (if any). Usually this is not transmitted over
	 * the network, but it could be useful to store this in some cases.
	 * 
	 */
	@JsonProperty("hash")
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * Postman supports path variables with the syntax
	 * `/path/:variableName/to/somewhere`. These variables are stored in this
	 * field.
	 * 
	 */
	@JsonProperty("variable")
	public List<Variable> getVariable() {
		return variable;
	}

	/**
	 * Postman supports path variables with the syntax
	 * `/path/:variableName/to/somewhere`. These variables are stored in this
	 * field.
	 * 
	 */
	@JsonProperty("variable")
	public void setVariable(List<Variable> variable) {
		this.variable = variable;
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
		sb.append(UrlImpl.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("raw");
		sb.append('=');
		sb.append(((this.raw == null) ? "<null>" : this.raw));
		sb.append(',');
		sb.append("protocol");
		sb.append('=');
		sb.append(((this.protocol == null) ? "<null>" : this.protocol));
		sb.append(',');
		sb.append("host");
		sb.append('=');
		sb.append(((this.host == null) ? "<null>" : this.host));
		sb.append(',');
		sb.append("path");
		sb.append('=');
		sb.append(((this.path == null) ? "<null>" : this.path));
		sb.append(',');
		sb.append("port");
		sb.append('=');
		sb.append(((this.port == null) ? "<null>" : this.port));
		sb.append(',');
		sb.append("query");
		sb.append('=');
		sb.append(((this.query == null) ? "<null>" : this.query));
		sb.append(',');
		sb.append("hash");
		sb.append('=');
		sb.append(((this.hash == null) ? "<null>" : this.hash));
		sb.append(',');
		sb.append("variable");
		sb.append('=');
		sb.append(((this.variable == null) ? "<null>" : this.variable));
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
		result = ((result * 31) + ((this.path == null) ? 0 : this.path.hashCode()));
		result = ((result * 31) + ((this.protocol == null) ? 0 : this.protocol.hashCode()));
		result = ((result * 31) + ((this.port == null) ? 0 : this.port.hashCode()));
		result = ((result * 31) + ((this.query == null) ? 0 : this.query.hashCode()));
		result = ((result * 31) + ((this.host == null) ? 0 : this.host.hashCode()));
		result = ((result * 31) + ((this.variable == null) ? 0 : this.variable.hashCode()));
		result = ((result * 31) + ((this.raw == null) ? 0 : this.raw.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.hash == null) ? 0 : this.hash.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof UrlImpl) == false) {
			return false;
		}
		UrlImpl rhs = ((UrlImpl) other);
		return ((((((((((this.path == rhs.path) || ((this.path != null) && this.path.equals(rhs.path)))
				&& ((this.protocol == rhs.protocol) || ((this.protocol != null) && this.protocol.equals(rhs.protocol))))
				&& ((this.port == rhs.port) || ((this.port != null) && this.port.equals(rhs.port))))
				&& ((this.query == rhs.query) || ((this.query != null) && this.query.equals(rhs.query))))
				&& ((this.host == rhs.host) || ((this.host != null) && this.host.equals(rhs.host))))
				&& ((this.variable == rhs.variable) || ((this.variable != null) && this.variable.equals(rhs.variable))))
				&& ((this.raw == rhs.raw) || ((this.raw != null) && this.raw.equals(rhs.raw))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.hash == rhs.hash) || ((this.hash != null) && this.hash.equals(rhs.hash))));
	}

}
