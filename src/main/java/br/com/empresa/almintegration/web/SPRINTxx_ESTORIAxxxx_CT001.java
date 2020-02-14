package br.com.empresa.almintegration.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.empresa.almintegration.alm.model.RunStep;
import br.com.empresa.almintegration.execution.CustomerTestCase;
import br.com.empresa.almintegration.helper.Utils;
import br.com.empresa.almintegration.testing.web.pageObject.WebPageExample;
import net.thucydides.core.annotations.Step;

public class SPRINTxx_ESTORIAxxxx_CT001 extends CustomerTestCase {

	private WebPageExample webPageExample;
	private WebDriver driver;

	@Before
	public void beforeTest() throws Exception{
		driver = Utils.initializeChromeDriver();
		driver.manage().window().maximize();
		webPageExample = PageFactory.initElements(driver, WebPageExample.class);
	}

	@Test
	public void testExample() throws Exception {
		step1();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
		step2();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
	}

	@Step("Acessar a página da google")
	public void step1(){
		try{
			webPageExample.getDriver().get("http://www.google.com.br");
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}
	}

	@Step("Pesquisar por 'Teste de pesquisa'")
	public void step2(){
		try{
			webPageExample.clickOnSearchField();
			webPageExample.insertValueOnSearchField("Teste de pesquisa");
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}
	}

	@After
	public void afterTest(){
		driver.close();
	}

}
