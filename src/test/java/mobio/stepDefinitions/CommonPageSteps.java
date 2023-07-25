package mobio.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.GlobalConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumberOption.Hooks;
import mobio.pageObjects.CommonPageObject;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageUIs.CommonPageUI;

public class CommonPageSteps {

	WebDriver driver;
	CommonPageObject commonPage;

	public CommonPageSteps() {
		driver = Hooks.getAndCloseBrowser();
		commonPage = PageGeneratorManager.getCommonPage(driver);
	}

	@Given("^Go to \"([^\"]*)\" screen from menu \"([^\"]*)\" Settings$")
	public void goToScreenFromMenuSettings(String childMenuName, String parentMenuName) {
		commonPage.goToSettingPageFromMenu(driver, childMenuName, parentMenuName);
	}

	@Given("^Go to \"([^\"]*)\" screen from \"([^\"]*)\" menu in \"([^\"]*)\" menu$")
	public void goToScreenFromMenuInMenu(String childMenuName, String parentMenuName, String ancestorMenu) {
		commonPage.goToScreenFromMenuInMenu(driver, childMenuName, parentMenuName, ancestorMenu);
	}

	@Given("^Go to \"([^\"]*)\" screen from menu$")
	public void goToSomethingScreenFromMenu(String menuName) {
		commonPage.clickToElement(driver, CommonPageUI.DYNAMIC_CHILD_MENU_LINK, menuName);
		commonPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		commonPage.sleepInSecond(5);
		commonPage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
	}
	
	@Given("^Go to the Social chat screen$")
	public void goToSocialScreenFromMenu() {
		commonPage.goToChildPageFromLink(driver, GlobalConstants.SOCIAL_LINK);
	}

	@And("^Close dialog$")
	public void closeDialog() {
		commonPage.clickToElement(driver, CommonPageUI.CLOSE_BTN);
		commonPage.sleepInSecond(2);
	}

	@And("^Refresh the page$")
	public void refreshThePage() {
		driver.navigate().refresh();
		commonPage.sleepInSecond(9);
	}

	@And("^Close all windows without parent$")
	public void closeAllWindowsWithoutParent() {
		commonPage.closeAllWindowsWithoutParent(driver);
	}

	@Given("^Click to Avatar and get website version$")
	public void clickToAvatarAndGetWebsiteVersion() {
		commonPage.getWebsiteVersion();
	}

	@And("^Switch to the main frame$")
	public void switchToMainFrame() {
		commonPage.switchToMainFrame();
	}
}
