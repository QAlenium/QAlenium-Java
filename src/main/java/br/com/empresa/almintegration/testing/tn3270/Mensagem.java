package br.com.empresa.almintegration.testing.tn3270;

public class Mensagem {
	private String CodigoMensagem;
	private String NumeroInstituicaoFinanceira;
	private String NumeroIdentificacaoChamada;
	private String VagoObrigatorio;
	private String CodigoErro;
	private String FlagBanco;
	private String Banco;
	private String NumeroEstabelecimento;
	private String FlagRazaoSocial;
	private String RazaoSocialEstabelecimento;
	private String FlagEnderecoCorrespondencia;
	private String LogradouroCorrespondencia;
	private String ComplementoLogradouroCorresp;
	private String FlagCidade;
	private String CidadeCorrespondencia;
	private String FlagEstado;
	private String EstadoCorrespondencia;
	private String FlagCEP;
	private String CEPCorrespondencia;
	private String FlagCNPJCPF;
	private String CNPJCPF;
	private String FlagInscricaoEstadual;
	private String InscricaoEstadual;
	private String FlagNomeFantasia;
	private String NomeFantasia;
	private String FlagEnderecoEstabelecimento;
	private String LogradouroEstabelecimento;
	private String ComplementoLogradouroEstabelecimento;
	private String FlagCidadeEstabelecimento;
	private String CidadeEstabelecimento;
	private String FlagEstadoEstabelecimento;
	private String EstadoEstabelecimento;
	private String FlagCEPEstabelecimento;
	private String CEPEstabelecimento;
	private String FlagNomePlaqueta;
	private String NomePlaqueta;
	private String FlagPessoaParaContato;
	private String PessoaParaContato;
	private String Filler;
	private String ReservadoCliente1;
	private String ReservadoCliente2;
	private String FlagRamoAtividade;
	private String CodigoRamoAtividade;
	private String FlagAgencia;
	private String CodigoAgencia;
	private String FlagContaCorrente;
	private String NumeroContaCorrente;
	private String FlagNomeProprietario1;
	private String NomeProprietario1;
	private String FlagCPFProprietario1;
	private String CPFProprietario1;
	private String FlagDataNascimentoProprietario1;
	private String DataNascimentoProprietario1;
	private String FlagNomeProprietario2;
	private String NomeProprietario2;
	private String FlagCPFProprietario2;
	private String CPFProprietario2;
	private String FlagDataNascimentoProprietario2;
	private String DataNascimentoProprietario2;
	private String FlagNomeProprietario3;
	private String NomeProprietario3;
	private String FlagCPFProprietario3;
	private String CPFProprietario3;
	private String FlagDataNascimentoProprietario3;
	private String DataNascimentoProprietario3;
	private String FlagTipoPessoa;
	private String TipoPessoa;
	private String FlagCentroCompras;
	private String CentroCompras;
	private String FlagTipoTerminal;
	private String TipoTerminal;
	private String FlagComplementoMCC;
	private String ComplementoMCC;
	private String FlagIndicadorMobile;
	private String IndicadorMobile;
	private String FlagDDDTelefoneComercial;
	private String DDDTelefoneComercial;
	private String FlagTelefoneComercial;
	private String NumeroTelefoneComercial;
	private String FlagDDDTelefoneCelular;
	private String DDDTelefoneCelular;
	private String FlagTelefoneCelular;
	private String NumeroTelefoneCelular;
	private String FlagMEI;
	private String ClienteMEI;
	private String AreaReservada1;
	private String DadosInformais;
	private String DataAfiliacao;
	private String FlagBanco2;
	private String Banco2;
	private String FlagAgencia2;
	private String Agencia2;
	private String FlagConta2;
	private String Conta;
	private String FlagProtocolo;
	private String Protocolo;
	private String FlagDuplCadastro;
	private String DuplCadastro;
	private String FlagOperadoraSaude;
	private String OperadoraSaude;
	private String AreaReservada2;
	private String AreaReservada3;
	private String FlagTrocoFacil;
	private String TrocoFacil;
	private String FlagTaxaTrocoFacil;
	private String TaxaTrocoFacil;
	private String FlagPrazoTrocoFacil;
	private String PrazoTrocoFacil;
	private String FlagFlexCar;
	private String FlexCar;
	private String FlagTaxaFlexCar;
	private String TaxaFlexCar;
	private String FlagPrazoFlexCar;
	private String PrazoFlexCar;
	private String AreaReservada4;
	private String AreaReservada5;

