package br.com.empresa.almintegration.testing.tn3270;

import java.util.List;

import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;

public class G120 {
	
	public enum OPTIONS{
		Inclusao("I"),Atualizacao("A"),Edicao("E"),Consulta("C");
		String opcao;
		OPTIONS(String opcao){
			this.opcao = opcao;
		}
	};

	private static final String optionLabel = "OPCAO I/A/E/C:";
	private Field optionField;
	private static final String codEstabLabel = "COD ESTB:";
	private Field codEstabField;
	private static final String suffixEstabLabel = "/";
	private Field suffixEstabField;
	private static final String prdMTZLabel = "PRD MTZ.:";
	private String prdMTZValue;

	private static final String prdSECLabel = "PRD SEC.:";
	private String prdSECValue;

	private static final String dataInclusaoLabel = "DATA INCLUSAO:";
	private String dataInclusaoVALUE;

	private static final String alteracaoLabel = "ALTERACAO:";
	private String alteracaoValue;

	private static final String situacaoLabel = "SITUACAO:";
	private String situacaoValue;

	private static final String nomeLabel = "NOME.........:";
	private String nomeValue;

	private static final String reduzidoLabel = "REDUZIDO:";
	private String reduzidoValue;

	private static final String enderecoLabel = "ENDERECO.....:";
	private String enderecoValue;

	private static final String cepLabel = "CEP.....:";
	private String cepValue;

	private static final String cidadeLabel = "CIDADE.......:";
	private String cidadeValue;

	private static final String ufLabel = "U.F.....:";
	private String uFValue;

	private static final String bairroLabel = "BAIRRO.......:";
	private String bairroValue;

	private static final String dddLabel = "DDD:";
	private String dddValue;

	private static final String telefoneLabel = "TELEFONE:";
	private String telefoneValue;

	private static final String nomeComprovLabel = "NOME COMPROV.:";
	private String nomeComprovValue;

	private static final String moedaLabel = "MOEDA...:";
	private String moedaValue;

	private static final String endComprovLabel = "END. COMPROV.:";
	private String endComprovValue;

	private static final String paisLabel = "PAIS....:";
	private String paisValue;

	private static final String cgcCPFLabel = "CGC/CPF......:";
	private String cgcCPFValue;

	private static final String tpPessoaLabel = "TP PESSOA:";
	private String tpPESSOAVALUE;

	private static final String msgECFLabel = "MSG ECF.:";
	private String msgECFValue;

	private static final String parceriaLabel = "PARCERIA.....:";
	private String parceriaValue;

	private static final String avsLabel = "AVS.:";
	private String avsValue;

	private static final String srvMKPLabel = "SRV MKP..:";
	private String srvMKPValue;

	private static final String ppLabel = "PP.:";
	private String ppValue;

	private static final String malaDiretaLabel = "MALA DIRETA..:";
	private String malaDiretaValue;

	private static final String grpImgLabel = " GRP IMG:";
	private String grpImgValue;

	private static final String mccLabel = "MCC:";
	private String mccValue;

	private static final String lmtHRFLOTLabel = "LMT HR F.LOT:";
	private String lmtHRFLOTValue;

	private static final String clFaturLabel = "CL. FATUR....:";
	private String clFaturValue;

	private static final String solECOMLabel = "SOL E-COM:";
	private String solECOMValue;

	private static final String grInfAdicLabel = "GR INF ADIC:";
	private String grInfAdicValue;

	private static final String estabelecLabel = "ESTABELEC....:";
	private String estabelecValue;

	private static final String alugadoLabel = "ALUGADO.:";
	private String alugadoValue;

	private static final String comodatoLabel = "COMODATO:";
	private String comodatoValue;

	private static final String redecardLabel = "REDECARD:";
	private String redecardValue;

	private static final String outrosLabel = "OUTROS..:";
	private String outrosValue;

	private static final String telefoneEstabelecLabel = "TELEFONE.....:";
	private String telefoneEstabelecValue;

	private static final String multiECLabel = "MULTI EC:";
	private String multiECVALUE;

	private static final String anlsFRDLabel = "ANLS FRD:";
	private String anlsFRDVALUE;

	private static final String cartaoPresenteLabel = "CARTAO PRESENTE:";
	private String cartaoPresenteVALUE;

	private static final String autTercLabel = "AUT TERC:";
	private String autTercValue;

	private static final String internetLabel = "INTERNET.....:";
	private String internetValue;

	private static final String pgtRecorLabel = "PGT RECOR:";
	private String pgtRecorValue;

	private static final String multivanLabel = "MULTIVAN:";
	private String multivanValue;

	private static final String bloqInternacLabel = "BLOQ. INTERNAC.:";
	private String bloqInternacValue;

	private static final String autParcLabel = "AUT PARC:";
	private String autParcValue;

	private static final String reentradaLabel = "REENTRADA....:";
	private String reentradaValue;

	private static final String bloqueadoLabel = "BLOQUEADO:";
	private String bloqueadoValue;

	private static final String stLabel = "ST:";
	private String stValue;

	private static final String motLabel = "MOT:";
	private String motValue;

	private static final String zonaFRLabel = "ZONA FR:";
	private String zonaFRValue;

	private static final String migBOBLabel = "MIG BOB.:";
	private String migBOBValue;

	private static final String correspBCOLabel = "CORRESP BCO..:";
	private String correspBCOValue;

	private static final String cartIntNAutEnLabel = "CART INT N.AUTEN:";
	private String cartIntNAutEnValue;

	private static final String bListLabel = "B.LIST:";
	private String bListValue;

	private static final String grpPrivateLabel = "GRP PRIVATE:";
	private String grpPrivateValue;

	private static final String msgLabel = "MSG.:";
	private String msgValue;

	private static final String idFBLabel = "ID FB........:";
	private String idFBValue;

	private static final String reentXBandLabel = "REENT X BAND.:";
	private String reentXBandValue;

	private static final String visaLabel = "VISA ";
	private String visaValue;

