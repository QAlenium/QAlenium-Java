package br.com.empresa.almintegration.constants;

import java.awt.Dimension;
import java.awt.Toolkit;

/**  
 * Fabrica<BR>
 *
 * AUT-206 - Atualizar arquivo de produtos em estoque<BR>
 *
 * @since 25 de ago de 2016 09:47:15
 * @author Gabriel Aguido Fraga<BR>
 *         Fabrica<BR>
 * 
 *         automation
 */
public class Constants {

	public static String pacote = "br.com.empresa.cliente";
	public static String classe = "br.com.empresa.cliente.ui.splash.SplashActivity";

	public static String dbProperties = "./utilitarios/properties/db.properties";
	public static String almProperties = "./utilitarios/properties/alm.properties";
	public static String emailProperties = "./utilitarios/properties/email.properties";
	public static String xpathProperties = "./utilitarios/properties/xpath.properties";
	public static String configProperties = "./utilitarios/properties/config.properties";
	public static String gtecProperties = "./utilitarios/properties/gtec.properties";
	public static String servicosProperties = "./utilitarios/properties/servicos.properties";
	public static String CTS = "./utilitarios/properties/CTs.properties";
	public static String mensagensProperties = "./utilitarios/properties/mensagens.properties";
	public static String temp = "temp";
	public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	public static String SUCCESS = "SUCCESS";
	public static String FAIL = "FAIL";
	public static String UNITTEST = "UNITTEST";
	public static String CHROMEDRIVER_EXE = "./utilitarios/drivers/chromedriver_win32/chromedriver.exe";
	public static int NUMERO_TENTATIVAS = 5;

	public static String NEW = "NEW";
	public static String OLD = "OLD";
	public static String ENV_TI = "TIEnv";
	public static String ENV_HML = "HMLEnv";
	public static String ENV_PRD = "PRDEnv";
	public static String PROJECT_OLD = "PJ07329_Cred_OLD";
	public static String PROJECT_NEW = "PJ07329_Cred_Release1";
}
