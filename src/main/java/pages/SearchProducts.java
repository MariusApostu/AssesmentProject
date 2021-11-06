package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;



public class SearchProducts extends SeleniumWrappers {
    public WebDriver driver;
    HomePage homePage;


    public SearchProducts(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class*='dgwt-wcas-st']") public WebElement firstProductSearch;
    //@FindBy(css = "input[type='search']") public WebElement secondProductSearch;

    @FindBy(css = "button[name = 'add-to-cart']") public WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='woocommerce-message'][@role='alert']") public WebElement addedMessage;
    @FindBy(css = "div[class='woocommerce-message']>[class*='button']") public WebElement viewCartButton;
    @FindBy(css = "i[class*='klbth-icon-plus']") public WebElement plusQtyButton;
    @FindBy(css = "td[data-title*='Total']") public WebElement totalCost;
    @FindBy(css = "a[class*='checkout-button']") public WebElement checkoutButton;









}
