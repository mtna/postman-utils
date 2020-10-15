
package us.mtna.postman.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * Auth
 * <p>
 * Represents authentication helpers provided by Postman
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "noauth", "apikey", "awsv4", "basic", "bearer", "digest", "hawk", "ntlm", "oauth1",
		"oauth2" })
public class Auth {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("type")
	private Auth.Type type;
	@JsonProperty("noauth")
	private Object noauth;
	/**
	 * API Key Authentication
	 * <p>
	 * The attributes for API Key Authentication.
	 * 
	 */
	@JsonProperty("apikey")
	@JsonPropertyDescription("The attributes for API Key Authentication.")
	private List<AuthAttribute> apikey = new ArrayList<AuthAttribute>();
	/**
	 * AWS Signature v4
	 * <p>
	 * The attributes for [AWS
	 * Auth](http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html).
	 * 
	 */
	@JsonProperty("awsv4")
	@JsonPropertyDescription("The attributes for [AWS Auth](http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html).")
	private List<AuthAttribute> awsv4 = new ArrayList<AuthAttribute>();
	/**
	 * Basic Authentication
	 * <p>
	 * The attributes for [Basic
	 * Authentication](https://en.wikipedia.org/wiki/Basic_access_authentication).
	 * 
	 */
	@JsonProperty("basic")
	@JsonPropertyDescription("The attributes for [Basic Authentication](https://en.wikipedia.org/wiki/Basic_access_authentication).")
	private List<AuthAttribute> basic = new ArrayList<AuthAttribute>();
	/**
	 * Bearer Token Authentication
	 * <p>
	 * The helper attributes for [Bearer Token
	 * Authentication](https://tools.ietf.org/html/rfc6750)
	 * 
	 */
	@JsonProperty("bearer")
	@JsonPropertyDescription("The helper attributes for [Bearer Token Authentication](https://tools.ietf.org/html/rfc6750)")
	private List<AuthAttribute> bearer = new ArrayList<AuthAttribute>();
	/**
	 * Digest Authentication
	 * <p>
	 * The attributes for [Digest
	 * Authentication](https://en.wikipedia.org/wiki/Digest_access_authentication).
	 * 
	 */
	@JsonProperty("digest")
	@JsonPropertyDescription("The attributes for [Digest Authentication](https://en.wikipedia.org/wiki/Digest_access_authentication).")
	private List<AuthAttribute> digest = new ArrayList<AuthAttribute>();
	/**
	 * Hawk Authentication
	 * <p>
	 * The attributes for [Hawk
	 * Authentication](https://github.com/hueniverse/hawk)
	 * 
	 */
	@JsonProperty("hawk")
	@JsonPropertyDescription("The attributes for [Hawk Authentication](https://github.com/hueniverse/hawk)")
	private List<AuthAttribute> hawk = new ArrayList<AuthAttribute>();
	/**
	 * NTLM Authentication
	 * <p>
	 * The attributes for [NTLM
	 * Authentication](https://msdn.microsoft.com/en-us/library/cc237488.aspx)
	 * 
	 */
	@JsonProperty("ntlm")
	@JsonPropertyDescription("The attributes for [NTLM Authentication](https://msdn.microsoft.com/en-us/library/cc237488.aspx)")
	private List<AuthAttribute> ntlm = new ArrayList<AuthAttribute>();
	/**
	 * OAuth1
	 * <p>
	 * The attributes for [OAuth2](https://oauth.net/1/)
	 * 
	 */
	@JsonProperty("oauth1")
	@JsonPropertyDescription("The attributes for [OAuth2](https://oauth.net/1/)")
	private List<AuthAttribute> oauth1 = new ArrayList<AuthAttribute>();
	/**
	 * OAuth2
	 * <p>
	 * Helper attributes for [OAuth2](https://oauth.net/2/)
	 * 
	 */
	@JsonProperty("oauth2")
	@JsonPropertyDescription("Helper attributes for [OAuth2](https://oauth.net/2/)")
	private List<AuthAttribute> oauth2 = new ArrayList<AuthAttribute>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("type")
	public Auth.Type getType() {
		return type;
	}

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("type")
	public void setType(Auth.Type type) {
		this.type = type;
	}

	@JsonProperty("noauth")
	public Object getNoauth() {
		return noauth;
	}

	@JsonProperty("noauth")
	public void setNoauth(Object noauth) {
		this.noauth = noauth;
	}

	/**
	 * API Key Authentication
	 * <p>
	 * The attributes for API Key Authentication.
	 * 
	 */
	@JsonProperty("apikey")
	public List<AuthAttribute> getApikey() {
		return apikey;
	}

	/**
	 * API Key Authentication
	 * <p>
	 * The attributes for API Key Authentication.
	 * 
	 */
	@JsonProperty("apikey")
	public void setApikey(List<AuthAttribute> apikey) {
		this.apikey = apikey;
	}

