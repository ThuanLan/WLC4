package mobio.stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import mobio.pageObjects.PageGeneratorManager;
import mobio.services.pageObjects.SvWebLiveChatPageObject;
import mobio.services.pageObjects.SvWlcMessagePageObject;
import mobio.services.pageUIs.SvWebLiveChatPageUI;

public class SvWebLiveChatPageSteps {
    WebDriver driver;
    SvWebLiveChatPageObject webLiveChatPage;

    public SvWebLiveChatPageSteps() {
        driver = Hooks.getAndCloseBrowser();
        webLiveChatPage = PageGeneratorManager.getWebLiveChatPage(driver);
    }

    @Given("^Go to \"([^\"]*)\" web live chat site$")
    public void goToSomethingWebLiveChatSite(String wlcURL) {
        webLiveChatPage.goToWLCSite(wlcURL);
        webLiveChatPage.sleepInSecond(7);
    }

    @Given("^Go to web live chat site$")
    public void goToWebLiveChatSite() {
        webLiveChatPage.goToWLCSite(SvWlcMessagePageObject.wlcSite);
        webLiveChatPage.sleepInSecond(5);
    }

    @When("^Click on wlc form$")
    public void openWlcForm() {
        webLiveChatPage.switchToIframe(driver, SvWebLiveChatPageUI.WLC_IFRAME);
        webLiveChatPage.clickToElement(driver, SvWebLiveChatPageUI.WLC_CHAT_IMG);
        webLiveChatPage.sleepInSecond(1);
    }

    @When("^Create message by wlc$")
    public void createMessageByWlc() {
        webLiveChatPage = PageGeneratorManager.getWebLiveChatPage(driver);
        webLiveChatPage.createMessage();
    }
}
