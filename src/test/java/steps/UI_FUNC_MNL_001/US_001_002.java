package steps.UI_FUNC_MNL_001;

import config.ConfigReader;
import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AddToCartPage;
import page.HomePage;
import page.SearchResultsPage;
import utilities.ReusableMethods;

import java.time.Duration;

public class US_001_002 {
    HomePage homePage=new HomePage(DriverManager.getDriver());
    SearchResultsPage searchPage = new SearchResultsPage(DriverManager.getDriver());
    AddToCartPage addPage = new AddToCartPage(DriverManager.getDriver());
    WebDriver driver = steps.Hooks.getDriver();

    //tc01
    @Given("Ziyaretci verilen Url ile siteye gider")
    public void ziyaretci_verilen_url_ile_siteye_gider() {
        driver.get(ConfigReader.getProperty("url"));
        ReusableMethods.wait(1);

    }
    @Then("Ziyareci siteye giris sagladigini dogrular")
    public void ziyareci_siteye_giris_sagladigini_dogrular() {
        homePage.trendyolTitleElement.isDisplayed();
        ReusableMethods.wait(1);

    }
    //tc02
    @When("Ziyaretci arama kutusuna tiklar , {string} yazar ve aratır")
    public void ziyaretciAramaKutusunaTiklarYazarVeAratır(String urun) {
        homePage.searchBox.click();
        homePage.searchBox.sendKeys(urun + Keys.ENTER);
        ReusableMethods.wait(1);
    }

    @When("Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar")
    public void ziyaretci_urunun_gorunurlugunu_dogrular_ve_urun_uzerine_tiklar() {
        for (WebElement urun : searchPage.tumUrunler) {
            if (urun.getText().toLowerCase().contains("mont")) {
                Assert.assertTrue(urun.isDisplayed());
                urun.click();
                break;
            }
            ReusableMethods.wait(1);
        }

    }

    @Then("Ziyaretci sepete ekle butonuna tiklar ve {string} yazisini görerek dogrular")
    public void ziyaretci_sepete_ekle_butonuna_tiklar_ve_yazisini_görerek_dogrular(String mesaj) {
        addPage.sepeteEkleButon.click();
        ReusableMethods.wait(1);
        ReusableMethods.verifyTextExistsOnPage(mesaj);

    }

    //tc03
    @When("Ziyaretci urunun kontrolu icin {string} e gider")
    public void ziyaretci_urunun_kontrolu_icin_e_gider(String string) {

    }


    @When("Sepetinde urunu artırabilmek icin {string} ya tiklar")
    public void sepetinde_urunu_artırabilmek_icin_ya_tiklar(String string) {

    }


    @Then("{string} yazisini goruntuler")
    public void yazisini_goruntuler(String string) {

    }


    @Then("Ziyaretci urunun arttigini goruntuler")
    public void ziyaretci_urunun_arttigini_goruntuler() {

    }



}
