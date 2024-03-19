package mobio.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import mobio.pageObjects.CommonPageObject;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageObjects.SvWlcCounterPageObject;
import mobio.services.pageUIs.SvWlcCounterPageUI;

public class SvCounterPageSteps {
    WebDriver driver;
    CommonPageObject commonPage;
    SvWlcCounterPageObject svWlcCounterPage;


    public SvCounterPageSteps() {
        driver = Hooks.getAndCloseBrowser();
        commonPage = PageGeneratorManager.getCommonPage(driver);
        svWlcCounterPage = PageGeneratorManager.getSvWlcCounterPage(driver);
    }

    @And("^Click on \"([^\"]*)\" tab$")
    public void clickOnAFbTab(String tabName) {
        svWlcCounterPage.clickOnAFbTab(tabName);
    }

    @And("^Get number of \"([^\"]*)\" tab$")
    public void getNunberofTab(String tabName) {
        svWlcCounterPage.getNumberOnTab(tabName);
    }

    @And("^Click on \"([^\"]*)\" tab and get the list$")
    public void clickOnTheCommentTabAndGetList(String tabName) {
        svWlcCounterPage.clickCommentTabAndGetList(tabName);
    }

    @And("^Reply ones$")
    public void replyOnes() {
        svWlcCounterPage.replyOnes();
    }

    @And("^Switch to Mobio site$")
    public void switchToMobioSite() {
        svWlcCounterPage.switchToWindowByTitle(driver, "Mobio - CDP & CEM Platform");
        svWlcCounterPage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
    }

    @And("^Assign pin task to \"([^\"]*)\" user$")
    public void assignPinTaskToOtherUser(String userAccount) {
        userAccount = commonPage.getAccount(userAccount);
        svWlcCounterPage.assignTask(userAccount, SvWlcCounterPageUI.SOCIAL_ITEM_ALL_CONTENT_PIN_ITEM);
    }

    @And("^Sort in order from new to old$")
    public void sortInOrderFromNewToOld() {
        svWlcCounterPage.sortNewest();
    }

    @And("^Sort in order from old to new$")
    public void sortInOrderFromOldToNew() {
        svWlcCounterPage.sortOldest();
    }

    @Then("^Verify the comment number of one page$")
    public void verifyTheCommentNumberOfOnePage() {
        int countAllItem;
        countAllItem = svWlcCounterPage.countAllItemInHTML5List(driver, SvWlcCounterPageUI.SOCIAL_ITEM_ALL_ITEM);
        //System.out.println(countAllItem);
        int countReplied;
        countReplied = svWlcCounterPage.countAllItemInHTML5List(driver, SvWlcCounterPageUI.SOCIAL_ITEM_REPLIED_SUCCESS);
        //System.out.println(countReplied);
        Assert.assertEquals((countAllItem - countReplied), Integer.parseInt(svWlcCounterPage.getTextElement(driver, SvWlcCounterPageUI.SOCIAL_MSG_NUMBER_LBL)));

    }

    @And("^Click one comment$")
    public void clickOneComment() {
        svWlcCounterPage.clickOneComment(SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM);
        svWlcCounterPage.sleepInSecond(3);
    }

    @Then("^Verify new task in the list of contents$")
    public void verifyNewTaskInTheListOfContents() {
        Assert.assertTrue(svWlcCounterPage.isContentDisplayInList());

    }

    @And("^Click to reply an item$")
    public void clickToReplyAnItem() {
        svWlcCounterPage.clickToReplyItem();
    }

    @And("^Click on Quick reply button$")
    public void clickOnQuickReplyButton() {
        svWlcCounterPage.backToDefault(driver);
        svWlcCounterPage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
        svWlcCounterPage.waitToElementClickable(driver, SvWlcCounterPageUI.TEMPLATE_REPLY_BTN);
        svWlcCounterPage.clickToElement(driver, SvWlcCounterPageUI.TEMPLATE_REPLY_BTN);
    }

    @And("^Select a \"([^\"]*)\" quick reply Message$")
    public void selectAQuickReplyMsg(String quickReplyContent) {
        svWlcCounterPage.selectQuickReplyMsg(quickReplyContent);
    }

    @And("^Drag and drop an item \"([^\"]*)\" to quick reply$")
    public void dragAndDropAnItemSomethingToQuickReply(String quickReplyItem) {
        svWlcCounterPage.dragAndDropQuickReply(quickReplyItem);
    }
}
