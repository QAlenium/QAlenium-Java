package br.com.qalenium.tests;

import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.annotations.Web;
import br.com.qalenium.rules.WebTestsRule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@TestClassDescription("This test class is supposed to assure something else")
public class TestTemplate extends WebTestsRule {

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
    @Web
    @TestDescription("This test is supposed to assure something else")
    public void testItself() {

    }
}
