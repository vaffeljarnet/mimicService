package se.iths.testSourceCode;

import static org.junit.Assert.*;


import org.junit.Test;

import se.iths.mimicService.RequestResponse;

public class TestRequestResponse {

	@Test
	public void TestRequestResponse111CreateObjectSetGet() {
		RequestResponse reqRes = new RequestResponse("1+1","2");
		assertEquals("1+1",reqRes.getRequest());
		assertEquals("2",reqRes.getResponse());
		
		reqRes.setRequest("1+2");
		reqRes.setResponse("3");
		assertEquals("1+2", reqRes.getRequest());
		assertEquals("3", reqRes.getResponse());		
	}

}
