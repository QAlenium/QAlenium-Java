package br.com.empresa.almintegration.alm.configuration.envModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MainFrame")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvMainFrame {
	
	@XmlElement(name="Redes")
	private EnvREDES redes;

	@XmlElement(name="TSO")
	private EnvTSO tso;
	
	@XmlElement(name="SEC")
	private EnvSEC sec;

	public EnvREDES getRedes() {
		return redes;
	}

	public void setRedes(EnvREDES redes) {
		this.redes = redes;
	}

	public EnvTSO getTso() {
		return tso;
	}

	public void setTso(EnvTSO tso) {
		this.tso = tso;
	}

	public EnvSEC getSec() {
		return sec;
	}

	public void setSec(EnvSEC sec) {
		this.sec = sec;
	}
	
}