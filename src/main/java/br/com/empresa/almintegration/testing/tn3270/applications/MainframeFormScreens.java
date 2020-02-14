package br.com.empresa.almintegration.testing.tn3270.applications;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.ScreenFields;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;

public abstract class MainframeFormScreens {

	protected static Mainframe mf = Mainframe.getInstance();
	public static Properties properties = loadPropertiesFile();
	protected static String C = "C";
	protected static String E = "E";
	protected static String A = "A";
	protected static String I = "I";
	protected static String UNDERSCORE = "_";
	protected static final String ALL = "(.*)";
	protected static final String BLANK = " ";
	
	private static Properties loadPropertiesFile() {
		String propFileName = "resources\\mainframeFields.properties";
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(propFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	protected static void setFieldValue(IMainframeScreenFields field) {
		field.setFieldValue(
				mf.getFieldValues(new FieldIdentifier(field.getFieldLabel())));
	}
	
	protected static void setFieldValue(FieldIdentifier fieldIdentifier, String value){
		setFieldValue((InputField)mf.getField(fieldIdentifier), value);
	}
	
	protected static void setFieldValue(InputField field, String value){
		field.setValue(value);
	}
	
	protected static void setFieldValue(IMainframeScreenFields fields, Field field) {
		fields.setFieldValue(field.getText());
		
	}
	
	public void setFieldValue(IMainframeScreenFields fields, String value) {
		fields.setFieldValue(value);
		
	}
	
	public String getFieldValue(IMainframeScreenFields field){
		return field.getFieldValue();
	}
	
	protected boolean startWithSpace(String screenText) {
		return screenText.substring(0,1).equals(BLANK);
	}


}
