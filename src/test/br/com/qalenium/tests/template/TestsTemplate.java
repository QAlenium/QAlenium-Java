package br.com.qalenium.tests.template;

import br.com.qalenium.annotations.Api;
import br.com.qalenium.annotations.Mobile;
import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.annotations.Web;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

@TestClassDescription("Assure something")
public class TestsTemplate /*extends WebTestsRule*/ /*extends ApiTestsRule*/ /*extends MobileTestsRule*/ {

    //private WebDriver webDriver = getWebDriver();

    @Before
    public void testSetup() {
    }

    @After
    public void testTearDown() {
    }

    @Test
    @Web
    @Api
    @Mobile
    @Ignore("Ignore running this tests")
    @StoryLink("https://www.example.com/issues/1234")
    @TestDescription("assure something else")
    public void testTemplate() {
        Assert.assertTrue(true);
    }
}




