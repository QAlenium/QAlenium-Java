package br.com.qalenium.tests;

import br.com.qalenium.annotations.StoryLink;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@TestClassDescription("Assure something else")
public class WebTemplateTest extends WebTestsRule {

    private WebDriver webDriver = getWebDriver();
    private String date = "";

    @Before
    public void testSetup() {
    }

    @After
    public void testTearDown() {
    }

    @Test
    @Web
    //@Ignore("Ignore running this tests")
    @StoryLink("https://www.example.com/issues/1234")
    @TestDescription("assure something else")
    public void testTemplate() {
        webDriver.get("");
        Assert.assertTrue(true);
    }

    @Test
    @Web
    //@Ignore("Ignore running this tests")
    @StoryLink("https://www.example.com/issues/1234")
    @TestDescription("assure something else")
    public void searchForNextAvailableDate() throws InterruptedException {
        webDriver.get("https://ais.usvisa-info.com/en-ca/niv/users/sign_in");
        webDriver.findElement(By.className("icheckbox")).click();
        webDriver.findElement(By.id("user_email")).sendKeys("EMAIL");
        webDriver.findElement(By.id("user_password")).sendKeys("PASSWORD");
        webDriver.findElement(By.id("user_password")).sendKeys(Keys.RETURN);

        webDriver.findElement(By.className("button")).click();
        webDriver.findElement(By.className("fa-calendar-minus")).click();
        Thread.sleep(500);
        webDriver.findElement(By.xpath("//a[text()='Reschedule Appointment']")).click();

        webDriver.findElement(By.className("primary")).click();

        Select dropdown = new Select(webDriver.findElement(By.id("appointments_consulate_appointment_facility_id")));
        selectLocation(dropdown, "Ottawa");

        for(int i = 0; i < 30; i++) {
            selectLocation(dropdown, "Montreal");
            selectLocation(dropdown, "Ottawa");
            selectLocation(dropdown, "Quebec City");
            selectLocation(dropdown, "Toronto");
        }

    }

    private void selectLocation(Select dropdown, String location) throws InterruptedException {
        dropdown.selectByVisibleText(location);
        webDriver.findElement(By.className("margin-bottom-30")).click();
        Thread.sleep(3000);
        if (validateErrorMessage())
            return;

        webDriver.findElement(By.id("appointments_consulate_appointment_date")).click();
        if (!findNextAvailableDateInTheFirstTable(location)) {

            for (int i = 0; i < 14; i++) {
                webDriver.findElement(By.className("ui-icon-circle-triangle-e")).click();
                Thread.sleep(500);

                String tableMonth = webDriver.findElement((By.className("ui-datepicker-month"))).getText();
                String tableYear = webDriver.findElement((By.className("ui-datepicker-year"))).getText();
                if (tableMonth.equals("March") && tableYear.equals("2023")){
                    return;
                }

                if (findNextAvailableDateInTheLastTable(location))
                    return;
            }
        }
    }

    private boolean validateErrorMessage() {
        return webDriver.findElement(By.id("consulate_date_time_not_available")).isDisplayed();
    }

    private boolean findNextAvailableDateInTheFirstTable(String location){
        WebElement table = webDriver.findElement(By.className("ui-datepicker-group-first"));
        List<WebElement> availableDates = table.findElements(By.cssSelector("[data-handler=selectDay]"));
        if (!availableDates.isEmpty()){
            for (WebElement availableDate : availableDates) {
                String month = Integer.toString(Integer.parseInt(availableDate.getAttribute("data-month")) + 1);
                String year = availableDate.getAttribute("data-year");
                String day = availableDate.findElement(By.className("ui-state-default")).getText();

                if (!date.equals(day + "/" + month + "/" + year)) {
                    date = day + "/" + month + "/" + year;
                    System.out.println("Available date in: " + location + " at: " + date);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findNextAvailableDateInTheLastTable(String location){
        WebElement table = webDriver.findElement(By.className("ui-datepicker-group-last"));
        List<WebElement> availableDates = table.findElements(By.cssSelector("[data-handler=selectDay]"));
        if (!availableDates.isEmpty()){
            for (WebElement availableDate : availableDates) {
                String month = Integer.toString(Integer.parseInt(availableDate.getAttribute("data-month")) + 1);
                String year = availableDate.getAttribute("data-year");
                String day = availableDate.findElement(By.className("ui-state-default")).getText();

                if (!date.equals(day + "/" + month + "/" + year)) {
                    date = day + "/" + month + "/" + year;
                    System.out.println("Available date in: " + location + " at: " + date);
                    return true;
                }
            }
        }
        return false;
    }
}




