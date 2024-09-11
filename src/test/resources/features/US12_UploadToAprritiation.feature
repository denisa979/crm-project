Feature: Upload functionalities in Appreciation page.
  User Story:
         As a user, I should be able to upload files and pictures to appreciation.
  Scenario Outline: Verify that the <userType> can upload <fileType>.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "More" in activity stream
    And user clicks "Appreciation" under more in activity stream
    And user enter a message "Appreciation"
    And user clicks Upload area with exact id "bx-b-uploadfile-blogPostForm"
    And user upload the files "<fileType>"
    Then user should be able to see "<fileType>" in the uploaded files
    Examples:
      | userType  | fileType      |
      | hr        | TestDocx.docx |
    #  | hr        | TestJpeg.jpg  |
    # | hr        | TestPdf.pdf   |
    # | hr        | TestPng.png   |
    # | hr        | TestTxt.txt   |
    # | helpdesk  | TestDocx.docx |
    # | helpdesk  | TestJpeg.jpg  |
    # | helpdesk  | TestPdf.pdf   |
    # | helpdesk  | TestPng.png   |
    # | helpdesk  | TestTxt.txt   |
    # | marketing | TestDocx.docx |
    # | marketing | TestJpeg.jpg  |
    # | marketing | TestPdf.pdf   |
    # | marketing | TestPng.png   |
    # | marketing | TestTxt.txt   |


  Scenario Outline: Verify that the <userType> can insert the <fileType>into the text.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "More" in activity stream
    And user clicks "Appreciation" under more in activity stream
    And user enter a message "Appreciation"
    And user clicks Upload area with exact id "bx-b-uploadfile-blogPostForm"
    And user upload the files "<fileType>"
    And user clicks Insert text with exact class "insert-btn"
    Then user should be able to see "<fileType>" in the message
    Examples:
      | userType  | fileType      |
   #   | hr        | TestDocx.docx |
   #   | hr        | TestJpeg.jpg  |
   #   | hr        | TestPdf.pdf   |
   #   | hr        | TestPng.png   |
   #   | hr        | TestTxt.txt   |
   #   | helpdesk  | TestDocx.docx |
   #   | helpdesk  | TestJpeg.jpg  |
   #   | helpdesk  | TestPdf.pdf   |
   #   | helpdesk  | TestPng.png   |
   #   | helpdesk  | TestTxt.txt   |
   #   | marketing | TestDocx.docx |
   #   | marketing | TestJpeg.jpg  |
   #   | marketing | TestPdf.pdf   |
   #   | marketing | TestPng.png   |
      | marketing | TestTxt.txt   |



  Scenario Outline: Verify that the <userType> can remove <fileType> at any time before sending.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "More" in activity stream
    And user clicks "Appreciation" under more in activity stream
    And user enter a message "Appreciation"
    And user clicks Upload area with exact id "bx-b-uploadfile-blogPostForm"
    And user upload the files "<fileType>"
    And user clicks Delete Icon with exact class "del-but"
    Then user should not be able to see "<fileType>" in the uploaded files
    Examples:
      | userType  | fileType      |
 #   | hr        | TestDocx.docx |
 #   | hr        | TestJpeg.jpg  |
 #   | hr        | TestPdf.pdf   |
 #   | hr        | TestPng.png   |
 #   | hr        | TestTxt.txt   |
      | helpdesk  | TestDocx.docx |
 #     | helpdesk  | TestJpeg.jpg  |
 #     | helpdesk  | TestPdf.pdf   |
 #     | helpdesk  | TestPng.png   |
 #     | helpdesk  | TestTxt.txt   |
 #     | marketing | TestDocx.docx |
 #     | marketing | TestJpeg.jpg  |
 #     | marketing | TestPdf.pdf   |
 #     | marketing | TestPng.png   |
 #     | marketing | TestTxt.txt   |