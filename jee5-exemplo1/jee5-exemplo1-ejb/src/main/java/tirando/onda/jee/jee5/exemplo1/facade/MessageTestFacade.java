package tirando.onda.jee.jee5.exemplo1.facade;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.common.MessageTest;
import tirando.onda.jee.jee5.exemplo1.common.PersistenceTest;
import tirando.onda.jee.jee5.library.message.Message;
import tirando.onda.jee.jee5.library.message.MessageContext;

@Stateless
@Local(value = MessageTest.class)
public class MessageTestFacade implements MessageTest {

	@EJB
	private PersistenceTest persistenceTest;

	@EJB
	private MessageContext context;

	public void testMethod(Message msg) {
		if (context.getMessages().size() == 1) {
			if (!context.getMessages().contains(msg)) {
				System.err.println("Deu pau 1");
			} else {
				persistenceTest.testMethod(msg);
			}

		} else
			System.err.println("Deu pau 2");
	}

}
