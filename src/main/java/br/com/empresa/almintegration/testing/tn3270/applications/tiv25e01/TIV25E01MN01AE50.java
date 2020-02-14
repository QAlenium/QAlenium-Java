package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;

public class TIV25E01MN01AE50 extends MainframeFormScreens{
	public static enum ENVIRONMENTS {ONLINE, BATCH};

	private static enum MESSAGES {
		INVALID_INSTITUTION(
				"CODIGO DA INSTITUICAO FINANCEIRA INVALIDO - DIGITE OUTRO CODIGO");
		private String message;

		MESSAGES(String message){
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
	
	private static InputField financialInstitution;
	private FieldIdentifier crdStatusIdentifier = new FieldIdentifier("INSTITUICAO FINANCEIRA:");
	private String crdStatusField;
	private FieldIdentifier effectiveSinceIdentifier = new FieldIdentifier("SITUACAO DO CRD:");
	private String effectiveSinceField;
	private FieldIdentifier definedByUserIdentifier = new FieldIdentifier("DEFINIDO PELO USUARIO:");
	private String definedByUserField;
	private String institution;

	public TIV25E01MN01AE50() {
		List<Field> fields = mf.getS3270().getScreen().getFields();	
		institution = new StringBuffer().append(fields.get(9).getText())
				.append(fields.get(10).getText())
				.append(fields.get(11).getText()).toString().trim();
		crdStatusField = new StringBuffer().append(fields.get(15).getText())
				.append(fields.get(16).getText())
				.append(fields.get(17).getText()).toString().trim();
		effectiveSinceField = new StringBuffer()
				.append(fields.get(19).getText())
				.append(fields.get(20).getText())
				.append(fields.get(21).getText()).toString().trim();
		definedByUserField = fields.get(23).getText()
				.trim();
	}

	public static boolean setEnvironment(ENVIRONMENTS environment){
		List<Field> fields = mf.getS3270().getScreen().getFields();
		InputField selectEnvironment = (InputField) fields.get(16);
		selectEnvironment.setValue("X");
		mf.enter();
		String expectedScreen = new StringBuffer().append(TIV25E01MN01.Transactions.AE50.getDescription()).append(" - ").append(environment.name()).toString();
		return atCorrectEnvironment(expectedScreen);
	}

	public static boolean setInstitution(String institution){
		financialInstitution = (InputField) mf.getS3270().getScreen().getFields().get(9);
		financialInstitution.setValue(institution);
		mf.enter();
		String returnMessage = mf.getS3270().getScreen().getFields().get(26).getText().trim();
		if(returnMessage.equals(MESSAGES.INVALID_INSTITUTION.getMessage())) return false;
		return true;
	}
	
	private static boolean atCorrectEnvironment(String expectedScreen){
		List<Field> fields = mf.getS3270().getScreen().getFields();
		String screenTitle = new StringBuffer().append(fields.get(6).getText()).append(fields.get(7).getText()).toString().trim();
		return screenTitle.equals(expectedScreen);
	}

	public String getCrdStatusField() {
		return crdStatusField;
	}

	public String getEffectiveSinceField() {
		return effectiveSinceField;
	}

	public String getDefinedByUserField() {
		return definedByUserField;
	}

	public String getInstitution() {
		return institution;
	}
}
