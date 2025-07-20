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

    @FindBy(xpath = "//*[@class='add-to-cart-button-text stock-info']")
    public WebElement sepeteEkleButon;

    @FindBy(xpath = "//img[@src='https://cdn.dsmcdn.com/web/production/new-gender-popup-female.png']")
    public WebElement poupopReklam;

    @FindBy(xpath = "//img[@alt='Female']")
    public WebElement poupopReklam2;

    @FindBy(xpath = "//button[@class='onboarding__default-renderer-primary-button']")
    public WebElement onboardingbutton;

    ///html/body/div[63]
    ////*[@id="envoy"]/div/div/div[2]/div/div[3]/div/div/button
    //button @class="onboarding__default-renderer-primary-button">Anladım</button>

    @FindBy(xpath = "(//*[@class=\"link-text\"])[3]")
    public WebElement sepetimButton;

    @FindBy(xpath = "//button[@aria-label='Ürün adedi arttırma']")
    public WebElement urunArtirmaButton;

    @FindBy(xpath = "//div[@class='toastrElement success']")
    public WebElement succesMesaji;

    @FindBy(xpath = "//button[@aria-label='Ürün adedi azaltma']")
    public WebElement urunAzaltmaButton;

    @FindBy(xpath = "//button[@class='_button_65101ec _lg_d463ab3 _contained_7fc71b7 _contained-primary_df66b41 _fluid_f013a80 add-to-cart-button']")
    public WebElement sepeteEklendiMesaji;

    @FindBy(xpath = "//input[@aria-label='Ürün adedi']")
    public WebElement urunAdet;

    @FindBy(xpath = "//div[@class='pb-summary-total-price discount-active']")
    public WebElement toplamFiyat;

    @FindBy(xpath = "//button[@aria-label='Ürünü sepetten çıkartma']")
    public WebElement urunSilmeİkonu;


}