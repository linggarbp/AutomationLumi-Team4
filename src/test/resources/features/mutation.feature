Feature: Mutation

  Background: Login with valid email and password
    Given User is on login page
    And User input email with "dxa0727@gmail.com"
    And User input password with "password123"
    When User click on login button
    Then User is on home page

  Scenario: Mutation with all data transaction
    Given User is on mutation page
    And User click on dropdown transaction list
    And User click on all option
    When User click on find mutation button
    Then All transaction is showing up

  Scenario: Mutation with income transaction
    Given User is on mutation page
    And User click on dropdown transaction list
    And User click on income option
    When User click on find mutation button
    Then Income transaction is showing up

  Scenario: Mutation with outcome transaction
    Given User is on mutation page
    And User click on dropdown transaction list
    And User click on outcome option
    When User click on find mutation button
    Then Outcome transaction is showing up

  Scenario: Mutation with valid startdate and enddate
    Given User is on mutation page
    And User click input startdate
    And User click input enddate true
    When User click on find mutation button
    Then All transaction between startdate and enddate is showing up


  Scenario: Mutation with invalid startdate or/and enddate
    Given User is on mutation page
    And User click input startdate
    And User click input enddate false
    When User click on find mutation button
    Then Error mutation message is showing up