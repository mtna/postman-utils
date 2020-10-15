
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
 * This field contains the data usually contained in the request body.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "mode", "raw", "graphql", "urlencoded", "formdata", "file", "disabled" })
public class Body {

	/**
	 * Postman stores the type of data associated with this request in this
	 * field.
	 * 
	 */
	@JsonProperty("mode")
	@JsonPropertyDescription("Postman stores the type of data associated with this request in this field.")
	private Body.Mode mode;
	@JsonProperty("raw")
	private String raw;
	@JsonProperty("graphql")
	private Graphql graphql;
	@JsonProperty("urlencoded")
	private List<Urlencoded> urlencoded = new ArrayList<Urlencoded>();
	@JsonProperty("formdata")
	private List<Formdatum> formdata = new ArrayList<Formdatum>();
	@JsonProperty("file")
	private File file;
	/**
	 * When set to true, prevents request body from being sent.
	 * 
	 */
	@JsonProperty("disabled")
	@JsonPropertyDescription("When set to true, prevents request body from being sent.")
	private Boolean disabled = false;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Postman stores the type of data associated with this request in this
	 * field.
	 * 
	 */
	@JsonProperty("mode")
	public Body.Mode getMode() {
		return mode;
	}

	/**
	 * Postman stores the type of data associated with this request in this
	 * field.
	 * 
	 */
	@JsonProperty("mode")
	public void setMode(Body.Mode mode) {
		this.mode = mode;
	}

	@JsonProperty("raw")
	public String getRaw() {
		return raw;
	}

	@JsonProperty("raw")
	public void setRaw(String raw) {
		this.raw = raw;
	}

	@JsonProperty("graphql")
	public Graphql getGraphql() {
		return graphql;
	}

	@JsonProperty("graphql")
	public void setGraphql(Graphql graphql) {
		this.graphql = graphql;
	}

	@JsonProperty("urlencoded")
	public List<Urlencoded> getUrlencoded() {
		return urlencoded;
	}

	@JsonProperty("urlencoded")
	public void setUrlencoded(List<Urlencoded> urlencoded) {
		this.urlencoded = urlencoded;
	}

	@JsonProperty("formdata")
	public List<Formdatum> getFormdata() {
		return formdata;
	}

	@JsonProperty("formdata")
	public void setFormdata(List<Formdatum> formdata) {
		this.formdata = formdata;
	}

	@JsonProperty("file")
	public File getFile() {
		return file;
	}

	@JsonProperty("file")
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * When set to true, prevents request body from being sent.
	 * 
	 */
	@JsonProperty("disabled")
	public Boolean getDisabled() {
		return disabled;
	}

	/**
	 * When set to true, prevents request body from being sent.
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
		sb.append(Body.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("mode");
		sb.append('=');
		sb.append(((this.mode == null) ? "<null>" : this.mode));
		sb.append(',');
		sb.append("raw");
		sb.append('=');
		sb.append(((this.raw == null) ? "<null>" : this.raw));
		sb.append(',');
		sb.append("graphql");
		sb.append('=');
		sb.append(((this.graphql == null) ? "<null>" : this.graphql));
		sb.append(',');
		sb.append("urlencoded");
		sb.append('=');
		sb.append(((this.urlencoded == null) ? "<null>" : this.urlencoded));
		sb.append(',');
		sb.append("formdata");
		sb.append('=');
		sb.append(((this.formdata == null) ? "<null>" : this.formdata));
		sb.append(',');
		sb.append("file");
		sb.append('=');
		sb.append(((this.file == null) ? "<null>" : this.file));
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
		result = ((result * 31) + ((this.mode == null) ? 0 : this.mode.hashCode()));
		result = ((result * 31) + ((this.file == null) ? 0 : this.file.hashCode()));
		result = ((result * 31) + ((this.urlencoded == null) ? 0 : this.urlencoded.hashCode()));
		result = ((result * 31) + ((this.raw == null) ? 0 : this.raw.hashCode()));
		result = ((result * 31) + ((this.disabled == null) ? 0 : this.disabled.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.graphql == null) ? 0 : this.graphql.hashCode()));
		result = ((result * 31) + ((this.formdata == null) ? 0 : this.formdata.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Body) == false) {
			return false;
		}
		Body rhs = ((Body) other);
		return (((((((((this.mode == rhs.mode) || ((this.mode != null) && this.mode.equals(rhs.mode)))
				&& ((this.file == rhs.file) || ((this.file != null) && this.file.equals(rhs.file))))
				&& ((this.urlencoded == rhs.urlencoded)
						|| ((this.urlencoded != null) && this.urlencoded.equals(rhs.urlencoded))))
				&& ((this.raw == rhs.raw) || ((this.raw != null) && this.raw.equals(rhs.raw))))
				&& ((this.disabled == rhs.disabled) || ((this.disabled != null) && this.disabled.equals(rhs.disabled))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.graphql == rhs.graphql) || ((this.graphql != null) && this.graphql.equals(rhs.graphql))))
				&& ((this.formdata == rhs.formdata)
						|| ((this.formdata != null) && this.formdata.equals(rhs.formdata))));
	}

	/**
	 * Postman stores the type of data associated with this request in this
	 * field.
	 * 
	 */
	public enum Mode {

		RAW("raw"), URLENCODED("urlencoded"), FORMDATA("formdata"), FILE("file"), GRAPHQL("graphql");

		private final String value;
		private final static Map<String, Body.Mode> CONSTANTS = new HashMap<String, Body.Mode>();

		static {
			for (Body.Mode c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private Mode(String value) {
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
		public static Body.Mode fromValue(String value) {
			Body.Mode constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
