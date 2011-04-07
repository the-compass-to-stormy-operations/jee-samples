package tirando.onda.jee.exemplo.jsf.view.managedbean;

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
		System.out.println("Executou Ajax");
		return "";
	}

}
