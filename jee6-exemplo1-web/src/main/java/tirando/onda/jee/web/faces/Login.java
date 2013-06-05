package tirando.onda.jee.web.faces;

import java.security.cert.X509Certificate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="login")
@RequestScoped
public class Login {
	
	private String username;
	private String password;
	private X509Certificate x509;
	
	public Login() {
		super();
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public X509Certificate getX509() {
		return x509;
	}


	public void setX509(X509Certificate x509) {
		this.x509 = x509;
	}

	public void autenticateUsernamePassword() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		try {
			request.login(username, password);
		} catch (ServletException e) {
			throw new RuntimeException("Error in programmatic login", e);
		}	
	}
	
	public void logout() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		try {
			request.logout();
		} catch (ServletException e) {
			throw new RuntimeException("Error in programmatic logout", e);
		}
	}

}
