package tirando.onda.jee.jee5.library.message;

import java.text.MessageFormat;
import java.util.Locale;

public class MessageLabelArgumentDecorator implements Message {

	private Message message;
	private Object[] args;

	public MessageLabelArgumentDecorator(Message message, Object... args) {
		this.message = message;
		this.args = args;
	}

	public String getKey() {
		return message.getKey();
	}

	public String getLabel() {
		String label = message.getLabel();

		if (args != null) {
			MessageFormat formatter = new MessageFormat("");
			formatter.applyPattern(message.getLabel());
			label = formatter.format(args);
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
