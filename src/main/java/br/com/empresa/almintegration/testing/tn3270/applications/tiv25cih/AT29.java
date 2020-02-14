package br.com.empresa.almintegration.testing.tn3270.applications.tiv25cih;

import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;

public class AT29 extends MainframeFormScreens{
	
	public enum AT29_MESSAGES{
		CONSULTA_EFETUADA("CAMPOS DISPONIVEIS PARA ALTERACAO");
		private String message;

		AT29_MESSAGES(String message) {
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}
	}
	
	public enum AT29_FIELDS implements IMainframeScreenFields{
		MATRIZ,                    PRIN,                      ASS,                     CADEIA,                 ESTAB,                  
		FONE,                      ABERTURA,                  MCC,                     FECHAMENTO,             PERMITE_PRAZO_FLEX,     
		INI_MM_AAAA,               LIMITE_ATUAL,              DT_ULT_ALTERACAO,        CONTROLE_FRAUDE,        SD,
		STATUS,                    EXCLUI_MRC110,             AUT_ESPECIAL,            LIBERA_BIN_DO_EXTERIOR, VLR_LIMITE_DEBITO_ITEM,  
		RAZAO_VALOR_SEM_CENTAVOS,  RAZAO_CREDITO_PARA_DEBITO, RAZAO_CHARGEBACK,        RAZAO_LIMITE_INFERIOR,  SUP,                    
		TITULAR_DUPLICADO,         TRATAMENTO_PARA_NMAS,      REFERENCIA,              PEDIDO_ACAO,            MOTIVO,                 
		RESPOSTA_ACAO,             ERRO,                      PEDIDO_DATA,             CATEG_ANTEC,            STATUS_EC,              
		NOME_FANT,                 CGC,                       FIM_MM_AAAA,             S_PFL,                  FORCA_MONITORIA,           
		VARIACAO_DEP_X_ULTIMO_MES, VLR_LIMITE_CREDITO_ITEM,   VARIACAO_MEDIA_POR_CV,  INF,                     RAZAO_VALOR_DUPLICIDADE,   
		RESPOSTA_DATA,             SOLICITANTE;
		private String fieldLabel;
		private String fieldValue;
		private AT29_FIELDS() {
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
		return mf.getScreenText().contains(AT29_MESSAGES.CONSULTA_EFETUADA.message);
	}

	public static void setEstabComercialField(String estabComercial){
		setFieldValue(new FieldIdentifier(AT29_FIELDS.ESTAB.getFieldLabel()), estabComercial);
	}

}
