package br.com.qalenium.tests;

import br.com.qalenium.annotations.Mobile;
import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.rules.MobileTestsRule;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

@TestClassDescription("Assure the screenshot mechanism is working")
public class MobileTest extends MobileTestsRule {

    private AndroidDriver androidDriver;

    @Before
    public void testSetup() {
        androidDriver = setupAndroidCapabilities();
    }

    @After
    public void testTearDown() {
        androidDriver.close();
    }

    @Test
    @Mobile
    @StoryLink("https://github.com/QAlenium/QAlenium-Java/issues/8")
    @TestDescription("Assure that we take a screenshot after the app is open")
    public void openAppAndSaveScreenShot() throws IOException {
        File screenshotAs = androidDriver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs, new File("./resources/screenshots"));
    }
}