	public Mensagem(String mensagem) {
		CodigoMensagem = mensagem.substring(0,3);
		NumeroInstituicaoFinanceira = mensagem.substring(3,7);
		NumeroIdentificacaoChamada = mensagem.substring(7,11);
		VagoObrigatorio = mensagem.substring(11,30);
		CodigoErro = mensagem.substring(30,32);
		FlagBanco = mensagem.substring(32,34);
		Banco = mensagem.substring(34,37);
		NumeroEstabelecimento = mensagem.substring(37,47);
		FlagRazaoSocial = mensagem.substring(47,49);
		RazaoSocialEstabelecimento = mensagem.substring(49,81);
		FlagEnderecoCorrespondencia = mensagem.substring(81,83);
		LogradouroCorrespondencia = mensagem.substring(83,115);
		ComplementoLogradouroCorresp = mensagem.substring(115,147);
		FlagCidade = mensagem.substring(147,149);
		CidadeCorrespondencia = mensagem.substring(149,177);
		FlagEstado = mensagem.substring(177,179);
		EstadoCorrespondencia = mensagem.substring(179,181);
		FlagCEP = mensagem.substring(181,183);
		CEPCorrespondencia = mensagem.substring(183,191);
		FlagCNPJCPF = mensagem.substring(191,193);
		CNPJCPF = mensagem.substring(193,208);
		FlagInscricaoEstadual = mensagem.substring(208,210);
		InscricaoEstadual = mensagem.substring(210,225);
		FlagNomeFantasia = mensagem.substring(225,227);
		NomeFantasia = mensagem.substring(227,259);
		FlagEnderecoEstabelecimento = mensagem.substring(259,261);
		LogradouroEstabelecimento = mensagem.substring(261,293);
		ComplementoLogradouroEstabelecimento = mensagem.substring(293,325);
		FlagCidadeEstabelecimento = mensagem.substring(325,327);
		CidadeEstabelecimento = mensagem.substring(327,355);
		FlagEstadoEstabelecimento = mensagem.substring(355,357);
		EstadoEstabelecimento = mensagem.substring(357,359);
		FlagCEPEstabelecimento = mensagem.substring(359,361);
		CEPEstabelecimento = mensagem.substring(361,369);
		FlagNomePlaqueta = mensagem.substring(369,371);
		NomePlaqueta = mensagem.substring(371,393);
		FlagPessoaParaContato = mensagem.substring(393,395);
		PessoaParaContato = mensagem.substring(395,427);
		Filler = mensagem.substring(427,459);
		ReservadoCliente1 = mensagem.substring(459,461);
		ReservadoCliente2 = mensagem.substring(461,471);
		FlagRamoAtividade = mensagem.substring(471,473);
		CodigoRamoAtividade = mensagem.substring(473,478);
		FlagAgencia = mensagem.substring(478,480);
		CodigoAgencia = mensagem.substring(480,485);
		FlagContaCorrente = mensagem.substring(485,487);
		NumeroContaCorrente = mensagem.substring(487,501);
		FlagNomeProprietario1 = mensagem.substring(501,503);
		NomeProprietario1 = mensagem.substring(503,535);
		FlagCPFProprietario1 = mensagem.substring(535,537);
		CPFProprietario1 = mensagem.substring(537,552);
		FlagDataNascimentoProprietario1 = mensagem.substring(552,554);
		DataNascimentoProprietario1 = mensagem.substring(554,560);
		FlagNomeProprietario2 = mensagem.substring(560,562);
		NomeProprietario2 = mensagem.substring(562,594);
		FlagCPFProprietario2 = mensagem.substring(594,596);
		CPFProprietario2 = mensagem.substring(596,611);
		FlagDataNascimentoProprietario2 = mensagem.substring(611,613);
		DataNascimentoProprietario2 = mensagem.substring(613,619);
		FlagNomeProprietario3 = mensagem.substring(619,621);
		NomeProprietario3 = mensagem.substring(621,653);
		FlagCPFProprietario3 = mensagem.substring(653,655);
		CPFProprietario3 = mensagem.substring(655,670);
		FlagDataNascimentoProprietario3 = mensagem.substring(670,672);
		DataNascimentoProprietario3 = mensagem.substring(672,678);
		FlagTipoPessoa = mensagem.substring(678,680);
		TipoPessoa = mensagem.substring(680,681);
		FlagCentroCompras = mensagem.substring(681,683);
		CentroCompras = mensagem.substring(683,684);
		FlagTipoTerminal = mensagem.substring(684,686);
		TipoTerminal = mensagem.substring(686,687);
		FlagComplementoMCC = mensagem.substring(687,689);
		ComplementoMCC = mensagem.substring(689,690);
		FlagIndicadorMobile = mensagem.substring(690,692);
		IndicadorMobile = mensagem.substring(692,693);
		FlagDDDTelefoneComercial = mensagem.substring(693,695);
		DDDTelefoneComercial = mensagem.substring(695,699);
		FlagTelefoneComercial = mensagem.substring(699,701);
		NumeroTelefoneComercial = mensagem.substring(701,710);
		FlagDDDTelefoneCelular = mensagem.substring(710,712);
		DDDTelefoneCelular = mensagem.substring(712,716);
		FlagTelefoneCelular = mensagem.substring(716,718);
		NumeroTelefoneCelular = mensagem.substring(718,727);
		FlagMEI = mensagem.substring(727,729);
		ClienteMEI = mensagem.substring(729,730);
		if(mensagem.length() > 730){
			AreaReservada1 = mensagem.substring(730,1179);
			DadosInformais = mensagem.substring(1179,1470);
			DataAfiliacao = mensagem.substring(1470,1478);
			FlagBanco2 = mensagem.substring(1478,1480);
			Banco2 = mensagem.substring(1480,1484);
			FlagAgencia2 = mensagem.substring(1484,1486);
			Agencia2 = mensagem.substring(1486,1491);
			FlagConta2 = mensagem.substring(1491,1493);
			Conta = mensagem.substring(1493,1507);
			FlagProtocolo = mensagem.substring(1507,1509);
			Protocolo = mensagem.substring(1509,1510);
			FlagDuplCadastro = mensagem.substring(1510,1512);
			DuplCadastro = mensagem.substring(1512,1513);
			FlagOperadoraSaude = mensagem.substring(1513,1515);
			OperadoraSaude = mensagem.substring(1515,1516);
			AreaReservada2 = mensagem.substring(1516,1533);
			AreaReservada3 = mensagem.substring(1533,1555);
			FlagTrocoFacil = mensagem.substring(1555,1557);
			TrocoFacil = mensagem.substring(1557,1558);
			FlagTaxaTrocoFacil = mensagem.substring(1558,1560);
			TaxaTrocoFacil = mensagem.substring(1560,1565);
			FlagPrazoTrocoFacil = mensagem.substring(1565,1567);
			PrazoTrocoFacil = mensagem.substring(1567,1570);
			FlagFlexCar = mensagem.substring(1570,1572);
			FlexCar = mensagem.substring(1572,1573);
			FlagTaxaFlexCar = mensagem.substring(1573,1575);
			TaxaFlexCar = mensagem.substring(1575,1580);
			FlagPrazoFlexCar = mensagem.substring(1580,1582);
			PrazoFlexCar = mensagem.substring(1582,1585);
			AreaReservada4 = mensagem.substring(1585,1889);
			AreaReservada5 = mensagem.substring(1889,1920);
		}
	}
	
