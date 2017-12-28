package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;
    private boolean acceptNextAlert = true;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15);
    }

    /**
     * Method check is text present
     *
     * @param text
     */
    public boolean isTextPresent(String text) {
        try {

            return text.contains(text);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method check is element present
     *
     * @param locatorWithText
     */
    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method clear and input text to webElement
     *
     * @param element
     * @param text
     */
    public void enterText(WebElement element, String text) {
        try {
            element.click();
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted.");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    /**
     * Method click to webElement
     *
     * @param element
     */
    public void clickElement(WebElement element) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            logger.info("element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    /**
     * Method click to webElement
     *
     * @param button
     */
    public void clickButton(WebElement button) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            logger.info("button was clicked");
        } catch (Exception e) {
            logger.error("Can not work with button" + button);
            Assert.fail("Can not work with button" + button);
        }
    }

    /**
     * Method clicks to webElement
     *
     * @param link
     */
    public void clickLink(WebElement link) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(link));
            link.click();
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            logger.info("link was clicked");
        } catch (Exception e) {
            logger.error("Can not work with link" + link);
            Assert.fail("Can not work with link" + link);
        }
    }

    /**
     * Method check is element present
     *
     * @param element
     */
    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method check is element disable
     *
     * @param element
     */
    public boolean isElementDisable(WebElement element) {
        try {
            return !element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method get checkbox state
     *
     * @param checkbox
     */
    public boolean getCheckboxState (WebElement checkbox) {
        if(checkbox.isSelected()){
            logger.info("Element is selected");
            return true;
        }
        else {
            logger.info("Element isn't selected");
            return false;
        }
    }

    /**
     * Method set checkbox state
     *
     * @param checkbox
     * @param expectedState
     */
    public void setCheckboxState(WebElement checkbox, String expectedState){
        boolean actualState = getCheckboxState(checkbox);

        if (actualState == true && expectedState == "checked"){
            logger.info("Checkbox is checked");
        }
        else if (actualState == true && expectedState == "unchecked"){
            checkbox.click();
            logger.info("Checkbox is checked");
        }
        else if (actualState == false && expectedState == "checked"){
            checkbox.click();
            logger.info("Checkbox is checked");
        }
        else if (actualState == false && expectedState == "unchecked"){
            logger.info("Checkbox is unchecked");
        }
    }

    /**
     * Method move to element
     *
     * @param element
     */
    public void movetoElement(WebElement element){
        Actions builder = new Actions(webDriver);
        builder.moveToElement(element);
    }

    /**
     * Method move to element and click
     *
     * @param element
     */
    public void movetoElementAndClick(WebElement element){
        Actions builder = new Actions(webDriver);
        builder.moveToElement(element).click(element);
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
    }

    /**
     * Method wait for new window and switch to it
     *
     * @param driver
     */
    public void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
        String cHandle = driver.getWindowHandle();
        String newWindowHandle = null;
        Set<String> allWindowHandles = driver.getWindowHandles();

        //Wait for 20 seconds for the new window and throw exception if not found
        for (int i = 0; i < 20; i++) {
            if (allWindowHandles.size() > 1) {
                for (String allHandlers : allWindowHandles) {
                    if (!allHandlers.equals(cHandle))
                        newWindowHandle = allHandlers;
                }
                driver.switchTo().window(newWindowHandle);
                break;
            } else {
                Thread.sleep(1000);
            }
        }
        if (cHandle == newWindowHandle) {
            throw new RuntimeException(
                    "Time out - No window found");
        }
    }

    /**
     * Method wait for page load
     *
     * @param
     */
    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 2);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    /**
     * Method set implicitly wait
     *
     * @param driver
     * @param seconds
     */
    public void setImplicitlyWait(WebDriver driver, long seconds){

        webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    /**
     * Method get window Handle
     *
     * @param
     */
    public void getWindowHandle(){

        Set Handles = webDriver.getWindowHandles();
        webDriver.switchTo().window((String) Handles.toArray()[1]);
    }

    /**
     * Method wait for element load
     *
     * @param element
     */
    public void waitForElementLoad(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, 2);
        wait.until(ExpectedConditions.visibilityOf(element));

        String actualValue = element.getText();
    }
}


