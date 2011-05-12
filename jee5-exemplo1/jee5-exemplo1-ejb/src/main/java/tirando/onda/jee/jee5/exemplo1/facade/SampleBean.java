package tirando.onda.jee.jee5.exemplo1.facade;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(value=Sample.class)
public class SampleBean implements Sample {

	public void sampleMethod() {
		System.out.println("executou");
	}

}
