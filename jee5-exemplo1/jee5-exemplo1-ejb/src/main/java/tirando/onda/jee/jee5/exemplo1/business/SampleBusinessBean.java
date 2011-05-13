package tirando.onda.jee.jee5.exemplo1.business;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.persistence.SampleDAO;

@Stateless
@Local(value=SampleBusiness.class)
public class SampleBusinessBean implements SampleBusiness {
	
	@EJB
	SampleDAO dao;

	public void businessMethod1() {
		dao.persistenceMethod1();
	}

	public void businessMethod2() {
		dao.persistenceMethod2();
	}

}
