package br.com.empresa.almintegration.mobile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import br.com.empresa.almintegration.execution.CustomerTestCase;
import br.com.empresa.almintegration.helper.Utils;
import br.com.empresa.almintegration.testing.mobile.pageObject.AsusCalculator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SPRINTxx_ESTORIAxxxx_CT003 extends CustomerTestCase {

	private AndroidDriver<AndroidElement> driver;
	private AsusCalculator calcPage;

	@Before
	public void antes() throws InterruptedException, IOException, URISyntaxException{
		driver = Utils.initializeAndroidDriver("192.168.0.1:5555", null);
		calcPage = PageFactory.initElements(driver, AsusCalculator.class);
	}

	@Test
	public void teste70x7() throws InterruptedException{
		calcPage.getDigit7().click();
		calcPage.getDigit0().click();
		calcPage.clickOnMULperation(driver);
		calcPage.getDigit7().click();
		calcPage.getEqual().click();
		Assert.assertEquals(calcPage.getResultFromOperation(driver), "490");
	}

	@After
	public void depois() throws FileNotFoundException, IOException, URISyntaxException{
		driver.closeApp();
		driver.quit();
	}
}
