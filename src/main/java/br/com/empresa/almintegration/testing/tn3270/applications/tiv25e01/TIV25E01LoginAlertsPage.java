package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Screen;

public class TIV25E01LoginAlertsPage {

	public static enum SCREENS{AT01, MN01, AT02};
	
	public static void ContinueLogin(){
		Mainframe.getInstance().enter();
	}
	
	public static boolean goToApplication(SCREENS application){
		Mainframe mainframe = Mainframe.getInstance();
		Screen screen = mainframe.getS3270().getScreen();
		InputField inputField = screen.getFocusedField();
		inputField.setValue(1, application.toString());
		mainframe.enter();
		FieldIdentifier functionName = null;
		if(application.equals(SCREENS.AT01)){
			functionName = new FieldIdentifier(SCREENS.AT01.toString());
		}
		if(application.equals(SCREENS.MN01)){
			functionName = new FieldIdentifier(SCREENS.MN01.toString());
		}
		
		if(application.equals(SCREENS.AT02)){
			functionName = new FieldIdentifier(SCREENS.AT02.toString());
		}
		boolean atCorrectApplication = mainframe.screenHasLabel(functionName);
		return atCorrectApplication;
	}
}