@chatfilter
Feature: Web live chat filter
  As a PO
  I want to go to message page
  So that verify filter in message

  Scenario: WLC_016_FBFilter Filter icon_User Account
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    And Hover on filter button
    Then Verify filter icon
    When Click on filter button
    Then Verify filter form for messages
    And Click on filter collapse link
    Then Verify close filter

  Scenario: WLC_017_FBFilter Check support dropdown list by manager account in a team
    Given Go to Mobio login page
    And Login by "Member" account
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on "Tin nhắn" tab and get the list
    And Logout from Mobio site
    And Login by "Admin" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on filter button
    And Select "Specific Member" data support dropdown
    Then Verify user name "Specific Member" in support dropdown list after chose one item
    And Click on the Apply button
    Then Verify comments of team member
    When Click one comment
    Then Verify the feature of selected wlc

  Scenario: WLC_018_FBFilter Check support dropdown list_Share view
    Given Go to Mobio site by "Member in Team" account
    And Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Select "ManagerTeam" Team that you want to config
    And Click on "Thành viên trong Team" config type to assign in a team
    And Select "Specific member in other Team" other member in the "UserTeam" Team that "Specific member in Team" member want to view
    And Click on "MXH được phụ trách" config type to assign in a team
    And Get pages list of Team in "Web live chat" social network
    And Back to default screen
    And Back to the Content
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on filter button
    And Click on list of social page dropdown
    Then Verify list of social page of team member

  Scenario: WLC_018_1_FBFilter Check support dropdown list by manager account in a team
    Given Go to Mobio site by "Member in other Team" account
    And Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Select "UserTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific member in other Team" rule
    And Back to default screen
    And Back to the Content
    When Go to "wlc0004" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    When Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab and get the list
    And Logout from Mobio site
    And Login by "Member in Team" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on filter button
    And Select "Specific member in other Team" data support dropdown
    And Click on the Apply button
    Then Verify comments of team member
    When Click one wlc item
    Then Verify the feature of selected wlc of member in another team

  Scenario: WLC_019_FBFilter Check support dropdown list by user account in a team
    Given Go to Mobio site by "Member in other Team" account
    And Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Select "UserTeam" Team that you want to config
    And Click on "Thành viên trong Team" config type to assign in a team
    And Select "Specific member in other Team" other member in the "UserTeam" Team that "Specific user other Team" member want to view
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific member in other Team" rule
    And Back to default screen
    And Back to the Content
    When Go to "wlc0005" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on "Tin nhắn" tab and get the list
    And Logout from Mobio site
    And Login by "User other Team" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on filter button
    And Select "Specific member in other Team" data support dropdown
    And Click on the Apply button
    Then Verify comments of team member
    And Click one wlc item
    Then Verify the feature of selected wlc of member in another team

  Scenario: WLC_020_FBFilter Check support dropdown list by normal user_Khong share view
    Given Go to Mobio site by "Member in other Team" account
    And Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Select "UserTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "MXH được phụ trách" config type to assign in a team
    And Get pages list of Team in "Web live chat" social network
    And Back to default screen
    And Back to the Content
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on filter button
    And Click on list of social page dropdown
    Then Verify list of social page of team member

  #Cấu hình rule phân công tin nhắn trong team

  Scenario: TC_01_Config Support Assignment in a Team_Only assign to online member
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

  Scenario: WLC_021_FBFilter_Finish a message
    Given Go to Mobio site by "Admin" account
    And Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click one wlc item
    And Click on Done button for Message
    And Click on filter button
    And Check on finished checkbox
    And Click on the Apply button
    Then Verify the list of the finished item

  Scenario: WLC_22_FBFilter_Answer and UnAnswer messages
    Given Go to Mobio site by "Admin" account
    And Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on filter button
    And Check on the unanswered checkbox
    And Click on the Apply button
    Then Verify list of social
    And Click one wlc item
    And Reply ones
    And Click on filter button
    And Check on the answered checkbox
    And Click on the Apply button
    Then Verify list of social
  
  Scenario: WLC_023_WLCFilter find messages_tag
    Given Go to Mobio site by "Admin" account
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on filter button
    And Check on the unanswered checkbox
    And Click on the Apply button
    And Click one wlc item
    And Add tag "Need to reply" into an item
    And Click one wlc item
    And Add tag "Check new tag" into an item
    And Click one wlc item
    And Add tag "MSB bank" into an item
    And Click on filter button
    And Select some tag names
    And Click on the Apply button
    Then Verify list of social

  Scenario: WLC_024_WLCFilter find messages_tag
    Given Go to Mobio site by "Admin" account
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    Then Verify the order of the list items

  Scenario: WLC_025_FBFilter find comments_Sorting
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on filter button
    And Check on the unanswered checkbox
    And Click on the Apply button
    Then Verify the list of items after sorting

  Scenario: WLC_026_FBFilter find comments_Comment number of a page
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    Then Verify the comment number of one page

  Scenario: WLC_027_FBFilter find comments_Search profile
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on Search box
    Then Verify list of profile in Search box

  Scenario: WLC_028_WLCFilter find a message content
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Select the search content kind
    And Send content to search
    Then Verify content of searching

  Scenario: WLC_029_WLCFilter find a message content in column2
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Sort in order from new to old
    And Click on the top item
    And Click on search icon at clolumn2
    And Send valid content to search at clolumn2
    Then Verify content of searching at column2
    And Send invalid content to search at clolumn2
    Then Verify invalid content of searching at column2

  Scenario: WLC_032_FBFilter Pin comment_Assign pin task
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on Pin icon of message
    And Assign pin task to "Specific Member" user
    And Logout from Mobio site
    And Login by "Member" account
    Given Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    Then Verify new task in the list of contents

  Scenario: WLC_033_FBFilter Verify position of the item
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click one wlc item
    And Click to reply an item
    Then Verify position of the wlc item

  Scenario: WLC_034_WLCFilter Check status active
    Given Go to Mobio site by "Admin" account
    And Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Switch to Mobio site
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on the top item
    Then Verify icon active status is dispplayed
    And Close the second browser
    Then Verify icon active status is undisplayed

  # Need to show all info of the access web

  Scenario: WLC_035_WLCFilter Check info access web
    Given Go to Mobio site by "Admin" account
    And Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Switch to Mobio site
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on the top item
    And Hold top message
    Then Verify infor access web is displayed column1
    And Click infor access web button
    Then Verify infor access web is displayed column2
    And Close the second browser
