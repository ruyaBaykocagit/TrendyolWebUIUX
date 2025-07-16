package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // filtre locateleri
    @FindBy(xpath = "//*[text()='Omuz Çantası']")
    public WebElement kategori;

    @FindBy(xpath = "//*[text()='MANGO']")
    public WebElement marka;

    // sayfayı kaydır
    // @FindBy(className = "fltr-cntnr-ttl-area")
    //public WebElement filtreElementi;

    @FindBy(xpath = "//*[text()='200 TL - 450 TL']")
    public WebElement fiyatFiltresi;

//sıralama locateleri
    //  @FindBy(className = "i-new-sort-icon search-sort-icon")
    //public WebElement sıralamaButonu;

    @FindBy(xpath = "//*[text()='En düşük fiyat']")
    public WebElement enDüsükFiyat;

    @FindBy(xpath = "//*[text()='En çok satan']")
    public WebElement enCokSatan;

    //liste kontrol locate
    @FindBy(xpath = "//h2[contains(text(), 'sonuç listeleniyor')]")
    public WebElement sonucBasligi;

    @FindBy(xpath = "//h2[contains(text(),'aramanız için ürün bulunamadı. Aşağıdakiler ilginizi çekebilir.')]")
    public WebElement urunBulunamadiMesaji;
}
