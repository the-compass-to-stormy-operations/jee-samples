package tirando.onda.jee.jee5.exemplo1.ejb2.facade;

import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.ejb2.dto.AnotherSampleDTO1;

@Stateless
@Local(value=AnotherSampleFacade1.class)
public class AnotherSampleFacade1Bean implements AnotherSampleFacade1 {
	
	public AnotherSampleDTO1 sampleMethod1(AnotherSampleDTO1 dto) {
		return new AnotherSampleDTO1();
	}
	
}