	private static final String amexLabel = "AMEX ";
	private String amexValue;

	private static final String eloLabel = "ELO  ";
	private String eloValue;

	private static final String jcbLabel = "JCB  ";
	private String jcbValue;

	private static final String cargaMoedeiroLabel = "CARGA MOEDEIRO:";
	private String cargaMoedeiroValue;

	private static final String digNRCartaoLabel = " DIG NR CARTAO.:";
	private String digNRCartaoValue;

	private static final String TruncCartaoLabel = " TRUNC CARTAO..:";
	private String TruncCartaoValue;

	private static final String SOLDig4UltLabel = " SOL DIG 4 ULT.:";
	private String SOLDig4UltValue;

	private static final String fallBackLabel = "FALL-BACK.....:";
	private String fallBackValue;

	private static final String OffLineLabel = " OFF-LINE......:";
	private String OffLineValue;

	private static final String disSaldoLabel = " DIS SALDO.....:";
	private String disSaldoValue;

	private static final String cvv2DigLabel = " CVV2 DIG......:";
	private String cvv2DigValue;

	private static final String pswSupervisorLabel = "PSW SUPERVISOR:";
	private String pswSupervisorValue;

	private static final String eleTrocoLabel = " ELETROCO......:";
	private String eleTrocoValue;

	private static final String impSaldoLabel = " IMP SALDO.....:";
	private String impSaldoValue;

	private static final String cvv2TrilhaLabel = " CVV2 TRILHA...:";
	private String cvv2TrilhaValue;

	private static final String permiteDCCLabel = " PERMITE DCC...:";
	private String permiteDCCValue;

	private static final String impValRecargLabel = " IMP VAL RECARG:";
	private String impValRecargValue;

	private static final String impDGTCartaoLabel = " IMP DGT CARTAO:";
	private String impDGTCartaoValue;

	private static final String solPSWLabel = " SOL PSW.......:";
	private String solPSWValue;

	private static final String impCodBarrasLabel = " IMP COD BARRAS:";
	private String impCodBarrasValue;

	private static final String obrigaSenhaLabel = " OBRIGA SENHA..:";
	private String obrigaSenhaValue;

	private static final String taxaEmbarqueLabel = " TAXA EMBARQUE.:";
	private String taxaEmbarqueValue;

	private static final String scodeX4DigLabel = " S.CODE X 4 DIG:";
	private String scodeX4DigValue;

	private static final String chkVlDupLabel = " CHK VL DUP....:";
	private String chkVlDupValue;

	private static final String naoUsadoLabel = "NAO USADO.....:";
	private String naoUsadoValue;

	private static final String taxaServicoLabel = " TAXA SERVICO..:";
	private String taxaServicoValue;

	private static final String scodeXCVV2Label = " S.CODE X CVV2.:";
	private String scodeXCVV2Value;

	private static final String chkVlDupPreLabel = " CHK VL DUP PRE:";
	private String chkVlDupPreValue;

	Mainframe mf;

	public G120() {
		mf = Mainframe.getInstance();
		List<Field> fields = mf.getS3270().getScreen().getFields();
		populateFirstPage(fields);
		mf.pf(8);
		fields = mf.getS3270().getScreen().getFields();
		populateSecondPage(fields);
	}

