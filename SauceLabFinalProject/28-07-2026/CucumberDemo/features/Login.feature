Feature: SauceDemo Login

  Scenario: Login with valid credentials
    Given User is on SauceDemo Login Page
    When User enters valid username and password
    And User clicks on Login button
    Then User should be redirected to Inventory Page
