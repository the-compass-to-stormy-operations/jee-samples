package tirando.onda.jee.jaas;

import java.io.Serializable;
import java.security.Principal;

public class SimpleUser implements Principal, Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;

	public SimpleUser(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
