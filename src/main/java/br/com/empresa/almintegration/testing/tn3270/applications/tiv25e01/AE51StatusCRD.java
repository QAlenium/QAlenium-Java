package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01;

import java.util.List;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;

public class AE51StatusCRD {
	
	private String statusField;
	private String sinceField;
	private String sinceDefinedByUserField;
	
	private String endSinceField;
	private String endDefinedByUserField;
	
	public AE51StatusCRD(int line) {

		Mainframe mainframe = Mainframe.getInstance();
		int statusFieldCounter = 14+(10*line);
		int sinceFieldCounter = statusFieldCounter + 4;
		int sinceDefinedByUserFieldCounter = statusFieldCounter + 5;
		
		int endSinceFieldCounter = statusFieldCounter + 7;
		int endDefinedByUserFieldCounter = statusFieldCounter + 8;

		List<Field> fields = mainframe.getS3270().getScreen().getFields();
		statusField = new StringBuilder()
				.append(fields.get(statusFieldCounter).getText().trim())
				.append(fields.get(statusFieldCounter + 1).getText().trim())
				.append(fields.get(statusFieldCounter + 2).getText().trim()).toString();
		
		sinceField = new StringBuilder().append(fields.get(sinceFieldCounter).getText().trim()).toString();
		sinceDefinedByUserField = new StringBuilder().append(fields.get(sinceDefinedByUserFieldCounter).getText().trim()).toString();
		
		endSinceField = new StringBuilder().append(fields.get(endSinceFieldCounter).getText().trim()).toString();
		endDefinedByUserField = new StringBuilder().append(fields.get(endDefinedByUserFieldCounter).getText().trim()).toString();
	}

	public String getStatusField() {
		return statusField;
	}

	public void setStatusField(String statusField) {
		this.statusField = statusField;
	}

	public String getSinceField() {
		return sinceField;
	}

	public void setSinceField(String sinceField) {
		this.sinceField = sinceField;
	}

	public String getSinceDefinedByUserField() {
		return sinceDefinedByUserField;
	}

	public void setSinceDefinedByUserField(String sinceDefinedByUserField) {
		this.sinceDefinedByUserField = sinceDefinedByUserField;
	}

	public String getEndSinceField() {
		return endSinceField;
	}

	public void setEndSinceField(String endSinceField) {
		this.endSinceField = endSinceField;
	}

	public String getEndDefinedByUserField() {
		return endDefinedByUserField;
	}

	public void setEndDefinedByUserField(String endDefinedByUserField) {
		this.endDefinedByUserField = endDefinedByUserField;
	}

}
