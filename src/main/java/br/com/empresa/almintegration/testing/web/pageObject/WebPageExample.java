package br.com.empresa.almintegration.testing.web.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.empresa.almintegration.testing.web.WebTestCase;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.google.com.br")
public class WebPageExample extends WebTestCase {

	protected WebDriver driver;
	
	@FindBy(id="lst-ib")
	private WebElement seachField;
	
	//------------------------------------------------------------------------------------------------------------------------------
	
	public WebPageExample(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open(String url) {
		driver.get(url);
	}
	
	public void close() {
		driver.quit();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickOnSearchField() {
		seachField.click();
	}
	
	public void insertValueOnSearchField(String keys){
		seachField.sendKeys(keys);
	}

}
