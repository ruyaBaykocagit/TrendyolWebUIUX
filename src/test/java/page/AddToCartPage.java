package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

    WebDriver driver;

    public AddToCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Accept All Cookies']")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//*[@class='selected-country-flag']")
    public WebElement fransaBayragi;

    @FindBy(xpath = "//*[@class='country-selection-wrapper menu-item']")
    public WebElement ulkeMenusu;

    @FindBy(xpath = "//*[@class='country']")
    public WebElement ulkeMenusu2;

    @FindBy(xpath = "//*[text()='France']")
    public WebElement fransaYazisi;

    @FindBy(xpath = "//*[text()='Türkiye']")
    public WebElement turkiyeYazisi;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButonu;

    @FindBy(xpath = "(//*[@class='custom-stamp-box-wrapper'])[2]")
    public WebElement modamhGomlek;

    @FindBy(xpath = "//*[@class='price-view-original']")
    public WebElement fiyatGomlek;

    @FindBy(xpath = "//*[@class='variant-title']")
    public WebElement bedenGomlek;

    @FindBy(xpath = "(//div[@class='react-transform-component transform-component-module_content__FBWxo '])[1]")
    public WebElement resimGomlek;

    @FindBy(xpath = "(//div[@class='_body_03c70b5 _large_34eb53c _left_b388a23 _align-left_def5d71'])[2]")
    public WebElement MbedenGomlek;


}
