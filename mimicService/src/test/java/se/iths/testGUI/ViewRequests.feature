@ViewRequests
Feature: Stored requests are visible in the overview returned by /viewRequests
@ViewRequests111
  Scenario: With one request stored it is visible in ViewRequests
    Given that the mimicService is running
    When I open the browser with the request "numbers"
    And I input "1" in the response form and press the Learn button
    And I make a /viewRequests request
    Then "numbers" is present in the overview
    And the browser is closed

    
@ViewRequests112
  Scenario: With multiple requests stored all are visible in ViewRequests
    Given that the mimicService is running
    When I open the browser
    And I teach Mimic the below requests and responses
    | request | response |
    |   I			| 	drink  |
    |  your   | milkshake|		
		And I make a /viewRequests request
		Then all requests below are present in the overview
		| request |
    |   I			| 
    |  your   |
    And the browser is closed
        
 @ViewRequests113
  Scenario: Open view requests with no responses stored
    Given that the mimicService is running
    And that no requests are stored
    When I open the browser
    And I make a /viewRequests request
    Then "No requests" is displayed
    And the browser is closed