	@Override
	public String toString() {
		String mensagem;
		mensagem = CodigoMensagem;
		mensagem = mensagem.concat(NumeroInstituicaoFinanceira);
		mensagem = mensagem.concat(NumeroIdentificacaoChamada);
		mensagem = mensagem.concat(VagoObrigatorio);
		mensagem = mensagem.concat(CodigoErro);
		mensagem = mensagem.concat(FlagBanco);
		mensagem = mensagem.concat(Banco);
		mensagem = mensagem.concat(NumeroEstabelecimento);
		mensagem = mensagem.concat(FlagRazaoSocial);
		mensagem = mensagem.concat(RazaoSocialEstabelecimento);
		mensagem = mensagem.concat(FlagEnderecoCorrespondencia);
		mensagem = mensagem.concat(LogradouroCorrespondencia);
		mensagem = mensagem.concat(ComplementoLogradouroCorresp);
		mensagem = mensagem.concat(FlagCidade);
		mensagem = mensagem.concat(CidadeCorrespondencia);
		mensagem = mensagem.concat(FlagEstado);
		mensagem = mensagem.concat(EstadoCorrespondencia);
		mensagem = mensagem.concat(FlagCEP);
		mensagem = mensagem.concat(CEPCorrespondencia);
		mensagem = mensagem.concat(FlagCNPJCPF);
		mensagem = mensagem.concat(CNPJCPF);
		mensagem = mensagem.concat(FlagInscricaoEstadual);
		mensagem = mensagem.concat(InscricaoEstadual);
		mensagem = mensagem.concat(FlagNomeFantasia);
		mensagem = mensagem.concat(NomeFantasia);
		mensagem = mensagem.concat(FlagEnderecoEstabelecimento);
		mensagem = mensagem.concat(LogradouroEstabelecimento);
		mensagem = mensagem.concat(ComplementoLogradouroEstabelecimento);
		mensagem = mensagem.concat(FlagCidadeEstabelecimento);
		mensagem = mensagem.concat(CidadeEstabelecimento);
		mensagem = mensagem.concat(FlagEstadoEstabelecimento);
		mensagem = mensagem.concat(EstadoEstabelecimento);
		mensagem = mensagem.concat(FlagCEPEstabelecimento);
		mensagem = mensagem.concat(CEPEstabelecimento);
		mensagem = mensagem.concat(FlagNomePlaqueta);
		mensagem = mensagem.concat(NomePlaqueta);
		mensagem = mensagem.concat(FlagPessoaParaContato);
		mensagem = mensagem.concat(PessoaParaContato);
		mensagem = mensagem.concat(Filler);
		mensagem = mensagem.concat(ReservadoCliente1);
		mensagem = mensagem.concat(ReservadoCliente2);
		mensagem = mensagem.concat(FlagRamoAtividade);
		mensagem = mensagem.concat(CodigoRamoAtividade);
		mensagem = mensagem.concat(FlagAgencia);
		mensagem = mensagem.concat(CodigoAgencia);
		mensagem = mensagem.concat(FlagContaCorrente);
		mensagem = mensagem.concat(NumeroContaCorrente);
		mensagem = mensagem.concat(FlagNomeProprietario1);
		mensagem = mensagem.concat(NomeProprietario1);
		mensagem = mensagem.concat(FlagCPFProprietario1);
		mensagem = mensagem.concat(CPFProprietario1);
		mensagem = mensagem.concat(FlagDataNascimentoProprietario1);
		mensagem = mensagem.concat(DataNascimentoProprietario1);
		mensagem = mensagem.concat(FlagNomeProprietario2);
		mensagem = mensagem.concat(NomeProprietario2);
		mensagem = mensagem.concat(FlagCPFProprietario2);
		mensagem = mensagem.concat(CPFProprietario2);
		mensagem = mensagem.concat(FlagDataNascimentoProprietario2);
		mensagem = mensagem.concat(DataNascimentoProprietario2);
		mensagem = mensagem.concat(FlagNomeProprietario3);
		mensagem = mensagem.concat(NomeProprietario3);
		mensagem = mensagem.concat(FlagCPFProprietario3);
		mensagem = mensagem.concat(CPFProprietario3);
		mensagem = mensagem.concat(FlagDataNascimentoProprietario3);
		mensagem = mensagem.concat(DataNascimentoProprietario3);
		mensagem = mensagem.concat(FlagTipoPessoa);
		mensagem = mensagem.concat(TipoPessoa);
		mensagem = mensagem.concat(FlagCentroCompras);
		mensagem = mensagem.concat(CentroCompras);
		mensagem = mensagem.concat(FlagTipoTerminal);
		mensagem = mensagem.concat(TipoTerminal);
		mensagem = mensagem.concat(FlagComplementoMCC);
		mensagem = mensagem.concat(ComplementoMCC);
		mensagem = mensagem.concat(FlagIndicadorMobile);
		mensagem = mensagem.concat(IndicadorMobile);
		mensagem = mensagem.concat(FlagDDDTelefoneComercial);
		mensagem = mensagem.concat(DDDTelefoneComercial);
		mensagem = mensagem.concat(FlagTelefoneComercial);
		mensagem = mensagem.concat(NumeroTelefoneComercial);
		mensagem = mensagem.concat(FlagDDDTelefoneCelular);
		mensagem = mensagem.concat(DDDTelefoneCelular);
		mensagem = mensagem.concat(FlagTelefoneCelular);
		mensagem = mensagem.concat(NumeroTelefoneCelular);
		mensagem = mensagem.concat(FlagMEI);
		mensagem = mensagem.concat(ClienteMEI);
		if (AreaReservada1 != null) mensagem = mensagem.concat(AreaReservada1);
		if (DadosInformais != null) mensagem = mensagem.concat(DadosInformais);
		if (DataAfiliacao != null) mensagem = mensagem.concat(DataAfiliacao);
		if (FlagBanco2 != null) mensagem = mensagem.concat(FlagBanco2);
		if (Banco2 != null) mensagem = mensagem.concat(Banco2);
		if (FlagAgencia2 != null) mensagem = mensagem.concat(FlagAgencia2);
		if (Agencia2 != null) mensagem = mensagem.concat(Agencia2);
		if (FlagConta2 != null) mensagem = mensagem.concat(FlagConta2);
		if (Conta != null) mensagem = mensagem.concat(Conta);
		if (FlagProtocolo != null) mensagem = mensagem.concat(FlagProtocolo);
		if (Protocolo != null) mensagem = mensagem.concat(Protocolo);
		if (FlagDuplCadastro != null) mensagem = mensagem.concat(FlagDuplCadastro);
		if (DuplCadastro != null) mensagem = mensagem.concat(DuplCadastro);
		if (FlagOperadoraSaude != null) mensagem = mensagem.concat(FlagOperadoraSaude);
		if (OperadoraSaude != null) mensagem = mensagem.concat(OperadoraSaude);
		if (AreaReservada2 != null) mensagem = mensagem.concat(AreaReservada2);
		if (AreaReservada3 != null) mensagem = mensagem.concat(AreaReservada3);
		if (FlagTrocoFacil != null) mensagem = mensagem.concat(FlagTrocoFacil);
		if (TrocoFacil != null) mensagem = mensagem.concat(TrocoFacil);
		if (FlagTaxaTrocoFacil != null) mensagem = mensagem.concat(FlagTaxaTrocoFacil);
		if (TaxaTrocoFacil != null) mensagem = mensagem.concat(TaxaTrocoFacil);
		if (FlagPrazoTrocoFacil != null) mensagem = mensagem.concat(FlagPrazoTrocoFacil);
		if (PrazoTrocoFacil != null) mensagem = mensagem.concat(PrazoTrocoFacil);
		if (FlagFlexCar != null) mensagem = mensagem.concat(FlagFlexCar);
		if (FlexCar != null) mensagem = mensagem.concat(FlexCar);
		if (FlagTaxaFlexCar != null) mensagem = mensagem.concat(FlagTaxaFlexCar);
		if (TaxaFlexCar != null) mensagem = mensagem.concat(TaxaFlexCar);
		if (FlagPrazoFlexCar != null) mensagem = mensagem.concat(FlagPrazoFlexCar);
		if (PrazoFlexCar != null) mensagem = mensagem.concat(PrazoFlexCar);
		if (AreaReservada4 != null) mensagem = mensagem.concat(AreaReservada4);
		if (AreaReservada5 != null) mensagem = mensagem.concat(AreaReservada5);
		return mensagem;
	}

