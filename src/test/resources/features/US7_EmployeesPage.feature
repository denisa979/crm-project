Feature: Access the Employee page.
  User Story:
          As a user, I should be able to access Employees page.

  Scenario Outline: Verify that the <userType> views the following 8 modules in the Employees page.
    When user logs in as "<userType>"
    And user clicks "Employees"
    Then user should be able to see following 8 modules in the Employees page
      | Company Structure   |
      | Find Employee          |
      | Telephone Directory |
      | Staff Changes           |
      | Efficiency Report      |
      | Honored Employees |
      | Birthdays                  |
      | New page                 |

    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify that the <userType> views the <pageTitle> as default by clicking the Employees Module.
    When user logs in as "<userType>"
    And user clicks "Employees"
    Then user should be able to see "<pageTitle>" Employees page
    Examples:
      | userType  | pageTitle                  |
      | hr              | Company Structure |
      | helpdesk  | Company Structure  |
      | marketing | Company Structure |