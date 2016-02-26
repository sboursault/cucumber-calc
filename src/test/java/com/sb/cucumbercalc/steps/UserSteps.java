package com.sb.cucumbercalc.steps;

import com.sb.cucumbercalc.support.GoogleInterface;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javax.annotation.Resource;

/**
 * Created by me on 23/02/16.
 */
public class UserSteps {

    @Resource
    GoogleInterface googleInterface;

    @When("^I search for \"(\\w+)\" in google$")
    public void i_search_for_keywords_in_google(String keywords) throws Throwable {
        googleInterface.search(keywords);
    }

    @Then("^the calculator should be displayed$")
    public void theCalculatorIsDisplayed() throws Throwable {
        googleInterface.calculatorShouldBeDisplayed();
    }

    @When("^I add (\\d+) to (\\d+)$")
    public void iAddTo(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the result should be (\\d+)$")
    public void theResultDisplayedIs(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
