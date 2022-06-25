package br.com.qalenium.tests;

import br.com.qalenium.annotations.*;
import org.junit.*;

@TestClassDescription("Assure something")
public class TemplateTest /*extends WebTestsRule/* /*extends ApiTestsRule/* /*extends MobileTestsRule*/ {

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




