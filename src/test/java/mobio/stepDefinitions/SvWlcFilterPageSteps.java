package mobio.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageObjects.SvWebLiveChatPageObject;
import mobio.services.pageObjects.SvWlcFilterPageObject;
import mobio.services.pageUIs.SvWlcCounterPageUI;
import mobio.services.pageUIs.SvWlcFilterPageUI;

public class SvWlcFilterPageSteps {
    WebDriver driver;
    SvWlcFilterPageObject wlcFilterPage;

    public SvWlcFilterPageSteps() {
        driver = Hooks.getAndCloseBrowser();
        wlcFilterPage = PageGeneratorManager.getSvFbWlcFilterPage(driver);
    }

    @Then("^Verify content of searching$")
    public void verifyContentOfSearching() {
        Assert.assertTrue(wlcFilterPage.isContentInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM,
                SvWebLiveChatPageObject.wlcMessage));
    }

    @Then("^Verify content of searching at column2$")
    public void verifyContentOfSearching2() {
        wlcFilterPage.hoverMouseToElement(driver, SvWlcFilterPageUI.SEARCH_COLUMN2_BTN);
        wlcFilterPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        Assert.assertNotEquals("0/0", wlcFilterPage.getTextElement(driver, SvWlcFilterPageUI.SEARCH_RESULT_LBL));
        System.out.println(SvWebLiveChatPageObject.wlcMessage);
        System.out.println("Get text cột 2 " + wlcFilterPage.getTextElement(driver, SvWlcCounterPageUI.CONTENT_IN_COLUMN2_LBL));
        Assert.assertEquals(SvWebLiveChatPageObject.wlcMessage, wlcFilterPage.getTextElement(driver, SvWlcCounterPageUI.CONTENT_IN_COLUMN2_LBL));
    }

    @Then("^Verify invalid content of searching at column2$")
    public void verifyInvalidContentOfSearching2() {
        wlcFilterPage.hoverMouseToElement(driver, SvWlcFilterPageUI.SEARCH_COLUMN2_BTN);
        wlcFilterPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        Assert.assertEquals("0/0", wlcFilterPage.getTextElement(driver, SvWlcFilterPageUI.SEARCH_RESULT_LBL));
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.NO_RESULT_SEARCH_LBL));
    }

    @Then("^Verify icon active status is dispplayed$")
    public void verifyIconActiveIsDisplayed() {
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.ACTIVE_STATUS_ICON_COLUMN1));
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.ACTIVE_STATUS_ICON_COLUMN2));

    }

    @Then("^Verify icon active status is undisplayed$")
    public void verifyIconActiveIsUnDisplayed() {
        wlcFilterPage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
        wlcFilterPage.sleepInSecond(3);
        Assert.assertTrue(wlcFilterPage.isElementUndisplayed(driver, SvWlcFilterPageUI.ACTIVE_STATUS_ICON_COLUMN1));
        Assert.assertTrue(wlcFilterPage.isElementUndisplayed(driver, SvWlcFilterPageUI.ACTIVE_STATUS_ICON_COLUMN2));
    }

    @Then("^Verify infor access web is displayed column1$")
    public void verifyInforAccessWebIsDisplayedColumn1() {
    	Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.INFOR_WEB_ACCESS_VERSION_COLUMN1));
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.INFOR_WEB_ACCESS_PAGE_COLUMN1));
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.INFOR_WEB_ACCESS_VERSION_COLUMN1));
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.INFOR_WEB_ACCESS_TIME_COLUMN1));

    }

    @And("^Click infor access web button$")
    public void clickInforAccessWebButton() {
        wlcFilterPage.clickInforAccessWebButton();
    }

    @Then("^Verify infor access web is displayed column2$")
    public void verifyInforAccessWebIsDisplayedColumn2() {
        wlcFilterPage.sleepInSecond(3);
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.INFOR_WEB_ACCESS_PAGE_COLUMN2));
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.INFOR_WEB_ACCESS_VERSION_COLUMN2));
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.INFOR_WEB_ACCESS_TIME_COLUMN2));

    }

    @Then("^Verify the feature of selected wlc$")
    public void verifyTheFeatureOfSelectedComment() {
        Assert.assertTrue(wlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN));
        Assert.assertFalse(wlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.FB_REPLY_TXTA));
        Assert.assertFalse(wlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.FB_ADD_PICTURE_BTN));
    }

    @Then("^Verify the feature of selected wlc of member in another team$")
    public void verifyTheFeatureOfSelectedCommentOfMemberOfAnotherTeam() {
        Assert.assertFalse(wlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN));
        Assert.assertFalse(wlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.FB_REPLY_TXTA));
        Assert.assertFalse(wlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.FB_ADD_PICTURE_BTN));
    }
    
}
