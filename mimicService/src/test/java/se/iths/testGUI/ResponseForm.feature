@ResponseForm
Feature: The GUI response form stores requests and automatically
				 recognises mime type of request
	
	#Refractored from TestMimicGUI111learnReqResp
  @ResponseForm111 
  Scenario: Store a request with response form
  Given that the mimicService is running
  When I open the url "2+2"
  And I input "4" in the response form
  And I press the learn button
  And I close the browser
  Then "2+2" respondes with "4"
  
  #Refractored from MimeTypeRec111
  @ResponseForm112 
  Scenario Outline: Store mime type response with response form
    Given that the mimicService is running
    When I open the url <question>
    And I input <response> in the response form
    And I press the learn button
    And I close the browser
    Then the request <question> has the mime type <mimeType>

    Examples: 
      |    question    |                    response    			  			     |      mimeType       |
      |   "TEXT"       |                  "TextMime"   								  	 | "application/text;" |
      |   "JSON"       |       "{ /'name/':/'John/', /'age/':30 }"         | "application/json;" |
      |   "XML"        |         "<note><to>Test</to></note>"              | "application/xml;"  |
      |   "HTML"       |   "<!DOCTYPE html><html><body></body></html>"     | "application/html;" |