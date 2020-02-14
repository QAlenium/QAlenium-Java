package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01;

import java.util.ArrayList;
import java.util.List;

import br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01.TIV25E01AT01.AT01_FIELDS;
import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;

public class TIV25E01MN01AE51 extends MainframeFormScreens{
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
	
	public static enum AE51_FIELDS implements IMainframeScreenFields {
		INST_FINANCEIRA,
		STATUS_VIGENTE,
		DESDE,
		POR;
		String fieldLabel;
		String fieldValue;
		private AE51_FIELDS() {
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
	private List<AE51StatusCRD> statusList;
	private int totalPages;

	public TIV25E01MN01AE51() {
		for (AE51_FIELDS field : AE51_FIELDS.values()) {
			field.setFieldValue(
			mf.getFieldValues(new FieldIdentifier(field.getFieldLabel())));
		}
		getHistoricStatus();
	}

	public static boolean successfulQuery() {
		if(mf.getScreenText().contains(MESSAGES.INVALID_INSTITUTION.getMessage())) return false;
		return true;
	}

	private void getHistoricStatus() {
		statusList = new ArrayList<AE51StatusCRD>();
		for(int currentPage = 1; currentPage <= this.totalPages; currentPage++){
			for(int j = 1; j < 10; j++){
				AE51StatusCRD status = new AE51StatusCRD(j);
				if(!status.getStatusField().equals("")) statusList.add(status);
			}
			mf.pf(8);
		}
	}

	public static boolean setEnvironment(ENVIRONMENTS environment){
		List<Field> fields = mf.getS3270().getScreen().getFields();
		InputField selectEnvironment = (InputField) fields.get(25);
		selectEnvironment.setValue("X");
		mf.enter();
		String expectedScreen = new StringBuffer().append(TIV25E01MN01.Transactions.AE51.getDescription()).append(" - ").append(environment.name()).toString();
		return atCorrectEnvironment(expectedScreen);
	}

	public static void setInstitution(String institution){
		setFieldValue(new FieldIdentifier(AE51_FIELDS.INST_FINANCEIRA.getFieldLabel()), institution);
	}
	
	private static boolean atCorrectEnvironment(String expectedScreen){
		List<Field> fields = mf.getS3270().getScreen().getFields();
		String screenTitle = new StringBuffer().append(fields.get(6).getText()).append(fields.get(7).getText()).toString().trim();
		return screenTitle.equals(expectedScreen);
	}
}