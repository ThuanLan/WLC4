@chatsocket1
Feature: WLC Message Socket
  As a PO
  I want to login to application
  So that verify Web live chat page

  Scenario: TC_02_Config Support Assignment in a Team_Only assign to online member
    Given Go to Mobio site by "Admin" account
    And Close all windows without parent
    When Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select only assign to online member
    And Back to default screen
    And Back to the Content
    And Go to Mobio login page
    And Login by "Admin" account

  Scenario Outline: TC01_Config for assignee group and prioritied page
    Given Go to Mobio site by "Admin" account
    And Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Click on "Phân công giữa các Team" rule to config
    And Select "<WLCSite>" page name in "Web live chat" social
    And Select priority radio button to handle mesages in "ManagerTeam" team
    And Back to default screen
    And Back to the Content
    And Go to Mobio login page
    And Login by "Admin" account

    Examples: 
      | WLCSite |
      | wlc0002 |
      | wlc0003 |

  Scenario: WLC_050_Wlc unanswered comment_reply one with text
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Click one unanswer wlc item
    And Reply one message
    Then Verify the content of a replied item

  Scenario: WLC_051_Wlc unanswered comment_reply one by Copy/Paste text
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0003" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Click one unanswer wlc item
    And Copy and paste text to reply
    Then Verify the content of a replied item

  Scenario: WLC_053_54_Wlc unanswered comment_reply one with text
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0001" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click one wlc item
    And Click one unanswer wlc item
    And Click on Quick reply button
    And Select a "Thank you a lot!" quick reply Message
    Then Verify the content of a quick replied wlc message

  Scenario: WLC_055_Wlc unanswered comment_reply one with text
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0001" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click one wlc item
    And Click on Quick reply button
    And Select a "Thank you a lot!" quick reply Message
    And Click on Quick reply button
    And Select a "Welcome to the Mobio website" quick reply Message
    Then Verify the content of a quick replied wlc message

  Scenario: WLC_56 Open new window_drag and drop
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0001" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Sort in order from new to old
    And Click on filter button
    And Check on the unanswered checkbox
    And Click on the Apply button
    And Click one unanswer wlc item
    And Click on Quick reply button
    And Drag and drop an item "Thank you a lot!" to quick reply

  Scenario Outline: WLC_058_Wlc Reply comment and view by member in team
    Given Go to Mobio site by "Member" account
    When Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on filter button
    And Select "Specific Member" data support dropdown
    And Click on the Apply button
    And Click old wlc message
    And Open Mobio on second driver
    And Login by "Member" account on other browser
    And Go to the Social chat screen on other browser
    And Click on wlc icon on other browser
    And Click old wlc message on other browser
    And Reply one message on other browser
    And Close the second browser
    Then Verify the content of a replied item by "Member" team member

    Examples: 
      | WLCSite |
      | wlc0003 |

  Scenario Outline: WLC_059_Wlc Reply message by member of other team
    Given Go to Mobio site by "Member" account
    And Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Sort in order from new to old
    And Go to Mobio login page
    And Login by "Other Member" account
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
    Then Verify the content of a replied item by "Member" in another team member
    And Refresh the page
    And Switch to the main frame
    And Click on wlc icon
    And Click on filter button
    And Select "Specific Member" data support dropdown
    And Click on the Apply button
    And Click old item that replied
    Then Verify the content of a replied item by "Member" team member

    Examples: 
      | WLCSite |
      | wlc0003 |

  Scenario: WLC_060_Wlc
    Given Go to Mobio site by "Member" account
    And Go to "wlc0001" web live chat site
    When Create message by wlc
    And Switch to Mobio site
    And Close all windows without parent
    And Go to the Social chat screen
    And Click on wlc icon
    And Go to Mobio login page
    And Login by "Other Member" account
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
    And Click on wlc form
    And Switch to Mobio site
    And Close all windows without parent
    Then Verify the replied item by another team member then view it by the customer

  Scenario: WLC_061_Wlc comment_reply one by customer
    Given Go to Mobio site by "Member" account
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
    And Click on wlc form
    And Switch to Mobio site
    And Close all windows without parent
    Then Verify the replied item by team member then view it by the customer

  Scenario: WLC_062_Wlc comment_reply one by customer
    Given Go to Mobio site by "Member" account
    And Go to "wlc0002" web live chat site
    And Create message by wlc
    And Switch to Mobio site
    And Close all windows without parent
    When Go to the Social chat screen
    And Click on wlc icon
    And Click old wlc message
    And Reply one message
    And Go to web live chat site
    And Click on wlc form
    And Switch to Mobio site
    And Close all windows without parent
    Then Verify the replied item by team member then view it by the customer

  Scenario: WLC_063_Socket Forward comment
    Given Go to Mobio site by "Member in Team" account
    And Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Team" screen from menu
    And Hover on "ManagerTeam" team and get members
    And Back to default screen
    And Back to the Content
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on filter button
    And Select "AllMember" data support dropdown
    And Click on the Apply button
    And Click one wlc item
    And Click on Forward wlc button
    Then Verify recipient group dropdown default
    And Click on recipient group dropdown
    Then Verify recipient group dropdown
    And Click on recipient dropdown
    Then Verify recipient dropdown
    And Close dialog

  Scenario: WLC_064_Socket Forward comment to team2
    Given Go to Mobio site by "Admin" account
    And Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    When Go to the Social chat screen
    And Click on wlc icon
    And Click one wlc item
    And Click on Forward wlc button
    And Select "UserTeam" value in recipient group dropdown
    Then Verify recipient drop down after selecting the second team
    And Click on "Chuyển tiếp" button
    Then Verify disable wlc in list

  Scenario: WLC_065_Socket Forward comment
    Given Go to Mobio site by "Member in Team" account
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on filter button
    And Select "AllMember" data support dropdown
    And Click on the Apply button
    And Click one wlc item
    And Click on Forward wlc button
    And Select "Specific Member" to assign task
    And Add tag "Tag new" in forwarded comment
    Then Verify forwarded wlc with the "Tag new" tag and "Member" assignee

  Scenario Outline: WLC_066_Socket Filter other team_forward an item
    Given Go to Mobio site by "Member" account
    And Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Go to Mobio login page
    When Login by "Other Member" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on filter button
    And Select "Specific Member" data support dropdown
    And Click on the Apply button
    And Click old wlc message
    And Open Mobio on second driver
    And Login by "Member" account on other browser
    And Go to the Social chat screen on other browser
    And Click on wlc icon on other browser
    And Click old wlc message on other browser
    And Click on Forward wlc button on other browser
    And Select "Specific Admin" to assign task on other browser
    And Click on "Chuyển tiếp" button on other browser
    And Close the second browser
    And Verify item jumps to list and column2

    Examples: 
      | WLCSite |
      | wlc0002 |

  Scenario: WLC_067_Socket Filter other team_thuannt6 received an item
    Given Go to Mobio site by "Member" account
    And Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Go to Mobio login page
    And Login by "Other Member" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on filter button
    And Select "Specific Member" data support dropdown
    And Click on the Apply button
    And Click one wlc item
    When Open Mobio on second driver
    And Login by "Member" account on other browser
    And Go to the Social chat screen on other browser
    And Click on wlc icon on other browser
    And Click one wlc item on other browser
    And Click on Forward wlc button on other browser
    And Select "Specific Admin" to assign task on other browser
    And Click on "Chuyển tiếp" button on other browser
    And Close the second browser
    Then Verify wlc list of team member after receiving an item

  Scenario: WLC_068_Socket Forward comment in the team
    Given Go to Mobio site by "Member" account
    And Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Go to Mobio login page
    And Login by "Member in Team" account
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on filter button
    And Select "Specific Member" data support dropdown
    And Click on the Apply button
    And Click one wlc item
    And Click on Forward wlc button
    And Select "Specific Admin" to assign task
    And Click on "Chuyển tiếp" button
    Then Verify disable wlc in list

  Scenario: WLC_069_Socket Not read_admin received a comment
    Given Go to Mobio site by "Admin" account
    And Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Go to Mobio login page
    And Login by "Member in Team" account
    And Go to the Social chat screen
    And Click on wlc icon
    When Open Mobio on second driver
    And Login by "Admin" account on other browser
    And Go to the Social chat screen on other browser
    And Click on wlc icon on other browser
    And Click old wlc message on other browser
    And Click on Forward wlc button on other browser
    And Select "Specific member in Team" to assign task on other browser
    And Click on "Chuyển tiếp" button on other browser
    And Close the second browser
    And Click on the top item
    Then Verify item jumps to list and column2
    Then Verify wlc list of team member
