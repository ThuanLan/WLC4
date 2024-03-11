package mobio.services.pageObjects;

import org.openqa.selenium.WebDriver;

import autolibraries.mobioLibs;
import commons.GlobalConstants;
import commons.SvDataTest;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageUIs.SvOtherFunctionsPageUI;
import mobio.services.pageUIs.SvWlcCounterPageUI;

/**
 * The Class HomePageObject.
 */
public class SvOtherFunctionPageObject extends mobioLibs {

    /**
     * The driver.
     */
    WebDriver driver;
    public static String ticketName;
    public static String noteContent;
    public static String dealName;
    String email = "mobio" + randomNumber() + "@mobio.vn";
    String configAtributeValue;

    /**
     * Instantiates a new home page object.
     *
     * @param _driver the driver
     */
    public SvOtherFunctionPageObject(WebDriver _driver) {
        driver = _driver;

    }

    public void clickAddDealButton() {
        sleepInSecond(5);
        waitToElementClickable(driver, SvOtherFunctionsPageUI.DYNAMIC_ADD_BUTTON, "Thêm cơ hội bán ");
        clickToElement(driver, SvOtherFunctionsPageUI.DYNAMIC_ADD_BUTTON, "Thêm cơ hội bán ");
    }

    public void addDealInfo() {
        dealName = "Deal " + randomNumber();
        System.out.println("in ra " + dealName);
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        sendkeyToElement(driver, CommonPageUI.DYNAMIC_MODAL_TXT, dealName,"Tên Cơ hội bán");
        sendkeyToElement(driver, CommonPageUI.DYNAMIC_MODAL_TXT, "1000000", "Giá trị Cơ hội bán");
        scrollToElement(driver, CommonPageUI.ITEM_DROP, "Trạng thái Cơ hội bán");
        selectItemInCustomDropdownBySearching(driver, getOverloadingLocator(CommonPageUI.ITEM_DROP, "Trạng thái Cơ hội bán"), CommonPageUI.ALL_ITEM_DROP, CommonPageUI.ITEM_SEARCH_DROP, "Liên lạc");
        clickToElement(driver, CommonPageUI.DYNAMIC_LBL,"Trạng thái Cơ hội bán");
        scrollToElement(driver, CommonPageUI.DYNAMIC_LBL,"Thông tin Khách hàng");
        selectItemInCustomDropdownBySearching(driver, getOverloadingLocator(CommonPageUI.CHECKBOX_DROP,"Profile"), CommonPageUI.ALL_ITEM_CHECKBOX_DROP, getOverloadingLocator(CommonPageUI.CHECKBOX_DROP,"Profile"), GlobalConstants.PROFILE_NAME);
        clickToElement(driver, CommonPageUI.DYNAMIC_LBL, "Profile");
		sleepInSecond(1);
    }

    public void addTicketInfo() {
        SvDataTest dataTest;
        dataTest = SvDataTest.getSvDataTest();
        ticketName = "Ticket " + randomNumber();
        waitToElementVisible(driver, SvOtherFunctionsPageUI.DYNAMIC_TEXTBOX, "Tên ticket");
        sendkeyToElement(driver, SvOtherFunctionsPageUI.DYNAMIC_TEXTBOX, ticketName, "Tên ticket");

		selectItemInCustomDropdownBySearching(driver, getOverloadingLocator(SvOtherFunctionsPageUI.ADD_PARENT_DROP, "Trạng thái xử lý", "Chọn thông tin"), SvOtherFunctionsPageUI.ADD_CHILD_LIST_DROP, SvOtherFunctionsPageUI.ADD_NEW_SEARCH_TXT, "Mở");

		selectItemInCustomDropdownBySearching(driver, getOverloadingLocator(SvOtherFunctionsPageUI.ADD_PARENT_DROP, "Kiểu ticket", "Chọn thông tin"), SvOtherFunctionsPageUI.ADD_CHILD_LIST_DROP, SvOtherFunctionsPageUI.ADD_NEW_SEARCH_TXT, "Khác");

		selectItemInCustomDropdownBySearching(driver, getOverloadingLocator(SvOtherFunctionsPageUI.ADD_PARENT_DROP, "Mức độ ưu tiên", "Chọn thông tin"), SvOtherFunctionsPageUI.ADD_CHILD_LIST_DROP, SvOtherFunctionsPageUI.ADD_NEW_SEARCH_TXT, "Cao");
		
		waitToElementVisible(driver, getOverloadingLocator(SvOtherFunctionsPageUI.ADD_STAFF_IN_CHARGE_DROP, "Nhân viên phụ trách", "Chọn thông tin"));
		scrollToElement(driver, getOverloadingLocator(SvOtherFunctionsPageUI.ADD_STAFF_IN_CHARGE_DROP, "Nhân viên phụ trách", "Chọn thông tin"));
		selectItemInCustomDropdownBySearching(driver, getOverloadingLocator(SvOtherFunctionsPageUI.ADD_STAFF_IN_CHARGE_DROP, "Nhân viên phụ trách", "Chọn thông tin"), SvOtherFunctionsPageUI.ADD_CHILD_LIST_DROP, SvOtherFunctionsPageUI.ADD_NEW_SEARCH_TXT, dataTest.getMemberAcc());

		waitToElementVisible(driver, SvOtherFunctionsPageUI.ADD_STAFF_PROFILE_DROP, "Profile", "Nhập họ và tên,");
		scrollToElement(driver, SvOtherFunctionsPageUI.ADD_STAFF_PROFILE_DROP, "Profile", "Nhập họ và tên,");
		selectItemInCustomDropdownBySearching(driver, getOverloadingLocator(SvOtherFunctionsPageUI.ADD_STAFF_PROFILE_DROP, "Profile", "Nhập họ và tên,"), SvOtherFunctionsPageUI.ADD_CHILD_LIST_CHECKBOX, getOverloadingLocator(SvOtherFunctionsPageUI.ADD_STAFF_PROFILE_DROP, "Profile", "Nhập họ và tên,"),
				GlobalConstants.PROFILE_NAME);
		clickToElement(driver, SvOtherFunctionsPageUI.ADD_NEW_LBL, "Profile");

    }

