package br.com.empresa.almintegration.alm.configuration.envModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Env")
@XmlAccessorType(XmlAccessType.FIELD)
public class Env {

	@XmlElement(name="Servicos")
	private EnvServicos Servicos;

	@XmlElement(name="Database")
	private EnvDataBase DataBase;

	@XmlElement(name="Web")
	private EnvWeb Web;
	
	@XmlElement(name="MainFrame")
	private EnvMainFrame mainFrame;

	
	public EnvMainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(EnvMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public EnvServicos getServicos() {
		return Servicos;
	}

	public void setServicos(EnvServicos Servicos) {
		this.Servicos = Servicos;
	}

	public EnvDataBase getDataBase() {
		return DataBase;
	}

	public void setDataBase(EnvDataBase DataBase) {
		this.DataBase = DataBase;
	}

	public EnvWeb getWeb() {
		return Web;
	}

	public void setWeb(EnvWeb Web) {
		this.Web = Web;
	}

	@Override
	public String toString() {
		return "ClassPojo [Servicos = " + Servicos + ", DataBase = " + DataBase + ", Web = " + Web + "]";
	}
}
