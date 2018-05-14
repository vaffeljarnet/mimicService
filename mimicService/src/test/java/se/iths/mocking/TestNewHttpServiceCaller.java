package se.iths.mocking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import se.iths.helpers.HttpServiceCaller;
import se.iths.helpers.MimicJarHelper;

public class TestNewHttpServiceCaller {

	private HttpServiceCaller service = new HttpServiceCaller();
	private String host = "http://localhost:8080/";
	private MimicJarHelper helper = new MimicJarHelper();

	/**
	 * Test that new HttpServiceCaller can make get request 
	 * and that text mime type is stored in Mimic
	 */
	@Test
	public void TestNewHttpServiceCaller111testTextMime() {
		if(helper.jarIsRunning()) {
			service.executeGetRequest(host+"learnNextResponse?text=TestTextMime&mime=application/text");
			service.executeGetRequest(host+"TEXT");
			assertEquals("TestTextMime", service.executeGetRequest(host+"TEXT"));
			assertTrue(service.getMimeType(host+"TEXT").contains("application/text;"));
		}else {
			fail(helper.errorString());
		}
	}

	/**
	 * Test that new HttpServiceCaller can make get request 
	 * and that HTML mime type is stored in Mimic
	 */
	@Test
	public void TestNewHttpServiceCaller112testHtmlMime() {
		if(helper.jarIsRunning()) {
			service.executeGetRequest(host+"learnNextResponse?text=TestHtmlMime&mime=application/html");
			service.executeGetRequest(host+"HTML");
			assertEquals("TestHtmlMime", service.executeGetRequest(host+"HTML"));
			assertTrue(service.getMimeType(host+"HTML").contains("application/html;"));
		}else {
			fail(helper.errorString());
		}
	}

	/**
	 * Test that new HttpServiceCaller can make get request 
	 * and that JSON mime type is stored in Mimic
	 */
	@Test
	public void TestNewHttpServiceCaller113testJsonMime() {
		if(helper.jarIsRunning()) {
			service.executeGetRequest(host+"learnNextResponse?text=testJsonMime&mime=application/json");
			service.executeGetRequest(host+"JSON");
			assertEquals("testJsonMime", service.executeGetRequest(host+"JSON"));
			assertTrue(service.getMimeType(host+"JSON").contains("application/json;"));
		}else {
			fail(helper.errorString());
		}
	}

	/**
	 * Test that new HttpServiceCaller can make get request 
	 * and that XML mime type is stored in Mimic
	 */
	@Test
	public void TestNewHttpServiceCaller114testXmlMime() {
		if(helper.jarIsRunning()) {
			service.executeGetRequest(host+"learnNextResponse?text=testXmlMime&mime=application/xml");
			service.executeGetRequest(host+"XML");
			assertEquals("testXmlMime", service.executeGetRequest(host+"XML"));
			assertTrue(service.getMimeType(host+"XML").contains("application/xml;"));
		}else {
			fail(helper.errorString());
		}
	}

}

