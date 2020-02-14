package br.com.empresa.almintegration.constants;

import java.io.Serializable;

public class ConstantsServices implements Serializable{

	private static final long serialVersionUID = -4900383083466150517L;
	
	//==SOAPAction==
	
	public static final String SOAPACTION_CUSTOMERLOYALTY = "";
	public static final String SOAPACTION_POINTSERVICE = "";
	public static final String SOAPACTION_ORDER_SERVICE= "";
	public static final String SOAPACTION_SALES_ORDER_SERVICE= "";
	public static final String SOAPACTION_AUTHENTICATION_SERVICE= "";
	
	//== LABELS ==
	
	public static final String LABEL_USER_ID = "\\[LABEL_USER_ID]";
	public static final String LABEL_USER_PWD = "\\[LABEL_USER_PWD]";
	
	public static final String LABEL_CODIGOFERRAMENTA = "\\[LABEL_CODIGOFERRAMENTA]";
	public static final String LABEL_INDICADORAGRO = "\\[LABEL_INDICADORAGRO]";
	public static final String LABEL_NUMEROCPFCNPJ = "\\[LABEL_NUMEROCPFCNPJ]";
	public static final String LABEL_CODIGOTIPOPESSOA = "\\[LABEL_CODIGOTIPOPESSOA]";
	public static final String LABEL_NOMERAZAOSOCIAL = "\\[LABEL_NOMERAZAOSOCIAL]";
	public static final String LABEL_INDICADORMICROEMPREENDEDORINDIVIDUAL = "\\[LABEL_INDICADORMICROEMPREENDEDORINDIVIDUAL]";
	public static final String LABEL_NUMEROINSCRICAOESTADUAL = "\\[LABEL_NUMEROINSCRICAOESTADUAL]";
	public static final String LABEL_NOMEFANTASIA = "\\[LABEL_NOMEFANTASIA]";
	public static final String LABEL_NOMEPLAQUETA = "\\[LABEL_NOMEPLAQUETA]";
	public static final String LABEL_NOMEPESSOACONTATO = "\\[LABEL_NOMEPESSOACONTATO]";
	public static final String LABEL_CODIGORAMOATIVIDADE = "\\[LABEL_CODIGORAMOATIVIDADE]";
	
	public static final String LABEL_DOMBANC_CODIGOBANCO = "\\[LABEL_DOMBANC_CODIGOBANCO]";
	public static final String LABEL_DOMBANC_NUMEROAGENCIA = "\\[LABEL_DOMBANC_NUMEROAGENCIA]";
	public static final String LABEL_DOMBANC_NUMEROCONTACORRENTE = "\\[LABEL_DOMBANC_NUMEROCONTACORRENTE]";
	
	public static final String LABEL_TEL_TIPOTELEFONE = "\\[LABEL_TEL_TIPOTELEFONE]";
	public static final String LABEL_TEL_NUMERODDD = "\\[LABEL_TEL_NUMERODDD]";
	public static final String LABEL_TEL_NUMEROTELEFONE = "\\[LABEL_TEL_NUMEROTELEFONE]";
	
	public static final String LABEL_END_TIPOENDERECO = "\\[LABEL_END_TIPOENDERECO]";
	public static final String LABEL_END_NOMELOGRADOURO = "\\[LABEL_END_NOMELOGRADOURO]";
	public static final String LABEL_END_DESCRICAOCOMPLEMENTOENDERECO = "\\[LABEL_END_DESCRICAOCOMPLEMENTOENDERECO]";
	public static final String LABEL_END_NUMEROLOGRADOURO = "\\[LABEL_END_NUMEROLOGRADOURO]";
	public static final String LABEL_END_NOMEBAIRRO = "\\[LABEL_END_NOMEBAIRRO]";
	public static final String LABEL_END_NOMECIDADE = "\\[LABEL_END_NOMECIDADE]";
	public static final String LABEL_END_SIGLAESTADO = "\\[LABEL_END_SIGLAESTADO]";
	public static final String LABEL_END_NUMEROCEP = "\\[LABEL_END_NUMEROCEP]";
	
	public static final String LABEL_SOLCAP_CODIGOSOLUCAOCAPTURA = "\\[LABEL_SOLCAP_CODIGOSOLUCAOCAPTURA]";
	
