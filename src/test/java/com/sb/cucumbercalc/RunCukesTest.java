package com.sb.cucumbercalc;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:target/html"},
        features = {"features"},
        glue = {"com.sb.cucumbercalc.steps", "com.sb.cucumbercalc.hooks"},
        name = "",
        tags = {},
        strict = true,
        monochrome = false,
        dryRun=false)
public class RunCukesTest {
}