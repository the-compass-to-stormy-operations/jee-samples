package tirando.onda.jee.jee5.exemplo1.teste;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(value=Xyz.class)
public class XyzBean implements Xyz {
	
	public void xxx() {
		System.out.println("foi...");
	}

}
