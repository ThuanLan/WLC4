package mobio.services.pageObjects;

import org.openqa.selenium.WebDriver;

import autolibraries.mobioLibs;
import mobio.pageObjects.CommonPageObject;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageUIs.SvWlcCounterPageUI;
import mobio.services.pageUIs.SvWlcMessagePageUI;

// TODO: Auto-generated Javadoc

/**
 * The Class HomePageObject.
 */
public class SvWlcMessagePageObject extends mobioLibs {

	/**
	 * The driver.
	 */
	WebDriver driver;
	String getAccount;
	CommonPageObject commonPage;
	SvWlcSocketPageObject svWlcSocketPage;
	public static String getContent;
	public static String wlcSite;

	/**
	 * Instantiates a new home page object.
	 *
	 * @param _driver the driver
	 */
	public SvWlcMessagePageObject(WebDriver _driver) {
		driver = _driver;
		svWlcSocketPage = PageGeneratorManager.getSvFbWlcSocketPage(driver);
		commonPage = PageGeneratorManager.getCommonPage(driver);
	}

	public void clickOnAvatar() {
		clickToElement(driver, CommonPageUI.ACCOUNT_AVATAR_BTN);
		getAccount = getTextElement(driver, CommonPageUI.WEBSITE_ACCOUNT_LBL);

	}

	public boolean isReplyData() {
		sleepInSecond(3);
		boolean msgContent = isElementDisplayed(driver, SvWlcMessagePageUI.COTENT_IN_COLUMN2_LBL, SvWlcCounterPageObject.randomReply);
		boolean successReplyIcon = isElementDisplayed(driver, SvWlcMessagePageUI.WLC_REPLY_SUCCESS_ICON);
		boolean respondent = isElementDisplayed(driver, SvWlcCounterPageUI.REPLY_ITEM_OWNER, getAccount);
		return msgContent && successReplyIcon && respondent;
	}

	public boolean isQuickRepliedWlc() {

		boolean msgContent = isElementDisplayed(driver, SvWlcMessagePageUI.COTENT_IN_COLUMN2_LBL, SvWlcCounterPageObject.quickReply);
		boolean successReplyIcon = isElementDisplayed(driver, SvWlcMessagePageUI.WLC_REPLY_SUCCESS_ICON);
		boolean respondent = isElementDisplayed(driver, SvWlcCounterPageUI.REPLY_ITEM_OWNER, getAccount);
		boolean repImg = isElementDisplayed(driver, SvWlcMessagePageUI.QUICK_REP_IMG);
		System.out.println("Trạng thái: " + msgContent + ", " + successReplyIcon + ", " + respondent + ", " + repImg);
		return msgContent && successReplyIcon && respondent && repImg;
	}

	public boolean isReplyByTeamMember(String userid) {
		sleepInSecond(1);
		boolean msgContent = isElementDisplayed(driver, SvWlcMessagePageUI.COTENT_IN_COLUMN2_LBL, SvWlcCounterPageObject.randomReply);
		boolean successReplyIcon = isElementDisplayed(driver, SvWlcMessagePageUI.WLC_REPLY_SUCCESS_ICON);
		boolean respondent = isElementDisplayed(driver, SvWlcCounterPageUI.REPLY_ITEM_OWNER, commonPage.getAccount(userid));
		return msgContent && successReplyIcon && respondent;
	}

	public boolean isReplyByOtherTeamMember(String userid) {
		sleepInSecond(1);
		boolean msgContent = isElementUndisplayed(driver, SvWlcMessagePageUI.COTENT_IN_COLUMN2_LBL, SvWlcCounterPageObject.randomReply);
		boolean successReplyIcon = isElementUndisplayed(driver, SvWlcMessagePageUI.WLC_REPLY_SUCCESS_ICON);
		boolean respondent = isElementUndisplayed(driver, SvWlcCounterPageUI.REPLY_ITEM_OWNER, userid);
		return msgContent && successReplyIcon && respondent;
	}

