package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class BlogsPage extends SeleniumWrappers {

    public WebDriver driver;

    public BlogsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "BLOG") public WebElement blogTabButton;
    @FindBy(css = "div[class*='entry-button']>a") public List<WebElement> readMoreButton;
    @FindBy(css = "textarea[id='comment']") public WebElement commentField;
    @FindBy(xpath = "//em['Your comment is awaiting moderation.']") public WebElement moderationCheckMessage;
    @FindBy(css = "input[id='submit']") public WebElement postCommentButton;
    @FindBy(xpath = "(//div[@class='klb-readmore entry-button']/a)[1]") public WebElement blogPost1;
    @FindBy(xpath = "(//div[@class='klb-readmore entry-button']/a)[2]") public WebElement blogPost2;
    @FindBy(xpath = "(//div[@class='klb-readmore entry-button']/a)[3]") public WebElement blogPost3;
    @FindBy(xpath = "(//div[@class='klb-readmore entry-button']/a)[4]") public WebElement blogPost4;


    public int blogsCount(){

        return readMoreButton.size();

    }
    public boolean addComments (WebElement element) {
        element.click();
        commentField.click();
        commentField.sendKeys("hhhhhhh");
        postCommentButton.click();
        return moderationCheckMessage.isDisplayed();



    }




        }
