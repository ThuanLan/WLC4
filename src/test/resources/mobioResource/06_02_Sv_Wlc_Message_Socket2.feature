@chatsocket2
Feature: WLC Message Socket2
  As a PO
  I want to login to application
  So that verify Web live chat page
 
  Scenario: WLC_071_Add tag
    Given Go to Mobio site by "Admin" account
    When Go to the Social chat screen
    And Click on wlc icon
    And Click one wlc item
    And Add tag "wlc tag" into an item
    Then Verify "wlc tag" that added into an item

  Scenario Outline: WLC_072_Wlc unanswered comment_reply one by Copy/Paste text
    Given Go to Mobio site by "Member" account
    And Go to "<WLCSite>" web live chat site on other browser
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
    And Click wlc item on other browser
    And Add tag "check wlc" into a message on other browser
    And Close the second browser
    Then Verify "check wlc" disable tag that added into an item

    Examples: 
      | WLCSite |
      | wlc0003 |
 
  Scenario: WLC_073_Completed
    Given Go to Mobio site by "Admin" account
    When Go to the Social chat screen
    And Click on wlc icon
    And Click one wlc item
    And Click on Done button for Message
    And Click on filter button
    And Check on finished checkbox
    And Click on the Apply button
    Then Verify list of team member

  Scenario: WLC_075_Completed by other member in team
    Given Go to Mobio site by "Admin" account
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
    And Click wlc item on other browser
    And Click on Done button for message on other browser
    And Close the second browser
    Then Verify disable wlc in list

  Scenario Outline: WLC_076_Completed by other team member
    Given Go to Mobio site by "Member" account
    And Go to "<WLCSite>" web live chat site on other browser
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
    And Click wlc item on other browser
    And Click on Done button for message on other browser
    And Close the second browser
    Then Verify wlc list of team member

    Examples: 
      | WLCSite |
      | wlc0003 |
