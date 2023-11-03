package mobio.stepDefinitions;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumberOption.Hooks;
import mobio.pageObjects.CommonPageObject;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageObjects.ServicesPageObject;
import mobio.services.pageUIs.ServicesPageUI;

public class ServicesPageSteps {
	WebDriver driver;
	ServicesPageObject servicesPage;
	CommonPageObject commonPage;

	public ServicesPageSteps() {
		driver = Hooks.getAndCloseBrowser();
		servicesPage = PageGeneratorManager.getServicesPage(driver);
		commonPage = PageGeneratorManager.getCommonPage(driver);
	}

	@And("^Delete data to reset facebook comment module$")
	public void deleteDataToResetFacebookCommentModule() {
		servicesPage.deleteDataToResetFBCommentModule();
	}

	@And("^Delete data to reset facebook message module$")
	public void deleteDataToResetFacebookMessageModule() {
		servicesPage.deleteDataToResetFBMessageModule();
	}

	@And("^Delete data to reset weblivechat module$")
	public void deleteDataToResetWeblivechatModule() {
		servicesPage.deleteDataToResetWLCModule();
	}

	// Common for Services

	@And("^Select \"([^\"]*)\" Team that you want to config$")
	public void selectTeamThatYouWantToConfig(String teamName) {
		teamName = commonPage.getAccount(teamName);
		servicesPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		servicesPage.sleepInSecond(5);
		servicesPage.waitToElementClickable(driver, ServicesPageUI.SUPPORT_TEAM, teamName);
		servicesPage.clickToElement(driver, ServicesPageUI.SUPPORT_TEAM, teamName);
		servicesPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
	}

	@And("^Click on \"([^\"]*)\" rule to config$")
	public void clickRuleToConfig(String ruleNameConfig) {
		servicesPage.clickToElement(driver, ServicesPageUI.RULE_OPTION, ruleNameConfig);
		servicesPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		servicesPage.sleepInSecond(9);
	}

	@And("^Click on \"([^\"]*)\" config type to assign in a team$")
	public void clickConfigTypeToConfigAssignmentInATeam(String configName) {
		servicesPage.clickToElement(driver, ServicesPageUI.ASSIGNMENT_CONFIG_TAB, configName);
		servicesPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
	}

	@And("^Select only assign to online member$")
	public void selectOnlyAssignToOnlineMember() {
		servicesPage.selectOnlyAssignToOnlineMemberRule();
	}

	@And("^Select not assigned to selected members \"([^\"]*)\" rule$")
	public void selectNotAssignedToSelectedMembersRule(String member) {
		servicesPage.notAssignedToSelectedMemberRule(commonPage.getAccount(member));
	}

	@And("^Select recall rule$")
	public void selectRecallRule() {
		servicesPage.configRecallRule();
	}

	@And("^Select \"([^\"]*)\" other member in the \"([^\"]*)\" Team that \"([^\"]*)\" member want to view$")
	public void selectTeamAndMemberToView(String otherMemberAccount, String teamName, String memberAccount) {
		memberAccount = commonPage.getAccount(memberAccount);
		otherMemberAccount = commonPage.getAccount(otherMemberAccount);
		teamName = commonPage.getAccount(teamName);
		servicesPage.chooseTeamAndMemberToView(memberAccount, otherMemberAccount, teamName);
	}

	@And("^Get pages list of Team in \"([^\"]*)\" social network$")
	public void getPagesListSocial(String socialNetworkName) {
		servicesPage.getPagesListSocialNetwork(socialNetworkName);
	}

	@And("^Select \"([^\"]*)\" page name in \"([^\"]*)\" social$")
	public void selectPageNameInListSocialPage(String pageName, String socialName) {
		servicesPage.selectPageName(pageName, socialName);
	}

