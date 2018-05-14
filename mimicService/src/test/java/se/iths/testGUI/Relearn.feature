#This feature need to be refractored and split in two. One for the new relearnResponse, and one for addResponse
@Relearn
Feature: Relearn function with web interface

  @Relearn111
  Scenario Outline: Correct wrong response with web interface
    Given that the mimicService is running
    And that no requests are stored
    When I open the url <question>
    And I input <wrongResponse> in the response form
    And I press the learn button
    And I open the url <question>
    And I open the relearnResponse URL
    And I input <correctResponse> in the response form
    And I press the learn button
    And I close the browser
    Then <question> respondes with <correctResponse>

    Examples: 
      |  question   | wrongResponse | correctResponse  |
      |   "1+1"     |     "1"       |       "2"        |
   
   @Relearn112
   Scenario: Relearn edits the last requested state in a sequense
    Given that the mimicService is running
    And the mock has learned the below sequense
    	|question|response|
    	|  ABC	 |	 A    |
    	|  ABC	 |	 D    |
    	|  ABC	 |	 C    |
    When I call resetState
    And I open the url "ABC"
    And I enter the url "localhost:8080/ABC"
    And I enter the url "localhost:8080/relearn"
    And I input "B" in the response form
    And I press the learn button
    And I enter the url "localhost:8080/resetState"
    And I enter the url "localhost:8080/ABC"
    And I enter the url "localhost:8080/ABC"
    And I close the browser
    Then "ABC" respondes with "B"
    
    
      