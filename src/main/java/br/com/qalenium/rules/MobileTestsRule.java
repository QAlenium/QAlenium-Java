package br.com.qalenium.rules;

import br.com.qalenium.interfaces.IMobileTestsRule;

public class MobileTestsRule extends GenericTestsRule implements IMobileTestsRule {

    @Override
    protected void before() {
        //Method used before every mobile tests
    }

    @Override
    protected void after() {
        //Method used after every mobile tests
    }
}