package tirando.onda.jee.jee5.exemplo1.facade;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.persistence.PersistenceTest;
import tirando.onda.jee.jee5.utility.message.Message;

@Stateless
@Local(value = MessageTest.class)
public class MessageTestBean implements MessageTest {

	@EJB
	private PersistenceTest persistenceTest;

	public void testMethod(Message msg) {
		System.out.println("facedo invoke...");
		persistenceTest.testMethod(msg);
	}

}
