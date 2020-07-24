package br.com.qalenium.tests;

import br.com.qalenium.annotations.Api;
import br.com.qalenium.annotations.Description;
import br.com.qalenium.annotations.Mobile;
import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.Web;
import br.com.qalenium.rules.ApiTestsRule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestTemplate {

    @BeforeClass
    public void classSetup() {

    }

    @AfterClass
    public void classTearDown() {

    }

    @Before
    public void testSetup() {

    }

    @After
    public void testTearDown() {

    }

    @Test
    @Web
    @Mobile
    @Api
    @Description("This test is supposed to assure something else")
    @Ignore("In case you want exclude this test from some suit")
    @StoryLink("In case we have a story link to associate with")
    public void testItself() {

    }
}
