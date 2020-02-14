package br.com.empresa.almintegration.alm.configuration.settingsModel;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Config")
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {
	
	@XmlElement(name="Evidences")
	private Evidences Evidences;

	@XmlElement(name="Email")
	private Email Email;

	@XmlElement(name="Paths")
	private Paths Paths;

	@XmlElement(name="ALM")
	private ALM ALM;

	public Evidences getEvidences() {
		return Evidences;
	}

	public void setEvidences(Evidences Evidences) {
		this.Evidences = Evidences;
	}

	public Email getEmail() {
		return Email;
	}

	public void setEmail(Email Email) {
		this.Email = Email;
	}

	public Paths getPaths() {
		return Paths;
	}

	public void setPaths(Paths Paths) {
		this.Paths = Paths;
	}

	public ALM getALM() {
		return ALM;
	}

	public void setALM(ALM ALM) {
		this.ALM = ALM;
	}

	@Override
	public String toString() {
		return "ClassPojo [Evidences = " + Evidences + ", Email = " + Email + ", Paths = " + Paths
				+ ", ALM = " + ALM + "]";
	}
}
