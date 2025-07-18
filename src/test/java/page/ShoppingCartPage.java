package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //ılk urun locate
    @FindBy(xpath = "//div[@class=\"product-down\"]")
    public List<WebElement> tumUrunler;

    @FindBy(xpath = "//span[@class='add-to-cart-button-text']")
    public WebElement sepeteEkleButon;

    @FindBy(xpath = "//img[@src='https://cdn.dsmcdn.com/web/production/new-gender-popup-female.png']")
    public WebElement poupopReklam;

    @FindBy(xpath = "//img[@alt='Female']")
    public WebElement poupopReklam2;

    @FindBy(xpath = "//*[@class='onboarding__default-renderer-primary-button']")
    public WebElement onboardingbutton;


//
//img[@alt='Female']








}