	public void populateFirstPage(List<Field> fields) {
		prdMTZValue = mf.getFieldValues(new FieldIdentifier(prdMTZLabel));
		prdSECValue = mf.getFieldValues(new FieldIdentifier(prdSECLabel));
		dataInclusaoVALUE = mf.getFieldValues(new FieldIdentifier(dataInclusaoLabel));
		alteracaoValue = mf.getFieldValues(new FieldIdentifier(alteracaoLabel));
		situacaoValue = mf.getFieldValues(new FieldIdentifier(situacaoLabel));
		nomeValue = mf.getFieldValues(new FieldIdentifier(nomeLabel));
		reduzidoValue = mf.getFieldValues(new FieldIdentifier(reduzidoLabel));
		enderecoValue = mf.getFieldValues(new FieldIdentifier(enderecoLabel));
		cepValue = mf.getFieldValues(new FieldIdentifier(cepLabel));
		cidadeValue = mf.getFieldValues(new FieldIdentifier(cidadeLabel));
		uFValue = mf.getFieldValues(new FieldIdentifier(ufLabel));
		bairroValue = mf.getFieldValues(new FieldIdentifier(bairroLabel));
		dddValue = mf.getFieldValues(new FieldIdentifier(dddLabel));
		telefoneValue = mf.getFieldValues(new FieldIdentifier(telefoneLabel));
		nomeComprovValue = mf.getFieldValues(new FieldIdentifier(nomeComprovLabel));
		moedaValue = mf.getFieldValues(new FieldIdentifier(moedaLabel));
		endComprovValue = mf.getFieldValues(new FieldIdentifier(endComprovLabel));
		paisValue = mf.getFieldValues(new FieldIdentifier(paisLabel));
		cgcCPFValue = mf.getFieldValues(new FieldIdentifier(cgcCPFLabel));
		tpPESSOAVALUE = mf.getFieldValues(new FieldIdentifier(tpPessoaLabel));
		msgECFValue = mf.getFieldValues(new FieldIdentifier(msgECFLabel));
		parceriaValue = mf.getFieldValues(new FieldIdentifier(parceriaLabel));
		avsValue = mf.getFieldValues(new FieldIdentifier(avsLabel));
		srvMKPValue = mf.getFieldValues(new FieldIdentifier(srvMKPLabel));
		ppValue = mf.getFieldValues(new FieldIdentifier(ppLabel));
		malaDiretaValue = mf.getFieldValues(new FieldIdentifier(malaDiretaLabel));
		grpImgValue = mf.getFieldValues(new FieldIdentifier(grpImgLabel));
		mccValue = mf.getFieldValues(new FieldIdentifier(mccLabel));
		lmtHRFLOTValue = mf.getFieldValues(new FieldIdentifier(lmtHRFLOTLabel));
		clFaturValue = mf.getFieldValues(new FieldIdentifier(clFaturLabel));
		solECOMValue = mf.getFieldValues(new FieldIdentifier(solECOMLabel));
		grInfAdicValue = mf.getFieldValues(new FieldIdentifier(grInfAdicLabel));
		estabelecValue = mf.getFieldValues(new FieldIdentifier(estabelecLabel));
		alugadoValue = mf.getFieldValues(new FieldIdentifier(alugadoLabel));
		comodatoValue = mf.getFieldValues(new FieldIdentifier(comodatoLabel));
		redecardValue = mf.getFieldValues(new FieldIdentifier(redecardLabel));
		outrosValue = mf.getFieldValues(new FieldIdentifier(outrosLabel));
		telefoneEstabelecValue = mf.getFieldValues(new FieldIdentifier(telefoneEstabelecLabel));
		multiECVALUE = mf.getFieldValues(new FieldIdentifier(multiECLabel));
		anlsFRDVALUE = mf.getFieldValues(new FieldIdentifier(anlsFRDLabel));
		cartaoPresenteVALUE = mf.getFieldValues(new FieldIdentifier(cartaoPresenteLabel));
		autTercValue = mf.getFieldValues(new FieldIdentifier(autTercLabel));
		internetValue = mf.getFieldValues(new FieldIdentifier(internetLabel));
		pgtRecorValue = mf.getFieldValues(new FieldIdentifier(pgtRecorLabel));
		multivanValue = mf.getFieldValues(new FieldIdentifier(multivanLabel));
		bloqInternacValue = mf.getFieldValues(new FieldIdentifier(bloqInternacLabel));
		autParcValue = mf.getFieldValues(new FieldIdentifier(autParcLabel));
		reentradaValue = mf.getFieldValues(new FieldIdentifier(reentradaLabel));
		bloqueadoValue = mf.getFieldValues(new FieldIdentifier(bloqueadoLabel));
		stValue = mf.getFieldValues(new FieldIdentifier(stLabel));
		motValue = mf.getFieldValues(new FieldIdentifier(motLabel));
		zonaFRValue = mf.getFieldValues(new FieldIdentifier(zonaFRLabel));
		migBOBValue = mf.getFieldValues(new FieldIdentifier(migBOBLabel));
		correspBCOValue = mf.getFieldValues(new FieldIdentifier(correspBCOLabel));
		cartIntNAutEnValue = mf.getFieldValues(new FieldIdentifier(cartIntNAutEnLabel));
		bListValue = mf.getFieldValues(new FieldIdentifier(bListLabel));
		grpPrivateValue = mf.getFieldValues(new FieldIdentifier(grpPrivateLabel));
		msgValue = mf.getFieldValues(new FieldIdentifier(msgLabel));
	}
	
	public void populateSecondPage(List<Field> fields){
		idFBValue = mf.getFieldValues(new FieldIdentifier(idFBLabel));
		reentXBandValue = mf.getFieldValues(new FieldIdentifier(reentXBandLabel));
		visaValue = mf.getFieldValues(new FieldIdentifier(visaLabel));
		amexValue = mf.getFieldValues(new FieldIdentifier(amexLabel));
		eloValue = mf.getFieldValues(new FieldIdentifier(eloLabel));
		jcbValue = mf.getFieldValues(new FieldIdentifier(jcbLabel));
		cargaMoedeiroValue = mf.getFieldValues(new FieldIdentifier(cargaMoedeiroLabel));
		digNRCartaoValue = mf.getFieldValues(new FieldIdentifier(digNRCartaoLabel));
		TruncCartaoValue = mf.getFieldValues(new FieldIdentifier(TruncCartaoLabel));
		SOLDig4UltValue = mf.getFieldValues(new FieldIdentifier(SOLDig4UltLabel));
		fallBackValue = mf.getFieldValues(new FieldIdentifier(fallBackLabel));
		OffLineValue = mf.getFieldValues(new FieldIdentifier(OffLineLabel));
		disSaldoValue = mf.getFieldValues(new FieldIdentifier(disSaldoLabel));
		cvv2DigValue = mf.getFieldValues(new FieldIdentifier(cvv2DigLabel));
		pswSupervisorValue = mf.getFieldValues(new FieldIdentifier(pswSupervisorLabel));
		eleTrocoValue = mf.getFieldValues(new FieldIdentifier(eleTrocoLabel));
		impSaldoValue = mf.getFieldValues(new FieldIdentifier(impSaldoLabel));
		cvv2TrilhaValue = mf.getFieldValues(new FieldIdentifier(cvv2TrilhaLabel));
		permiteDCCValue = mf.getFieldValues(new FieldIdentifier(permiteDCCLabel));
		impValRecargValue = mf.getFieldValues(new FieldIdentifier(impValRecargLabel));
		impDGTCartaoValue = mf.getFieldValues(new FieldIdentifier(impDGTCartaoLabel));
		solPSWValue = mf.getFieldValues(new FieldIdentifier(solPSWLabel));
		impCodBarrasValue = mf.getFieldValues(new FieldIdentifier(impCodBarrasLabel));
		obrigaSenhaValue = mf.getFieldValues(new FieldIdentifier(obrigaSenhaLabel));
		taxaEmbarqueValue = mf.getFieldValues(new FieldIdentifier(taxaEmbarqueLabel));
		scodeX4DigValue = mf.getFieldValues(new FieldIdentifier(scodeX4DigLabel));
		chkVlDupValue = mf.getFieldValues(new FieldIdentifier(chkVlDupLabel));
		naoUsadoValue = mf.getFieldValues(new FieldIdentifier(naoUsadoLabel));
		taxaServicoValue = mf.getFieldValues(new FieldIdentifier(taxaServicoLabel));
		scodeXCVV2Value = mf.getFieldValues(new FieldIdentifier(scodeXCVV2Label));
		chkVlDupPreValue = mf.getFieldValues(new FieldIdentifier(chkVlDupPreLabel));
	}
	
