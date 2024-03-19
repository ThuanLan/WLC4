package mobio.services.pageObjects;

import org.openqa.selenium.WebDriver;

import autolibraries.mobioLibs;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageUIs.SvWlcCounterPageUI;
import mobio.services.pageUIs.SvWlcFilterPageUI;

public class SvWlcFilterPageObject extends mobioLibs {
	WebDriver driver;

	public SvWlcFilterPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void clickInforAccessWebButton() {
		waitToElementClickable(driver, SvWlcFilterPageUI.INFOR_WEB_ACCESS_BUTTON);
		clickToElement(driver, SvWlcFilterPageUI.INFOR_WEB_ACCESS_BUTTON);
	}

	// them filter

	public void clickOnFilterButton() {
		sleepInSecond(2);
		waitToElementClickable(driver, SvWlcFilterPageUI.FILTER_BTN);
		clickToElement(driver, SvWlcFilterPageUI.FILTER_BTN);
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
	}

	public void selectAllSupportDropdown(String itemName) {
		waitToElementVisible(driver, SvWlcFilterPageUI.SUPPORT_DROP);
		selectItemInCustomDropdownBySearching(driver, SvWlcFilterPageUI.SUPPORT_DROP,
				SvWlcFilterPageUI.SUPPORT_ALLITEM_DROP, SvWlcFilterPageUI.SUPPORT_SEARCH_TXT, itemName);
		sleepInSecond(1);
	}

	public void checkOnUnansweredCheckbox() {
		if (!isElementDisplayed(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKED_CHECKBOX)) {
			waitToElementClickable(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKBOX);
			scrollToElement(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKBOX);
			clickToElement(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKBOX);
		}

		if (isElementDisplayed(driver, SvWlcFilterPageUI.REPLY_CHECKED_CHECKBOX)) {
			waitToElementClickable(driver, SvWlcFilterPageUI.REPLY_CHECKBOX);
			scrollToElement(driver, SvWlcFilterPageUI.REPLY_CHECKBOX);
			clickToElement(driver, SvWlcFilterPageUI.REPLY_CHECKBOX);
			sleepInSecond(1);
		}
	}

	public void checkOnAnsweredCheckbox() {
		if (!isElementDisplayed(driver, SvWlcFilterPageUI.REPLY_CHECKED_CHECKBOX)) {
			waitToElementClickable(driver, SvWlcFilterPageUI.REPLY_CHECKBOX);
			scrollToElement(driver, SvWlcFilterPageUI.REPLY_CHECKBOX);
			clickToElement(driver, SvWlcFilterPageUI.REPLY_CHECKBOX);
			sleepInSecond(1);
		}

		if (isElementDisplayed(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKED_CHECKBOX)) {
			waitToElementClickable(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKBOX);
			scrollToElement(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKBOX);
			clickToElement(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKBOX);
			sleepInSecond(1);
		}
	}

	public void clickOnTheApplyButton() {
		waitToElementClickable(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, "Áp dụng bộ lọc");
		clickToElement(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, "Áp dụng bộ lọc");
		sleepInSecond(5);
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
	}

	public void hoverOnFilterButton() {
		hoverMouseToElement(driver, SvWlcFilterPageUI.FILTER_BTN);
	}

	public void clickOnFilterCollapse() {
		clickToElement(driver, SvWlcFilterPageUI.FILTER_COLLAPSE_LINK);
	}

	public void clickOnFinishedCheckbox() {
		clickToElement(driver, SvWlcFilterPageUI.FINISHED_RADIO);

	}

	public void selectTagNames(String tagName1, String tagName2, String tagName3) {
		selectTags(tagName1);
		selectTags(tagName2);
		selectTags(tagName3);
	}

	public void selectTags(String expectedText) {
		selectItemInCustomDropdownBySearching(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT,
				SvWlcFilterPageUI.FILTER_TAG_NAME_ALL_ITEM, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT, expectedText);
		clickToElement(driver, CommonPageUI.DYNAMIC_LBL, "Tag phân loại công việc");
	}
}