#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.persistence;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(value=SampleDAO1.class)
public class SampleDAO1Bean implements SampleDAO1 {
	
//	@PersistenceUnit
//	private EntityManager em;

	public void persistenceMethod1() {
//		em.clear();
	}

	public void persistenceMethod2() {
//		em.clear();		
	}

}
