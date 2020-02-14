package br.com.empresa.almintegration.testing.tn3270.applications.k100.g120;

import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;

public class G120 extends MainframeFormScreens {
	
	public enum G120_OPTIONS{
		Inclusao(I),Atualizacao(A),Edicao(E),Consulta(C);
		String opcao;
		G120_OPTIONS(String opcao){
			this.opcao = opcao;
		}
	};
	
	public enum G120_MESSAGES{
		CONSULTA_EFETUADA("OK. CONSULTA EFETUADA.");
		private String message;

		G120_MESSAGES(String message) {
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}
	}

	public static enum G120_FIELDS implements IMainframeScreenFields {
		COD_ESTB,      SUFFIX_ESTB,     PRD_MTZ,          PRD_SEC,      DATA_INCLUSAO, 
		ALTERACAO,     SITUACAO,        NOME,             REDUZIDO,     ENDERECO, 
		CEP,           CIDADE,          UF,               BAIRRO,       DDD, 
		TELEFONE,      NOME_COMPROV,    MOEDA,            END_COMPROV,  PAIS, 
		CGC_CPF,       TP_PESSOA,       MSG_ECF,          PARCERIA,     AVS, 
		SRV_MKP,       PP,              MALA_DIRETA,      GRP_IMG,      MCC, 
		LMT_HRFLOT,    CL_FATUR,        SOL_ECOM,         GR_INFADIC,   ESTABELEC, 
		ALUGADO,       COMODATO,        REDECARD,         OUTROS,       TELEFONE_ESTABELEC, 
		MULTI_EC,      ANLS_FRD,        CARTAO_PRESENTE,  AUT_TERC,     INTERNET, 
		PGT_RECOR,     MULTIVAN,        BLOQ_INTERNAC,    AUT_PARC,     REENTRADA, 
		BLOQUEADO,     ST,              MOT,              ZONA_FR,      MIG_BOB, 
		CORRESP_BCO,   CART_INTNAUT_EN, B_LIST,           GRP_PRIVATE,  MSG, 
		ID_FB,         REENT_XBAND,     VISA,             AMEX,         ELO, 
		JCB,           CARGA_MOEDEIRO,  DIG_NRCARTAO,     TRUNC_CARTAO, SOLDIG4ULT, 
		FALL_BACK,     OFF_LINE,        DIS_SALDO,        CVV2DIG,      PSW_SUPERVISOR, 
		ELE_TROCO,     IMP_SALDO,       CVV2TRILHA,       PERMITE_DCC,  IMP_VALRECARG, 
		IMP_DGTCARTAO, SOL_PSW,         IMP_CODBARRAS,    OBRIGA_SENHA, TAXA_EMBARQUE, 
		SCODE_X4DIG,   CHK_VLDUP,       NAO_USADO,        TAXA_SERVICO, SCODE_XCVV2, 
		CHK_VLDUP_PRE, OPTION;
		private String fieldLabel;
		private String fieldValue;
		private G120_FIELDS() {
			String propertyName = this.getClass().getSimpleName() + UNDERSCORE + this.name();
			this.fieldLabel = properties.getProperty(propertyName, propertyName);
		}
		@Override
		public String getFieldLabel() {
			return fieldLabel;
		}

		@Override
		public String getFieldValue() {
			fieldValue = (successfulQuery()) ? mf.getFieldValues(new FieldIdentifier(getFieldLabel())) : null;
			return fieldValue;
		}

		@Override
		public void setFieldValue(String fieldValue) {
			this.fieldValue = fieldValue;			
		}
	}

	public static boolean successfulQuery(){
		return mf.getScreenText().contains(G120_MESSAGES.CONSULTA_EFETUADA.getMessage());
	}

	/**
	 * @param optionField the optionField to set
	 */
	public static void setOptionField(G120_OPTIONS option) {
		setFieldValue(new FieldIdentifier(G120_FIELDS.OPTION.getFieldLabel()), option.opcao);
	}
	/**
	 * @param codEstabField the codEstabField to set
	 */
	public static void setCodEstabField(String codEstabField) {
		setFieldValue(new FieldIdentifier(G120_FIELDS.COD_ESTB.getFieldLabel()), codEstabField);
	}
	/**
	 * @param suffixEstabField the suffixEstabField to set
	 */
	public static void setSuffixEstabField(String suffixEstabField) {
		((InputField)mf.getS3270().getScreen().getFields().get(18)).setValue(suffixEstabField);
	}
	
	public String getField(G120_FIELDS fields){
		for (G120_FIELDS field : G120_FIELDS.values())
			if (field.equals(field)) return field.fieldValue;
		return null;
	}
}
