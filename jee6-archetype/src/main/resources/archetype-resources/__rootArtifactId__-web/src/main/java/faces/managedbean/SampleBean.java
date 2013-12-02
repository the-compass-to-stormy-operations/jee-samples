#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.faces.managedbean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import ${package}.dto.SampleDTO1;
import ${package}.facade.SampleFacade1;

public class SampleBean {
	
	private String textField;
	private Date dateField;
	private Integer choiceField = -1;
	private BigDecimal decimalField;
	
	private Collection<SelectItem> choiceFieldValues = new ArrayList<SelectItem>();
	
	@EJB
	private SampleFacade1 sampleFacade1;
	
	public SampleBean() {
		choiceFieldValues.add(new SelectItem(-1,""));
		choiceFieldValues.add(new SelectItem(1,"value1"));
		choiceFieldValues.add(new SelectItem(2,"value2"));
		choiceFieldValues.add(new SelectItem(3,"value3"));
		choiceFieldValues.add(new SelectItem(4,"value4"));
		
		decimalField = new BigDecimal("1155.37");
		decimalField.setScale(2);
		decimalField = decimalField.add(new BigDecimal("0.5231"));
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
	
	public Collection<SelectItem> getChoiceFieldValues() {
		return choiceFieldValues;
	}

	public void setChoiceFieldValues(Collection<SelectItem> choiceFieldValues) {
		this.choiceFieldValues = choiceFieldValues;
	}

	public String execute1() {
		System.out.println(this.toString());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sampleFacade1.sampleMethod1(new SampleDTO1());
		return "sample";
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextField:");
		builder.append(textField);
		builder.append(",DateField:");
		builder.append(dateField);
		builder.append(",ChoiceField:");
		builder.append(choiceField);
		builder.append(",decimalField:");
		builder.append(decimalField);

		return builder.toString();
	}
	
}
