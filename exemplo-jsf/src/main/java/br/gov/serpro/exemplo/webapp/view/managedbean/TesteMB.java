package br.gov.serpro.exemplo.webapp.view.managedbean;

import java.util.Date;

public class TesteMB {
	
	private String field;
//	private FacesContext ctx = FacesContext.getCurrentInstance();
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
//	public String getId() {
//		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
//		return request.getParameter("javax.faces.ViewState");
//	}
	
	public String executar() {
//		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste de Mensagem", "");
//		ctx.addMessage(null, msg);
//		
		System.out.println("executou "+field);
//		if (field.equals("xyz")) {
//			return "default";
//		} else {
			return "";
//		}
	}
	
	public String executarAjax() {
		System.out.println("Executou Ajax");
		field = new Date().toString();
		return "";
	}

}
