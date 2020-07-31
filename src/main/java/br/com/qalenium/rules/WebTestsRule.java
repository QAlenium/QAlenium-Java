package br.com.qalenium.rules;

import br.com.qalenium.config.Utils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WebTestsRule extends GenericTestsRule {


    @Override
    protected void before() {

        System.out.println("Antes Webtestrule");

    }

    @Override
    protected void after() {

        System.out.println("Depois Webtestrule");

    }
}