package mobio.pageObjects;

import org.openqa.selenium.WebDriver;

import autolibraries.mobioLibs;
import commons.GlobalConstants;
import commons.SvDataTest;
import mobio.pageUIs.CommonPageUI;
import mobio.pageUIs.LoginPageUI;

public class LoginPageObject extends mobioLibs {

    WebDriver driver;
    SvDataTest accountTest;
    CommonPageObject commonPage;

    /**
     * Instantiates a new login page object.
     *
     * @param _driver the driver
     */
    public LoginPageObject(WebDriver _driver) {
        driver = _driver;
        commonPage = PageGeneratorManager.getCommonPage(driver);
    }

    /**
     * Input to user ID textbox.
     *
     * @param userID the user ID
     */
    public void inputToUserIDTextbox(String userID) {
        waitToElementVisible(driver, LoginPageUI.USER_NAME_TXT);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_TXT, userID);
    }

    /**
     * Input to password textbox.
     *
     * @param password the password
     */
    public void inputToPasswordTextbox(String password) {
        waitToElementVisible(driver, LoginPageUI.PASSWORD_TXT);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
    }

    /**
     * Click to Login button.
     */
    public void clickToLoginButton() {
        waitToElementClickable(driver, LoginPageUI.LOGIN_BTN);
        clickToElementByJS(driver, LoginPageUI.LOGIN_BTN);
    }

    /**
     * Login as user.
     *
     * @param userID   the user ID
     * @param password the password
     */
    public void loginAsAnUser(String userID, String password) {
        inputToUserIDTextbox(userID);
        inputToPasswordTextbox(password);
        clickToLoginButton();
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
    }

    public void loginToMobio(String userID) {
        accountTest = SvDataTest.getSvDataTest();
        inputToUserIDTextbox(userID);
        inputToPasswordTextbox(accountTest.getPassword());
        clickToLoginButton();
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
    }

    public void loginAsAnAccount(String userID) {
        loginToMobio(commonPage.getAccount(userID));
    }

    public void goToMobioSiteByAnAccount(String account) {
        switchToWindowByTitle(driver, "Mobio - CDP & CEM Platform");
        login(commonPage.getAccount(account));
    }

    public void login(String account) {
        if (!getCurrentPageUrl(driver).contains("/login")) {
            openUrl(driver, GlobalConstants.UAT_URL);
            waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        }
        if (isElementDisplayed(driver, CommonPageUI.ACCOUNT_AVATAR_BTN)) {
            waitToElementClickable(driver, CommonPageUI.ACCOUNT_AVATAR_BTN);
            clickToElementByJS(driver, CommonPageUI.ACCOUNT_AVATAR_BTN);
            sleepInSecond(1);
            if (isElementDisplayed(driver, CommonPageUI.LOGIN_ACCOUNT_LBL, account)) {
            	refreshPage(driver);
            	waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
            } else {
                waitToElementClickable(driver, CommonPageUI.ACCOUNT_LOGOUT_MENU);
                clickToElementByJS(driver, CommonPageUI.ACCOUNT_LOGOUT_MENU);
                sleepInSecond(1);
                loginAsAnUser(account, GlobalConstants.PASSWORD);
            }
        } else {
            logoutMobioSite();
            loginAsAnUser(account, GlobalConstants.PASSWORD);
        }
    }

    public void logoutMobioSite() {
    	refreshPage(driver);
    	sleepInSecond(3);
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        if (!(getCurrentPageUrl(driver).contains("/login"))) {
            waitToElementClickable(driver, CommonPageUI.ACCOUNT_AVATAR_BTN);
            clickToElementByJS(driver, CommonPageUI.ACCOUNT_AVATAR_BTN);
            sleepInSecond(3);
            waitToElementClickable(driver, CommonPageUI.ACCOUNT_LOGOUT_MENU);
            clickToElementByJS(driver, CommonPageUI.ACCOUNT_LOGOUT_MENU);
            waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        }
    }
}
