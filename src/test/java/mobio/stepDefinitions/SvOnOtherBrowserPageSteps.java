package mobio.stepDefinitions;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import mobio.pageObjects.CommonPageObject;
import mobio.pageObjects.LoginPageObject;
import mobio.pageObjects.PageGeneratorManager;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageObjects.SvWebLiveChatPageObject;
import mobio.services.pageObjects.SvWlcCounterPageObject;
import mobio.services.pageObjects.SvWlcMessagePageObject;
import mobio.services.pageObjects.SvWlcSocketPageObject;
import mobio.services.pageUIs.SvWlcCounterPageUI;
import mobio.services.pageUIs.SvWlcMessagePageUI;

public class SvOnOtherBrowserPageSteps {
	static WebDriver driverSecond;
	LoginPageObject loginPage;
	SvWlcSocketPageObject svWlcSocketPage;
	SvWlcCounterPageObject svWlcCounterPage;
	CommonPageObject commonPage;
	SvWlcMessagePageObject wlcMessagePage;
	SvWebLiveChatPageObject webLiveChatPage;

	public SvOnOtherBrowserPageSteps() {
		loginPage = PageGeneratorManager.getLoginPage(driverSecond);
		svWlcSocketPage = PageGeneratorManager.getSvFbWlcSocketPage(driverSecond);
		svWlcCounterPage = PageGeneratorManager.getSvWlcCounterPage(driverSecond);
		commonPage = PageGeneratorManager.getCommonPage(driverSecond);
		wlcMessagePage = PageGeneratorManager.getWlcMessagePage(driverSecond);
		webLiveChatPage = PageGeneratorManager.getWebLiveChatPage(driverSecond);
	}

