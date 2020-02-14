package br.com.empresa.almintegration.alm.configuration.settingsModel;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {
	
	@XmlElement(name="User")
	private String User;

	@XmlElement(name="Port")
	private String Port;

	@XmlElement(name="Domain")
	private String Domain;

	@XmlElement(name="Host")
	private String Host;

	@XmlElement(name="Project")
	private String Project;

	@XmlElement(name="Pass")
	private String Pass;

	public String getUser() {
		return User;
	}

	public void setUser(String User) {
		this.User = User;
	}

	public String getPort() {
		return Port;
	}

	public void setPort(String Port) {
		this.Port = Port;
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String Domain) {
		this.Domain = Domain;
	}

	public String getHost() {
		return Host;
	}

	public void setHost(String Host) {
		this.Host = Host;
	}

	public String getProject() {
		return Project;
	}

	public void setProject(String Project) {
		this.Project = Project;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String Pass) {
		this.Pass = Pass;
	}

	@Override
	public String toString() {
		return "ClassPojo [User = " + User + ", Port = " + Port + ", Domain = " + Domain + ", Host = " + Host
				+ ", Project = " + Project + ", Pass = " + Pass + "]";
	}
}
