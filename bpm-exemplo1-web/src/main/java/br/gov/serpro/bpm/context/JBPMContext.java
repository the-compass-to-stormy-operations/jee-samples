package br.gov.serpro.bpm.context;

import javax.persistence.EntityManagerFactory;

import org.drools.KnowledgeBase;
import org.drools.runtime.Environment;
import org.drools.runtime.StatefulKnowledgeSession;

public interface JBPMContext extends BPMContext<StatefulKnowledgeSession>{

	public abstract void initialize(EntityManagerFactory emf);

	public abstract KnowledgeBase getKnowledgeBase();

	public abstract Environment getEnvironment();

	public abstract void registerHandlers();

	public abstract StatefulKnowledgeSession getEngine();

}