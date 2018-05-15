@ResponseForm
Feature: The GUI response form stores requests and automatically
				 recognises mime type of request
	

@ResponseForm111 
  Scenario: Store a request with response form
  Given that the mimicService is running
  When I open the browser with the request "2+2"
  And I input "4" in the response form and press the Learn button
  And I enter the request "2+2"
  Then "4" is displayed
  And the browser is closed
  

@ResponseForm112 
  Scenario Outline: Store mime type response with response form
    Given that the mimicService is running
    When I open the browser with the request <request>
    And I input <response> in the response form
    And I press the learn button
    And the browser is closed
    Then the request <request> has the mime type <mimeType>

    Examples: 
      |   request      |                    response    			  			     |      mimeType       |
      |   "TEXT"       |                  "TextMime"   								  	 | "application/text;" |
      |   "JSON"       |       "{ /'name/':/'John/', /'age/':30 }"         | "application/json;" |
      |   "XML"        |         "<note><to>Test</to></note>"              | "application/xml;"  |
      |   "HTML"       |         "<html> Det här är HTML </html>"          | "application/html;" |