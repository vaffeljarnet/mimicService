package se.iths.stepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.iths.helpers.MimicGuiSelenium;

public class SeleniumStepDef {
	
	private MimicGuiSelenium driver;
	private String host = "http://localhost:8080/";
	
	@When("^I open the browser with the request \"([^\"]*)\"$")
	public void i_open_the_url(String arg1) throws Throwable {
		driver = new MimicGuiSelenium();
	    driver.openURL(host+arg1);
	}
	
	@When("^I open the browser$")
	public void i_open_the_browser() throws Throwable {
		driver = new MimicGuiSelenium();
	    driver.openURL("http://www.google.se");
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
	
	@When("^I enter the request \"([^\"]*)\"$")
	public void i_enter_the_url(String arg1) throws Throwable {
		driver.openURL(host+arg1);
		driver.delay(100);
	}
	
	@When("^I enter the request \"([^\"]*)\" \"([^\"]*)\" times$")
	public void i_enter_the_url_times(String arg1, String arg2) throws Throwable {
		int nrOfCalls = Integer.parseInt(arg2);
		for(int i = 0;i<nrOfCalls;i++) {
			driver.openURL(host+arg1);
			driver.delay(100);
		}
	}
	
	@When("^I input \"([^\"]*)\" in the response form$")
	public void i_input_in_the_response_form(String arg1) throws Throwable {
	    driver.sendText(arg1);
	    driver.delay(100);
	}
	
	@When("^I input \"([^\"]*)\" in the response form and press the Learn button$")
	public void i_input_in_the_response_form_and_press_learn(String arg1) throws Throwable {
	    driver.sendText(arg1);
	    driver.clickLearn();
	    driver.delay(100);
	}

	@When("^I press the learn button$")
	public void i_press_the_learn_button() throws Throwable {
	    driver.clickLearn();
	    driver.delay(100);
	}
	
	@When("^I make a /relearnResponse request$")
	public void i_use_the_relearn_function() throws Throwable {
	    driver.openURL(host+"relearnResponse");
	    driver.delay(100);
	}
	
	@When("^I make an /addResponse request$")
	public void i_make_an_addResponse_request() throws Throwable {
		driver.openURL(host+"addResponse");
		driver.delay(100);
	}
	
	@When("^I make a /resetState request$")
	public void i_make_a_ResetState_request() throws Throwable {
		driver.openURL(host+"resetState");
		driver.delay(100);
	}
	
	@When("^I make an /unlearnResponse request$")
	public void i_make_a_unlearnResponse_request() throws Throwable {
		driver.openURL(host+"unlearnResponse");
		driver.delay(100);
	}
	
	@When("^I make a /viewRequests request$")
	public void i_make_a_viewRequests_request() throws Throwable {
		driver.openURL(host+"viewRequests");
		driver.delay(100);
	}
	
	@When("^I add the states below to the request \"([^\"]*)\"$")
	public void i_add_the_states_bellow_to_the_request(String arg1, DataTable arg2) throws Throwable {
		driver.openURL(host+arg1);
		for (Map<String, String> examples : arg2.asMaps(String.class, String.class)) {
	    	driver.openURL(host+"addResponse");
	    	driver.sendText(examples.get("state"));
	    	driver.clickLearn();
	    	driver.delay(100);
	    }
	}
	
	@When("^I click state \"([^\"]*)\" in the viewRequests overview$")
	public void i_click_state_in_viewRequests(String arg1) throws Throwable {
		int index = Integer.parseInt(arg1);
		driver.clickViewRequestIndex(index);
	}
	
	@When("^I set mime type as \"([^\"]*)\"$")
	public void i_set_mime_type_as(String arg1) throws Throwable {
		driver.selectMimeType(arg1);
	}
	
	@Then("^\"([^\"]*)\" is present in the overview$")
	public void is_present_in_the_overview(String arg1) throws Throwable {
	    assertTrue(driver.getValue().contains(arg1));
	}
	
	@When("^I teach Mimic the below requests and responses$")
	public void i_teach_Mimic_the_below_requests_and_responses(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
	    	driver.openURL(host+examples.get("request"));
	    	driver.sendText(examples.get("response"));
	    	driver.clickLearn();
	    	driver.delay(100);
	    }
	}
	
	@Then("^\"([^\"]*)\" is displayed$")
	public void is_displayed(String arg1) throws Throwable {
		assertEquals(arg1, driver.getValue());
	}
	
	@Then("^the browser is closed$")
	public void i_close_the_browser() throws Throwable {
	    driver.quitSelenium();
	}
	
	@Then("^all requests below are present in the overview$")
	public void all_requests_below_are_present_in_the_overview(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
	    	assertTrue(driver.getValue().contains(examples.get("request")));
	    }
	}
	
	@Then("^all requests below are clickable and displays the corresponding response$")
	public void all_requests_below_are_clickable(DataTable arg1) throws Throwable {
		int index = 1;
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
	    	driver.clickViewRequestIndex(index);
	    	assertEquals(examples.get("response"), driver.getValue());
	    	driver.stepBack();
	    	index++;
	    }
	}
	
}


