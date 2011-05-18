package tirando.onda.jee.jee5.exemplo1.ejb1.facade;

import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.ejb1.dto.SampleDTO2;

@Stateless
@Local(value=SampleFacade2.class)
public class SampleFacade2Bean implements SampleFacade2 {
	
	public SampleDTO2 sampleMethod1(SampleDTO2 dto) {
		
		return new SampleDTO2();
	}

}
