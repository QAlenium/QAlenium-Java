package br.com.empresa.almintegration.testing.tn3270.applications.tiv25cih;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Screen;

public class LoginAlertsPage {

	private static String AU50 = "AU50";
	
	public static void ContinueLogin(){
		Mainframe.getInstance().enter();
	}
	
	public static boolean goToAU50(){
		Mainframe mainframe = Mainframe.getInstance();
		Screen screen = mainframe.getS3270().getScreen();
		InputField inputField = screen.getFocusedField();
		inputField.setValue(1, AU50);
		mainframe.enter();
		FieldIdentifier functionName = new FieldIdentifier(AU50);
		return mainframe.screenHasLabel(functionName) ? true : false;
	}
}