	public String getCodigoMensagem() {
		return CodigoMensagem;
	}

	public void setCodigoMensagem(String codigoMensagem) {
		CodigoMensagem = codigoMensagem;
	}

	public String getNumeroInstituicaoFinanceira() {
		return NumeroInstituicaoFinanceira;
	}

	public void setNumeroInstituicaoFinanceira(String numeroInstituicaoFinanceira) {
		NumeroInstituicaoFinanceira = numeroInstituicaoFinanceira;
	}

	public String getNumeroIdentificacaoChamada() {
		return NumeroIdentificacaoChamada;
	}

	public void setNumeroIdentificacaoChamada(String numeroIdentificacaoChamada) {
		NumeroIdentificacaoChamada = numeroIdentificacaoChamada;
	}

	public String getVagoObrigatorio() {
		return VagoObrigatorio;
	}

	public void setVagoObrigatorio(String vagoObrigatorio) {
		VagoObrigatorio = vagoObrigatorio;
	}

	public String getCodigoErro() {
		return CodigoErro;
	}

	public void setCodigoErro(String codigoErro) {
		CodigoErro = codigoErro;
	}

	public String getFlagBanco() {
		return FlagBanco;
	}

	public void setFlagBanco(String flagBanco) {
		FlagBanco = flagBanco;
	}

	public String getBanco() {
		return Banco;
	}

	public void setBanco(String banco) {
		Banco = banco;
	}

	public String getNumeroEstabelecimento() {
		return NumeroEstabelecimento;
	}

	public void setNumeroEstabelecimento(String numeroEstabelecimento) {
		NumeroEstabelecimento = numeroEstabelecimento;
	}

	public String getFlagRazaoSocial() {
		return FlagRazaoSocial;
	}

	public void setFlagRazaoSocial(String flagRazaoSocial) {
		FlagRazaoSocial = flagRazaoSocial;
	}

	public String getRazaoSocialEstabelecimento() {
		return RazaoSocialEstabelecimento;
	}

	public void setRazaoSocialEstabelecimento(String razaoSocialEstabelecimento) {
		RazaoSocialEstabelecimento = razaoSocialEstabelecimento;
	}

