Feature: Login

  Scenario: Login with valid username and password
    Given User is on login page
    And User input email with "dxa0727@gmail.com"
    And User input password with "password123"
    When User click on login button
    Then User is on home page

  Scenario: Login with invalid password
    Given User is on login page
    And User input username with "dxa0727@gmail.com"
    And User input password with "password1234"
    When User click on login button
    Then Error message is showing up