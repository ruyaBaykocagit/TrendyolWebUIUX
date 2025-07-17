package steps.UI_FUNC_MNL_002;

import config.ConfigReader;
import driver.DriverManager;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.SearchResultsPage;
import utilities.ReusableMethods;


public class US_003_004_005 {


    WebDriver driver = steps.Hooks.getDriver();
    HomePage homePage = new HomePage(DriverManager.getDriver());
    SearchResultsPage resultsPage = new SearchResultsPage(DriverManager.getDriver());

    //US_003-------------------------------------------------------------------------------------
    
    @Given("Kullanıcı URL ile siteye giris yapar")
    public void kullanıcı_url_ile_siteye_giris_yapar() {
        ReusableMethods.wait(2);
        driver.get(ConfigReader.getProperty("url"));
        ReusableMethods.wait(1);
    }
    @Then("Kullanıcı anasayfada olduğunu dogrular")
    public void kullanıcı_anasayfada_olduğunu_dogrular() {

       // homePage.cookiesAcceptButton.click();
        ReusableMethods.wait(2);
        //Assert.assertTrue(homePage.trendyolTitleElement.isDisplayed());
        String expectedUrl = "https://www.trendyol.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue("Kullanıcı anasayfada değil! URL: " + actualUrl,
                actualUrl.startsWith("https://www.trendyol.com"));
    }

    @Then("Kullanıcı arama kutusunu gordugunu dogrular")
    public void kullanıcı_arama_kutusunu_gordugunu_dogrular() {
       Assert.assertTrue(homePage.searchBox.isDisplayed());
    }

    @When("Kullanıcı arama kutusuna {string} yazar")
    public void kullanıcı_arama_kutusuna_yazar(String string) {
        homePage.searchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("Kullanıcı arama sonucu cıkan listeyi dogrular")
    public void kullanıcı_arama_sonucu_cıkan_listeyi_dogrular() {
        Assert.assertTrue(resultsPage.sonucBasligi.isDisplayed());
    }

    @Then("Kullanıcı anasayfaya geri doner")
    public void kullanıcı_anasayfaya_geri_doner() {
homePage.trendyolTitleElement.click();
    }


    // TC_002
    @Then("Kullanıcı ilgili uyarı yazısını gördügünü dogrular")
    public void kullanıcıIlgiliUyarıYazısınıGördügünüDogrular() {

        Assert.assertTrue(resultsPage.urunBulunamadiMesaji.isDisplayed());
    }

    @When("Kullanıcı sayfanın sol \\(veya üst) kısmındaki filtreleme panelini görür.")
    public void kullanıcıSayfanınSolVeyaÜstKısmındakiFiltrelemePaneliniGörür() {
        Assert.assertTrue(resultsPage.tumKategoriler.isDisplayed());
    }

    @And("Kullanıcı “Kategori” filtresi altında yer alan “Omuz Çantası” seçeneğini işaretler.")
    public void kullanıcıKategoriFiltresiAltındaYerAlanOmuzÇantasıSeçeneğiniIşaretler() {
        resultsPage.kategori.click();
    }

    @Then("Kullanıcı, filtre uygulandıktan sonra listelenen ürünlerin yalnızca {string} kategorisine ait olduğunu doğrular.")
    public void kullanıcıFiltreUygulandıktanSonraListelenenÜrünlerinYalnızcaKategorisineAitOlduğunuDoğrular(String arg0) {

        String originalWindow = driver.getWindowHandle(); // Mevcut sekmeyi sakla

        resultsPage.firstProduct.click(); // Ürüne tıkla

        // Yeni sekmenin açılmasını bekle
        ReusableMethods.wait(2); // Alternatif olarak WebDriverWait ile window sayısını bekleyebilirsin

        // Yeni sekmeye geç
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Detay sayfasında doğrulama yap
        Assert.assertTrue(resultsPage.firstProductDetail.isDisplayed());

        // (İsteğe bağlı) Orijinal pencereye geri dön
        driver.close(); // Yeni sekmeyi kapat
        driver.switchTo().window(originalWindow); // Ana sekmeye dön
    }

    //US_004-------------------------------------------------------------------------------------
    
}
