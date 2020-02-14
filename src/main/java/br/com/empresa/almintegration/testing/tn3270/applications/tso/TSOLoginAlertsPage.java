package br.com.empresa.almintegration.testing.tn3270.applications.tso;

import java.util.List;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;

public class TSOLoginAlertsPage {

	public static void ContinueLogin(){
		Mainframe.getInstance().enter();
	}
	
	public static boolean goToTSO(){
		Mainframe mainframe = Mainframe.getInstance();
		mainframe.enter();
		if(!mainframe.getScreenText().contains("TIME SHARING OPTION")) return false;
		mainframe.enter();
		if(!mainframe.getScreenText().contains("LOGON IN PROGRESS")) return false;
		mainframe.enter();
		if(!mainframe.getScreenText().contains("Primary Option Menu")) return false;
		FieldIdentifier optionFieldIdentifier = new FieldIdentifier("Option ===>");
		InputField field = (InputField)mainframe.getField(optionFieldIdentifier);
		field.setValue("6");
		mainframe.enter();
		if(!mainframe.getScreenText().contains("ISPF Command Shell")) return false;
		List<Field> fields = mainframe.getS3270().getScreen().getFields();
		InputField commandField = (InputField) fields.get(19);
		commandField.setValue(0,"exec tvnar9.tso.exec(qsex01) exec");
		mainframe.enter();
		if(!mainframe.getScreenText().contains("QSEX 01")) return false;
		
		return true;
	}
}
