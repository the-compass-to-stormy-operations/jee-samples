package tirando.onda.jee.jee5.exemplo1.common.message;

import java.util.Locale;

import tirando.onda.jee.jee5.library.message.Message;
import tirando.onda.jee.jee5.library.message.Severity;

public enum InfoMessage implements Message {

	INFO_MESSAGE_001("Mensagem 001");
	
	private String label;

	private InfoMessage(String label) {
		this.label = label;
	}
	
	public String getKey() {
		return this.toString();
	}

	public String getLabel() {
		return label;
	}

	public Locale getLocale() {
		return new Locale("pt","br");
	}

	public String getResourceName() {
		return "info-message";
	}

	public Severity getSeverity() {
		return Severity.INFO;
	}

}
