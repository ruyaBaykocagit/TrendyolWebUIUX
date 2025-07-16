package steps.UI_FUNC_MNL_002;

import driver.DriverManager;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.SearchResultsPage;
import utilities.ConfigReader;



public class US_003_004_005 {



    WebDriver driver = steps.Hooks.getDriver();

    private DriverManager driverManager;
    HomePage homePage = new HomePage(driverManager.getDriver());

    SearchResultsPage resultsPage = new SearchResultsPage(driverManager.getDriver());
    @Given("Kullanıcı URL ile siteye giris yapar")
    public void kullanıcı_url_ile_siteye_giris_yapar() {

        String buyCellUrl= config.ConfigReader.getProperty("url");
        driver.get(buyCellUrl);

        //driverManager.getDriver().navigate().to(ConfigReader.getProperty("url"));

    }
    @Then("Kullanıcı anasayfada olduğunu dogrular")
    public void kullanıcı_anasayfada_olduğunu_dogrular() {
        String actualUrl = driverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(homePage.logoYazisi.isDisplayed());
    }
    @Then("Kullanıcı arama kutusunu gordugunu dogrular")
    public void kullanıcı_arama_kutusunu_gordugunu_dogrular() {
        Assert.assertTrue(homePage.aramaKutusu.isDisplayed());
    }
    @When("Kullanıcı arama kutusuna {string} yazar")
    public void kullanıcı_arama_kutusuna_yazar(String string) {
        homePage.aramaKutusu.sendKeys(string + Keys.ENTER);
    }
    @Then("Kullanıcı arama sonucu cıkan listeyi dogrular")
    public void kullanıcı_arama_sonucu_cıkan_listeyi_dogrular() {
        Assert.assertTrue(resultsPage.sonucBasligi.isDisplayed());
        Assert.assertTrue(resultsPage.sonucBasligi.getText().contains("sonuç listeleniyor"));
    }
    @Then("Kullanıcı anasayfaya geri doner")
    public void kullanıcı_anasayfaya_geri_doner() {

    }
    @When("Browser kapatılır")
    public void browser_kapatılır() {

    }
    // TC_002
    @Then("Kullanıcı ilgili uyarı yazısını gördügünü dogrular")
    public void kullanıcıIlgiliUyarıYazısınıGördügünüDogrular() {

        Assert.assertTrue(resultsPage.urunBulunamadiMesaji.isDisplayed());
    }
}
