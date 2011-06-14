package br.gov.serpro.bpm.context;

import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;

public class DemoiselleWorkItemHandler implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		JBPMContextImpl.workItem.add(workItem);
		
		System.out.println("Executando item ...");

	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		System.out.println("Abortando item ...");

	}

}
