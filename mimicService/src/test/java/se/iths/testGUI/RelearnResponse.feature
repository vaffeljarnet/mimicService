#This feature need to be refractored and split in two. One for the new relearnResponse, and one for addResponse
@RelearnResponse
Feature: Relearn function with web interface

@RelearnResponse111
  Scenario Outline: Correct wrong response with web interface
    Given that the mimicService is running
    When I open the browser with the request <request>
    And I input <wrongResponse> in the response form and press the Learn button
    And I enter the request <request>
    And I make a /relearnResponse request
    And I input <correctResponse> in the response form and press the Learn button
    And I enter the request <request>
    Then "2" is displayed
    And the browser is closed

    Examples: 
      |  request   | wrongResponse | correctResponse  |
      |   "1+1"    |     "1"       |       "2"        |
   
 @RelearnResponse112
   Scenario: Relearn edits the last requested state in a sequense
    Given that the mimicService is running
    And the mock has learned the below sequense
    	|question|response|
    	|  ABC	 |	 A    |
    	|  ABC	 |	 D    |
    	|  ABC	 |	 C    |
    When I call resetState
    And I open the browser with the request "ABC"
    And I enter the request "ABC"
    And I make a /relearnResponse request
    And I input "B" in the response form
    And I press the learn button
    And I make a /resetState request
    And I enter the request "ABC" "2" times
    Then "B" is displayed
    And the browser is closed
    