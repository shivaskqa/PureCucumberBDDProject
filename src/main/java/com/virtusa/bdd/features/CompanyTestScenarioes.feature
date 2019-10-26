#Author: shivaskqa@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@companytest
Feature: Validating Companies Page in CRMPRO Application

Background: User is logged in CRMPRO application with valid credentials
            Given user launches the application
            When user enters valid credentials
            Then user should be successfully logged in
        
  
  Scenario: Enter data in Companies form in the respective fields via Data Table
    Given User is in HomePage and hover on Company Tab
    And click on New company link
    When User enters the details
    |sanath|BFSI|Active|Client|High|
    And click on Save button in new Company form
    Then company details should be saved successfully

  
  Scenario Outline: Enter data in Companies page in the respective fields via outline
    Given User is in HomePage and hover on Company Tab
    And click on New company link
    When User enters "<companyname>","<industry>","<status>","<category>","<priority>"
    And click on Save button in new Company form
    Then company details should be saved successfully

    Examples: 
      | companyname  | industry | status  | category| priority | 
      | futuristic |  IT | New | Partner | High| 
      | medinovas |     Health | On Hold    | | |
      |SBI|Banking|New|Client|Medium|
