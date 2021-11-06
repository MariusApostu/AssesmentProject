package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReadProperties;
import utils.SeleniumWrappers;
import static org.testng.Assert.assertTrue;

public class CheckOutPage extends SeleniumWrappers {
    public WebDriver driver;

    public String firstName  = ReadProperties.config.getProperty("firstName");
    public String lastName = ReadProperties.config.getProperty("lastName");
    public String streetAddress  = ReadProperties.config.getProperty("streetAddress");
    public String city = ReadProperties.config.getProperty("town/city");
    public String zipCode  = ReadProperties.config.getProperty("zipCode");
    public String phoneNumber = ReadProperties.config.getProperty("phone");
    public String emailAddress = ReadProperties.config.getProperty("email");


    public CheckOutPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "input[id='billing_first_name']") public WebElement firstNameField;
    @FindBy (css = "input[id='billing_last_name']") public WebElement lastNameField;
    @FindBy (css = "input[id='billing_address_1']") public WebElement streetAddressField;
    @FindBy (css = "input[id='billing_city']") public WebElement townOrCityField;
    @FindBy (css = "input[id='billing_postcode']") public WebElement zipCodeField;
    @FindBy (css = "input[id='billing_phone']") public WebElement phoneNumberField;
    @FindBy (css = "button[id='place_order']") public WebElement placeOrderButton;
    @FindBy (css = "input[type='checkbox']") public WebElement conditionsCheckBox;
    @FindBy (css = "p[class*='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']") public WebElement orderReceivedMessage;
    @FindBy (css = "li[class*='woocommerce-order-overview__order order']") public WebElement orderNumber;
    @FindBy (css = "input[id='billing_email']") public WebElement emailAddressField;


    public void checkOut(String firstName, String lastName, String streetAddress, String city, String zipCode, String phoneNumber, String emailAddress){
        click(firstNameField);
        sendKeys(firstNameField, firstName);
        click(lastNameField);
        sendKeys(lastNameField, lastName);
        click(streetAddressField);
        sendKeys(streetAddressField, streetAddress);
        click(townOrCityField);
        sendKeys(townOrCityField, city);
        click(zipCodeField);
        sendKeys(zipCodeField, zipCode);
        click(phoneNumberField);
        sendKeys(phoneNumberField, phoneNumber);
        click(emailAddressField);
        sendKeys(emailAddressField, emailAddress);
        click(conditionsCheckBox);
        click(placeOrderButton);
        waitForElementToBeDisplayed(orderReceivedMessage);
        waitForElementToBeDisplayed(orderNumber);
        assertTrue(orderReceivedMessage.getText().contains("Thank you. Your order has been received."));
        assertTrue(orderNumber.getText().contains("Order number:"));

    }



}
