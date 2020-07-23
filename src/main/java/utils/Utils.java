package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {

    public WebDriver getDriver() {
        String os = System.getProperty("os.name");

        if (os.contains("OS X")) {
            System.setProperty("webdriver.chrome.driver", "./driver/mac/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "./driver/windows/chromedriver.exe");
        }

        return new ChromeDriver();
    }

}
