Feature: Access to Company page.
  User Story:
       As a user, I should be able to access Company page.
  Scenario Outline:Verify that the <userType> can see the following 8 modules on the Company page.
    When user logs in as "<userType>"
    And user clicks "Company"
    Then user should be able to see following 8 modules in the Company page
      | Official Information |
      | Our Life                   |
      | About Company      |
      | Photo Gallery           |
      | Video                       |
      | Career                      |
      | Business News (RSS)|
      | More                        |

    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |