package br.com.empresa.almintegration.alm.configuration.settingsModel;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ALM")
@XmlAccessorType(XmlAccessType.FIELD)
public class ALM {
	
	@XmlElement(name="Project")
	private Project Project;

	public Project getProject() {
		return Project;
	}

	public void setProject(Project Project) {
		this.Project = Project;
	}

	@Override
	public String toString() {
		return "ClassPojo [Project = " + Project + "]";
	}
}
