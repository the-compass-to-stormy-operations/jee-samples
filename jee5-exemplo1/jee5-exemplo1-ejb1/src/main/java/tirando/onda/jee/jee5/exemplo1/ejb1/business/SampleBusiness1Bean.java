package tirando.onda.jee.jee5.exemplo1.ejb1.business;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.ejb1.persistence.SampleDAO1;

@Stateless
@Local(value=SampleBusiness1.class)
public class SampleBusiness1Bean implements SampleBusiness1 {
	
	@EJB
	SampleDAO1 dao;

	public void businessMethod1() {
		dao.persistenceMethod1();
	}

	public void businessMethod2() {
		dao.persistenceMethod2();
	}

}
