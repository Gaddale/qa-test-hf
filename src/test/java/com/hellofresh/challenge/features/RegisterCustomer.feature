Feature: As a user I should be able to register on My store

  Scenario: Generated customer with all customer data
    Given user is on authentication page
    When user sign in with valid email address
    And user enters all the mandatory fields and register
    Then user should land on my account page with proper username as header
    And logout link is displayed for the user