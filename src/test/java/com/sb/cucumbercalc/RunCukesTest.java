package com.sb.cucumbercalc;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(plugin="pretty",
        strict = true,
        snippets=SnippetType.CAMELCASE,
        features = {"features"},
        glue = {"com.sb.cucumbercalc.stepdefs.Steps"},
        dryRun=false)
public class RunCukesTest {
}