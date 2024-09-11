Feature: Accessing Drive page.
  User Story:
        As a user, I should be able to access Drive page.
  Scenario Outline:Verify that the <userType> can see the following 7 modules on the Drive page.
    When user logs in as "<userType>"
    And user clicks "Drive"
    Then user should be able to see following 7 modules in the Drive page
      | My Drive                                    |
      | All Documents                          |
      | Company Drive                         |
      | Sales and Marketing                 |
      | Top Management's documents |
      | Drive Cleanup                            |
      | More                                           |

    Examples:
      | userType  |
      | hr              |
      | helpdesk  |
      | marketing |
