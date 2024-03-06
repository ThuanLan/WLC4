@chatsocket3
Feature: Web live chat Socket3
  As a PO
  I want to go to message page
  So that verify message screen with the socket

  # Kiểm tra tin nhắn phân công đúng người
  Scenario: WLC_036_Socket Check assignment_one message
    Given Go to Mobio site by "Member" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific Member" rule
    And Back to default screen
    And Back to the Content
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    And Click on the top item
    Then Verify the task assignment message wlc

  #Tin nhắn dạng text Kiểm tra hiển thị tin nhắn
  Scenario: WLC_037_Socket Check assignment_Text message
    Given Go to Mobio site by "Admin" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific Admin" rule
    And Back to default screen
    And Back to the Content
    When Go to "wlc0003" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    And Click on the top item
    Then Verify the task assignment message wlc

  Scenario: TC_01_Config Support Assignment in a Team_Only assign to online member
    Given Go to Mobio site by "Admin" account
    And Close all windows without parent
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select only assign to online member

  Scenario Outline: WLC_038_FBSocket Check displaying of the post with image content_ERR image content_34571
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0003" web live chat site on other browser
    And Create "<VideoAndImage>" message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    When Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    And Click on the top item
    Then Verify wlc text and file in the post
    And Click on the picture in the wlc
    Then Verify the posted image after clicking to zoom out
    And Close dialog

    Examples: 
      | VideoAndImage |
      | dreamCar.jpg  |

  Scenario Outline: WLC_039_FBSocket Check displaying of the post with a gif file
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0003" web live chat site on other browser
    And Create "<VideoAndImage>" message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    When Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    And Click on the top item
    Then Verify wlc text and file in the post
    And Click on the picture in the wlc
    Then Verify the posted gif after clicking to zoom out
    And Close dialog

    Examples: 
      | VideoAndImage |
      | thankyou.gif  |

  # 40,41 sua xong dong lai
  #Scenario Outline: WLC_040_FBSocket Check displaying of the post with video item
  #Given Go to Mobio site by "Admin" account
  #When Go to "wlc0003" web live chat site on other browser
  #And Create "<VideoAndImage>" message by wlc on other browser
  #And Close the second browser
  #And Switch to Mobio site
  #When Go to the Social chat screen
  #When Click on wlc icon
  #And Click on the message tab
  #And Click on the top item
  #Then Verify wlc text and file in the post
  #And Click on the picture in the wlc
  #Then Verify the posted video after clicking to zoom out
  #And Close dialog
  #
  #Examples:
  #| VideoAndImage |
  #| videoTest.mp4 |
  #@chat3
  #Scenario Outline: WLC_041_FBSocket Check displaying of the post with mp3 file content
  #Given Go to Mobio site by "Admin" account
  #When Go to "wlc0003" web live chat site on other browser
  #And Create "<VideoAndImage>" message by wlc on other browser
  #And Close the second browser
  #And Switch to Mobio site
  #When Go to the Social chat screen
  #When Click on wlc icon
  #And Click on the message tab
  #And Click on the top item
  #Then Verify the posted file
  #
  #Examples:
  #| VideoAndImage |
  #| mp3test.mp3   |
  Scenario: WLC_042_FBSocket Check displaying of the post with link content
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0003" web live chat site on other browser
    And Create "https://vnexpress.net/" text by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    When Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    And Click on the top item
    Then Verify the task assignment message wlc
    Then Verify redirection of the link task wlc
    And Switch to new tab
    And Switch to Mobio site
    And Close all windows without parent

  Scenario Outline: WLC_044_FBSocket Check displaying of the post with a file
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0003" web live chat site on other browser
    And Create "<VideoAndImage>" message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    When Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    And Click on the top item
    Then Verify the posted file

    Examples: 
      | VideoAndImage     |
      | checkfileuat.docx |
@46
  Scenario: WLC_046_Wlc Reply comment and view by member in team
    Given Go to Mobio site by "Admin" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific Member" rule
    And Back to default screen
    And Back to the Content
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on filter button
    And Select "Specific Member" data support dropdown
    And Click on the Apply button
    When Go to "wlc0003" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Click on the top item
    Then Verify item jumps to list and column2

  Scenario: WLC_047_Wlc Reply comment and view by member in other team
    Given Go to Mobio site by "User other Team" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific Member" rule
    And Back to default screen
    And Back to the Content
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on filter button
    And Select "Specific Member" data support dropdown
    And Click on the Apply button
    When Go to "wlc0003" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Click on the top item
    Then Verify disable wlc in list and column2

  Scenario: WLC_048_Wlc Reply comment and view by member in team
    Given Go to Mobio site by "Admin" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific Member" rule
    And Back to default screen
    And Back to the Content
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on filter button
    And Select "Specific Member" data support dropdown
    When Click on the Apply button
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Click on the top item
    Then Verify item jumps to list and column2

  Scenario: WLC_049_Wlc comment_reply one by customer
    Given Go to Mobio site by "Member" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific Member" rule
    And Back to default screen
    And Back to the Content
    And Go to "wlc0002" web live chat site
    And Create message by wlc
    And Switch to Mobio site
    And Close all windows without parent
    And Go to the Social chat screen
    And Click on wlc icon
    And Go to Mobio login page
    And Login by "Admin" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on filter button
    And Select "Specific Member" data support dropdown
    And Click on the Apply button
    And Click old wlc message
    When Open Mobio on second driver
    And Login by "Member" account on other browser
    And Go to the Social chat screen on other browser
    And Click on wlc icon on other browser
    And Click old wlc message on other browser
    And Reply one message on other browser
    And Close the second browser
    And Go to web live chat site
    And Create message by wlc
    And Switch to Mobio site
    And Close all windows without parent
    When Open Mobio on second driver
    And Login by "Member" account on other browser
    And Go to the Social chat screen on other browser
    And Click on wlc icon on other browser
    And Click old wlc message on other browser
    And Reply one message on other browser
    And Close the second browser
    Then Verify the replied item by team member then view it by the customer

  Scenario: TC_01_Config Support Assignment in a Team_Only assign to online member
    Given Go to Mobio site by "Admin" account
    And Close all windows without parent
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select only assign to online member
  
