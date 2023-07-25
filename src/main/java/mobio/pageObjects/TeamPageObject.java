package mobio.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;

import autolibraries.mobioLibs;
import mobio.pageUIs.CommonPageUI;
import mobio.pageUIs.TeamPageUI;
import mobio.services.pageUIs.SvWlcCounterPageUI;

public class TeamPageObject extends mobioLibs {

	/** The driver. */
	WebDriver driver;
	public static List<String> getListContent;

	public TeamPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void hoverOnTeamMember(String groupName) {
		sleepInSecond(5);
		hoverMouseToElement(driver, TeamPageUI.AUTO_TEAM_MEMBER, groupName);
		clickToElement(driver, TeamPageUI.EDIT_TEAM_BTN, groupName);
		sleepInSecond(3);
		scrollToBottom(driver);
		getListContent = getListItemsInDropdown(driver, TeamPageUI.TEAM_ALL_ITEM);
		sleepInSecond(3);
		clickToElement(driver, CommonPageUI.CLOSE_DIALOG_TEAM_BTN);
	}

	public boolean isCompareRecipientMemberListDrop() {
		List<String> getAccountList = getListItemsInDropdown(driver, SvWlcCounterPageUI.LIST_FORWARD_MEMBER_DROP);
		return isCompare2Lists(driver,getAccountList, getListContent);
	}

}
