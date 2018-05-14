package se.iths.testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java",
		tags = {"@MachineLearning,@UnlearnResponse,@UnlearnAllResponses,@AddResponse,@RelearnResponse,@ViewRequests"},
		glue = {"classpath:se/iths/stepDefs"}
		)
public class Sprint5TestSuite {}

