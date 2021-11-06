package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class NavigationMenuPage extends SeleniumWrappers {

    public WebDriver driver;

    public NavigationMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //@FindBy(css= "span[class*='text']") public WebElement categoriesTab;
    //@FindBy(linkText = "Frozen Foods") public WebElement frozenFoodsTab;

    public void navigateTo(WebElement element){
        element.click();
    }

   public void hoverMenu(WebElement element){
        Actions actions =  new Actions(driver);
        actions.moveToElement(element).perform();

    }


}
