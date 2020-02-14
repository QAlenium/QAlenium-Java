package br.com.empresa.almintegration.testing.tn3270;

import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;

public class K100MainScreen {
	
	public static boolean goToCadastroInicializacao(){
		Mainframe mf = Mainframe.getInstance();
		((InputField) mf.getS3270().getScreen().getFields().get(14)).setValue("s");
		mf.enter();
		return mf.getS3270().getScreen().getFields().get(9).getValue().contains("SISTEMA DE AUTORIZACAO");
	}
	
	public static boolean goToSistemasCaptura(){
		return false;
	}

	public static boolean goToSistemasAutorizacao(){
		return false;
	}

}
