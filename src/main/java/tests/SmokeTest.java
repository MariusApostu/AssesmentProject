package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.BasePage;
import utils.TestNgListener;
import static org.testng.Assert.*;

@Listeners(TestNgListener.class)
public class SmokeTest extends BasePage {
    NavigationMenuPage navPage;
    LoginPage loginInApp;
    HomePage homePage;
    BlogsPage blogsPage;

    @Test(priority = 1)
    public void login() {
        loginInApp = new LoginPage(driver);
        loginInApp.loginInApp(loginInApp.username, loginInApp.password);
    }
    @Test(priority = 2)
    public void blogsCount() {
        navPage = new NavigationMenuPage(driver);
        homePage = new HomePage(driver);
        blogsPage = new BlogsPage(driver);
        navPage.click(blogsPage.blogTabButton);
        assertEquals(blogsPage.blogsCount(), 4);

    }
    @Test(priority = 3)
    public void leaveComments() {
        blogsPage = new BlogsPage(driver);
        assertTrue(blogsPage.addComments(blogsPage.blogPost1));
        navPage.click(blogsPage.blogTabButton);
        assertTrue(blogsPage.addComments(blogsPage.blogPost2));
        navPage.click(blogsPage.blogTabButton);
        assertTrue(blogsPage.addComments(blogsPage.blogPost3));
        navPage.click(blogsPage.blogTabButton);
        assertTrue(blogsPage.addComments(blogsPage.blogPost4));
        }

    }




