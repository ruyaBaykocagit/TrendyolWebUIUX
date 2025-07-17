package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//img[@alt='Trendyol Türkçe']")
    public WebElement trendyolTitleElement;


    @FindBy(xpath = "//*[@class='vQI670rJ']")
    public WebElement searchBox;


    @FindBy(xpath = "//*[text()='Accept All Cookies']")
    public WebElement cookiesAcceptButton;

}
