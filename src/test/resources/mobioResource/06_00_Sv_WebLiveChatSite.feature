@chatdata
Feature: Web live chat and data
  As a PO
  I want to login to application
  So that verify Web live chat page

  @loginsuccess
  Scenario: TC01_Login to the website with valid Username and Password
    And Login by "Admin" account

  @getwebvs
  Scenario: TC01_Get website version to display on report
    Given Go to Mobio site by "Admin" account
    And Click to Avatar and get website version

  @deletealldata
  Scenario: TC01_FBCounter Delete all data before checking all TCs
    Given Go to Mobio site by "Admin" account
    And Go to "Chat & trả lời khách hàng" screen from "Online & mạng xã hội" menu in "Services" menu
    And Delete data to reset weblivechat module
    And Delete data to reset facebook comment module
    And Delete data to reset facebook message module
  
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
 
  Scenario Outline: TC01_Config for assignee group and prioritied page
    Given Go to Mobio site by "Admin" account
    When Go to Social assignment settings screen
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

  Scenario: TC01_2 Logout to apply new config
    Given Go to Mobio site by "Admin" account

  Scenario Outline: TC01_3 Wlc create new message
    Given Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site

    Examples: 
      | WLCSite |
      | wlc0002 |

  Scenario: TC02_1 Wlc go to web live chat site
    Given Go to Mobio site by "Member" account

  Scenario Outline: TC02_2 Wlc go to web live chat site
    Given Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site

    Examples: 
      | WLCSite |
      | wlc0003 |

  Scenario: TC_02_Config Support Assignment in a Team_Only assign to online member
    Given Go to Mobio site by "Admin" account
    When Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select only assign to online member
    And Back to default screen
    And Back to the Content

  Scenario Outline: TC04_Config for assignee group
    Given Go to Mobio site by "Admin" account
    When Go to Social assignment settings screen
    And Click on "Phân công giữa các Team" rule to config
    And Select "<WLCSite>" page name in "Web live chat" social
    And Select priority radio button to handle mesages in "UserTeam" team
    And Back to default screen
    And Back to the Content

    Examples: 
      | WLCSite |
      | wlc0004 |
      | wlc0005 |

  Scenario: TC05_1Wlc go to web live chat site
    Given Go to Mobio login page
    And Login by "Member in other Team" account

  Scenario Outline: TC05_2Wlc go to web live chat site
    Given Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site

    Examples: 
      | WLCSite |
      | wlc0004 |

  Scenario: TC07_1 Wlc go to web live chat site
    Given Go to Mobio login page
    And Login by "Other Member" account

  Scenario Outline: TC07_2 Wlc go to web live chat site
    Given Go to "<WLCSite>" web live chat site on other browser
    And Create message by wlc on other browser
    And Close the second browser
    And Switch to Mobio site

    Examples: 
      | WLCSite |
      | wlc0005 |

  Scenario Outline: TC08_Config for assignee group and prioritied page
    Given Go to Mobio site by "Admin" account
    When Go to Social assignment settings screen
    And Click on "Phân công giữa các Team" rule to config
    And Select "<WLCSite>" page name in "Web live chat" social
    And Select priority radio button to handle mesages in "ManagerTeam" team
    And Back to default screen
    And Back to the Content

    Examples: 
      | WLCSite |
      | wlc0002 |
      | wlc0003 |
      | wlc0004 |
      | wlc0005 |

  Scenario: TC_02_Config Support Assignment in a Team_Only assign to online member
    Given Go to Mobio site by "Admin" account
    When Go to Social assignment settings screen
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select only assign to online member
    And Back to default screen
    And Back to the Content
    And Go to Mobio login page
    And Login by "Admin" account
