package se.iths.stepDefs;

import cucumber.api.java.en.When;
import se.iths.helpers.MimicGuiSelenium;

public class SeleniumStepDef {
	
	private MimicGuiSelenium driver;
	private String host = "http://localhost:8080/";
	
	@When("^I open the url \"([^\"]*)\"$")
	public void i_open_the_url(String arg1) throws Throwable {
		driver = new MimicGuiSelenium();
	    driver.openURL(host+arg1);
	}
	
	@When("^I open the url \"([^\"]*)\" in Chrome$")
	public void i_open_the_url_in_chrome(String arg1) throws Throwable {
		driver = new MimicGuiSelenium("chrome");
		driver.openURL(host+arg1);
	}
	
	@When("^I open the url \"([^\"]*)\" in FireFox$")
	public void i_open_the_url_in_firefox(String arg1) throws Throwable {
		driver = new MimicGuiSelenium("firefox");
		driver.openURL(host+arg1);
	}
	
	@When("^I open the url \"([^\"]*)\" in Edge$")
	public void i_open_the_url_in_edge(String arg1) throws Throwable {
		driver = new MimicGuiSelenium("edge");
		driver.openURL(host+arg1);
	}
	
	@When("^I enter the url \"([^\"]*)\"$")
	public void i_enter_the_url(String arg1) throws Throwable {
		driver.openURL(arg1);
	}
	
	@When("^I input \"([^\"]*)\" in the response form$")
	public void i_input_in_the_response_form(String arg1) throws Throwable {
	    driver.sendText(arg1);
	}

	@When("^I press the learn button$")
	public void i_press_the_learn_button() throws Throwable {
	    driver.clickLearn();
	}
	
	@When("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	    driver.quitSelenium();
	}
	
	@When("^I open the relearnResponse URL$")
	public void i_use_the_relearn_function() throws Throwable {
	    driver.openURL(host+"relearnResponse");
	}
	
}


