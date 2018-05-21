@GUILearnNextResponse
Feature: LearnNextResponse adds states/responses to a request

#New test case sprint 6      
@GUILearnNextResponse111
  Scenario: LearnNextResponse without paramaters 
  					presents the response form
  Given that the mimicService is running
  And I open the browser with the request "LearnNextResponse"
  And I input "4" in the response form and press the Learn button
  And I enter the request "2+2"
  Then "2+2" respondes with "4"