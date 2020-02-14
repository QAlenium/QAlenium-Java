package br.com.empresa.almintegration.alm.configuration.envModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WebPortal")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvWebPortal {

	@XmlElement(name="User")
	private String User;

	@XmlElement(name="ChamadosGrade")
	private String ChamadosGrade;

	@XmlElement(name="Dominio")
	private String Dominio;

	@XmlElement(name="UrlLogin")
	private String UrlLogin;

	@XmlElement(name="UrlPesquisa")
	private String UrlPesquisa;

	@XmlElement(name="Pass")
	private String Pass;

	@XmlElement(name="NumMaquineta")
	private String NumMaquineta;

	public String getUser() {
		return User;
	}

	public void setUser(String User) {
		this.User = User;
	}

	public String getChamadosGrade() {
		return ChamadosGrade;
	}

	public void setChamadosGrade(String ChamadosGrade) {
		this.ChamadosGrade = ChamadosGrade;
	}

	public String getDominio() {
		return Dominio;
	}

	public void setDominio(String Dominio) {
		this.Dominio = Dominio;
	}

	public String getUrlLogin() {
		return UrlLogin;
	}

	public void setUrlLogin(String UrlLogin) {
		this.UrlLogin = UrlLogin;
	}

	public String getUrlPesquisa() {
		return UrlPesquisa;
	}

	public void setUrlPesquisa(String UrlPesquisa) {
		this.UrlPesquisa = UrlPesquisa;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String Pass) {
		this.Pass = Pass;
	}

	public String getNumMaquineta() {
		return NumMaquineta;
	}

	public void setNumMaquineta(String NumMaquineta) {
		this.NumMaquineta = NumMaquineta;
	}

	@Override
	public String toString() {
		return "ClassPojo [User = " + User + ", ChamadosGrade = " + ChamadosGrade + ", Dominio = " + Dominio
				+ ", UrlLogin = " + UrlLogin + ", UrlPesquisa = " + UrlPesquisa + ", Pass = " + Pass
				+ ", NumMaquineta = " + NumMaquineta + "]";
	}
}
