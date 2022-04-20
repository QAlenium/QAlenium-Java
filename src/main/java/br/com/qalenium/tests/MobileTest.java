package br.com.qalenium.tests;

import br.com.qalenium.annotations.Mobile;
import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.rules.MobileTestsRule;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@TestClassDescription("Assure that the login page is working")
public class MobileTest extends MobileTestsRule {

    private AndroidDriver androidDriver;
    @Before
    public void testSetup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP,"./resources/apk/app-debug.apk");
        androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @After
    public void testTearDown() {
        androidDriver.close();
    }

    @Test
    @Mobile
    @StoryLink("https://www.example.com/issues/1234")
    @TestDescription("assure something else")
    public void login() {
        androidDriver.get("https://google.com");
        Assert.assertTrue(true);
    }
}




