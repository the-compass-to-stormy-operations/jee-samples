package br.gov.serpro.bpm.context;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class ActivitiContext implements BPMContext<ProcessEngine> {
	
	private static ProcessEngine engine = ProcessEngineConfiguration
		.createStandaloneProcessEngineConfiguration()
		.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
		.setJdbcDriver("org.postgresql.Driver")
		.setJdbcUrl("jdbc:postgresql://framework.cta.serpro/bpm-exemplo1-db")
		.setJdbcUsername("bpm")
		.setJdbcPassword("bpm")
		.setJobExecutorActivate(false).buildProcessEngine();

	public ProcessEngine getEngine() {
		return engine;
	}

}
