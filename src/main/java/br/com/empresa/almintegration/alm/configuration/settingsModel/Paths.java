package br.com.empresa.almintegration.alm.configuration.settingsModel;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Paths")
@XmlAccessorType(XmlAccessType.FIELD)
public class Paths {
	
	@XmlElement(name="Evidencia")
	private String Evidencia;

	@XmlElement(name="FabricaLogo")
	private String FabricaLogo;

	@XmlElement(name="Files")
	private String Files;

	@XmlElement(name="EvidenciasConsolidadas")
	private String EvidenciasConsolidadas;

	@XmlElement(name="App")
	private String App;

	@XmlElement(name="Layouts")
	private String Layouts;

	@XmlElement(name="Emulator")
	private String Emulator;

	@XmlElement(name="Adb")
	private String Adb;

	@XmlElement(name="Aux")
	private String Aux;

	@XmlElement(name="OutputDirBaseEvidences")
	private String OutputDirBaseEvidences;

	@XmlElement(name="ClienteLogo")
	private String ClienteLogo;

	public String getEvidencia() {
		return Evidencia;
	}

	public void setEvidencia(String Evidencia) {
		this.Evidencia = Evidencia;
	}

	public String getFabricaLogo() {
		return FabricaLogo;
	}

	public void setFabricaLogo(String FabricaLogo) {
		this.FabricaLogo = FabricaLogo;
	}

	public String getFiles() {
		return Files;
	}

	public void setFiles(String Files) {
		this.Files = Files;
	}

	public String getEvidenciasConsolidadas() {
		return EvidenciasConsolidadas;
	}

	public void setEvidenciasConsolidadas(String EvidenciasConsolidadas) {
		this.EvidenciasConsolidadas = EvidenciasConsolidadas;
	}

	public String getApp() {
		return App;
	}

	public void setApp(String App) {
		this.App = App;
	}

	public String getLayouts() {
		return Layouts;
	}

	public void setLayouts(String Layouts) {
		this.Layouts = Layouts;
	}

	public String getEmulator() {
		return Emulator;
	}

	public void setEmulator(String Emulator) {
		this.Emulator = Emulator;
	}

	public String getAdb() {
		return Adb;
	}

	public void setAdb(String Adb) {
		this.Adb = Adb;
	}

	public String getAux() {
		return Aux;
	}

	public void setAux(String Aux) {
		this.Aux = Aux;
	}

	public String getOutputDirBaseEvidences() {
		return OutputDirBaseEvidences;
	}

	public void setOutputDirBaseEvidences(String OutputDirBaseEvidences) {
		this.OutputDirBaseEvidences = OutputDirBaseEvidences;
	}

	public String getClienteLogo() {
		return ClienteLogo;
	}

	public void setClienteLogo(String ClienteLogo) {
		this.ClienteLogo = ClienteLogo;
	}

	@Override
	public String toString() {
		return "ClassPojo [Evidencia = " + Evidencia + ", FabricaLogo = " + FabricaLogo + ", Files = " + Files
				+ ", EvidenciasConsolidadas = " + EvidenciasConsolidadas + ", App = " + App + ", Layouts = " + Layouts
				+ ", Emulator = " + Emulator + ", Adb = " + Adb + ", Aux = " + Aux + ", OutputDirBaseEvidences = "
				+ OutputDirBaseEvidences + ", ClienteLogo = " + ClienteLogo + "]";
	}
}
