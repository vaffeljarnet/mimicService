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

    
@ViewRequests111
  Scenario: With multiple requests stored all are visible in ViewRequests
    Given that the mimicService is running
    When I open the browser with the request "start"
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
