package mobio.pageObjects;

import org.openqa.selenium.WebDriver;

import mobio.services.pageObjects.ServicesPageObject;
import mobio.services.pageObjects.SvOtherFunctionPageObject;
import mobio.services.pageObjects.SvWlcCounterPageObject;
import mobio.services.pageObjects.SvWlcFilterPageObject;
import mobio.services.pageObjects.SvWlcSocketPageObject;
import mobio.services.pageObjects.SvWebLiveChatPageObject;
import mobio.services.pageObjects.SvWlcMessagePageObject;

public class PageGeneratorManager {


    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static CommonPageObject getCommonPage(WebDriver driver) {
        return new CommonPageObject(driver);
    }

    public static TeamPageObject getTeamPage(WebDriver driver) {
        return new TeamPageObject(driver);
    }

    public static SettingsPageObject getSettingsPage(WebDriver driver) {
        return new SettingsPageObject(driver);
    }

    public static ServicesPageObject getServicesPage(WebDriver driver) {
        return new ServicesPageObject(driver);
    }

    public static SvWebLiveChatPageObject getWebLiveChatPage(WebDriver driver) {
        return new SvWebLiveChatPageObject(driver);
    }

    public static SvWlcMessagePageObject getWlcMessagePage(WebDriver driver) {
        return new SvWlcMessagePageObject(driver);
    }

    // add message maiht

    public static SvWlcCounterPageObject getSvWlcCounterPage(WebDriver driver) {
        return new SvWlcCounterPageObject(driver);
    }

    public static SvWlcFilterPageObject getSvFbWlcFilterPage(WebDriver driver) {
        return new SvWlcFilterPageObject(driver);
    }

    public static SvWlcSocketPageObject getSvFbWlcSocketPage(WebDriver driver) {
        return new SvWlcSocketPageObject(driver);
    }

    public static SvOtherFunctionPageObject getSvOtherFunctionPage(WebDriver driver) {
        return new SvOtherFunctionPageObject(driver);
    }
}
