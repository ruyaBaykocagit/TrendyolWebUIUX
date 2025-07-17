package steps.UI_FUNC_MNL_002;

import config.ConfigReader;
import driver.DriverManager;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.HomePage;
import page.SearchResultsPage;
import utilities.ReusableMethods;

import java.util.List;


public class US_003_004_005 {


    WebDriver driver = steps.Hooks.getDriver();
    HomePage homePage = new HomePage(DriverManager.getDriver());
    SearchResultsPage resultsPage = new SearchResultsPage(DriverManager.getDriver());
    Logger logger = LoggerFactory.getLogger(getClass());


    //US_003-------------------------------------------------------------------------------------

    @Given("Kullanıcı URL ile siteye giris yapar")
    public void kullanıcı_url_ile_siteye_giris_yapar() {
        Allure.step("Tarayıcı başlatıldı ve URL'ye gidiliyor.");
        logger.info("Tarayıcı başlatıldı. URL'ye gidiliyor: {}", ConfigReader.getProperty("url"));

        ReusableMethods.wait(2);
        driver.get(ConfigReader.getProperty("url"));
        ReusableMethods.wait(1);
    }

    @Then("Kullanıcı anasayfada olduğunu dogrular")
    public void kullanıcı_anasayfada_olduğunu_dogrular() {
        Allure.step("Kullanıcı anasayfada olduğunu doğruluyor.");
        // homePage.cookiesAcceptButton.click();
        ReusableMethods.wait(2);
        //Assert.assertTrue(homePage.trendyolTitleElement.isDisplayed());
        String expectedUrl = "https://www.trendyol.com/";
        String actualUrl = driver.getCurrentUrl();
        logger.info("Beklenen URL: {}, Gerçekleşen URL: {}", expectedUrl, actualUrl);
        Assert.assertTrue("Kullanıcı anasayfada değil! URL: " + actualUrl,
                actualUrl.startsWith("https://www.trendyol.com"));
    }

    @Then("Kullanıcı arama kutusunu gordugunu dogrular")
    public void kullanıcı_arama_kutusunu_gordugunu_dogrular() {
        Allure.step("Arama kutusunun görünürlüğü kontrol ediliyor.");
        logger.info("Arama kutusu görünürlük kontrolü yapılıyor.");
        Assert.assertTrue(homePage.searchBox.isDisplayed());
    }

    @When("Kullanıcı arama kutusuna {string} yazar")
    public void kullanıcı_arama_kutusuna_yazar(String string) {
        Allure.step("Kullanıcı arama kutusuna '" + string + "' yazar ve Enter tuşuna basar.");
        logger.info("Arama kutusuna yazılan kelime: {}", string);
        homePage.searchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("Kullanıcı arama sonucu cıkan listeyi dogrular")
    public void kullanıcı_arama_sonucu_cıkan_listeyi_dogrular() {
        Allure.step("Arama sonuçlarının ekranda gösterildiği doğrulanıyor.");
        logger.info("Arama sonuç başlığı görünürlüğü kontrol ediliyor.");
        Assert.assertTrue(resultsPage.sonucBasligi.isDisplayed());
    }

    @Then("Kullanıcı anasayfaya geri doner")
    public void kullanıcı_anasayfaya_geri_doner() {
        Allure.step("Kullanıcı anasayfaya geri dönmek için Trendyol logosuna tıklar.");
        logger.info("Kullanıcı Trendyol logosuna tıklayarak anasayfaya geri dönüyor.");
        homePage.trendyolTitleElement.click();
    }


    // TC_002
    @Then("Kullanıcı ilgili uyarı yazısını gördügünü dogrular")
    public void kullanıcıIlgiliUyarıYazısınıGördügünüDogrular() {
        Allure.step("Kullanıcı, 'Ürün bulunamadı' uyarı mesajını görür.");
        logger.info("Uyarı mesajı kontrol ediliyor: 'Ürün bulunamadı' mesajı görünmeli.");
        Assert.assertTrue(resultsPage.urunBulunamadiMesaji.isDisplayed());
    }

    // US_004-------------------------------------------------------------------------------------
    //TC_001
    @When("Kullanıcı sayfanın sol \\(veya üst) kısmındaki filtreleme panelini görür.")
    public void kullanıcıSayfanınSolVeyaÜstKısmındakiFiltrelemePaneliniGörür() {
        Allure.step("Kullanıcı, filtreleme panelinin görünür olduğunu kontrol eder.");
        logger.info("Filtreleme paneli görünürlük kontrolü yapılıyor.");
        Assert.assertTrue(resultsPage.tumKategoriler.isDisplayed());
    }

    @And("Kullanıcı “Kategori” filtresi altında yer alan “Omuz Çantası” seçeneğini işaretler.")
    public void kullanıcıKategoriFiltresiAltındaYerAlanOmuzÇantasıSeçeneğiniIşaretler() {
        Allure.step("Kullanıcı, 'Kategori' filtresinden 'Omuz Çantası' seçeneğini işaretler.");
        logger.info("'Omuz Çantası' kategorisi filtresi işaretleniyor.");
        resultsPage.kategori.click();
    }

    @Then("Kullanıcı, filtre uygulandıktan sonra listelenen ürünlerin yalnızca {string} kategorisine ait olduğunu doğrular.")
    public void kullanıcıFiltreUygulandıktanSonraListelenenÜrünlerinYalnızcaKategorisineAitOlduğunuDoğrular(String string) {
        Allure.step("Filtre sonrası yalnızca '" + string + "' kategorisine ait ürünlerin listelendiği doğrulanıyor.");
        logger.info("Filtre sonrası '" + string + "' kategorisindeki ürünler doğrulanıyor.");

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
        Allure.step("Ürün detay sayfasında, seçilen kategorideki ürün görüntüleniyor.");
        Assert.assertTrue(resultsPage.firstProductDetail.isDisplayed());

        // (İsteğe bağlı) Orijinal pencereye geri dön
        driver.close(); // Yeni sekmeyi kapat
        logger.info("Yeni pencere kapatıldı.");
        driver.switchTo().window(originalWindow); // Ana sekmeye dön
        logger.info("Ana pencereye geri dönüldü: {}", originalWindow);
    }
    //TC_002
    @And("Kullanıcı “Marka” filtresi altında yer alan “Mango” seçeneğini işaretler.")
    public void kullanıcıMarkaFiltresiAltındaYerAlanMangoSeçeneğiniIşaretler() {
        Allure.step("Kullanıcı, 'Marka' filtresi altından 'Mango' seçeneğini işaretler.");
        logger.info("'Mango' markası filtresi seçiliyor.");
        resultsPage.marka.click();
    }

    @Then("Kullanıcı, filtre uygulandıktan sonra listelenen ürünlerin yalnızca {string} markasına ait olduğunu doğrular.")
    public void kullanıcıFiltreUygulandıktanSonraListelenenÜrünlerinYalnızcaMarkasınaAitOlduğunuDoğrular(String string) {
        Allure.step("Kullanıcı, filtreleme sonrası yalnızca '" + string + "' markasına ait ürünlerin listelendiğini doğrular.");
        logger.info("Filtre sonrası '" + string + "' markasına ait ürünler kontrol edilecek.");

        String originalWindow = driver.getWindowHandle();
        logger.info("Mevcut pencere handle alındı: {}", originalWindow);
        ReusableMethods.wait(5);
        resultsPage.firstProductForMark.click();
        ReusableMethods.wait(2);
        logger.info("Filtrelenmiş ilk '" + string + "' ürünü tıklandı. Yeni sekmenin açılması bekleniyor.");

        ReusableMethods.wait(2); // İstersen WebDriverWait ile windowHandles > 1 bekleyebilirsin

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                logger.info("Yeni sekmeye geçildi: {}", windowHandle);
                break;
            }
        }