	public static final String LABEL_PROP_NOME = "\\[LABEL_PROP_NOME]";
	public static final String LABEL_PROP_NUMEROCPF = "\\[LABEL_PROP_NUMEROCPF]";
	public static final String LABEL_PROP_DATANASCIMENTO = "\\[LABEL_PROP_DATANASCIMENTO]";
	public static final String LABEL_PROP_TEL_TIPOTELEFONE = "\\[LABEL_PROP_TEL_TIPOTELEFONE]";
	public static final String LABEL_PROP_TEL_NUMERODDD = "\\[LABEL_PROP_TEL_NUMERODDD]";
	public static final String LABEL_PROP_TEL_NUMEROTELEFONE = "\\[LABEL_PROP_TEL_NUMEROTELEFONE]";
	
	//== DEFAULT VALUES =
	
	public static final String SUCCESS = "_SUCCESS";
	public static final String PASSED = "_PASSED";
	public static final String NO_RUN = "_NO_RUN";
	public static final String NOT_COMPLETED = "_NOT_COMPLETED";
	public static final String FAIL = "_FAIL";
	
	public static final String STATUS_PASSED = "Passed";
	public static final String STATUS_NO_RUN = "No Run";
	public static final String STATUS_NOT_COMPLETED = "Not Completed";
	public static final String STATUS_FAIL = "Fail";
	
	public static final String UNIT_TEST = "_UNITTEST";	
	
	public static final String VALUE_USER_ID = "svc_OSB_CRD";
	public static final String VALUE_USER_PWD = "0sbCRD2016";
	
	public static final String VALUE_CODIGOFERRAMENTA = "2";
	public static final String VALUE_INDICADORAGRO = "N";
	public static final String VALUE_NUMEROCPFCNPJ = "93152692000174";
	public static final String VALUE_CODIGOTIPOPESSOA = "J";
	public static final String VALUE_NOMERAZAOSOCIAL = "FREITAS SOLUTION LTDA";
	public static final String VALUE_INDICADORMICROEMPREENDEDORINDIVIDUAL = "N";
	public static final String VALUE_NUMEROINSCRICAOESTADUAL = "15";
	public static final String VALUE_NOMEFANTASIA = "NOME FANTASIA";
	public static final String VALUE_NOMEPLAQUETA = "NOME PARA PLAQUETA";
	public static final String VALUE_NOMEPESSOACONTATO = "NOME DA PESSOA PARA CONTATO";
	public static final String VALUE_CODIGORAMOATIVIDADE = "12345";
	
	public static final String VALUE_DOMBANC_CODIGOBANCO = "33";
	public static final String VALUE_DOMBANC_NUMEROAGENCIA = "657";
	public static final String VALUE_DOMBANC_NUMEROCONTACORRENTE = "00000010259193";
	
	public static final String VALUE_TEL_TIPOTELEFONE = "2";
	public static final String VALUE_TEL_NUMERODDD = "11";
	public static final String VALUE_TEL_NUMEROTELEFONE = "970806999";
	
	public static final String VALUE_END_TIPOENDERECO = "2";
	public static final String VALUE_END_NOMELOGRADOURO = "ENDERECO DO ESTABELECIMENTO 0001";
	public static final String VALUE_END_DESCRICAOCOMPLEMENTOENDERECO = "ENDERECO DO ESTABELECIMENTO 0002";
	public static final String VALUE_END_NUMEROLOGRADOURO = "12345";
	public static final String VALUE_END_NOMEBAIRRO = "ROCHDALA";
	public static final String VALUE_END_NOMECIDADE = "SAO PAULO";
	public static final String VALUE_END_SIGLAESTADO = "SP";
	public static final String VALUE_END_NUMEROCEP = "05145000";
	
	public static final String VALUE_SOLCAP_CODIGOSOLUCAOCAPTURA = "1";
	
	public static final String VALUE_PROP_NOME = "NOME DO PROPRIETARIO UM";
	public static final String VALUE_PROP_NUMEROCPF = "11671613864";
	public static final String VALUE_PROP_DATANASCIMENTO = "1989-11-21";
	public static final String VALUE_PROP_TEL_TIPOTELEFONE = "2";
	public static final String VALUE_PROP_TEL_NUMERODDD = "11";
	public static final String VALUE_PROP_TEL_NUMEROTELEFONE = "970806999";
	
}
