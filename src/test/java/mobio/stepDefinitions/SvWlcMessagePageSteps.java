package mobio.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.GlobalConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageObjects.SvWebLiveChatPageObject;
import mobio.services.pageObjects.SvWlcCounterPageObject;
import mobio.services.pageObjects.SvWlcMessagePageObject;
import mobio.services.pageUIs.SvWlcCounterPageUI;
import mobio.services.pageUIs.SvWlcMessagePageUI;

public class SvWlcMessagePageSteps {
    WebDriver driver;
    SvWlcMessagePageObject wlcMessagePage;
    SvWlcCounterPageObject svWlcCounterPage;

    public SvWlcMessagePageSteps() {
        driver = Hooks.getAndCloseBrowser();
        wlcMessagePage = PageGeneratorManager.getWlcMessagePage(driver);
        svWlcCounterPage = PageGeneratorManager.getSvWlcCounterPage(driver);
    }

    @When("^Click on wlc icon$")
    public void clickOnWlcIcon() {
        wlcMessagePage.clickToElement(driver, SvWlcMessagePageUI.WLC_ICON);
        wlcMessagePage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
    }

    @And("^Click one unanswer wlc item$")
    public void clickOneUnanswerItem() {
        wlcMessagePage.sleepInSecond(5);
        wlcMessagePage.clickOneWlc(SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_NOT_REPLY);
        wlcMessagePage.sleepInSecond(3);
    }

    @And("^Click one wlc item$")
    public void clickOneWlcItem() {
        wlcMessagePage.clickOneWlc(SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM);
        wlcMessagePage.sleepInSecond(3);
    }

    @And("^Click one wlc item to add tag$")
    public void clickOneWlcItemToAddTag() {
        wlcMessagePage.clickOneWlcToAddTag(SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM);
        wlcMessagePage.sleepInSecond(3);
    }
    
    @And("^Copy and paste text to reply$")
	public void copyAndPasteTextToReply() {
    	svWlcCounterPage.copyAndPasteText();
	}


    @Then("^Verify position of the wlc item$")
    public void verifyPositionOfTheItem() {
        Assert.assertTrue(wlcMessagePage.isPositionOfTheItem());
    }


    @Then("^Verify the content of a replied item$")
    public void verifyTheContentOfARepliedItem() {
        wlcMessagePage.clickOnAvatar();
        wlcMessagePage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
        Assert.assertTrue(wlcMessagePage.isReplyData());
    }

    @Then("^Verify the content of a quick replied wlc message$")
    public void verifyTheContentOfAQuickRepliedWlc() {
        wlcMessagePage.clickOnAvatar();
        wlcMessagePage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
        Assert.assertTrue(wlcMessagePage.isQuickRepliedWlc());
    }

    @Then("^Verify the content of a replied item by \"([^\"]*)\" team member$")
    public void verifyTheContentOfARepliedItemByTeamMember(String userid) {
        Assert.assertTrue(wlcMessagePage.isReplyByTeamMember(userid));
    }

    @Then("^Verify the content of a replied item by \"([^\"]*)\" in another team member$")
    public void verifyTheContentOfARepliedItemInOTherTeam(String userid) {
        Assert.assertTrue(wlcMessagePage.isReplyByOtherTeamMember(userid));
    }

    @And("^Click old item that replied$")
    public void clickOldItemThatReplied() {
        svWlcCounterPage.ClickOldRepliedItem();
    }

    @Then("^Verify the replied item by another team member then view it by the customer$")
    public void verifyRepliedItemAnotherTeamByCustomer() {
        Assert.assertTrue(wlcMessagePage.isRepliedItemAnotherTeamByCustomer());
    }

    @Then("^Verify the replied item by team member then view it by the customer$")
    public void verifyRepliedItemTeamByCustomer() {
        Assert.assertTrue(wlcMessagePage.isRepliedItemInTeamByCustomer());
    }

    @And("^Click old wlc message$")
    public void clickOldWlcItem() {
        wlcMessagePage.clickOldWlcItem();
        wlcMessagePage.sleepInSecond(3);
    }

    @Then("^Verify list of team member$")
    public void verifListOfTeamMember() {
    	wlcMessagePage.sleepInSecond(10);
    	//System.out.println("Giá trị nội dung mới tạo wlc " + SvWebLiveChatPageObject.wlcMessage);
    	Assert.assertTrue(wlcMessagePage.isContentInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM, SvWlcMessagePageObject.getContent));
    }
    
    @Then("^Verify wlc list of team member$")
    public void verifyWlcListOfTeamMember() {
        wlcMessagePage.sleepInSecond(10);
       // System.out.println("Giá trị nội dung mới tạo wlc " + SvWebLiveChatPageObject.wlcMessage);
        Assert.assertTrue(wlcMessagePage.isContentInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM,  SvWebLiveChatPageObject.wlcMessage));
    }

    @Then("^Verify wlc list of team member after receiving an item$")
    public void verifyWlcListOfTeamMemberAfterReceivingAnItem() {
        //System.out.println("Giá trị nội dung cần so sánh " + SvWlcMessagePageObject.getContent);
        wlcMessagePage.sleepInSecond(10);
        Assert.assertTrue(wlcMessagePage.isContentInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM, SvWlcMessagePageObject.getContent));
    }

    @Then("^Verify disable wlc in list$")
    public void verifyDisableCommentInListComments() {
        wlcMessagePage.sleepInSecond(15);
        System.out.println("Giá tri cần so sánh: " + wlcMessagePage.formatInputedText(SvWlcMessagePageObject.getContent));
        Assert.assertFalse(wlcMessagePage.isContentInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM, SvWlcMessagePageObject.getContent));
    }

    @Then("^Verify \"([^\"]*)\" that added into an item$")
    public void verifyThatAddedIntoAnItem(String tagName) {       
        wlcMessagePage.hoverMouseToElement(driver, SvWlcCounterPageUI.COLUMN1_TAG_ICON);
        Assert.assertTrue(wlcMessagePage.isElementDisplayed(driver, SvWlcCounterPageUI.COLUMN1_TAG_CONTENT_LBL, tagName));
        wlcMessagePage.hoverMouseToElement(driver, SvWlcCounterPageUI.COLUMN2_TAG_ICON);
        wlcMessagePage.sleepInSecond(3);
        Assert.assertTrue(wlcMessagePage.isElementDisplayed(driver, SvWlcCounterPageUI.COLUMN2_TAG_CONTENT_LBL, tagName));
    }

    @Then("^Verify \"([^\"]*)\" disable tag that added into an item$")
    public void verifyDisableTagThatAddedIntoAnItem(String tagName) {
        Assert.assertFalse(wlcMessagePage.isDisableTagAddedIntoAnItem(tagName));
    }

    @And("^Click on Forward wlc button$")
    public void clickOnForwardButton() {
        wlcMessagePage.waitToElementClickable(driver, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN);
        wlcMessagePage.clickToElement(driver, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN);
        wlcMessagePage.sleepInSecond(2);
        wlcMessagePage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        wlcMessagePage.sleepInSecond(3);
    }

    @And("^Add tag \"([^\"]*)\" into an item$")
    public void addTagIntoAComment(String tagName) {
        wlcMessagePage.waitToElementVisible(driver, SvWlcCounterPageUI.MSG_ADD_TAG_REPLY_BTN);
        wlcMessagePage.clickToElement(driver, SvWlcCounterPageUI.MSG_ADD_TAG_REPLY_BTN);
        svWlcCounterPage.addTagIntoComment(tagName, "Lưu");
    }

    @And("^Reply one message$")
    public void replyOneMessage() {
        svWlcCounterPage.replyOnesMsg();
    }

    @Then("^Verify wlc after adding behavior tag$")
    public void verifyWlcAfterAddingBehaviorTag() {
        wlcMessagePage.sleepInSecond(10);
        wlcMessagePage.scrollToElement(driver, SvWlcCounterPageUI.MSG_FINISH_BTN);
        wlcMessagePage.sleepInSecond(3);
        Assert.assertTrue(
                wlcMessagePage.isElementDisplayed(driver, SvWlcCounterPageUI.BEHAVIOR_TAG_MSG_ICON));
        wlcMessagePage.hoverMouseToElement(driver, SvWlcCounterPageUI.BEHAVIOR_TAG_MSG_ICON);
        Assert.assertTrue(wlcMessagePage.isElementDisplayed(driver,
                SvWlcCounterPageUI.BEHAVIOR_TAG_NAME_OVERLAY, GlobalConstants.BH_TAG_NAME));
    }

    @And("^Click on Config Column3 button$")
    public void clickOnConfigColumn3Button() {
        wlcMessagePage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        wlcMessagePage.sleepInSecond(2);
        wlcMessagePage.scrollToElement(driver, SvWlcCounterPageUI.MSG_FINISH_BTN);
        wlcMessagePage.waitToElementClickable(driver, SvWlcCounterPageUI.COLUMN3_CONFIG_ICON);
        wlcMessagePage.clickToElement(driver, SvWlcCounterPageUI.COLUMN3_CONFIG_ICON);
    }
}