	/**
	 * AWS Signature v4
	 * <p>
	 * The attributes for [AWS
	 * Auth](http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html).
	 * 
	 */
	@JsonProperty("awsv4")
	public List<AuthAttribute> getAwsv4() {
		return awsv4;
	}

	/**
	 * AWS Signature v4
	 * <p>
	 * The attributes for [AWS
	 * Auth](http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html).
	 * 
	 */
	@JsonProperty("awsv4")
	public void setAwsv4(List<AuthAttribute> awsv4) {
		this.awsv4 = awsv4;
	}

	/**
	 * Basic Authentication
	 * <p>
	 * The attributes for [Basic
	 * Authentication](https://en.wikipedia.org/wiki/Basic_access_authentication).
	 * 
	 */
	@JsonProperty("basic")
	public List<AuthAttribute> getBasic() {
		return basic;
	}

	/**
	 * Basic Authentication
	 * <p>
	 * The attributes for [Basic
	 * Authentication](https://en.wikipedia.org/wiki/Basic_access_authentication).
	 * 
	 */
	@JsonProperty("basic")
	public void setBasic(List<AuthAttribute> basic) {
		this.basic = basic;
	}

	/**
	 * Bearer Token Authentication
	 * <p>
	 * The helper attributes for [Bearer Token
	 * Authentication](https://tools.ietf.org/html/rfc6750)
	 * 
	 */
	@JsonProperty("bearer")
	public List<AuthAttribute> getBearer() {
		return bearer;
	}

	/**
	 * Bearer Token Authentication
	 * <p>
	 * The helper attributes for [Bearer Token
	 * Authentication](https://tools.ietf.org/html/rfc6750)
	 * 
	 */
	@JsonProperty("bearer")
	public void setBearer(List<AuthAttribute> bearer) {
		this.bearer = bearer;
	}

	/**
	 * Digest Authentication
	 * <p>
	 * The attributes for [Digest
	 * Authentication](https://en.wikipedia.org/wiki/Digest_access_authentication).
	 * 
	 */
	@JsonProperty("digest")
	public List<AuthAttribute> getDigest() {
		return digest;
	}

	/**
	 * Digest Authentication
	 * <p>
	 * The attributes for [Digest
	 * Authentication](https://en.wikipedia.org/wiki/Digest_access_authentication).
	 * 
	 */
	@JsonProperty("digest")
	public void setDigest(List<AuthAttribute> digest) {
		this.digest = digest;
	}

	/**
	 * Hawk Authentication
	 * <p>
	 * The attributes for [Hawk
	 * Authentication](https://github.com/hueniverse/hawk)
	 * 
	 */
	@JsonProperty("hawk")
	public List<AuthAttribute> getHawk() {
		return hawk;
	}

	/**
	 * Hawk Authentication
	 * <p>
	 * The attributes for [Hawk
	 * Authentication](https://github.com/hueniverse/hawk)
	 * 
	 */
	@JsonProperty("hawk")
	public void setHawk(List<AuthAttribute> hawk) {
		this.hawk = hawk;
	}

	/**
	 * NTLM Authentication
	 * <p>
	 * The attributes for [NTLM
	 * Authentication](https://msdn.microsoft.com/en-us/library/cc237488.aspx)
	 * 
	 */
	@JsonProperty("ntlm")
	public List<AuthAttribute> getNtlm() {
		return ntlm;
	}

	/**
	 * NTLM Authentication
	 * <p>
	 * The attributes for [NTLM
	 * Authentication](https://msdn.microsoft.com/en-us/library/cc237488.aspx)
	 * 
	 */
	@JsonProperty("ntlm")
	public void setNtlm(List<AuthAttribute> ntlm) {
		this.ntlm = ntlm;
	}

	/**
	 * OAuth1
	 * <p>
	 * The attributes for [OAuth2](https://oauth.net/1/)
	 * 
	 */
	@JsonProperty("oauth1")
	public List<AuthAttribute> getOauth1() {
		return oauth1;
	}

	/**
	 * OAuth1
	 * <p>
	 * The attributes for [OAuth2](https://oauth.net/1/)
	 * 
	 */
	@JsonProperty("oauth1")
	public void setOauth1(List<AuthAttribute> oauth1) {
		this.oauth1 = oauth1;
	}

	/**
	 * OAuth2
	 * <p>
	 * Helper attributes for [OAuth2](https://oauth.net/2/)
	 * 
	 */
	@JsonProperty("oauth2")
	public List<AuthAttribute> getOauth2() {
		return oauth2;
	}

