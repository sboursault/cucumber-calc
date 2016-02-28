package com.sb.cucumbercalc.steps;

import com.sb.cucumbercalc.support.ui.GoogleInterface;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javax.annotation.Resource;

/**
 * Created by sboursault on 23/02/16.
 */
public class UserSteps {

    @Resource
    GoogleInterface googleInterface;

    @When("^I search for \"(\\w+)\" in google$")
    public void iSearchForKeywordsInGoogle(String keywords) throws Throwable {
        googleInterface.search(keywords);
    }

    @Then("^the calculator should be displayed$")
    public void theCalculatorShouldBeDisplayed() throws Throwable {
        googleInterface.calculatorShouldBeDisplayed();
    }

    @Given("^I have opened the calculator$")
    public void i_have_opened_the_calculator() throws Throwable {
        googleInterface.openCalculator();
    }

    @When("^I add (\\d+) to (\\d+)$")
    public void iAddAToB(int a, int b) throws Throwable {
        googleInterface.getCalculator().type(a + "+" + b);
    }

    @Then("^the result should be (\\d+)$")
    public void theResultDisplayedIs(int result) throws Throwable {
        googleInterface.getCalculator().resultShouldBe(result);
    }
}
