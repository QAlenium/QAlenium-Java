package br.com.empresa.almintegration.alm.configuration.settingsModel;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Email")
@XmlAccessorType(XmlAccessType.FIELD)
public class Email {
	
	@XmlElement(name="Port")
	private String Port;

	@XmlElement(name="Host")
	private String Host;

	@XmlElement(name="To")
	private String To;

	@XmlElement(name="Pass")
	private String Pass;

	@XmlElement(name="From")
	private String From;

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

	public String getTo() {
		return To;
	}

	public void setTo(String To) {
		this.To = To;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String Pass) {
		this.Pass = Pass;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String From) {
		this.From = From;
	}

	@Override
	public String toString() {
		return "ClassPojo [Port = " + Port + ", Host = " + Host + ", To = " + To + ", Pass = " + Pass + ", From = "
				+ From + "]";
	}
}