	@And("^Select priority radio button to handle mesages in \"([^\"]*)\" team$")
	public void selectTeamToHandleMessages(String teamName) {
		teamName = commonPage.getAccount(teamName);
		servicesPage.sleepInSecond(3);
		servicesPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		servicesPage.sleepInSecond(5);
		if (!servicesPage.isElementDisplayed(driver, ServicesPageUI.HANDLE_PRIORITY_CHECKED_RADIO,
				"Danh sách các team xử lý Inbox", teamName)) {
			servicesPage.waitToElementClickable(driver, ServicesPageUI.HANDLE_PRIORITY_RADIO,
					"Danh sách các team xử lý Inbox", teamName);
			servicesPage.sleepInSecond(3);
			servicesPage.clickToElement(driver, ServicesPageUI.HANDLE_PRIORITY_RADIO, "Danh sách các team xử lý Inbox",
					teamName);
			servicesPage.waitToElementClickable(driver, ServicesPageUI.SAVE_HANDLE_PRIORITY_BTN);
			servicesPage.clickToElement(driver, ServicesPageUI.SAVE_HANDLE_PRIORITY_BTN);
		}
	}

	@And("^Click the \"([^\"]*)\" button$")
	public void clickButton(String buttonName) {
		servicesPage.waitToElementClickable(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, buttonName);
		servicesPage.clickToElement(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, buttonName);
		servicesPage.sleepInSecond(3);
	}
	
	@And("^Click on \"([^\"]*)\" button$")
	public void clickOnButton(String buttonName) {
		servicesPage.waitToElementClickable(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, buttonName);
		servicesPage.clickToElement(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, buttonName);
		servicesPage.sleepInSecond(3);
	}

	@And("^Create new \"([^\"]*)\" behavior tag$")
	public void createNewBehaviorTag(String tagName) {
		servicesPage.createNewBehaviorTag(tagName);
	}

	@And("^Search \"([^\"]*)\" page name in Fanpage Wlc$")
	public void searchpageInFanpageWlc(String pageName) {
		//servicesPage.waitToElementVisible(driver, ServicesPageUI.SEARCH_SOCIAL_PAGE_TXT, 60);
		servicesPage.sendkeyToElement(driver, ServicesPageUI.SEARCH_SOCIAL_PAGE_TXT, pageName);
	}

	@And("^Close all list of displayed social item$")
	public void closeAllListOfDisplayedSocialItem() {
		while (servicesPage.isElementDisplayed(driver, ServicesPageUI.CLOSE_DISPLAY_PAGE_BTN)) {
			servicesPage.clickToElement(driver, ServicesPageUI.CLOSE_DISPLAY_PAGE_BTN);
		}
	}

	@And("^Select \"([^\"]*)\" on fanpage$")
	public void selectSomethingOnFanpage(String fbComponentName) throws Throwable {
		if (servicesPage.isElementDisplayed(driver, ServicesPageUI.BOARD_CHECKED_CHECKBOX, fbComponentName)) {
			throw new Exception("TL_Exited old dashboard!");
		} else {
			servicesPage.clickToElement(driver, ServicesPageUI.BOARD_CHECKBOX, fbComponentName);
		}
	}

	@Given("^Click on Setting menu$")
	public void clickOnSettingMenu() {
		servicesPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		servicesPage.waitToElementClickable(driver, CommonPageUI.SETTINGS_ICON);
		servicesPage.clickToElement(driver, CommonPageUI.SETTINGS_ICON);
		servicesPage.sleepInSecond(3);
	}

	@And("^Click on \"([^\"]*)\" settings$")
	public void clickOnSomethingSettings(String settingName) {
		servicesPage.waitToElementClickable(driver, CommonPageUI.SETTINGS_BRANCH_MENU, settingName);
		servicesPage.clickToElement(driver, CommonPageUI.SETTINGS_BRANCH_MENU, settingName);
		servicesPage.sleepInSecond(5);
		servicesPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		servicesPage.sleepInSecond(5);
	}
	
	
}
