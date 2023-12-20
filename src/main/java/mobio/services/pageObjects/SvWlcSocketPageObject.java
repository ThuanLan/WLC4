package mobio.services.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;

import autolibraries.mobioLibs;
import mobio.services.pageUIs.SvWlcCounterPageUI;

public class SvWlcSocketPageObject extends mobioLibs {
    WebDriver driver;
    public static String getContentInTop;

    public SvWlcSocketPageObject(WebDriver _driver) {
        driver = _driver;
    }

    public void clickOnTheTopItem() {
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_ICON)) {
            int countPin = countAllItemInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_ICON);
            String locator = SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM + '[' + (countPin + 1) + ']';
            waitToElementClickable(driver, locator);
            clickToElement(driver, locator);
            getContentInTop = getTextElement(driver, locator);
        } else {
            String locator = SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM + "[" + 1 + "]";
            waitToElementClickable(driver, locator);
            clickToElement(driver, locator);
            getContentInTop = getTextElement(driver, locator);
        }
    }


    /**
     * Checks if is team manage page.
     *
     * @return true, if is team manage page
     */
    public boolean isTeamManagePage() {
        List<String> listOfTeam = getListItemsInDropdown(driver, SvWlcCounterPageUI.LIST_FORWARD_GROUP_DROP);
        return listOfTeam.contains("Auto_Thuannt");

    }

    /**
     * Assign task to user.
     *
     * @param userAccount the user account
     */
    public void assignTaskToUser(String userAccount) {
        waitToElementVisible(driver, SvWlcCounterPageUI.ASSIGNED_DROP);
        selectItemInCustomDropdownByPass(driver, SvWlcCounterPageUI.ASSIGNED_DROP,
                SvWlcCounterPageUI.ASSIGNED_ALL_ITEMS_DROP, userAccount);
    }
}
