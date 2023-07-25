package mobio.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import mobio.pageObjects.PageGeneratorManager;
import mobio.services.pageObjects.SvWebLiveChatPageObject;
import mobio.services.pageObjects.SvWlcSocketPageObject;
import mobio.services.pageUIs.SvWlcCounterPageUI;

public class SvWlcSocketPageSteps {
    WebDriver driver;
    SvWlcSocketPageObject wlcSocketPage;

    public SvWlcSocketPageSteps() {
        driver = Hooks.getAndCloseBrowser();
        wlcSocketPage = PageGeneratorManager.getSvFbWlcSocketPage(driver);

    }

    @Then("^Verify the task assignment message wlc$")
    public void verifyTheTaskAssignment() {
        wlcSocketPage.sleepInSecond(10);
        Assert.assertTrue(wlcSocketPage.isContentInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM,
                SvWlcSocketPageObject.getContentInTop));
    }

    @Then("^Verify redirection of the link task wlc$")
    public void verifyTheTaskRedirection() {
        wlcSocketPage.clickToElement(driver, SvWlcCounterPageUI.MESSAGE_TEXT_IN_COLUMN2_LBL);
        wlcSocketPage.switchToNewTab(driver);
        System.out.println(SvWebLiveChatPageObject.wlcMessage);
        System.out.println(wlcSocketPage.getCurrentPageUrl(driver));
        Assert.assertTrue(wlcSocketPage.getCurrentPageUrl(driver).contains(SvWebLiveChatPageObject.wlcMessage));
    }
}
