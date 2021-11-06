package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

import static org.testng.Assert.*;

public class ShopPage extends SeleniumWrappers {
    public WebDriver driver;
    HomePage homePage;
    NavigationMenuPage navPage;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css= "span[class*='text']") public WebElement categoriesTab;
    @FindBy(linkText = "Frozen Foods") public WebElement frozenFoodsTab;
    @FindBy(linkText = "Beverages") public WebElement beveragesTab;

    @FindBy(css = "a[title*='Frozen Beef & Cheese Mini Tacos']") public WebElement miniTacos;
    @FindBy(css = "a[data-product_id = '368']") public WebElement addMiniTacos;
    @FindBy(css = "a[title*='Gorton’s Beer Battered Fish Fillets']") public WebElement fishFillets;
    @FindBy(css = "a[data-product_id = '362']") public WebElement addFishFillets;
    @FindBy(css = "a[title*= 'Coca-Cola – 2 L Bottle']") public WebElement cocaCola;
    @FindBy(css = "a[data-product_id = '387']") public WebElement addCocaCola;

    @FindBy(css = "td[data-title*='Total']") public WebElement totalCost;

    @FindBy(css = "input[name='coupon_code']") public WebElement couponCodeField;
    @FindBy(css = "button[type*=submit]") public WebElement applyCouponButton;


    public void applyDiscount () throws InterruptedException {
        homePage = new HomePage(driver);
        click(homePage.cartButon);
        totalCost.getText();
        String firstTotal = totalCost.getText();
        sendKeys(couponCodeField,"keyfood31122021");
        click(applyCouponButton);
        Thread.sleep(3000);
        System.out.println("The total was: " + totalCost.getText());
        String secondTotal = totalCost.getText();
        assertFalse(firstTotal.equals(secondTotal));
    }
}
