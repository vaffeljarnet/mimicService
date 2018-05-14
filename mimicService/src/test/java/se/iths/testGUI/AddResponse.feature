@AddResponse
Feature: Add response adds states to a request

@AddResponse111
  Scenario: addResponse adds states to request
    Given that the mimicService is running
    When I open the url "1+1"
    And I input "2" in the response form
    And I press the learn button
    And I make the request "1+1"
    And I open the relearnResponse URL
    And I input "3" in the response form
    And I press the learn button
    And I close the browser
    And I call resetState
    Then "1+1" respondes with "2"