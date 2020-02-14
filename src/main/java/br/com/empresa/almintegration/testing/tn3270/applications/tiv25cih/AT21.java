package br.com.empresa.almintegration.testing.tn3270.applications.tiv25cih;

import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;

public class AT21 extends MainframeFormScreens{
	
	public enum AT21_MESSAGES{
		CONSULTA_EFETUADA("CAMPOS DISPONIVEIS PARA ALTERACAO");
		private String message;

		AT21_MESSAGES(String message) {
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}
	}
	
	public enum AT21_FIELDS implements IMainframeScreenFields{
		MATRIZ,        PRIN,           ASS,           CADEIA,          STATUS_EC,  ESTAB,
		NOME_FANTASIA, SD,             SEGTO,         CODPCT,          PILOTO,     MOBPAYMENT,
		RECEBE_SMS,    NOME_FANTASIA2, FONE,          RAZAO_SOCIAL,    FAX,        END_FISICO,
		CEP,           ECI6,           COMPLEMENTO,   CGC,             CIDADE,     UF,
		VISA_DISTR,    END_CORRESP,    ELO100,        COMELETR,        GRDSUP,     CONTATO,
		JURIDICO,      REC,            CB,            NOME_PLAQUETA,   QTDE_PLAQT, TP_PLAQT,
		PROP1,         CPF1,           DTNAS1,        PROP2,           CPF2,        DTNAS2,
		PROP3,         CPF3,           DTNAS3,        NOVO_STATUS_EC,  MOT,        TFACIL,
		ASSEM_ARQ,     NATJUR,         CATEG_ANTECIP, LOJFRAN,         CEDIR,      DT_ABERT,
		SITCAD,        RAMO_ATIVIDADE, MOTO,          DATA_FECHAMENTO, CVA,        DTINCLCVA,
		TOP_10,        ECOMM_PERMANT,  SERV,          DATA_ULTMANUT,   USUARIO,    SOLICITANTE,
		EVENTO;
		private String fieldLabel;
		private String fieldValue;
		private AT21_FIELDS() {
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
			if(field.equals(AT21_FIELDS.NOME_FANTASIA2)) fieldValue = (successfulQuery()) ? mf.getS3270().getScreen().getFields().get(39).getValue() : null;
			else if(field.equals(AT21_FIELDS.CPF1))      fieldValue = (successfulQuery()) ? mf.getS3270().getScreen().getFields().get(105).getValue() : null;
			else if(field.equals(AT21_FIELDS.CPF2))      fieldValue = (successfulQuery()) ? mf.getS3270().getScreen().getFields().get(112).getValue() : null;
			else if(field.equals(AT21_FIELDS.CPF3))      fieldValue = (successfulQuery()) ? mf.getS3270().getScreen().getFields().get(119).getValue() : null;

			else if(field.equals(AT21_FIELDS.DTNAS1))    fieldValue = (successfulQuery()) ? mf.getS3270().getScreen().getFields().get(107).getValue() : null;
			else if(field.equals(AT21_FIELDS.DTNAS2))    fieldValue = (successfulQuery()) ? mf.getS3270().getScreen().getFields().get(114).getValue() : null;
			else if(field.equals(AT21_FIELDS.DTNAS3))    fieldValue = (successfulQuery()) ? mf.getS3270().getScreen().getFields().get(121).getValue() : null;
				fieldValue = (successfulQuery()) ? mf.getFieldValues(new FieldIdentifier(getFieldLabel())) : null;
			return fieldValue;
		}

		@Override
		public void setFieldValue(String fieldValue) {
			this.fieldValue = fieldValue;
		}		
	}
	
	public static void populateFields(){
		if(successfulQuery()) {
			for (AT21_FIELDS field : AT21_FIELDS.values()) {
				if(field.equals(AT21_FIELDS.NOME_FANTASIA2)) setFieldValue(field, mf.getS3270().getScreen().getFields().get(39));

				else if(field.equals(AT21_FIELDS.CPF1))      setFieldValue(field, mf.getS3270().getScreen().getFields().get(105));
				else if(field.equals(AT21_FIELDS.CPF2))      setFieldValue(field, mf.getS3270().getScreen().getFields().get(112));
				else if(field.equals(AT21_FIELDS.CPF3))      setFieldValue(field, mf.getS3270().getScreen().getFields().get(119));
				
				else if(field.equals(AT21_FIELDS.DTNAS1))    setFieldValue(field, mf.getS3270().getScreen().getFields().get(107));
				else if(field.equals(AT21_FIELDS.DTNAS2))    setFieldValue(field, mf.getS3270().getScreen().getFields().get(114));
				else if(field.equals(AT21_FIELDS.DTNAS3))    setFieldValue(field, mf.getS3270().getScreen().getFields().get(121));
				else setFieldValue(field);
			}
		}
	}

	public static boolean successfulQuery(){
		return mf.getScreenText().contains(AT21_MESSAGES.CONSULTA_EFETUADA.getMessage());
	}

	public static void setEstabComercialField(String estabComercial){
		setFieldValue(new FieldIdentifier(AT21_FIELDS.ESTAB.getFieldLabel()), estabComercial);
	}

}
