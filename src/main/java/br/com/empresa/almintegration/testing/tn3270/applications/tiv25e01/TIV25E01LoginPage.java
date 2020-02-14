package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;

public class TIV25E01LoginPage {
	
	private static Mainframe mainFrame = Mainframe.getInstance();
	private static String systemLabel = "SYSTEM:";
	private static FieldIdentifier systemIdentifier = new FieldIdentifier(systemLabel);
	
	private static String terminalLabel = "TERMINAL:";
	private static FieldIdentifier terminalIdentifier = new FieldIdentifier(terminalLabel);
	
	private static String nodeLabel = "NODE:";
	private static FieldIdentifier nodeIdentifier = new FieldIdentifier(nodeLabel);
	
	private static String dayLabel = "DAY:";
	private static FieldIdentifier dayIdentifier = new FieldIdentifier(dayLabel);
	
	private static String systemDateLabel = "SYSTEM DATE:";
	private static FieldIdentifier systemDateIdentifier = new FieldIdentifier(systemDateLabel);
	
	private static String systemTimeLabel = "SYSTEM TIME:";
	private static FieldIdentifier systemTimeIdentifier = new FieldIdentifier(systemTimeLabel);
	
	private static String logonIdLabel = "LOGONID:";
	private static FieldIdentifier logonIdIdentifier = new FieldIdentifier(logonIdLabel);
	
	private static String passwordLabel = "PASSWORD:";
	private static FieldIdentifier passwordIdentifier = new FieldIdentifier(passwordLabel);
	
	private static String newPasswordLabel = "NEW PASSWORD:";
	private static FieldIdentifier newPasswordIdentifier = new FieldIdentifier(newPasswordLabel);
	
	private static String twicePasswordLabel = "(enter twice)";
	private static FieldIdentifier twicePasswordIdentifier = new FieldIdentifier(twicePasswordLabel);
	
	private static String logOnStatusLabel = "Signon OK";
	private static FieldIdentifier logOnStatusIdentifier = new FieldIdentifier(logOnStatusLabel); 
	
	public static boolean performLogin(String logonId, String password){
		setLogonId(logonId);
		setPassword(password);
		mainFrame.enter();
		Pattern pattern = Pattern.compile(".*" + logOnStatusLabel);
		Matcher matcher = pattern.matcher(mainFrame.getScreenText());
		return matcher.find();
	}
	
	public static Field getSystemIdentifier() {
		return mainFrame.getField(systemIdentifier);
	}

	/**
	 * @return the terminalIdentifier
	 */
	public static Field getTerminalIdentifier() {
		return mainFrame.getField(terminalIdentifier);
	}

	/**
	 * @return the nodeIdentifier
	 */
	public static Field getNodeIdentifier() {
		return mainFrame.getField(nodeIdentifier);
	}

	/**
	 * @return the dayIdentifier
	 */
	public static Field getDayIdentifier() {
		return mainFrame.getField(dayIdentifier);
	}

	/**
	 * @return the systemDateIdentifier
	 */
	public static Field getSystemDateIdentifier() {
		return mainFrame.getField(systemDateIdentifier);
	}

	/**
	 * @return the systemTimeIdentifier
	 */
	public static Field getSystemTimeIdentifier() {
		return mainFrame.getField(systemTimeIdentifier);
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
