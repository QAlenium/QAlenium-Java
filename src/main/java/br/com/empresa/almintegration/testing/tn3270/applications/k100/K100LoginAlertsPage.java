package br.com.empresa.almintegration.testing.tn3270.applications.k100;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Screen;

public class K100LoginAlertsPage {

	public static enum APPLICATIONS{K100};
	
	public static void ContinueLogin(){
		Mainframe.getInstance().enter();
	}
	
	public static boolean goToApplication(APPLICATIONS application){
		Mainframe mainframe = Mainframe.getInstance();
		Screen screen = mainframe.getS3270().getScreen();
		InputField inputField = (InputField)screen.getFields().get(2);
		inputField.setValue(application.name());
		mainframe.enter();
		FieldIdentifier functionName = new FieldIdentifier(APPLICATIONS.K100.name());
		boolean atK11 = mainframe.screenHasLabel(functionName);
		return atK11;
	}
}
