package br.com.qalenium.tests.template;

import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@TestClassDescription("This test class is supposed to assure something else")
public class TestsTemplate /*extends WebTestsRule*/ /*ApiTestsRule*/ /*MobileTestsRule*/ {

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
    @Ignore("Use this annotation in case you want to ignore this test from runs")
    @StoryLink("Use this annotation in case you want to trace the story adding the link")
    @TestDescription("This test is supposed to assure something else")
    public void testItself() {
        System.out.println("hello world!");
        Assert.assertTrue(true);
    }
}
