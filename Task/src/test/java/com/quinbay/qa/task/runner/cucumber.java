package com.quinbay.qa.task.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/destination/cucumber.json","pretty", "html:target/cucumber/report.html"},
        tags="@TaskFeature",
        glue = {"com.quinbay.tivo.steps"},
        features = "src/test/resources/feature"
)
public class cucumber {
}
