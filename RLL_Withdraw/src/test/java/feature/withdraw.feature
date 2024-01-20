
@tag
Feature: Login page

  Background:
    Given User navigates to the URL
    When User performs the login process
    
    
  Scenario: user perform withdraw Test
    Given User clicks on withdraw link
    Then select DropDown button and test
    And check RestButton 
    Then check withdraw with no value in input
    Then check withdraw with '0' amount 
    Then check withdraw with exceed bank amount
    And give valid amount and deposite
    
    
    
    
   
      
    
   