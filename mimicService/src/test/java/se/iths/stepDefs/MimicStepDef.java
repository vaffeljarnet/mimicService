package se.iths.stepDefs;

import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.iths.helpers.*;

public class MimicStepDef {
	private final static String host="http://localhost:8080/"; 
	private HttpServiceCaller service = new HttpServiceCaller();
	private String responseForm = "Paste or type json, xml, html or text response to learn and press Learn<br><br><form action=\"/learnresponse\" method=\"post\"><select name='mime'><option value='auto'>Auto</option><option value='application/json'>JSON</option><option value='application/xml'>XML</option><option value='text/html'>HTML</option><option value='text/plain'>Text</option></select><br><textarea name='text' rows='30' cols='150'></textarea><br><br><input type=\"submit\" id='learn' value=\"Learn\"></form>";
	private MimicJarHelper helper = new MimicJarHelper();
	
	@Given("^that the mimicService is running$")
	public void that_the_mimicService_is_running() throws Throwable {
		if(helper.jarIsRunning()){
		}else {
			fail(helper.errorString());
		}
	}
	
	@Given("^that the mock has learned \"([^\"]*)\" with \"([^\"]*)\"$")
	public void that_the_mock_has_learned_questionOne_with_responseOne(String arg1, String arg2) throws Throwable {
		service.executeGetRequest(host + "LearnNextResponse?text="+arg2);
		service.executeGetRequest(host + arg1); 
		Assert.assertEquals(arg2, service.executeGetRequest(host + arg1));
	}	

	@Then("^the mock unlearns \"([^\"]*)\"$")
	public void the_mock_unlearns_questionTwo(String arg1) throws Throwable {
		Assert.assertEquals(responseForm, service.executeGetRequest(host + arg1));
	}
	
	@Then("^\"([^\"]*)\" returns the response form$")
	public void returns_the_response_form(String arg1) throws Throwable {
		helper.wait(100);
		Assert.assertEquals(responseForm, service.executeGetRequest(host + arg1));
	}
	
	@When("^I write unlearnAllResponses in url$")
	public void i_write_unlearnAll_in_url() throws Throwable {
	  service.executeGetRequest(host + "unlearnAllResponses");
	
	}
	
	@Given("^that no requests are stored$")
	public void that_no_requests_are_stored() throws Throwable {
	   service.executeGetRequest(host+ "unlearnAllResponses");
	    
	}

	@Then("^message \"([^\"]*)\" is returned$")
	public void the_mock_shows_error_message(String arg1) throws Throwable {
		Assert.assertEquals(arg1, service.executeGetRequest(host + "unlearnAllResponses"));
	}
	
	@When("^I teach the mock that \"([^\"]*)\" has response \"([^\"]*)\"$")
	public void i_teach_the_mock_that_has_response(String arg1, String arg2) throws Throwable {
		service.executeGetRequest(host + "LearnNextResponse?text="+arg2);
		service.executeGetRequest(host + arg1); 
	}
	
	@Then("^\"([^\"]*)\" respondes with \"([^\"]*)\"$")
	public void respondes_with(String arg1, String arg2) throws Throwable {
		helper.wait(100);
		Assert.assertEquals(arg2, service.executeGetRequest(host + arg1));
	}
	
	@Then("^\"([^\"]*)\" does not return empty response$")
	public void does_not_return_empty_response(String arg1, String arg2) throws Throwable {
		helper.wait(100);
		String response = service.executeGetRequest(host + arg1);
		Assert.assertFalse(response.equals(""));
		System.out.println("Actual response was: "+response);
	}
	
	@Then("^\"([^\"]*)\" does not responde with \"([^\"]*)\"$")
	public void does_not_responde_with(String arg1, String arg2) throws Throwable {
		helper.wait(100);
		String response = service.executeGetRequest(host + arg1);
		Assert.assertFalse(response.equals(arg2));
		System.out.println("Actual response was: "+response);
	}
	
	@When("^I call unlearnResponse")
	public void i_call_unlearn() throws Throwable {
		helper.wait(100);
	    service.executeGetRequest(host+"unlearnResponse");
	}
	
	@When("^I make the request \"([^\"]*)\"$")
	public void i_make_the_request(String arg1) throws Throwable {
		helper.wait(100);
		service.executeGetRequest(host+arg1);
	}

	@When("^\"([^\"]*)\" does not return an empty response$")
	public void does_not_return_empty(String arg1) throws Throwable {
		String response = service.executeGetRequest(host+arg1);
		Assert.assertTrue(!response.equals(""));
		System.out.println("Actual response was: "+response);
	}
	@Then("^the request \"([^\"]*)\" has the mime type \"([^\"]*)\"$")
	public void the_request_has_the_mime_type(String arg1, String arg2) throws Throwable {
		String mimeType = service.getMimeType(host+arg1);
	    Assert.assertTrue(mimeType.contains(arg2));
	    System.out.println("Mime Type: "+mimeType);
	}
	
	@When("^I terminate the mimicService$")
	public void i_terminate_mimicService() throws Throwable {
	    helper.killMimic();
	}

	@When("^I start mimicService$")
	public void i_start_mimicService() throws Throwable {
	    helper.startMimic();
	}
	
	@When("^I teach the mock the below questions and responses$")
	public void i_teach_the_mock_multiple_questions_with_responses(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
				service.executeGetRequest(host + "LearnNextResponse?text="+examples.get("response"));
				helper.wait(200);
				service.executeGetRequest(host + examples.get("question"));
				helper.wait(200);
			}
	}

	@Then("^every question below respondes with corresponding response$")
	public void every_question_respondes_with_correct_response(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
			Assert.assertEquals(examples.get("response"), service.executeGetRequest(host + examples.get("question"))); 
			helper.wait(200);
		}
	}

	@When("^I call resetState$")
	public void i_call_resetState() throws Throwable {
	    service.executeGetRequest(host+"resetState");
	    helper.wait(500);
	}
	
	@When("^I teach the mock the below sequense$")
	public void i_teach_the_mock_the_bellow_sequense(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
			service.executeGetRequest(host + "LearnNextResponse?text="+examples.get("response"));
			helper.wait(200);
			service.executeGetRequest(host + examples.get("question"));
			helper.wait(200);
		}
	}
	
	@When("^the mock has learned the below sequense$")
	public void the_mock_has_learned_the_bellow_sequense(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
			service.executeGetRequest(host + "LearnNextResponse?text="+examples.get("response"));
			helper.wait(200);
			service.executeGetRequest(host + examples.get("question"));
			helper.wait(200);
		}
	}

	@Then("^every step in the stored sequense respondes with the stored response as below$")
	public void every_step_in_the_stored_sequense_respondes_with_the_correct_response_as_bellow(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
			Assert.assertEquals(examples.get("response"), service.executeGetRequest(host + examples.get("question")));
			helper.wait(200);
		}
	}

}
