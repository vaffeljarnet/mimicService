@LearnNextResponseFeature
Feature: LearnNextResponse adds states/responses to a request        
 
#Replaced 112 with 113 test case
 
@LearnNextResponse111
  Scenario: LearnNextResponse adds a response to a request
  Given that the mimicService is running
  When I teach the mock that "1+1" has response "2"
  Then "1+1" respondes with "2" 
      
@LearnNextResponse112
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

#New test case sprint 6      
@LearnNextResponse113
  Scenario Outline: You can store requests with forward slash sign
  Given that the mimicService is running
  When I teach the mock that <request> has response <response>
  Then <request> respondes with <response>
  
  Examples:
  |   request   |  response  |
  | "test/test" |   "test"   |
  | "te/te/te"  |   "test"   |
  

