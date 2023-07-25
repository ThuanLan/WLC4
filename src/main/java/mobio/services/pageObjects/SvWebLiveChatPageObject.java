package mobio.services.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import autolibraries.mobioLibs;
import commons.GlobalConstants;
import mobio.services.pageUIs.SvWebLiveChatPageUI;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePageObject.
 */
public class SvWebLiveChatPageObject extends mobioLibs {

	/** The driver. */
	WebDriver driver;
	public static String wlcMessage;

	/**
	 * Instantiates a new home page object.
	 *
	 * @param _driver the driver
	 */
	public SvWebLiveChatPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void createMessage() {
		sleepInSecond(3);
		switchToIframe(driver, SvWebLiveChatPageUI.WLC_IFRAME);
		if (isElementDisplayed(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG)) {
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA);
			wlcMessage = "Create new message " + randomNumber();
			sendkeyToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, wlcMessage);
			sendkeyControl(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, Keys.ENTER);
			driver.switchTo().defaultContent();
			sleepInSecond(1);
		} else {
			refreshPage(driver);
			sleepInSecond(10);
			waitToElementVisible(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA);
			wlcMessage = "Create new message " + randomNumber();
			sendkeyToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, wlcMessage);
			sendkeyControl(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, Keys.ENTER);
			driver.switchTo().defaultContent();
			sleepInSecond(1);
		}
	}

	public void createMessageThatAddFile(String fileName) {
		sleepInSecond(3);
		switchToIframe(driver, SvWebLiveChatPageUI.WLC_IFRAME);
		if (isElementDisplayed(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG)) {
			
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA);
			uploadFile(driver, SvWebLiveChatPageUI.WLC_CHAT_FILE, fileName);
			sendkeyControl(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, Keys.ENTER);
			sleepInSecond(1);
			driver.switchTo().defaultContent();
			sleepInSecond(1);
		} else {
			refreshPage(driver);
			sleepInSecond(10);
			waitToElementVisible(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA);
			uploadFile(driver, SvWebLiveChatPageUI.WLC_CHAT_FILE, fileName);
			sendkeyControl(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, Keys.ENTER);
			sleepInSecond(1);
			driver.switchTo().defaultContent();
			sleepInSecond(1);
		}
	}

	public void createMessage(String message) {
		sleepInSecond(3);
		switchToIframe(driver, SvWebLiveChatPageUI.WLC_IFRAME);
		if (isElementDisplayed(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG)) {
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA);
			wlcMessage = message;
			sendkeyToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, wlcMessage);
			sendkeyControl(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, Keys.ENTER);
			driver.switchTo().defaultContent();
			sleepInSecond(1);
		} else {
			refreshPage(driver);
			sleepInSecond(10);
			waitToElementVisible(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
			clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA);
			wlcMessage = message;
			sendkeyToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, wlcMessage);
			sendkeyControl(driver, SvWebLiveChatPageUI.WLC_CHAT_TXTA, Keys.ENTER);
			driver.switchTo().defaultContent();
			sleepInSecond(1);
		}
	}

	public void goToWLCSite(String wlcURL) {
		if (wlcURL.contains("wlc0001")) {
			openNewURL(driver, GlobalConstants.WLC_SITE_0001);
		} else if (wlcURL.contains("wlc0002")) {
			openNewURL(driver, GlobalConstants.WLC_SITE_0002);
		} else if (wlcURL.contains("wlc0003")) {
			openNewURL(driver, GlobalConstants.WLC_SITE_0003);
		} else if (wlcURL.contains("wlc0004")) {
			openNewURL(driver, GlobalConstants.WLC_SITE_0004);
		} else if (wlcURL.contains("wlc0005")) {
			openNewURL(driver, GlobalConstants.WLC_SITE_0005);
		} else {
			openNewURL(driver, GlobalConstants.WLC_SITE_0001);
		}
	}

	public void goToWLCSiteOther(String wlcURL) {
		if (wlcURL.contains("wlc0001")) {
			openUrl(driver, GlobalConstants.WLC_SITE_0001);
		} else if (wlcURL.contains("wlc0002")) {
			openUrl(driver, GlobalConstants.WLC_SITE_0002);
		} else if (wlcURL.contains("wlc0003")) {
			openUrl(driver, GlobalConstants.WLC_SITE_0003);
		} else if (wlcURL.contains("wlc0004")) {
			openUrl(driver, GlobalConstants.WLC_SITE_0004);
		} else if (wlcURL.contains("wlc0005")) {
			openUrl(driver, GlobalConstants.WLC_SITE_0005);
		} else {
			openUrl(driver, GlobalConstants.WLC_SITE_0003);
		}
	}

}
