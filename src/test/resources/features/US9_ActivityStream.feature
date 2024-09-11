Feature: Options on the Activity Stream page.
  User Story:
          As a user, I should be able to see all the options on the Activity Stream page.

  Scenario Outline: Verify that <userType> views the following options on the Activity Stream page.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    Then user should be able to see the following options on the Activity Stream page
      | MESSAGE |
      | TASK       |
      | EVENT     |
      | POLL       |
      | MORE      |

    Examples:
      | userType  |
      | hr              |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify that <userType> views the following 4 options under the MORE tab
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "More" in activity stream
    Then user should be able to see the following options under more tab on the Activity Stream page
      | File                   |
      | Appreciation    |
      | Announcement|
      | Workflow          |
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |