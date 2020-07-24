package br.com.qalenium.rules;

import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;

public class GenericTestRule extends ExternalResource implements TestRule {

    @Override
    protected void before() throws Throwable {
        //before every kind of test
    }

    @Override
    protected void after() {
        //after every kind of tests
    }
}
