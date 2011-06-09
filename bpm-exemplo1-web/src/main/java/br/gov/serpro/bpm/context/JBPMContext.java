package br.gov.serpro.bpm.context;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;

public class JBPMContext implements BPMContext<StatefulKnowledgeSession> {

	
	private static StatefulKnowledgeSession ksession;
	public static List<WorkItem> workItem = new ArrayList<WorkItem>();
	
	static {
		
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("SampleProcess001.bpmn20.xml"), ResourceType.BPMN2);
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();

		ksession = kbase.newStatefulKnowledgeSession();
		
		ksession.getWorkItemManager().registerWorkItemHandler("Human Task", new DemoiselleWorkItemHandler());
		

	}

	public StatefulKnowledgeSession getEngine() {
		return ksession;
	}
	
}
