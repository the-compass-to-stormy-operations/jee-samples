import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class Deploy {

	public static void main(String[] args) {
		ProcessEngine engine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
			.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
			.setJdbcDriver("org.postgresql.Driver")
			.setJdbcUrl("jdbc:postgresql://framework.cta.serpro/bpm-exemplo1-db")
			.setJdbcUsername("bpm")
			.setJdbcPassword("bpm")
			.setJobExecutorActivate(false)
			.buildProcessEngine();
		
		engine.getRepositoryService().createDeployment()
			.name("SampleProcessDeployment")
			.addClasspathResource("SampleProcess001.bpmn20.xml")
			.deploy();
	}

}
