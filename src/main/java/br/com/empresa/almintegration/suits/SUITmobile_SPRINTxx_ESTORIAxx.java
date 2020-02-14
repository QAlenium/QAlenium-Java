package br.com.empresa.almintegration.suits;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.exec.ExecuteException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.github.genium_framework.appium.support.server.AppiumServer;

import br.com.empresa.almintegration.helper.Utils;
import br.com.empresa.almintegration.mobile.SPRINTxx_ESTORIAxxxx_CT003;

@RunWith(Suite.class)
@Suite.SuiteClasses({ SPRINTxx_ESTORIAxxxx_CT003.class })
public class SUITmobile_SPRINTxx_ESTORIAxx {

	private static AppiumServer server;

	@BeforeClass
	public static void startAppiumServer() throws ExecuteException, IOException, InterruptedException, URISyntaxException{
		server = Utils.initializeServer();
	}
	
	@AfterClass
	public static void stopAppiumServer() throws IOException{
		Utils.stopServer();
		server.stopServer();
	}
	
}
