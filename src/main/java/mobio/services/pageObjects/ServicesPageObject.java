package mobio.services.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autolibraries.mobioLibs;
import commons.GlobalConstants;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageUIs.ServicesPageUI;

/**
 * The Class HomePageObject.
 */
public class ServicesPageObject extends mobioLibs {

	/**
	 * The driver.
	 */
	WebDriver driver;
	public static List<String> listTemp = null;
	public static String newTagName;

	/**
	 * Instantiates a new home page object.
	 *
	 * @param _driver the driver
	 */
	public ServicesPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void deleteDataToResetFBCommentModule() {
		deleteDataToReset(GlobalConstants.REQUEST_URL_TO_DELETE_DATA, GlobalConstants.MERCHAN_ID, GlobalConstants.FB_SOCIAL_TYPE_ID, GlobalConstants.COMMENT_OBJECT_TYPE_ID);
	}

	public void deleteDataToResetFBMessageModule() {
		deleteDataToReset(GlobalConstants.REQUEST_URL_TO_DELETE_DATA, GlobalConstants.MERCHAN_ID, GlobalConstants.FB_SOCIAL_TYPE_ID, GlobalConstants.MESSAGE_OBJECT_TYPE_ID);
	}

	public void deleteDataToResetWLCModule() {
		deleteDataToReset(GlobalConstants.REQUEST_URL_TO_DELETE_DATA, GlobalConstants.MERCHAN_ID, GlobalConstants.WEBLIVECHAT_SOCIAL_TYPE_ID, GlobalConstants.MESSAGE_OBJECT_TYPE_ID);
	}

