package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.List;

public class CT01ValidarBotoesEAusenciaTest {

    //Funcionalidade: Verificar ausência dos botões após clicar nos mesmos

    //Cenário: Clicar nos botões "One", "Two, e "Four", depois verificar a ausência dos mesmos.

    //Dado que estou na página WeJump-automation
    //E clico nos botões "One", "Two, e "Four"
    //Quando verifico os botões
    //Então os botões estão ausentes.

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new Utils().getDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void ct01ValidarBotoesEAusencia() {
        driver.get("https://wejump-automation-test.github.io/qa-test/");
        driver.manage().window().setSize(new Dimension(917, 774));
        driver.findElement(By.id("btn_one")).click();
        driver.findElement(By.id("btn_two")).click();
        driver.findElement(By.id("btn_link")).click();
        {
            List<WebElement> elements = driver.findElements(By.id("btn_one"));
            assert(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.id("btn_two"));
            assert(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.id("btn_link"));
            assert(elements.size() > 0);
        }
    }
}



