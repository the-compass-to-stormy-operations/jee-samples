package tirando.onda.jee.jaas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class ProviderLoginModule implements LoginModule {
	
	private Subject subject;
	private CallbackHandler callbackHandler;
	private Map<String, ?> sharedState;
	private Map<String, ?> options;

	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;
	}

	public boolean login() throws LoginException {
		System.out.println("Login");
		
		NameCallback nc = new NameCallback("username:");
		PasswordCallback pc = new PasswordCallback("password:", false);
		Callback[] callbacks = new Callback[] { nc, pc };
		try {
			callbackHandler.handle(callbacks);
			System.out.println(nc.getName());
			System.out.println(pc.getPassword());
		} catch (Exception e) {
			throw new RuntimeException("Error on Callback Handle", e);
		}
		
		return true;
	}

	public boolean logout() throws LoginException {
		System.out.println("Login");
		return true;
	}

	public boolean commit() throws LoginException {
		System.out.println("Commit");

		SimpleGroup callerPrincipalGroup;
		SimpleGroup roleGroup;

		Collection<SimpleRole> roles = new ArrayList<SimpleRole>();
		roles.add(new SimpleRole("ROLE001"));

		callerPrincipalGroup = new SimpleGroup("CallerPrincipal");
		callerPrincipalGroup.addMember(new SimpleUser("admin"));
		subject.getPrincipals().add(callerPrincipalGroup);

		roleGroup = new SimpleGroup("Roles");
		for (SimpleRole role : roles) {
			roleGroup.addMember(role);
		}
		subject.getPrincipals().add(roleGroup);
		
		return true;
	}

	public boolean abort() throws LoginException {
		System.out.println("Abort");
		return true;
	}

}
