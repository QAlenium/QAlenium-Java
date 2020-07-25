package br.com.qalenium.rules;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;

public class GenericTestsRule extends ExternalResource implements TestRule {

    @ClassRule
    public static final ClassTestRule classTestRule = new ClassTestRule();

    @Rule
    public MethodTestRule methodTestRule = new MethodTestRule();

}
