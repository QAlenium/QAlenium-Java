package br.com.empresa.almintegration.alm.configuration.settingsModel;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Settings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Settings {
	
	@XmlElement(name="Env")
	private String Env;
	
	@XmlElement(name="Config")
	private Config Config;

	public String getEnv() {
		return Env;
	}

	public void setEnv(String Env) {
		this.Env = Env;
	}
	
	public Config getConfig() {
		return Config;
	}

	public void setConfig(Config Config) {
		this.Config = Config;
	}

	@Override
	public String toString() {
		return "ClassPojo [Config = " + Config + "]";
	}
}
