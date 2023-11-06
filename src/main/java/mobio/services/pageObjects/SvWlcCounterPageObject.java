package mobio.services.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.IllegalAddException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import autolibraries.mobioLibs;
import mobio.pageUIs.CommonPageUI;
import mobio.services.pageUIs.ServicesPageUI;
import mobio.services.pageUIs.SvWlcCounterPageUI;
import mobio.services.pageUIs.SvWlcFilterPageUI;


/**
 * The Class HomePageObject.
 */
public class SvWlcCounterPageObject extends mobioLibs {

    /**
     * The driver.
     */
    WebDriver driver;

    /**
     * The driver.
     */
    public static String itemCount = "0";
    public static String getContent;
    public static String randomReply;
    public static String quickReply;
    public static String addedTagName;
    public static List<String> contentAllStartList = new ArrayList<>();

    /**
     * Instantiates a new home page object.
     *
     * @param _driver the driver
     */
    public SvWlcCounterPageObject(WebDriver _driver) {
        driver = _driver;
    }

    public void holdTopMessage() {
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_ICON)) {
            int countPin = countAllItemInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_ICON);
            String locator = SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM + '[' + (countPin + 1) + ']';
            waitToElementClickable(driver, locator);
            hoverMouseToElement(driver, locator);
            sleepInSecond(5);
        } else {
            String locator = SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM + "[" + 1 + "]";
            waitToElementClickable(driver, locator);
            hoverMouseToElement(driver, locator);
            sleepInSecond(5);
        }
    }

    public void clickOneComment(String randomElement) {
        sleepInSecond(5);
        if (isElementDisplayed(driver, randomElement)) {
            int totalRow = countElementNumber(driver, randomElement);
            int rowNumber = randomRowNumber(totalRow);
            String locator = randomElement + "[" + rowNumber + "]";
            sleepInSecond(3);
            waitToElementClickable(driver, locator);
            scrollToElement(driver, locator);
            getContent = getTextElement(driver, locator);
//            try {
                if ((getContent.contains("đã gửi 1 video")) || (getContent.contains("đã gửi 1 ảnh"))
                        || (getContent.contains("Đã gửi 1 ảnh gif"))) {
                    rowNumber = randomRowNumber(totalRow);
                    locator = randomElement + "[" + rowNumber + "]";
                    
                    waitToElementClickable(driver, locator);
                    scrollToElement(driver, locator);
                    getContent = getTextElement(driver, locator);
                }
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//            waitToElementClickable(driver, locator);
//            scrollToElement(driver, locator);
//            getContent = getTextElement(driver, locator);
            clickToElement(driver, locator);
            sleepInSecond(3);
        }
    }

    public void replyOnes() {
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_ALL_ITEM)) {
            switchToIframe(driver, SvWlcCounterPageUI.FB_REPLY_IFRAME);
            waitToElementVisible(driver, SvWlcCounterPageUI.FB_REPLY_TXTA);
            randomReply = "May I help you! " + randomNumber();
            sendkeyToElement(driver, SvWlcCounterPageUI.FB_REPLY_TXTA, randomReply);
            findElementByXpath(driver, SvWlcCounterPageUI.FB_REPLY_TXTA).sendKeys(Keys.ENTER);
            sleepInSecond(3);
            driver.switchTo().parentFrame();
            waitToElementInVisible(driver, SvWlcCounterPageUI.SOCIAL_LOADING_ICON);
        }
    }

    public void replyOnesMsg() {
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_ALL_ITEM)) {
            switchToIframe(driver, SvWlcCounterPageUI.FB_REPLY_MSG_IFRAME);
            waitToElementVisible(driver, SvWlcCounterPageUI.FB_REPLY_TXTA);
            randomReply = "May I help you! " + randomNumber();
            sendkeyToElement(driver, SvWlcCounterPageUI.FB_REPLY_TXTA, randomReply);
            findElementByXpath(driver, SvWlcCounterPageUI.FB_REPLY_TXTA).sendKeys(Keys.ENTER);

            waitToElementInVisible(driver, SvWlcCounterPageUI.SOCIAL_LOADING_ICON);
            backToDefault(driver);
        }
    }

    public void clickOnAFbTab(String tabName) {
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        sleepInSecond(2);
        waitToElementVisible(driver, SvWlcCounterPageUI.SOCIAL_TAB_NUMBER_LBL, tabName);
        itemCount = getTextElement(driver, SvWlcCounterPageUI.SOCIAL_TAB_NUMBER_LBL, tabName);
        waitToElementClickable(driver, SvWlcCounterPageUI.SOCIAL_TAB_BTN, tabName);
        clickToElement(driver, SvWlcCounterPageUI.SOCIAL_TAB_BTN, tabName);
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
    }

    public void getNumberOnTab(String tabName) {
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        sleepInSecond(20);
        waitToElementVisible(driver, SvWlcCounterPageUI.SOCIAL_TAB_NUMBER_LBL, tabName);
        itemCount = getTextElement(driver, SvWlcCounterPageUI.SOCIAL_TAB_NUMBER_LBL, tabName);
    }

    public void assignTask(String userAccount, String itemInListLocator) {
        waitToElementClickable(driver, itemInListLocator);
        clickOneComment(itemInListLocator);
        waitToElementClickable(driver, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN);
        clickToElement(driver, SvWlcCounterPageUI.MSG_FORWARD_REPLY_BTN);
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        sleepInSecond(1);
        waitToElementVisible(driver, SvWlcCounterPageUI.ASSIGNED_DROP);
        selectItemInCustomDropdown(driver, SvWlcCounterPageUI.ASSIGNED_DROP, SvWlcCounterPageUI.ASSIGNED_ALL_ITEMS_DROP,
                userAccount);
        waitToElementClickable(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, "Chuyển tiếp");
        clickToElementByJS(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, "Chuyển tiếp");
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        sleepInSecond(5);
    }

    public void sortNewest() {
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SORT_OLDEST_LBL)) {
            clickToElement(driver, SvWlcCounterPageUI.FB_SORT_MENU);
            clickToElement(driver, SvWlcCounterPageUI.FB_SORT_NEWEST_ITEM);
            waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        }
    }

    public void sortOldest() {
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SORT_NEWEST_LBL)) {
            clickToElement(driver, SvWlcCounterPageUI.FB_SORT_MENU);
            clickToElement(driver, SvWlcCounterPageUI.FB_SORT_OLDEST_ITEM);
            waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        }
    }

    public void clickCommentTabAndGetList(String tabName) {
        clickOnAFbTab(tabName);
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM))
            contentAllStartList = getOriginalList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM);
        else {
            contentAllStartList = null;
        }
    }

