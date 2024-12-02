package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class BrowserUtils {
    //This method will accept int (in seconds) and execute Thread.sleep method for given duration
    public static void sleep(int second) {
        second = second * 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
        }
    }
    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle) {
        //return and store all window handles in a Set
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for(String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("Curent URL: " + Driver.getDriver().getCurrentUrl());
            if(Driver.getDriver().getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }
        //Assert:Title contains "Etsy"
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }
    public static void verifyTitleContains( String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }
    //This method accepts WebElement target, and waits for that WebElement not to be displayed on the page

    public static void waitForInvisibilityOf(WebElement target){
        //create the object of "WebDriverWait" class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }
    //This method accepts String title, and waits for that Title to contain given String value
    public static void waitForTitleContains(String title){
        //create the object of "WebDriverWait" class, and set up the contructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use "wait" object to create explicit wait condition
        wait.until(ExpectedConditions.titleContains(title));
    }
    /**
     *  This method accepts dropdown element and returns a List<String> that contains all options values as String
     *     @param dropdownElement
     *     @return actualMonth_as_String
     */
    public static List<String> dropdownOptions_as_String(WebElement dropdownElement){
        Select month = new Select(dropdownElement);

        //Storing all the ACTUAL options into a List of WebElements
        List<WebElement> actualMonth_as_WebElement = month.getOptions();
        //Creating an EMPTY list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_String = new ArrayList<String>();

        //Looping through the List<WebElement>, getting all options' texts, and storing them into List<String>
        for(WebElement each : actualMonth_as_WebElement){
            actualMonth_as_String.add(each.getText());
        }
        return actualMonth_as_String;
    }
    public static void clickRadioButton(List<WebElement> radioButtons, String atributeValue){
        for(WebElement each : radioButtons){
            if(each.getAttribute("value").equalsIgnoreCase(atributeValue)){
                each.click();
            }
        }
    }
    ///  This method will accept String as expected value and verify actual URL contains value
    public static void verifyURLContains(String expectedURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedURL));
    }
    /// Switches to new window by the exact title. Returns to original window if target title not found
    public static void switchToWindow(String targetTitle){
        String origin = Driver.getDriver().getWindowHandle();
        for(String handle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(handle);
            if(Driver.getDriver().getTitle().equals(targetTitle)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
    /**
     *   Moves the mouse to given element
     *   @param element on which to hover
     */

    public static void hover(WebElement element){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).perform();
    }
    /**
     * return a list of string from a list of elements
     * @param list of webElement
     *@return list of string

     */
    public static List<String> getElementsText(List<WebElement> list){
        List<String>elementText = new ArrayList<>();
        for(WebElement element: list){
            elementText.add(element.getText());
        }
        return elementText;
    }
    /**
     * Extracts text from list of elements matching the provided locator into new List<String>
     * @param locator
     * @return list of String
     */

    public static List<String>getElementsText(By locator){
        List<WebElement>elements = Driver.getDriver().findElements(locator);
        List<String>elementsText = new ArrayList<>();
        for(WebElement element : elements){
            elementsText.add(element.getText());
        }
        return elementsText;
    }
    /**
     *  Performs a pause
     *  @param seconds
     */

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    /**
     * Waits for the provided element to be visible on the page
     * @param time
     * @return
     */
    public static WebElement waitForVisibility(By locator, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    /**
     * waits for provided element to be clickable
     * @param element
     * @param time
     * @return
     */
    public static WebElement waitForClickability(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * waits for element matching the locator to be clickable
     * @param locator
     * @param time
     * @return
     */
    public static WebElement waitForClickability(By locator, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    /**
     * waits for backgrounds processes on the browser to comlite
     * @param time
     */
    public static void waitForPageLoad(long time){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
    };
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
            wait.until(expectation);
        }catch (Throwable error){
        error.printStackTrace();}
    }
    /**
     * verifies whether element matching provided locator is displayed on page
     *
     * @param by
     * @throws AssertionError if the element matching the provided locator is not found or not displayed
     */
    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);
        }
    }
        /**
         * Verifies whether the element matching the provided locator is NOT displayed on page
         *
         * @param by
         * @throws AssertionError the element matching provided locator is displayed
         */
        public static void verifyElementNotDisplayed(By by){
            try{
                Assert.assertFalse("Element should not be visible: "+ by, Driver.getDriver().findElement(by).isDisplayed());;
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
    }
    /**
     * Verifies whether the element is displayed on page
     *
     * @param element
     * @throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element){
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }
    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }
    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }
    /**
     * Highlighs an element by changing its background and border color
     * @param element
     */
    public static void highlight(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }
    /**
     * attempts to click on provided element until given time runs out
     *
     * @param element
     * @param timeout
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    /**
     * executes the given JavaScript command on given web element
     *
     * @param element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }
    /**
     * executes the given JavaScript command on given web element
     *
     * @param command
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }
    /**
     * This method will recover in case of exception after unsuccessful the click,
     * and will try to click on element again.
     *
     * @param by
     * @param attempts
     */
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                //selenium must look for element again
                clickWithJS(Driver.getDriver().findElement(by));
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                //print attempt
                e.printStackTrace();
                ++counter;
                //wait for 1 second, and try to click again
                waitFor(1);
            }
        }
    }
    /**
     *  checks that an element is present on the DOM of a page. This does not
     *    * necessarily mean that the element is visible.
     * @param by
     * @param time
     */
    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static String getAttributeValue(WebElement webElement, String attribute) {

        return webElement.getAttribute(attribute);
    }
    public static void navigateToBack(){
        Driver.getDriver().navigate().back();
    }

    public static void clickWithText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }

    public static void clickElementWithPartOfId(String id){
        waitFor(3);
        String locator = "(//*[@id=''+ id])";
                Driver.getDriver().findElement(By.xpath(locator)).click();
    }
    public static void clickElementWithExactId(String id){
        waitFor(3);
        String locator = "(//*[@id=''+ id])";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

    public static void clickElementWithExactClassName(String className){
        waitFor(3);
        WebElement element = Driver.getDriver().findElement(By.className(className));
        waitForVisibility((By) element, 20);
        waitForClickability(element,20);
        element.click();
    }
    public static void switchToFrame(String nameOrId){
        Driver.getDriver().switchTo().frame(nameOrId);
    }

    public static void switchToFrame(WebElement frameElement){
        Driver.getDriver().switchTo().frame(frameElement);
    }
    public static void switchToFrame(int index){
        Driver.getDriver().switchTo().frame(index);
    }
    public static void switchToDefaultContent(){
        Driver.getDriver().switchTo().defaultContent();
    }
    public static WebElement findElementWithClass(String className){
        return Driver.getDriver().findElement(By.className(className));
    }
    public static void typeWithExactId(String message, String id){
        waitFor(2);
        Driver.getDriver().findElement(By.id(id)).sendKeys(message);
    }
    public static int getWindowSize(){
        return  Driver.getDriver().getWindowHandles().size();
    }


    }

