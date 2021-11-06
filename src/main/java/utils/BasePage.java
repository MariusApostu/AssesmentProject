package utils;

import pages.HomePage;
import pages.LoginPage;
import pages.NavigationMenuPage;

public class BasePage extends BaseTest{

    public NavigationMenuPage navPage = new NavigationMenuPage(driver);
    public LoginPage loginPage = new LoginPage(driver);
    public HomePage homePage = new HomePage(driver);



}