	public String getFlagEnderecoCorrespondencia() {
		return FlagEnderecoCorrespondencia;
	}

	public void setFlagEnderecoCorrespondencia(String flagEnderecoCorrespondencia) {
		FlagEnderecoCorrespondencia = flagEnderecoCorrespondencia;
	}

	public String getLogradouroCorrespondencia() {
		return LogradouroCorrespondencia;
	}

	public void setLogradouroCorrespondencia(String logradouroCorrespondencia) {
		LogradouroCorrespondencia = logradouroCorrespondencia;
	}

	public String getComplementoLogradouroCorresp() {
		return ComplementoLogradouroCorresp;
	}

	public void setComplementoLogradouroCorresp(String complementoLogradouroCorresp) {
		ComplementoLogradouroCorresp = complementoLogradouroCorresp;
	}

	public String getFlagCidade() {
		return FlagCidade;
	}

	public void setFlagCidade(String flagCidade) {
		FlagCidade = flagCidade;
	}

	public String getCidadeCorrespondencia() {
		return CidadeCorrespondencia;
	}

	public void setCidadeCorrespondencia(String cidadeCorrespondencia) {
		CidadeCorrespondencia = cidadeCorrespondencia;
	}

	public String getFlagEstado() {
		return FlagEstado;
	}

	public void setFlagEstado(String flagEstado) {
		FlagEstado = flagEstado;
	}

	public String getEstadoCorrespondencia() {
		return EstadoCorrespondencia;
	}

	public void setEstadoCorrespondencia(String estadoCorrespondencia) {
		EstadoCorrespondencia = estadoCorrespondencia;
	}

	public String getFlagCEP() {
		return FlagCEP;
	}

	public void setFlagCEP(String flagCEP) {
		FlagCEP = flagCEP;
	}

	public String getCEPCorrespondencia() {
		return CEPCorrespondencia;
	}

	public void setCEPCorrespondencia(String cEPCorrespondencia) {
		CEPCorrespondencia = cEPCorrespondencia;
	}

	public String getFlagCNPJCPF() {
		return FlagCNPJCPF;
	}

	public void setFlagCNPJCPF(String flagCNPJCPF) {
		FlagCNPJCPF = flagCNPJCPF;
	}

	public String getCNPJCPF() {
		return CNPJCPF;
	}

	public void setCNPJCPF(String cNPJCPF) {
		CNPJCPF = cNPJCPF;
	}

	public String getFlagInscricaoEstadual() {
		return FlagInscricaoEstadual;
	}

	public void setFlagInscricaoEstadual(String flagInscricaoEstadual) {
		FlagInscricaoEstadual = flagInscricaoEstadual;
	}

	public String getInscricaoEstadual() {
		return InscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		InscricaoEstadual = inscricaoEstadual;
	}

	public String getFlagNomeFantasia() {
		return FlagNomeFantasia;
	}

	public void setFlagNomeFantasia(String flagNomeFantasia) {
		FlagNomeFantasia = flagNomeFantasia;
	}

	public String getNomeFantasia() {
		return NomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}

	public String getFlagEnderecoEstabelecimento() {
		return FlagEnderecoEstabelecimento;
	}

	public void setFlagEnderecoEstabelecimento(String flagEnderecoEstabelecimento) {
		FlagEnderecoEstabelecimento = flagEnderecoEstabelecimento;
	}

	public String getLogradouroEstabelecimento() {
		return LogradouroEstabelecimento;
	}

	public void setLogradouroEstabelecimento(String logradouroEstabelecimento) {
		LogradouroEstabelecimento = logradouroEstabelecimento;
	}

	public String getComplementoLogradouroEstabelecimento() {
		return ComplementoLogradouroEstabelecimento;
	}

	public void setComplementoLogradouroEstabelecimento(String complementoLogradouroEstabelecimento) {
		ComplementoLogradouroEstabelecimento = complementoLogradouroEstabelecimento;
	}

	public String getFlagCidadeEstabelecimento() {
		return FlagCidadeEstabelecimento;
	}

	public void setFlagCidadeEstabelecimento(String flagCidadeEstabelecimento) {
		FlagCidadeEstabelecimento = flagCidadeEstabelecimento;
	}

	public String getCidadeEstabelecimento() {
		return CidadeEstabelecimento;
	}

	public void setCidadeEstabelecimento(String cidadeEstabelecimento) {
		CidadeEstabelecimento = cidadeEstabelecimento;
	}

	public String getFlagEstadoEstabelecimento() {
		return FlagEstadoEstabelecimento;
	}

	public void setFlagEstadoEstabelecimento(String flagEstadoEstabelecimento) {
		FlagEstadoEstabelecimento = flagEstadoEstabelecimento;
	}

	public String getEstadoEstabelecimento() {
		return EstadoEstabelecimento;
	}

	public void setEstadoEstabelecimento(String estadoEstabelecimento) {
		EstadoEstabelecimento = estadoEstabelecimento;
	}

	public String getFlagCEPEstabelecimento() {
		return FlagCEPEstabelecimento;
	}

	public void setFlagCEPEstabelecimento(String flagCEPEstabelecimento) {
		FlagCEPEstabelecimento = flagCEPEstabelecimento;
	}

	public String getCEPEstabelecimento() {
		return CEPEstabelecimento;
	}

	public void setCEPEstabelecimento(String cEPEstabelecimento) {
		CEPEstabelecimento = cEPEstabelecimento;
	}

	public String getFlagNomePlaqueta() {
		return FlagNomePlaqueta;
	}

	public void setFlagNomePlaqueta(String flagNomePlaqueta) {
		FlagNomePlaqueta = flagNomePlaqueta;
	}

