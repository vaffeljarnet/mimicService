package se.iths.testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java",
		tags = {"@MachineLearning119"},
		glue = {"classpath:se/iths/stepDefs"},
		plugin = { "pretty", "json:target/cucumber-reports/tempRunnerResult.json" },
		monochrome = true
		)
public class TempRunner {}

