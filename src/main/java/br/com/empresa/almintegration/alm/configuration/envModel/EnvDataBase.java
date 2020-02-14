package br.com.empresa.almintegration.alm.configuration.envModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DataBase")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvDataBase {

	@XmlElement(name="SID")
	private String SID;

	@XmlElement(name="User")
	private String User;

	@XmlElement(name="Port")
	private String Port;

	@XmlElement(name="Host")
	private String Host;

	@XmlElement(name="Pass")
	private String Pass;

	public String getSID() {
		return SID;
	}

	public void setSID(String SID) {
		this.SID = SID;
	}

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

	public String getHost() {
		return Host;
	}

	public void setHost(String Host) {
		this.Host = Host;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String Pass) {
		this.Pass = Pass;
	}

	@Override
	public String toString() {
		return "ClassPojo [SID = " + SID + ", User = " + User + ", Port = " + Port + ", Host = " + Host + ", Pass = "
				+ Pass + "]";
	}
}
