package steps.UI_FUNC_MNL_003;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import page.AddToCartPage;

public class US_006_007_008 {

    WebDriver driver = steps.Hooks.getDriver();
    Actions actions = new Actions(driver);
    AddToCartPage addToCartPage = new AddToCartPage(driver);


    @And("Kullanici cookiesleri kabul eder")
    public void kullaniciCookiesleriKabulEder() {
        addToCartPage.acceptAllCookies.click();

    }
    @Then("Kullanici dil ayarlarini yapar")
    public void kullaniciDilAyarlariniYapar() {
        actions.moveToElement(addToCartPage.fransaBayragi).perform();
        addToCartPage.fransaYazisi.click();
        addToCartPage.turkiyeYazisi.click();
        addToCartPage.saveButonu.click();

    }
    @Then("Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar")
    public void kullanıcı_istedigi_herhangi_bir_urunu_secer_ve_uzerine_tıklar() {
        addToCartPage.modamhGomlek.click();

    }
    @Then("Kullanici istedigi urunun resmini gorur")
    public void kullanici_istedigi_urunun_resmini_gorur() {
        Assert.assertTrue(addToCartPage.resimGomlek.isDisplayed());

    }
    @Then("Kullanici istedigi urunun fiyatini gorur")
    public void kullanici_istedigi_urunun_fiyatini_gorur() {
        Assert.assertTrue(addToCartPage.fiyatGomlek.isDisplayed());

    }

    @Then("Kullanici istedigi urunun bedenini gorur")
    public void kullanici_istedigi_urunun_bedenini_gorur() {
        Assert.assertTrue(addToCartPage.bedenGomlek.isDisplayed());

    }

    @Then("Kullanici M bedeni gorur ve tiklar")
    public void kullanici_m_bedeni_gorur_ve_tiklar() {
        Assert.assertTrue(addToCartPage.MbedenGomlek.isDisplayed());
        //addToCartPage.MbedenGomlek.click();

    }


}
