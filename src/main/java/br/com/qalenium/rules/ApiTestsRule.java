package br.com.qalenium.rules;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;

public class ApiTestsRule extends GenericTestsRule {

    @Override
    protected void before() {
        //Method used before every api tests
    }

    @Override
    protected void after() {
        //Method used after every api tests
    }
}