	/**
	 * @param optionField the optionField to set
	 */
	public static void setOptionField(OPTIONS option) {
		((InputField)Mainframe.getInstance().getField(new FieldIdentifier(optionLabel))).setValue(option.opcao);
	}
	/**
	 * @param codEstabField the codEstabField to set
	 */
	public static void setCodEstabField(String codEstabField) {
		((InputField)Mainframe.getInstance().getField(new FieldIdentifier(codEstabLabel))).setValue(codEstabField);
	}
	/**
	 * @param suffixEstabField the suffixEstabField to set
	 */
	public static void setSuffixEstabField(String suffixEstabField) {
		((InputField)Mainframe.getInstance().getS3270().getScreen().getFields().get(18)).setValue(suffixEstabField);
	}

	/**
	 * @return the prdMTZValue
	 */
	public String getPrdMTZValue() {
		return prdMTZValue;
	}

	/**
	 * @param prdMTZValue the prdMTZValue to set
	 */
	public void setPrdMTZValue(String prdMTZValue) {
		this.prdMTZValue = prdMTZValue;
	}

	/**
	 * @return the prdSECValue
	 */
	public String getPrdSECValue() {
		return prdSECValue;
	}

	/**
	 * @param prdSECValue the prdSECValue to set
	 */
	public void setPrdSECValue(String prdSECValue) {
		this.prdSECValue = prdSECValue;
	}

	/**
	 * @return the dataInclusaoVALUE
	 */
	public String getDataInclusaoVALUE() {
		return dataInclusaoVALUE;
	}

	/**
	 * @param dataInclusaoVALUE the dataInclusaoVALUE to set
	 */
	public void setDataInclusaoVALUE(String dataInclusaoVALUE) {
		this.dataInclusaoVALUE = dataInclusaoVALUE;
	}

	/**
	 * @return the alteracaoValue
	 */
	public String getAlteracaoValue() {
		return alteracaoValue;
	}

	/**
	 * @param alteracaoValue the alteracaoValue to set
	 */
	public void setAlteracaoValue(String alteracaoValue) {
		this.alteracaoValue = alteracaoValue;
	}

	/**
	 * @return the situacaoValue
	 */
	public String getSituacaoValue() {
		return situacaoValue;
	}

	/**
	 * @param situacaoValue the situacaoValue to set
	 */
	public void setSituacaoValue(String situacaoValue) {
		this.situacaoValue = situacaoValue;
	}

	/**
	 * @return the nomeValue
	 */
	public String getNomeValue() {
		return nomeValue;
	}

	/**
	 * @param nomeValue the nomeValue to set
	 */
	public void setNomeValue(String nomeValue) {
		this.nomeValue = nomeValue;
	}

	/**
	 * @return the reduzidoValue
	 */
	public String getReduzidoValue() {
		return reduzidoValue;
	}

	/**
	 * @param reduzidoValue the reduzidoValue to set
	 */
	public void setReduzidoValue(String reduzidoValue) {
		this.reduzidoValue = reduzidoValue;
	}

	/**
	 * @return the enderecoValue
	 */
	public String getEnderecoValue() {
		return enderecoValue;
	}

	/**
	 * @param enderecoValue the enderecoValue to set
	 */
	public void setEnderecoValue(String enderecoValue) {
		this.enderecoValue = enderecoValue;
	}

	/**
	 * @return the cepValue
	 */
	public String getCepValue() {
		return cepValue;
	}

	/**
	 * @param cepValue the cepValue to set
	 */
	public void setCepValue(String cepValue) {
		this.cepValue = cepValue;
	}

	/**
	 * @return the cidadeValue
	 */
	public String getCidadeValue() {
		return cidadeValue;
	}

	/**
	 * @param cidadeValue the cidadeValue to set
	 */
	public void setCidadeValue(String cidadeValue) {
		this.cidadeValue = cidadeValue;
	}

	/**
	 * @return the uFValue
	 */
	public String getuFValue() {
		return uFValue;
	}

	/**
	 * @param uFValue the uFValue to set
	 */
	public void setuFValue(String uFValue) {
		this.uFValue = uFValue;
	}

	/**
	 * @return the bairroValue
	 */
	public String getBairroValue() {
		return bairroValue;
	}

	/**
	 * @param bairroValue the bairroValue to set
	 */
	public void setBairroValue(String bairroValue) {
		this.bairroValue = bairroValue;
	}

	/**
	 * @return the dddValue
	 */
	public String getDddValue() {
		return dddValue;
	}

	/**
	 * @param dddValue the dddValue to set
	 */
	public void setDddValue(String dddValue) {
		this.dddValue = dddValue;
	}

	/**
	 * @return the telefoneValue
	 */
	public String getTelefoneValue() {
		return telefoneValue;
	}

	/**
	 * @param telefoneValue the telefoneValue to set
	 */
	public void setTelefoneValue(String telefoneValue) {
		this.telefoneValue = telefoneValue;
	}

	/**
	 * @return the nomeComprovValue
	 */
	public String getNomeComprovValue() {
		return nomeComprovValue;
	}

	/**
	 * @param nomeComprovValue the nomeComprovValue to set
	 */
	public void setNomeComprovValue(String nomeComprovValue) {
		this.nomeComprovValue = nomeComprovValue;
	}

	/**
	 * @return the moedaValue
	 */
	public String getMoedaValue() {
		return moedaValue;
	}

	/**
	 * @param moedaValue the moedaValue to set
	 */
	public void setMoedaValue(String moedaValue) {
		this.moedaValue = moedaValue;
	}

	/**
	 * @return the endComprovValue
	 */
	public String getEndComprovValue() {
		return endComprovValue;
	}

	/**
	 * @param endComprovValue the endComprovValue to set
	 */
	public void setEndComprovValue(String endComprovValue) {
		this.endComprovValue = endComprovValue;
	}

