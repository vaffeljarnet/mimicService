package se.iths.testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java",
		tags = {"@Relearn112,@Relearn113,@AutoLearn,@LearnNextResponseMultiBrowser"},
		glue = {"classpath:se/iths/stepDefs"}
		)
public class Sprint4TestSuite {}

