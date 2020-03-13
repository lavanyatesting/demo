Feature: Login Feature
  Verify if user is able to register in to the site

  Scenario: Registering the company
    Given user is  on homepage
    When user navigates to registration Page
    And user enters details for registration
    Then user creates the account
    
