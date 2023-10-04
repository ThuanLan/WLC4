package cucumberOption;

import java.time.Duration;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import commons.GlobalConstants;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	private static WebDriver driver;
	private static final Logger log = Logger.getLogger(Hooks.class.getName());
	public static Scenario scenario;

	@Before
	public synchronized static WebDriver getAndCloseBrowser() {
		String browser = System.getProperty("BROWSER");

		if (driver == null) {

			try {
				if (browser == null) {
					browser = System.getenv("BROWSER");
					if (browser == null) {
						browser = "chrome";
					}
				}

				switch (browser) {
				case "chrome":
					// WebDriverManager.chromedriver().setup();
					// System.setProperty("webdriver.chrome.silentOutput", "true");

					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-popup-blocking");
					options.addArguments("--disable-notifications");
					HashMap<String, Object> chromePrefs = new HashMap<>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FOLDER);
					options.setExperimentalOption("prefs", chromePrefs);
					driver = new ChromeDriver(options);
					break;

				// Allow for notification in chrome browser
				// WebDriverManager.chromedriver().setup();
				// System.setProperty("webdriver.chrome.silentOutput", "true");
				// ChromeOptions options = new ChromeOptions();
				// HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				// chromePrefs.put("profile.default_content_setting_values.notifications", 1);
				// chromePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FOLDER);
				// options.setExperimentalOption("prefs", chromePrefs);
				// driver = new ChromeDriver(options);
				// break;

				case "hchrome":

					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--headless");
					chromeOptions.addArguments("--disable-notifications");
					chromeOptions.addArguments("window-size=1366x768");
					driver = new ChromeDriver(chromeOptions);
					break;

				case "firefox":

					System.setProperty(FirefoxDriver.SystemProperty.BROWSER_BINARY, "true");
					System.setProperty(FirefoxDriver.SystemProperty.BROWSER_PROFILE, "/dev/null");

					FirefoxOptions optionsfx = new FirefoxOptions();
					optionsfx.addPreference("browser.download.folderList", 2);
					optionsfx.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_FOLDER);
					driver = new FirefoxDriver(optionsfx);
					break;

				case "hfirefox":

					System.setProperty(FirefoxDriver.SystemProperty.BROWSER_BINARY, "true");
					System.setProperty(FirefoxDriver.SystemProperty.BROWSER_PROFILE, "/dev/null");
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					// firefoxOptions.setHeadless(true);
					driver = new FirefoxDriver(firefoxOptions);
					break;
				default:
					throw new RuntimeException("Please choose your browser!");
				}
			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}

			driver.get(GlobalConstants.UAT_URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
			log.info("------------- Started the browser -------------");

		}
		return driver;
	}

	@After("@browser")
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // stick it in the report
		}
		driver.close();
	}

	public static void closeBrowserAndDriver() {

		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String cmd = "";
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}

			assert driver != null;
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			}

			driver = null;
			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	private static class BrowserCleanup implements Runnable {
		@Override
		public void run() {
			closeBrowserAndDriver();
		}
	}

}