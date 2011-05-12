package tirando.onda.jee.jee5.exemplo1.persistence;

import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.utility.message.Message;

@Stateless
@Local(value=PersistenceTest.class)
public class PersistenceTestBean implements PersistenceTest {
	
	public void testMethod(Message msg) {
		System.out.println("persist....");
	}


}
