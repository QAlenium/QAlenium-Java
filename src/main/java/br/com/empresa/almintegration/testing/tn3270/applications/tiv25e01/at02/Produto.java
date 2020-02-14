package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01.at02;

public class Produto{
	
	private int page;
	private int y;
	private String codigo;
	private String descricao;
	private String prazo;
	private String tipoCobranca;
	private String liq;
	private String taxaComissao;
	private String tarifaItem;
	private String prazoFlex;
	private String fatura1;
	private String fatura2;
	private String parcelas;
	
	public Produto(String line, int y, int page) {
		this.page = page;
		this.y = y;
		this.codigo = line.substring(3, 6);
		this.descricao = line.substring(7, 20).trim();
		this.prazo = line.substring(22, 25).trim();
		this.tipoCobranca = line.substring(25, 29).trim();
		this.liq = line.substring(30, 33).trim();
		this.taxaComissao = line.substring(36, 42).trim();
		this.tarifaItem = line.substring(44, 49).trim();
		this.prazoFlex = line.substring(50, 53).trim();
		this.fatura1 = line.substring(54, 58).trim();
		this.fatura2 = line.substring(60, 64).trim();
		this.parcelas = line.substring(65, 80).trim();
	}

	public int getPage() {
		return page;
	}

	public int getY() {
		return y;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getPrazo() {
		return prazo;
	}

	public String getTipoCobranca() {
		return tipoCobranca;
	}

	public String getLiq() {
		return liq;
	}

	public String getTaxaComissao() {
		return taxaComissao;
	}

	public String getTarifaItem() {
		return tarifaItem;
	}

	public String getPrazoFlex() {
		return prazoFlex;
	}

	public String getFatura1() {
		return fatura1;
	}

	public String getFatura2() {
		return fatura2;
	}

	public String getParcelas() {
		return parcelas;
	}
	
}