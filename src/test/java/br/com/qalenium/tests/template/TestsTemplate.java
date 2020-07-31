package br.com.qalenium.tests.template;

import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.annotations.Web;
import br.com.qalenium.config.Utils;
import br.com.qalenium.rules.WebTestsRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

@TestClassDescription("Garantir que a pagina inicial do google está funcionando")
public class TestsTemplate extends WebTestsRule {


    WebDriver driver;
    @Before
    public void before() {
        Utils utils = new Utils();
        driver = utils.getDriver();
        driver.manage().window().maximize();
        System.out.println("Antes");
    }

    @After
    public void after() {
        driver.quit();
        System.out.println("Depois");
    }

    @Test
    @Web
    @TestDescription("Testar campo de pesquisa do google")
    @StoryLink("Use this annotation in case you want to trace the story adding the link")
    public void pesquisaGoogle() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("QAlenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        System.out.println("Pesquisa com sucesso");
        Assert.assertTrue(true);

    }
}