	/**
	 * @return the paisValue
	 */
	public String getPaisValue() {
		return paisValue;
	}

	/**
	 * @param paisValue the paisValue to set
	 */
	public void setPaisValue(String paisValue) {
		this.paisValue = paisValue;
	}

	/**
	 * @return the cgcCPFValue
	 */
	public String getCgcCPFValue() {
		return cgcCPFValue;
	}

	/**
	 * @param cgcCPFValue the cgcCPFValue to set
	 */
	public void setCgcCPFValue(String cgcCPFValue) {
		this.cgcCPFValue = cgcCPFValue;
	}

	/**
	 * @return the tpPESSOAVALUE
	 */
	public String getTpPESSOAVALUE() {
		return tpPESSOAVALUE;
	}

	/**
	 * @param tpPESSOAVALUE the tpPESSOAVALUE to set
	 */
	public void setTpPESSOAVALUE(String tpPESSOAVALUE) {
		this.tpPESSOAVALUE = tpPESSOAVALUE;
	}

	/**
	 * @return the msgECFValue
	 */
	public String getMsgECFValue() {
		return msgECFValue;
	}

	/**
	 * @param msgECFValue the msgECFValue to set
	 */
	public void setMsgECFValue(String msgECFValue) {
		this.msgECFValue = msgECFValue;
	}

	/**
	 * @return the parceriaValue
	 */
	public String getParceriaValue() {
		return parceriaValue;
	}

	/**
	 * @param parceriaValue the parceriaValue to set
	 */
	public void setParceriaValue(String parceriaValue) {
		this.parceriaValue = parceriaValue;
	}

	/**
	 * @return the avsValue
	 */
	public String getAvsValue() {
		return avsValue;
	}

	/**
	 * @param avsValue the avsValue to set
	 */
	public void setAvsValue(String avsValue) {
		this.avsValue = avsValue;
	}

	/**
	 * @return the srvMKPValue
	 */
	public String getSrvMKPValue() {
		return srvMKPValue;
	}

	/**
	 * @param srvMKPValue the srvMKPValue to set
	 */
	public void setSrvMKPValue(String srvMKPValue) {
		this.srvMKPValue = srvMKPValue;
	}

	/**
	 * @return the ppValue
	 */
	public String getPpValue() {
		return ppValue;
	}

	/**
	 * @param ppValue the ppValue to set
	 */
	public void setPpValue(String ppValue) {
		this.ppValue = ppValue;
	}

	/**
	 * @return the malaDiretaValue
	 */
	public String getMalaDiretaValue() {
		return malaDiretaValue;
	}

	/**
	 * @param malaDiretaValue the malaDiretaValue to set
	 */
	public void setMalaDiretaValue(String malaDiretaValue) {
		this.malaDiretaValue = malaDiretaValue;
	}

	/**
	 * @return the grpImgValue
	 */
	public String getGrpImgValue() {
		return grpImgValue;
	}

	/**
	 * @param grpImgValue the grpImgValue to set
	 */
	public void setGrpImgValue(String grpImgValue) {
		this.grpImgValue = grpImgValue;
	}

	/**
	 * @return the mccValue
	 */
	public String getMccValue() {
		return mccValue;
	}

	/**
	 * @param mccValue the mccValue to set
	 */
	public void setMccValue(String mccValue) {
		this.mccValue = mccValue;
	}

	/**
	 * @return the lmtHRFLOTValue
	 */
	public String getLmtHRFLOTValue() {
		return lmtHRFLOTValue;
	}

	/**
	 * @param lmtHRFLOTValue the lmtHRFLOTValue to set
	 */
	public void setLmtHRFLOTValue(String lmtHRFLOTValue) {
		this.lmtHRFLOTValue = lmtHRFLOTValue;
	}

	/**
	 * @return the clFaturValue
	 */
	public String getClFaturValue() {
		return clFaturValue;
	}

	/**
	 * @param clFaturValue the clFaturValue to set
	 */
	public void setClFaturValue(String clFaturValue) {
		this.clFaturValue = clFaturValue;
	}

	/**
	 * @return the solECOMValue
	 */
	public String getSolECOMValue() {
		return solECOMValue;
	}

	/**
	 * @param solECOMValue the solECOMValue to set
	 */
	public void setSolECOMValue(String solECOMValue) {
		this.solECOMValue = solECOMValue;
	}

	/**
	 * @return the grInfAdicValue
	 */
	public String getGrInfAdicValue() {
		return grInfAdicValue;
	}

	/**
	 * @param grInfAdicValue the grInfAdicValue to set
	 */
	public void setGrInfAdicValue(String grInfAdicValue) {
		this.grInfAdicValue = grInfAdicValue;
	}

	/**
	 * @return the estabelecValue
	 */
	public String getEstabelecValue() {
		return estabelecValue;
	}

	/**
	 * @param estabelecValue the estabelecValue to set
	 */
	public void setEstabelecValue(String estabelecValue) {
		this.estabelecValue = estabelecValue;
	}

	/**
	 * @return the alugadoValue
	 */
	public String getAlugadoValue() {
		return alugadoValue;
	}

	/**
	 * @param alugadoValue the alugadoValue to set
	 */
	public void setAlugadoValue(String alugadoValue) {
		this.alugadoValue = alugadoValue;
	}

	/**
	 * @return the comodatoValue
	 */
	public String getComodatoValue() {
		return comodatoValue;
	}

	/**
	 * @param comodatoValue the comodatoValue to set
	 */
	public void setComodatoValue(String comodatoValue) {
		this.comodatoValue = comodatoValue;
	}

	/**
	 * @return the redecardValue
	 */
	public String getRedecardValue() {
		return redecardValue;
	}

	/**
	 * @param redecardValue the redecardValue to set
	 */
	public void setRedecardValue(String redecardValue) {
		this.redecardValue = redecardValue;
	}

	/**
	 * @return the outrosValue
	 */
	public String getOutrosValue() {
		return outrosValue;
	}

