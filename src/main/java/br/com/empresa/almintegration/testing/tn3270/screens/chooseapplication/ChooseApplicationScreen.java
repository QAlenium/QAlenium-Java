package br.com.empresa.almintegration.testing.tn3270.screens.chooseapplication;

import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.Mainframe;

public class ChooseApplicationScreen {
	
	private static Mainframe mainFrame = Mainframe.getInstance();
	private static String applicationLabel = "Application:";
	private static FieldIdentifier applicationFieldIdentifier = new FieldIdentifier(applicationLabel);
	
	/**
	 * @return the applicationField
	 */
	public static Field getApplicationField() {
		return mainFrame.getField(applicationFieldIdentifier);
	}

	/**
	 * @param applicationField the applicationField to set
	 */
	public static void setApplicationField(String application) {
		mainFrame.write(applicationFieldIdentifier, application);
	}
	
	public static boolean EnterApplication(String application){
		setApplicationField(application);
		mainFrame.enter();
		return mainFrame.screenHasLabel(applicationFieldIdentifier)?false:true;
	}
}