	public boolean isRepliedItemAnotherTeamByCustomer() {
		boolean msgContent = isElementUndisplayed(driver, SvWlcMessagePageUI.COTENT_IN_COLUMN2_LBL, SvWlcCounterPageObject.randomReply);
		boolean avatarIcon = isElementUndisplayed(driver, SvWlcMessagePageUI.WLC_VIEW_AVATAR_ICON, SvWlcCounterPageObject.randomReply);
		return msgContent && avatarIcon;
	}

	public boolean isRepliedItemInTeamByCustomer() {
		switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
		sleepInSecond(7);
		return isElementDisplayed(driver, SvWlcMessagePageUI.COTENT_IN_COLUMN2_LBL, SvWlcCounterPageObject.randomReply);
	}

	public void clickOldWlcItem() {
		sleepInSecond(3);
		waitToElementVisible(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ITEM, SvWebLiveChatPageObject.wlcMessage);
		clickToElement(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ITEM, SvWebLiveChatPageObject.wlcMessage);
		sleepInSecond(2);
		wlcSite = getTextElement(driver, SvWlcMessagePageUI.WLC_SITE);
	}

	public void clickOneWlc(String randomElement) {
		if (isElementDisplayed(driver, randomElement)) {

			int totalRow = countElementNumber(driver, randomElement);
			int rowNumber = randomRowNumber(totalRow);
			// System.out.println("Số hàng " + rowNumber);
			String locator = randomElement + "[" + rowNumber + "]";
			// System.out.println("GT element " + locator);
			waitToElementVisible(driver, locator);
			sleepInSecond(3);
			getContent = getTextElement(driver, locator);
			try {
				if ((getContent.contains("đã gửi 1 video")) || (getContent.contains("đã gửi 1 ảnh")) || (getContent.contains("Đã gửi 1 ảnh gif"))) {
					rowNumber = randomRowNumber(totalRow);
					locator = randomElement + "[" + rowNumber + "]";
					getContent = getTextElement(driver, locator);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// System.out.println("Giá trị content ban đầu chọn : " + getContent);
			wlcSite = getTextElement(driver, SvWlcMessagePageUI.WLC_SITE);
			waitToElementClickable(driver, locator);
			clickToElementByJS(driver, locator);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);

		}
	}

	public void clickOneWlcToAddTag(String randomElement) {
		clickOneWlc(randomElement);
		sleepInSecond(3);
		while (isElementDisplayed(driver, SvWlcCounterPageUI.DISABLED_BEHAVIOR_TAG)) {
			waitToElementClickable(driver, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN);
			clickToElement(driver, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
			svWlcSocketPage.assignTaskToUser(commonPage.getAccount("Member in Team"));
			waitToElementClickable(driver, CommonPageUI.DYNAMIC_BUTTON, "Chuyển tiếp");
			clickToElement(driver, CommonPageUI.DYNAMIC_BUTTON, "Chuyển tiếp");
			clickOneWlc(randomElement);
		}
	}

	public void clickOldWlcItemOtherDriver() {
		clickToElement(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ITEM, getContent);
		sleepInSecond(2);
	}

	public boolean isDisableTagAddedIntoAnItem(String tagName) {
		sleepInSecond(5);
		boolean tagicon1 = isElementDisplayed(driver, SvWlcCounterPageUI.COLUMN1_TAG_ICON);
		boolean tagIcon2 = isElementDisplayed(driver, SvWlcCounterPageUI.COLUMN2_TAG_ICON);
		boolean tagName1 = isElementDisplayed(driver, SvWlcCounterPageUI.COLUMN1_TAG_CONTENT_LBL, tagName);
		boolean tagName2 = isElementDisplayed(driver, SvWlcCounterPageUI.COLUMN2_TAG_CONTENT_LBL, tagName);
		return tagicon1 && tagIcon2 && tagName1 && tagName2;
	}

	public boolean isPositionOfTheItem() {
		backToDefault(driver);
		switchToIframe(driver, CommonPageUI.MAIN_IFRAME);

		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		sleepInSecond(3);

		if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_ICON)) {
			int countPin = countElementNumber(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_ICON);
			String compareText = getTextElement(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM + '[' + (countPin + 1) + ']');
			return compareText.equals(getContent);
		} else {
			String compareText = getTextElement(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM + '[' + 1 + ']');
			return compareText.equals(getContent);
		}
	}

}