	/**
	 * @param outrosValue the outrosValue to set
	 */
	public void setOutrosValue(String outrosValue) {
		this.outrosValue = outrosValue;
	}

	/**
	 * @return the telefoneEstabelecValue
	 */
	public String getTelefoneEstabelecValue() {
		return telefoneEstabelecValue;
	}

	/**
	 * @param telefoneEstabelecValue the telefoneEstabelecValue to set
	 */
	public void setTelefoneEstabelecValue(String telefoneEstabelecValue) {
		this.telefoneEstabelecValue = telefoneEstabelecValue;
	}

	/**
	 * @return the multiECVALUE
	 */
	public String getMultiECVALUE() {
		return multiECVALUE;
	}

	/**
	 * @param multiECVALUE the multiECVALUE to set
	 */
	public void setMultiECVALUE(String multiECVALUE) {
		this.multiECVALUE = multiECVALUE;
	}

	/**
	 * @return the anlsFRDVALUE
	 */
	public String getAnlsFRDVALUE() {
		return anlsFRDVALUE;
	}

	/**
	 * @param anlsFRDVALUE the anlsFRDVALUE to set
	 */
	public void setAnlsFRDVALUE(String anlsFRDVALUE) {
		this.anlsFRDVALUE = anlsFRDVALUE;
	}

	/**
	 * @return the cartaoPresenteVALUE
	 */
	public String getCartaoPresenteVALUE() {
		return cartaoPresenteVALUE;
	}

	/**
	 * @param cartaoPresenteVALUE the cartaoPresenteVALUE to set
	 */
	public void setCartaoPresenteVALUE(String cartaoPresenteVALUE) {
		this.cartaoPresenteVALUE = cartaoPresenteVALUE;
	}

	/**
	 * @return the autTercValue
	 */
	public String getAutTercValue() {
		return autTercValue;
	}

	/**
	 * @param autTercValue the autTercValue to set
	 */
	public void setAutTercValue(String autTercValue) {
		this.autTercValue = autTercValue;
	}

	/**
	 * @return the internetValue
	 */
	public String getInternetValue() {
		return internetValue;
	}

	/**
	 * @param internetValue the internetValue to set
	 */
	public void setInternetValue(String internetValue) {
		this.internetValue = internetValue;
	}

	/**
	 * @return the pgtRecorValue
	 */
	public String getPgtRecorValue() {
		return pgtRecorValue;
	}

	/**
	 * @param pgtRecorValue the pgtRecorValue to set
	 */
	public void setPgtRecorValue(String pgtRecorValue) {
		this.pgtRecorValue = pgtRecorValue;
	}

	/**
	 * @return the multivanValue
	 */
	public String getMultivanValue() {
		return multivanValue;
	}

	/**
	 * @param multivanValue the multivanValue to set
	 */
	public void setMultivanValue(String multivanValue) {
		this.multivanValue = multivanValue;
	}

	/**
	 * @return the bloqInternacValue
	 */
	public String getBloqInternacValue() {
		return bloqInternacValue;
	}

	/**
	 * @param bloqInternacValue the bloqInternacValue to set
	 */
	public void setBloqInternacValue(String bloqInternacValue) {
		this.bloqInternacValue = bloqInternacValue;
	}

	/**
	 * @return the autParcValue
	 */
	public String getAutParcValue() {
		return autParcValue;
	}

	/**
	 * @param autParcValue the autParcValue to set
	 */
	public void setAutParcValue(String autParcValue) {
		this.autParcValue = autParcValue;
	}

	/**
	 * @return the reentradaValue
	 */
	public String getReentradaValue() {
		return reentradaValue;
	}

	/**
	 * @param reentradaValue the reentradaValue to set
	 */
	public void setReentradaValue(String reentradaValue) {
		this.reentradaValue = reentradaValue;
	}

	/**
	 * @return the bloqueadoValue
	 */
	public String getBloqueadoValue() {
		return bloqueadoValue;
	}

	/**
	 * @param bloqueadoValue the bloqueadoValue to set
	 */
	public void setBloqueadoValue(String bloqueadoValue) {
		this.bloqueadoValue = bloqueadoValue;
	}

	/**
	 * @return the stValue
	 */
	public String getStValue() {
		return stValue;
	}

	/**
	 * @param stValue the stValue to set
	 */
	public void setStValue(String stValue) {
		this.stValue = stValue;
	}

	/**
	 * @return the motValue
	 */
	public String getMotValue() {
		return motValue;
	}

	/**
	 * @param motValue the motValue to set
	 */
	public void setMotValue(String motValue) {
		this.motValue = motValue;
	}

	/**
	 * @return the zonaFRValue
	 */
	public String getZonaFRValue() {
		return zonaFRValue;
	}

	/**
	 * @param zonaFRValue the zonaFRValue to set
	 */
	public void setZonaFRValue(String zonaFRValue) {
		this.zonaFRValue = zonaFRValue;
	}

	/**
	 * @return the migBOBValue
	 */
	public String getMigBOBValue() {
		return migBOBValue;
	}

	/**
	 * @param migBOBValue the migBOBValue to set
	 */
	public void setMigBOBValue(String migBOBValue) {
		this.migBOBValue = migBOBValue;
	}

	/**
	 * @return the correspBCOValue
	 */
	public String getCorrespBCOValue() {
		return correspBCOValue;
	}

	/**
	 * @param correspBCOValue the correspBCOValue to set
	 */
	public void setCorrespBCOValue(String correspBCOValue) {
		this.correspBCOValue = correspBCOValue;
	}

	/**
	 * @return the cartIntNAutEnValue
	 */
	public String getCartIntNAutEnValue() {
		return cartIntNAutEnValue;
	}

	/**
	 * @param cartIntNAutEnValue the cartIntNAutEnValue to set
	 */
	public void setCartIntNAutEnValue(String cartIntNAutEnValue) {
		this.cartIntNAutEnValue = cartIntNAutEnValue;
	}

