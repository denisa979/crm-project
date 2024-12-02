
Feature: Login functionalities.
  User Story:
    As I user, I should be able to login.


  Background:User is already on the login page

    Given user is on the login page
  @wip
    Scenario Outline: Verify that user can log in with valid credentials and land on the home page.
      When user logs in as "<userType>"
      Then user should be able to see "Portal" as page title
      Examples:
        | userType  |
        | hr        |
        | helpdesk  |
        | marketing |

      Scenario Outline: Verify that "Incorrect login or password" error message is displayed for invalid credentials.
        When user log in with incorrect username as "<username>" and password as "<password>"
        Then user should see error message "Incorrect username or password"
        Examples:
          | username                   | password |
          | hr1@cybertekschool.com     |invalid   |
          | invalid@cybertekschool.com | UserUser |
          | invalid@cybertekschool.com | invalid  |

        Scenario: Verify that the "Remember me on this computer"  link exists
          Then user should be able to see remember me box

  Scenario: Verify that the "Remember me on this computer"  is clickable
    When user clicks Remember me checkbox
    Then user should be able to see "Remember me" checkbox clicked

  Scenario: Verify that the password is in bullet signs by default.
    Then user should be able to see password is in bullet signs by default

