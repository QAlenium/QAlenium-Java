package br.com.empresa.almintegration.alm.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import br.com.empresa.almintegration.constants.ViewConstants;
import br.com.empresa.almintegration.alm.infrastructure.Entity;
import br.com.empresa.almintegration.alm.infrastructure.Entity.Fields.Field;

public class Defect {

	private List<Entity> fields = null;
	private String type;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	private static final String INCIDENT_REOPENED = "user-03";
	private static final String SISTEMAS = "user-02";
	private static final String HAS_CHANGE = "has-change";
	private static final String ORIGEM = "user-01";
	private static final String PLANNED_CLOSING_VER = "planned-closing-ver";
	private static final String TEST_REFERENCE = "test-reference";
	private static final String SUBJECT = "subject";
	private static final String REPRODUCIBLE = "reproducible";
	private static final String REQUEST_ID = "request-id";
	private static final String MANAGEMENT = "user-template-01";
	private static final String REQUEST_SERVER = "request-server";
	private static final String SOFTWARE_FACTORY = "user-template-04";
	private static final String ID = "id";
	private static final String VER_STAMP = "ver-stamp";
	private static final String HAS_OTHERS_LINKAGE = "has-others-linkage";
	private static final String DESCRIPTION = "description";
	private static final String PRIORITY = "priority";
	private static final String NAME = "name";
	private static final String HAS_LINKAGE = "has-linkage";
	private static final String RUN_REFERENCE = "run-reference";
	private static final String CYCLE_REFERENCE = "cycle-reference";
	private static final String DEV_COMMENTS = "dev-comments";
	private static final String CREATION_TIME = "creation-time";
	private static final String TO_MAIL = "to-mail";
	private static final String CLOSING_VERSION = "closing-version";
	private static final String REQUEST_NOTE = "request-note";
	private static final String CYCLE_ID = "cycle-id";
	private static final String DETECTION_VERSION = "detection-version";
	private static final String LAST_MODIFIED = "last-modified";
	private static final String STATUS = "status";
	private static final String CLOSING_DATE = "closing-date";
	private static final String DETECTED_IN_RCYC = "detected-in-rcyc";
	private static final String DETECTED_IN_REL = "detected-in-rel";
	private static final String SEVERITY = "severity";
	private static final String ATTACHMENT = "attachment";
	private static final String EXTENDED_REFERENCE = "extended-reference";
	private static final String ESTIMATED_FIX_TIME = "estimated-fix-time";
	private static final String PROJECT = "project";
	private static final String TARGET_REL = "target-rel";
	private static final String DETECTED_BY = "detected-by";
	private static final String STEP_REFERENCE = "step-reference";
	private static final String OWNER = "owner";
	private static final String TARGET_RCYC = "target-rcyc";
	private static final String ACTUAL_FIX_TIME = "actual-fix-time";
	private static final String REQUEST_TYPE = "request-type";

	private String incidentReopened;
	private String sistemas;
	private String hasChange;
	private String origem;
	private String plannedClosingVer;
	private String testReference;
	private String subject;
	private String reproducible;
	private String requestId;
	private String management;
	private String requestServer;
	private String softwareFactory;
	private String id;
	private String verStamp;
	private String hasOthersLinkage;
	private String description;
	private String priority;
	private String name;
	private String hasLinkage;
	private String runReference;
	private String cycleReference;
	private String devComments;
	private String creationTime;
	private String toMail;
	private String closingVersion;
	private String requestNote;
	private String cycleId;
	private String detectionVersion;
	private String lastModified;
	private String status;
	private String closingDate;
	private String detectedInRcyc;
	private String detectedInRel;
	private String severity;
	private String attachment;
	private String extendedReference;
	private String estimatedFixTime;
	private String project;
	private String targetRel;
	private String detectedBy;
	private String stepReference;
	private String owner;
	private String targetRcyc;
	private String actualFixTime;
	private String requestType;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Defect() {
	}

	/**
	 *
	 * @param type
	 * @param fields
	 */
	public Defect(List<Entity> fields) {
		super();

		List<Field> fieldsList = fields.get(0).getFields().getField();
		for (Iterator<Field> iterator = fieldsList.iterator(); iterator.hasNext();) {
			Field field = (Field) iterator.next();
			String value = field.getValue().toString();
			value = value.substring(1, value.length() - 1);
			/*switch (field.getName()) {
			case (INCIDENT_REOPENED):
				incidentReopened = value;
				break;
			case (SISTEMAS):
				sistemas = value;
				break;
			case (HAS_CHANGE):
				hasChange = value;
				break;
			case (ORIGEM):
				origem = value;
				break;
			case (PLANNED_CLOSING_VER):
				plannedClosingVer = value;
				break;
			case (TEST_REFERENCE):
				testReference = value;
				break;
			case (SUBJECT):
				subject = value;
				break;
			case (REPRODUCIBLE):
				reproducible = value;
				break;
			case (REQUEST_ID):
				requestId = value;
				break;
			case (MANAGEMENT):
				management = value;
				break;
			case (REQUEST_SERVER):
				requestServer = value;
				break;
			case (SOFTWARE_FACTORY):
				softwareFactory = value;
				break;
			case (ID):
				id = value;
				break;
			case (VER_STAMP):
				verStamp = value;
				break;
			case (HAS_OTHERS_LINKAGE):
				hasOthersLinkage = value;
				break;
			case (DESCRIPTION):
				description = value;
				break;
			case (PRIORITY):
				priority = value;
				break;
			case (NAME):
				name = value;
				break;
			case (HAS_LINKAGE):
				hasLinkage = value;
				break;
			case (RUN_REFERENCE):
				runReference = value;
				break;
			case (CYCLE_REFERENCE):
				cycleReference = value;
				break;
			case (DEV_COMMENTS):
				devComments = value;
				break;
			case (CREATION_TIME):
				creationTime = value;
				break;
			case (TO_MAIL):
				toMail = value;
				break;
			case (CLOSING_VERSION):
				closingVersion = value;
				break;
			case (REQUEST_NOTE):
				requestNote = value;
				break;
			case (CYCLE_ID):
				cycleId = value;
				break;
			case (DETECTION_VERSION):
				detectionVersion = value;
				break;
			case (LAST_MODIFIED):
				lastModified = value;
				break;
			case (STATUS):
				status = value;
				break;
			case (CLOSING_DATE):
				closingDate = value;
				break;
			case (DETECTED_IN_RCYC):
				detectedInRcyc = value;
				break;
			case (DETECTED_IN_REL):
				detectedInRel = value;
				break;
			case (SEVERITY):
				severity = value;
				break;
			case (ATTACHMENT):
				attachment = value;
				break;
			case (EXTENDED_REFERENCE):
				extendedReference = value;
				break;
			case (ESTIMATED_FIX_TIME):
				estimatedFixTime = value;
				break;
			case (PROJECT):
				project = value;
				break;
			case (TARGET_REL):
				targetRel = value;
				break;
			case (DETECTED_BY):
				detectedBy = value;
				break;
			case (STEP_REFERENCE):
				stepReference = value;
				break;
			case (OWNER):
				owner = value;
				break;
			case (TARGET_RCYC):
				targetRcyc = value;
				break;
			case (ACTUAL_FIX_TIME):
				actualFixTime = value;
				break;
			case (REQUEST_TYPE):
				requestType = value;
				break;
			default:
				break;
			}*/
		}

		this.fields = fields;
		this.type = ViewConstants.ALM.Defects.DEFECTS;
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
		if ((other instanceof Defect) == false) {
			return false;
		}
		Defect rhs = ((Defect) other);
		return new EqualsBuilder().append(fields, rhs.fields).append(type, rhs.type)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

	/**
	 * @return the incidentReopened
	 */
	public String getIncidentReopened() {
		return incidentReopened;
	}

	/**
	 * @param incidentReopened the incidentReopened to set
	 */
	public void setIncidentReopened(String incidentReopened) {
		this.incidentReopened = incidentReopened;
	}

	/**
	 * @return the sistemas
	 */
	public String getSistemas() {
		return sistemas;
	}

	/**
	 * @param sistemas the sistemas to set
	 */
	public void setSistemas(String sistemas) {
		this.sistemas = sistemas;
	}

	/**
	 * @return the hasChange
	 */
	public String getHasChange() {
		return hasChange;
	}

	/**
	 * @param hasChange the hasChange to set
	 */
	public void setHasChange(String hasChange) {
		this.hasChange = hasChange;
	}

	/**
	 * @return the origem
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * @param origem the origem to set
	 */
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	/**
	 * @return the plannedClosingVer
	 */
	public String getPlannedClosingVer() {
		return plannedClosingVer;
	}

	/**
	 * @param plannedClosingVer the plannedClosingVer to set
	 */
	public void setPlannedClosingVer(String plannedClosingVer) {
		this.plannedClosingVer = plannedClosingVer;
	}

	/**
	 * @return the testReference
	 */
	public String getTestReference() {
		return testReference;
	}

	/**
	 * @param testReference the testReference to set
	 */
	public void setTestReference(String testReference) {
		this.testReference = testReference;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the reproducible
	 */
	public String getReproducible() {
		return reproducible;
	}

	/**
	 * @param reproducible the reproducible to set
	 */
	public void setReproducible(String reproducible) {
		this.reproducible = reproducible;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the management
	 */
	public String getManagement() {
		return management;
	}

	/**
	 * @param management the management to set
	 */
	public void setManagement(String management) {
		this.management = management;
	}

	/**
	 * @return the requestServer
	 */
	public String getRequestServer() {
		return requestServer;
	}

	/**
	 * @param requestServer the requestServer to set
	 */
	public void setRequestServer(String requestServer) {
		this.requestServer = requestServer;
	}

	/**
	 * @return the softwareFactory
	 */
	public String getSoftwareFactory() {
		return softwareFactory;
	}

	/**
	 * @param softwareFactory the softwareFactory to set
	 */
	public void setSoftwareFactory(String softwareFactory) {
		this.softwareFactory = softwareFactory;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the verStamp
	 */
	public String getVerStamp() {
		return verStamp;
	}

	/**
	 * @param verStamp the verStamp to set
	 */
	public void setVerStamp(String verStamp) {
		this.verStamp = verStamp;
	}

	/**
	 * @return the hasOthersLinkage
	 */
	public String getHasOthersLinkage() {
		return hasOthersLinkage;
	}

	/**
	 * @param hasOthersLinkage the hasOthersLinkage to set
	 */
	public void setHasOthersLinkage(String hasOthersLinkage) {
		this.hasOthersLinkage = hasOthersLinkage;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hasLinkage
	 */
	public String getHasLinkage() {
		return hasLinkage;
	}

	/**
	 * @param hasLinkage the hasLinkage to set
	 */
	public void setHasLinkage(String hasLinkage) {
		this.hasLinkage = hasLinkage;
	}

	/**
	 * @return the runReference
	 */
	public String getRunReference() {
		return runReference;
	}

	/**
	 * @param runReference the runReference to set
	 */
	public void setRunReference(String runReference) {
		this.runReference = runReference;
	}

	/**
	 * @return the cycleReference
	 */
	public String getCycleReference() {
		return cycleReference;
	}

	/**
	 * @param cycleReference the cycleReference to set
	 */
	public void setCycleReference(String cycleReference) {
		this.cycleReference = cycleReference;
	}

	/**
	 * @return the devComments
	 */
	public String getDevComments() {
		return devComments;
	}

	/**
	 * @param devComments the devComments to set
	 */
	public void setDevComments(String devComments) {
		this.devComments = devComments;
	}

	/**
	 * @return the creationTime
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return the toMail
	 */
	public String getToMail() {
		return toMail;
	}

	/**
	 * @param toMail the toMail to set
	 */
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	/**
	 * @return the closingVersion
	 */
	public String getClosingVersion() {
		return closingVersion;
	}

	/**
	 * @param closingVersion the closingVersion to set
	 */
	public void setClosingVersion(String closingVersion) {
		this.closingVersion = closingVersion;
	}

	/**
	 * @return the requestNote
	 */
	public String getRequestNote() {
		return requestNote;
	}

	/**
	 * @param requestNote the requestNote to set
	 */
	public void setRequestNote(String requestNote) {
		this.requestNote = requestNote;
	}

	/**
	 * @return the cycleId
	 */
	public String getCycleId() {
		return cycleId;
	}

	/**
	 * @param cycleId the cycleId to set
	 */
	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
	}

	/**
	 * @return the detectionVersion
	 */
	public String getDetectionVersion() {
		return detectionVersion;
	}

	/**
	 * @param detectionVersion the detectionVersion to set
	 */
	public void setDetectionVersion(String detectionVersion) {
		this.detectionVersion = detectionVersion;
	}

	/**
	 * @return the lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the closingDate
	 */
	public String getClosingDate() {
		return closingDate;
	}

	/**
	 * @param closingDate the closingDate to set
	 */
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}

	/**
	 * @return the detectedInRcyc
	 */
	public String getDetectedInRcyc() {
		return detectedInRcyc;
	}

	/**
	 * @param detectedInRcyc the detectedInRcyc to set
	 */
	public void setDetectedInRcyc(String detectedInRcyc) {
		this.detectedInRcyc = detectedInRcyc;
	}

	/**
	 * @return the detectedInRel
	 */
	public String getDetectedInRel() {
		return detectedInRel;
	}

	/**
	 * @param detectedInRel the detectedInRel to set
	 */
	public void setDetectedInRel(String detectedInRel) {
		this.detectedInRel = detectedInRel;
	}

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the extendedReference
	 */
	public String getExtendedReference() {
		return extendedReference;
	}

	/**
	 * @param extendedReference the extendedReference to set
	 */
	public void setExtendedReference(String extendedReference) {
		this.extendedReference = extendedReference;
	}

	/**
	 * @return the estimatedFixTime
	 */
	public String getEstimatedFixTime() {
		return estimatedFixTime;
	}

	/**
	 * @param estimatedFixTime the estimatedFixTime to set
	 */
	public void setEstimatedFixTime(String estimatedFixTime) {
		this.estimatedFixTime = estimatedFixTime;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the targetRel
	 */
	public String getTargetRel() {
		return targetRel;
	}

	/**
	 * @param targetRel the targetRel to set
	 */
	public void setTargetRel(String targetRel) {
		this.targetRel = targetRel;
	}

	/**
	 * @return the detectedBy
	 */
	public String getDetectedBy() {
		return detectedBy;
	}

	/**
	 * @param detectedBy the detectedBy to set
	 */
	public void setDetectedBy(String detectedBy) {
		this.detectedBy = detectedBy;
	}

	/**
	 * @return the stepReference
	 */
	public String getStepReference() {
		return stepReference;
	}

	/**
	 * @param stepReference the stepReference to set
	 */
	public void setStepReference(String stepReference) {
		this.stepReference = stepReference;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the targetRcyc
	 */
	public String getTargetRcyc() {
		return targetRcyc;
	}

	/**
	 * @param targetRcyc the targetRcyc to set
	 */
	public void setTargetRcyc(String targetRcyc) {
		this.targetRcyc = targetRcyc;
	}

	/**
	 * @return the actualFixTime
	 */
	public String getActualFixTime() {
		return actualFixTime;
	}

	/**
	 * @param actualFixTime the actualFixTime to set
	 */
	public void setActualFixTime(String actualFixTime) {
		this.actualFixTime = actualFixTime;
	}

	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * @param additionalProperties the additionalProperties to set
	 */
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}