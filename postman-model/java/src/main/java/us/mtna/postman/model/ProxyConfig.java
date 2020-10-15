
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
 * Proxy Config
 * <p>
 * Using the Proxy, you can configure your custom proxy into the postman for
 * particular url match
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "match", "host", "port", "tunnel", "disabled" })
public class ProxyConfig {

	/**
	 * The Url match for which the proxy config is defined
	 * 
	 */
	@JsonProperty("match")
	@JsonPropertyDescription("The Url match for which the proxy config is defined")
	private String match = "http+https://*/*";
	/**
	 * The proxy server host
	 * 
	 */
	@JsonProperty("host")
	@JsonPropertyDescription("The proxy server host")
	private String host;
	/**
	 * The proxy server port
	 * 
	 */
	@JsonProperty("port")
	@JsonPropertyDescription("The proxy server port")
	private Integer port = 8080;
	/**
	 * The tunneling details for the proxy config
	 * 
	 */
	@JsonProperty("tunnel")
	@JsonPropertyDescription("The tunneling details for the proxy config")
	private Boolean tunnel = false;
	/**
	 * When set to true, ignores this proxy configuration entity
	 * 
	 */
	@JsonProperty("disabled")
	@JsonPropertyDescription("When set to true, ignores this proxy configuration entity")
	private Boolean disabled = false;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * The Url match for which the proxy config is defined
	 * 
	 */
	@JsonProperty("match")
	public String getMatch() {
		return match;
	}

	/**
	 * The Url match for which the proxy config is defined
	 * 
	 */
	@JsonProperty("match")
	public void setMatch(String match) {
		this.match = match;
	}

	/**
	 * The proxy server host
	 * 
	 */
	@JsonProperty("host")
	public String getHost() {
		return host;
	}

	/**
	 * The proxy server host
	 * 
	 */
	@JsonProperty("host")
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * The proxy server port
	 * 
	 */
	@JsonProperty("port")
	public Integer getPort() {
		return port;
	}

	/**
	 * The proxy server port
	 * 
	 */
	@JsonProperty("port")
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * The tunneling details for the proxy config
	 * 
	 */
	@JsonProperty("tunnel")
	public Boolean getTunnel() {
		return tunnel;
	}

	/**
	 * The tunneling details for the proxy config
	 * 
	 */
	@JsonProperty("tunnel")
	public void setTunnel(Boolean tunnel) {
		this.tunnel = tunnel;
	}

	/**
	 * When set to true, ignores this proxy configuration entity
	 * 
	 */
	@JsonProperty("disabled")
	public Boolean getDisabled() {
		return disabled;
	}

	/**
	 * When set to true, ignores this proxy configuration entity
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
		sb.append(ProxyConfig.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("match");
		sb.append('=');
		sb.append(((this.match == null) ? "<null>" : this.match));
		sb.append(',');
		sb.append("host");
		sb.append('=');
		sb.append(((this.host == null) ? "<null>" : this.host));
		sb.append(',');
		sb.append("port");
		sb.append('=');
		sb.append(((this.port == null) ? "<null>" : this.port));
		sb.append(',');
		sb.append("tunnel");
		sb.append('=');
		sb.append(((this.tunnel == null) ? "<null>" : this.tunnel));
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
		result = ((result * 31) + ((this.port == null) ? 0 : this.port.hashCode()));
		result = ((result * 31) + ((this.match == null) ? 0 : this.match.hashCode()));
		result = ((result * 31) + ((this.host == null) ? 0 : this.host.hashCode()));
		result = ((result * 31) + ((this.disabled == null) ? 0 : this.disabled.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.tunnel == null) ? 0 : this.tunnel.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ProxyConfig) == false) {
			return false;
		}
		ProxyConfig rhs = ((ProxyConfig) other);
		return (((((((this.port == rhs.port) || ((this.port != null) && this.port.equals(rhs.port)))
				&& ((this.match == rhs.match) || ((this.match != null) && this.match.equals(rhs.match))))
				&& ((this.host == rhs.host) || ((this.host != null) && this.host.equals(rhs.host))))
				&& ((this.disabled == rhs.disabled) || ((this.disabled != null) && this.disabled.equals(rhs.disabled))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.tunnel == rhs.tunnel) || ((this.tunnel != null) && this.tunnel.equals(rhs.tunnel))));
	}

}
