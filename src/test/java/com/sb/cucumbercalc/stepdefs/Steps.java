package com.sb.cucumbercalc.stepdefs;

import com.sb.cucumbercalc.pageobjects.CalcInterface;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by me on 23/02/16.
 */
@Component
public class Steps {

    @Resource
    CalcInterface calcInterface;

    @When("^I search for calculatrice in google$")
    public void iSearchForCalculatriceInGoogle() throws Throwable {
        calcInterface.search("calculatrice");
    }

    @Then("^the calculator is displayed$")
    public void theCalculatorIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @When("^I add (\\d+) to (\\d+)$")
    public void iAddTo(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the result displayed is (\\d+)$")
    public void theResultDisplayedIs(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
