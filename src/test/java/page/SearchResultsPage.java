package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Tüm Kategoriler']")
    public WebElement tumKategoriler;
    // filtre locateleri
    @FindBy(xpath = "//*[text()='Omuz Çantası']")
    public WebElement kategori;

    //ilk cıkan urune tıklar ilk cıkan urun locate butun alındı spesıfık olmasın dıye
    @FindBy(xpath = "//*[@class='product-down']")
    public WebElement firstProduct;

    @FindBy(xpath = "//*[text()='Kadın Omuz Çantası']")
    public WebElement firstProductDetail;

    @FindBy(xpath = "//*[text()='MANGO']")
    public WebElement marka;

    @FindBy(xpath = "//*[@class='prdct-desc-cntnr']")
    public WebElement firstProductForMark;

    @FindBy(xpath = "//*[text()='MANGO Kadın Omuz Çantası']")
    public WebElement markaUrunClick;


    // sayfayı kaydır--gerek kalmadı
    // @FindBy(className = "fltr-cntnr-ttl-area")
    //public WebElement filtreElementi;
    @FindBy(xpath = "//*[text()='Fiyat']")
    public WebElement fiyatFiltresi;


    @FindBy(xpath = "//*[text()='200 TL - 450 TL']")
    public WebElement fiyatFiltresiSpecific;

    @FindBy(xpath = "//*[@class='price-item discounted']")
    public WebElement firstProductPrice;

    //sıralama locateleri
    //  @FindBy(className = "i-new-sort-icon search-sort-icon")
    //public WebElement sıralamaButonu;
    @FindBy(xpath = "//*[text()='Önerilen']")
    public WebElement önerilen;

    @FindBy(xpath = "//*[text()='En düşük fiyat']")
    public WebElement enDüsükFiyat;

    @FindBy(xpath = "(//div[@class='price-item discounted'])[1]")
    public WebElement enDüsükFiyatFirstProduct;

    @FindBy(xpath = "(//div[@class='price-item discounted'])[2]")
    public WebElement enDüsükFiyatSecondProduct;




   // @FindBy(xpath = "//*[text()='En çok satan']")
   // public WebElement enCokSatan;

    @FindBy(xpath = "//span[@class='search-dropdown-text' and contains(text(),'En çok')]")
    public WebElement enCokSatan;


    @FindBy(xpath = "//*[text()='En Çok Satan 1. Ürün']")
    public WebElement enCokSatanKontrol;



    //liste kontrol locate
    @FindBy(xpath = "//h2[text()= ' araması için 100.000+ sonuç listeleniyor']")
    public WebElement sonucBasligi;

    @FindBy(xpath = "//h2[text()=' aramanız için ürün bulunamadı. Aşağıdakiler ilginizi çekebilir.']")
    public WebElement urunBulunamadiMesaji;


}
