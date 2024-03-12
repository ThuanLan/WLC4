@chatother
Feature: Web live chat and Others
  As a PO
  I want to login to application
  So that verify Web live chat page

  Scenario: TC01_FBCounter Delete all data before checking all TCs
    Given Go to Mobio site by "Admin" account
    And Go to the Social chat screen
    And Delete data to reset weblivechat module
    And Switch to Mobio site
    And Close all windows without parent

  Scenario: TC_01_Config Support Assignment in a Team_Only assign to online member
    Given Go to Mobio site by "Admin" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select only assign to online member
    When Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser

  # dong 77,78,79
  #Scenario: WLC_077_BlockContact
  #Given Go to the Social chat screen
  #When Click on wlc icon
  #And Click one wlc item
  #And Click on Block contact button
  #Then Verify block contact of member
  #
  #Scenario: WLC_078_BlockContact in team
  #Given Logout from Mobio site
  #And Login by "Admin" account
  #Given Go to the Social chat screen
  #When Click on wlc icon
  #And Click on filter button
  #And Select "Specific Member" data support dropdown
  #And Click on the Apply button
  #And Click one wlc item
  #And Open Mobio on second driver
  #And Login by "Member" account on other browser
  #Given Go to the Social chat screen on other browser
  #When Click on wlc icon on other browser
  #And Click wlc item on other browser
  #And Click on Block contact button
  #Then Verify the block contact of member in team
  #
  #Scenario: WLC_079_BlockContact in other team
  #Given Logout from Mobio site
  #And Login by "Other Member" account
  #Given Go to the Social chat screen
  #When Click on wlc icon
  #And Click on filter button
  #And Select "Specific Member" data support dropdown
  #And Click on the Apply button
  #And Click one wlc item
  #And Open Mobio on second driver
  #And Login by "Member" account on other browser
  #Given Go to the Social chat screen on other browser
  #When Click on wlc icon on other browser
  #And Click wlc item on other browser
  #And Click on Block contact button
  #Then Verify the block contact of member in other team

  Scenario Outline: WLC_080_Add tag profile
    Given Go to Mobio site by "Admin" account
    When Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Click one wlc item to add tag
    And Select behavior tag name
    And Click on Add tag profile button
    Then Verify wlc after adding behavior tag
    And Click on Forward wlc button
    And Select "Specific Member" to assign task
    And Click on "Chuyển tiếp" button

    Examples: 
      | WLCSite |
      | wlc0002 |

  Scenario: WLC_081_Add tag in a team _ERR30392
    Given Go to Mobio site by "Admin" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific Member" rule
    When Go to "wlc0003" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Sort in order from new to old   
    And Click on filter button
    And Select "Specific Member" data support dropdown
    And Click on the Apply button
    And Sort in order from new to old
    And Click old wlc message
    And Open Mobio on second driver
    And Login by "Member" account on other browser
    And Go to the Social chat screen on other browser
    And Click on wlc icon on other browser
    And Click old wlc message on other browser
    And Select behavior tag name on other browser
    And Click on Add tag profile button on other browser
    And Close the second browser
    Then Verify wlc after adding behavior tag
    And Click on Forward wlc button
    And Select "Specific member in Team" to assign task
    And Click on "Chuyển tiếp" button

  Scenario Outline: WLC_082_Tag in other team
    Given Go to Mobio site by "Member" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific Member" rule
    When Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Go to Mobio login page
    And Login by "User other Team" account
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
    And Select behavior tag name on other browser
    And Click on Add tag profile button on other browser
    And Close the second browser
    Then Verify comment after adding behavior tag by other team

    Examples: 
      | WLCSite |
      | wlc0002 |

  Scenario: TC_01_Config Support Assignment in a Team_Only assign to online member
    Given Go to Mobio site by "Admin" account
    And Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select only assign to online member

  Scenario Outline: WLC_083_Edit profile
    Given Go to Mobio site by "Admin" account
    When Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Click one wlc item
    And Click on Config Column3 button
    And Config for "Thông tin Profile" value
    And Click on "Lưu" button
    And Back to default screen
    And Switch to the main frame
    And Click on Edit profile button
    And Input some valid data
    And Click on "Lưu" button
    Then Verify the updated profile at column3
    And Click on profile name
    And Switch to new tab
    Then Verify the updated profile in redirected page
    And Switch to Mobio site
    And Close all windows without parent

    Examples: 
      | WLCSite |
      | wlc0003 |
@80
  Scenario Outline: WLC_084_86_Add deal and delete deal
    Given Go to Mobio site by "Admin" account
    When Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Go to the Social chat screen
    And Click on wlc icon
    And Click one wlc item
    And Click on Config Column3 button
    And Config for "Cơ hội bán " value
    And Click on "Lưu" button
    And Click Deal icon
    And Click Add deal button
    And Add deal information
    And Click on "Lưu" button
    And Click to View deal detail
    Then Verify deal updated information at the column3
    And Click to redirect deal detail
    And Switch to new tab
    Then Verify redirected deal page
    And Switch to Mobio site
    And Close all windows without parent
    And Click to delete a deal
    And Click on "Gỡ" button
    And Click Deal icon
    Then Verify deleted deal at column3

    Examples: 
      | WLCSite |
      | wlc0002 |

  Scenario Outline: WLC_087_89_Add Ticket
    Given Go to Mobio site by "Admin" account
    And Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    When Go to the Social chat screen
    And Click on wlc icon
    And Click one wlc item
    And Click Ticket icon
    And Click Add ticket button
    And Add ticket information
    And Click on "Lưu" button
    And Click to View ticket detail
    Then Verify ticket updated information at the column3
    And Click to redirect ticket detail
    And Switch to new tab
    Then Verify redirected ticket page
    And Switch to Mobio site
    And Close all windows without parent
    And Click to delete a ticket
    And Click on "Gỡ" button
    And Click Ticket icon
    Then Verify deleted ticket at the column3

    Examples: 
      | WLCSite |
      | wlc0003 |

  Scenario Outline: WLC_090_Add Note
    Given Go to Mobio site by "Admin" account
    And Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    When Go to the Social chat screen
    When Click on wlc icon
    And Click one wlc item
    And Click on Config Column3 button
    And Config for "Ghi chú" value
    And Click on "Lưu" button
    And Click Note icon
    And Click Add note button
    And Send note information with valid information
    And Click on "Lưu" button
    And Switch to iframe screen
    And Click Note icon
    Then Verify add new note information at the column3

    Examples: 
      | WLCSite |
      | wlc0002 |

  Scenario Outline: WLC_091_Edit Note
    Given Go to Mobio site by "Admin" account
    And Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    When Go to the Social chat screen
    And Click on wlc icon
    And Click one wlc item
    And Click Note icon
    And Click Add note button
    And Send note information with valid information
    And Click on "Lưu" button
    And Switch to iframe screen
    And Click Note icon
    And Click to edit one note
    And Send note information with valid information
    And Click on "Lưu" button
    And Switch to iframe screen
    And Click Note icon
    Then Verify note updated information at the column3

    Examples: 
      | WLCSite |
      | wlc0003 |

  Scenario: WLC_092_Delete Note
    Given Go to the Social chat screen
    When Click on wlc icon
    And Click one wlc item
    And Click Note icon
    And Click Add note button
    And Send note information with valid information
    And Click on "Lưu" button
    And Switch to iframe screen
    And Click Note icon
    And Click to delete a note
    And Click on "Đồng ý" button
    Then Verify deleted note at the column3

  Scenario: WLC_093_config in Colum3
    Given Go to the Social chat screen
    When Click on wlc icon
    And Click one wlc item
    And Click on Config Column3 button
    And Config for "Ghi chú" value
    And Click on "Lưu" button
    And Click Note icon
    Then Verify new config in column3
