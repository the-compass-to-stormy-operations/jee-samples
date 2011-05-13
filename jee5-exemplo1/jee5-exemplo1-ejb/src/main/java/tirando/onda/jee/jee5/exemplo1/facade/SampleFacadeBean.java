package tirando.onda.jee.jee5.exemplo1.facade;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.business.SampleBusiness;
import tirando.onda.jee.jee5.exemplo1.dto.SampleDTO;

@Stateless
@Local(value=SampleFacade.class)
public class SampleFacadeBean implements SampleFacade {
	
	@EJB
	SampleBusiness business;

	public SampleDTO sampleMethod(SampleDTO dto) {
		business.businessMethod1();
		business.businessMethod2();
		return new SampleDTO();
	}

}