	public String getNomePlaqueta() {
		return NomePlaqueta;
	}

	public void setNomePlaqueta(String nomePlaqueta) {
		NomePlaqueta = nomePlaqueta;
	}

	public String getFlagPessoaParaContato() {
		return FlagPessoaParaContato;
	}

	public void setFlagPessoaParaContato(String flagPessoaParaContato) {
		FlagPessoaParaContato = flagPessoaParaContato;
	}

	public String getPessoaParaContato() {
		return PessoaParaContato;
	}

	public void setPessoaParaContato(String pessoaParaContato) {
		PessoaParaContato = pessoaParaContato;
	}

	public String getFiller() {
		return Filler;
	}

	public void setFiller(String filler) {
		Filler = filler;
	}

	public String getReservadoCliente1() {
		return ReservadoCliente1;
	}

	public void setReservadoCliente1(String reservadoCliente1) {
		ReservadoCliente1 = reservadoCliente1;
	}

	public String getReservadoCliente2() {
		return ReservadoCliente2;
	}

	public void setReservadoCliente2(String reservadoCliente2) {
		ReservadoCliente2 = reservadoCliente2;
	}

	public String getFlagRamoAtividade() {
		return FlagRamoAtividade;
	}

	public void setFlagRamoAtividade(String flagRamoAtividade) {
		FlagRamoAtividade = flagRamoAtividade;
	}

	public String getCodigoRamoAtividade() {
		return CodigoRamoAtividade;
	}

	public void setCodigoRamoAtividade(String codigoRamoAtividade) {
		CodigoRamoAtividade = codigoRamoAtividade;
	}

	public String getFlagAgencia() {
		return FlagAgencia;
	}

	public void setFlagAgencia(String flagAgencia) {
		FlagAgencia = flagAgencia;
	}

	public String getCodigoAgencia() {
		return CodigoAgencia;
	}

	public void setCodigoAgencia(String codigoAgencia) {
		CodigoAgencia = codigoAgencia;
	}

	public String getFlagContaCorrente() {
		return FlagContaCorrente;
	}

	public void setFlagContaCorrente(String flagContaCorrente) {
		FlagContaCorrente = flagContaCorrente;
	}

	public String getNumeroContaCorrente() {
		return NumeroContaCorrente;
	}

	public void setNumeroContaCorrente(String numeroContaCorrente) {
		NumeroContaCorrente = numeroContaCorrente;
	}

	public String getFlagNomeProprietario1() {
		return FlagNomeProprietario1;
	}

	public void setFlagNomeProprietario1(String flagNomeProprietario1) {
		FlagNomeProprietario1 = flagNomeProprietario1;
	}

	public String getNomeProprietario1() {
		return NomeProprietario1;
	}

	public void setNomeProprietario1(String nomeProprietario1) {
		NomeProprietario1 = nomeProprietario1;
	}

	public String getFlagCPFProprietario1() {
		return FlagCPFProprietario1;
	}

	public void setFlagCPFProprietario1(String flagCPFProprietario1) {
		FlagCPFProprietario1 = flagCPFProprietario1;
	}

	public String getCPFProprietario1() {
		return CPFProprietario1;
	}

	public void setCPFProprietario1(String cPFProprietario1) {
		CPFProprietario1 = cPFProprietario1;
	}

	public String getFlagDataNascimentoProprietario1() {
		return FlagDataNascimentoProprietario1;
	}

	public void setFlagDataNascimentoProprietario1(String flagDataNascimentoProprietario1) {
		FlagDataNascimentoProprietario1 = flagDataNascimentoProprietario1;
	}

	public String getDataNascimentoProprietario1() {
		return DataNascimentoProprietario1;
	}

	public void setDataNascimentoProprietario1(String dataNascimentoProprietario1) {
		DataNascimentoProprietario1 = dataNascimentoProprietario1;
	}

	public String getFlagNomeProprietario2() {
		return FlagNomeProprietario2;
	}

	public void setFlagNomeProprietario2(String flagNomeProprietario2) {
		FlagNomeProprietario2 = flagNomeProprietario2;
	}

	public String getNomeProprietario2() {
		return NomeProprietario2;
	}

	public void setNomeProprietario2(String nomeProprietario2) {
		NomeProprietario2 = nomeProprietario2;
	}

	public String getFlagCPFProprietario2() {
		return FlagCPFProprietario2;
	}

	public void setFlagCPFProprietario2(String flagCPFProprietario2) {
		FlagCPFProprietario2 = flagCPFProprietario2;
	}

	public String getCPFProprietario2() {
		return CPFProprietario2;
	}

	public void setCPFProprietario2(String cPFProprietario2) {
		CPFProprietario2 = cPFProprietario2;
	}

	public String getFlagDataNascimentoProprietario2() {
		return FlagDataNascimentoProprietario2;
	}

	public void setFlagDataNascimentoProprietario2(String flagDataNascimentoProprietario2) {
		FlagDataNascimentoProprietario2 = flagDataNascimentoProprietario2;
	}

	public String getDataNascimentoProprietario2() {
		return DataNascimentoProprietario2;
	}

	public void setDataNascimentoProprietario2(String dataNascimentoProprietario2) {
		DataNascimentoProprietario2 = dataNascimentoProprietario2;
	}

	public String getFlagNomeProprietario3() {
		return FlagNomeProprietario3;
	}

	public void setFlagNomeProprietario3(String flagNomeProprietario3) {
		FlagNomeProprietario3 = flagNomeProprietario3;
	}

	public String getNomeProprietario3() {
		return NomeProprietario3;
	}

	public void setNomeProprietario3(String nomeProprietario3) {
		NomeProprietario3 = nomeProprietario3;
	}

