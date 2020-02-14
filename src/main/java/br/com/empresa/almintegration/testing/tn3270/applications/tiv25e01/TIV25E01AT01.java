package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01;

import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;

public class TIV25E01AT01 extends MainframeFormScreens{
	
	public enum AT01_MESSAGES implements MainframeMessages {
		ESTABELECIMENTO_ENCONTRADO("AT01-10-ESTABELECIMENTO NAO CADASTRADO                        "),
		CONSULTA_EFETUADA("AT01-02-CONSULTA EFETUADA                                     ");
		private String message;
		private AT01_MESSAGES(String message) {
			this.message = message;
		}
		public String getMessage(){
			return message;
		}
	}
	
	public enum AT01_FIELDS implements IMainframeScreenFields{
		AFILIACAO,       ALELO,        AN_ECM,       ANTEC_CAT,      ASS_ARQUIVO, 
		ASS,             AUTOM,        BL,           CGC,            CADEIA, 
		CB,              CBANC,        CDPCT,        CEDIR,          CEP, 
		CIDADE,          CLASSE,       COM_ELETR,    COMPLEMENTO,    CONTATO, 
		CP,              CVA,          DATA_ABERT,   DATA_FECHAM,    DATA, 
		DOM_BANC,        ECI6,         END_FISICO,   ESTAB,          EVENTO, 
		FONE,            FRANCA,       GMAR,         GS,             LIMITE, 
		MATRIZ,          MOB_PAYMENT,  MULTIVAN,     NOME_FANTASIA,  NOME_PLAQUETA, 
		ORIGEM_1,        ORIGEM_2,     ORIZON,       PARCEL_LOJISTA, PERC, 
		PILOTO,          POS_QTDE,     PP,           PRIN,           PROPRIE, 
		QUANT_PLAQUETAS, RATING,       RAZAO_SOCIAL, RECEBE_SMS,     RECOR, 
		S_PFL,           SD,           SEG,          SERV,           STATUS_ATIV, 
		STATUS_EC,       TIPO_DE_PGTO, TOP10,        TP_DEP,         UF, 
		ULT_EXTRATO,     USUARIO,      VISA_DISTR,   VOL;
		private String fieldLabel;
		private String fieldValue;
		private AT01_FIELDS() {
			String propertyName = this.getClass().getSimpleName() + UNDERSCORE + this.name();
			this.fieldLabel = properties.getProperty(propertyName, propertyName);
		}
		@Override
		public String getFieldLabel() {
			return fieldLabel;
		}
	
		@Override
		public String getFieldValue() {
			String field = getFieldLabel();
			if(field.equals(AT01_FIELDS.ORIGEM_1))		fieldValue = (successfulQuery()) ? mf.getS3270().getScreen().getFields().get(105).getValue() : null;
			else if(field.equals(AT01_FIELDS.ORIGEM_2)) fieldValue = (successfulQuery()) ? mf.getS3270().getScreen().getFields().get(153).getValue() : null;
				else                                    fieldValue = (successfulQuery()) ? mf.getFieldValues(new FieldIdentifier(getFieldLabel())) : null;
			return fieldValue;
		}
	
		@Override
		public void setFieldValue(String fieldValue) {
			this.fieldValue = fieldValue;
		}
	}

	public static boolean successfulQuery(){
		return mf.getScreenText().contains(AT01_MESSAGES.CONSULTA_EFETUADA.getMessage());
	}
	
	public static void setEstabValue(String estabComercial){
		setFieldValue(new FieldIdentifier(AT01_FIELDS.ESTAB.getFieldLabel()), estabComercial);
	}
	
	
}
