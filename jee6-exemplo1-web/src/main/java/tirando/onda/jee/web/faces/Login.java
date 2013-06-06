package tirando.onda.jee.web.faces;

import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

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

	public String autenticateUsernamePassword() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		
		Gson gson = new Gson();
		String json = gson.toJson(map);

		System.out.println(json);
		
		try {
			request.login("USERNAME-PASSWORD", json);
		} catch (ServletException e) {
			throw new RuntimeException("Failed login with Username/Password", e);
		}	
		return "";
	}
	
	public String autenticateClientCertificate() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		try {
			request.login("CLIENT-CERTIFICATE", x509.toString());
		} catch (ServletException e) {
			throw new RuntimeException("Failed login with Client Certificate", e);
		}	
		return "";
	}
	
	public String logout() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		try {
			request.logout();
		} catch (ServletException e) {
			throw new RuntimeException("Failed logout", e);
		}
		return "";
	}

}
