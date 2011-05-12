package tirando.onda.jee.jee5.utility.message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import org.apache.log4j.Logger;

public class MessageContextImpl implements MessageContext {

	private static Logger log = Logger.getLogger(MessageContextImpl.class);

	private Collection<MessageRecord> messages = new ArrayList<MessageRecord>();

	public MessageContextImpl() {
		log.debug("Message context created");
	}

	public void addMessage(Message message, Object... args) {
		log.debug("Adding message " + message + " to the context");
		
		messages.add(new MessageRecordImpl(message, args));
	}

	public Collection<Message> getMessages() {
		Collection<Message> result = new MessageArrayList<Message>();

		for (MessageRecord record : messages) {
			result.add(new MessageLabelArgumentDecorator(record.getMessage(), record.getArgs()));
		}

		log.debug("Retrieving collection of messages (" + result.size() + ")");

		return result;
	}

	public Collection<Message> getMessages(Locale locale) {
		Collection<Message> result = new MessageArrayList<Message>();

		for (MessageRecord record : messages) {
			result.add(new MessageLabelArgumentDecorator(
					new MessageLabelInternationalizeDecorator(record
							.getMessage(), locale), record.getArgs()));
		}

		log.debug("Retrieving collection of messages (" + result.size() + ")");

		return result;
	}

	public Collection<MessageRecord> getMessageRecords() {
		return messages;
	}
	
	public void clear() {
		log.debug("Cleaning up message context");
		messages.clear();
	}

}
