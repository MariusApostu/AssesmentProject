package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class DiscountOrderWithoutRegistration extends BaseTest {
    NavigationMenuPage navPage;
    HomePage homePage;
    SearchProducts product;
    CheckOutPage checkOut;
    ShopPage shopPage;

    @Test(priority = 1)
    public void selectProducts() {
        navPage = new NavigationMenuPage(driver);
        shopPage = new ShopPage(driver);
        homePage = new HomePage(driver);

        navPage.hoverElement(shopPage.categoriesTab);
        navPage.navigateTo(shopPage.frozenFoodsTab);
        navPage.hoverElement(shopPage.miniTacos);
        navPage.click(shopPage.addMiniTacos);
        navPage.hoverElement(shopPage.fishFillets);
        navPage.click(shopPage.addFishFillets);
        navPage.click(shopPage.categoriesTab);
        navPage.click(shopPage.beveragesTab);
        navPage.hoverElement(shopPage.cocaCola);
        navPage.click(shopPage.addCocaCola);
    }
    @Test(priority = 2)
            public void discountCoupon () throws InterruptedException {
        shopPage.applyDiscount();
    }

    @Test(priority = 3)
    public void checkOut() {
        checkOut = new CheckOutPage(driver);
        product = new SearchProducts(driver);
        product.click(product.checkoutButton);
        checkOut.checkOut(checkOut.firstName, checkOut.lastName, checkOut.streetAddress, checkOut.city, checkOut.zipCode, checkOut.phoneNumber, checkOut.emailAddress);

    }
}
