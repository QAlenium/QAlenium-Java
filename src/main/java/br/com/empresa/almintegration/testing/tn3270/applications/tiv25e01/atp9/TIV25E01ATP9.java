package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01.atp9;

import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;

public class TIV25E01ATP9 extends MainframeFormScreens{
	private static boolean successfulQuery = mf.getScreenText().contains(MESSAGES.CONSULTA_EFETUADA.getMessage());
	public DetalhesProduto detalhesProduto;
	public enum MESSAGES {
		CONSULTA_EFETUADA("01-CONSULTA EFETUADA");
		private String message;
		MESSAGES(String message){
			this.message = message;
		}
		public String getMessage() {
			return message;
		}
	}
	
	public enum TIV25E01ATP9_FIELDS implements IMainframeScreenFields{
		MATRIZ,            PRIN,                   ASS,                     CADEIA,
		STATUS_EC,         ESTAB,                  NOME,                    ESTAB_AMEX,
		CODIGO_DO_PRODUTO;
		private String fieldLabel;
		private String fieldValue;
		TIV25E01ATP9_FIELDS(){
			String propertyName = this.getClass().getSimpleName() + UNDERSCORE + this.name();
			this.fieldLabel = properties.getProperty(propertyName, propertyName);
		}
		@Override
		public String getFieldLabel() {
			return fieldLabel;
		}
		@Override
		public String getFieldValue() {
			return fieldValue;
		}
		@Override
		public void setFieldValue(String fieldValue) {
			this.fieldValue = fieldValue;
		}
	}
	
	public TIV25E01ATP9() {
		populateFields();
	}
	
	private void populateFields(){
		for (TIV25E01ATP9_FIELDS field : TIV25E01ATP9_FIELDS.values()) {
			setFieldValue(field);
			System.out.println(field.fieldLabel + field.fieldValue);
		}
		this.detalhesProduto = new DetalhesProduto();
	}
	
	public static boolean isSuccessfulQuery() {
		return successfulQuery;
	}

	public DetalhesProduto getDetalhesProduto() {
		return detalhesProduto;
	}	
}
