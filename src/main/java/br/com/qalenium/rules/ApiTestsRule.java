package br.com.qalenium.rules;

import br.com.qalenium.interfaces.IApiTestsRule;

public class ApiTestsRule extends GenericTestsRule implements IApiTestsRule {

    @Override
    protected void before() {
        //Method used before every api tests
    }

    @Override
    protected void after() {
        //Method used after every api tests
    }
}