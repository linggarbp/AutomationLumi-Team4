Feature: Register

  Scenario: Register with valid credentials
    Given User is on register page
    And User input email with "dxa0727@gmail.com"
    And User input password with "password123"
    When User click on next button
    Then User is on validation page
    And User input otp
    And User input identity card
    And User click on next button
    And User is on pin page
    And User input pin mumber
    When User is click next button
    And User validation biometrics security
    Then User is on login page