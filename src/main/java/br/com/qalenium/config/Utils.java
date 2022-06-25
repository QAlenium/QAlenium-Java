package br.com.qalenium.config;

import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Utils {

    public static WebDriver getDriver() {
        String os = System.getProperty("os.name");

        if (os.contains("OS X")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/mac/chromedriver");
        } else if (os.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/windows/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/linux/chromedriver");
        }

        return new ChromeDriver();
    }

    public RuleChain buildRuleChain(List<TestRule> rules) {
        RuleChain ruleChain = RuleChain.emptyRuleChain();
        for (TestRule testRule : rules) {
            ruleChain = ruleChain.around(testRule);
        }
        return ruleChain;
    }

}
