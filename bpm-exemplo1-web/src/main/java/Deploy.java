import br.gov.serpro.bpm.context.ActivitiContext;


public class Deploy {

	public static void main(String[] args) {
		ActivitiContext ctx = new ActivitiContext();
		ctx.getEngine().getRepositoryService().createDeployment().addClasspathResource("sampleprocess001.bpmn20.xml").deploy();
		
	}

}
