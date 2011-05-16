package tirando.onda.jee.jee5.exemplo1.persistence;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(value=SampleDAO.class)
public class SampleDAOBean implements SampleDAO {
	
//	@PersistenceUnit
//	private EntityManager em;

	public void persistenceMethod1() {
//		em.clear();
	}

	public void persistenceMethod2() {
//		em.clear();		
	}

}
