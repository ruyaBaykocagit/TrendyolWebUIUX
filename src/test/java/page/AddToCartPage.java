package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(xpath = "//*[text()='ÜRÜNÜN TÜM ÖZELLİKLERİ']")
    public WebElement urunDetayi;

    @FindBy(xpath = "//*[@class='summary-rating']")
    public WebElement urunPuanlamasi;

    @FindBy(xpath = "//*[text()='TÜM YORUMLARI GÖSTER']")
    public WebElement urununYorumlari;

    @FindBy(xpath = "//*[@class='add-to-cart-button-text']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//*[text()='Sepete Git']")
    public WebElement sepeteGitButonu;

    @FindBy(xpath = "//*[@class='trash-icon']")
    public WebElement silButonu;

    @FindBy(xpath = "//*[text()='Anladım']")
    public WebElement anladımButonu;



    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void yorumlariGoster(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Sayfanın sonuna kadar yavaş yavaş scroll yap
            for (int i = 0; i < 4; i++) {
                js.executeScript("window.scrollBy(0, 500);");
            }

            // Buton görünene kadar bekle
            WebElement yorumButonu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(text(),'TÜM YORUMLARI GÖSTER')]")));

            // Butona scroll yap
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", yorumButonu);

            yorumButonu.click(); // Yorumları göster
            System.out.println("✅ Yorumlar açıldı.");

        } catch (Exception e) {
            System.out.println("❌ Yorum butonu bulunamadı: " + e.getMessage());
        }
    }
    public void puanlariGoster(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Sayfanın sonuna kadar yavaş yavaş scroll yap
            for (int i = 0; i < 6; i++) {
                js.executeScript("window.scrollBy(0, 500);");
            }

            // Buton görünene kadar bekle
            WebElement yorumButonu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@class='summary-rating']")));

            // Butona scroll yap
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});" );

            yorumButonu.click(); // Yorumları göster
            System.out.println("✅ Puanlar açıldı.");

        } catch (Exception e) {
            System.out.println("❌ Puanlar bulunamadı: " + e.getMessage());
        }
    }

}







