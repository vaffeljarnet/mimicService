@LearnNextResponse
Feature: LearnNextResponse adds states to a request        
 
@LearnNextResponse111
  Scenario: LearnNextResponse adds a response to a request
  Given that the mimicService is running
  When I teach the mock that "1+1" has response "2"
  Then "1+1" respondes with "2" 
  
@LearnNextResponse112
   Scenario Outline: Set new state for request with LearnNextResponse
    Given that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    When I teach the mock that <questionOne> has response <responseTwo>
    When I teach the mock that <questionOne> has response <responseThree>
    Then <questionOne> respondes with <responseThree>

    Examples:
      | questionOne| responseOne | responseTwo |responseThree| 
      | "1+1"      |     "2"     | "4"         |   "6"       |
      
@LearnNextResponse113
	Scenario: Store sequense with LearnNextResponse and check that all 
					  states are stored after reset
	  Given that the mimicService is running
	  And that no requests are stored
	  When I teach the mock the below sequense
	    |  question   |    response   |
      |    1+1      |       2       |
      |    1+1      |       3       |
      |    1+1      |       4       |
      |    1+1      |       5       |
	  And I call resetState
	  Then every step in the stored sequense respondes with the stored response as below
	    |  question   |    response   |
      |    1+1      |       2       |
      |    1+1      |       3       |
      |    1+1      |       4       |
      |    1+1      |       5       |
