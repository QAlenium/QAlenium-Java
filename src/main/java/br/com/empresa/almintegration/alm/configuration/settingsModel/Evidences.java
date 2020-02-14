package br.com.empresa.almintegration.alm.configuration.settingsModel;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Evidences")
@XmlAccessorType(XmlAccessType.FIELD)
public class Evidences {
	
	@XmlElement(name="Cycle")
	private String Cycle;

	@XmlElement(name="Project")
	private String Project;

	@XmlElement(name="Version")
	private String Version;

	@XmlElement(name="Executor")
	private String Executor;

	public String getCycle() {
		return Cycle;
	}

	public void setCycle(String Cycle) {
		this.Cycle = Cycle;
	}

	public String getProject() {
		return Project;
	}

	public void setProject(String Project) {
		this.Project = Project;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String Version) {
		this.Version = Version;
	}

	public String getExecutor() {
		return Executor;
	}

	public void setExecutor(String Executor) {
		this.Executor = Executor;
	}

	@Override
	public String toString() {
		return "ClassPojo [Cycle = " + Cycle + ", Project = " + Project + ", Version = " + Version + ", Executor = "
				+ Executor + "]";
	}
}
