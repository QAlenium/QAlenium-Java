package br.com.empresa.almintegration.alm.model;

import br.com.empresa.almintegration.alm.infrastructure.Entity;
import br.com.empresa.almintegration.alm.infrastructure.Entity.Fields.Field;

public class Run extends ALMModels{

	public static enum FIELDS implements IALMFields{
		TEST_INSTANCE, EXECUTION_DATE,  STATE,                ID,                  VER_STAMP, 
		OS_CONFIG,     TEST_CONFIG_ID,  NAME,                 HAS_LINKAGE,         PATH, 
		VC_STATUS,     PINNED_BASELINE, VC_VERSION_NUMBER,    OS_BUILD,            TESTCYCL_ID, 
		CYCLE_ID,      CYCLE,           HOST,                 ASSIGN_RCYC,         LAST_MODIFIED, 
		STATUS,        OS_NAME,         ATTACHMENT,           ITERS_PARAMS_VALUES, TEST_ID, 
		SUBTYPE_ID,    DRAFT,           ITERS_SUM_STATUS,     DURATION,            BPT_STRUCTURE, 
		OWNER,         TEXT_SYNC,       BPTA_CHANGE_DETECTED, EXECUTION_TIME,      BPTA_CHANGE_AWARENESS, 
		VC_LOCKED_BY,  COMMENTS,        OS_SP;
		String value;
	}
	
	public Run(Entity entity){
		populateFields(entity);
	}
	
	public void populateFields(Entity entity){
		for (FIELDS runField : FIELDS.values()) {
			String propertyName = (this.getClass().getSimpleName() + UNDERSCORE + FIELDS.class.getSimpleName() + UNDERSCORE + runField.name()).toUpperCase();
			String fieldName = properties.getProperty(propertyName, propertyName);
			for (Field field : entity.getFields().getField()) {
				if (field.getName().equals(fieldName)) {
					runField.value = field.getValue().toString().replace("[", "").replace("]", "");
					break;
				}
			}
		}
	}

	public String getField(Run.FIELDS field) {
		for (Run.FIELDS fields : Run.FIELDS.values())
			if (fields.equals(field))
				return fields.value;
		return null;
	}
}
