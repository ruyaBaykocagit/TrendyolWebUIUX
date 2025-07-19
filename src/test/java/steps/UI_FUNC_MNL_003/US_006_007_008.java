package steps.UI_FUNC_MNL_003;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import page.AddToCartPage;
import utilities.ReusableMethods;

import java.time.Duration;

public class US_006_007_008 {

    WebDriver driver = steps.Hooks.getDriver();
    Actions actions = new Actions(driver);
    AddToCartPage addToCartPage = new AddToCartPage(driver);
    Logger logger = LoggerFactory.getLogger(getClass());

    //US_006
    @And("Kullanici cookiesleri kabul eder")
    public void kullaniciCookiesleriKabulEder() {
        addToCartPage.acceptAllCookies.click();
        Allure.step("Cookies kabul edildi");
        logger.info("Cookies kabul edildi");
    }
    @Then("Kullanici dil ayarlarini yapar")
    public void kullaniciDilAyarlariniYapar() {
        actions.moveToElement(addToCartPage.fransaBayragi).perform();
        addToCartPage.fransaYazisi.click();
        addToCartPage.turkiyeYazisi.click();
        addToCartPage.saveButonu.click();
        Allure.step("Dil ayarları yapıldı");
        logger.info("Dil ayarları yapıldı");

    }
    @Then("Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar")
    public void kullanıcı_istedigi_herhangi_bir_urunu_secer_ve_uzerine_tıklar() {
        addToCartPage.modamhGomlek.click();
        Allure.step("Urun secildi");
        logger.info("Urun secildi");

    }
    @Then("Kullanici istedigi urunun resmini gorur")
    public void kullanici_istedigi_urunun_resmini_gorur() {
        Assert.assertTrue(addToCartPage.resimGomlek.isDisplayed());
        Allure.step("Resim goruldu");
        logger.info("Resim goruldu");

    }
    @Then("Kullanici istedigi urunun fiyatini gorur")
    public void kullanici_istedigi_urunun_fiyatini_gorur() {
        Assert.assertTrue(addToCartPage.fiyatGomlek.isDisplayed());
        Allure.step("Fiyat goruldu");
        logger.info("Fiyat goruldu");

    }


    @And("Kullanici simdi al butonunu gorur")
    public void kullaniciSimdiAlButonunuGorur() {
        Assert.assertTrue(addToCartPage.simdiAlButonu.isDisplayed());
        addToCartPage.anladımButonu.click();
        Allure.step("Beden goruldu");
        logger.info("Beden goruldu");

    }

    // US_007
    @Then("Kullanici istedigi urunun detaylarini gorur")
    public void kullanici_istedigi_urunun_detaylarini_gorur() {
        addToCartPage.scrollToElement(addToCartPage.urunDetayi);
        Assert.assertTrue(addToCartPage.urunDetayi.isDisplayed());
        Allure.step("Detaylar goruldu");
        logger.info("Detaylar goruldu");

    }

    @Then("Kullanici istedigi urunun yorumlarini gorur")
    public void kullanici_istedigi_urunun_yorumlarini_gorur() {
        addToCartPage.yorumlariGoster(driver);
        Assert.assertTrue(addToCartPage.urununYorumlari.isDisplayed());
        Allure.step("Yorumlar goruldu");
        logger.info("Yorumlar goruldu");

    }
    @Then("Kullanici istedigi urunun puanlamasini gorur")
    public void kullanici_istedigi_urunun_puanlamasini_gorur() {
        addToCartPage.puanlariGoster(driver);
        Assert.assertTrue(addToCartPage.urunPuanlamasi.isDisplayed());
        Allure.step("Puanlar goruldu");
        logger.info("Puanlar goruldu");
    }

    @And("Kullanici  sepete ekle butonunu gorur ve tiklar")
    public void kullaniciSepeteEkleButonunuGorurVeTiklar() {

        addToCartPage.anladımButonu.click();

        Assert.assertTrue(addToCartPage.sepeteEkleButonu.isDisplayed());
        addToCartPage.sepeteEkleButonu.click();
        Allure.step("Sepete ekle butonu goruldu ve tiklandi");
        logger.info("Sepete ekle butonu goruldu ve tiklandi");
    }

    @And("Kullanici sepete git butonunu gorur")
    public void kullaniciSepeteGitButonunuGorur() {
        ReusableMethods.wait(2);
        Assert.assertTrue(addToCartPage.sepeteGitButonu.isDisplayed());
        Allure.step("Sepete git butonu goruldu");
        logger.info("Sepete git butonu goruldu");

    }

    @And("Kullanici sectigi urunu basariyla sepete ekler")
    public void kullaniciSectigiUrunuBasariylaSepeteEkler() {

        Assert.assertTrue(addToCartPage.silButonu.isDisplayed());
        Allure.step("Urun sepete eklendi");
        logger.info("Urun sepete eklendi");
    }

}
