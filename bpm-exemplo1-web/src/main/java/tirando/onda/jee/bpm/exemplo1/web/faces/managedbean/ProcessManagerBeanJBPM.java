package tirando.onda.jee.bpm.exemplo1.web.faces.managedbean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.drools.definition.process.Process;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.drools.runtime.process.WorkItem;

import br.gov.serpro.bpm.context.BPMContext;
import br.gov.serpro.bpm.context.JBPMContext;


public class ProcessManagerBeanJBPM {
	
	private BPMContext<StatefulKnowledgeSession> ctx = new JBPMContext();
	
	private Process selectedProcessDefinition;

	private ProcessInstance selectedProcessInstance;
	
	private WorkItem selectedTask;
	
	public DataModel getProcessDefinition() {
		Collection<Process> processess = ctx.getEngine().getKnowledgeBase().getProcesses();
		List<Process> list = new ArrayList<Process>();
		list.addAll(processess);
		return new ListDataModel(list);
	}
	
	public void startProcess() {
		this.ctx.getEngine().startProcess(this.selectedProcessDefinition.getId());
	}
	
	public DataModel getProcessInstance() {
		if (selectedProcessDefinition == null) {
			return new ListDataModel();
		}
		List<ProcessInstance> list = new ArrayList<ProcessInstance>();
		Collection<ProcessInstance> result = this.ctx.getEngine().getProcessInstances();
		list.addAll(result);
		return new ListDataModel(list);
	}
	
	public DataModel getTask() {
		if (selectedProcessInstance == null) {
			return new ListDataModel();
		}

		return new ListDataModel(JBPMContext.workItem);
	}
	
	public void completeTask() {
		this.ctx.getEngine().getWorkItemManager().completeWorkItem(selectedTask.getId(), null);
	}
	
	public Process getSelectedProcessDefinition() {
		return selectedProcessDefinition;
	}

	public void setSelectedProcessDefinition(Process selectedProcessDefinition) {
		this.selectedProcessDefinition = selectedProcessDefinition;
	}

	public ProcessInstance getSelectedProcessInstance() {
		return selectedProcessInstance;
	}

	public void setSelectedProcessInstance(ProcessInstance selectedProcessInstance) {
		this.selectedProcessInstance = selectedProcessInstance;
	}

	public WorkItem getSelectedTask() {
		return selectedTask;
	}

	public void setSelectedTask(WorkItem selectedTask) {
		this.selectedTask = selectedTask;
	}
	
}
