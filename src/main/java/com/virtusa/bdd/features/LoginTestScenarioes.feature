@logintest
Feature: Login Page credentials validation

  
  Scenario: Login with valid user credentials
    Given user is on CRMPRO application login page
    When user enters valid username,password
    Then Home Page should be displayed

  
  Scenario Outline: Login with invalid user credentials
    Given user is on CRMPRO application login page
    When User enters "<username>" and "<password>"
    Then user should re-direct to login page again

    Examples:
    | username   | password |
    | testuser_1 | Test@153 |
    | testuser_2 | Test@153 |
  
  Scenario: Login with user credentials via Data Table
    Given user is on CRMPRO application login page
    When user enters username,password
    |satya|pass123|
    Then user should be re-directed to login page again