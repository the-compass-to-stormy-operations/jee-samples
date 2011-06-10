package br.gov.serpro.bpm.context;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

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

public class JBPMContext implements BPMContext<StatefulKnowledgeSession> {

	private static StatefulKnowledgeSession ksession;
	public static List<WorkItem> workItem = new ArrayList<WorkItem>();
	
	static {
		InitialContext ctx = null;
		EntityManagerFactory emf = null;
		try {
			ctx = new InitialContext();
			emf = (EntityManagerFactory) ctx.lookup("java:comp/JBPMPU");
		} catch (NamingException e) {
			throw new RuntimeException("NUM DEU",e);
		}
		
		
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("SampleProcess001.bpmn20.xml"), ResourceType.BPMN2);
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		
		Environment env = KnowledgeBaseFactory.newEnvironment();
		env.set(EnvironmentName.ENTITY_MANAGER_FACTORY, emf);
		
		ksession = JPAKnowledgeService.newStatefulKnowledgeSession(kbase, null, env);
		
		ksession.getWorkItemManager().registerWorkItemHandler("Human Task", new DemoiselleWorkItemHandler());

	}

	public StatefulKnowledgeSession getEngine() {
		return ksession;
	}
	
}
