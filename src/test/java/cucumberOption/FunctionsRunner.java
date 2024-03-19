package cucumberOption;
 
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import mobio.pageObjects.CommonPageObject;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/mobioResource",
		glue = "mobio.stepDefinitions",
		monochrome = true,
		dryRun = false,
		plugin = { "pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html",
				"json:target/site/mobio.json" },
		snippets = SnippetType.CAMELCASE,
		
		//tags = "@chatdata,@chatcounter, @chatfilter, @chatsocket1, @chatsocket2, @chatother, @chatsocket3 ")
		tags = "@w32")
		//tags = "@chatcounter")

public class FunctionsRunner {
	
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/main/resources/extent_config.xml"));
	Reporter.setSystemInfo("User Name", "Mobio Auto");
	Reporter.setSystemInfo("Application Name", "Mobio - CDP & CEM Platform");
	Reporter.setSystemInfo("Website version: ",CommonPageObject.getWebsiteVersion);
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name"));
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
}