//    public void addTagIntoComment(String tagName, String buttonName) {
//        addedTagName = tagName;
//        if (isElementDisplayed(driver, SvWlcFilterPageUI.CHOSE_TAG_ITEM)) {
//            String selectedTag = getTextElement(driver, SvWlcFilterPageUI.All_SELECTED_TAG_ITEM);
//            if (!selectedTag.contains(tagName)) {
//                waitToElementVisible(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
//                waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
//                clickToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
//                sendkeyToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT, tagName);
//                waitToElementVisible(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
//                sleepInSecond(1);
//                if (isElementDisplayed(driver, SvWlcCounterPageUI.FB_ALL_TAG_NAME_ITEM)) {
//                    String checkExistTag = getTextElement(driver, SvWlcCounterPageUI.FB_ALL_TAG_NAME_ITEM);
//                    if (!checkExistTag.contains(tagName)) {
//                        addTagInCaseBlank(tagName, buttonName);
//                    } else {
//                        addTagInCaseExistedTagName(tagName, buttonName);
//                    }
//                } else {
//                    addTagInCaseBlank(tagName, buttonName);
//                }
//            } else {
//                clickToElement(driver, CommonPageUI.CLOSE_BTN);
//            }
//        } else {
//            waitToElementVisible(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
//            clickToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
//            waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
//            clickToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
//            sendkeyToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT, tagName);
//            sleepInSecond(1);
//            if (isElementDisplayed(driver, SvWlcCounterPageUI.FB_ALL_TAG_NAME_ITEM)) {
//                String checkExistTag = getTextElement(driver, SvWlcCounterPageUI.FB_ALL_TAG_NAME_ITEM);
//                if (!checkExistTag.contains(tagName)) {
//                    addTagInCaseBlank(tagName, buttonName);
//                } else {
//                    addTagInCaseExistedTagName(tagName, buttonName);
//                }
//            } else {
//                addTagInCaseBlank(tagName, buttonName);
//            }
//        }
//    }
//
//    private void addTagInCaseBlank(String tagName, String buttonName) {
//        tagName = formatInputedText(tagName);
//        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
//        waitToElementClickable(driver, SvWlcFilterPageUI.ADD_NEW_TAG_BTN);
//        clickToElement(driver, SvWlcFilterPageUI.ADD_NEW_TAG_BTN);
//        sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX, tagName, "Nhập nội dung");
//        clickToElement(driver, SvWlcCounterPageUI.SAVE_NEW_TAG_BTN);
//        //thêm
//        clickToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
//        sendkeyToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT, tagName);
//        addTagInCaseExistedTagName(tagName, buttonName);
//    }
//
//    private void addTagInCaseExistedTagName(String tagName, String buttonName) {
//        sendkeyToElement(driver, SvWlcFilterPageUI.FORWARD_TAG_TXT, tagName);
//        sleepInSecond(1);
//        clickToElement(driver, SvWlcCounterPageUI.TAG_NAME_ITEM, formatInputedText(tagName));
//        sleepInSecond(1);
//        clickToElement(driver, SvWlcCounterPageUI.ADD_TAG_LBL);
//        clickToElement(driver, CommonPageUI.DYNAMIC_BUTTON, buttonName);
//        sleepInSecond(1);
//    }

    public void addTagIntoComment(String tagName, String buttonName) {
		addedTagName = tagName;
		if (isElementDisplayed(driver, SvWlcFilterPageUI.CHOSE_TAG_ITEM)) {
			String selectedTag = getTextElement(driver, SvWlcFilterPageUI.All_SELECTED_TAG_ITEM);
			if (!selectedTag.contains(tagName)) {
				sendkeyToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT, tagName);
				clickToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
				waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
				sleepInSecond(3);
				if (isElementDisplayed(driver, SvWlcCounterPageUI.FB_ALL_TAG_NAME_ITEM)) {
					String checkExistTag = getTextElement(driver, SvWlcCounterPageUI.FB_ALL_TAG_NAME_ITEM);
					if (!checkExistTag.contains(tagName)) {
						addTagInCaseBlank(tagName, buttonName);
					} else {
						addTagInCaseExistedTagName(tagName, buttonName);
					}
				} else {
					addTagInCaseBlank(tagName, buttonName);
				}
			} else {
				clickToElement(driver, CommonPageUI.CLOSE_BTN);
			}
		} else {
			sendkeyToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT, tagName);
			clickToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
			waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
			if (isElementDisplayed(driver, SvWlcCounterPageUI.FB_ALL_TAG_NAME_ITEM)) {
				String checkExistTag = getTextElement(driver, SvWlcCounterPageUI.FB_ALL_TAG_NAME_ITEM);
				if (!checkExistTag.contains(tagName)) {
					addTagInCaseBlank(tagName, buttonName);
				} else {
					addTagInCaseExistedTagName(tagName, buttonName);
				}
			} else {
				addTagInCaseBlank(tagName, buttonName);
			}
		}
	}

	private void addTagInCaseBlank(String tagName, String buttonName) {
		waitToElementClickable(driver, SvWlcFilterPageUI.ADD_NEW_TAG_BTN);
		clickToElement(driver, SvWlcFilterPageUI.ADD_NEW_TAG_BTN);
		sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX, tagName, "Nhập nội dung");
		clickToElement(driver, ServicesPageUI.SAVE_NEW_TAG_BTN);

		sendkeyToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT, tagName);
		clickToElement(driver, SvWlcCounterPageUI.FB_ADD_TAG_REPLY_TXT);
		waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);

		addTagInCaseExistedTagName(tagName, buttonName);
	}

	private void addTagInCaseExistedTagName(String tagName, String buttonName) {
		if (isElementDisplayed(driver, ServicesPageUI.ALL_TAG_NAME_ITEM)) {
			List<WebElement> allItems = driver.findElements(By.xpath(ServicesPageUI.ALL_TAG_NAME_ITEM));
			for (WebElement item : allItems) {
				if (item.getText().equals(tagName)) {
					item.click();
					sleepInSecond(1);
					break;
				}
			}
		} else {
			throw new IllegalAddException("No data found!");
		}

		clickToElement(driver, ServicesPageUI.WORK_TAG_LBL);
		sleepInSecond(1);
		clickToElement(driver, CommonPageUI.DYNAMIC_BASIC_BUTTON, buttonName);
		sleepInSecond(1);
	}
    
    public void pinMessage(String fbElementNoPin) {

        try {
            // The first: Unpin all items
            if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_ICON)) {
                List<WebElement> pinElements = findElementsByXpath(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_ICON);
                for (WebElement pinItem : pinElements) {
                    pinItem.click();
                    sleepInSecond(2);
                    clickToElement(driver, SvWlcCounterPageUI.SOCIAL_ITEM_3DOTS_ICON);
                    waitToElementClickable(driver, SvWlcCounterPageUI.SOCIAL_MESSAGE_REMOVE_PIN_TOOLTIP);
                    clickToElement(driver, SvWlcCounterPageUI.SOCIAL_MESSAGE_REMOVE_PIN_TOOLTIP);
                    sleepInSecond(2);
                }
            }

            // Select one item that has no pin
            if (isElementDisplayed(driver, fbElementNoPin)) {
                int totalRow = countElementNumber(driver, fbElementNoPin);
                int rowNumber = randomRowNumber(totalRow);
                String locator = fbElementNoPin + "[" + rowNumber + "]";
                waitToElementVisible(driver, locator);
                hoverMouseToElement(driver, locator);
                clickToElement(driver, SvWlcCounterPageUI.SOCIAL_ITEM_3DOTS_ICON);
                sleepInSecond(2);
            }

            // Pin this item
            waitToElementClickable(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_TOOLTIP);
            clickToElement(driver, SvWlcCounterPageUI.SOCIAL_ITEM_PIN_TOOLTIP);
            sleepInSecond(3);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isContentDisplayInList() {
        System.out.println(" Content sau đó " + getContent);
        return getOriginalList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM).contains(getContent);
    }

    public void clickToReplyItem() {
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_NOT_REPLY)) {
            switchToIframe(driver, SvWlcCounterPageUI.FB_REPLY_IFRAME);
            waitToElementVisible(driver, SvWlcCounterPageUI.FB_REPLY_TXTA);
            clickToElement(driver, SvWlcCounterPageUI.FB_REPLY_TXTA);
            sleepInSecond(1);
            driver.switchTo().defaultContent();
            sleepInSecond(5);
        }
    }

    public boolean isSortDataInList() {
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM)) {
            System.out.println("săp xêp " + isNewListCompare(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM,
                    SvWlcCounterPageUI.TAIL_ALL_CONTENT_PIN_ITEM, SvWlcCounterPageUI.TAIL_UNANSWER_NO_PIN_ITEM,
                    SvWlcCounterPageUI.TAIL_ANSWERED_NO_PIN_ITEM));
            return isNewListCompare(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM,
                    SvWlcCounterPageUI.TAIL_ALL_CONTENT_PIN_ITEM, SvWlcCounterPageUI.TAIL_UNANSWER_NO_PIN_ITEM,
                    SvWlcCounterPageUI.TAIL_ANSWERED_NO_PIN_ITEM);
        } else {
            try {
                throw new Exception("Not found element!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public void selectQuickReplyMsg(String quickReplyContent) {
        quickReply = quickReplyContent;
        if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_ALL_ITEM)) {
            waitToElementClickable(driver, SvWlcCounterPageUI.QUICK_REPLY_TXT, quickReplyContent);
            sleepInSecond(2);
            clickToElement(driver, SvWlcCounterPageUI.QUICK_REPLY_TXT, quickReplyContent);
            switchToIframe(driver, SvWlcCounterPageUI.FB_REPLY_MSG_IFRAME);
            waitToElementClickable(driver, SvWlcCounterPageUI.FB_REPLY_TXTA);
            clickToElement(driver, SvWlcCounterPageUI.FB_REPLY_TXTA);
            sendkeyControl(driver, SvWlcCounterPageUI.FB_REPLY_TXTA, Keys.ENTER);
            sleepInSecond(2);
            driver.switchTo().defaultContent();
            waitToElementInVisible(driver, SvWlcCounterPageUI.SOCIAL_LOADING_ICON);
            sleepInSecond(2);
        }

    }

    public void dragAndDropQuickReply(String quickReplyContent) {
        Actions action = new Actions(driver);
        WebElement from = findElementByXpath(driver, SvWlcCounterPageUI.QUICK_REPLY_ONE_ITEM, quickReplyContent);
        action.clickAndHold(from).perform();
        sleepInSecond(2);
        switchToIframe(driver, SvWlcCounterPageUI.FB_REPLY_MSG_IFRAME);
        sleepInSecond(2);
        WebElement destination = findElementByXpath(driver, SvWlcCounterPageUI.FB_REPLY_TXTA);
        sleepInSecond(2);
        action.moveToElement(destination).release(destination).build().perform();
        sleepInSecond(2);
        // action.release(destination).build().perform();
        sleepInSecond(2);
        // clickToElement(driver, SvWlcCounterPageUI.FB_REPLY_TXTA);
        action.sendKeys(SvWlcCounterPageUI.FB_REPLY_TXTA, Keys.ENTER);
        // sendkeyControl(driver, SvWlcCounterPageUI.FB_REPLY_TXTA, Keys.ENTER);
        driver.switchTo().defaultContent();
        sleepInSecond(5);
    }

    public void ClickOldRepliedItem() {
        clickToElement(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ITEM, randomReply);
        sleepInSecond(1);
    }

    public void clickOnTheMessageTab(String tabName) {
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
        waitToElementClickable(driver, SvWlcCounterPageUI.SOCIAL_TAB_BTN, tabName);
        clickToElement(driver, SvWlcCounterPageUI.SOCIAL_TAB_BTN, tabName);
        waitShortToElementInVisible(driver, CommonPageUI.LOADING_ICON);
    }

    public void clickToNewItemOnNotifications() {
        clickToElement(driver, SvWlcCounterPageUI.NEW_COMMENT_CONTENT, SvWebLiveChatPageObject.wlcMessage);
    }

    public boolean isCommentJumpToList() {
    	
        System.out.println("so sanh " + SvWebLiveChatPageObject.wlcMessage );
        return isContentInList(driver, SvWlcCounterPageUI.SOCIAL_ITEM_CONTENT_ALL_ITEM,
                SvWebLiveChatPageObject.wlcMessage);
    }

    public boolean isCommentOnColumn2() {
        return isElementDisplayed(driver, SvWlcCounterPageUI.CONTENT_ITEM_COLUMN2_LBL,
              SvWebLiveChatPageObject.wlcMessage);
    }
    
    public void copyAndPasteText() {
		if (isElementDisplayed(driver, SvWlcCounterPageUI.SOCIAL_ITEM_ALL_ITEM)) {
			switchToIframe(driver, SvWlcCounterPageUI.FB_REPLY_MSG_IFRAME);
			waitToElementVisible(driver, SvWlcCounterPageUI.FB_REPLY_TXTA);
			randomReply = "Copy and paste text! " + randomNumber();
			sendkeyToElement(driver, SvWlcCounterPageUI.FB_REPLY_TXTA, randomReply);
			copyPasteSomeText(driver, SvWlcCounterPageUI.FB_REPLY_TXTA, SvWlcCounterPageUI.FB_REPLY_TXTA);
			findElementByXpath(driver, SvWlcCounterPageUI.FB_REPLY_TXTA).sendKeys(Keys.ENTER);
			sleepInSecond(5);
			driver.switchTo().defaultContent();
			waitToElementInVisible(driver, SvWlcCounterPageUI.SOCIAL_LOADING_ICON);
		}
	}
}
