@LearnNextResponseMultiBrowser
Feature: LearnNextResponse does not work in some 
				browsers possibly due to cache

	
@LearnNextResponseMultiBrowser111
  Scenario: LearnNextResponse in Chrome
    Given that the mimicService is running
    When I open the url "learnNextResponse?text=2" in Chrome
    And I enter the request "1+1" "2" times
    Then "2" is displayed
    And the browser is closed
    
@LearnNextResponseMultiBrowser112
  Scenario: LearnNextResponse in FireFox
    Given that the mimicService is running
    When I open the url "learnNextResponse?text=2" in FireFox
    And I enter the request "1+1" "2" times
    Then "2" is displayed
    And the browser is closed
    
@LearnNextResponseMultiBrowser113
  Scenario: LearnNextResponse in Edge
    Given that the mimicService is running
    When I open the url "learnNextResponse?text=2" in Edge
    And I enter the request "1+1" "2" times
    Then "2" is displayed
    And the browser is closed
    
    
    
  