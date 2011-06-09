import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.bpmn.diagram.ProcessDiagramGenerator;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.ProcessDefinition;


public class PNG {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ProcessEngine engine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
			.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
			.setJdbcDriver("org.postgresql.Driver")
			.setJdbcUrl("jdbc:postgresql://framework.cta.serpro/bpm-exemplo1-db")
			.setJdbcUsername("bpm")
			.setJdbcPassword("bpm")
			.setJobExecutorActivate(false)
			.buildProcessEngine();
		
		ProcessDefinition pd = engine.getRepositoryService().createProcessDefinitionQuery()
			.processDefinitionKey("SampleProcess001")
			.latestVersion()
			.singleResult();
		
		System.out.println(pd);
		
		InputStream is = ProcessDiagramGenerator.generateJpgDiagram((ProcessDefinitionEntity)pd);
		
		OutputStream os = new FileOutputStream("~/teste.png");
		
 
		int read=0;
		byte[] bytes = new byte[1024];
 
		while((read = is.read(bytes))!= -1){
			os.write(bytes, 0, read);
		}
 
		is.close();
		os.flush();
		os.close();	

		
	}

}
