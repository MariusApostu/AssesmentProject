package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class HomePage extends SeleniumWrappers {

    public WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id='dgwt-wcas-search-input-1']") public WebElement searchBar;
    @FindBy(linkText = "CART") public WebElement cartButon;



}
