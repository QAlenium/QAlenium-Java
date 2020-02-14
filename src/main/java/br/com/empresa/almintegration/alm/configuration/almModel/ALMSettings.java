package br.com.empresa.almintegration.alm.configuration.almModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ALMSettings")
@XmlAccessorType(XmlAccessType.FIELD)
public class ALMSettings {

	@XmlElement(name = "Settings")
	private Settings Settings;

	public Settings getSettings() {
		return Settings;
	}

	public void setSettings(Settings Settings) {
		this.Settings = Settings;
	}

	@Override
	public String toString() {
		return "ClassPojo [Settings = " + Settings + "]";
	}
}
