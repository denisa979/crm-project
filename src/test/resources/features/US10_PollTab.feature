Feature: Creating Poll tab in the Activity Stream.
  User Story:
          As a user, I should be able to create a poll by clicking on Poll tab in the Activity Stream.
  Scenario Outline: Verify that the delivery is 'All employees' by default.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Poll" in activity stream
    Then user should be able to see the message delivery is to "All employees" by default

    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |




  Scenario Outline: Verify that the user can create a poll by adding questions and multiple answers.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Poll" in activity stream
    And user enter a message "Poll"
    And user types "Question 1" As Text with exact id "question_0"
    And user types "Answer 1" As Text with exact id "answer_0__0_"
    And user types "Answer 2" As Text with exact id "answer_0__1_"
    And user clicks Send Button with exact id "blog-submit-button-save"
    Then user should be able to see poll which is sent
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify that the user can select the “Allow multiple choice” checkbox.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Poll" in activity stream
    And user clicks Checkbox button with exact class "vote-checkbox"
    And user should be able to see Allow multiple checkbox clicked
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |



  Scenario Outline: Verify the corresponding error messages for the mandatory fields.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Poll" in activity stream
    And user clicks Send Button with exact id "blog-submit-button-save"
    Then user should be able to see message as "The message title is not specified"
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |

  Scenario Outline: Verify the corresponding error messages for the mandatory fields.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Poll" in activity stream
    And user clicks All employees with exact class "feed-add-post-del-but"
    And user clicks Send Button with exact id "blog-submit-button-save"
    Then user should be able to see message as "Please specify at least one person."
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |




  Scenario Outline: Verify the corresponding error messages for the mandatory fields.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Poll" in activity stream
    And user enter a message "Poll"
    And user types "Answer 1" As Text with exact id "answer_0__0_"
    And user types "Answer 2" As Text with exact id "answer_0__1_"
    And user clicks Send Button with exact id "blog-submit-button-save"
    Then user should be able to see message as "The question text is not specified."
    Examples:
      | userType  |
      | hr             |
      | helpdesk  |
      | marketing |



  Scenario Outline: Verify the corresponding error messages for the mandatory fields.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Poll" in activity stream
    And user enter a message "Poll"
    And user types "Question 1" As Text with exact id "question_0"
    And user clicks Send Button with exact id "blog-submit-button-save"
    Then user should be able to see message as "The question \"Question 1\" has no answers."
    Examples:
      | userType  |
      | hr        |

