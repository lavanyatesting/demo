Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario: Login as a authenticated user
    Given user is  on loginpage
    When user navigates to Login Page
    And user enters username and Password
    And user is on profile page
    Then user edits the company details to update the profile
    
