package tirando.onda.jee.bpm.exemplo1.web.faces.managedbean;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.activiti.engine.ProcessEngine;

import br.gov.serpro.bpm.context.ActivitiContext;

import tirando.onda.jee.bpm.exemplo1.web.entity.SampleEntity1;

public class SampleBean1 {
	
	@PersistenceContext
	private EntityManager em;
	private Long sampleEntity1Id;
	private SampleEntity1 sampleEntity1;
	private Collection<SelectItem> choiceFieldValues = new ArrayList<SelectItem>();
	
	public SampleBean1() {
		choiceFieldValues.add(new SelectItem(-1,""));
		choiceFieldValues.add(new SelectItem(1,"value1"));
		choiceFieldValues.add(new SelectItem(2,"value2"));
		choiceFieldValues.add(new SelectItem(3,"value3"));
		choiceFieldValues.add(new SelectItem(4,"value4"));
	}
	
	public Long getSampleEntity1Id() {
		return sampleEntity1Id;
	}

	public void setSampleEntity1Id(Long sampleEntity1Id) {
		this.sampleEntity1Id = sampleEntity1Id;
	}

	public SampleEntity1 getSampleEntity1() {
		if (sampleEntity1 == null) {
			sampleEntity1 = new SampleEntity1();
		}
		return sampleEntity1;
	}

	public Collection<SelectItem> getChoiceFieldValues() {
		return choiceFieldValues;
	}

	public void setChoiceFieldValues(Collection<SelectItem> choiceFieldValues) {
		this.choiceFieldValues = choiceFieldValues;
	}
	
	public DataModel getSampleEntity1List() {
		return new ListDataModel(em.createQuery("from SampleEntity1 o").getResultList());
	}
	
	public String create() {
		sampleEntity1Id = null;
		return "sample1-edit";
	}
	
	public String save() {
		em.persist(sampleEntity1);
		
		ProcessEngine engine = new ActivitiContext().getEngine();
		engine.getRuntimeService().startProcessInstanceByKey("SampleProcess001","SampleEntity1_"+sampleEntity1.getId());
		
		return "sample1-list";
	}

	public String cancel() {
		return "sample1-list";
	}

}
