package br.com.empresa.almintegration.alm.configuration.envModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Servicos")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvServicos {

	@XmlElement(name="API")
	private EnvAPI API;

	@XmlElement(name="CRDTB")
	private EnvCRDTB CRDTB;

	@XmlElement(name="ClientID")
	private String ClientID;

	public EnvAPI getAPI() {
		return API;
	}

	public void setAPI(EnvAPI API) {
		this.API = API;
	}

	public EnvCRDTB getCRDTB() {
		return CRDTB;
	}

	public void setCRDTB(EnvCRDTB CRDTB) {
		this.CRDTB = CRDTB;
	}

	public String getClientID() {
		return ClientID;
	}

	public void setClientID(String ClientID) {
		this.ClientID = ClientID;
	}

	@Override
	public String toString() {
		return "ClassPojo [API = " + API + ", CRDTB = " + CRDTB + ", ClientID = " + ClientID + "]";
	}
}
