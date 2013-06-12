package tirando.onda.jee.web.faces;

import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

public class Login {
	
	private static final String CERTIFICATES_ATTR = "javax.servlet.request.X509Certificate";
	
	private String username;
	private String password;
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
			request.logout();
			request.login(arg0, arg1);
			
			
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
		
		X509Certificate certs[] = (X509Certificate[]) request.getAttribute(CERTIFICATES_ATTR);
		if ((certs == null) || (certs.length < 1)) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "X509 not found", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "";
		}
		
		try {
			request.login("CLIENT-CERTIFICATE", certs.toString());
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
	
	public String getUserPrincipalName() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		Principal principal = request.getUserPrincipal();
		if (principal != null) {
			return principal.getName();
		} else {
			return null;
		}
	}

}
