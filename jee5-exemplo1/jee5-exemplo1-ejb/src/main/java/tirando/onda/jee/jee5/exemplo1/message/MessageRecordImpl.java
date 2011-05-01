package tirando.onda.jee.jee5.exemplo1.message;

import tirando.onda.jee.jee5.utility.message.Message;
import tirando.onda.jee.jee5.utility.message.MessageRecord;

public class MessageRecordImpl implements MessageRecord {

	private Message message;
	private Object[] args;

	public MessageRecordImpl(Message message, Object... args) {
		this.message = message;
		this.args = args;
	}

	public Message getMessage() {
		return message;
	}

	public Object[] getArgs() {
		return args;
	}

}
