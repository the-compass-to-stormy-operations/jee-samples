package tirando.onda.jee.jee5.exemplo1.web.faces.managedbean;

import java.util.Locale;

import tirando.onda.jee.jee5.utility.message.Message;
import tirando.onda.jee.jee5.utility.message.Severity;

public class GenericMessage implements Message {
	
	private String key;
	private String label;
	private Locale locale;
	private String resourceName;
	private Severity severity;
	
	public GenericMessage(String key, String label, Locale locale, String resourceName, Severity severity) {
		this.key = key;
		this.label = label;
		this.locale = locale;
		this.resourceName = resourceName;
		this.severity = severity;
	}

	public String getKey() {
		return key;
	}

	public String getLabel() {
		return label;
	}

	public Locale getLocale() {
		return locale;
	}

	public String getResourceName() {
		return resourceName;
	}

	public Severity getSeverity() {
		return severity;
	}

}
