package mobio.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.GlobalConstants;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumberOption.Hooks;
import mobio.pageObjects.LoginPageObject;
import mobio.pageObjects.PageGeneratorManager;

public class LoginPageSteps extends MobioLibSteps {
    WebDriver driver;
    LoginPageObject loginPage;

    public LoginPageSteps() {
        driver = Hooks.getAndCloseBrowser();
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @After
    public void screenshot(Scenario scenario) {
        takeAScreenshot(driver, scenario);
    }


    @And("^Logout from Mobio site$")
    public void logoutFromMobioSite() {
        loginPage.logoutMobioSite();
    }

    @Given("^Go to Mobio login page$")
    public void goToMobioLoginPage() {
        loginPage.switchToWindowByTitle(driver, "Mobio - CDP & CEM Platform");
        driver.get(GlobalConstants.UAT_LOGIN_URL);
        loginPage.logoutMobioSite();
    }

    @Given("^Go to Mobio site by \"([^\"]*)\" account$")
    public void goToMobioSiteByAnAccount(String account) {
        loginPage.goToMobioSiteByAnAccount(account);
    }

    @And("^Login by \"([^\"]*)\" account$")
    public void loginByValidAccount(String account) {
        loginPage.loginAsAnAccount(account);
    }
}
