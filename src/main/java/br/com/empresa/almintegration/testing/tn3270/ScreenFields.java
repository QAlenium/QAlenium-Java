package br.com.empresa.almintegration.testing.tn3270;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;

public class ScreenFields extends MainframeFormScreens{
	
	public static enum FIELDS implements IMainframeScreenFields{
		SCREEN, TITLE, DATE, USER, SUBTITLE, TIME, CURRENT_PAGE, LAST_PAGE;
		final String regex = "([A-Za-z0-9]*)\\s*([A-Za-z -]*)([0-9]{2}\\/[0-9]{2}\\/[0-9]{4})\\s*" + // Primeira linha.
				   "([A-Za-z0-9]*)\\s*([A-Za-z -]*)([0-9]{2}:[0-9]{2}:[0-9]{2})\\s*" + // Segunda linha.
				   "PAG\\.:\\s([0-9]{3})\\s\\/\\s([0-9]{3})"; // Terceira linha.
		private String fieldLabel;
		private String fieldValue;

		FIELDS(){
			int i = 0;
			String screenFieldsLines = mf.getLine(i++) + mf.getLine(i++) + mf.getLine(i++);
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(screenFieldsLines);
			if(matcher.find()) this.fieldValue = matcher.group(this.ordinal() + 1);
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
	
	public ScreenFields() {
		for (FIELDS field : FIELDS.values()) {
			System.out.println(field.name() + ": " + field.fieldValue);
		}
	}

}
