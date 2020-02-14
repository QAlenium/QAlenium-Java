package br.com.empresa.almintegration.alm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.empresa.almintegration.alm.infrastructure.Entity;

public class RunSteps {

	private List<RunStep> runStepsList = new ArrayList<RunStep>();
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RunSteps() {
	}

	/**
	 *
	 * @param list
	 */
	public RunSteps(Entities entities) {
		super();
		for (Entity entity : entities.getEntityList()) {
			this.runStepsList.add(new RunStep(entity));
		}
	}

	public List<RunStep> getRunStepsList() {
		return runStepsList;
	}

	public void setRunStepsList(List<RunStep> runStep) {
		this.runStepsList = runStep;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}	
}