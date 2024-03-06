package mobio.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import mobio.pageObjects.CommonPageObject;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageObjects.TeamPageObject;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageObjects.SvWlcCounterPageObject;
import mobio.services.pageObjects.SvWlcMessagePageObject;
import mobio.services.pageObjects.SvWlcSocketPageObject;
import mobio.services.pageUIs.SvWlcCounterPageUI;

public class SvSocketPageSteps {
    WebDriver driver;
    SvWlcSocketPageObject svWlcSocketPage;
    SvWlcCounterPageObject svWlcCounterPage;
    TeamPageObject teamPage;
    CommonPageObject commonPage;

    public SvSocketPageSteps() {
        driver = Hooks.getAndCloseBrowser();
        svWlcSocketPage = PageGeneratorManager.getSvFbWlcSocketPage(driver);
        svWlcCounterPage = PageGeneratorManager.getSvWlcCounterPage(driver);
        teamPage = PageGeneratorManager.getTeamPage(driver);
        commonPage = PageGeneratorManager.getCommonPage(driver);
    }

    @And("^Click on the top item$")
    public void clickOnTheTopItem() {
        svWlcSocketPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        svWlcSocketPage.sleepInSecond(10);
        svWlcSocketPage.clickOnTheTopItem();
    }

    @Then("^Verify wlc text and file in the post$")
    public void verifyWlcAndFileInThePost() {
        Assert.assertTrue(svWlcSocketPage.isElementDisplayed(driver, SvWlcCounterPageUI.MESSAGE_POSTED_IMG));
    }

    @Then("^Verify the posted image after clicking to zoom out$")
    public void verifyTheImageAfterClickingToZoomOut() {
        svWlcSocketPage.hoverMouseToElement(driver, SvWlcCounterPageUI.NO_ZOOM_IMG);
        Assert.assertEquals("Đã gửi 1 ảnh", svWlcSocketPage.getTextElement(driver, SvWlcCounterPageUI.SOCIAL_CONTENT_TOP_ITEM));
        Assert.assertTrue(svWlcSocketPage.isElementDisplayed(driver, SvWlcCounterPageUI.ZOOM_IMG));
    }

    @Then("^Verify the posted gif after clicking to zoom out$")
    public void verifyTheGifAfterClickingToZoomOut() {
        svWlcSocketPage.hoverMouseToElement(driver, SvWlcCounterPageUI.NO_ZOOM_IMG);
        Assert.assertEquals("Đã gửi 1 ảnh", svWlcSocketPage.getTextElement(driver, SvWlcCounterPageUI.SOCIAL_CONTENT_TOP_ITEM));
        Assert.assertTrue(svWlcSocketPage.isElementDisplayed(driver, SvWlcCounterPageUI.ZOOM_IMG));
    }

    @Then("^Verify the posted video after clicking to zoom out$")
    public void verifyTheVideoAfterClickingToZoomOut() {
        Assert.assertEquals("Đã gửi 1 video", svWlcSocketPage.getTextElement(driver, SvWlcCounterPageUI.SOCIAL_CONTENT_TOP_ITEM));
        Assert.assertTrue(svWlcSocketPage.isElementDisplayed(driver, SvWlcCounterPageUI.ZOOM_VIDEO));
    }

    @Then("^Verify the posted file$")
    public void verifyTheFileAfterClickingToZoomOut() {
        Assert.assertEquals("Đã gửi 1 tệp tin", svWlcSocketPage.getTextElement(driver, SvWlcCounterPageUI.SOCIAL_CONTENT_TOP_ITEM));
    }

    @And("^Click on the picture in the wlc$")
    public void clickOnThePictureInTheWlc() {
        svWlcSocketPage.waitToElementClickable(driver, SvWlcCounterPageUI.MESSAGE_POSTED_IMG);
        svWlcSocketPage.clickToElementByJS(driver, SvWlcCounterPageUI.MESSAGE_POSTED_IMG);
        svWlcSocketPage.sleepInSecond(3);
    }

    @Then("^Verify recipient group dropdown$")
    public void verifyRecipientGroupDropdown() {
        Assert.assertTrue(svWlcSocketPage.isTeamManagePage());
    }

    @Then("^Verify recipient group dropdown default$")
    public void verifyRecipientGroupDropdownDefault() {
        svWlcSocketPage.sleepInSecond(3);
        svWlcSocketPage.waitToElementVisible(driver, SvWlcCounterPageUI.FORWARD_GROUP_DEFAULT_DROP);
        Assert.assertEquals("Auto_Thuannt", (svWlcSocketPage.getTextElement(driver, SvWlcCounterPageUI.FORWARD_GROUP_DEFAULT_DROP)));
    }

    @Then("^Verify recipient dropdown$")
    public void verifyRecipientDropdown() {
        Assert.assertTrue(teamPage.isCompareRecipientMemberListDrop());
    }

    @And("^Click on recipient group dropdown$")
    public void clickOnRecipientGroupDropdown() {
        svWlcSocketPage.waitToElementClickable(driver, SvWlcCounterPageUI.RECIPIENT_GROUP_DROP);
        svWlcSocketPage.clickToElement(driver, SvWlcCounterPageUI.RECIPIENT_GROUP_DROP);
    }

    @And("^Click on recipient dropdown$")
    public void clickOnRecipientDropdown() {
        svWlcSocketPage.clickToElement(driver, SvWlcCounterPageUI.FORWARD_HEADER);
        svWlcSocketPage.waitToElementClickable(driver, SvWlcCounterPageUI.ASSIGNED_DROP);
        svWlcSocketPage.clickToElement(driver, SvWlcCounterPageUI.ASSIGNED_DROP);
    }

    @And("^Select \"([^\"]*)\" value in recipient group dropdown$")
    public void selectValueInRecipientGroupDropdown(String groupName) {
        groupName = commonPage.getAccount(groupName);
        svWlcSocketPage.sleepInSecond(3);
        svWlcSocketPage.waitToElementVisible(driver, SvWlcCounterPageUI.RECIPIENT_GROUP_DROP);
        svWlcSocketPage.selectItemInCustomDropdownBySearching(driver, SvWlcCounterPageUI.RECIPIENT_GROUP_DROP,
                SvWlcCounterPageUI.LIST_FORWARD_GROUP_DROP,CommonPageUI.ITEM_SEARCH_DROP, groupName);
        svWlcSocketPage.sleepInSecond(2);
    }

    @Then("^Verify recipient drop down after selecting the second team$")
    public void verifyRecipientDropDownAfterSelectingSecondTeam() {
        svWlcSocketPage.sleepInSecond(3);
        Assert.assertFalse(svWlcSocketPage.isElementSelected(driver, SvWlcCounterPageUI.ASSIGNED_DROP));
    }

    @Then("^Verify forwarded wlc with the \"([^\"]*)\" tag and \"([^\"]*)\" assignee$")
    public void verifyForwardedwlcWithTheTagAndAssignee(String tagName, String asignee) {
        asignee = commonPage.getAccount(asignee);
        Assert.assertTrue(svWlcSocketPage.isContentInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM,
                SvWlcMessagePageObject.getContent));
        svWlcSocketPage.hoverMouseToElement(driver, SvWlcCounterPageUI.COLUMN2_TAG_ICON);
        Assert.assertTrue(
                svWlcSocketPage.isElementDisplayed(driver, SvWlcCounterPageUI.COLUMN2_TAG_CONTENT_LBL, tagName));
        svWlcSocketPage.clickToElement(driver, SvWlcCounterPageUI.COLUMN2_CONTENT_HEADER);
        svWlcSocketPage.waitToElementClickable(driver, SvWlcCounterPageUI.ASSIGN_HISTORY_BTN);
        svWlcSocketPage.clickToElement(driver, SvWlcCounterPageUI.ASSIGN_HISTORY_BTN);
        Assert.assertTrue(
                svWlcSocketPage.isElementDisplayed(driver, SvWlcCounterPageUI.ASSIGNED_HISTORY_ITEM, asignee));
    }

    @And("^Select \"([^\"]*)\" to assign task$")
    public void selectAccountToAssignTask(String userAccount) {
        userAccount = commonPage.getAccount(userAccount);
        svWlcSocketPage.assignTaskToUser(userAccount);
    }

    @And("^Add tag \"([^\"]*)\" in forwarded comment$")
    public void addTagSomethingInForwardedComment(String tagName) {
        svWlcCounterPage.addTagIntoComment(tagName, "Chuyển tiếp");
    }

    @And("^Click on Done button for Message$")
    public void clickOnDoneButtonMsg() {
        svWlcSocketPage.scrollToElement(driver, SvWlcCounterPageUI.MSG_FINISH_BTN);
        svWlcSocketPage.clickToElement(driver, SvWlcCounterPageUI.MSG_FINISH_BTN);
    }
}
