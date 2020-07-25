package br.com.qalenium.rules;

import br.com.qalenium.annotations.Api;
import br.com.qalenium.annotations.Mobile;
import br.com.qalenium.annotations.TestDescription;
import br.com.qalenium.annotations.Web;
import br.com.qalenium.config.Utils;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.ArrayList;
import java.util.List;

public class MethodTestRule extends ExternalResource implements TestRule {

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

        Api api = description.getAnnotation(Api.class);
        Web web = description.getAnnotation(Web.class);
        Mobile mobile = description.getAnnotation(Mobile.class);
        TestDescription testDescription = description.getAnnotation(TestDescription.class);

        if (testDescription == null) {
            throw new IllegalArgumentException("The test method must have the @TestDescription annotation");
        } else if (testDescription.value().isEmpty()) {
            throw new IllegalArgumentException("The test method must have at least a description");
        } else if (testDescription.value().length() < 20) {
            throw new IllegalArgumentException("Your test description is too short");
        }

        if (api == null && web == null && mobile == null) {
            throw new IllegalArgumentException("You must have at least one of the following annotations in your test method: " +
                    "@Api | @Web | @Mobile");
        }

        if (api != null) {
            rules.add(new ApiTestsRule());
        }

        if (web != null) {
            rules.add(new WebTestsRule());
        }

        if (mobile != null) {
            rules.add(new MobileTestsRule());
        }

        return new Utils().buildRuleChain(rules);
    }
}
