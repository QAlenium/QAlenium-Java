package br.com.qalenium.tests.template;

import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.annotations.Web;
import br.com.qalenium.rules.WebTestsRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@TestClassDescription("Garantir que a pagina inicial do google está funcionando")
public class TestsTemplate extends WebTestsRule {

    WebDriver webDriver;

    @Before
    public void before() {
        webDriver = getWebDriver();
    }

    @After
    public void after() {
    }

    @Test
    @Web
    @TestDescription("Testar campo de pesquisa do google")
    public void pesquisaGoogle() {
        webDriver.get("https://www.google.com/");
        webDriver.findElement(By.name("q")).sendKeys("QAlenium");
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        System.out.println("Pesquisa com sucesso");
        Assert.assertTrue(true);

    }
}




