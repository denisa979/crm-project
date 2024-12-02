Feature: Logout functionality.
  User Story:
     As a user, I should be able to logout.
  @wip
  Scenario Outline:  Verify that user can log out from the app after clicking "Log out" button.
    When user logs in as "<userType>"
    And user clicks profile dropdown
    And user clicks "Log out" option from profile options
    Then user should be able to see "Authorization" as page title
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify that the <userType> user can see 5 options under the profile name.
    When user logs in as "<userType>"
    And user clicks profile dropdown
    Then user should be able to see 5 options under the profile name:
      |My Profile|
      |Edit Profile Settings|
      |Themes|
      |Configure notifications|
      |Log out|

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |