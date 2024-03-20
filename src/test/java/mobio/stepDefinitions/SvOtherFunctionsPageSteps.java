package mobio.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.GlobalConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageObjects.SvOtherFunctionPageObject;
import mobio.services.pageUIs.SvOtherFunctionsPageUI;
import mobio.services.pageUIs.SvWlcCounterPageUI;

public class SvOtherFunctionsPageSteps {
	WebDriver driver;
	SvOtherFunctionPageObject svOtherFunctionPage;

	public SvOtherFunctionsPageSteps() {
		driver = Hooks.getAndCloseBrowser();
		svOtherFunctionPage = PageGeneratorManager.getSvOtherFunctionPage(driver);
	}

	@Then("^Verify block contact of member$")
	public void verifyBlockContactOfMember() {
	}

	@And("^Click on Block contact button$")
	public void clickOnBlockContactButton() {
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.BLOCK_CONTACT_BTN);
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.BLOCK_CONTACT_MENU);
	}

	@Then("^Verify the block contact of member in team$")
	public void verifyTheBlockContactOfMemberInTeam() {

	}

	@Then("^Verify the block contact of member in other team$")
	public void verifyTheBlockContactOfMemberInOtherTeam() {

	}

	@And("^Select behavior tag name$")
	public void selectBehaviorTagName() {
		svOtherFunctionPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		svOtherFunctionPage.waitToElementVisible(driver, SvWlcCounterPageUI.SEARCH_BEHAVIOR_TAG);
		svOtherFunctionPage.sendkeyToElement(driver, SvWlcCounterPageUI.SEARCH_BEHAVIOR_TAG, GlobalConstants.BH_TAG_NAME);
		svOtherFunctionPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		svOtherFunctionPage.waitToElementVisible(driver, SvWlcCounterPageUI.BEHAVIOR_TAG, GlobalConstants.BH_TAG_NAME);
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.BEHAVIOR_TAG, GlobalConstants.BH_TAG_NAME);
		svOtherFunctionPage.sleepInSecond(3);
	}

	@And("^Click on Add tag profile button$")
	public void clickOnAddTagProfileButton() {
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.ADD_TAG_PROFILE_BTN);
		svOtherFunctionPage.sleepInSecond(5);
	}

	@Then("^Verify comment after adding behavior tag by other team$")
	public void verifyCommentAfterAddingBehaviorTagOtherTeam() {
		Assert.assertFalse(svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.BEHAVIOR_TAG_ICON));
	}

	@And("^Switch to new tab$")
	public void switchToNewTab() {
		svOtherFunctionPage.switchToNewTab(driver);
	}

	@Then("^Verify the updated profile in redirected page$")
	public void verifyTheUpdatedProfile() {
		Assert.assertTrue(svOtherFunctionPage.checkUpdatedProfile());
	}

	@Then("^Verify the updated profile at column3$")
	public void verifyTheUpdatedProfileAtColumn3() {
		Assert.assertTrue(svOtherFunctionPage.isUpdatedProfileAtColumn3());
	}

	@And("^Click on Edit profile button$")
	public void clickOnEditProfileButton() {
		svOtherFunctionPage.sleepInSecond(5);
		svOtherFunctionPage.waitToElementClickable(driver, SvWlcCounterPageUI.EDIT_PROFILE_BTN);
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.EDIT_PROFILE_BTN);
	}

	@And("^Input some valid data$")
	public void inputSomeValidData() {
		svOtherFunctionPage.updateProfileInfo();
	}

	@And("^Click on profile name$")
	public void clickOnProfileName() {
		svOtherFunctionPage.waitToElementClickable(driver, SvWlcCounterPageUI.REDIRECT_PROFILE_BTN);
		svOtherFunctionPage.sleepInSecond(3);
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.REDIRECT_PROFILE_BTN);
	}

	@Then("^Verify deal updated information at the column3$")
    public void verifyDealUpdatedInformationAtTheColumn3() {
        Assert.assertTrue(
                svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.DEAL_STATUS_LBL, "Liên lạc"));
        Assert.assertTrue(svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.DEAL_VALUE_LBL));
    }


	@And("^Add deal information$")
	public void addDealInformationWithValidInformation() {
		svOtherFunctionPage.addDealInfo();		
	}

	@Then("^Verify redirected deal page$")
	public void verifyRedirectedDealPage() {
		svOtherFunctionPage.sleepInSecond(3);
		String redirectedUrl = svOtherFunctionPage.getCurrentPageUrl(driver);
		System.out.println("in ra url hiện tại " + redirectedUrl);
		Assert.assertTrue(redirectedUrl.contains(GlobalConstants.UAT_URL + "/sales/detail?"));
	}

	@And("^Click to View deal detail$")
	public void clickToViewDealDetail() {
		svOtherFunctionPage.sleepInSecond(9);
		svOtherFunctionPage.waitToElementVisible(driver, SvWlcCounterPageUI.RIGHT_BOX_TITLE_ITEM, SvOtherFunctionPageObject.dealName);
		svOtherFunctionPage.waitToElementClickable(driver, SvWlcCounterPageUI.RIGHT_BOX_TITLE_ITEM, SvOtherFunctionPageObject.dealName);
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.RIGHT_BOX_TITLE_ITEM, SvOtherFunctionPageObject.dealName);
		svOtherFunctionPage.sleepInSecond(3);
	}

	@And("^Click to redirect deal detail$")
	public void clickOnViewDealDetailButton() {
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.DEAL_REDIRECT_DETAIL_PAGE, SvOtherFunctionPageObject.dealName);
		svOtherFunctionPage.sleepInSecond(3);
	}

	@And("^Click to delete a deal$")
	public void clickToDeleteADeal() {
		svOtherFunctionPage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.DELETE_BTN, SvOtherFunctionPageObject.dealName);
		svOtherFunctionPage.sleepInSecond(3);
	}

	@Then("^Verify ticket updated information at the column3$")
	public void verifyTicketUpdatedInformationAtTheColumn3() {
		Assert.assertTrue(svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.TICKET_STATUS_LBL, "Mở"));
		Assert.assertEquals(svOtherFunctionPage.getTextElement(driver, SvWlcCounterPageUI.TICKET_TITLE_LBL), SvOtherFunctionPageObject.ticketName);
	}

	@Then("^Verify redirected ticket page$")
	public void verifyRedirectedTicketPage() {
		svOtherFunctionPage.sleepInSecond(3);
		String redirecteTicketdUrl = svOtherFunctionPage.getCurrentPageUrl(driver);
		System.out.println("in ra url hiện tại " + redirecteTicketdUrl);
		Assert.assertTrue(redirecteTicketdUrl.contains(GlobalConstants.UAT_URL + "/ticket/detail"));
	}

	@Then("^Verify deleted ticket at the column3$")
	public void verifyDeletedTicketAtTheColumn3() {
		svOtherFunctionPage.sleepInSecond(5);
		Assert.assertFalse(svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.TICKET_TITLE_LBL, SvOtherFunctionPageObject.ticketName));
	}

	@Then("^Verify deleted deal at column3$")
	public void verifyDeletedDealAtColumn3() {
//		Assert.assertTrue(svFbCommentCounterPage.isElementUndisplayed(driver, SvFbCommentCounterPageUI.DEAL_DETAIL_FORM,
//				SvFbMessageColumn3PageObject.orderName));
		svOtherFunctionPage.sleepInSecond(5);
		System.out.println("check deal name" + svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.DEAL_DETAIL_FORM, SvOtherFunctionPageObject.dealName));
		Assert.assertFalse(svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.DEAL_DETAIL_FORM, SvOtherFunctionPageObject.dealName));
	}

	@And("^Add ticket information$")
	public void addTicketInformation() {
		svOtherFunctionPage.addTicketInfo();
	}

	@And("^Click to View ticket detail$")
	public void clickToViewTicketDetail() {
		svOtherFunctionPage.sleepInSecond(5);
		svOtherFunctionPage.waitToElementClickable(driver, SvWlcCounterPageUI.RIGHT_BOX_TITLE_ITEM, SvOtherFunctionPageObject.ticketName);
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.RIGHT_BOX_TITLE_ITEM, SvOtherFunctionPageObject.ticketName);
	}

	@And("^Click to redirect ticket detail$")
	public void clickToRedirectTicketDetail() {
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.TICKETL_REDIRECT_DETAIL_PAGE, SvOtherFunctionPageObject.ticketName);
		svOtherFunctionPage.sleepInSecond(3);
	}

	@And("^Click to delete a ticket$")
	public void clickToDeleteATicket() {
		svOtherFunctionPage.switchToIframe(driver, CommonPageUI.MAIN_IFRAME);
		svOtherFunctionPage.clickToElement(driver, SvWlcCounterPageUI.DELETE_BTN, SvOtherFunctionPageObject.ticketName);
	}

	@Then("^Verify add new note information at the column3$")
	public void verifyAddedNoteInformationAtTheColumn3() {
		Assert.assertTrue(svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.NOTE_ITEM_C3_LBL, SvOtherFunctionPageObject.noteContent));
	}

	@Then("^Verify note updated information at the column3$")
	public void verifyNoteUpdatedInformationAtTheColumn3() {
		svOtherFunctionPage.sleepInSecond(1);
		svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.NOTE_TITLE_C3_LBL);
		svOtherFunctionPage.sleepInSecond(1);

		Assert.assertTrue(svOtherFunctionPage.isElementDisplayed(driver, SvWlcCounterPageUI.NOTE_ITEM_C3_LBL, SvOtherFunctionPageObject.noteContent));
	}

	@Then("^Verify deleted note at the column3$")
	public void verifyDeletedNoteAtTheColumn3() {
		svOtherFunctionPage.sleepInSecond(3);
		Assert.assertTrue(svOtherFunctionPage.isElementUndisplayed(driver, SvWlcCounterPageUI.NOTE_ITEM_C3_LBL, SvOtherFunctionPageObject.noteContent));
	}

	@And("^Send note information with valid information$")
	public void addNoteInformationWithValidInformation() {

		svOtherFunctionPage.sendNoteInfo();
	}

	@Then("^Verify new config in column3$")
	public void verifyNewConfigInColumn3() {
		svOtherFunctionPage.waitToElementVisible(driver, SvOtherFunctionsPageUI.DYNAMIC_TAB, "note");
		Assert.assertTrue(svOtherFunctionPage.checkConfig());
	}

	@And("^Config for \"([^\"]*)\" value$")
	public void configForSomethingValue(String infoNeedShowing) {
		svOtherFunctionPage.configSettingsValue(infoNeedShowing);
	}

	@And("^Click to edit one note$")
	public void clickToOneNote() {
		svOtherFunctionPage.sleepInSecond(2);
		svOtherFunctionPage.clickToElementByJS(driver, SvWlcCounterPageUI.NOTE_EDIT_BTN, SvOtherFunctionPageObject.noteContent);
	}

	@And("^Click to delete a note$")
	public void clickToDeleteANote() {
		svOtherFunctionPage.clickToElementByJS(driver, SvWlcCounterPageUI.NOTE_DELETE_BTN, SvOtherFunctionPageObject.noteContent);
	}

	@And("^Click Note icon$")
	public void clickNoteIcon() {
		svOtherFunctionPage.sleepInSecond(5);
		svOtherFunctionPage.clickNoteIcon();
		svOtherFunctionPage.sleepInSecond(1);
		svOtherFunctionPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);

	}

	@And("^Click Ticket icon$")
	public void clickTicketIcon() {
		svOtherFunctionPage.sleepInSecond(5);
		svOtherFunctionPage.clickTicketIcon();
		svOtherFunctionPage.sleepInSecond(1);
		svOtherFunctionPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
	}

	@And("^Click Deal icon$")
	public void clickDealIcon() {
		svOtherFunctionPage.sleepInSecond(5);
		svOtherFunctionPage.clickDealIcon();
		svOtherFunctionPage.sleepInSecond(1);
		svOtherFunctionPage.waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
	}

	@And("^Click Add note button$")
	public void clickAddNoteButton() {
		svOtherFunctionPage.clickAddNoteButton();
	}

	@And("^Click Add ticket button$")
	public void clickAddTicketButton() {
		svOtherFunctionPage.clickAddTicketButton();
	}

	@And("^Click Add deal button$")
	public void clickAddOrderButton() {
		svOtherFunctionPage.clickAddDealButton();
	}
}
