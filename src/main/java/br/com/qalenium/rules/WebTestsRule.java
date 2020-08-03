package br.com.qalenium.rules;

import br.com.qalenium.config.Utils;
import br.com.qalenium.interfaces.IWebTestsRule;
import org.openqa.selenium.WebDriver;

public class WebTestsRule extends GenericTestsRule implements IWebTestsRule {

    private static final WebDriver webDriver = Utils.getDriver();

    @Override
    protected void before() {
        getWebDriver().manage().window().maximize();
    }

    @Override
    protected void after() {
        getWebDriver().close();
        getWebDriver().quit();
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

}