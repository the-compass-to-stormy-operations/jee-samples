package tirando.onda.jee.jee5.library.message;

import java.util.Collection;
import java.util.Locale;

public interface MessageContext {

	public void addMessage(Message message, Object... args);

	public Collection<Message> getMessages();
	
	public Collection<Message> getMessages(Locale locale);
	
	public Collection<MessageRecord> getMessageRecords();

	public void clear();

}
