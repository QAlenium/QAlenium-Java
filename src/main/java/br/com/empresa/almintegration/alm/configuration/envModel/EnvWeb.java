package br.com.empresa.almintegration.alm.configuration.envModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Web")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvWeb {
	
	@XmlElement(name="WebPortal")
	private EnvWebPortal WebPortal;

	public EnvWebPortal getWebPortal() {
		return WebPortal;
	}

	public void setWebPortal(EnvWebPortal WebPortal) {
		this.WebPortal = WebPortal;
	}

	@Override
	public String toString() {
		return "ClassPojo [WebPortal = " + WebPortal + "]";
	}
}