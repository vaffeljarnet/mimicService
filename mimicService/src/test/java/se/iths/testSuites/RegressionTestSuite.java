package se.iths.testSuites;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java",
		glue = {"classpath:se/iths/stepDefs"},
				tags = {"~@MachineLearning113,~@MachineLearning118,~@MachineLearning119,"
						+ "~@LearnNextResponse113,~@GuiLearnNextResponse111,"
						+ "~@ViewRequests114,~@ViewRequests115,"
						+ "~@ResponseForm112,~@ResponseForm113"},
		plugin = { "pretty", "json:target/cucumber-reports/regressionResults.json" },
		monochrome = true
		)
public class RegressionTestSuite {}
