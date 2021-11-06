package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest {

    /**
     * Method used to perform a double click
     * @param element : WebElement
     */
    public void doubleClick(WebElement element) {
        try{
            waitForElementToBeDisplayed(element);
            Actions actions =  new Actions(driver);
            actions.doubleClick(element).perform();
        }catch (Exception e) {
            throw new TestException("The element was not present");
        }
    }

    /**
     * Method used to hover over an WebElement
     * @param element : WebElement
     */
    public void hoverElement(WebElement element) {
        try{
            waitForElementToBeDisplayed(element);
            Actions actions =  new Actions(driver);
            actions.moveToElement(element).perform();
        }catch (Exception e) {
            throw new TestException("The element was not present");
        }
    }

    /**
     * Method used to drag and drop a slider WebElement
     * @param element : WebElement
     * @param xOffset : sliding on the X axis (horizontal)
     * @param yOffset : sliding on the Y axis (vertical)
     */
    public void dragAndDropSlider(WebElement element, int xOffset, int yOffset){
        try{
            waitForElementToBeDisplayed(element);
            Actions actions =  new Actions(driver);
            actions.dragAndDropBy(element, xOffset, yOffset).perform();
        }catch (Exception e) {
            throw new TestException("The element was not present");
        }
    }

    /**
     * Method used to wait for an element to be displayed (present) to reduce flakiness (lack of reliability)
     * @param element : WebElement
     */
    public void waitForElementToBeDisplayed(WebElement element) {
        try{
            Log.info("Called the <waitForElementToBeDisplayed> on element" + element);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            Log.error(e.getStackTrace().toString());
            throw new TestException("The element was not present");
        }
    }

    /**
     * Method used to wait for an element to be clickable to reduce flakiness (lack of reliability)
     * @param element : WebElement
     */
    public void waitForElementToBeClickable(WebElement element) {
        try{
            Log.info("Called the <waitForElementToBeClickable> on element" + element);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            Log.error("Failed on <waitForElementToBeClickable>  on element" + element);
            throw new TestException("The element was not present");
        }
    }

    /**
     * Method used to send key values (String) to an input or text area field
     * First clears the element of any text
     * @param element : WebElement that receives the text input
     * @param value : The String value to be sent
     */
    public void sendKeys(WebElement element, String value) {
        try{
            waitForElementToBeDisplayed(element);
            element.clear();
            element.sendKeys(value);
        }catch (Exception e){
            throw new TestException("The element was not present");
        }
    }

    /**
     * Method used to click an element. Makes use of method waitForElementToBeClickable(element);
     * @param element : element to be clicked on (type WebElement)
     */
    public void click(WebElement element) {
        Log.info("Called the <click> on element" + element);
        waitForElementToBeClickable(element);
        try {
            element.click();
        }catch(StaleElementReferenceException e) {
            Log.error("error catched StaleElementReferenceException");
            element.click();
        }catch (Exception e) {
            throw new TestException("Element was not clickable");
        }
    }


}
