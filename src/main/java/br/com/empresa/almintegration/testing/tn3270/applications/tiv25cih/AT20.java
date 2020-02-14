package br.com.empresa.almintegration.testing.tn3270.applications.tiv25cih;

import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;

public class AT20 extends MainframeFormScreens {

	public enum AT20_FIELDS implements IMainframeScreenFields{
		MATRIZ,    PRIN,   ASS,        CADEIA,
		STATUS_EC, ESTAB,  NOME_FANT,  EVENTO,
		REFER,     DEPEND, PERIODO_DE, ATE,    RECUPERADOS;
		private String fieldLabel;
		private String fieldValue;

		AT20_FIELDS() {
			String propertyName = this.getClass().getSimpleName() + UNDERSCORE + this.name();
			this.fieldLabel = properties.getProperty(propertyName, propertyName);
		}

		public String getFieldLabel() {
			return fieldLabel;
		}

		public String getFieldValue() {
			fieldValue = (successfulQuery()) ? mf.getFieldValues(new FieldIdentifier(getFieldLabel())) : null;
			return fieldValue;
		}

		public void setFieldValue(String fieldValue) {
			this.fieldValue = fieldValue;
		}
	}
	
	public static boolean successfulQuery(){
		// TODO: Pegar mensagem de sucesso.
		return false;
	}
	
	public static void setEstabComercialField(String estabComercial){
		setFieldValue(new FieldIdentifier(AT20_FIELDS.ESTAB.getFieldLabel()), estabComercial);
	}

}
