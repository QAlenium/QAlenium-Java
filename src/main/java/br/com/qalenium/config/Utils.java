package br.com.qalenium.config;

import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Utils {

    public WebDriver getDriver() {
        String os = System.getProperty("os.name");

        if (os.contains("OS X")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/mac/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/windows/chromedriver.exe");
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
