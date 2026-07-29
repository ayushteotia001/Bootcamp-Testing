Feature: Add Product to Cart

  Scenario: Add Backpack to Cart

    Given User is logged into SauceDemo
    When User clicks on Add to Cart button
    Then Product should be added to the cart