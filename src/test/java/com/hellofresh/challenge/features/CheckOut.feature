Feature: Customer should be able to add items to cart and check order details

  Scenario: Verify Checkout functionality
    Given user is on authentication page
    When user logs in with valid username "automation1982@gmail.com" and password
    And user selects the product "Faded Short Sleeve T-shirts" and add to card
    And user proceeds to checkout by agreeing terms of service and confirms the order
    Then user should land on order confirmation page with order complete status

