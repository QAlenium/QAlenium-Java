package br.com.empresa.almintegration.testing.tn3270.applications.tso;

import java.util.List;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;

public class LoginPage {
	
	private static Mainframe mainFrame = Mainframe.getInstance();
	private static String systemLabel = "SYSTEM:";
	private static FieldIdentifier systemIdentifier = new FieldIdentifier(systemLabel);
	
	private static String logonIdLabel = "ACF82003  ACF2, ENTER LOGON ID - ";
	private static FieldIdentifier logonIdIdentifier = new FieldIdentifier(logonIdLabel);
	
	private static String passwordLabel = "PASSWORD:";
	private static FieldIdentifier passwordIdentifier = new FieldIdentifier(passwordLabel);
	
	private static String newPasswordLabel = "NEW PASSWORD:";
	private static FieldIdentifier newPasswordIdentifier = new FieldIdentifier(newPasswordLabel);
	
	private static String twicePasswordLabel = "(enter twice)";
	private static FieldIdentifier twicePasswordIdentifier = new FieldIdentifier(twicePasswordLabel);
	
	public static boolean performLogin(String logonId, String password){
		setLogonId(logonId);
		mainFrame.enter();
		setPassword(password);
		mainFrame.enter();
		return mainFrame.getScreenText().contains("LOGON IN PROGRESS");
	}
	
	public static Field getSystemIdentifier() {
		return mainFrame.getField(systemIdentifier);
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
		List<Field> fields = mainFrame.getS3270().getScreen().getFields();
		InputField userNameField = (InputField) fields.get(2);
		userNameField.setValue(1, logonId);
	}

	/**
	 * @return the passwordIdentifier
	 */
	public static InputField getPasswordField() {
		List<Field> fields = mainFrame.getS3270().getScreen().getFields();
		InputField passwordField = (InputField) fields.get(4);
		return passwordField;
	}

	/**
	 * @param passwordIdentifier the passwordIdentifier to set
	 */
	public static void setPassword(String password) {
		InputField passwordField = getPasswordField();
		passwordField.setValue(1, password);
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

	/**
	 * @return the twicePasswordIdentifier
	 */
	public static Field getTwicePassword() {
		return mainFrame.getField(twicePasswordIdentifier);
	}

	/**
	 * @param twicePasswordIdentifier the twicePasswordIdentifier to set
	 */
	public static void setTwicePassword(String twicePassword) {
		mainFrame.write(twicePasswordIdentifier,twicePassword);
	}
}
