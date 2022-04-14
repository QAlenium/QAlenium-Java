package br.com.qalenium.tests.template;

import br.com.qalenium.annotations.Mobile;
import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.rules.MobileTestsRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;

@TestClassDescription("Assure that the login page is working")
public class MobileTest extends MobileTestsRule {

    @Before
    public void testSetup() throws IOException {
        startServer();
        startEmulator();
        startSimulator();
    }

    @After
    public void testTearDown() throws IOException {
        stopServer();
        closeEmulator();
        closeSimulator();
    }

    @Test
    @Mobile
    @StoryLink("https://www.example.com/issues/1234")
    @TestDescription("assure something else")
    public void login() {
        Assert.assertTrue(true);
    }
}




