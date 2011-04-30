package tirando.onda.jee.jee5.exemplo1.facade;

import javax.ejb.Local;
import javax.ejb.Stateless;

import tirando.onda.jee.jee5.exemplo1.common.Sample;

@Local(value=Sample.class)
@Stateless
public class SampleFacade implements Sample {

	public void sampleMethod() {
		System.out.println("executou");
	}

}
