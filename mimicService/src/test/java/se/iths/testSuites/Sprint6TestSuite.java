package se.iths.testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java",
		tags = {"@MachineLearning113"},
		glue = {"classpath:se/iths/stepDefs"},
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" },
		monochrome = true
		)
public class Sprint6TestSuite {}

// MachineLearning113, 117, 119
//LearnNextResponse113
//GUILearnNextResponse111
//ViewRequests114, 115