package mobio.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import mobio.pageObjects.CommonPageObject;

// TODO: Auto-generated Javadoc
/**
 * The Class MobioLibSteps.
 */
public class MobioLibSteps {

	/**
	 * Take A screenshot.
	 *
	 * @param driver   the driver
	 * @param scenario the scenario
	 */
	public void takeAScreenshot(WebDriver driver, Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				// This takes a screenshot from the driver at save it to the specified location

				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// Building up the destination path for the screenshot to save
				// Also make sure to create a folder 'screenshots' with in the cucumber-report
				// folder
//				File destinationPath = new File(System.getProperty("user.dir") + "/target" + screenshotName + ".png");
				File destinationPath = new File(System.getProperty("user.dir") + "\\target\\" + screenshotName + ".png");

				// Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);

				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());

				// Embed image for cucumber report
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				
				//Gets website version
				scenario.write(CommonPageObject.getWebsiteVersion);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}
			
			
		}
	}

}
