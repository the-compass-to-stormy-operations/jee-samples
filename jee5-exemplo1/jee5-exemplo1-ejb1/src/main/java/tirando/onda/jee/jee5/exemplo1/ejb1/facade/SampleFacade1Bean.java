package tirando.onda.jee.jee5.exemplo1.ejb1.facade;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.ejb1.business.SampleBusiness1;
import tirando.onda.jee.jee5.exemplo1.ejb1.dto.SampleDTO1;
import tirando.onda.jee.jee5.exemplo1.ejb2.dto.AnotherSampleDTO1;
import tirando.onda.jee.jee5.exemplo1.ejb2.facade.AnotherSampleFacade1;

@Stateless
@Local(value=SampleFacade1.class)
public class SampleFacade1Bean implements SampleFacade1 {
	
	@EJB
	SampleBusiness1 business1;
	
	@EJB
	AnotherSampleFacade1 anotherSampleFacade1;
	
	public SampleDTO1 sampleMethod1(SampleDTO1 dto) {
		business1.businessMethod1();
		business1.businessMethod2();
		
		anotherSampleFacade1.sampleMethod1(new AnotherSampleDTO1());

		return new SampleDTO1();
	}

}
