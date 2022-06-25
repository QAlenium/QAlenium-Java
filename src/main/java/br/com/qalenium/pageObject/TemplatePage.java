package br.com.qalenium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TemplatePage {
    protected WebDriver driver;
    private final By element = By.id("element_id");

    public TemplatePage(WebDriver driver){
        this.driver = driver;
    }

    /*
    public SecondPage search(String searchText){
        driver.get("https://pagewebsite.com");
        driver.findElement(element).sendKeys(searchText);
        return new SeconPage(driver);
    }
    */
}
