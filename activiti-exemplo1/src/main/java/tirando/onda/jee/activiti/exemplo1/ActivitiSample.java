package tirando.onda.jee.activiti.exemplo1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;

public class ActivitiSample {
	
	public static void main(String[] args) {
		ProcessEngine engine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
		  .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
		  .setJdbcDriver("org.h2.Driver")
		  .setJdbcUrl("jdbc:h2:tcp://localhost/~/Java/h2/database/activiti")
		  .setJdbcUsername("sa")
		  .setJdbcPassword("")
		  .setJobExecutorActivate(false)
		  .buildProcessEngine();

		RepositoryService repositoryService = engine.getRepositoryService();
//		repositoryService.createDeployment()
//			.name("repo1")
//			.addClasspathResource("sample.bpmn20.xml")
//			.deploy();

		System.out.println(repositoryService.createDeploymentQuery().count());

//		engine.getRuntimeService().startProcessInstanceByKey("com.sample.bpmn.hello");
		
		System.out.println(engine.getRuntimeService().createExecutionQuery().count());
		
//		engine.getRuntimeService().signal(executionId)

		
	}

}
