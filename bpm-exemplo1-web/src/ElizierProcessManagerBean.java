package tirando.onda.jee.bpm.exemplo1.web.faces.managedbean;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

import br.gov.serpro.bpm.client.IProcessDefinition;
import br.gov.serpro.bpm.client.ITask;
import br.gov.serpro.bpm.context.BPMContext;
import br.gov.serpro.bpm.context.BPMContextFactory;

public class ElizierProcessManagerBean {
	
	public IProcessDefinition selectedProcessDefinition;
	                         
	private BPMContext<ProcessEngine> ctx = BPMContextFactory.getInstance();
	
	public IProcessDefinition getSelectedProcessDefinition() {
		return selectedProcessDefinition;
	}

	public void setSelectedProcessDefinition(IProcessDefinition selectedProcessDefinition) {
		this.selectedProcessDefinition = selectedProcessDefinition;		
	}

	public DataModel getProcessDefinition() {		
		return new ListDataModel(ctx.listProcessDefinitions());
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
		if (selectedProcessDefinition == null) {
			return new ListDataModel();
		}
		
		return new ListDataModel(ctx.listTasksForProcess(selectedProcessDefinition));
	}
	
	public String startProcess() {
		ctx.start(selectedProcessDefinition.getId());
		
		return "process-manager";
	}


}