	/**
	 * OAuth2
	 * <p>
	 * Helper attributes for [OAuth2](https://oauth.net/2/)
	 * 
	 */
	@JsonProperty("oauth2")
	public void setOauth2(List<AuthAttribute> oauth2) {
		this.oauth2 = oauth2;
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
		sb.append(Auth.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("type");
		sb.append('=');
		sb.append(((this.type == null) ? "<null>" : this.type));
		sb.append(',');
		sb.append("noauth");
		sb.append('=');
		sb.append(((this.noauth == null) ? "<null>" : this.noauth));
		sb.append(',');
		sb.append("apikey");
		sb.append('=');
		sb.append(((this.apikey == null) ? "<null>" : this.apikey));
		sb.append(',');
		sb.append("awsv4");
		sb.append('=');
		sb.append(((this.awsv4 == null) ? "<null>" : this.awsv4));
		sb.append(',');
		sb.append("basic");
		sb.append('=');
		sb.append(((this.basic == null) ? "<null>" : this.basic));
		sb.append(',');
		sb.append("bearer");
		sb.append('=');
		sb.append(((this.bearer == null) ? "<null>" : this.bearer));
		sb.append(',');
		sb.append("digest");
		sb.append('=');
		sb.append(((this.digest == null) ? "<null>" : this.digest));
		sb.append(',');
		sb.append("hawk");
		sb.append('=');
		sb.append(((this.hawk == null) ? "<null>" : this.hawk));
		sb.append(',');
		sb.append("ntlm");
		sb.append('=');
		sb.append(((this.ntlm == null) ? "<null>" : this.ntlm));
		sb.append(',');
		sb.append("oauth1");
		sb.append('=');
		sb.append(((this.oauth1 == null) ? "<null>" : this.oauth1));
		sb.append(',');
		sb.append("oauth2");
		sb.append('=');
		sb.append(((this.oauth2 == null) ? "<null>" : this.oauth2));
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
		result = ((result * 31) + ((this.apikey == null) ? 0 : this.apikey.hashCode()));
		result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
		result = ((result * 31) + ((this.oauth2 == null) ? 0 : this.oauth2.hashCode()));
		result = ((result * 31) + ((this.oauth1 == null) ? 0 : this.oauth1.hashCode()));
		result = ((result * 31) + ((this.ntlm == null) ? 0 : this.ntlm.hashCode()));
		result = ((result * 31) + ((this.awsv4 == null) ? 0 : this.awsv4.hashCode()));
		result = ((result * 31) + ((this.noauth == null) ? 0 : this.noauth.hashCode()));
		result = ((result * 31) + ((this.digest == null) ? 0 : this.digest.hashCode()));
		result = ((result * 31) + ((this.bearer == null) ? 0 : this.bearer.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.basic == null) ? 0 : this.basic.hashCode()));
		result = ((result * 31) + ((this.hawk == null) ? 0 : this.hawk.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Auth) == false) {
			return false;
		}
		Auth rhs = ((Auth) other);
		return (((((((((((((this.apikey == rhs.apikey) || ((this.apikey != null) && this.apikey.equals(rhs.apikey)))
				&& ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
				&& ((this.oauth2 == rhs.oauth2) || ((this.oauth2 != null) && this.oauth2.equals(rhs.oauth2))))
				&& ((this.oauth1 == rhs.oauth1) || ((this.oauth1 != null) && this.oauth1.equals(rhs.oauth1))))
				&& ((this.ntlm == rhs.ntlm) || ((this.ntlm != null) && this.ntlm.equals(rhs.ntlm))))
				&& ((this.awsv4 == rhs.awsv4) || ((this.awsv4 != null) && this.awsv4.equals(rhs.awsv4))))
				&& ((this.noauth == rhs.noauth) || ((this.noauth != null) && this.noauth.equals(rhs.noauth))))
				&& ((this.digest == rhs.digest) || ((this.digest != null) && this.digest.equals(rhs.digest))))
				&& ((this.bearer == rhs.bearer) || ((this.bearer != null) && this.bearer.equals(rhs.bearer))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.basic == rhs.basic) || ((this.basic != null) && this.basic.equals(rhs.basic))))
				&& ((this.hawk == rhs.hawk) || ((this.hawk != null) && this.hawk.equals(rhs.hawk))));
	}

	public enum Type {

		APIKEY("apikey"), AWSV_4("awsv4"), BASIC("basic"), BEARER("bearer"), DIGEST("digest"), HAWK("hawk"), NOAUTH(
				"noauth"), OAUTH_1("oauth1"), OAUTH_2("oauth2"), NTLM("ntlm");

		private final String value;
		private final static Map<String, Auth.Type> CONSTANTS = new HashMap<String, Auth.Type>();

		static {
			for (Auth.Type c : values()) {
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
		public static Auth.Type fromValue(String value) {
			Auth.Type constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
