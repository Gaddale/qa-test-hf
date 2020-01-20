@ParallelTestingWithCucumber
Feature: Existing customer should be able to login

  Scenario: Able to login with existing customer
    Given user is on authentication page
    When user logs in with valid username "automation1982@gmail.com" and password
    Then user should land on my account page with username "Sachin Tendulkar" as header
    And logout link is displayed for the user