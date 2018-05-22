@GuiLearnNextResponseFeature
Feature: LearnNextResponse adds states/responses to a request

#New test case sprint 6      
@GuiLearnNextResponse111
  Scenario: LearnNextResponse without paramaters 
  					presents the response form
  Given that the mimicService is running
  And I open the browser with the request "LearnNextResponse"
  And I input "4" in the response form and press the Learn button
  And I enter the request "2+2"
  Then "2+2" respondes with "4"
  
@GuiLearnNextResponse112
  Scenario: LearnNextResponse in Chrome
    Given that the mimicService is running
    When I open the url "learnNextResponse?text=2" in Chrome
    And I enter the request "1+1" "2" times
    Then "2" is displayed
    And the browser is closed
    
@GuiLearnNextResponse113
  Scenario: LearnNextResponse in FireFox
    Given that the mimicService is running
    When I open the url "learnNextResponse?text=2" in FireFox
    And I enter the request "1+1" "2" times
    Then "2" is displayed
    And the browser is closed
    
@GuiLearnNextResponse114
  Scenario: LearnNextResponse in Edge
    Given that the mimicService is running
    When I open the url "learnNextResponse?text=2" in Edge
    And I enter the request "1+1" "2" times
    Then "2" is displayed
    And the browser is closed