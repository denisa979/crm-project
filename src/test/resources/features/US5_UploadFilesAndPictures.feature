Feature: Upload functionality.
  User Story:
          As a user, I should be able to upload files and pictures as messages.

  Scenario Outline: Verify that the user can send a message by filling in the mandatory fields.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Message" in activity stream
    And user enter a message "Test"
    And user clicks Send button with part of id "blog-submit-button-save"
    Then user should be able to see message which is sent
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |



  Scenario Outline: Verify that the user can not send a message without filling title.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Message" in activity stream
    And user clicks Send button with part of id "blog-submit-button-save"
    Then user should be able to see message as "The message title is not specified"
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |



  Scenario Outline: Verify that the user can not send a message without filling message delivery.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Message" in activity stream
    And user clicks All employees with exact class "feed-add-post-del-but"
    And user clicks Send button with part of id "blog-submit-button-save"
    Then user should be able to see message as "Please specify at least one person."
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify that the message delivery is to 'All employees' by default.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Message" in activity stream
    Then user should be able to see the message delivery is to "All employees" by default
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify that the user can cancel sending the message at any time before sending.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Message" in activity stream
    And user enter a message "Test"
    And user clicks Cancel button with part of id "blog-submit-button-cancel"
    Then user should be able to see Send Message area with class name "feed-add-post-micro-title"
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |
