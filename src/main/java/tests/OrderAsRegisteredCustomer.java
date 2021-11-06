package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.TestNgListener;

import static org.testng.Assert.*;

@Listeners(TestNgListener.class)
public class OrderAsRegisteredCustomer extends BaseTest {
    NavigationMenuPage navPage;
    LoginPage loginInApp;
    HomePage homePage;
    SearchProducts product;
    CheckOutPage checkOut;

    @Test(priority = 1)
    public void login() {
        loginInApp = new LoginPage(driver);
        loginInApp.loginInApp(loginInApp.username, loginInApp.password);
    }
    @Test(priority = 2)
    public void selectProduct() throws InterruptedException {
        homePage = new HomePage(driver);
        product = new SearchProducts(driver);
        navPage = new NavigationMenuPage(driver);
        homePage.click(homePage.searchBar);
        homePage.searchBar.sendKeys("Pepsi");
        navPage.navigateTo(product.firstProductSearch);
        product.click(product.addToCartButton);
        homePage.click(homePage.searchBar);
        assertTrue(product.addedMessage.getText().contains( "“Pepsi Cola Soda – 2 L Bottle” has been added to your cart."));
        navPage.navigateTo(product.viewCartButton);
        navPage.click(product.plusQtyButton);
        Thread.sleep(2000);
        assertFalse(product.totalCost.getText().contains( "5.05"));
        product.click(product.checkoutButton);
    }
   @Test(priority = 3)
   public void checkOut() throws InterruptedException {
        checkOut = new CheckOutPage(driver);
        checkOut.checkOut(checkOut.firstName, checkOut.lastName, checkOut.streetAddress, checkOut.city, checkOut.zipCode, checkOut.phoneNumber, checkOut.emailAddress);
   }



}
