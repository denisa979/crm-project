Feature:Access to profile page.
  User Story:
     As a user I should be able to access my profile page.

  Scenario Outline: Verify that the <userType> user can view the following options on My Profile page
    When user logs in as "<userType>"
    And user clicks profile dropdown
    And user clicks "My Profile" option from profile options
    Then user should be able to see the following options on My Profile page like "General, Drive, Tasks, Calendar, Conversations"
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |




  Scenario Outline: Verify that the email which is  <username> under the General tab is the same as the user’s account.
    When user logged in with username as "<username>" and password as "<password>"
    And user clicks profile dropdown
    And user clicks "My Profile" option from profile options
    Then user should be able to see the email "<username>" under the General tab is the same as the user’s account.
    Examples:
      | username              | password |
      | hr1@cydeo.com         | UserUser |
      | helpdesk1@cydeo.com   | UserUser |
      | marketing94@cydeo.com | UserUser |