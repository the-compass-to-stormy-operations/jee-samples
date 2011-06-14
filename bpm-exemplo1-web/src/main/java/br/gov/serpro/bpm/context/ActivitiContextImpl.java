package br.gov.serpro.bpm.context;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class ActivitiContextImpl implements ActivitiContext {
	
	private static ProcessEngine engine;
	
	static {
		ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		cfg.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		cfg.setDataSourceJndiName("java:BPMExemplo1DS");
		cfg.setTransactionsExternallyManaged(true);
		engine = cfg.buildProcessEngine();
		
		//TODO implementar carregamento via JPA
	}

	public ProcessEngine getEngine() {
		return engine;
	}
	
}
