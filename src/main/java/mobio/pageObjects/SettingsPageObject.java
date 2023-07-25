package mobio.pageObjects;

import org.openqa.selenium.WebDriver;

import autolibraries.mobioLibs;
import mobio.pageUIs.CommonPageUI;
import mobio.pageUIs.SettingsPageUI;

public class SettingsPageObject extends mobioLibs {

	/** The driver. */
	WebDriver driver;

	public SettingsPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void clickOnSettingButton() {
		waitToElementClickable(driver, SettingsPageUI.SETTING_BTN);
		clickToElement(driver, SettingsPageUI.SETTING_BTN);
	}

	public void clickOnTheSocialLinkInTheSettingScreen() {
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		sleepInSecond(5);
		while (isElementDisplayed(driver, SettingsPageUI.SETTING_UP_ARROW)) {
			clickToElement(driver, SettingsPageUI.SETTING_UP_ARROW);
		}
		scrollToBottom(driver);
		waitToElementClickable(driver, SettingsPageUI.SETTING_SOCIAL_LINK);
		scrollToElement(driver, SettingsPageUI.SETTING_SOCIAL_LINK);
		if (isElementDisplayed(driver, SettingsPageUI.SETTING_SOCIAL_DOWN_ARROW)) {
			clickToElement(driver, SettingsPageUI.SETTING_SOCIAL_DOWN_ARROW);
		}
	}

	public void clickOnTheEditButtonOnTheJobProcessingPage() {
		scrollToBottom(driver);
		hoverMouseToElement(driver, SettingsPageUI.SETTING_SOCIAL_FORM);
		waitToElementClickable(driver, SettingsPageUI.SETTING_EDIT_SOCIAL_BTN);
		clickToElementByJS(driver, SettingsPageUI.SETTING_EDIT_SOCIAL_BTN);
		sleepInSecond(1);
	}

	public void clickOnShowUnansweredCountRadio() {
		if (isElementUndisplayed(driver, SettingsPageUI.CHECK_COUNT_NOTREPLY_SOCIAL_CHECKBOX)) {
			waitToElementClickable(driver, SettingsPageUI.UNCHECK_COUNT_NOTREPLY_SOCIAL_CHECKBOX);
			clickToElement(driver, SettingsPageUI.UNCHECK_COUNT_NOTREPLY_SOCIAL_CHECKBOX);
		}
	}

	public void clickOnSaveButtonSettings() {
		waitToElementClickable(driver, SettingsPageUI.SAVE_SETTINGS);
		clickToElement(driver, SettingsPageUI.SAVE_SETTINGS);
		sleepInSecond(3);
	}

	public void clickOnShowUnreadCountRadio() {
		if (!isElementDisplayed(driver, SettingsPageUI.CHECK_COUNT_NOTREAD_SOCIAL_CHECKBOX)) {
			waitToElementClickable(driver, SettingsPageUI.UNCHECK_COUNT_NOTREAD_SOCIAL_CHECKBOX);
			clickToElement(driver, SettingsPageUI.UNCHECK_COUNT_NOTREAD_SOCIAL_CHECKBOX);
		}
	}

	public void backtoDefault() {
		// TODO Auto-generated method stub
		driver.switchTo().defaultContent();
	}

}
