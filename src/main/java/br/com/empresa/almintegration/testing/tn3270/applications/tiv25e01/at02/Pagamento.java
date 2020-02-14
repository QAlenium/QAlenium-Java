package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01.at02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;

class Pagamento extends MainframeFormScreens{
	public static enum FIELDS implements IMainframeScreenFields{
		EC_PAGUE_CONTA, TAR,            EC_AVS,     EC_AVS_TAR,     ADM_VISA, 
		SAUDE,          OUTRA_BANDEIRA, ESTAB_AMEX, IND_PRAZO_FLEX, BLQ_PFLEX;
		private String fieldLabel;
		private String fieldValue;
		final String regex = "EC PAGUE CONTA:\\s*(.) TAR.:\\s*(.*)\\s*EC AVS:\\s*(.)\\s*TAR.:\\s*(.*)\\s*ADM VISA:\\s*(.)" + 
							 "\\s*SAUDE:\\s*(.)\\s*OUTRA BANDEIRA:\\s*(.)\\s*ESTAB.AMEX:\\s*(.*)\\s*IND.PRAZO FLEX:\\s*(.)\\s*" + 
							 "BLQ_PFLEX:\\s*(.)";
		FIELDS() {
			int i = 7;
			String screenFieldsLines = mf.getLine(i++) + mf.getLine(i++);
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(screenFieldsLines);
			if(matcher.find()) this.fieldValue = matcher.group(this.ordinal() + 1).trim();
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
	
	public Pagamento() {
		for (FIELDS field : FIELDS.values()) System.out.println(field.name() + ": " + field.fieldValue);
	}
}