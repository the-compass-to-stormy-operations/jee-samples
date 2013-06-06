package tirando.onda.jee.jaas;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.message.AuthException;
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
		} catch (Exception e) {
			throw new RuntimeException("Error on Callback Handle", e);
		}
		
		System.out.println(nc+"/"+pc);
		
		return true;
	}

	public boolean logout() throws LoginException {
		System.out.println("Login");
		return true;
	}

	public boolean commit() throws LoginException {
		System.out.println("Commit");
		return true;
	}

	public boolean abort() throws LoginException {
		System.out.println("Abort");
		return true;
	}

}
