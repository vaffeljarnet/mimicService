@GuiUnlearnResponse
Feature: Using UnlearnResponse in the GUI

@GuiUnlearnResponse114
  Scenario: Calling the same request when at end of a sequense
  					does not affect unlearnResopnse				
  Given that the mimicService is running
  When I open the browser
  And I add the states below to the request "numbers"
    |state|
    |  1  |
    |  2  |
    |  3  |
  And I make a /resetState request
  And I enter the request "numbers" "4" times
  And I make an /unlearnResponse request
  And I enter the request "numbers" 
	Then "2" is displayed
	And the browser is closed