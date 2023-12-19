package mobio.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageObjects.SvWebLiveChatPageObject;
import mobio.services.pageObjects.SvWlcCounterPageObject;
import mobio.services.pageUIs.SvWlcCounterPageUI;

public class SvWlcCounterPageSteps {
    WebDriver driver;
    SvWlcCounterPageObject svWlcCounterPage;

    public SvWlcCounterPageSteps() {
        driver = Hooks.getAndCloseBrowser();
        svWlcCounterPage = PageGeneratorManager.getSvWlcCounterPage(driver);
    }

    @And("^Hold top message$")
    public void holdTopMessage() {
        svWlcCounterPage.holdTopMessage();
    }

    @Then("^Verify \"([^\"]*)\" is displayed$")
    public void verifyMessageIsDisplayed(String pageName) {
        Assert.assertTrue(svWlcCounterPage.isElementDisplayed(driver, SvWlcCounterPageUI.PAGE_NAME_DYNAMIC, pageName));
    }

    @And("^Click on the message tab$")
    public void clickOnTheMessageTab() {
        svWlcCounterPage.clickOnTheMessageTab("Tin nhắn");
    }

    @Then("^Verify item count is increased by one$")
    public void verifyItemCountIncreasedOne() {
        svWlcCounterPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        String commentBefore = SvWlcCounterPageObject.itemCount;
        svWlcCounterPage.sleepInSecond(10);
        String commentNumberAfter = svWlcCounterPage.getTextElement(driver,
                SvWlcCounterPageUI.SOCIAL_TAB_NUMBER_LBL, "Tin nhắn");
        System.out.println(commentNumberAfter);
        Assert.assertEquals(Integer.parseInt(commentBefore), (Integer.parseInt(commentNumberAfter) - 1));
    }

    @Then("^Verify item count is unchanged$")
    public void verifyItemCountUnchanged() {

        String commentBefore = SvWlcCounterPageObject.itemCount;
        svWlcCounterPage.sleepInSecond(30);
        String commentNumberAfter = svWlcCounterPage.getTextElement(driver,
                SvWlcCounterPageUI.SOCIAL_TAB_NUMBER_LBL, "Tin nhắn");
        Assert.assertEquals(Integer.parseInt(commentBefore), Integer.parseInt(commentNumberAfter));
    }

    @Then("^Verify item count is reduced by one$")
    public void verifyItemCountReducedOne() {
        String commentBefore = SvWlcCounterPageObject.itemCount;
        svWlcCounterPage.sleepInSecond(20);
        String commentNumberAfter = svWlcCounterPage.getTextElement(driver,
                SvWlcCounterPageUI.SOCIAL_TAB_NUMBER_LBL, "Tin nhắn");
        Assert.assertEquals(Integer.parseInt(commentBefore), Integer.parseInt(commentNumberAfter) + 1);
    }

    @And("^Click on Notify icon$")
    public void clickOnNotifyIcon() {
        svWlcCounterPage.backToDefault(driver);
        svWlcCounterPage.clickToElement(driver, SvWlcCounterPageUI.NOTIFY_ICON);
        svWlcCounterPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
    }

    @Then("^Verify notification after that$")
    public void verifyNotificationAfterThat() {
        svWlcCounterPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        svWlcCounterPage.sleepInSecond(20);
        Assert.assertEquals(SvWebLiveChatPageObject.wlcMessage,
                svWlcCounterPage.getTextElement(driver, SvWlcCounterPageUI.NOTIFY_COMMENT_CONTENT).trim());
    }

    @And("^Click on the Notification$")
    public void clickOnNotification() {
        svWlcCounterPage.clickToNewItemOnNotifications();
    }

    @Then("^Verify item jumps to list and column2$")
    public void verifyWlcJumpToListAndColumn2() {
    	svWlcCounterPage.backToDefault(driver);
    	svWlcCounterPage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
        Assert.assertTrue(svWlcCounterPage.isCommentJumpToList());
        Assert.assertTrue(svWlcCounterPage.isCommentOnColumn2());
    }

    @Then("^Verify disable wlc in list and column2$")
    public void verifyNoWlcJumpToListAndColumn2() {
        Assert.assertFalse(svWlcCounterPage.isCommentJumpToList());
        Assert.assertFalse(svWlcCounterPage.isCommentOnColumn2());
    }

    @Then("^Verify the focus for new item$")
    public void verifyTheFocusForNewItem() {
        svWlcCounterPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        svWlcCounterPage.sleepInSecond(60);
        Assert.assertEquals(SvWebLiveChatPageObject.wlcMessage, svWlcCounterPage.getTextElement(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_FOCUSED_ITEM));
    }

}
