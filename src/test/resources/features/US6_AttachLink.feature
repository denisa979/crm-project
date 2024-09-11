Feature: Attach link in the message field.
  User Story:
          As a user, I should be able to add link in message.

  Scenario Outline: Verify that the <userType> can attach a link to the specified text.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Message" in activity stream
    And user enter a message "Test"
    And user clicks Link Button with exact id "bx-b-link-blogPostForm"
    And user types "Google" As Text with exact id "linkidPostFormLHE_blogPostForm-text"
    And user types "http://www.google.com" As Text with exact id "linkidPostFormLHE_blogPostForm-href"
    And user clicks Save Button with exact class "adm-btn-save"
    Then user should be able to see "Google" in the message
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |



  Scenario Outline: Verify that by clicking on the link the <userType> can navigate to the correct URL.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Message" in activity stream
    And user enter a message "Test"
    And user clicks Link Button with exact id "bx-b-link-blogPostForm"
    And user types "Google" As Text with exact id "linkidPostFormLHE_blogPostForm-text"
    And user types "http://www.google.com" As Text with exact id "linkidPostFormLHE_blogPostForm-href"
    And user clicks Save Button with exact class "adm-btn-save"
    And user clicks Send button with part of id "blog-submit-button-save"
    And user clicks first link in the messages
    And user switches to next page with "Google"
    Then user should be able to see "Google" as page title
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |



  Scenario Outline: Verify that the link is opened in a new tab.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Message" in activity stream
    And user enter a message "Test"
    And user clicks Link Button with exact id "bx-b-link-blogPostForm"
    And user types "Google" As Text with exact id "linkidPostFormLHE_blogPostForm-text"
    And user types "http://www.google.com" As Text with exact id "linkidPostFormLHE_blogPostForm-href"
    And user clicks Save Button with exact class "adm-btn-save"
    And user clicks Send button with part of id "blog-submit-button-save"
    And user clicks first link in the messages
    Then user should be able to see more than one window
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |
