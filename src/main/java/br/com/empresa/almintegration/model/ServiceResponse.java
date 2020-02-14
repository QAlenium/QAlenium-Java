package br.com.empresa.almintegration.model;

public class ServiceResponse {

	private String resposeFromRequest;
	private String endpoint;
	private String evidenceContent;
	private Object expectedResult;
	private Object result;
	private String message;
	private Class<?> clazz;
	private String runId;
	
	public String getResposeFromRequest() {
		return resposeFromRequest;
	}
	public void setResposeFromRequest(String resposeFromRequest) {
		this.resposeFromRequest = resposeFromRequest;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getEvidenceContent() {
		return evidenceContent;
	}
	public void setEvidenceContent(String evidenceContent) {
		this.evidenceContent = evidenceContent;
	}
	public Object getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(Object expectedResult) {
		this.expectedResult = expectedResult;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	public String getRunId() {
		return runId;
	}
	public void setRunId(String runId) {
		this.runId = runId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
