Feature: QRIS

  Background: Login with valid email and password
    Given User is on login page
    And User input email with "dxa0727@gmail.com"
    And User input password with "password123"
    When User click on login button
    Then User is on home page

    Scenario: Using QRIS payment
      Given User is on home page
      When User click on qris button
      Then User is on qris page