package se.iths.testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java",
		tags = {"@MachineLearning113,@MachineLearning118,@MachineLearning119,"
				+ "@LearnNextResponse113,@GuiLearnNextResponse111,"
				+ "@ViewRequests114,@ViewRequests115,"
				+ "@ResponseForm112,@ResponseForm113"},
		glue = {"classpath:se/iths/stepDefs"},
		plugin = { "pretty", "json:target/cucumber-reports/sprint6Results.json" },
		monochrome = true
		)
public class Sprint6TestSuite {}