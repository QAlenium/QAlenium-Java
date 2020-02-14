package br.com.empresa.almintegration.testing.tn3270.applications.k100;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;

public class K100LoginPage {
	
	private static final String systemIdentifier = "Sign-on is complete";
	private static Mainframe mainFrame = Mainframe.getInstance();
	private static String logonIdLabel = "Userid . . . .";
	private static FieldIdentifier logonIdIdentifier = new FieldIdentifier(logonIdLabel);
	
	private static String passwordLabel = "Password . . .";
	private static FieldIdentifier passwordIdentifier = new FieldIdentifier(passwordLabel);
	
	private static String newPasswordLabel = "New Password . . .";
	private static FieldIdentifier newPasswordIdentifier = new FieldIdentifier(newPasswordLabel);
	
	public static boolean performLogin(String logonId, String password){
		setLogonId(logonId);
		setPassword(password);
		mainFrame.enter();
		return mainFrame.getScreenText().contains(systemIdentifier);
	}
	
	public static String getSystemIdentifier() {
		return systemIdentifier;
	}

	/**
	 * @return the logonIdIdentifier
	 */
	public static Field getLogonId() {
		return mainFrame.getField(logonIdIdentifier);
	}

	/**
	 * @param logonIdIdentifier the logonIdIdentifier to set
	 */
	public static void setLogonId(String logonId) {
		mainFrame.write(logonIdIdentifier, logonId);
	}

	/**
	 * @return the passwordIdentifier
	 */
	public static Field getPassword() {
		return mainFrame.getField(passwordIdentifier);
	}

	/**
	 * @param passwordIdentifier the passwordIdentifier to set
	 */
	public static void setPassword(String password) {
		mainFrame.write(passwordIdentifier, password);
	}

	/**
	 * @return the newPasswordIdentifier
	 */
	public static Field getNewPassword() {
		return mainFrame.getField(newPasswordIdentifier);
	}

	/**
	 * @param newPasswordIdentifier the newPasswordIdentifier to set
	 */
	public static void setNewPassword(String newPassword) {
		mainFrame.write(newPasswordIdentifier,newPassword);
	}	
}
