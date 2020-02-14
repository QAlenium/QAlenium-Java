package br.com.empresa.almintegration.testing.mobile.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;

public class AsusCalculator {

	@FindBy(id="digit0")
	private WebElement digit0;
	
	@FindBy(id="digit1")
	private WebElement digit1;
	
	@FindBy(id="digit2")
	private WebElement digit2;
	
	@FindBy(id="digit3")
	private WebElement digit3;
	
	@FindBy(id="digit4")
	private WebElement digit4;
	
	@FindBy(id="digit5")
	private WebElement digit5;
	
	@FindBy(id="digit6")
	private WebElement digit6;
	
	@FindBy(id="digit7")
	private WebElement digit7;
	
	@FindBy(id="digit8")
	private WebElement digit8;
	
	@FindBy(id="digit9")
	private WebElement digit9;
	
	@FindBy(id="equal")
	private WebElement equal;
	
	public WebElement getEqual() {
		return equal;
	}

	public WebElement getDigit0() {
		return digit0;
	}

	public WebElement getDigit1() {
		return digit1;
	}

	public WebElement getDigit2() {
		return digit2;
	}

	public WebElement getDigit3() {
		return digit3;
	}

	public WebElement getDigit4() {
		return digit4;
	}

	public WebElement getDigit5() {
		return digit5;
	}

	public WebElement getDigit6() {
		return digit6;
	}

	public WebElement getDigit7() {
		return digit7;
	}

	public WebElement getDigit8() {
		return digit8;
	}

	public WebElement getDigit9() {
		return digit9;
	}

	public void clickOnPLUSOperation(WebDriver driver){
		driver.findElement(By.id("plus")).click();
	}
	
	public void clickOnMINUSOperation(WebDriver driver){
		driver.findElement(By.id("minus")).click();
	}
	
	public void clickOnMULperation(WebDriver driver){
		driver.findElement(By.id("mul")).click();
	}
	
	public void clickOnDIVOperation(WebDriver driver){
		driver.findElement(By.id("div")).click();
	}
	
	public String getResultFromOperation(WebDriver driver){
		return driver.findElement(By.id("resultEditTextID")).getText();
	}
}
