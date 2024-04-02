package com.sparta.shs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/sparta/shs/features",
        glue = {"com.sparta.shs.steps"},
        plugin = {
                "pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt"
        }
)

public class TestRunner {
}
