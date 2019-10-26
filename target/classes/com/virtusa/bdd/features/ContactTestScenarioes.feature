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
@contacttest
Feature: Validating Contacts Form in CRMPRO Application
  
Background: User is logged in CRMPRO application with valid credentials  
             Given user hit the application URL in the browser
             When user enters valid user credentials
             Then user should be in Home Page successfully

Scenario: Enter data in Contacts Form page in with existing company details
    Given that user hovers Contacts Tab in Home
    And click on New Contacts link under Contacts Tab
    When user enters data in the mandatory fields in new contact page by company lookup
    |Mr.|Sri|Murugan|BMC Software|Internet|Google Talk|14-Oct-1982|ECT - Central European Time|Germany|
    Then details should be saved successfully
    
Scenario: Enter data in Contacts Form page in with new company details
    Given that user hovers Contacts Tab in Home
    And click on New Contacts link under Contacts Tab
    When user enters data in the mandatory fields in new contact page
    |Mr.|Sri|Shanmukha|Delloitte.|Internet|Google Talk|14-Oct-1982|IST - India Standard Time|India|
    Then details should be saved successfully
    
Scenario Outline: Enter data in Contacts Form with existing company details
    Given that user hovers Contacts Tab in Home
    And click on New Contacts link under Contacts Tab
    When user enters details "<Title>","<First_Name>","<SurName>","<Company_Name>","<Source>","<Messenger>","<Birthdate>","<Time Zone>","<Country>" by company lookup
    Then details should be saved successfully

    Examples: 
      | Title  | First_Name | SurName  |Company_Name|Source|Messenger|Birthdate|Time Zone|Country|
      | Mr. |     Skandha | Konduru | TechM|Email|AOL Messenger|10-Nov-2010|ECT - Central European Time|Germany|
      | Mr. |     Ishaan | Konduru    |Microsoft|Ad|Google Talk|24-May-2011|ECT - Central European Time|Germany|
      
Scenario Outline: Enter data in Contacts Form with new company details
    Given that user hovers Contacts Tab in Home
    And click on New Contacts link under Contacts Tab
    When user enters details "<Title>","<First_Name>","<SurName>","<Company_Name>","<Source>","<Messenger>","<Birthdate>","<Time Zone>","<Country>"
    Then details should be saved successfully      
  
  Examples:   
      | Title  | First_Name | SurName  |Company_Name|Source|Messenger|Birthdate|Time Zone|Country|
      | Mrs.| Sandhya| Shivashankar| Google|Internet|Google Talk|15-Nov-1985|IST - India Standard Time|India|
      |Mr.|Shivashankar|Konduru|Virtusa|Email|AOL Messenger|11-Mar-1983|IST - India Standard Time|India|