	public String getFlagCPFProprietario3() {
		return FlagCPFProprietario3;
	}

	public void setFlagCPFProprietario3(String flagCPFProprietario3) {
		FlagCPFProprietario3 = flagCPFProprietario3;
	}

	public String getCPFProprietario3() {
		return CPFProprietario3;
	}

	public void setCPFProprietario3(String cPFProprietario3) {
		CPFProprietario3 = cPFProprietario3;
	}

	public String getFlagDataNascimentoProprietario3() {
		return FlagDataNascimentoProprietario3;
	}

	public void setFlagDataNascimentoProprietario3(String flagDataNascimentoProprietario3) {
		FlagDataNascimentoProprietario3 = flagDataNascimentoProprietario3;
	}

	public String getDataNascimentoProprietario3() {
		return DataNascimentoProprietario3;
	}

	public void setDataNascimentoProprietario3(String dataNascimentoProprietario3) {
		DataNascimentoProprietario3 = dataNascimentoProprietario3;
	}

	public String getFlagTipoPessoa() {
		return FlagTipoPessoa;
	}

	public void setFlagTipoPessoa(String flagTipoPessoa) {
		FlagTipoPessoa = flagTipoPessoa;
	}

	public String getTipoPessoa() {
		return TipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		TipoPessoa = tipoPessoa;
	}

	public String getFlagCentroCompras() {
		return FlagCentroCompras;
	}

	public void setFlagCentroCompras(String flagCentroCompras) {
		FlagCentroCompras = flagCentroCompras;
	}

	public String getCentroCompras() {
		return CentroCompras;
	}

	public void setCentroCompras(String centroCompras) {
		CentroCompras = centroCompras;
	}

	public String getFlagTipoTerminal() {
		return FlagTipoTerminal;
	}

	public void setFlagTipoTerminal(String flagTipoTerminal) {
		FlagTipoTerminal = flagTipoTerminal;
	}

	public String getTipoTerminal() {
		return TipoTerminal;
	}

	public void setTipoTerminal(String tipoTerminal) {
		TipoTerminal = tipoTerminal;
	}

	public String getFlagComplementoMCC() {
		return FlagComplementoMCC;
	}

	public void setFlagComplementoMCC(String flagComplementoMCC) {
		FlagComplementoMCC = flagComplementoMCC;
	}

	public String getComplementoMCC() {
		return ComplementoMCC;
	}

	public void setComplementoMCC(String complementoMCC) {
		ComplementoMCC = complementoMCC;
	}

	public String getFlagIndicadorMobile() {
		return FlagIndicadorMobile;
	}

	public void setFlagIndicadorMobile(String flagIndicadorMobile) {
		FlagIndicadorMobile = flagIndicadorMobile;
	}

	public String getIndicadorMobile() {
		return IndicadorMobile;
	}

	public void setIndicadorMobile(String indicadorMobile) {
		IndicadorMobile = indicadorMobile;
	}

	public String getFlagDDDTelefoneComercial() {
		return FlagDDDTelefoneComercial;
	}

	public void setFlagDDDTelefoneComercial(String flagDDDTelefoneComercial) {
		FlagDDDTelefoneComercial = flagDDDTelefoneComercial;
	}

	public String getDDDTelefoneComercial() {
		return DDDTelefoneComercial;
	}

	public void setDDDTelefoneComercial(String dDDTelefoneComercial) {
		DDDTelefoneComercial = dDDTelefoneComercial;
	}

	public String getFlagTelefoneComercial() {
		return FlagTelefoneComercial;
	}

	public void setFlagTelefoneComercial(String flagTelefoneComercial) {
		FlagTelefoneComercial = flagTelefoneComercial;
	}

	public String getNumeroTelefoneComercial() {
		return NumeroTelefoneComercial;
	}

	public void setNumeroTelefoneComercial(String numeroTelefoneComercial) {
		NumeroTelefoneComercial = numeroTelefoneComercial;
	}

	public String getFlagDDDTelefoneCelular() {
		return FlagDDDTelefoneCelular;
	}

	public void setFlagDDDTelefoneCelular(String flagDDDTelefoneCelular) {
		FlagDDDTelefoneCelular = flagDDDTelefoneCelular;
	}

	public String getDDDTelefoneCelular() {
		return DDDTelefoneCelular;
	}

	public void setDDDTelefoneCelular(String dDDTelefoneCelular) {
		DDDTelefoneCelular = dDDTelefoneCelular;
	}

	public String getFlagTelefoneCelular() {
		return FlagTelefoneCelular;
	}

	public void setFlagTelefoneCelular(String flagTelefoneCelular) {
		FlagTelefoneCelular = flagTelefoneCelular;
	}

	public String getNumeroTelefoneCelular() {
		return NumeroTelefoneCelular;
	}

	public void setNumeroTelefoneCelular(String numeroTelefoneCelular) {
		NumeroTelefoneCelular = numeroTelefoneCelular;
	}

	public String getFlagMEI() {
		return FlagMEI;
	}

	public void setFlagMEI(String flagMEI) {
		FlagMEI = flagMEI;
	}

	public String getClienteMEI() {
		return ClienteMEI;
	}

	public void setClienteMEI(String clienteMEI) {
		ClienteMEI = clienteMEI;
	}

	public String getAreaReservada1() {
		return AreaReservada1;
	}

	public void setAreaReservada1(String areaReservada1) {
		AreaReservada1 = areaReservada1;
	}

	public String getDadosInformais() {
		return DadosInformais;
	}

	public void setDadosInformais(String dadosInformais) {
		DadosInformais = dadosInformais;
	}

