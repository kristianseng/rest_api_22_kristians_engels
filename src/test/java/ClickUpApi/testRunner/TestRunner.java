package ClickUpApi.testRunner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/report.xml"
        },
        features = {"src/test/resources/features"},
        glue = {"ClickUpApi/stepdefinitions"}
)


public class TestRunner {
}
