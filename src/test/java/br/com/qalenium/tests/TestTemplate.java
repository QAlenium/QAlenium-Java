package br.com.qalenium.tests;

import br.com.qalenium.annotations.Api;
import br.com.qalenium.annotations.Mobile;
import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.annotations.Web;
import br.com.qalenium.rules.ApiTestsRule;
import br.com.qalenium.rules.MobileTestsRule;
import br.com.qalenium.rules.WebTestsRule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@TestClassDescription("This test class is supposed to assure something else")
public class TestTemplate extends WebTestsRule /*extends ApiTestsRule*/ /*extends MobileTestsRule*/ {

    @BeforeClass
    public static void classSetup() {

    }

    @AfterClass
    public static void classTearDown() {

    }

    @Before
    public void testSetup() {

    }

    @After
    public void testTearDown() {

    }

    @Test
    //@Api
    //@Web
    //@Mobile
    @TestDescription("This test is supposed to assure something else")
    //@Ignore("In case you want exclude this test from some suit")
    @StoryLink("In case we have a story link to associate with")
    public void testItself() {

    }
}
