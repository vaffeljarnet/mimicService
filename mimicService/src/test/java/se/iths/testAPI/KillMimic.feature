@KillMimic
Feature: KillMimic terminates the service

@KillMimic111
  Scenario: KillMimic terminates the service
    Given that the mimicService is running
    When I terminate the mimicService
    Then "1+1" respondes with "Error"