	public void selectOnlyAssignToOnlineMemberRule() {
		deactiveAllRules();
		clickToElement(driver, ServicesPageUI.ASSIGN_RULE_TOGGLE, "Chỉ phân công cho các thành viên đang truy cập");
		waitToElementClickable(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
		clickToElement(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		if (isElementDisplayed(driver, ServicesPageUI.SELECTED_TYPE_ASSIGNMENT_LBL)) {
			try {
				throw new Exception("Assign only to members accessing successfully!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			selectItemInCustomDropdown(driver, ServicesPageUI.ASSIGNMENT_TYPE_DROP, ServicesPageUI.LIST_ASSIGNMENT_TYPE_DROP, "Phân chia cho tất cả các thành viên trong Team");
			waitToElementClickable(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			clickToElement(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		}
	}

	public void deactiveAllRules() {
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		while (isElementDisplayed(driver, ServicesPageUI.ACTIVE_CONFIG_TOGGLE)) {
			while (isElementDisplayed(driver, ServicesPageUI.CLOSE_TAG_MEMBER_ICON)) {
				clickToElement(driver, ServicesPageUI.CLOSE_TAG_MEMBER_ICON);
			}
			clickToElement(driver, ServicesPageUI.ACTIVE_CONFIG_TOGGLE);
			waitToElementClickable(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			clickToElement(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		}
	}

	public void notAssignedToSelectedMemberRule(String member) {
		deactiveAllRules();
		clickToElement(driver, ServicesPageUI.ASSIGN_RULE_TOGGLE, "Không phân công cho các thành viên được chọn");

		clickToElement(driver, ServicesPageUI.SELECT_MEMBER_DROP);
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);

		if (isElementDisplayed(driver, ServicesPageUI.LIST_MEMBER_DROP)) {
			List<WebElement> listMembers = findElementsByXpath(driver, ServicesPageUI.LIST_MEMBER_DROP);
			for (WebElement element : listMembers) {
				String account = element.getText().trim();
				if (!(account.equals(member.trim()))) {
					element.click();
				}
			}
			waitToElementClickable(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			clickToElement(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		}

		if (isElementDisplayed(driver, ServicesPageUI.SELECTED_TYPE_ASSIGNMENT_LBL)) {
			try {
				throw new Exception("Assign only to members accessing successfully!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			selectItemInCustomDropdown(driver, ServicesPageUI.ASSIGNMENT_TYPE_DROP, ServicesPageUI.LIST_ASSIGNMENT_TYPE_DROP, "Phân chia cho tất cả các thành viên trong Team");
			waitToElementClickable(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			clickToElement(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		}
	}

	public void configRecallRule() {
		if (isElementDisplayed(driver, ServicesPageUI.RECALL_LAW_ACTIVE_TOGGLE)) {
			clickToElement(driver, ServicesPageUI.RECALL_LAW_ACTIVE_TOGGLE);
			waitToElementClickable(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			clickToElement(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			clickToElement(driver, ServicesPageUI.RECALL_LAW_TOGGLE);
			scrollToBottom(driver);
			sendkeyToElement(driver, ServicesPageUI.RECALL_TIME_TXT, "2");
			sendkeyToElement(driver, ServicesPageUI.ASSIGN_RECALL_TIME_TXT, "2");
			selectItemInCustomDropdown(driver, ServicesPageUI.RECALL_ASSIGN_MEMBER_DROP, ServicesPageUI.LIST_MEMBER_DROP, "Admin (admin@testauto)");
			waitToElementClickable(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			clickToElement(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		} else {
			clickToElement(driver, ServicesPageUI.RECALL_LAW_TOGGLE);
			scrollToBottom(driver);
			sendkeyToElement(driver, ServicesPageUI.RECALL_TIME_TXT, "2");
			sendkeyToElement(driver, ServicesPageUI.ASSIGN_RECALL_TIME_TXT, "2");
			selectItemInCustomDropdown(driver, ServicesPageUI.RECALL_ASSIGN_MEMBER_DROP, ServicesPageUI.LIST_MEMBER_DROP, "Admin (admin@testauto)");
			waitToElementClickable(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			clickToElement(driver, ServicesPageUI.ASSIGNMENT_CONFIG_SAVE_BTN);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		}
	}

	public void chooseTeamAndMemberToView(String memberAccount, String otherMemberAccount, String teamName) {
		clickToElement(driver, ServicesPageUI.TEAM_NAME_DROP, memberAccount);
		waitToElementVisible(driver, ServicesPageUI.LIST_MEMBER_DROP);
    	sleepInSecond(1);
		if (!isElementDisplayed(driver, ServicesPageUI.LIST_OF_TEAM_CHECKED_ITEM, teamName)) {
			clickToElement(driver, ServicesPageUI.LIST_OF_TEAM, teamName);
			clickToElement(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, "Lưu");
			sleepInSecond(1);
		}
		clickToElement(driver, ServicesPageUI.MEMBER_ACC_DROP, memberAccount);
		waitToElementVisible(driver, ServicesPageUI.LIST_MEMBER_DROP);
		if (!isElementDisplayed(driver, ServicesPageUI.LIST_OF_ACC_CHECKED_ITEM, otherMemberAccount)) {
			clickToElement(driver, ServicesPageUI.LIST_OF_ACC, otherMemberAccount);
			clickToElement(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, "Lưu");
			sleepInSecond(1);
		}
	}

	public List<String> getListPageNameOfATeam(String socialNetworkName) {
		List<String> listConfiguredPage = new ArrayList<>();
		waitToElementVisible(driver, ServicesPageUI.LIST_SOCIAL_PAGE_NAME_CHECKED_ITEM, socialNetworkName);
		List<WebElement> configuredPageList = findElementsByXpath(driver, ServicesPageUI.LIST_SOCIAL_PAGE_NAME_CHECKED_ITEM, socialNetworkName);
		for (WebElement configuredPage : configuredPageList) {
			listConfiguredPage.add(configuredPage.getText());
		}
		System.out.println("List social page: " + listConfiguredPage);
		return listConfiguredPage;
	}

	public void getPagesListSocialNetwork(String socialNetworkName) {
		scrollToBottom(driver);
		sleepInSecond(3);
		listTemp = getListPageNameOfATeam(socialNetworkName);
		sleepInSecond(3);
	}

	public void selectPageName(String pageName, String socialName) {
		if (isElementDisplayed(driver, ServicesPageUI.SOCIAL_ARROW_ICON, socialName)) {
			waitToElementClickable(driver, ServicesPageUI.SOCIAL_PAGE_NAME_ITEM, pageName);
			scrollToElement(driver, ServicesPageUI.SOCIAL_PAGE_NAME_ITEM, pageName);
			clickToElement(driver, ServicesPageUI.SOCIAL_PAGE_NAME_ITEM, pageName);
		} else {
			scrollToElement(driver, ServicesPageUI.SOCIAL_NAME, socialName);
			waitToElementClickable(driver, ServicesPageUI.SOCIAL_NAME, socialName);
			clickToElement(driver, ServicesPageUI.SOCIAL_NAME, socialName);
			waitToElementClickable(driver, ServicesPageUI.SOCIAL_PAGE_NAME_ITEM, pageName);
			scrollToElement(driver, ServicesPageUI.SOCIAL_PAGE_NAME_ITEM, pageName);
			clickToElement(driver, ServicesPageUI.SOCIAL_PAGE_NAME_ITEM, pageName);
		}
	}

	public void createNewBehaviorTag(String tagName) {
		newTagName = tagName + " " + randomNumber();
		sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX, newTagName, "Nhập nội dung");
		sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTAREA, newTagName, "Nhập nội dung");
		clickToElement(driver, CommonPageUI.DYNAMIC_BUTTON, "Lưu");

	}
}
