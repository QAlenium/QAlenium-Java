package br.com.empresa.almintegration.alm.configuration.envModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Settings")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvSettings {

	@XmlElement(name="Env")
	private Env Env;

	public Env getEnv() {
		return Env;
	}

	public void setEnv(Env Env) {
		this.Env = Env;
	}

	@Override
	public String toString() {
		return "ClassPojo [Env = " + Env + "]";
	}
}
