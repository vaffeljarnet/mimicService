@MachineLearningFeature
Feature: As a Tester I would like the mock to learn how to respond 
				to requests that I have not defined so that I do not 
        have to create code for that manually (only add, mult, sub and div)
@MachineLearning111
  Scenario Outline: Learn how to calculate add, sub, mult and div with one digit values
    Given that the mimicService is running
    When I teach the mock that <questionOne> has response <responseOne>
    And I teach the mock that <questionTwo> has response <responseTwo>
    Then <notKnownQuestion> respondes with <notKnownResponse>
    
    Examples:
    	|       questionOne       | responseOne |       questionTwo          | responseTwo |     notKnownQuestion       | notKnownResponse |
 			| "add?value1=1&value2=1" |    "2"      |   "add?value1=1&value2=2"  |     "3"     |  "add?value1=1&value2=3"   |       "4"        |
 			|"sub?value1=5&value2=1"  |    "4"      |   "sub?value1=5&value2=2"  |     "3"     |  "sub?value1=5&value2=3"   |       "2"        |
 			|"mult?value1=3&value2=2" |    "6"      |  "mult?value1=3&value2=3"  |     "9"     |  "mult?value1=3&value2=4"  |       "12"       |
 			|"div?value1=4&value2=2"  |    "2"      |  "div?value1=60&value2=20" |     "3"     |  "div?value1=8&value2=4"   |       "2"        |
 			
@MachineLearning112
  Scenario Outline: Learn how to calculate when teaching with values
  									ending with the same digit.
    Given that the mimicService is running
    When I teach the mock that <questionOne> has response <responseOne>
    And I teach the mock that <questionTwo> has response <responseTwo>
    Then <notKnownQuestion> respondes with <notKnownResponse>
    
    Examples:
    	|       questionOne         | responseOne  |       questionTwo            | responseTwo  |     notKnownQuestion       | notKnownResponse |
 			|"add?value1=10&value2=20"  |    "30"      | "add?value1=20&value2=20"    |     "40"     |  "add?value1=1&value2=2"   |       "3"        |
 			|"add?value1=15&value2=15"  |    "30"      | "add?value1=25&value2=25"    |     "50"     |  "add?value1=1&value2=1"   |       "2"        |
 			|"add?value1=26&value2=16"  |    "42"      | "add?value1=36&value2=46"    |     "82"     |  "add?value1=1&value2=1"   |       "2"        |
 			|"add?value1=111&value2=111"|    "222"     | "add?value1=222&value2=222"  |     "444"    |  "add?value1=1&value2=1"   |       "2"        |
 	
 	
@MachineLearning113
	Scenario: Calling with format "/text?param"
		Given that the mimicService is running
	  When I make the request "test?ett"
	  Then "test?ett" returns the response form 
	  
@MachineLearning114
  Scenario: Learn how to calculate add while alternating with mult
    Given that the mimicService is running
    When I teach the mock that "add?value1=1&value2=2" has response "3" 
    And I teach the mock that "mult?value1=3&value2=2" has response "6"
    And I teach the mock that "add?value1=1&value2=1" has response "2"
    Then "add?value1=1&value2=3" respondes with "4"
    
@MachineLearning115
  Scenario: UnlearnAllResponses removes all learned formats
    Given that the mimicService is running
    And that the mock has learned "add?value1=1&value2=2" with "3" 
    And that the mock has learned "add?value1=1&value2=1" with "2"
    And "add?value1=1&value2=3" respondes with "4"
    When I write unlearnAllResponses in url
		Then "add?value1=1&value2=3" returns the response form
		
@AutoLearn116
  Scenario: Terminating Mimic does not remove learned formats
    Given that the mimicService is running
    And that the mock has learned "add?value1=1&value2=2" with "3" 
    And that the mock has learned "add?value1=1&value2=1" with "2"
    And "add?value1=1&value2=3" respondes with "4"
    When I terminate the mimicService
    And I start mimicService
		Then "add?value1=1&value2=3" respondes with "4"
			
@MachineLearning117
  Scenario: Mimic can learn how to respond with complex responses 
    Given that the mimicService is running
    And that the mock has learned "montlyCost?TotalCost=10000&Months=10" with "{ 'TotalCost': 10000,'MontlyCost': 1000,'Months': 10;}" 
    And that the mock has learned "montlyCost?TotalCost=20000&Months=10" with "{ 'TotalCost': 20000,'MontlyCost': 2000,'Months': 10;}" 
		Then "montlyCost?TotalCost=30000&Months=10" respondes with "{ 'TotalCost': 30000,'MontlyCost': 3000,'Months': 10;}"
		
@MachineLearning118
	Scenario Outline: Teaching Mimic wrong does not produce empty responses
	Given that the mimicService is running
	When I teach the mock that <questionOne> has response <responseOne>
  And I teach the mock that <questionTwo> has response <responseTwo>
  Then <notKnownQuestion> does not return an empty response
    
    Examples:
    	|       questionOne         | responseOne  |       questionTwo            | responseTwo  |     notKnownQuestion       |
 			|"add?value1=10&value2=20"  |    "15"      | "add?value1=20&value2=20"    |     "30"     |  "add?value1=1&value2=2"   |
		
@MachineLearning119
	Scenario: Correcting does not produce empty responses
	Given that the mimicService is running
	When I teach the mock that "add?value1=10&value2=20" has response "15"
  And I teach the mock that "add?value1=20&value2=20" has response "30"
  And "add?value1=1&value2=2" does not responde with "3"
  And I teach the mock that "add?value1=1&value2=2" has response "3"
  Then "add?value1=2&value2=2" does not return an empty response
    
 