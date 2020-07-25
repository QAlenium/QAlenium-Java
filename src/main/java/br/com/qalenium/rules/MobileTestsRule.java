package br.com.qalenium.rules;

import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;

public class MobileTestsRule extends ExternalResource implements TestRule {

    @Override
    protected void before() {
        //Method used before every mobile tests
    }

    @Override
    protected void after() {
        //Method used after every mobile tests
    }
}