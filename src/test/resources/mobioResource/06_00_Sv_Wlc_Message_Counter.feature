@chatcounter
Feature: Web Live Chat Counter
  As a PO
  I want to go to weblivechat page
  So that verifies the message counter of the screen

  Scenario: TC02_FBCounter_Set counter on the job processing screen
    Given Go to Mobio site by "Admin" account
    And Click on Setting button
    And Click on "Cài đặt cá nhân" settings
    And Go to "Kiểu hiển thị" screen from menu
    When Click on the Social link in the setting screen
    And Click on the Edit button on the job processing page
    And Click on Show unanswered count radio
    And Click on the Save button
    And Back to default screen
    And Back to the Content
    And Logout from Mobio site
    And Login by "Admin" account

  #Cấu hình rule phân công bình luận trong team
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

    Examples: 
      | WLCSite |
      | wlc0002 |
      | wlc0003 |

  #Cấu hình view page ở Tổng quan của tài khoản
  
  Scenario Outline: TC_02_Config Display Content on the Dashboard
    Given Go to Mobio site by "Admin" account
    When Go to "Tổng quan" screen from "Online & mạng xã hội" menu in "Services" menu
    And Click on "Thêm nội dung hiển thị" button
    And Search "<WLCSite>" page name in Fanpage Wlc
    And Close all list of displayed social item
    And Select "Tin nhắn" on fanpage
    And Click on "Lưu" button
    Then Verify "<WLCSite>" is displayed

    Examples: 
      | WLCSite |
      | wlc0002 |

  Scenario: WLC_001_WLCCounter unanswered message_message one
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    Then Verify item count is increased by one

  Scenario: WLC_002_1_WLCCounter unanswered message_received one mesage
    Given Go to Mobio site by "Member" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab
    And Go to Mobio site by "Admin" account
    And Go to "wlc0003 " web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the top item
    And Click on Forward wlc button
    And Select "Specific Member" to assign task
    And Click on "Chuyển tiếp" button
    And Go to Mobio site by "Member" account
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    Then Verify item count is increased by one

  Scenario: WLC_002_1_WLCCounter unanswered message_received one mesage
    Given Go to Mobio site by "Member" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab
    And Go to Mobio site by "Admin" account
    When Go to "wlc0003 " web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the top item
    And Reply ones
    And Click on Forward wlc button
    And Select "Specific Member" to assign task
    And Click on "Chuyển tiếp" button
    And Go to Mobio site by "Member" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    Then Verify item count is unchanged

  Scenario: WLC_003_1_WLCCounter unanswered message_forward one replied message
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on the top item
    And Reply ones
    And Click on "Tin nhắn" tab
    And Click on Forward wlc button
    And Select "Specific Member" to assign task
    And Click on "Chuyển tiếp" button
    Then Verify item count is unchanged

  Scenario: WLC_003_2_WLCCounter unanswered message_forward one unreplied message
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0003" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    And Click on wlc icon
    And Click on "Tin nhắn" tab
    And Click on filter button
    And Check on the unanswered checkbox
    And Click on the Apply button
    And Click on the top item
    And Click on Forward wlc button
    And Select "Specific Member" to assign task
    And Click on "Chuyển tiếp" button
    Then Verify item count is reduced by one

  Scenario: WLC_004_WLCCounter unanswered message_received one message
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab
    When Go to "wlc0003" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Click on the top item
    And Reply ones
    Then Verify item count is unchanged

  # Cấu hình hiển thị tin chưa đọc
  Scenario: TC04_FBCounter_Set counter on the job processing page
    Given Go to Mobio site by "Admin" account
    Given Click on Setting button
    And Click on "Cài đặt cá nhân" settings
    And Go to "Kiểu hiển thị" screen from menu
    When Click on the Social link in the setting screen
    And Click on the Edit button on the job processing page
    And Click on Show unread count radio
    And Click on the Save button
    And Back to default screen
    And Back to the Content
    And Logout from Mobio site
    And Login by "Admin" account

  #Đếm số message chưa đọc mặc định
  Scenario: WLC_005_WLCCounter create one message
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    When Go to "wlc0003" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    Then Verify item count is increased by one

  Scenario: WLC_006_WLCCounter read one message
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab
    And Sort in order from new to old
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Click on the message tab
    And Click on the top item
    Then Verify item count is unchanged

  Scenario: WLC_007_WLCCounter received one message
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab
    And Sort in order from old to new
    And Go to Mobio site by "Member" account
    When Go to "wlc0003 " web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on the top item
    And Click on Forward wlc button
    And Select "Specific Admin" to assign task
    And Click on "Chuyển tiếp" button
    And Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    When Click on wlc icon
    Then Verify item count is increased by one

  Scenario: WLC_008_1_WLCCounter unread mesage_forward an unread message
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    And Sort in order from new to old
    When Go to "wlc0003 " web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Get number of "Tin nhắn" tab
    And Click old wlc message
    And Click on Forward wlc button
    And Select "Specific Member" to assign task
    And Click on "Chuyển tiếp" button
    Then Verify item count is reduced by one

  Scenario: WLC_008_2_WLCCounter_forward a read message
    Given Go to Mobio site by "Admin" account
    When Go to "wlc0003 " web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on the message tab
    And Sort in order from new to old
    And Click old wlc message
    And Get number of "Tin nhắn" tab
    And Click on Forward wlc button
    And Select "Specific Member" to assign task
    And Click on "Chuyển tiếp" button
    Then Verify item count is unchanged

  Scenario: WLC_009_1_WLCCounter Count messages
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab
    And Sort in order from old to new
    When Go to "wlc0002" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    Then Verify item count is increased by one
    And Click old wlc message
    Then Verify item count is unchanged

  Scenario: WLC_009_2_WLCCounter unread mesage_received one message_Condition_No item in list of account
    Given Go to Mobio site by "Member in Team" account
    And Go to the Social chat screen
    When Click on wlc icon
    And Click on "Tin nhắn" tab
    And Sort in order from new to old
    And Go to "wlc0003" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    Then Verify the focus for new item

  Scenario: TC02_FBCounter_Set counter on the job processing screen
    Given Go to Mobio site by "Admin" account
    And Click on Setting button
    And Click on "Cài đặt cá nhân" settings
    And Go to "Kiểu hiển thị" screen from menu
    When Click on the Social link in the setting screen
    And Click on the Edit button on the job processing page
    And Click on Show unanswered count radio
    And Click on the Save button
    And Back to default screen
    And Back to the Content
    And Logout from Mobio site
    And Login by "Admin" account
@counttl
  Scenario: BL_013_14_FBCounter notify_comment ones
    Given Go to Mobio site by "Admin" account
    And Go to "wlc0003 " web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site
    When Go to the Social chat screen
    And Click on wlc icon
    And Click on the message tab
    And Click on Notify icon
    Then Verify notification after that   
    And Click on the Notification
    Then Verify item jumps to list and column2
