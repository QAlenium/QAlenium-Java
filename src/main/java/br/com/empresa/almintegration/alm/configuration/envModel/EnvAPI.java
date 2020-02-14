package br.com.empresa.almintegration.alm.configuration.envModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "API")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvAPI {

	@XmlElement(name="ListaBancos")
	private String ListaBancos;
	
	@XmlElement(name="CpfCnpj")
	private String CpfCnpj;

	@XmlElement(name="PropostaRascunho")
	private String PropostaRascunho;

	@XmlElement(name="ContaCorrenteExiste")
	private String ContaCorrenteExiste;

	@XmlElement(name="Produtos")
	private String Produtos;

	@XmlElement(name="CredenciarCliente")
	private String CredenciarCliente;

	@XmlElement(name="RamoAtividade")
	private String RamoAtividade;

	@XmlElement(name="ContaCorrenteValida")
	private String ContaCorrenteValida;

	@XmlElement(name="PropostaCliente")
	private String PropostaCliente;

	@XmlElement(name="Ceps")
	private String Ceps;

	@XmlElement(name="Proposta")
	private String Proposta;

	@XmlElement(name="SolucaoCaptura")
	private String SolucaoCaptura;

	public String getListaBancos() {
		return ListaBancos;
	}

	public void setListaBancos(String listaBancos) {
		ListaBancos = listaBancos;
	}

	public String getCpfCnpj() {
		return CpfCnpj;
	}

	public void setCpfCnpj(String CpfCnpj) {
		this.CpfCnpj = CpfCnpj;
	}

	public String getPropostaRascunho() {
		return PropostaRascunho;
	}

	public void setPropostaRascunho(String PropostaRascunho) {
		this.PropostaRascunho = PropostaRascunho;
	}

	public String getContaCorrenteExiste() {
		return ContaCorrenteExiste;
	}

	public void setContaCorrenteExiste(String ContaCorrenteExiste) {
		this.ContaCorrenteExiste = ContaCorrenteExiste;
	}

	public String getProdutos() {
		return Produtos;
	}

	public void setProdutos(String Produtos) {
		this.Produtos = Produtos;
	}

	public String getCredenciarCliente() {
		return CredenciarCliente;
	}

	public void setCredenciarCliente(String CredenciarCliente) {
		this.CredenciarCliente = CredenciarCliente;
	}

	public String getRamoAtividade() {
		return RamoAtividade;
	}

	public void setRamoAtividade(String RamoAtividade) {
		this.RamoAtividade = RamoAtividade;
	}

	public String getContaCorrenteValida() {
		return ContaCorrenteValida;
	}

	public void setContaCorrenteValida(String ContaCorrenteValida) {
		this.ContaCorrenteValida = ContaCorrenteValida;
	}

	public String getPropostaCliente() {
		return PropostaCliente;
	}

	public void setPropostaCliente(String PropostaCliente) {
		this.PropostaCliente = PropostaCliente;
	}

	public String getCeps() {
		return Ceps;
	}

	public void setCeps(String Ceps) {
		this.Ceps = Ceps;
	}

	public String getProposta() {
		return Proposta;
	}

	public void setProposta(String Proposta) {
		this.Proposta = Proposta;
	}

	public String getSolucaoCaptura() {
		return SolucaoCaptura;
	}

	public void setSolucaoCaptura(String SolucaoCaptura) {
		this.SolucaoCaptura = SolucaoCaptura;
	}

	@Override
	public String toString() {
		return "ClassPojo [CpfCnpj = " + CpfCnpj + ", PropostaRascunho = " + PropostaRascunho
				+ ", ContaCorrenteExiste = " + ContaCorrenteExiste + ", Produtos = " + Produtos
				+ ", CredenciarCliente = " + CredenciarCliente + ", RamoAtividade = " + RamoAtividade
				+ ", ContaCorrenteValida = " + ContaCorrenteValida + ", PropostaCliente = " + PropostaCliente
				+ ", Ceps = " + Ceps + ", Proposta = " + Proposta + ", SolucaoCaptura = " + SolucaoCaptura + "]";
	}
}