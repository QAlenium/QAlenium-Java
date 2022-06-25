package br.com.qalenium.tests;

import br.com.qalenium.annotations.Mobile;
import br.com.qalenium.annotations.StoryLink;
import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.rules.MobileTestsRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@TestClassDescription("Assure something")
public class MobileTemplateTest extends MobileTestsRule {

    @Before
    public void testSetup() {
    }

    @After
    public void testTearDown() {
    }

    @Test
    @Mobile
    //@Ignore("Ignore running this tests")
    @StoryLink("https://www.example.com/issues/1234")
    @TestDescription("assure something else")
    public void testTemplate() {
        Assert.assertEquals("200", "200");
    }
}




