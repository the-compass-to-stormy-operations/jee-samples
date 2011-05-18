package tirando.onda.jee.jee5.exemplo1.ejb2.facade;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.ejb1.dto.SampleDTO1;
import tirando.onda.jee.jee5.exemplo1.ejb1.facade.SampleFacade1;
import tirando.onda.jee.jee5.exemplo1.ejb2.dto.AnotherSampleDTO2;

@Stateless
@Local(value=AnotherSampleFacade2.class)
public class AnotherSampleFacade2Bean implements AnotherSampleFacade2 {
	
	@EJB
	SampleFacade1 sampleFacade1;

	public AnotherSampleDTO2 sampleMethod1(AnotherSampleDTO2 dto) {
		sampleFacade1.sampleMethod1(new SampleDTO1());
		
		return new AnotherSampleDTO2();
	}

}
