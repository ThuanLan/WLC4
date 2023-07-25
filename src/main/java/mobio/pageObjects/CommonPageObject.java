package mobio.pageObjects;

import org.openqa.selenium.WebDriver;

import autolibraries.mobioLibs;
import commons.SvDataTest;
import mobio.pageUIs.CommonPageUI;

/**
 * @author thuannt
 */
public class CommonPageObject extends mobioLibs {

	WebDriver driver;
	SvDataTest dataTest;
	public static String getWebsiteVersion;

	public CommonPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void goToScreenFromMenuInMenu(WebDriver driver, String childMenuName, String parentMenuName,
			String ancestorMenu) {
		switchToWindowByTitle(driver, "Mobio - CDP & CEM Platform");
		driver.navigate().refresh();
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		sleepInSecond(5);
		waitToElementClickable(driver, CommonPageUI.HOME_MENU);
		clickToElement(driver, CommonPageUI.HOME_MENU);
		waitToElementClickable(driver, CommonPageUI.DYNAMIC_MENU_LINK, ancestorMenu);
		clickToElement(driver, CommonPageUI.DYNAMIC_MENU_LINK, ancestorMenu);
		clickToElement(driver, CommonPageUI.DYNAMIC_MENU_LINK, parentMenuName);
		clickToElement(driver, CommonPageUI.DYNAMIC_CHILD_MENU_LINK, childMenuName);
		sleepInSecond(3);
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		sleepInSecond(9);
		switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
	}

	public void goToSettingPageFromMenu(WebDriver driver, String childMenuName, String parentMenuName) {
		sleepInSecond(1);
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		waitToElementClickable(driver, CommonPageUI.DYNAMIC_MENU_LINK, parentMenuName);
		clickToElement(driver, CommonPageUI.DYNAMIC_MENU_LINK, parentMenuName);
		clickToElement(driver, CommonPageUI.DYNAMIC_CHILD_MENU_LINK, childMenuName);
		sleepInSecond(3);
		switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		sleepInSecond(7);
	}

	public void goToChildPageFromLink(WebDriver driver,String urlLink) {
		openUrl(driver, urlLink);
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
		sleepInSecond(1);
	}
	
	public boolean isFilterCursor(String locator, String cursor) {
		String cursorCss = findElementByXpath(driver, locator).getCssValue("cursor");
		return cursor.equals(cursorCss);
	}

	public String getAccount(String account) {
		
		dataTest = SvDataTest.getSvDataTest();
		switch (account) {

		case "ManagerTeam":
			assert dataTest != null;
			return dataTest.getManagerTeam();

		case "UserTeam":
			assert dataTest != null;
			return dataTest.getUserTeam();

		case "AllMember":
			// admin
			assert dataTest != null;
			return dataTest.getAllAcc();

		case "Admin":
			// admin
			assert dataTest != null;
			return dataTest.getManagerAcc();

		case "Specific Admin":
			// admin
			assert dataTest != null;
			return dataTest.getManagerInfo();

		case "Member":
			// thuannt5: To view other member and other team
			assert dataTest != null;
			return dataTest.getMemberAcc();

		case "Specific Member":
			// thuannt5 info: To view other member and other team
			assert dataTest != null;
			return dataTest.getMemberInfo();

		case "Member in Team":
			// thuan1: Do not view other member
			assert dataTest != null;
			return dataTest.getMemberInTeam();

		case "Specific member in Team":
			// thuan1: Do not view other member
			assert dataTest != null;
			return dataTest.getMemberInTeamInfo();

		case "Other Member":
			// thuannt: member in other team that do not share view
			assert dataTest != null;
			return dataTest.getMemberOtherAcc();

		case "Member in other Team":
			// thuannt6: belong to other team and only as a user
			assert dataTest != null;
			return dataTest.getMemberOtherToView();

		case "Specific member in other Team":
			// thuannt6 info: belong to other team and only as a user
			assert dataTest != null;
			return dataTest.getMemberOtherViewInfo();
			
		case "User other Team":
			// thuannt6: belong to other team and only as a user
			assert dataTest != null;
			return dataTest.getMemberOtherUser();

		case "Specific user other Team":
			// thuannt6 info: belong to other team and only as a user
			assert dataTest != null;
			return dataTest.getMemberOtherUserInfo();
		}
		return "Not found value!";
	}

	public void getWebsiteVersion() {
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		clickToElement(driver, CommonPageUI.ACCOUNT_AVATAR_BTN);
		getWebsiteVersion = getTextElement(driver, CommonPageUI.WEBSITE_VERSION_LBL);
		clickToElement(driver, CommonPageUI.RIGHT_SIDER_BAR);
	}

	public void switchToMainFrame() {
		switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
	}
}