        Allure.step("'" + string + "' ürününün detay sayfası doğrulanıyor.");
        ReusableMethods.wait(2);
        Assert.assertTrue(resultsPage.markaUrunClick.isDisplayed());
        logger.info("Detay sayfasında '" + string + "' markalı ürün başarıyla doğrulandı.");

        driver.close();
        logger.info("Yeni sekme kapatıldı.");

        driver.switchTo().window(originalWindow);
        logger.info("Ana sekmeye geri dönüldü: {}", originalWindow);

    }
    //TC_003
    @And("Kullanıcı “Fiyat” filtresi altında yer alan “{int}{int} TL” seçeneğini işaretler.")
    public void kullanıcıFiyatFiltresiAltındaYerAlanTLSeçeneğiniIşaretler(int min, int max) {
        Allure.step("Kullanıcı '" + min + "-" + max + " TL' fiyat filtresini işaretler.");
        logger.info("Kullanıcı fiyat filtresi olarak '{}' - '{}' TL aralığını seçiyor.", min, max);

        Assert.assertTrue(resultsPage.fiyatFiltresi.isDisplayed());
        resultsPage.fiyatFiltresi.click();
        logger.info("Fiyat filtresi paneli açıldı.");

        resultsPage.fiyatFiltresiSpecific.click(); // Bu eleman "200-450 TL" filtresine ait olmalı
        logger.info("{} - {} TL aralığı filtresi seçildi.", min, max);

    }
    @Then("Kullanıcı, filtre uygulandıktan sonra listelenen ürünlerin seçtigim filtrelere uygun olduğunu doğrular.")
    public void kullanıcıFiltreUygulandıktanSonraListelenenÜrünlerinSeçtigimFiltrelereUygunOlduğunuDoğrular() {
        Allure.step("Kullanıcı, ilk ürünün fiyatının 200 TL'den büyük olduğunu doğrular.");
        logger.info("İlk ürünün fiyatı kontrol ediliyor...");

        ReusableMethods.wait(2); // Filtreden sonra yüklenme süresi için

        String fiyatText = resultsPage.firstProductPrice.getText()
                .replace("TL", "")
                .replace(".", "")
                .replace(",", "")
                .trim();

        logger.info("İlk ürünün görünen fiyatı: {}", fiyatText);

        fiyatText = resultsPage.firstProductPrice.getText()
                .replace("TL", "")
                .replace(".", "")
                .replace(",", "")
                .trim();

        logger.info("İlk ürünün görünen fiyatı: '{}'", fiyatText);

        if (fiyatText.isEmpty()) {
            Assert.fail("Fiyat bilgisi boş veya alınamadı!");
        }

        int fiyat;
        try {
            fiyat = Integer.parseInt(fiyatText);
        } catch (NumberFormatException e) {
            Assert.fail("Fiyat değeri sayıya dönüştürülemedi: " + fiyatText);
            return;
        }
        Assert.assertTrue("İlk ürünün fiyatı 200 TL'den büyük değil: " + fiyat, fiyat > 200);

        Allure.step("İlk ürünün fiyatı " + fiyat + " TL ve 200 TL'den büyüktür.");
        logger.info("İlk ürünün fiyatı {} TL ve filtreye uygundur.", fiyat);
    }

    //US_005-----------------------------------------------------------------------------------------------
    //TC_001
}
