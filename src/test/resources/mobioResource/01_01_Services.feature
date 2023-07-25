@fbcommonservices
Feature: Config services
  As a PO
  I want to go to services common page
  So that config common case in services module

  Scenario: TC01_Login to the website with valid Username and Password
    And Login by "Admin" account

  Scenario: TC_02_Config Support Assignment in a Team_Only assign to online member
    Given Go to Mobio site by "Admin" account
    When Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select only assign to online member
    And Click the "Quay lại" button

  Scenario: TC_03_Config Support Assignment in a Team_Not assigned to selected members
    Given Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Select "ManagerTeam" Team that you want to config
    And Click on "Phân công trong nội bộ Team" rule to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select not assigned to selected members "Specific Member" rule
    And Click the "Quay lại" button

  Scenario: TC_04_Config recall rule in a Team
    Given Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Select "ManagerTeam" Team that you want to config
    And Click on "Cấu hình phân công Inbox" config type to assign in a team
    And Select recall rule
    And Click the "Quay lại" button

  Scenario: TC_05_Config share view to see another memember in a Team
    Given Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Phân công chat & trả lời" screen from menu "Online & mạng xã hội" Settings
    And Select "ManagerTeam" Team that you want to config
    And Click on "Thành viên trong Team" config type to assign in a team
    And Select "Specific member in other Team" other member in the "UserTeam" Team that "Specific Member" member want to view
    And Click the "Quay lại" button

  Scenario: TC_06_Config Create behavior tag
    Given Click on Setting menu
    And Click on "Cài đặt doanh nghiệp" settings
    And Go to "Tags hành vi" screen from "Tags" menu in "Đối Tượng" menu
    When Click on "Tag hành vi mới" button
    And Create new "Behavior tag" behavior tag