	@And("^Open Mobio on second driver$")
	public void openMobioOnSecondBrowser() {
		try {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			HashMap<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FOLDER);
			options.setExperimentalOption("prefs", chromePrefs);
			driverSecond = new ChromeDriver(options);

		} finally {
			Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
		}
		driverSecond.get(GlobalConstants.UAT_URL);
		driverSecond.manage().window().maximize();
		driverSecond.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
	}

	@And("^Go to \"([^\"]*)\" web live chat site on other browser$")
	public void openwlcsiteAndCreateData(String wlcURL) {
		try {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			HashMap<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FOLDER);
			options.setExperimentalOption("prefs", chromePrefs);
			commonPage.sleepInSecond(1);
			driverSecond = new ChromeDriver(options);
			commonPage.sleepInSecond(1);
		} finally {
			Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
		}
		webLiveChatPage = PageGeneratorManager.getWebLiveChatPage(driverSecond);
		webLiveChatPage.goToWLCSiteOther(wlcURL);
		driverSecond.manage().window().maximize();
		driverSecond.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
	}

	@And("^Login by \"([^\"]*)\" account on other browser$")
	public void loginBySomethingAccountOnOtherBrowser(String userID) {
		loginPage = PageGeneratorManager.getLoginPage(driverSecond);
		loginPage.loginAsAnAccount(userID);
	}

	@Given("^Go to the Social chat screen on other browser$")
	public void goToScreenFromMenuInMenu() {
		commonPage.goToChildPageFromLink(driverSecond, GlobalConstants.SOCIAL_LINK);
	}

	@And("^Reply one message on other browser$")
	public void replyOneMsgOnOtherBrowser() {
		svWlcCounterPage = PageGeneratorManager.getSvWlcCounterPage(driverSecond);
		svWlcCounterPage.replyOnesMsg();
	}

	@And("^Click wlc item on other browser$")
	public void clickOldWlc() {
		wlcMessagePage = PageGeneratorManager.getWlcMessagePage(driverSecond);
		wlcMessagePage.clickOldWlcItemOtherDriver();
	}

	@And("^Click on Forward wlc button on other browser$")
	public void clickOnForwardWlcButtonOtherBrowser() {
		svWlcSocketPage.waitToElementClickable(driverSecond, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN);
		svWlcSocketPage.clickToElement(driverSecond, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN);
		svWlcSocketPage.waitShortToElementInVisible(driverSecond, CommonPageUI.LOADING_ICON);
	}

	@And("^Select \"([^\"]*)\" to assign task on other browser$")
	public void selectAccountToAssignTask(String userAccount) {
		svWlcSocketPage = PageGeneratorManager.getSvFbWlcSocketPage(driverSecond);
		userAccount = commonPage.getAccount(userAccount);
		svWlcSocketPage.assignTaskToUser(userAccount);
	}

	@And("^Click on \"([^\"]*)\" button on other browser$")
	public void clickOnSomethingButton(String buttonName) {
		svWlcCounterPage.waitToElementClickable(driverSecond, CommonPageUI.DYNAMIC_BASIC_BUTTON, buttonName);
		svWlcCounterPage.clickToElement(driverSecond, CommonPageUI.DYNAMIC_BASIC_BUTTON, buttonName);
		svWlcSocketPage.waitShortToElementInVisible(driverSecond, CommonPageUI.LOADING_ICON);
	}

	@And("^Click on Done button for message on other browser$")
	public void clickOnDoneButtonforMsgOtherBrowser() {
		svWlcCounterPage.clickToElement(driverSecond, SvWlcCounterPageUI.MSG_FINISH_BTN);
	}

	@And("^Select behavior tag name on other browser$")
	public void selectBehaviorTagName() {
		svWlcCounterPage.waitShortToElementInVisible(driverSecond, CommonPageUI.LOADING_ICON);
		svWlcCounterPage.waitToElementVisible(driverSecond, SvWlcCounterPageUI.SEARCH_BEHAVIOR_TAG);
		svWlcCounterPage.sendkeyToElement(driverSecond, SvWlcCounterPageUI.SEARCH_BEHAVIOR_TAG, GlobalConstants.BH_TAG_NAME);
		svWlcCounterPage.sleepInSecond(2);
		svWlcCounterPage.waitToElementVisible(driverSecond, SvWlcCounterPageUI.BEHAVIOR_TAG, GlobalConstants.BH_TAG_NAME);
		svWlcCounterPage.clickToElement(driverSecond, SvWlcCounterPageUI.BEHAVIOR_TAG, GlobalConstants.BH_TAG_NAME);
	}

	@And("^Click on Add tag profile button on other browser$")
	public void clickOnAddTagProfileButton() {
		svWlcCounterPage.clickToElement(driverSecond, SvWlcCounterPageUI.ADD_TAG_PROFILE_BTN);
	}

	// wlc
	@And("^Add tag \"([^\"]*)\" into a message on other browser$")
	public void addTagIntoMsg(String tagName) {
		svWlcCounterPage = PageGeneratorManager.getSvWlcCounterPage(driverSecond);
		svWlcCounterPage.waitToElementVisible(driverSecond, SvWlcCounterPageUI.MSG_ADD_TAG_REPLY_BTN);
		svWlcCounterPage.clickToElement(driverSecond, SvWlcCounterPageUI.MSG_ADD_TAG_REPLY_BTN);
		svWlcCounterPage.addTagIntoComment(tagName, "Lưu");
	}

	@When("^Create \"([^\"]*)\" message by wlc on other browser$")
	public void createMessageByWlcAddFile(String fileName) {
		webLiveChatPage = PageGeneratorManager.getWebLiveChatPage(driverSecond);
		webLiveChatPage.createMessageThatAddFile(fileName);
	}

	@When("^Create \"([^\"]*)\" text by wlc on other browser$")
	public void createTextByWlc(String message) {
		webLiveChatPage = PageGeneratorManager.getWebLiveChatPage(driverSecond);
		webLiveChatPage.createMessage(message);
	}

	@When("^Create message by wlc on other browser$")
	public void createMessageByWlc() {
		webLiveChatPage = PageGeneratorManager.getWebLiveChatPage(driverSecond);
		webLiveChatPage.createMessage();
	}

	@And("^Click on wlc icon on other browser$")
	public void clickOnWlcIcon() {
		wlcMessagePage.sleepInSecond(3);
		wlcMessagePage.waitToElementClickable(driverSecond, SvWlcMessagePageUI.WLC_ICON);
		wlcMessagePage.clickToElement(driverSecond, SvWlcMessagePageUI.WLC_ICON);
		wlcMessagePage.waitShortToElementInVisible(driverSecond, CommonPageUI.LOADING_ICON);
	}

	@And("^Click old wlc message on other browser$")
	public void clickWlcMessageComment() {
		wlcMessagePage = PageGeneratorManager.getWlcMessagePage(driverSecond);
		wlcMessagePage.clickOldWlcItem();

	}

	@And("^Click one wlc item on other browser$")
	public void clickOneWlcItemOtherBrowser() {
		wlcMessagePage = PageGeneratorManager.getWlcMessagePage(driverSecond);
		wlcMessagePage.clickOneWlc(SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM);
		wlcMessagePage.sleepInSecond(3);
	}

	@And("^Close the second browser$")
	public void closeSecondBrowser() {
		driverSecond.quit();
	}

	public static void closeBrowserAndDriver() {

		try {
			String osName = System.getProperty("os.name").toLowerCase();

			String cmd = "";
			if (driverSecond != null) {
				// driverSecond.manage().deleteAllCookies();
				driverSecond.quit();
			}

			assert driverSecond != null;
			if (driverSecond.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driverSecond.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverSecond.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			}

			driverSecond = null;
			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class BrowserCleanup implements Runnable {
		@Override
		public void run() {
			closeBrowserAndDriver();
		}
	}
}