	/**
	 * @return the bListValue
	 */
	public String getbListValue() {
		return bListValue;
	}

	/**
	 * @param bListValue the bListValue to set
	 */
	public void setbListValue(String bListValue) {
		this.bListValue = bListValue;
	}

	/**
	 * @return the grpPrivateValue
	 */
	public String getGrpPrivateValue() {
		return grpPrivateValue;
	}

	/**
	 * @param grpPrivateValue the grpPrivateValue to set
	 */
	public void setGrpPrivateValue(String grpPrivateValue) {
		this.grpPrivateValue = grpPrivateValue;
	}

	/**
	 * @return the msgValue
	 */
	public String getMsgValue() {
		return msgValue;
	}

	/**
	 * @param msgValue the msgValue to set
	 */
	public void setMsgValue(String msgValue) {
		this.msgValue = msgValue;
	}

	/**
	 * @return the idFBValue
	 */
	public String getIdFBValue() {
		return idFBValue;
	}

	/**
	 * @param idFBValue the idFBValue to set
	 */
	public void setIdFBValue(String idFBValue) {
		this.idFBValue = idFBValue;
	}

	/**
	 * @return the reentXBandValue
	 */
	public String getReentXBandValue() {
		return reentXBandValue;
	}

	/**
	 * @param reentXBandValue the reentXBandValue to set
	 */
	public void setReentXBandValue(String reentXBandValue) {
		this.reentXBandValue = reentXBandValue;
	}

	/**
	 * @return the visaValue
	 */
	public String getVisaValue() {
		return visaValue;
	}

	/**
	 * @param visaValue the visaValue to set
	 */
	public void setVisaValue(String visaValue) {
		this.visaValue = visaValue;
	}

	/**
	 * @return the amexValue
	 */
	public String getAmexValue() {
		return this.amexValue;
	}

	/**
	 * @param amexValue the amexValue to set
	 */
	public void setAmexValue(String amexValue) {
		this.amexValue = amexValue;
	}

	/**
	 * @return the jcbValue
	 */
	public String getJcbValue() {
		return this.jcbValue;
	}

	/**
	 * @param jcbValue the jcbValue to set
	 */
	public void setJcbValue(String jcbValue) {
		this.jcbValue = jcbValue;
	}

	/**
	 * @return the cargaMoedeiroValue
	 */
	public String getCargaMoedeiroValue() {
		return cargaMoedeiroValue;
	}

	/**
	 * @param cargaMoedeiroValue the cargaMoedeiroValue to set
	 */
	public void setCargaMoedeiroValue(String cargaMoedeiroValue) {
		this.cargaMoedeiroValue = cargaMoedeiroValue;
	}

	/**
	 * @return the digNRCartaoValue
	 */
	public String getDigNRCartaoValue() {
		return digNRCartaoValue;
	}

	/**
	 * @param digNRCartaoValue the digNRCartaoValue to set
	 */
	public void setDigNRCartaoValue(String digNRCartaoValue) {
		this.digNRCartaoValue = digNRCartaoValue;
	}

	/**
	 * @return the truncCartaoValue
	 */
	public String getTruncCartaoValue() {
		return TruncCartaoValue;
	}

	/**
	 * @param truncCartaoValue the truncCartaoValue to set
	 */
	public void setTruncCartaoValue(String truncCartaoValue) {
		TruncCartaoValue = truncCartaoValue;
	}

	/**
	 * @return the sOLDig4UltValue
	 */
	public String getSOLDig4UltValue() {
		return SOLDig4UltValue;
	}

	/**
	 * @param sOLDig4UltValue the sOLDig4UltValue to set
	 */
	public void setSOLDig4UltValue(String sOLDig4UltValue) {
		SOLDig4UltValue = sOLDig4UltValue;
	}

	/**
	 * @return the fallBackValue
	 */
	public String getFallBackValue() {
		return fallBackValue;
	}

	/**
	 * @param fallBackValue the fallBackValue to set
	 */
	public void setFallBackValue(String fallBackValue) {
		this.fallBackValue = fallBackValue;
	}

	/**
	 * @return the offLineValue
	 */
	public String getOffLineValue() {
		return OffLineValue;
	}

	/**
	 * @param offLineValue the offLineValue to set
	 */
	public void setOffLineValue(String offLineValue) {
		OffLineValue = offLineValue;
	}

	/**
	 * @return the disSaldoValue
	 */
	public String getDisSaldoValue() {
		return disSaldoValue;
	}

	/**
	 * @param disSaldoValue the disSaldoValue to set
	 */
	public void setDisSaldoValue(String disSaldoValue) {
		this.disSaldoValue = disSaldoValue;
	}

	/**
	 * @return the cvv2DigValue
	 */
	public String getCvv2DigValue() {
		return cvv2DigValue;
	}

	/**
	 * @param cvv2DigValue the cvv2DigValue to set
	 */
	public void setCvv2DigValue(String cvv2DigValue) {
		this.cvv2DigValue = cvv2DigValue;
	}

	/**
	 * @return the pswSupervisorValue
	 */
	public String getPswSupervisorValue() {
		return pswSupervisorValue;
	}

	/**
	 * @param pswSupervisorValue the pswSupervisorValue to set
	 */
	public void setPswSupervisorValue(String pswSupervisorValue) {
		this.pswSupervisorValue = pswSupervisorValue;
	}

	/**
	 * @return the eleTrocoValue
	 */
	public String getEleTrocoValue() {
		return eleTrocoValue;
	}

	/**
	 * @param eleTrocoValue the eleTrocoValue to set
	 */
	public void setEleTrocoValue(String eleTrocoValue) {
		this.eleTrocoValue = eleTrocoValue;
	}

	/**
	 * @return the impSaldoValue
	 */
	public String getImpSaldoValue() {
		return impSaldoValue;
	}

	/**
	 * @param impSaldoValue the impSaldoValue to set
	 */
	public void setImpSaldoValue(String impSaldoValue) {
		this.impSaldoValue = impSaldoValue;
	}

