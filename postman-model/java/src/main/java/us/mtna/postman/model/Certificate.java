
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
 * Certificate
 * <p>
 * A representation of an ssl certificate
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "matches", "key", "cert", "passphrase" })
public class Certificate {

	/**
	 * A name for the certificate for user reference
	 * 
	 */
	@JsonProperty("name")
	@JsonPropertyDescription("A name for the certificate for user reference")
	private String name;
	/**
	 * A list of Url match pattern strings, to identify Urls this certificate
	 * can be used for.
	 * 
	 */
	@JsonProperty("matches")
	@JsonPropertyDescription("A list of Url match pattern strings, to identify Urls this certificate can be used for.")
	private List<Object> matches = new ArrayList<Object>();
	/**
	 * An object containing path to file containing private key, on the file
	 * system
	 * 
	 */
	@JsonProperty("key")
	@JsonPropertyDescription("An object containing path to file containing private key, on the file system")
	private Key key;
	/**
	 * An object containing path to file certificate, on the file system
	 * 
	 */
	@JsonProperty("cert")
	@JsonPropertyDescription("An object containing path to file certificate, on the file system")
	private Cert cert;
	/**
	 * The passphrase for the certificate
	 * 
	 */
	@JsonProperty("passphrase")
	@JsonPropertyDescription("The passphrase for the certificate")
	private String passphrase;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * A name for the certificate for user reference
	 * 
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * A name for the certificate for user reference
	 * 
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * A list of Url match pattern strings, to identify Urls this certificate
	 * can be used for.
	 * 
	 */
	@JsonProperty("matches")
	public List<Object> getMatches() {
		return matches;
	}

	/**
	 * A list of Url match pattern strings, to identify Urls this certificate
	 * can be used for.
	 * 
	 */
	@JsonProperty("matches")
	public void setMatches(List<Object> matches) {
		this.matches = matches;
	}

	/**
	 * An object containing path to file containing private key, on the file
	 * system
	 * 
	 */
	@JsonProperty("key")
	public Key getKey() {
		return key;
	}

	/**
	 * An object containing path to file containing private key, on the file
	 * system
	 * 
	 */
	@JsonProperty("key")
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * An object containing path to file certificate, on the file system
	 * 
	 */
	@JsonProperty("cert")
	public Cert getCert() {
		return cert;
	}

	/**
	 * An object containing path to file certificate, on the file system
	 * 
	 */
	@JsonProperty("cert")
	public void setCert(Cert cert) {
		this.cert = cert;
	}

	/**
	 * The passphrase for the certificate
	 * 
	 */
	@JsonProperty("passphrase")
	public String getPassphrase() {
		return passphrase;
	}

	/**
	 * The passphrase for the certificate
	 * 
	 */
	@JsonProperty("passphrase")
	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
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
		sb.append(Certificate.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("matches");
		sb.append('=');
		sb.append(((this.matches == null) ? "<null>" : this.matches));
		sb.append(',');
		sb.append("key");
		sb.append('=');
		sb.append(((this.key == null) ? "<null>" : this.key));
		sb.append(',');
		sb.append("cert");
		sb.append('=');
		sb.append(((this.cert == null) ? "<null>" : this.cert));
		sb.append(',');
		sb.append("passphrase");
		sb.append('=');
		sb.append(((this.passphrase == null) ? "<null>" : this.passphrase));
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
		result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
		result = ((result * 31) + ((this.cert == null) ? 0 : this.cert.hashCode()));
		result = ((result * 31) + ((this.passphrase == null) ? 0 : this.passphrase.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.matches == null) ? 0 : this.matches.hashCode()));
		result = ((result * 31) + ((this.key == null) ? 0 : this.key.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Certificate) == false) {
			return false;
		}
		Certificate rhs = ((Certificate) other);
		return (((((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
				&& ((this.cert == rhs.cert) || ((this.cert != null) && this.cert.equals(rhs.cert))))
				&& ((this.passphrase == rhs.passphrase)
						|| ((this.passphrase != null) && this.passphrase.equals(rhs.passphrase))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.matches == rhs.matches) || ((this.matches != null) && this.matches.equals(rhs.matches))))
				&& ((this.key == rhs.key) || ((this.key != null) && this.key.equals(rhs.key))));
	}

}
