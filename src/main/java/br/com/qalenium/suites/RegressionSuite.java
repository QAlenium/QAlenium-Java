package br.com.qalenium.suites;

import br.com.qalenium.tests.MobileTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MobileTest.class})
public class RegressionSuite {
}
