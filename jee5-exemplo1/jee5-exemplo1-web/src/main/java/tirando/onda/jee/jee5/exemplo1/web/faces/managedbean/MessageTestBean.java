package tirando.onda.jee.jee5.exemplo1.web.faces.managedbean;

import java.util.Locale;

import javax.ejb.EJB;

import tirando.onda.jee.jee5.exemplo1.common.MessageTest;
import tirando.onda.jee.jee5.utility.message.Message;
import tirando.onda.jee.jee5.utility.message.MessageContext;
import tirando.onda.jee.jee5.utility.message.Severity;

public class MessageTestBean {

	@EJB
	private MessageTest messageTest;
	
	@EJB
	private MessageContext context;
	
	private String label;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String execute(){
		Message msg = new GenericMessage("GENERIC-MESSAGE", label, new Locale("pt", "br"), "info-message", Severity.INFO);
		
		context.addMessage(msg);
		messageTest.testMethod(msg);
		context.clear();
		return "message";
	}
	
}
