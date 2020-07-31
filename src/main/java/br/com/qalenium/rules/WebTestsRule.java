package br.com.qalenium.rules;

import br.com.qalenium.config.Utils;
import br.com.qalenium.interfaces.IWebTestsRule;
import org.openqa.selenium.WebDriver;

public class WebTestsRule extends GenericTestsRule implements IWebTestsRule {

    private WebDriver webDriver;

    @Override
    protected void before() {
        Utils utils = new Utils();
        webDriver = utils.getDriver();
        webDriver.manage().window().maximize();
        setWebDriver(webDriver);
    }

    @Override
    protected void after() {
        webDriver.quit();
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}