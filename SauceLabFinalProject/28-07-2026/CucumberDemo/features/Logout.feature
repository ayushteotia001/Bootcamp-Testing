Feature: Logout from SauceDemo

  Scenario: Logout Successfully

    Given User is logged into the application
    When User clicks on the menu button
    And User clicks on Logout
    Then User should be redirected to Login Page