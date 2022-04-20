package br.com.qalenium.execution;

import br.com.qalenium.suites.RegressionSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Play {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RegressionSuite.class);
        System.out.println(result.getFailures());
    }

}
