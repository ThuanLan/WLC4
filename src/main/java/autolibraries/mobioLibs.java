/*
 * 
 */

package autolibraries;

import static io.restassured.RestAssured.given;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.eac.EACException;
import org.dom4j.IllegalAddException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import commons.GlobalConstants;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mobio.pageUIs.CommonPageUI;

// TODO: Auto-generated Javadoc
/**
 * The Class MobioLibs.
 */
public class mobioLibs {

	/** The js. */
	private JavascriptExecutor js;

	/** The by xpath. */
	private By byXpath;

	/** The action. */
	public Actions action;

	/** The element. */
	private WebElement element;

	/** The wait explicit. */
	private WebDriverWait waitExplicit;

	/** The select. */
	private Select select;

	/**
	 * Instantiates a new mobio libs.
	 */
	public mobioLibs() {
	}

	/**
	 * Open url.
	 *
	 * @param driver   the driver
	 * @param urlValue the url value
	 */
	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
		sleepInSecond(1);
	}

	/**
	 * Gets the page title.
	 *
	 * @param driver the driver
	 * @return the page title
	 */
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	/**
	 * Gets the current page url.
	 *
	 * @param driver the driver
	 * @return the current page url
	 */
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	/**
	 * Back.
	 *
	 * @param driver the driver
	 */
	public void back(WebDriver driver) {
		driver.navigate().back();
		sleepInSecond(1);
	}

	/**
	 * Back to default content.
	 *
	 * @param driver the driver
	 */
	public void backToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * Switch to iframe.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void switchToIframe(WebDriver driver, String locator) {
		WebElement element = findElementByXpath(driver, locator);
		driver.switchTo().frame(element);
	}

	/**
	 * Refresh a page.
	 *
	 * @param driver the driver
	 */
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	/**
	 * Reload the Mobio page until the loading icon disappears.
	 *
	 * @param driver         the driver
	 * @param loadingLocator the loading locator
	 */
	public void reloadMobioPage(WebDriver driver, String loadingLocator) {
		driver.navigate().refresh();
		waitShortToElementInVisible(driver, loadingLocator);
	}

	/**
	 * Accept alert.
	 *
	 * @param driver the driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Cancel alert.
	 *
	 * @param driver the driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Gets the text alert.
	 *
	 * @param driver the driver
	 * @return the text alert
	 */
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * Senkey to alert.
	 *
	 * @param driver the driver
	 * @param value  the value
	 */
	public void senkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);

	}

	/**
	 * Gets the text element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return the text element
	 */
	public String getTextElement(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).getText().trim();
	}

	/**
	 * Gets the text element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return the text element
	 */
	public String getTextElement(WebDriver driver, String locator, String... values) {
		return findElementByXpath(driver, locator, values).getText();
	}

	/**
	 * Gets the overloading locator.
	 *
	 * @param locator the locator
	 * @param values  the values
	 * @return the overloading locator
	 */
	public String getOverloadingLocator(String locator, String... values) {
		return String.format(locator, (Object[]) values);
	}

	/**
	 * Find element by xpath.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return the web element
	 */
	public WebElement findElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(byXpathLocator(locator));
	}

	/**
	 * Find element by xpath.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return the web element
	 */
	public WebElement findElementByXpath(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return driver.findElement(byXpathLocator(locator));
	}

	/**
	 * Find element by xpath any.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return the web element
	 */
	public WebElement findElementByXpathAny(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values, (Object[]) values);
		return driver.findElement(byXpathLocator(locator));
	}

	/**
	 * Find elements by xpath.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return the list
	 */
	public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		return driver.findElements(byXpathLocator(locator));
	}

	/**
	 * Find elements by xpath.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return the list
	 */
	public List<WebElement> findElementsByXpath(WebDriver driver, String locator, String... values) {
		highlightElement(driver, locator, values);
		locator = String.format(locator, (Object[]) values);
		return driver.findElements(byXpathLocator(locator));
	}

	/**
	 * get xpath locator by By method.
	 *
	 * @param locator the locator
	 * @return the by
	 */
	public By byXpathLocator(String locator) {
		return By.xpath(locator);
	}

	/**
	 * get dynamic xpath locator by By method.
	 *
	 * @param locator the locator
	 * @param values  the values
	 * @return the by
	 */
	public By byXpathLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return By.xpath(locator);
	}

	/**
	 * Click to element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void clickToElement(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		element = findElementByXpath(driver, locator);
		element.click();
	}

	/**
	 * Click to element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void clickToElement(WebDriver driver, String locator, String... values) {
		highlightElement(driver, locator, values);
		element = findElementByXpath(driver, locator, values);
		element.click();
	}

	/**
	 * Click to element by JS.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void clickToElementByJS(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		highlightElement(driver, locator);
		element = findElementByXpath(driver, locator);
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * Click to element by JS.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		js = (JavascriptExecutor) driver;
		highlightElement(driver, locator, values);
		element = findElementByXpath(driver, locator, values);
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * Sendkey to element by JS.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param value   the value
	 */
	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		js = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	/**
	 * Sendkey to element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param value   the value
	 */
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		highlightElement(driver, locator);
		findElementByXpath(driver, locator).clear();
		findElementByXpath(driver, locator).sendKeys(value);
	}

	/**
	 * Send key to element.
	 *
	 * @param driver         the driver
	 * @param locator        the locator
	 * @param valueToSendkey the value to send key
	 * @param values         the values
	 */
	public void sendkeyToElement(WebDriver driver, String locator, String valueToSendkey, String... values) {
		highlightElement(driver, locator, values);
		findElementByXpath(driver, locator, values).clear();
		findElementByXpath(driver, locator, values).sendKeys(valueToSendkey);
	}

	/**
	 * Send key by control method.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param keyName the key name
	 */
	public void sendkeyControl(WebDriver driver, String locator, Keys keyName) {
		element = findElementByXpath(driver, locator);
		element.sendKeys(keyName);
		sleepInSecond(1);
	}

	/**
	 * Sends the control key and a key simultaneously.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param keyName the key name
	 */
	public void sendkeyControlAndAKey(WebDriver driver, String locator, String keyName) {
		element = findElementByXpath(driver, locator);
		element.sendKeys(Keys.chord(Keys.CONTROL, keyName));
		sleepInSecond(1);
	}

	/**
	 * Drag and drop an element.
	 *
	 * @param driver            the driver
	 * @param startPointLocator the start point locator
	 * @param endPointLocator   the end point locator
	 */
	public void dragAndDropElement(WebDriver driver, String startPointLocator, String endPointLocator) {
		Actions act = new Actions(driver);
		act.dragAndDrop(findElementByXpath(driver, startPointLocator), findElementByXpath(driver, endPointLocator))
				.build().perform();
	}

	/**
	 * Open the browser full screen by pressing F11 on the keyboard.
	 */
	public void pressFullScreen() {
		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(30);
			robot.keyPress(KeyEvent.VK_F11);
			sleepInSecond(2);
			robot.keyRelease(KeyEvent.VK_F11);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Drag and drop element. This is used when dragging and dropping an element to
	 * create a scenario or a process. In case all destinations are clear.
	 *
	 * @param driver   the driver
	 * @param dragFrom the drag from
	 * @param dragTo   the drag to
	 * @param xYOffset the x Y offset
	 */
	public void dragAndDropElement(WebDriver driver, WebElement dragFrom, WebElement dragTo, int xYOffset) {
		// Setup robot
		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(30);

			// Fullscreen page so selenium coordinates work
			driver.manage().window().fullscreen();
			// robot.keyPress(KeyEvent.VK_F11);
			sleepInSecond(2);

			// Get size of elements
			Dimension fromSize = dragFrom.getSize();
			Dimension toSize = dragTo.getSize();

			// Get centre distance
			int xCentreFrom = fromSize.width / 2;
			int yCentreFrom = fromSize.height / 2;
			int xCentreTo = toSize.width / 2;
			int yCentreTo = toSize.height / 2;

			// Get x and y of WebElement to drag to
			Point toLocation = dragTo.getLocation();
			Point fromLocation = dragFrom.getLocation();

			// Make Mouse coordinate centre of element
			toLocation.x += xYOffset + xCentreTo;
			toLocation.y += 2 * xYOffset + yCentreTo;
			fromLocation.x += xCentreFrom;
			fromLocation.y += 2 * xYOffset + yCentreFrom;

			// Move mouse to drag from location
			robot.mouseMove(fromLocation.x, fromLocation.y);

			sleepInSecond(1);
			// Click and drag
			robot.mousePress(InputEvent.BUTTON1_MASK);
			sleepInSecond(1);
			// Drag events require more than one movement to register
			// Just appearing at destination doesn't work so move halfway first
			robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x,
					((toLocation.y - fromLocation.y) / 2) + fromLocation.y);
			sleepInSecond(1);
			// Move to final position
			robot.mouseMove(toLocation.x, toLocation.y);

			sleepInSecond(1);
			// Drop
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Drag and drop element. This is used when dragging and dropping an element to
	 * create a scenario or a process. In this case, all destinations are only shown
	 * when the object moves some distance.
	 *
	 * @param driver          the driver
	 * @param dragFrom        the start point
	 * @param endPointLocator the end point locator
	 * @param xYOffset        the X Y offset
	 */
	public void dndElementToAddBtn(WebDriver driver, WebElement dragFrom, String endPointLocator, int xYOffset) {
		// Setup robot
		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(30);

			sleepInSecond(2);

			// Get size of elements
			Dimension fromSize = dragFrom.getSize();

			// Get centre distance
			int xCentreFrom = fromSize.width / 2;
			int yCentreFrom = fromSize.height / 2;

			// Get x and y of WebElement to drag to

			Point fromLocation = dragFrom.getLocation();

			// Make Mouse coordinate centre of element

			fromLocation.x += xCentreFrom;
			fromLocation.y += 2 * xYOffset + yCentreFrom;

			// Move mouse to drag from location
			robot.mouseMove(fromLocation.x, fromLocation.y);
			sleepInSecond(1);
			// Click and drag
			robot.mousePress(InputEvent.BUTTON1_MASK);
			sleepInSecond(1);
			// Drag events require more than one movement to register
			// Just appearing at destination doesn't work so move halfway first
			robot.mouseMove(1265, 287);
			robot.mouseMove(1000, 287);

			// khai báo điểm đón
			WebElement dragTo = findElementByXpath(driver, endPointLocator);
			Dimension toSize = dragTo.getSize();
			int xCentreTo = toSize.width / 2;
			int yCentreTo = toSize.height / 2;
			Point toLocation = dragTo.getLocation();
			toLocation.x += xYOffset + xCentreTo;
			toLocation.y += 2 * xYOffset + yCentreTo;

			robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x,
					((toLocation.y - fromLocation.y) / 2) + fromLocation.y);
			sleepInSecond(1);
			// Move to final position
			robot.mouseMove(toLocation.x, toLocation.y);
			sleepInSecond(1);
			// Drop
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Drag and drop element. This is used when dragging and dropping an element to
	 * create a scenario or a process. In this case, all destinations are only shown
	 * when the object moves some distance.
	 *
	 * @param driver          the driver
	 * @param dragFrom        the drag from
	 * @param endPointLocator the end point locator
	 * @param xYOffset        the x Y offset
	 * @param values          the values
	 */
	public void dndElementToAddBtn(WebDriver driver, WebElement dragFrom, String endPointLocator, int xYOffset,
			String... values) {
		// Setup robot
		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(30);

			sleepInSecond(2);

			// Get size of elements
			Dimension fromSize = dragFrom.getSize();

			// Get centre distance
			int xCentreFrom = fromSize.width / 2;
			int yCentreFrom = fromSize.height / 2;

			// Get x and y of WebElement to drag to

			Point fromLocation = dragFrom.getLocation();

			// Make Mouse coordinate centre of element

			fromLocation.x += xCentreFrom;
			fromLocation.y += 2 * xYOffset + yCentreFrom;

			// Move mouse to drag from location
			robot.mouseMove(fromLocation.x, fromLocation.y);
			sleepInSecond(1);
			// Click and drag
			robot.mousePress(InputEvent.BUTTON1_MASK);
			sleepInSecond(1);
			// Drag events require more than one movement to register
			// Just appearing at destination doesn't work so move halfway first
			robot.mouseMove(1265, 287);
			robot.mouseMove(1000, 287);

			// khai báo điểm đón
			WebElement dragTo = findElementByXpath(driver, endPointLocator, values);
			Dimension toSize = dragTo.getSize();
			int xCentreTo = toSize.width / 2;
			int yCentreTo = toSize.height / 2;
			Point toLocation = dragTo.getLocation();
			toLocation.x += xYOffset + xCentreTo;
			toLocation.y += 2 * xYOffset + yCentreTo;

			robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x,
					((toLocation.y - fromLocation.y) / 2) + fromLocation.y);
			sleepInSecond(1);
			// Move to final position
			robot.mouseMove(toLocation.x, toLocation.y);
			sleepInSecond(1);
			// Drop
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

//

	/**
	 * Sleep in second.
	 *
	 * @param timeout the timeout
	 */
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Select an item in dropdown.
	 *
	 * @param driver    the driver
	 * @param locator   the locator
	 * @param valueItem the value item
	 */
	public void selectAnItemInDropdown(WebDriver driver, String locator, String valueItem) {
		element = findElementByXpath(driver, locator);
		highlightElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}

	/**
	 * Select an item in dropdown.
	 *
	 * @param driver    the driver
	 * @param locator   the locator
	 * @param valueItem the value item
	 * @param values    the values
	 */
	public void selectAnItemInDropdown(WebDriver driver, String locator, String valueItem, String... values) {
		element = findElementByXpath(driver, locator, values);
		highlightElement(driver, locator, values);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}

	/**
	 * Count element number.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return the int
	 */
	public int countElementNumber(WebDriver driver, String locator) {
		return findElementsByXpath(driver, locator).size();
	}

	/**
	 * Checks if is element not present.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return true, if is element not present
	 */
	public boolean isElementNotPresent(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(byXpathLocator(locator));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		if (elements.size() == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Checks if is element present.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return true, if is element present
	 */
	public boolean isElementPresent(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(byXpathLocator(locator));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

		if (elements.size() > 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Checks if is element present.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return true, if is element present
	 */
	public boolean isElementPresent(WebDriver driver, String locator, String... values) {
		List<WebElement> elements = driver.findElements(byXpathLocator(locator, values));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

		if (elements.size() > 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Checks if is element displayed.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return true, if is element displayed
	 */
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			element = driver.findElement(By.xpath(locator));
			return element.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Checks if is elements displayed.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return true, if is elements displayed
	 */
	public boolean isElementsDisplayed(WebDriver driver, String locator) {
		if (driver.findElements(byXpathLocator(locator)).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if is elements displayed.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return true, if is elements displayed
	 */
	public boolean isElementsDisplayed(WebDriver driver, String locator, String... values) {
		if (driver.findElements(byXpathLocator(locator, values)).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if is element displayed.
	 *
	 * @param driver       the driver
	 * @param locator      the locator
	 * @param shortTimeOut the short time out
	 * @return true, if is element displayed
	 */
	public boolean isElementDisplayed(WebDriver driver, String locator, int shortTimeOut) {
		overriderGlobalTimeout(driver, shortTimeOut);
		try {
			element = driver.findElement(byXpathLocator(locator));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(shortTimeOut));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			return element.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Checks if is element displayed.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return true, if is element displayed
	 */
	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		try {
			element = driver.findElement(byXpathLocator(locator, values));
			return element.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Checks if is element enabled.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return true, if is element enabled
	 */
	public boolean isElementEnabled(WebDriver driver, String locator) {
		try {
			element = driver.findElement(byXpathLocator(locator));
			return element.isEnabled();
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Checks if is element enabled.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return true, if is element enabled
	 */
	public boolean isElementEnabled(WebDriver driver, String locator, String... values) {
		try {
			element = driver.findElement(byXpathLocator(locator, values));
			return element.isEnabled();
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Checks if is integer.
	 *
	 * @param driver the driver
	 * @param input  the input
	 * @return true, if is integer
	 */
	public boolean isInteger(WebDriver driver, String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Hover mouse to element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		highlightElement(driver, locator);
		element = findElementByXpath(driver, locator);
		action.moveToElement(element).perform();
	}

	/**
	 * Hover mouse to element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void hoverMouseToElement(WebDriver driver, String locator, String... values) {
		action = new Actions(driver);
		highlightElement(driver, locator, values);
		element = findElementByXpath(driver, locator, values);
		action.moveToElement(element).perform();

	}

	/**
	 * Hover mouse to web element.
	 *
	 * @param driver  the driver
	 * @param element the element
	 */
	public void hoverMouseToWebElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * Gets the atribute.
	 *
	 * @param driver        the driver
	 * @param locator       the locator
	 * @param atributeValue the atribute value
	 * @return the atribute
	 */
	public String getAtribute(WebDriver driver, String locator, String atributeValue) {
		element = findElementByXpath(driver, locator);
		return element.getAttribute(atributeValue);
	}

	/**
	 * Gets the atribute.
	 *
	 * @param driver        the driver
	 * @param locator       the locator
	 * @param atributeValue the atribute value
	 * @param values        the values
	 * @return the atribute
	 */
	public String getAtribute(WebDriver driver, String locator, String atributeValue, String... values) {
		element = findElementByXpath(driver, locator, values);
		return element.getAttribute(atributeValue);
	}

	/**
	 * Gets the list elements value.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return the list elements value
	 */
	public List<String> getListElementsValue(WebDriver driver, String locator) {
		List<String> listValue = new ArrayList<>();
		waitToElementVisible(driver, locator);
		List<WebElement> listElements = findElementsByXpath(driver, locator);
		for (WebElement element : listElements) {
			listValue.add(element.getText().trim());
		}
		return listValue;
	}

	/**
	 * Gets the list elements value.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return the list elements value
	 */
	public List<String> getListElementsValue(WebDriver driver, String locator, String... values) {
		List<String> listValue = new ArrayList<>();
		waitToElementVisible(driver, locator, values);
		List<WebElement> listElements = findElementsByXpath(driver, locator, values);
		for (WebElement element : listElements) {
			listValue.add(element.getText().trim());
		}
		return listValue;
	}

	/**
	 * Double click an Element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void doubleClickAnElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.doubleClick(element).perform();
	}

	/**
	 * Double click an element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void doubleClickAnElement(WebDriver driver, String locator, String... values) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator, values);
		action.doubleClick(element).perform();
	}

	/**
	 * Mouse click an Element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void mouseClickAnElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.click(element).perform();
	}

	/**
	 * Mouse click an Element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void mouseClickAnElement(WebDriver driver, String locator, String... values) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator, values);
		action.click(element).perform();
	}

	/**
	 * Wait until Alert is displayed.
	 *
	 * @param driver the driver
	 */
	public void waitAlerPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Wait until the element is visible.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void waitToElementVisible(WebDriver driver, String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}

	/**
	 * Wait until the element is visible.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void waitToElementVisible(WebDriver driver, String locator, String... values) {
		byXpath = byXpathLocator(locator, values);
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}

	/**
	 * Wait until the element is visible.
	 *
	 * @param driver      the driver
	 * @param locator     the locator
	 * @param longTimeOut the long time out
	 * @param values      the values
	 */
	public void waitToElementVisible(WebDriver driver, String locator, int longTimeOut, String... values) {
		byXpath = byXpathLocator(locator, values);
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}

	/**
	 * Wait until the element is visible.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param timeOut the time out
	 */
	public void waitToElementVisible(WebDriver driver, String locator, int timeOut) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		overriderGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}

	/**
	 * Wait until the element is clickable.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void waitToElementClickable(WebDriver driver, String locator) {
		By byLocator = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
		overriderGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
		} catch (org.openqa.selenium.TimeoutException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Wait until the element is clickable.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void waitToElementClickable(WebDriver driver, String locator, String... values) {
		By byLocator = byXpathLocator(locator, values);
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
		try {
			waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
		} catch (org.openqa.selenium.TimeoutException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Wait to element in visible.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void waitToElementInVisible(WebDriver driver, String locator) {
		By byLocator = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		overriderGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		try {
			waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		} catch (org.openqa.selenium.TimeoutException ex) {
			ex.printStackTrace();
		}
		// overriderGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	/**
	 * Wait short to element in visible.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void waitShortToElementInVisible(WebDriver driver, String locator) {
		By byLocator = byXpathLocator(locator);
		if (isElementDisplayed(driver, locator)) {
			try {
				waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.MID_TIMEOUT));
				waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
			} catch (org.openqa.selenium.TimeoutException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Wait to element in visible.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void waitToElementInVisible(WebDriver driver, String locator, String... values) {
		By byLocator = byXpathLocator(locator, values);
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		overriderGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		try {
			waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		} catch (org.openqa.selenium.TimeoutException ex) {
			ex.printStackTrace();
		}
		overriderGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	/**
	 * Wait to element in visible.
	 *
	 * @param driver      the driver
	 * @param locator     the locator
	 * @param longTimeOut the long time out
	 */
	public void waitToElementInVisible(WebDriver driver, String locator, int longTimeOut) {
		By byLocator = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		try {
			waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		} catch (org.openqa.selenium.TimeoutException ex) {
			ex.printStackTrace();
		}
		overriderGlobalTimeout(driver, longTimeOut);
	}

	/**
	 * Checks if is element undisplayed.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return true, if is element undisplayed
	 */
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overriderGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			overriderGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return true;

		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overriderGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return true;
		} else {
			overriderGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return false;
		}
	}

	/**
	 * Overrider global timeout.
	 *
	 * @param driver  the driver
	 * @param timeOut the time out
	 */
	private void overriderGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}

	/**
	 * Checks if is element undisplayed.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return true, if is element undisplayed
	 */
	public boolean isElementUndisplayed(WebDriver driver, String locator, String... values) {
		overriderGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		locator = String.format(locator, (Object[]) values);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if is element selected.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return true, if is element selected
	 */

	public boolean isElementSelected(WebDriver driver, String locator) {
		try {
			byXpath = byXpathLocator(locator);
			waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
			waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
			element = driver.findElement(byXpath);
			return element.isSelected();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Checks if is element selected.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 * @return true, if is element selected
	 */
	public boolean isElementSelected(WebDriver driver, String locator, String... values) {
		try {
			byXpath = byXpathLocator(locator, values);
			waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
			waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
			element = driver.findElement(byXpath);
			return element.isSelected();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Random number.
	 *
	 * @return the int
	 */
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(100000);
	}

	/**
	 * Random string.
	 *
	 * @param stringNumber the string number
	 * @return the string
	 */
	public String randomString(int stringNumber) {

		return RandomStringUtils.randomAlphabetic(stringNumber);
	}

	/**
	 * Gets the text by JS.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return the text by JS
	 */
	public String getTextByJS(WebDriver driver, String locator) {
		return (String) js.executeScript("return document.querySelector('" + locator + "').text");
	}

	/**
	 * Gets the text by JS content.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @return the text by JS content
	 */
	public String getTextByJSContent(WebDriver driver, String locator) {
		return (String) js.executeScript("return document.querySelector('" + locator + "').textContent");
	}

	/**
	 * Verify text inner text.
	 *
	 * @param driver       the driver
	 * @param textExpected the text expected
	 * @return true, if successful
	 */
	public boolean verifyTextInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) js
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	/**
	 * Scroll to element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void scrollToElement(WebDriver driver, String locator, String... values) {
		js = (JavascriptExecutor) driver;
		WebElement element = findElementByXpath(driver, locator, values);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * Scroll to element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void scrollToElement(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		WebElement element = findElementByXpath(driver, locator);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * Scroll to element and hold.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void scrollToElementAndHold(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
		WebElement element = findElementByXpath(driver, locator);
		js.executeScript("arguments[0].scrollIntoView();", element);
		action.clickAndHold(element).perform();
	}

	/**
	 * Scroll to element and hold.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void scrollToElementAndHold(WebDriver driver, String locator, String... values) {
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
		WebElement element = findElementByXpath(driver, locator, values);
		js.executeScript("arguments[0].scrollIntoView();", element);
		action.clickAndHold(element).perform();
	}

	/**
	 * Scroll to bottom.
	 *
	 * @param driver the driver
	 */
	public void scrollToBottom(WebDriver driver) {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
//		js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		sleepInSecond(1);
	}

	/**
	 * Scroll to bottom by xpath locator.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void scrollToBottomByXpathLocator(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).sendKeys(Keys.CONTROL, Keys.END);
		sleepInSecond(1);
	}

	/**
	 * Scroll to left.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void scrollToLeft(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
		WebElement element = findElementByXpath(driver, locator);
		js.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", element);
	}

	/**
	 * Release element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void releaseElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		WebElement element = findElementByXpath(driver, locator);
		action.release(element).perform();
	}

	/**
	 * Release element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void releaseElement(WebDriver driver, String locator, String... values) {
		action = new Actions(driver);
		WebElement element = findElementByXpath(driver, locator, values);
		action.release(element).perform();
	}

	/**
	 * Switch to child window by ID.
	 *
	 * @param driver the driver
	 * @param parent the parent
	 * @return the string
	 */
	public String switchToChildWindowByID(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parent)) {
				driver.switchTo().window(runWindows);
			}

		}
		return driver.getTitle();
	}

	/**
	 * Switch to window.
	 *
	 * @param driver      the driver
	 * @param windowTitle the window title
	 */
	public void switchToWindow(WebDriver driver, String windowTitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(windowTitle)) {
				return;
			}
		}
	}

	/**
	 * Switch to window by title.
	 *
	 * @param driver the driver
	 * @param title  the title
	 */
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String curentWin = driver.getTitle();
			if (curentWin.contains(title)) {
				sleepInSecond(3);
				break;
			}
		}
	}

	/**
	 * Close all windows without parent.
	 *
	 * @param driver the driver
	 * @return true, if successful
	 */
	public boolean closeAllWindowsWithoutParent(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		if (driver.getWindowHandles().size() > 1) {
			for (String runWindows : allWindows) {
				if (!runWindows.equals(parentWindow)) {
					driver.switchTo().window(runWindows);
					driver.close();
					sleepInSecond(3);
				}
			}
			driver.switchTo().window(parentWindow);
			if (driver.getWindowHandles().size() == 1)
				return true;
			else
				return false;
		} else {
			return true;
		}
	}

	/**
	 * Input item in dropdown.
	 *
	 * @param driver       the driver
	 * @param parentXpath  the parent xpath
	 * @param inputXpath   the input xpath
	 * @param expectedText the expected text
	 */
	public void inputItemInDropdown(WebDriver driver, String parentXpath, String inputXpath, String expectedText) {
		driver.findElement(By.xpath(parentXpath)).click();
		driver.findElement(By.xpath(inputXpath)).sendKeys(expectedText);
		sendkeyControl(driver, inputXpath, Keys.ENTER);
	}

	/**
	 * Using in case of drop-down that has no searching function. The list in the
	 * drop-down menu can show all data after clicking the parent drop-down list for
	 * the first time.
	 *
	 * @param driver         the driver
	 * @param parentXpath    the parent Xpath. This is the locator of the parent
	 *                       drop-down list.
	 * @param childItemXpath the child item Xpath. This is the dynamic locator that
	 *                       contains expected text (for example childItemXpath :
	 *                       //mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip[text()='%s'])
	 * @param expectedText   the expected text. This is the expected value that you
	 *                       want to choose in the drop-down list.
	 */

	public void selectChildItemInDropdownDirectlyNoScroll(WebDriver driver, String parentXpath, String childItemXpath,
			String expectedText) {
		driver.findElement(By.xpath(parentXpath)).click();
		if (isElementDisplayed(driver, childItemXpath, expectedText)) {
			clickToElement(driver, childItemXpath, expectedText);
		} else {
			throw new IllegalAddException("No data found!");
		}
	}

	/**
	 * Using in case of drop-down that has no searching function. The list in the
	 * drop-down menu has quite a few values that we have to scroll down to display
	 * all the data.
	 *
	 * @param driver         the driver
	 * @param parentXpath    the parent Xpath. This is the locator of the parent
	 *                       drop-down list.
	 * @param childItemXpath the child item Xpath. This is the dynamic locator that
	 *                       contains expected text (for example childItemXpath :
	 *                       //mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip[text()='%s'])
	 * @param scrollElement  the scroll element
	 * @param expectedText   the expected text. This is the expected value that you
	 *                       want to choose in the drop-down list.
	 */
	public void selectChildItemInDropdownDirectlyHasScroll(WebDriver driver, String parentXpath, String childItemXpath,
			String scrollElement, String expectedText) {
		driver.findElement(By.xpath(parentXpath)).click();
		scrollToBottomByXpathLocator(driver, scrollElement);
		if (isElementDisplayed(driver, childItemXpath, expectedText)) {
			clickToElementByJS(driver, childItemXpath, expectedText);
		} else {
			throw new IllegalAddException("No data found!");
		}
	}

	/**
	 * Using in case of drop-down that has no searching function. Select an item
	 * with the exact value for the drop-down list.
	 *
	 * @param driver       the driver
	 * @param parentXpath  the parent Xpath. This is the locator of the parent
	 *                     drop-down list.
	 * @param allItemXpath the all item Xpath. They are locators of the list after
	 *                     clicking on the parent drop-down list.
	 * @param expectedText the expected text. This is the expected value that you
	 *                     want to choose in the drop-down list.
	 */
	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath,
			String expectedText) {
		int flag = 0;
		waitToElementClickable(driver, parentXpath);
		driver.findElement(By.xpath(parentXpath)).click();
		waitToElementVisible(driver, allItemXpath);
		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedText)) {
				flag = flag + 1;
				item.click();
				break;
			}
		}
		if (flag == 0) {
			throw new IllegalAddException("No data found!");
		}
	}

	/**
	 * Using in case of drop-down that has no searching function. Select an item
	 * with relative value (search value is similar to the desired value) for the
	 * drop-down list.
	 *
	 * @param driver       the driver
	 * @param parentXpath  the parent Xpath. This is the locator of the parent
	 *                     drop-down list.
	 * @param allItemXpath the all item Xpath. They are locators of the list after
	 *                     clicking on the parent drop-down list.
	 * @param expectedText the expected text. This is the expected value that you
	 *                     want to choose in the drop-down list.
	 */
	public void selectItemInCustomDropdownByPass(WebDriver driver, String parentXpath, String allItemXpath,
			String expectedText) {
		int flag = 0;
		driver.findElement(By.xpath(parentXpath)).click();
		waitToElementVisible(driver, allItemXpath);
		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
		for (WebElement item : allItems) {
			if (item.getText().contains(expectedText)) {
				flag = flag + 1;
				item.click();
				break;
			}
		}
		if (flag == 0) {
			throw new IllegalAddException("No data found!");
		}
	}

	/**
	 * Select an item by searching with the exact value for the drop-down list.
	 *
	 * @param driver       the driver
	 * @param parentXpath  the parent Xpath. This is the locator of the parent
	 *                     drop-down list.
	 * @param allItemXpath the all item Xpath. They are locators of the list after
	 *                     clicking on the parent drop-down list.
	 * @param searchXpath  the search Xpath. This is the locator of the search
	 *                     element under the parent drop-down list.
	 * @param expectedText the expected text. This is the expected value that you
	 *                     want to choose in the drop-down list.
	 */
	public void selectItemInCustomDropdownBySearching(WebDriver driver, String parentXpath, String allItemXpath,
			String searchXpath, String expectedText) {
		int flag = 0;
		driver.findElement(By.xpath(parentXpath)).click();
		waitToElementVisible(driver, allItemXpath);
		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedText)) {
				flag = flag + 1;
				item.click();
				sleepInSecond(1);
				break;
			}
		}

		// If not found value at the first time, we will continue to search for the
		// expected value in the search box of the drop-down list.
		if (flag == 0) {
			waitToElementVisible(driver, searchXpath);
			sendkeyToElement(driver, searchXpath, expectedText);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);

			List<WebElement> allItems2 = driver.findElements(By.xpath(allItemXpath));
			for (WebElement item : allItems2) {
				if (item.getText().equals(expectedText)) {
					flag = flag + 1;
					item.click();
					sleepInSecond(1);
					break;
				}
			}
		}

		// Throw exception in case no data is found for all.
		if (flag == 0) {
			throw new IllegalAddException("No data found!");
		}
	}

	/**
	 * Select an item by searching with relative value (search value is similar to
	 * the desired value) for the drop-down list.
	 *
	 * @param driver       the driver
	 * @param parentXpath  the parent Xpath. This is the locator of the parent
	 *                     drop-down list.
	 * @param allItemXpath the all item Xpath. They are locators of the list after
	 *                     clicking on the parent drop-down list.
	 * @param searchXpath  the search Xpath. This is the locator of the search
	 *                     element under the parent drop-down list.
	 * @param expectedText the expected text. This is the expected value that you
	 *                     want to choose in the drop-down list.
	 */
	public void selectItemInCustomDropdownBySearchingByPass(WebDriver driver, String parentXpath, String allItemXpath,
			String searchXpath, String expectedText) {
		int flag = 0;
		driver.findElement(By.xpath(parentXpath)).click();
		waitToElementVisible(driver, allItemXpath);
		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedText)) {
				flag = flag + 1;
				item.click();
				sleepInSecond(1);
				break;
			}
		}

		// If not found value at the first time, we will continue to search for the
		// expected value in the search box of the drop-down list.
		if (flag == 0) {
			waitToElementVisible(driver, searchXpath);
			sendkeyToElement(driver, searchXpath, expectedText);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);

			List<WebElement> allItems2 = driver.findElements(By.xpath(allItemXpath));
			for (WebElement item : allItems2) {
				if (item.getText().contains(expectedText)) {
					flag = flag + 1;
					item.click();
					sleepInSecond(1);
					break;
				}
			}
		}

		// Throw exception in case no data is found for all.
		if (flag == 0) {
			throw new IllegalAddException("No data found!");
		}
	}

	/**
	 * Highlight element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 */
	public void highlightElement(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		String originalStyle = element.getAttribute("style");
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style",
				"border: 2px solid #f20060; border-style: dashed;");
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", originalStyle);
	}

	/**
	 * Highlight element.
	 *
	 * @param driver  the driver
	 * @param locator the locator
	 * @param values  the values
	 */
	public void highlightElement(WebDriver driver, String locator, String... values) {
		js = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator, values);
		String originalStyle = element.getAttribute("style");
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style",
				"border: 2px solid #f20060; border-style: dashed;");
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", originalStyle);
	}

	/**
	 * Removes the atribute in DOM.
	 *
	 * @param driver         the driver
	 * @param locator        the locator
	 * @param atributeRemove the atribute remove
	 */
	public void removeAtributeInDOM(WebDriver driver, String locator, String atributeRemove) {
		js = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		js.executeScript("arguments[0].removeAttribute('" + atributeRemove + "');", element);
	}

	/**
	 * Removes the atribute in DOM.
	 *
	 * @param driver         the driver
	 * @param locator        the locator
	 * @param atributeRemove the atribute remove
	 * @param values         the values
	 */
	public void removeAtributeInDOM(WebDriver driver, String locator, String atributeRemove, String... values) {
		js = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator, values);
		js.executeScript("arguments[0].removeAttribute('" + atributeRemove + "');", element);
	}

	/**
	 * Gets the index of column.
	 *
	 * @param driver          the driver
	 * @param listHeaderXpath the list header xpath
	 * @param headerText      the header text
	 * @return the index of column
	 */
	public int getIndexOfColumn(WebDriver driver, String listHeaderXpath, String headerText) {
		List<WebElement> allItems = driver.findElements(By.xpath(listHeaderXpath));
		int columIndex = 0;
		int count = 0;
		for (WebElement item : allItems) {
			if (item.getText().contains(headerText) == true) {
				count = count + 1;
				columIndex = count;
				break;
			}
			count = count + 1;
		}
		return columIndex;
	}

	/**
	 * Gets the index of column.
	 *
	 * @param driver          the driver
	 * @param listHeaderXpath the list header xpath
	 * @param headerText1     the header text 1
	 * @param headerText2     the header text 2
	 * @return the index of column
	 */
	public int getIndexOfColumn(WebDriver driver, String listHeaderXpath, String headerText1, String headerText2) {
		List<WebElement> allItems = driver.findElements(By.xpath(listHeaderXpath));
		int columIndex = 0;
		int count = 0;
		for (WebElement item : allItems) {
			if (item.getText().contains(headerText1) && item.getText().contains(headerText2) == true) {
				count = count + 1;
				columIndex = count;
				break;
			}
			count = count + 1;
		}
		return columIndex;
	}

	/**
	 * From date.
	 *
	 * @param numberOfDaysAgo the number of days ago
	 * @return the string
	 */
	public String fromDate(int numberOfDaysAgo) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, numberOfDaysAgo);
		Date yesterday = calendar.getTime();
		return dateFormat.format(yesterday).toString();
	}

	/**
	 * To date.
	 *
	 * @return the string
	 */
	public String toDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 0);
		Date today = calendar.getTime();
		return dateFormat.format(today).toString();
	}

	/**
	 * Gets the minute.
	 *
	 * @return the minute
	 */
	public String getMinute() {
		DateFormat dateFormat = new SimpleDateFormat("mm");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 0);
		Date today = calendar.getTime();
		return dateFormat.format(today).toString();
	}

	/**
	 * Gets the hour.
	 *
	 * @return the hour
	 */
	public String getHour() {
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 0);
		Date today = calendar.getTime();
		return dateFormat.format(today).toString();
	}

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public String getMonth() {
		DateFormat dateFormat = new SimpleDateFormat("MM");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 0);
		Date month = calendar.getTime();
		return dateFormat.format(month).toString();
	}

	/**
	 * Gets the day of week.
	 *
	 * @return the day of week
	 */
	public String getDayOfWeek() {
		LocalDate localDate = LocalDate.now(); // today
		java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		dayOfWeek.getValue(); // 4
		return sentenceCase(dayOfWeek.toString());
	}

	/**
	 * Random row number.
	 *
	 * @param rowNumber the row number
	 * @return the int
	 */
	public int randomRowNumber(int rowNumber) {
		Random rand = new Random();
		return (1 + rand.nextInt(rowNumber));
	}

	/**
	 * Open new tab.
	 *
	 * @param driver    the driver
	 * @param yourURL   the your URL
	 * @param tabNumber the tab number
	 */
	public void openNewTab(WebDriver driver, String yourURL, int tabNumber) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('','_blank');");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNumber));
		driver.get(yourURL);
	}

	/**
	 * Open new tab 1.
	 *
	 * @param driver  the driver
	 * @param yourURL the your URL
	 */
	public void openNewTab1(WebDriver driver, String yourURL) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('about:blank', '-blank')");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(yourURL);
	}

	/**
	 * Open new URL.
	 *
	 * @param driver  the driver
	 * @param yourURL the your URL
	 */
	public void openNewURL(WebDriver driver, String yourURL) {
		String currentHandle = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
		// getting all the handles currently available
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {

			if (!actual.equalsIgnoreCase(currentHandle)) {
				// switching to the opened tab
				driver.switchTo().window(actual);

				// opening the URL saved.
				driver.get(yourURL);
			}
		}
	}

	/**
	 * Upload multiple files. The files that you want to upload must be in the
	 * UploadFiles folder in your project.
	 *
	 * @param driver    the driver
	 * @param locator   the locator
	 * @param fileNames the file names
	 */
	public void uploadMultipleFiles(WebDriver driver, String locator, String... fileNames) {
		String filePath = GlobalConstants.UAT_URL + "\\Media" + "\\Uploads\\";
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		sendkeyToElement(driver, locator, fullFileName);
	}

	/**
	 * Upload only one file for one tile. The file that you want to upload must be
	 * in the UploadFiles folder in your project.
	 *
	 * @param driver   the driver
	 * @param locator  the locator
	 * @param fileName the file name
	 * @param values   the values
	 */
	public void uploadFile(WebDriver driver, String locator, String fileName, String... values) {
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\uploadFiles\\";
		String fullFileName = filePath + fileName;
		fullFileName = fullFileName.trim();
		findElementByXpath(driver, locator, values).sendKeys(fullFileName);
	}

	/**
	 * Upload file.
	 *
	 * @param driver   the driver
	 * @param locator  the locator
	 * @param fileName the file name
	 */
	public void uploadFile(WebDriver driver, String locator, String fileName) {
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\uploadFiles\\";
		String fullFileName = filePath + fileName;
		fullFileName = fullFileName.trim();
		findElementByXpath(driver, locator).sendKeys(fullFileName);
	}

	/**
	 * Upload file by auto IT.
	 *
	 * @param driver         the driver
	 * @param exeUploadFile  the exe upload file
	 * @param uploadFilePath the upload file path
	 */
	public void UploadFileByAutoIT(WebDriver driver, String exeUploadFile, String uploadFilePath) {
		try {
			if (driver.toString().contains("firefox")) {
				Runtime.getRuntime().exec(new String[] { exeUploadFile, uploadFilePath });
				sleepInSecond(1);
			} else if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
				Runtime.getRuntime().exec(new String[] { exeUploadFile, uploadFilePath });
				sleepInSecond(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Upload file by auto IT.
	 *
	 * @param driver         the driver
	 * @param exeUploadFile  the exe upload file
	 * @param uploadFilePath the upload file path
	 * @param fileName       the file name
	 */
	public void UploadFileByAutoIT(WebDriver driver, String exeUploadFile, String uploadFilePath, String fileName) {
		uploadFilePath = uploadFilePath + "\\" + fileName;
		try {
			if (driver.toString().contains("firefox")) {
				Runtime.getRuntime().exec(new String[] { exeUploadFile, uploadFilePath });
				sleepInSecond(1);
			} else if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
				Runtime.getRuntime().exec(new String[] { exeUploadFile, uploadFilePath });
				sleepInSecond(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete file in folder.
	 *
	 * @param directoryPath the directory path
	 */
	public void deleteFileInFolder(String directoryPath) {
		File file = new File(directoryPath);
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile() && f.exists()) {
				f.delete();
			} else {
				try {
					throw new EACException("Can not delete file!");
				} catch (EACException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Export file in the folder.
	 *
	 * @param downloadPath the download path
	 * @param fileName     the file name
	 * @return true, if successful
	 */
	public boolean exportFileInTheFolder(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().contains(fileName))
				return flag = true;
		}

		return flag;
	}

	/**
	 * List files for folder.
	 *
	 * @param folder the folder
	 * @return the string
	 */
	public String getListFilesInAFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				return getListFilesInAFolder(fileEntry);
			} else {
				return fileEntry.getName();
			}
		}
		return null;
	}

	public List<String> getAKindOfItemsInHTML5List(WebDriver driver, String allItemXpath, String allContentItemXpath,
			String tailSpecificItemXpath) {
		WebElement lastItem = null;
		int loadMoreItem = 1;

		String allSpecificItemXpath = allItemXpath + tailSpecificItemXpath;

		List<String> contentGetSpecificList = new ArrayList<String>();

		if (isElementDisplayed(driver, allSpecificItemXpath)) {
			List<WebElement> allListContent = findElementsByXpath(driver, allSpecificItemXpath);
			for (WebElement content : allListContent) {
				contentGetSpecificList.add(content.getText());
			}
//			System.out.println("chưa đọc đầu: " + contentGetSpecificList);
		}

		while (loadMoreItem != 0) {
			List<WebElement> webElementListTemp = findElementsByXpath(driver, allContentItemXpath);
			int size = webElementListTemp.size();
//			System.out.println("Số lượng item ban đầu " + size);
			for (int i = 0; i < size; i++) {

				WebElement el = webElementListTemp.get((i));

				if (lastItem == null) {
//					System.out.println("Last item = null tức chưa load lần nào thì cho chạy tiếp");
					continue;
				}

				// waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);

				if (lastItem.equals(el)) {
					webElementListTemp.add(el);
					loadMoreItem = size - i - 1;
//					System.out.println("KT loadmore keo scroll " + loadMoreItem);					
					for (int j = (i + 2); j <= size; j++) {
						if (isElementDisplayed(driver, allItemXpath + '[' + j + ']' + tailSpecificItemXpath)) {
							contentGetSpecificList.add(
									findElementByXpath(driver, allItemXpath + '[' + j + ']' + tailSpecificItemXpath)
											.getText());
						}
					}
					break;
				}
			}
			lastItem = webElementListTemp.get(size - 1);
//			System.out.println("Số lượng item sau " + (size) + " giá trị: " + lastItem.getText());
			scrollToElement(driver, allItemXpath + '[' + (size) + "]");
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		}
		return contentGetSpecificList;
	}

	/**
	 * Count all item in list.
	 *
	 * @param driver       the driver
	 * @param allItemXpath the all item xpath
	 * @return the int
	 */
	public int countAllItemInHTML5List(WebDriver driver, String allItemXpath) {
		WebElement lastItem = null;
		int loadTimes = 1;
		int totalCount = 0;
		if (isElementDisplayed(driver, allItemXpath)) {
			totalCount = countElementNumber(driver, allItemXpath);
			while (loadTimes != 0) {
				List<WebElement> webElementListTemp = findElementsByXpath(driver, allItemXpath);
				int size = webElementListTemp.size();
				for (int i = 0; i < size; i++) {
					WebElement el = webElementListTemp.get((i));
					if (lastItem == null) {
						continue;
					}
					if (lastItem.equals(el)) {
						webElementListTemp.add(el);
						loadTimes = size - i - 1;
						totalCount += loadTimes;
						break;
					}
				}
				lastItem = webElementListTemp.get(size - 1);
				scrollToElement(driver, allItemXpath + '[' + size + "]");
				waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
			}
		}
		return totalCount;
	}

	/**
	 * Gets the original list.
	 *
	 * @param driver       the driver
	 * @param allItemXpath the all item xpath
	 * @return the original list
	 */
	public List<String> getHTML5List(WebDriver driver, String allItemXpath) {
		WebElement lastItem = null;
		int loadMoreItem = 1;
		sleepInSecond(5);
		List<WebElement> allListContent = findElementsByXpath(driver, allItemXpath);
		List<String> originalList = new ArrayList<String>();
		for (WebElement content : allListContent) {
			sleepInSecond(3);
			originalList.add(content.getText());
		}

		while (loadMoreItem != 0) {
			List<WebElement> webElementListTemp = findElementsByXpath(driver, allItemXpath);
			int size = webElementListTemp.size();
			for (int i = 0; i < size; i++) {
				WebElement el = webElementListTemp.get((i));
				if (lastItem == null) {
					continue;
				}

				if (lastItem.equals(el)) {
					webElementListTemp.add(el);
					loadMoreItem = size - i - 1;
					List<WebElement> elementLoadListTemp = findElementsByXpath(driver, allItemXpath);
					for (int j = (i + 1); j < size; j++) {
						WebElement el1 = elementLoadListTemp.get((j));
						originalList.add(el1.getText());
					}
					break;
				}
			}
			lastItem = webElementListTemp.get(size - 1);
			scrollToElement(driver, allItemXpath + '[' + size + "]");
			sleepInSecond(3);
		}
		System.out.println("Original List : " + originalList);
		return originalList;
	}

	/**
	 * Check if the list is sorted in the correct order by taking the original list
	 * and comparing it with the list sorted in the specified order. The correct
	 * order is that: the item has not been answered and has been pinned -> the item
	 * has been answered and has been pinned -> Item has not replied but has not
	 * been pinned -> Item has replied but has not been pinned.
	 *
	 * @param driver                 the driver
	 * @param allItemXpath           the all item xpath
	 * @param allContentItemXpath    the all content item xpath
	 * @param tailUnanswerPinXpath   the tail unanswer pin xpath
	 * @param tailAnswerPinXpath     the tail answer pin xpath
	 * @param tailUnanswerNoPinXpath the tail unanswer no pin xpath
	 * @param tailAnswerNoPinXpath   the tail answer no pin xpath
	 * @return true, if is new list compare
	 */
	public boolean isNewListCompare(WebDriver driver, String allItemXpath, String allContentItemXpath,
			String tailUnanswerPinXpath, String tailAnswerPinXpath, String tailUnanswerNoPinXpath,
			String tailAnswerNoPinXpath) {

		WebElement lastItem = null;
		int loadMoreItem = 1;

		String allGetUnAnswerPinXpath = allItemXpath + tailUnanswerPinXpath;
		String allGetAnswerPinXpath = allItemXpath + tailAnswerPinXpath;
		String allUnAnswerNoPinXpath = allItemXpath + tailUnanswerNoPinXpath;
		String allAnswerNoPinXpath = allItemXpath + tailAnswerNoPinXpath;

		List<String> contentTotalList = new ArrayList<String>();
		List<String> contentGetUnAnswerPinList = new ArrayList<String>();
		List<String> contentGetAnswerPinList = new ArrayList<String>();
		List<String> contentGetUnAnswerNoPinList = new ArrayList<String>();
		List<String> contentGetAnswerNoPinList = new ArrayList<String>();

		if (isElementDisplayed(driver, allItemXpath)) {
			List<WebElement> totalListContent = findElementsByXpath(driver, allContentItemXpath);
			for (WebElement content : totalListContent) {
				contentTotalList.add(content.getText());
			}
		}

		if (isElementDisplayed(driver, allGetUnAnswerPinXpath)) {
			List<WebElement> allListContent = findElementsByXpath(driver, allGetUnAnswerPinXpath);
			for (WebElement content : allListContent) {
				contentGetUnAnswerPinList.add(content.getText());
			}

//			System.out.println("Pin ko trả lời đầu: " + contentGetUnAnswerPinList);
		}

		if (isElementDisplayed(driver, allGetAnswerPinXpath)) {
			List<WebElement> allListContent = findElementsByXpath(driver, allGetAnswerPinXpath);
			for (WebElement content : allListContent) {
				contentGetAnswerPinList.add(content.getText());
			}

//			System.out.println("Pin trả lời đầu: " + contentGetAnswerPinList);
		}

		// check unanswer in the first loading
		if (isElementDisplayed(driver, allUnAnswerNoPinXpath)) {
			List<WebElement> allListContent = findElementsByXpath(driver, allUnAnswerNoPinXpath);
			for (WebElement content : allListContent) {
				contentGetUnAnswerNoPinList.add(content.getText());
			}

//			System.out.println("The first loading unanswer: " + contentGetUnAnswerNoPinList);
		}

		if (isElementDisplayed(driver, allAnswerNoPinXpath)) {
			List<WebElement> allListContent = findElementsByXpath(driver, allAnswerNoPinXpath);
			for (WebElement content : allListContent) {
				contentGetAnswerNoPinList.add(content.getText());
			}
//			System.out.println("Answer đầu: " + contentGetAnswerNoPinList);
		}

//		System.out.println("Loadmore đầu tiên luôn =1: " + "=====================");

		while (loadMoreItem != 0) {
			List<WebElement> webElementListTemp = findElementsByXpath(driver, allContentItemXpath);
			int size = webElementListTemp.size();
//			System.out.println("Số lượng item ban đầu " + size);
			for (int i = 0; i < size; i++) {

				WebElement el = webElementListTemp.get((i));

				if (lastItem == null) {
//					System.out.println("Last item = null tức chưa load lần nào thì cho chạy tiếp");
					continue;
				}

				if (lastItem.equals(el)) {
					webElementListTemp.add(el);
					loadMoreItem = size - i - 1;
//					System.out.println("KT loadmore keo scroll " + loadMoreItem);

					for (int j = (i + 1); j < size; j++) {
						WebElement el1 = webElementListTemp.get((j));
						contentTotalList.add(el1.getText());
					}

//					System.out.println("Giá trị chuỗi tiếp theo sau kéo scroll: " + contentTotalList);

					for (int j = (i + 2); j <= size; j++) {
//						System.out.println("có mấy giá trị " + j);
						if (isElementDisplayed(driver, allItemXpath + '[' + j + ']' + tailUnanswerPinXpath)) {
							contentGetUnAnswerPinList
									.add(findElementByXpath(driver, allItemXpath + '[' + j + ']' + tailUnanswerPinXpath)
											.getText());
						}

						if (isElementDisplayed(driver, allItemXpath + '[' + j + ']' + tailAnswerPinXpath)) {
							contentGetAnswerPinList
									.add(findElementByXpath(driver, allItemXpath + '[' + j + ']' + tailAnswerPinXpath)
											.getText());
						}
						if (isElementDisplayed(driver, allItemXpath + '[' + j + ']' + tailUnanswerNoPinXpath)) {
							contentGetUnAnswerNoPinList.add(
									findElementByXpath(driver, allItemXpath + '[' + j + ']' + tailUnanswerNoPinXpath)
											.getText());
						}
						if (isElementDisplayed(driver, allItemXpath + '[' + j + ']' + tailAnswerNoPinXpath)) {
							contentGetAnswerNoPinList
									.add(findElementByXpath(driver, allItemXpath + '[' + j + ']' + tailAnswerNoPinXpath)
											.getText());
//							System.out.println("Answer tiếp " + contentGetAnswerNoPinList);
						}
					}
					break;
				}
			}
			lastItem = webElementListTemp.get(size - 1);
//			System.out.println("Số lượng item sau " + (size) + " giá trị: " + lastItem.getText());
			scrollToElement(driver, allItemXpath + '[' + (size) + "]");
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
		}

		List<String> webElementAllCompare = new ArrayList<String>();
		webElementAllCompare.addAll(contentGetUnAnswerPinList);
		webElementAllCompare.addAll(contentGetAnswerPinList);
		webElementAllCompare.addAll(contentGetUnAnswerNoPinList);
		webElementAllCompare.addAll(contentGetAnswerNoPinList);
		System.out.println("list tổng: " + contentTotalList);
		System.out.println("List sau sx: " + webElementAllCompare);
		return webElementAllCompare.containsAll(contentTotalList);
	}

	/**
	 * Gets the content of the list in a drop-down list.
	 *
	 * @param driver              the driver
	 * @param allXpathItemsInDrop all locators in a drop-down list.
	 * @return the list item in drop
	 */
	public List<String> getListItemsInDropdown(WebDriver driver, String allXpathItemsInDrop) {
		List<WebElement> elements = findElementsByXpath(driver, allXpathItemsInDrop);
		List<String> listItem = new ArrayList<String>();
		for (WebElement item : elements) {
			listItem.add(item.getText().trim());
		}
		return listItem;
	}

	/**
	 * Check to see if the second list contains the first list.
	 *
	 * @param driver               the driver
	 * @param theFirstListContent  the the first list content
	 * @param theSecondListContent the the second list content
	 * @return true, if is compare 2 lists
	 */
	public boolean isCompare2Lists(WebDriver driver, List<String> theFirstListContent,
			List<String> theSecondListContent) {
		return theSecondListContent.containsAll(theFirstListContent);
	}

	/**
	 * Check to see if the value you are looking for in the list or not.
	 *
	 * @param driver              the driver
	 * @param listContentXpath    the list content xpath. The purpose is to get a
	 *                            list of values to compare.
	 * @param getContentToCompare Get the content to compare, this content you want
	 *                            to have in the list.
	 * @return true, if is content in list
	 */
	public boolean isContentInList(WebDriver driver, String listContentXpath, String getContentToCompare) {
		if (isElementDisplayed(driver, listContentXpath)) {
			List<WebElement> listContent = findElementsByXpath(driver, listContentXpath);
			List<String> contentList = new ArrayList<String>();
			for (WebElement content : listContent) {
				contentList.add(content.getText());
			}
			return contentList.contains(getContentToCompare);
		} else {
			try {
				throw new Exception("No data found!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Delete data to reset.
	 *
	 * @param requestUrl      the request url
	 * @param merchantValue   the merchant value
	 * @param socialTypeValue the social type value
	 * @param objectTypeValue the object type value
	 */
//	
	public void deleteDataToReset(String requestUrl, String merchantValue, String socialTypeValue,
			String objectTypeValue) {
		String editApi = requestUrl;
		try {
			Unirest.delete(editApi).routeParam("merchantID", merchantValue).routeParam("socialTypeID", socialTypeValue)
					.routeParam("objectTypeID", objectTypeValue).asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Delete all ticket.
	 *
	 * @param requestUrl    the request url
	 * @param merchantValue the merchant value
	 */
//	public void deleteAllTicket(String requestUrl, String urlDomain, String pathAPI, String merchantValue,
//			String account, String password) {
//		try {
//			Unirest.delete(requestUrl)
//			.header("Authorization", "Bearer " + getTokenSite(urlDomain, pathAPI, account, password))
//			.header("x-merchant-id", merchantValue).asJson();
//		} catch (UnirestException e) {
//			e.printStackTrace();
//		}
//		
//	}

	// Do dev chua by pass dc PEM nen dung tam basic token de by pass thay vi tu
	// dong update token theo website
	public void deleteAllTicket(String requestUrl, String merchantValue) {
		try {
			Unirest.delete(requestUrl).header("Authorization", "Basic f38b67fa-22f3-4680-9d01-c36b23bd0cad")
					.header("x-merchant-id", merchantValue).asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Copy and paste some texts.
	 *
	 * @param driver      the driver
	 * @param fromLocator the from locator
	 * @param toLocator   the to locator
	 */
	public void copyPasteSomeText(WebDriver driver, String fromLocator, String toLocator) {
		WebElement element = findElementByXpath(driver, fromLocator);
		action = new Actions(driver);
		action.moveToElement(element).doubleClick().perform();
		action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		WebElement textboxDestination = findElementByXpath(driver, toLocator);
		textboxDestination.clear();
		textboxDestination.click();
		action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		action.build().perform();
	}
	
	/**
	 * Switch to new tab. Used when you want to switch to a new tab in the same
	 * driver.
	 *
	 * @param driver the driver
	 */
	public void switchToNewTab(WebDriver driver) {
		ArrayList<String> numberOfTabs = new ArrayList<String>(driver.getWindowHandles());
		int tabNumber = numberOfTabs.size();
		driver.switchTo().window(numberOfTabs.get(tabNumber - 1));
		sleepInSecond(3);
	}

	/**
	 * Close new tab.
	 *
	 * @param driver the driver
	 */
	public void closeNewTab(WebDriver driver) {
		driver.close();
	}

	/**
	 * Split item.
	 *
	 * @param originalList the original list
	 * @return the array list
	 */
	public ArrayList<String> splitItem(List<String> originalList) {
		ArrayList<String> arrSplit = new ArrayList<>();
		String[] arr = null;
		for (String splitString : originalList) {
			arr = splitString.split("[ \n]");
			for (String item : arr) {
				arrSplit.add(item.trim());
			}
		}
		return arrSplit;
	}

	/**
	 * Removes the duplicated item.
	 *
	 * @param originalList the original list
	 * @param removeList   the remove list
	 * @return the list
	 */
	public List<String> removeDuplicatedItem(List<String> originalList, List<String> removeList) {
		List<String> stringList = new ArrayList<>();
		for (String originalItem : originalList) {
			if (!removeList.contains(originalItem.trim())) {
				stringList.add(originalItem.trim());
			}
		}
		return stringList;
	}

	/**
	 * Encode string.
	 *
	 * @param message the message
	 * @return the string
	 */
	public String encodeString(String message) {
		if (message == null)
			return null;

		for (int i = 0; i < message.length(); i++) {
			switch (message.charAt(i)) {
			case ' ':
				return message.replaceAll("\\s", "&nbsp;");
			case '\"':
				return message.replaceAll("\"", "&quot;");
			case '\'':
				return message.replaceAll("\'", "&#039;");
			case '<':
				return message.replaceAll("<", "&lt;");
			case '>':
				return message.replaceAll(">", "&gt;");
			case '\t':
				return message.replaceAll("\t", "&nbsp;&nbsp;");
			}
		}
		return message;
	}

	/**
	 * Format input text to HTML.
	 *
	 * @param message the message
	 * @return the string has HTML format
	 */
	public String formatInputedText(String message) {
		message = encodeString(message);
		return StringEscapeUtils.unescapeHtml(message);
	}

	/**
	 * Sentence case.
	 *
	 * @param sentence the sentence
	 * @return the string
	 */
	public String sentenceCase(String sentence) {
		sentence = sentence.toLowerCase();
		String preSentence = sentence.substring(0, 1).toUpperCase();
		String endSentence = sentence.substring(1);
		return preSentence.concat(endSentence);
	}

	/**
	 * Parses the JCON string.
	 *
	 * @param postLogin the post login
	 * @return the string
	 */
	public static String parseJCONString(PostLogin postLogin) {
		if (postLogin == null) {
			throw new IllegalArgumentException("Post body can't be null");
		}
		return new Gson().toJson(postLogin);
	}

	/**
	 * Gets the token site.
	 *
	 * @param baseURI      the base URI
	 * @param pathLoginAPI the path login API
	 * @param userName     the user name
	 * @param password     the password
	 * @return the token site
	 */
	public String getTokenSite(String baseURI, String pathLoginAPI, String userName, String password) {
		// Form up request object and header
		RequestSpecification request = given();
		request.baseUri(baseURI);
		request.header(new Header("Content-type", "application/json"));

		// Construct body
		PostLogin postLogin = new PostLogin(userName, password);
		String postLoginStr = parseJCONString(postLogin);
		Response response = request.body(postLoginStr).post(pathLoginAPI);

		Map<String, String> loginInfo = JsonPath.from(response.asString()).get();
		return loginInfo.get("jwt");
	}
}

class PostLogin {
	private String username;
	private String password;

	public PostLogin() {
		super();
	}

	public PostLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
