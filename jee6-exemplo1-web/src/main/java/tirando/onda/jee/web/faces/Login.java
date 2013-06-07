package tirando.onda.jee.web.faces;

import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

public class Login {
	
	private String username;
	private String password;
	private X509Certificate x509;
	private String sucessPageRedirect;
	
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

	public String getSucessPageRedirect() {
		return sucessPageRedirect;
	}

	public void setSucessPageRedirect(String sucessPageRedirect) {
		this.sucessPageRedirect = sucessPageRedirect;
	}

	public String autenticateUsernamePassword() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		
		Gson gson = new Gson();
		String json = gson.toJson(map);
		
		try {
			request.login("USERNAME-PASSWORD", json);
			return sucessPageRedirect;
		} catch (ServletException e) {
			StringBuilder sb = new StringBuilder();
			if (e.getStackTrace() != null) {
				for (StackTraceElement element : e.getStackTrace()) {
					sb.append(element.toString());
					sb.append("\n");
				}
			}
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), sb.toString());
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "";
		}	
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
