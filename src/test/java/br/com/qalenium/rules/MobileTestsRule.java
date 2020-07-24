package br.com.qalenium.rules;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;

public class MobileTestsRule extends ExternalResource implements TestRule {

    @ClassRule
    public static ClassTestRule classTestRule = new ClassTestRule();

    @Rule
    public MethodTestRule methodTestRule = new MethodTestRule();

    @Override
    protected void before() {
    }

    @Override
    protected void after() {
    }
}