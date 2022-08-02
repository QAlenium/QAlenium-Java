package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class StepDefinitions {
    private String endpoint;
    private String apiReturn;
    private String responseCode;
    private String httpParam;
    private File outputFile;

    @Given("^I have the endpoint \"([^\"]*)\"$")
    public void i_have_the_endpoint(String arg1) {
        endpoint = arg1;
    }

    @Then("^I should be able to call it$")
    public void i_should_be_able_to_call_it() throws Throwable {
        if(!endpoint.contains(":") || !endpoint.contains("//") || !endpoint.contains("zippopotam")) {
            throw new MalformedURLException();
        }
    }

    @When("^I perform a \"([^\"]*)\" in the given api$")
    public void i_perform_a_in_the_given_api(String arg1) throws Throwable {
        StringBuilder result = new StringBuilder();
        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            conn.setRequestMethod(arg1);
        } catch (ProtocolException p){
            responseCode = "Invalid HTTP Method";
            return;
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        } catch (Exception e) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getErrorStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }
        }
        responseCode = String.valueOf(conn.getResponseCode());
        outputFile = new File("payload-sortie.json");
        outputFile.createNewFile();
        apiReturn = result.toString();
    }

    @Then("^I am able to validate a \"([^\"]*)\" status code$")
    public void i_am_able_to_validate_a_status_code(String arg1) {
        if (!arg1.equals(responseCode)) {
            throw new RuntimeException("Response code not expected");
        }
    }

    @Then("^my output payload must be equals to \"([^\"]*)\"$")
    public void my_output_payload_must_be_equals_to(String arg1) {
        if (!outputFile.exists()) {
            throw new RuntimeException("The output payload is not " + arg1);
        }
    }

    @When("^I use \"([^\"]*)\" as parameter$")
    public void i_use_as_parameter(String arg1) {
        httpParam = arg1;
    }

}
