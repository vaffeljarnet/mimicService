package se.iths.testSuites;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java",
		glue = {"classpath:se/iths/stepDefs"}
		)
public class RegressionTestSuite {}
