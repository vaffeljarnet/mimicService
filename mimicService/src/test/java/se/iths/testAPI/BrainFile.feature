@BrainFileFeature
Feature: Request are stored in the Brain file when terminating mimicService

@StoreInBrainFile111
  Scenario Outline: Store one request and make same request after reboot
    Given that the mimicService is running
    And that no requests are stored
    When I teach the mock that <question> has response <response>
    And I terminate the mimicService
    And I start mimicService
    Then <question> respondes with <response>

    Examples: 
      |  question   |    response   | 
      |   "1+1"     |      "1"      |
      
@StoreInBrainFile112
  Scenario: Store multiple requests and make same requests after reboot
    Given that the mimicService is running
    And that no requests are stored
    When I teach the mock the below questions and responses
      |  question   |    response   |
      |   "2+2"     |      "4"      |
      |   "3+3"     |      "6"      |
      |   "4+4"     |      "8"      |
    And I terminate the mimicService
    And I start mimicService
    Then every question below respondes with corresponding response
      |  question   |    response   |
      |   "2+2"     |      "4"      |
      |   "3+3"     |      "6"      |
      |   "4+4"     |      "8"      |

    
    