    public void clickTicketIcon() {
        waitToElementClickable(driver, SvOtherFunctionsPageUI.DYNAMIC_TAB, "ticket");
        clickToElement(driver, SvOtherFunctionsPageUI.DYNAMIC_TAB, "ticket");
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
    }

    public void clickDealIcon() {
        waitToElementClickable(driver, SvOtherFunctionsPageUI.DYNAMIC_TAB, "deal");
        clickToElement(driver, SvOtherFunctionsPageUI.DYNAMIC_TAB, "deal");
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
    }

    public void clickAddTicketButton() {
        sleepInSecond(10);
        waitToElementClickable(driver, SvOtherFunctionsPageUI.DYNAMIC_ADD_BUTTON, "Thêm Ticket");
        clickToElement(driver, SvOtherFunctionsPageUI.DYNAMIC_ADD_BUTTON, "Thêm Ticket");
    }

    public void clickNoteIcon() {
        waitToElementClickable(driver, SvOtherFunctionsPageUI.DYNAMIC_TAB, "note");
        clickToElement(driver, SvOtherFunctionsPageUI.DYNAMIC_TAB, "note");
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
    }

    public void clickAddNoteButton() {
        waitToElementClickable(driver, SvOtherFunctionsPageUI.DYNAMIC_ADD_BUTTON, "Thêm ghi chú");
        clickToElement(driver, SvOtherFunctionsPageUI.DYNAMIC_ADD_BUTTON, "Thêm ghi chú");
    }

    public void sendNoteInfo() {
    	sleepInSecond(5);
    	backToDefault(driver);
        noteContent = "Create and update new note " + randomNumber();
		System.out.println("Note content kt " + noteContent);
        sendkeyToElement(driver, SvOtherFunctionsPageUI.NOTE_TEXTA, noteContent);
    }

    public void updateProfileInfo() {
        waitToElementVisible(driver, SvWlcCounterPageUI.EDIT_PROFILE_EMAIL_TXT);
        sendkeyToElement(driver, SvWlcCounterPageUI.EDIT_PROFILE_EMAIL_TXT, email);
        sendkeyToElement(driver, SvWlcCounterPageUI.EDIT_PROFILE_PHONE_TXT, "0989091655");
    }

    public boolean checkUpdatedProfile() {
        String redirectedUrl = getCurrentPageUrl(driver);
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
        boolean redirectedOK = redirectedUrl.contains(GlobalConstants.UAT_URL + "/profiles");
        boolean emailbl = isElementDisplayed(driver, SvWlcCounterPageUI.UPDATED_PROFILE_EMAIL_TXT, email);
        boolean phonebl = isElementDisplayed(driver, SvWlcCounterPageUI.UPDATED_PROFILE_PHONE_TXT, "989091655");
        System.out.println("gia tri " + redirectedOK + " email " + emailbl + "phone " + phonebl);
        return emailbl & phonebl & redirectedOK;
    }

    public boolean isUpdatedProfileAtColumn3() {
        sleepInSecond(3);
        System.out.println("Thông tin email hiển thị " + email);
        boolean emailbl = isElementDisplayed(driver, SvWlcCounterPageUI.COLUMN3_PROFILE_EMAIL_LBL, email);

        boolean phonebl = isElementDisplayed(driver, SvWlcCounterPageUI.COLUMN3_PROFILE_PHONE_LBL, "989091655");
        System.out.println("Số điện thoại " + emailbl + phonebl);
        return emailbl & phonebl;
    }

    public boolean checkConfig() {
        System.out.println("Giá trị atribute ghi chu  " + configAtributeValue);
        String getSortOrder = getAtribute(driver, SvWlcCounterPageUI.CONFIG_SORT_ORDER, "class");
        return getSortOrder.contains(configAtributeValue);
    }

    public void configSettingsValue(String infoNeedShowing) {
        waitToElementClickable(driver, SvWlcCounterPageUI.CONFIG_INFO_RADIO, infoNeedShowing);
        clickToElement(driver, SvWlcCounterPageUI.CONFIG_INFO_RADIO, infoNeedShowing);

        switch (infoNeedShowing) {
            case "Ghi chú":
                configAtributeValue = "mo-icn-cancelling-note";
                break;
            case "Thông tin Profile":
                configAtributeValue = "mo-icn-personal-n-brand";
                break;
            case "Ticket":
                configAtributeValue = "mo-icn-ticket";
                break;
            case "Đơn hàng":
                configAtributeValue = "mo-icn-deal-activity";
                break;
            default:
                configAtributeValue = "can not found!";
        }
    }

}
