package com.sb.cucumbercalc;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:cukes.html"},
        features = {"features"},
        glue = {"com.sb.cucumbercalc.steps", "com.sb.cucumbercalc.hooks"},
        name = "",
        tags = {},
        strict = true,
        monochrome = true,
        dryRun=false)
public class RunCukesTest {
}