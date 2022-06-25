package br.com.qalenium.tests;

import br.com.qalenium.annotations.Api;
import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.rules.ApiTestsRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

@TestClassDescription("Assure something")
public class ApiTemplateTest extends ApiTestsRule {

    //private WebDriver webDriver = getWebDriver();

    @Before
    public void testSetup() {
    }

    @After
    public void testTearDown() {
    }

    @Test
    @Api
    //@Ignore("Ignore running this tests")
    @StoryLink("https://www.example.com/issues/1234")
    @TestDescription("assure something else")
    public void testTemplate() {
        int statusCode = given().when().get("https://google.com").statusCode();
        Assert.assertEquals(200, statusCode);
    }
}




