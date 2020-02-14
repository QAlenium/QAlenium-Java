package br.com.empresa.almintegration.alm.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import br.com.empresa.almintegration.alm.infrastructure.Entity;
import br.com.empresa.almintegration.alm.infrastructure.Entity.Fields.Field;

public class TestInstance {

	private List<Entity> fields = null;
	private String type;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	private static final String ASSIGN_RCYC_LABEL = "assign-rcyc";
	private static final String TEST_INSTANCE_NAME_LABEL = "test-instance-name";
	private static final String TEST_INSTANCE_LABEL = "test-instance";
	private static final String PLAN_SCHEDULING_TIME_LABEL = "plan-scheduling-time";
	private static final String PLAN_SCHEDULING_DATE_LABEL = "plan-scheduling-date";
	private static final String VER_STAMP_LABEL = "ver-stamp";
	private static final String CYCLE_ID_LABEL = "cycle-id";
	private static final String CYCLE_LABEL = "cycle";
	private static final String STATUS_LABEL = "status";
	private static final String ITERATIONS_LABEL = "iterations";
	private static final String TEST_ID_LABEL = "test-id";
	private static final String OWNER_LABEL = "owner";
	private static final String ID_LABEL = "id";
	private static final String HOST_NAME_LABEL = "host-name";
	private static final String TEST_CONFIG_ID_LABEL = "test-config-id";
	private static final String EXEC_DATE_LABEL = "exec-date";
	private static final String LAST_MODIFIED_LABEL = "last-modified";
	private static final String EXEC_TIME_LABEL = "exec-time";
	private static final String ATTACHMENT_LABEL = "attachment";
	private static final String SUBTYPE_ID_LABEL = "subtype-id";
	private static final String TEST_ORDER_LABEL = "test-order";

	private String assignRcyc;
	private String testInstanceName;
	private String testInstance;
	private String planSchedulingTime;
	private String planSchedulingDate;
	private String verStamp;
	private String cycleID;
	private String cycle;
	private String status;
	private String iterations;
	private String testID;
	private String owner;
	private String id;
	private String hostName;
	private String testConfigID;
	private String execDate;
	private String lastModified;
	private String execTime;
	private String attachment;
	private String subtypeId;
	private String testOrder;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public TestInstance() {
	}

	/**
	 *
	 * @param type
	 * @param fields
	 */
	public TestInstance(List<Entity> fields, String type) {
		super();

		List<Field> fieldsList = fields.get(0).getFields().getField();
		for (Iterator<Field> iterator = fieldsList.iterator(); iterator.hasNext();) {
			Field field = (Field) iterator.next();
			String value = field.getValue().toString();
			value = value.substring(1, value.length() - 1);

			if(field.getName().equals(ASSIGN_RCYC_LABEL)) assignRcyc = value;
			else if(field.getName().equals(TEST_INSTANCE_NAME_LABEL)) testInstanceName = value;
			else if(field.getName().equals(TEST_INSTANCE_LABEL)) testInstance = value;
			else if(field.getName().equals(PLAN_SCHEDULING_TIME_LABEL)) planSchedulingTime = value;
			else if(field.getName().equals(PLAN_SCHEDULING_DATE_LABEL)) planSchedulingDate = value;
			else if(field.getName().equals(VER_STAMP_LABEL)) verStamp = value;
			else if(field.getName().equals(CYCLE_ID_LABEL)) cycleID = value;
			else if(field.getName().equals(CYCLE_LABEL)) cycle = value;
			else if(field.getName().equals(STATUS_LABEL)) status = value;
			else if(field.getName().equals(ITERATIONS_LABEL)) iterations = value;
			else if(field.getName().equals(TEST_ID_LABEL)) testID = value;
			else if(field.getName().equals(OWNER_LABEL)) owner = value;
			else if(field.getName().equals(ID_LABEL)) id = value;
			else if(field.getName().equals(HOST_NAME_LABEL)) hostName = value;
			else if(field.getName().equals(TEST_CONFIG_ID_LABEL)) testConfigID = value;
			else if(field.getName().equals(EXEC_DATE_LABEL)) execDate = value;
			else if(field.getName().equals(LAST_MODIFIED_LABEL)) lastModified = value;
			else if(field.getName().equals(EXEC_TIME_LABEL)) execTime = value;
			else if(field.getName().equals(ATTACHMENT_LABEL)) attachment = value;
			else if(field.getName().equals(SUBTYPE_ID_LABEL)) subtypeId = value;
			else if(field.getName().equals(TEST_ORDER_LABEL)) testOrder = value;
		}

		this.fields = fields;
		this.type = type;
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

	public void setType(String type) {
		this.type = type;
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
		if ((other instanceof TestInstance) == false) {
			return false;
		}
		TestInstance rhs = ((TestInstance) other);
		return new EqualsBuilder().append(fields, rhs.fields).append(type, rhs.type)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

	/**
	 * @return the testInstance
	 */
	public String getTestInstance() {
		return testInstance;
	}

	/**
	 * @return the planSchedulingTime
	 */
	public String getPlanSchedulingTime() {
		return planSchedulingTime;
	}

	/**
	 * @return the planSchedulingDate
	 */
	public String getPlanSchedulingDate() {
		return planSchedulingDate;
	}

	/**
	 * @return the verStamp
	 */
	public String getVerStamp() {
		return verStamp;
	}

	/**
	 * @return the cycleID
	 */
	public String getCycleID() {
		return cycleID;
	}

	/**
	 * @return the cycle
	 */
	public String getCycle() {
		return cycle;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the iterations
	 */
	public String getIterations() {
		return iterations;
	}

	/**
	 * @return the testID
	 */
	public String getTestID() {
		return testID;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @return the testConfigID
	 */
	public String getTestConfigID() {
		return testConfigID;
	}

	/**
	 * @return the execDate
	 */
	public String getExecDate() {
		return execDate;
	}

	/**
	 * @return the lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}

	/**
	 * @return the execTime
	 */
	public String getExecTime() {
		return execTime;
	}

	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * @return the subtypeId
	 */
	public String getSubtypeId() {
		return subtypeId;
	}

	/**
	 * @return the testOrder
	 */
	public String getTestOrder() {
		return testOrder;
	}

	public String getTestInstanceName() {
		return testInstanceName;
	}

	public void setTestInstanceName(String testInstanceName) {
		this.testInstanceName = testInstanceName;
	}

	public String getAssignRcyc() {
		return assignRcyc;
	}

	public void setAssignRcyc(String assignRcyc) {
		this.assignRcyc = assignRcyc;
	}
	
}