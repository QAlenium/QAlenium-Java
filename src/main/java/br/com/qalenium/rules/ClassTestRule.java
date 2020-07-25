package br.com.qalenium.rules;

import br.com.qalenium.annotations.TestClassDescription;
import br.com.qalenium.config.Utils;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.ArrayList;
import java.util.List;

public class ClassTestRule extends ExternalResource implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                buildRuleChain(description).apply(base, description).evaluate();
            }
        };
    }

    private RuleChain buildRuleChain(Description description) {
        List<TestRule> rules = new ArrayList<>();

        TestClassDescription testClassDescription = description.getAnnotation(TestClassDescription.class);

        if (testClassDescription == null) {
            throw new IllegalArgumentException("The test class must have the @TestClassDescription annotation");
        } else if (testClassDescription.value().isEmpty()) {
            throw new IllegalArgumentException("The test class must have at least a description");
        } else if (testClassDescription.value().length() < 20) {
            throw new IllegalArgumentException("Your test class description is too short");
        }

        return new Utils().buildRuleChain(rules);
    }
}
