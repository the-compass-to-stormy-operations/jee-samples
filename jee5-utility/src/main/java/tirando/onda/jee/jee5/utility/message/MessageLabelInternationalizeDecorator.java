package tirando.onda.jee.jee5.utility.message;

import java.util.Locale;
import java.util.ResourceBundle;

import tirando.onda.jee.jee5.utility.message.Message;
import tirando.onda.jee.jee5.utility.message.Severity;

public class MessageLabelInternationalizeDecorator implements Message {

	private Message message;
	private Locale newLocale;

	public MessageLabelInternationalizeDecorator(Message message,
			Locale newLocale) {
		this.message = message;
		this.newLocale = newLocale;
	}

	public String getKey() {
		return message.getKey();
	}

	public String getLabel() {
		String label = message.getLabel();

		if (!newLocale.equals(message.getLocale())) {
			ResourceBundle bundle = ResourceBundle.getBundle(message
					.getResourceName(), newLocale);
			if (bundle.getString(message.getKey()) != null) {
				label = bundle.getString(message.getKey());
			}
		}

		return label;
	}

	public Locale getLocale() {
		return message.getLocale();
	}

	public String getResourceName() {
		return message.getResourceName();
	}

	public Severity getSeverity() {
		return message.getSeverity();
	}

	@Override
	public String toString() {
		return message.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return message.equals(obj);
	}

	@Override
	public int hashCode() {
		return message.hashCode();
	}

}