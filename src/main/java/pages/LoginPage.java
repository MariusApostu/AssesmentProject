package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReadProperties;
import utils.SeleniumWrappers;

public class LoginPage extends SeleniumWrappers {

    public WebDriver driver;
    public String username = ReadProperties.config.getProperty("user");
    public String password = ReadProperties.config.getProperty("pass");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(partialLinkText="My account") public WebElement myAccount;
    @FindBy(id="username") public WebElement usernameField;
    @FindBy(id="password") public WebElement passwordField;
    @FindBy(name = "login") public WebElement submitButton;
    @FindBy(partialLinkText="Log out") public WebElement logoutButton;


    public void loginInApp(String username, String password){
        click(myAccount);
        sendKeys(usernameField, username);
        sendKeys(passwordField, password);
        click(submitButton);
        waitForElementToBeDisplayed(logoutButton);
    }




}
