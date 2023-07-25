package mobio.stepDefinitions;

import mobio.pageUIs.CommonPageUI;
import mobio.services.pageUIs.ServicesPageUI;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import mobio.pageObjects.CommonPageObject;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageObjects.SettingsPageObject;

public class SettingsPageSteps {
	WebDriver driver;

	SettingsPageObject settingsPage;
	CommonPageObject commonPage;

	public SettingsPageSteps() {
		driver = Hooks.getAndCloseBrowser();
		settingsPage = PageGeneratorManager.getSettingsPage(driver);
		commonPage = PageGeneratorManager.getCommonPage(driver);
	}

	@Given("^Click on Setting button$")
	public void clickOnSettingButton() {
		settingsPage.clickOnSettingButton();
	}

	@When("^Click on the Social link in the setting screen$")
	public void clickOnTheSocialLinkInTheSettingScreen() {
		settingsPage.clickOnTheSocialLinkInTheSettingScreen();
	}

	@And("^Click on the Edit button on the job processing page$")
	public void clickOnTheEditButtonOnTheJobProcessingPage() {
		settingsPage.clickOnTheEditButtonOnTheJobProcessingPage();
	}

	@And("^Click on Show unanswered count radio$")
	public void clickOnShowUnansweredCountRadio() {
		settingsPage.clickOnShowUnansweredCountRadio();
	}

	@And("^Switch to iframe screen$")
	public void switchToIframeScreen() {
		settingsPage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
	}

	@And("^Back to default screen$")
	public void backToDefaultScreen() {
		settingsPage.backtoDefault();
	}

	@And("^Click on the Save button$")
	public void clickOnTheSaveButton() {
		settingsPage.clickOnSaveButtonSettings();
	}

	@And("^Click on Show unread count radio$")
	public void clickOnShowUnreadCountRadio() {
		settingsPage.clickOnShowUnreadCountRadio();
	}

	@And("^Back to the Content$")
	public void backToTheContent() {
		settingsPage.clickToElement(driver, ServicesPageUI.BACK_TO_THE_CONTENT_ICON);
	}
}
