package tirando.onda.jee.jee5.library.message;

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
