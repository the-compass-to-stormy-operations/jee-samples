package tirando.onda.jee.exemplo.jsf.view.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class TesteMB {
	
	private String field;
		
	public TesteMB() {}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public String executar() {
		System.out.println("Executou");
		return "";
	}
	
	public String executarAjax() {
		System.out.println("Executou Ajax...");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem 1", "Detalhe da Mensagem 1"));
		return "";
	}

}
