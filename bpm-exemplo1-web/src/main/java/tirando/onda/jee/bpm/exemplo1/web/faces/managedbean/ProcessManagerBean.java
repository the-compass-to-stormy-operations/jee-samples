package tirando.onda.jee.bpm.exemplo1.web.faces.managedbean;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class ProcessManagerBean {
	
	public ProcessDefinition selectedProcessDefinition;
	                         
	private static ProcessEngine engine = ProcessEngineConfiguration
		.createStandaloneProcessEngineConfiguration()
		.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
		.setJdbcDriver("org.h2.Driver")
		.setJdbcUrl("jdbc:h2:tcp://localhost/~/Java/activiti-5.5/apps/h2/activiti")
		.setJdbcUsername("sa").setJdbcPassword("")
		.setJobExecutorActivate(false).buildProcessEngine();
	
	public ProcessDefinition getSelectedProcessDefinition() {
		return selectedProcessDefinition;
	}

	public void setSelectedProcessDefinition(ProcessDefinition selectedProcessDefinition) {
		this.selectedProcessDefinition = selectedProcessDefinition;
	}

	public DataModel getProcessDefinition() {
		List<ProcessDefinition> list = engine.getRepositoryService().createProcessDefinitionQuery()
			.list();
		
		return new ListDataModel(list);
	}
	
	public DataModel getProcessInstance() {
		if (selectedProcessDefinition == null) {
			return new ListDataModel();
		}
		
		List<ProcessInstance> list = engine.getRuntimeService().createProcessInstanceQuery()
			.processDefinitionId(selectedProcessDefinition.getId())
			.list();
		
		return new ListDataModel(list);
	}
	
	public DataModel getTask() {
		if (selectedProcessDefinition == null) {
			return new ListDataModel();
		}

		List<Task> list = engine.getTaskService().createTaskQuery()
			.processDefinitionId(selectedProcessDefinition.getId())
			.list();
		
		return new ListDataModel(list);
	}
	
	public String startProcess() {
		engine.getRuntimeService().startProcessInstanceById(selectedProcessDefinition.getId());
		return "process-manager";
	}


}
