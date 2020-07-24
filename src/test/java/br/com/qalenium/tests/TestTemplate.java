package br.com.qalenium.tests;

import br.com.qalenium.annotations.Api;
import br.com.qalenium.annotations.Description;
import br.com.qalenium.annotations.Mobile;
import br.com.qalenium.annotations.Web;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public void testItself() {

    }
}
