package br.com.qalenium.rules;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;

public class ApiTestsRule extends ExternalResource implements TestRule {

    @ClassRule
    public static ClassTestRule classTestRule = new ClassTestRule();

    @Rule
    public MethodTestRule methodTestRule = new MethodTestRule();

    @Override
    protected void before() throws Throwable {
        //before api tests
        System.out.println();
    }

    @Override
    protected void after() {
        //after api tests
        System.out.println();
    }
}