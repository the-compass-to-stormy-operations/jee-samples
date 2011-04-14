package tirando.onda.jee.exemplo.jsf.view;

public class SampleController {
	
	private SampleModel model = new SampleModel();
		
	public SampleController() {}

	public SampleModel getModel() {
		return model;
	}

	public void setModel(SampleModel model) {
		this.model = model;
	}

	public String execute() {
		System.out.println(model.toString());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "sample";
	}

}
