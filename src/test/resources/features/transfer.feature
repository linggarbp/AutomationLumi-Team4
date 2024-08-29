Feature: Transfer

  Background: Login with valid email and password
    Given User is on login page
    And User input email with "dxa0727@gmail.com"
    And User input password with "password123"
    When User click on login button
    Then User is on home page

  Scenario: Transfer successfull
    Given User is on transfer page
    And User input destination account
    And User input nominal
    And User input description
    When User click next button
    Then User is on pin page
    When User input pin number
    Then Transfer success

  Scenario: Transfer unsuccessfull pin
    Given User is on transfer page
    And User input destination account
    And User input nominal
    And User input description
    When User click next button
    Then User is on pin page
    When User input pin number
    Then Error pin message is showing up