package steps.UI_FUNC_MNL_001;

import config.ConfigReader;
import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.HomePage;
import page.ShoppingCartPage;
import utilities.ReusableMethods;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class US_001_002 {
    Logger logger = LoggerFactory.getLogger(getClass());
    HomePage homePage=new HomePage(DriverManager.getDriver());
    ShoppingCartPage shoppingCartPage= new ShoppingCartPage(DriverManager.getDriver());
    WebDriver driver = steps.Hooks.getDriver();

    //tc01
    @Given("Ziyaretci verilen Url ile siteye gider")
    public void ziyaretci_verilen_url_ile_siteye_gider() {
        driver.get(ConfigReader.getProperty("url"));
        logger.info("Ziyaretçi şu URL'e gitti: {}", "url");
        ReusableMethods.wait(1);
    }
    @Then("Ziyareci siteye giris sagladigini dogrular")
    public void ziyareci_siteye_giris_sagladigini_dogrular() {
        Assert.assertTrue(homePage.trendyolTitleElement.isDisplayed());
        logger.info("Anasayfa basligi goruntulendi.");
    }
    //tc02
    @When("Acilan reklamda kategoriyi secer")
    public void acilan_reklamda_kategoriyi_secer() {
        ReusableMethods.wait(1);
        shoppingCartPage.poupopReklam2.click();
        logger.info("Ziyaretci kategori secimi yapti.");
        ReusableMethods.wait(1);

    }
    @When("Ziyaretci arama kutusuna tiklar , {string} yazar ve aratır")
    public void ziyaretci_arama_kutusuna_tiklar_yazar_ve_aratır(String urun) {
        homePage.searchBox.click();
        homePage.searchBox.sendKeys(urun + Keys.ENTER);
        logger.info("Ziyaretci arama kutusuna tikaladi " + urun + "yazip aratti: {}" , urun);
        ReusableMethods.wait(1);
    }

    @When("Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar")
    public void ziyaretci_urunun_gorunurlugunu_dogrular_ve_urun_uzerine_tiklar() {
        ReusableMethods.clickFirstVisibleProduct(shoppingCartPage.tumUrunler);
        logger.info("Ziyaretci urunun gorunurlugunu dogruladi ve uzerine tikladi.");
        ReusableMethods.wait(1);

    }
    @When("Acilan onboarding {string} butonuna tiklar")
    public void acilan_onboarding_butonuna_tiklar(String buttonText) {
        ReusableMethods.switchToLastWindow();
        ReusableMethods.wait(2);
        shoppingCartPage.onboardingbutton.click();
        logger.info("Acilan onboarding butonuna tikladi: {}" , buttonText);

    }

    @Then("Ziyaretci sepete ekle butonuna tiklar ve {string} yazisini görerek dogrular")
    public void ziyaretci_sepete_ekle_butonuna_tiklar_ve_yazisini_görerek_dogrular(String mesaj) {
        shoppingCartPage.sepeteEkleButon.click();
        ReusableMethods.wait(1);
        ReusableMethods.verifyTextExistsOnPage(mesaj);
        logger.info("Sepete ekle butonuna tikladi ve " + mesaj + "yazisini goruntuledi: {}" , mesaj);

    }
    //tc03
    @When("Ziyaretci urunun kontrolu icin Sepetim'e e gider")
    public void ziyaretci_urunun_kontrolu_icin_sepetim_e_e_gider() {
        shoppingCartPage.sepetimButton.click();
        ReusableMethods.wait(1);
    }

    @When("Sepetinde urunu artırabilmek icin {string} ya tiklar")
    public void sepetinde_urunu_artırabilmek_icin_ya_tiklar(String ikon) {
        switch (ikon) {
            case "+":
                shoppingCartPage.urunArtirmaButton.click();
                break;
            case "-":
                shoppingCartPage.urunAzaltmaButton.click();
                break;
            default:
                Assert.fail("Tanımsız simge: " + ikon);
        }

    }
    @Then("Sepet başarıyla güncellendi yazisini goruntuler")
    public void sepet_başarıyla_güncellendi_yazisini_goruntuler() {
        shoppingCartPage.succesMesaji.isDisplayed();
        ReusableMethods.wait(1);
    }


    @When("Ziyaretci urunun adetini degistirdiginde fiyat guncellenmeli")
    public void ziyaretci_urunun_adetini_degistirdiginde_fiyat_guncellenmeli() {

        int oncekiAdet = Integer.parseInt(shoppingCartPage.urunAdet.getAttribute("value"));
        String fiyatMetniOnce = shoppingCartPage.toplamFiyat.getText().replaceAll("[^0-9,]", "");
        double oncekiFiyat = Double.parseDouble(fiyatMetniOnce.replace(",", "."));

        logger.info("Ürün artırılmadan önce adet: " + oncekiAdet);
        logger.info("Ürün artırılmadan önce fiyat: " + oncekiFiyat);

        shoppingCartPage.urunArtirmaButton.click();
        ReusableMethods.wait(2);

        int sonrakiAdet = Integer.parseInt(shoppingCartPage.urunAdet.getAttribute("value"));
        String fiyatMetniSonra = shoppingCartPage.toplamFiyat.getText().replaceAll("[^0-9,]", "");
        double sonrakiFiyat = Double.parseDouble(fiyatMetniSonra.replace(",", "."));

        logger.info("Ürün artırıldıktan sonra adet: " + sonrakiAdet);
        logger.info("Ürün artırıldıktan sonra fiyat: " + sonrakiFiyat);

        Assert.assertTrue("Ürün adedi artmadı", sonrakiAdet > oncekiAdet);
        Assert.assertTrue("Ürün fiyatı artmadı", sonrakiFiyat > oncekiFiyat);

        logger.info("Kullanıcı ürün adedini artırdığında fiyatın güncellendiği başarıyla doğrulandı.");

    }

    @Then("Sepetten urun cıkarmak ici Sil ikonunu goruntulendıgını dogrular")
    public void sepetten_urun_cıkarmak_ici_sil_ikonunu_goruntulendıgını_dogrular() {
        Assert.assertTrue(shoppingCartPage.urunSilmeIkonu.isDisplayed());
        logger.info("Sepetten urun cıkarmak icin Sil ikonu goruntulendi.");

    }

    @Then("Ziyaretci ekledigi urunu sepetten siler ve silindigini dogrular")
    public void ziyaretci_ekledigi_urunu_sepetten_siler_ve_silindigini_dogrular() {
        shoppingCartPage.urunSilmeIkonu.click();
        logger.info("Sepetten urun cıkarmak icin silme ikonuna tikladi.");
        Assert.assertTrue(shoppingCartPage.succesMesaji.isDisplayed());
        logger.info("Sepetten urun basariyla silindi.");
        ReusableMethods.wait(1);

    }

    @Then("Ziyaretci urunu sildiginde Siparis Ozeti kismindaki tutarin guncellendigini dogrular")
    public void ziyaretci_urunu_sildiginde_siparis_ozeti_kismindaki_tutarin_guncellendigini_dogrular() {
        String toplamOnceString =shoppingCartPage.urunToplamTutar.getAttribute("title");
        if (toplamOnceString == null || toplamOnceString.isEmpty()) {
            toplamOnceString = shoppingCartPage.urunToplamTutar.getText();
        }
        double toplamOnce = ReusableMethods.parsePriceStringToDouble(toplamOnceString);
        logger.info("Ürün silinmeden önce toplam tutar: {}", toplamOnce);

        shoppingCartPage.urunSilmeIkonu.click();
        ReusableMethods.wait(2);

        String toplamSonraString = shoppingCartPage.urunToplamTutar.getAttribute("title");
        if (toplamSonraString == null || toplamSonraString.isEmpty()) {
            toplamSonraString = shoppingCartPage.urunToplamTutar.getText();
        }
        double toplamSonra = ReusableMethods.parsePriceStringToDouble(toplamSonraString);
        logger.info("Ürün silindikten sonra toplam tutar: {}", toplamSonra);

        Assert.assertTrue("Silme sonrası toplam tutar aynı kaldı veya artmış görünüyor!",
                toplamSonra < toplamOnce);
    }




    }








