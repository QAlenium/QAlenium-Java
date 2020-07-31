package br.com.qalenium.interfaces;

import org.openqa.selenium.WebDriver;

public interface IWebTestsRule {

    WebDriver getWebDriver();

    void setWebDriver(WebDriver webDriver);

}
