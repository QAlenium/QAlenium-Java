package br.com.empresa.almintegration.alm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.empresa.almintegration.alm.infrastructure.Entity;
import br.com.empresa.almintegration.alm.infrastructure.Entity.Fields.Field;

public class RunStep extends ALMModels{

	private List<Entity> fields = null;
	private final String type = "run-step";
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	public String currentStepId;
	public static enum FIELDS implements IALMFields{
		COMPONENT_DATA,     STEP_ID,     STATUS,      DESSTEP_ID, 
		EXECUTION_DATE,     ATTACHMENT, LINE_NO,     TEST_ID, 
		EXTENDED_REFERENCE, REL_OBJ_ID, PARENT_ID,   EXPECTED, 
		BPTA_CONDITION,     LEVEL,      DESCRIPTION, NAME, 
		HAS_LINKAGE,        PATH,       ACTUAL,      EXECUTION_TIME, 
		STEP_ORDER, ATTACHMENT_LABEL, DESSTEP_ID_LABEL;
		String value;	
	}
		
	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RunStep() {
	}

	/**
	 *
	 * @param type
	 * @param fields
	 */
	public RunStep(Entity entity) {
		super();
		populateFields(entity);
	}
	
	public void populateFields(Entity entity){

		for (FIELDS runField : FIELDS.values()) {
			String propertyName = "RUN_STEP_" + FIELDS.class.getSimpleName() + UNDERSCORE + runField.name();
			String fieldName = properties.getProperty(propertyName, propertyName);
			for (Field field : entity.getFields().getField()) {
				if (field.getName().equals(fieldName)) {
					String value = field.getValue().toString().replace("[", "").replace("]", "");
					runField.value = value;
					if(runField.equals(FIELDS.STEP_ID)) this.currentStepId = value;
					break;
				}
			}
		}
	}
	
	public String getField(RunStep.FIELDS field){
		for (RunStep.FIELDS fields : RunStep.FIELDS.values()){
			if (fields.equals(field))
				return fields.value;
		}
		return null;
	}
	
	public void setField(IALMFields field, String value){
		for (RunStep.FIELDS fields : RunStep.FIELDS.values()) {
			if (fields.equals(field)) 
				fields.value = value;
		}
	}

	public List<Entity> getFields() {
		return fields;
	}

	public void setFields(List<Entity> fields) {
		this.fields = fields;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(fields).append(type).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof RunStep) == false) {
			return false;
		}
		RunStep rhs = ((RunStep) other);
		return new EqualsBuilder().append(fields, rhs.fields).append(type, rhs.type)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}
}