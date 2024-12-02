Feature: Functions on Company Structure under Employee menu.
  User Story:
         As a user, I should be able to use functions on Company Structure
  under Employee menu.

  Scenario Outline: Verify that the Company Structure is visible for all <userType> users.
    When user logs in as "<userType>"
    And user clicks "Employees"
    Then user should be able to see "<pageTitle>" Employees page
    Examples:
      | userType  | pageTitle                 |
      | hr              | Company Structure |
      | helpdesk  | Company Structure |
      | marketing | Company Structure |



  Scenario: Verify that the HR user can add a department from the Company Structure.
    When user logs in as "hr"
    And user clicks "Employees"
    And user add department with name "Department"
    Then user should see created department


  Scenario Outline: Verify that the “ADD DEPARTMENT” button is not displayed for Helpdesk and Marketing users..
    When user logs in as "<userType>"
    And user clicks "Employees"
    Then user should not see ADD DEPARTMENT button

    Examples:
      | userType  |
      | helpdesk  |
      | marketing |