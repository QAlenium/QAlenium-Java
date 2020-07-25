package br.com.qalenium.rules;

import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;

public class WebTestsRule extends ExternalResource implements TestRule {

    @Override
    protected void before() {
        //Method used before every web tests
    }

    @Override
    protected void after() {
        //Method used after every web tests
    }
}