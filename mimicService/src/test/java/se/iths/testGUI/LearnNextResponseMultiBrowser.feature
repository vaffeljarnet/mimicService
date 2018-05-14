@LearnNextResponseMultiBrowser
Feature: LearnNextResponse does not work in some 
				browsers possibly due to cache

	
  @LearnNextResponseMultiBrowser111
  Scenario: LearnNextResponse in Chrome
    Given that the mimicService is running
    When I open the url "learnNextResponse?text=2" in Chrome
    And I enter the url "http://localhost:8080/1+1"
    And I close the browser
    Then "1+1" respondes with "2"
    
  @LearnNextResponseMultiBrowser112
  Scenario: LearnNextResponse in FireFox
    Given that the mimicService is running
    When I open the url "learnNextResponse?text=2" in FireFox
    And I enter the url "http://localhost:8080/1+1"
    And I close the browser
    Then "1+1" respondes with "2"
    
  @LearnNextResponseMultiBrowser113
  Scenario: LearnNextResponse in Edge
    Given that the mimicService is running
    When I open the url "learnNextResponse?text=2" in Edge
    And I enter the url "http://localhost:8080/1+1"
    And I close the browser
    Then "1+1" respondes with "2"
    
    
    
  