	/**
	 * @return the cvv2TrilhaValue
	 */
	public String getCvv2TrilhaValue() {
		return cvv2TrilhaValue;
	}

	/**
	 * @param cvv2TrilhaValue the cvv2TrilhaValue to set
	 */
	public void setCvv2TrilhaValue(String cvv2TrilhaValue) {
		this.cvv2TrilhaValue = cvv2TrilhaValue;
	}

	/**
	 * @return the permiteDCCValue
	 */
	public String getPermiteDCCValue() {
		return permiteDCCValue;
	}

	/**
	 * @param permiteDCCValue the permiteDCCValue to set
	 */
	public void setPermiteDCCValue(String permiteDCCValue) {
		this.permiteDCCValue = permiteDCCValue;
	}

	/**
	 * @return the impValRecargValue
	 */
	public String getImpValRecargValue() {
		return impValRecargValue;
	}

	/**
	 * @param impValRecargValue the impValRecargValue to set
	 */
	public void setImpValRecargValue(String impValRecargValue) {
		this.impValRecargValue = impValRecargValue;
	}

	/**
	 * @return the impDGTCartaoValue
	 */
	public String getImpDGTCartaoValue() {
		return impDGTCartaoValue;
	}

	/**
	 * @param impDGTCartaoValue the impDGTCartaoValue to set
	 */
	public void setImpDGTCartaoValue(String impDGTCartaoValue) {
		this.impDGTCartaoValue = impDGTCartaoValue;
	}

	/**
	 * @return the solPSWValue
	 */
	public String getSolPSWValue() {
		return solPSWValue;
	}

	/**
	 * @param solPSWValue the solPSWValue to set
	 */
	public void setSolPSWValue(String solPSWValue) {
		this.solPSWValue = solPSWValue;
	}

	/**
	 * @return the impCodBarrasValue
	 */
	public String getImpCodBarrasValue() {
		return impCodBarrasValue;
	}

	/**
	 * @param impCodBarrasValue the impCodBarrasValue to set
	 */
	public void setImpCodBarrasValue(String impCodBarrasValue) {
		this.impCodBarrasValue = impCodBarrasValue;
	}

	/**
	 * @return the obrigaSenhaValue
	 */
	public String getObrigaSenhaValue() {
		return obrigaSenhaValue;
	}

	/**
	 * @param obrigaSenhaValue the obrigaSenhaValue to set
	 */
	public void setObrigaSenhaValue(String obrigaSenhaValue) {
		this.obrigaSenhaValue = obrigaSenhaValue;
	}

	/**
	 * @return the taxaEmbarqueValue
	 */
	public String getTaxaEmbarqueValue() {
		return taxaEmbarqueValue;
	}

	/**
	 * @param taxaEmbarqueValue the taxaEmbarqueValue to set
	 */
	public void setTaxaEmbarqueValue(String taxaEmbarqueValue) {
		this.taxaEmbarqueValue = taxaEmbarqueValue;
	}

	/**
	 * @return the scodeX4DigValue
	 */
	public String getScodeX4DigValue() {
		return scodeX4DigValue;
	}

	/**
	 * @param scodeX4DigValue the scodeX4DigValue to set
	 */
	public void setScodeX4DigValue(String scodeX4DigValue) {
		this.scodeX4DigValue = scodeX4DigValue;
	}

	/**
	 * @return the chkVlDupValue
	 */
	public String getChkVlDupValue() {
		return chkVlDupValue;
	}

	/**
	 * @param chkVlDupValue the chkVlDupValue to set
	 */
	public void setChkVlDupValue(String chkVlDupValue) {
		this.chkVlDupValue = chkVlDupValue;
	}

	/**
	 * @return the naoUsadoValue
	 */
	public String getNaoUsadoValue() {
		return naoUsadoValue;
	}

	/**
	 * @param naoUsadoValue the naoUsadoValue to set
	 */
	public void setNaoUsadoValue(String naoUsadoValue) {
		this.naoUsadoValue = naoUsadoValue;
	}

	/**
	 * @return the taxaServicoValue
	 */
	public String getTaxaServicoValue() {
		return taxaServicoValue;
	}

	/**
	 * @param taxaServicoValue the taxaServicoValue to set
	 */
	public void setTaxaServicoValue(String taxaServicoValue) {
		this.taxaServicoValue = taxaServicoValue;
	}

	/**
	 * @return the scodeXCVV2Value
	 */
	public String getScodeXCVV2Value() {
		return scodeXCVV2Value;
	}

	/**
	 * @param scodeXCVV2Value the scodeXCVV2Value to set
	 */
	public void setScodeXCVV2Value(String scodeXCVV2Value) {
		this.scodeXCVV2Value = scodeXCVV2Value;
	}

	/**
	 * @return the chkVlDupPreValue
	 */
	public String getChkVlDupPreValue() {
		return chkVlDupPreValue;
	}

	/**
	 * @param chkVlDupPreValue the chkVlDupPreValue to set
	 */
	public void setChkVlDupPreValue(String chkVlDupPreValue) {
		this.chkVlDupPreValue = chkVlDupPreValue;
	}

	/**
	 * @return the visaLabel
	 */
	public static String getVisaLabel() {
		return visaLabel;
	}

	/**
	 * @return the eloValue
	 */
	public String getEloValue() {
		return eloValue;
	}

	/**
	 * @return the optionField
	 */
	public Field getOptionField() {
		return optionField;
	}

	/**
	 * @param optionField the optionField to set
	 */
	public void setOptionField(Field optionField) {
		this.optionField = optionField;
	}

	/**
	 * @return the suffixEstabField
	 */
	public Field getSuffixEstabField() {
		return suffixEstabField;
	}

	/**
	 * @param suffixEstabField the suffixEstabField to set
	 */
	public void setSuffixEstabField(Field suffixEstabField) {
		this.suffixEstabField = suffixEstabField;
	}
}
