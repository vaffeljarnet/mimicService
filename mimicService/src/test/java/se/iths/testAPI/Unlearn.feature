@Unlearn
Feature: Unlearn removes the current and the following states of the latest request

#Refractored from CurrentState111
@Unlearn111
  Scenario: Unlearn removes the current and following states
    Given that the mimicService is running
    And that no requests are stored
		When I teach the mock the below sequense
	    |  question   |    response   |
      |    1+1      |       2       |
      |    1+1      |       3       |
      |    1+1      |       4       |
      |    1+1      |       5       |
	  And I call resetState
	  And I make the request "1+1"
		And I make the request "1+1"
		And I make the request "1+1"
		And I call unlearn
		And I make the request "1+1"
	  Then "1+1" respondes with "3"

 #Refractored from CurrentState112   
 @Unlearn112     
   Scenario: Unlearn question with one state
    Given  that the mimicService is running
    And that the mock has learned "1+1" with "2"
    When I call unlearn
    Then "1+1" returns the response form 
      
  #Refractored from TestMimicService113    
  @Unlearn113
  Scenario: Unlearn does not affect other stored responses
  Given that the mimicService is running
  When I teach the mock that "1+1" has response "2"
  And I teach the mock that "2+2" has response "4"
  And I teach the mock that "3+3" has response "6"
  And I make the request "2+2"
  And I call unlearn
  Then "2+2" returns the response form
  And "1+1" respondes with "2"
  And "3+3" respondes with "6"
  
  #Refractored from TestMimicGUI113   
  @Unlearn114
  Scenario: Unlearn removes response from last stored request
  					without the need to make that request again					
  Given that the mimicService is running
  When I teach the mock that "1+1" has response "2+2"
  And I call unlearn
  Then "1+1" returns the response form
  
  