package tirando.onda.jee.bpm.exemplo1.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_sampleentity1")
@SequenceGenerator(name="SampleEntity1Sequence", sequenceName="sq_sampleentity1")
public class SampleEntity1 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="SampleEntity1Sequence", strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String textField;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateField;
	
	@Column
	private Integer choiceField;
	
	@Column
	private BigDecimal decimalField;
	
	public SampleEntity1() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}

	public Date getDateField() {
		return dateField;
	}

	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}

	public Integer getChoiceField() {
		return choiceField;
	}

	public void setChoiceField(Integer choiceField) {
		this.choiceField = choiceField;
	}

	public BigDecimal getDecimalField() {
		return decimalField;
	}

	public void setDecimalField(BigDecimal decimalField) {
		this.decimalField = decimalField;
	}
	
}
