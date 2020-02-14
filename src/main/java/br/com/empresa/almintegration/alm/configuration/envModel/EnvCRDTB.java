package br.com.empresa.almintegration.alm.configuration.envModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CRDTB")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvCRDTB {

	@XmlElement(name="ValidaMCC")
	private String ValidaMCC;
	
	@XmlElement(name="TB02")
	private String TB02;
	
	@XmlElement(name="ConsultaProposta")
	private String ConsultaProposta;
	
	@XmlElement(name="DomicilioBancario")
	private String DomicilioBancario;

	@XmlElement(name="ProdutosElegiveis")
	private String ProdutosElegiveis;

	@XmlElement(name="ConsultaCEP")
	private String ConsultaCEP;
	
	@XmlElement(name="CadastrarEC")
	private String CadastrarEC;
	
	@XmlElement(name="ValidarDadosCadastrais")
	private String ValidarDadosCadastrais;
	
	public String getValidarDadosCadastrais() {
		return ValidarDadosCadastrais;
	}

	public void setValidarDadosCadastrais(String validarDadosCadastrais) {
		ValidarDadosCadastrais = validarDadosCadastrais;
	}

	public String getCadastrarEC() {
		return CadastrarEC;
	}

	public void setCadastrarEC(String cadastrarEC) {
		CadastrarEC = cadastrarEC;
	}

	public String getConsultaProposta() {
		return ConsultaProposta;
	}

	public void setConsultaProposta(String consultaProposta) {
		ConsultaProposta = consultaProposta;
	}

	public String getTB02() {
		return TB02;
	}

	public void setTB02(String tB02) {
		TB02 = tB02;
	}

	public String getValidaMCC() {
		return ValidaMCC;
	}

	public void setValidaMCC(String ValidaMCC) {
		this.ValidaMCC = ValidaMCC;
	}

	public String getDomicilioBancario() {
		return DomicilioBancario;
	}

	public void setDomicilioBancario(String DomicilioBancario) {
		this.DomicilioBancario = DomicilioBancario;
	}

	public String getProdutosElegiveis() {
		return ProdutosElegiveis;
	}

	public void setProdutosElegiveis(String ProdutosElegiveis) {
		this.ProdutosElegiveis = ProdutosElegiveis;
	}

	public String getConsultaCEP() {
		return ConsultaCEP;
	}

	public void setConsultaCEP(String ConsultaCEP) {
		this.ConsultaCEP = ConsultaCEP;
	}

	@Override
	public String toString() {
		return "ClassPojo [ValidaMCC = " + ValidaMCC + ", DomicilioBancario = " + DomicilioBancario
				+ ", ProdutosElegiveis = " + ProdutosElegiveis + ", ConsultaCEP = " + ConsultaCEP + "]";
	}
}