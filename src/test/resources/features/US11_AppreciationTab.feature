Feature: Functionality of Appreciation tab.
  User Story:
        As a user, I should be to send appreciation by clicking on Appreciation tab in the
  Activity Stream.

  Scenario Outline: Verify that the user can send an appreciation by filling in the mandatory fields.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "More" in activity stream
    And user clicks "Appreciation" under more in activity stream
    And user enter a message "Appreciation"
    And user clicks Send button with part of id "blog-submit-button-save"
    Then user should be able to see message which is sent
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify that the user can send an appreciation by filling in the mandatory fields.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "More" in activity stream
    And user clicks "Appreciation" under more in activity stream
    And user clicks Send button with part of id "blog-submit-button-save"
    Then user should be able to see message as "The message title is not specified"
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify that the user can send an appreciation by filling in the mandatory fields.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "More" in activity stream
    And user clicks "Appreciation" under more in activity stream
    And user clicks All employees with exact class "feed-add-post-del-but"
    And user clicks Send Button with exact id "blog-submit-button-save"
    Then user should be able to see message as "Please specify at least one person."
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify the delivery is 'All employees' by default.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "More" in activity stream
    And user clicks "Appreciation" under more in activity stream
    And user clicks Send Button with exact id "blog-submit-button-save"
    Then user should be able to see the message delivery is to "All employees" by default

    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify that the user can cancel sending appreciation at any time before sending.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "More" in activity stream
    And user clicks "Appreciation" under more in activity stream
    And user enter a message "Appreciation"
    And user clicks Cancel button with part of id "blog-submit-button-cancel"
    Then user should be able to see Send Message area with class name "feed-add-post-micro-title"
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |