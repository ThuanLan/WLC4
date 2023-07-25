package mobio.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import mobio.pageObjects.CommonPageObject;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageObjects.TeamPageObject;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageObjects.ServicesPageObject;
import mobio.services.pageObjects.SvWebLiveChatPageObject;
import mobio.services.pageObjects.SvWlcCounterPageObject;
import mobio.services.pageObjects.SvWlcFilterPageObject;
import mobio.services.pageObjects.SvWlcMessagePageObject;
import mobio.services.pageUIs.SvWlcCounterPageUI;
import mobio.services.pageUIs.SvWlcFilterPageUI;

public class SvFilterPageSteps {
    WebDriver driver;
    SvWlcFilterPageObject svWlcFilterPage;
    TeamPageObject teamPage;
    CommonPageObject commonPage;
    SvWlcCounterPageObject svWlcCounterPage;

    public SvFilterPageSteps() {
        driver = Hooks.getAndCloseBrowser();
        svWlcFilterPage = PageGeneratorManager.getSvFbWlcFilterPage(driver);
        svWlcCounterPage = PageGeneratorManager.getSvWlcCounterPage(driver);
        teamPage = PageGeneratorManager.getTeamPage(driver);
        commonPage = PageGeneratorManager.getCommonPage(driver);
    }

    @Then("^Verify filter icon$")
    public void verifyFilterIcon() {
        Assert.assertTrue(commonPage.isFilterCursor(SvWlcFilterPageUI.FILTER_BTN, "pointer"));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.FILTER_BTN));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.FILTER_SEARCH_TXT));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.FILTER_TOOLTIP));

        if (svWlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_ALL_ITEM)) {
            Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.FILTER_NO_LIST));
        } else {
            Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.FILTER_NO_LIST));
        }
    }

    @Then("^Verify filter form for messages$")
    public void verifyFilterFormMessage() {
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.FILTER_COLLAPSE_LINK));

        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.SUPPORT_LBL));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.SUPPORT_DROP));

        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.PAGE_LBL));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.PAGE_DROP));

        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.PROCESSING_STATUS_LBL));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.DONE_RADIO));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.NOT_DONE_RADIO));

        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.REPLY_STATUS_LBL));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKBOX));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.REPLY_CHECKBOX));

        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.TAG_LBL));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT));
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.APPLY_BTN));
    }

    @Then("^Verify close filter$")
    public void verifyCloseFilter() {
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.FILTER_COLLAPSE_LINK));

        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.SUPPORT_LBL));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.SUPPORT_DROP));

        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.PAGE_LBL));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.PAGE_DROP));

        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.PROCESSING_STATUS_LBL));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.DONE_RADIO));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.NOT_DONE_RADIO));

        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.REPLY_STATUS_LBL));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.NOT_REPLY_CHECKBOX));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.REPLY_CHECKBOX));

        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.STATUS_LBL));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.POSITIVE_CHECKBOX));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.NEGATIVE_CHECKBOX));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.NEUTRAL_CHECKBOX));

        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.TAG_LBL));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.APPLY_BTN));
    }

    @And("^Hover on filter button$")
    public void hoverOnFilterButton() {
        svWlcFilterPage.hoverOnFilterButton();
    }

    @And("^Click on filter collapse link$")
    public void clickOnCollapseLink() {
        svWlcFilterPage.clickOnFilterCollapse();
    }

    @And("^Click on filter button$")
    public void clickOnFilterButton() {
        svWlcFilterPage.clickOnFilterButton();
    }

    @And("^Select \"([^\"]*)\" data support dropdown$")
    public void selectDataSupportDropdown(String itemName) {
        itemName = commonPage.getAccount(itemName);
        svWlcFilterPage.selectAllSupportDropdown(itemName);
    }

    @And("^Click on list of social page dropdown$")
    public void clickOnListOfFacebookPageDropdown() {
        svWlcFilterPage.clickToElement(driver, SvWlcFilterPageUI.PAGE_DROP);
    }

    @Then("^Verify list of social page of team member$")
    public void verifyListOfSocialPageOfTeamMember() {
        svWlcFilterPage.waitToElementVisible(driver, SvWlcFilterPageUI.PAGE_ALLITEM_DROP);
        Assert.assertTrue((ServicesPageObject.listTemp)
                .containsAll(svWlcFilterPage.getListItemsInDropdown(driver, SvWlcFilterPageUI.PAGE_ALLITEM_DROP)));
    }

    @And("^Check on the unanswered checkbox$")
    public void checkOnUnansweredCheckbox() {
        svWlcFilterPage.checkOnUnansweredCheckbox();
    }

    @And("^Check on the answered checkbox$")
    public void checkOnAnsweredCheckbox() {
        svWlcFilterPage.checkOnAnsweredCheckbox();
    }

    @And("^Click on the Apply button$")
    public void clickOnTheApplyButton() {
        svWlcFilterPage.clickOnTheApplyButton();
    }

    @And("^Hover on \"([^\"]*)\" team and get members$")
    public void hoverOnSomethingTeam(String groupName) {
        groupName = commonPage.getAccount(groupName);
        teamPage.hoverOnTeamMember(groupName);
    }

    @Then("^Verify user name \"([^\"]*)\" in support dropdown list after chose one item$")
    public void verifySupportDropdownListAfterChoseOneItem(String userName) {
        userName = commonPage.getAccount(userName);
        Assert.assertTrue(
                svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.SUPPORT_ONE_ITEM_DROP, userName));
    }

    @Then("^Verify the list of the finished item$")
    public void verifyTheListOfTheFinishedItem() {
        Assert.assertTrue(svWlcFilterPage.isContentInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM,
                SvWlcMessagePageObject.getContent));
    }

    @Then("^Verify list of social$")
    public void verifyListOfSocial() {
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_ALL_ITEM));
    }

    @Then("^Verify comments of team member$")
    public void verifyCommentsOfTeamMember() {
        svWlcFilterPage.sleepInSecond(7);
        System.out.println("Số lượng items " + SvWlcCounterPageObject.contentAllStartList);
        
        try {
            Assert.assertTrue(svWlcFilterPage.getOriginalList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM)
                    .containsAll(SvWlcCounterPageObject.contentAllStartList));
		} catch (Exception e) {
			throw new IllegalArgumentException("*** Can not found any item ***");
		}
    }

    @And("^Check on finished checkbox$")
    public void checkOnFinishedCheckbox() {
        svWlcFilterPage.clickOnFinishedCheckbox();
    }

    @And("^Select some tag names$")
    public void selectSomeTagNames() {
        svWlcFilterPage.selectTagNames("Need to reply", "Check new tag", "MSB bank");

    }

    @Then("^Verify the order of the list items$")
    public void verifyOrderOfListComments() {
        svWlcCounterPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        svWlcCounterPage.sleepInSecond(15);
        Assert.assertTrue(svWlcCounterPage.isSortDataInList());
    }

    @Then("^Verify the list of items after sorting$")
    public void verifyTheListOfItemsAfterSorting() {
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_NOT_REPLY));
        Assert.assertFalse(svWlcFilterPage.isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_REPLIED_SUCCESS));
    }

    @And("^Click on Search box$")
    public void clickOnSearchBox() {
        svWlcFilterPage.clickToElement(driver, SvWlcFilterPageUI.SEARCH_BOX_TXT);
    }

    @And("^Select the search content kind$")
    public void selectTheSearchContentKind() {
        svWlcFilterPage.selectItemInCustomDropdown(driver, SvWlcFilterPageUI.SEARCH_STYLE_DROP,
                SvWlcFilterPageUI.SEARCH_STYLE_AlL_ITEM_DROP, "Nội dung");
    }

    @And("^Send content to search$")
    public void sendContentOfSeaching() {
        svWlcFilterPage.sendkeyToElement(driver, SvWlcFilterPageUI.SEARCH_BOX_TXT, SvWebLiveChatPageObject.wlcMessage);
        svWlcFilterPage.sendkeyControl(driver, SvWlcFilterPageUI.SEARCH_BOX_TXT, Keys.ENTER);
    }

    @And("^Click on search icon at clolumn2$")
    public void clickToSearchIconAtClolumn2() {
        svWlcFilterPage.waitToElementClickable(driver, SvWlcFilterPageUI.SEARCH_COLUMN2_BTN);
        svWlcFilterPage.clickToElement(driver, SvWlcFilterPageUI.SEARCH_COLUMN2_BTN);
    }

    @And("^Send valid content to search at clolumn2$")
    public void inputTextIntoSearchBoxAtClolumn2() {

        svWlcFilterPage.sendkeyToElement(driver, SvWlcFilterPageUI.SEARCH_COLUMN2_TXT,
                SvWebLiveChatPageObject.wlcMessage);
        svWlcFilterPage.sendkeyControl(driver, SvWlcFilterPageUI.SEARCH_COLUMN2_TXT, Keys.ENTER);
    }

    @And("^Send invalid content to search at clolumn2$")
    public void inputInValidTextIntoSearchBoxAtClolumn2() {
        svWlcFilterPage.sendkeyToElement(driver, SvWlcFilterPageUI.SEARCH_COLUMN2_TXT,
                SvWebLiveChatPageObject.wlcMessage + " 12345");
        svWlcFilterPage.sendkeyControl(driver, SvWlcFilterPageUI.SEARCH_COLUMN2_TXT, Keys.ENTER);
    }

    @Then("^Verify list of profile in Search box$")
    public void verifyListOfProfileInSearchBox() {
        Assert.assertTrue(svWlcFilterPage.isElementDisplayed(driver, SvWlcFilterPageUI.ACCOUNT_SEARCH_BOX_DROP,
                SvWlcFilterPageUI.WLC_WEB_NAME));
    }

    @And("^Click on Pin icon of message$")
    public void clickOnPinIcon() {
        svWlcCounterPage.pinMessage(SvWlcCounterPageUI.FB_EL_NO_PIN);
    }
}