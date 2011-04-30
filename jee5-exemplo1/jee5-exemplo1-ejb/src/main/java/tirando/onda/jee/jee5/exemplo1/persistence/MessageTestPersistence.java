package tirando.onda.jee.jee5.exemplo1.persistence;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.common.PersistenceTest;
import tirando.onda.jee.jee5.library.message.Message;
import tirando.onda.jee.jee5.library.message.MessageContext;


@Stateless
@Local(value=PersistenceTest.class)
public class MessageTestPersistence implements PersistenceTest {
	
	@EJB
	private MessageContext context;

	public void testMethod(Message msg) {
		if (context.getMessages().size() ==1 ){
			if (!context.getMessages().contains(msg)){
				System.err.println("Deu pau 1");
			}
		}else System.err.println("Deu pau 2");
	}


}
