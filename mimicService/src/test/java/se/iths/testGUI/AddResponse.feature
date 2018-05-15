@AddResponse
Feature: Add response adds states to a request

@AddResponse111
  Scenario: addResponse adds states to request
    Given that the mimicService is running
    When I open the browser with the request "numbers"
    And I input "1" in the response form and press the Learn button
    And I enter the request "1+1"
    And I make an /addResponse request
    And I input "2" in the response form
    And I press the learn button
    And I make a /resetState request
    And I enter the request "1+1"
    Then "2" is displayed
    And the browser is closed
    
@AddResponse112
  Scenario: addResponse works after relearning a state in the middle of a sequense
    Given that the mimicService is running
    When I open the browser with the request "numbers"
    And I input "1" in the response form and press the Learn button
    And I add the states below to the request "numbers"
    |state|
    |  4  |
    |  3  |
    And I make a /resetState request
    And I enter the request "numbers" "2" times
    And I make a /relearnResponse request
    And I input "2" in the response form and press the Learn button
    And I make an /addResponse request
    And I input "4" in the response form 
    And I enter the request "numbers"
    Then "2" is displayed
    And the browser is closed
    
@AddResponse112
  Scenario: addResponse adds state to the end of a request when the current 
  					state is the first in the sequense
    Given that the mimicService is running
    When I open the browser with the request "numbers"
    And I input "1" in the response form and press the Learn button
    And I add the states below to the request "numbers"
    |state|
    |  2  |
    |  3  |
    And I make a /resetState request
    And I make an /addResponse request
    And I input "4" in the response form and press the Learn button
    And I enter the request "numbers" "4" times
    Then "4" is displayed
    And the browser is closed
    
    