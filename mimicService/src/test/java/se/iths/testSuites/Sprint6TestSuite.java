package se.iths.testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java",
		tags = {""},
		glue = {"classpath:se/iths/stepDefs"}
		)
public class Sprint6TestSuite {}

// MachineLearning113, 117, 119
//LearnNextResponse113
//GUILearnNextResponse111
//ViewRequests114, 115