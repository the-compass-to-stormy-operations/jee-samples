package br.gov.serpro.bpm.context;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.persistence.jpa.JPAKnowledgeService;
import org.drools.runtime.Environment;
import org.drools.runtime.EnvironmentName;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;

public class JBPMContextImpl implements JBPMContext {

	private StatefulKnowledgeSession ksession;
	public static List<WorkItem> workItem = new ArrayList<WorkItem>();
	private EntityManagerFactory emf = null;
	
	private static JBPMContextImpl instance;
	
	public static JBPMContextImpl getInstance(EntityManagerFactory emf) {
		if (JBPMContextImpl.instance == null) {
			JBPMContextImpl.instance = new JBPMContextImpl();
			JBPMContextImpl.instance.initialize(emf);
		}
		return JBPMContextImpl.instance;
	}
	
	private JBPMContextImpl() {
		
	}
	
	public synchronized void initialize(EntityManagerFactory emf) {
		
		this.emf = emf;
		
		Environment env = this.getEnvironment();
		
		KnowledgeBase kbase = this.getKnowledgeBase();
		
		ksession = JPAKnowledgeService.newStatefulKnowledgeSession(kbase, null, env);
		
		this.registerHandlers();
	}
	
	public KnowledgeBase getKnowledgeBase() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("SampleProcess001.bpmn20.xml"), ResourceType.BPMN2);
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		return kbase;
	}
	
	public Environment getEnvironment() {
		Environment env = KnowledgeBaseFactory.newEnvironment();
		env.set(EnvironmentName.ENTITY_MANAGER_FACTORY, this.emf);
		return env;
	}
	
	public void registerHandlers() {
		if (this.getEngine() == null)
			return;
		
		this.getEngine().getWorkItemManager().registerWorkItemHandler("Human Task", new DemoiselleWorkItemHandler());
	}

	public StatefulKnowledgeSession getEngine() {
		return ksession;
	}
	
}
