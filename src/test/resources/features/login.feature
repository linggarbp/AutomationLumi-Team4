Feature: Login

  Scenario: Login with valid email and password
    Given User is on login page
    And User input email with "dxa0727@gmail.com"
    And User input password with "password123"
    When User click on login button
    Then User is on home page

  Scenario: Login with invalid email
    Given User is on login page
    And User input email with "dxa072727@gmail.com"
    And User input password with "password123"
    When User click on login button
    Then Error login message is showing up

  Scenario: Login with invalid password
    Given User is on login page
    And User input email with "dxa0727@gmail.com"
    And User input password with "password12345"
    When User click on login button
    Then Error login message is showing up