	public String getDataAfiliacao() {
		return DataAfiliacao;
	}

	public void setDataAfiliacao(String dataAfiliacao) {
		DataAfiliacao = dataAfiliacao;
	}

	public String getFlagBanco2() {
		return FlagBanco2;
	}

	public void setFlagBanco2(String flagBanco2) {
		FlagBanco2 = flagBanco2;
	}

	public String getBanco2() {
		return Banco2;
	}

	public void setBanco2(String banco2) {
		Banco2 = banco2;
	}

	public String getFlagAgencia2() {
		return FlagAgencia2;
	}

	public void setFlagAgencia2(String flagAgencia2) {
		FlagAgencia2 = flagAgencia2;
	}

	public String getAgencia2() {
		return Agencia2;
	}

	public void setAgencia2(String agencia2) {
		Agencia2 = agencia2;
	}

	public String getFlagConta2() {
		return FlagConta2;
	}

	public void setFlagConta2(String flagConta2) {
		FlagConta2 = flagConta2;
	}

	public String getConta() {
		return Conta;
	}

	public void setConta(String conta) {
		Conta = conta;
	}

	public String getFlagProtocolo() {
		return FlagProtocolo;
	}

	public void setFlagProtocolo(String flagProtocolo) {
		FlagProtocolo = flagProtocolo;
	}

	public String getProtocolo() {
		return Protocolo;
	}

	public void setProtocolo(String protocolo) {
		Protocolo = protocolo;
	}

	public String getFlagDuplCadastro() {
		return FlagDuplCadastro;
	}

	public void setFlagDuplCadastro(String flagDuplCadastro) {
		FlagDuplCadastro = flagDuplCadastro;
	}

	public String getDuplCadastro() {
		return DuplCadastro;
	}

	public void setDuplCadastro(String duplCadastro) {
		DuplCadastro = duplCadastro;
	}

	public String getFlagOperadoraSaude() {
		return FlagOperadoraSaude;
	}

	public void setFlagOperadoraSaude(String flagOperadoraSaude) {
		FlagOperadoraSaude = flagOperadoraSaude;
	}

	public String getOperadoraSaude() {
		return OperadoraSaude;
	}

	public void setOperadoraSaude(String operadoraSaude) {
		OperadoraSaude = operadoraSaude;
	}

	public String getAreaReservada2() {
		return AreaReservada2;
	}

	public void setAreaReservada2(String areaReservada2) {
		AreaReservada2 = areaReservada2;
	}

	public String getAreaReservada3() {
		return AreaReservada3;
	}

	public void setAreaReservada3(String areaReservada3) {
		AreaReservada3 = areaReservada3;
	}

	public String getFlagTrocoFacil() {
		return FlagTrocoFacil;
	}

	public void setFlagTrocoFacil(String flagTrocoFacil) {
		FlagTrocoFacil = flagTrocoFacil;
	}

	public String getTrocoFacil() {
		return TrocoFacil;
	}

	public void setTrocoFacil(String trocoFacil) {
		TrocoFacil = trocoFacil;
	}

	public String getFlagTaxaTrocoFacil() {
		return FlagTaxaTrocoFacil;
	}

	public void setFlagTaxaTrocoFacil(String flagTaxaTrocoFacil) {
		FlagTaxaTrocoFacil = flagTaxaTrocoFacil;
	}

	public String getTaxaTrocoFacil() {
		return TaxaTrocoFacil;
	}

	public void setTaxaTrocoFacil(String taxaTrocoFacil) {
		TaxaTrocoFacil = taxaTrocoFacil;
	}

	public String getFlagPrazoTrocoFacil() {
		return FlagPrazoTrocoFacil;
	}

	public void setFlagPrazoTrocoFacil(String flagPrazoTrocoFacil) {
		FlagPrazoTrocoFacil = flagPrazoTrocoFacil;
	}

	public String getPrazoTrocoFacil() {
		return PrazoTrocoFacil;
	}

	public void setPrazoTrocoFacil(String prazoTrocoFacil) {
		PrazoTrocoFacil = prazoTrocoFacil;
	}

	public String getFlagFlexCar() {
		return FlagFlexCar;
	}

	public void setFlagFlexCar(String flagFlexCar) {
		FlagFlexCar = flagFlexCar;
	}

	public String getFlexCar() {
		return FlexCar;
	}

	public void setFlexCar(String flexCar) {
		FlexCar = flexCar;
	}

	public String getFlagTaxaFlexCar() {
		return FlagTaxaFlexCar;
	}

	public void setFlagTaxaFlexCar(String flagTaxaFlexCar) {
		FlagTaxaFlexCar = flagTaxaFlexCar;
	}

	public String getTaxaFlexCar() {
		return TaxaFlexCar;
	}

	public void setTaxaFlexCar(String taxaFlexCar) {
		TaxaFlexCar = taxaFlexCar;
	}

	public String getFlagPrazoFlexCar() {
		return FlagPrazoFlexCar;
	}

	public void setFlagPrazoFlexCar(String flagPrazoFlexCar) {
		FlagPrazoFlexCar = flagPrazoFlexCar;
	}

	public String getPrazoFlexCar() {
		return PrazoFlexCar;
	}

	public void setPrazoFlexCar(String prazoFlexCar) {
		PrazoFlexCar = prazoFlexCar;
	}

	public String getAreaReservada4() {
		return AreaReservada4;
	}

	public void setAreaReservada4(String areaReservada4) {
		AreaReservada4 = areaReservada4;
	}

	public String getAreaReservada5() {
		return AreaReservada5;
	}

	public void setAreaReservada5(String areaReservada5) {
		AreaReservada5 = areaReservada5;
	}
}