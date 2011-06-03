package tirando.onda.jee.bpm.exemplo1.web.faces.managedbean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import br.gov.serpro.bpm.context.ActivitiContext;
import br.gov.serpro.bpm.context.BPMContext;


public class ProcessManagerBean {
	
	private FacesContext facesContext = FacesContext.getCurrentInstance();
	
	private ProcessDefinition selectedProcessDefinition;
	private ProcessInstance selectedProcessInstance;
	private Task selectedTask;
	                         
	private BPMContext<ProcessEngine> ctx = new ActivitiContext();
	
	public ProcessDefinition getSelectedProcessDefinition() {
		return selectedProcessDefinition;
	}

	public void setSelectedProcessDefinition(ProcessDefinition selectedProcessDefinition) {
		this.selectedProcessDefinition = selectedProcessDefinition;
	}

	public ProcessInstance getSelectedProcessInstance() {
		return selectedProcessInstance;
	}

	public void setSelectedProcessInstance(ProcessInstance selectedProcessInstance) {
		this.selectedProcessInstance = selectedProcessInstance;
	}

	public Task getSelectedTask() {
		return selectedTask;
	}

	public void setSelectedTask(Task selectedTask) {
		this.selectedTask = selectedTask;
	}

	public DataModel getProcessDefinition() {
		List<ProcessDefinition> list = ctx.getEngine().getRepositoryService().createProcessDefinitionQuery()
			.list();
		
		return new ListDataModel(list);
	}
	
	public DataModel getProcessInstance() {
		if (selectedProcessDefinition == null) {
			return new ListDataModel();
		}
		
		List<ProcessInstance> list = ctx.getEngine().getRuntimeService().createProcessInstanceQuery()
			.processDefinitionId(selectedProcessDefinition.getId())
			.list();
		
		return new ListDataModel(list);
	}
	
	public DataModel getTask() {
		if (selectedProcessInstance == null) {
			return new ListDataModel();
		}

		List<Task> list = ctx.getEngine().getTaskService().createTaskQuery()
			.processInstanceId(selectedProcessInstance.getId())
			.list();
		
		return new ListDataModel(list);
	}
	
	public void startProcess() {
		ctx.getEngine().getRuntimeService().startProcessInstanceById(selectedProcessDefinition.getId());
	}
	
	public void claimTask() {
		ctx.getEngine().getTaskService().claim(selectedTask.getId(), "admin" /*facesContext.getExternalContext().getUserPrincipal().getName()*/);
		
	}
	
	public void completeTask() {
		ctx.getEngine().getTaskService().complete(selectedTask.getId());
	}
	
}
