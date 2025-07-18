package steps.UI_FUNC_MNL_001;

import config.ConfigReader;
import driver.DriverManager;
import io.cucumber.java.en.And;
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
import page.ShoppingCartPage;
import utilities.ReusableMethods;

import java.time.Duration;

public class US_001_002 {
        HomePage homePage=new HomePage(DriverManager.getDriver());
        SearchResultsPage searchPage = new SearchResultsPage(DriverManager.getDriver());
        AddToCartPage addPage = new AddToCartPage(DriverManager.getDriver());
        ShoppingCartPage shoppingCartPage= new ShoppingCartPage(DriverManager.getDriver());
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
        }
        //tc02

    @When("Acilan reklamda kategoriyi secer")
    public void acilan_reklamda_kategoriyi_secer() {
        ReusableMethods.wait(1);
        shoppingCartPage.poupopReklam2.click();
        ReusableMethods.wait(1);

    }
    @When("Ziyaretci arama kutusuna tiklar , {string} yazar ve aratır")
    public void ziyaretci_arama_kutusuna_tiklar_yazar_ve_aratır(String urun) {
        homePage.searchBox.click();
        ReusableMethods.wait(2);
        homePage.searchBox.sendKeys(urun + Keys.ENTER);
        ReusableMethods.wait(3);
    }

    @When("Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar")
        public void ziyaretci_urunun_gorunurlugunu_dogrular_ve_urun_uzerine_tiklar() {
            /*
        for (WebElement urun : shoppingCartPage.tumUrunler) {
            if (urun.getText().toLowerCase().contains("mont")) {
                Assert.assertTrue(urun.isDisplayed());
                urun.click();
                break;
            }
            ReusableMethods.wait(20);

        }
             */
        ReusableMethods.wait(1);
        ReusableMethods.clickFirstVisibleProduct(shoppingCartPage.tumUrunler);
        ReusableMethods.wait(2);

    }
    /*
    @When("Acilan onboarding butonuna tiklar")
    public void acilan_onboarding_butonuna_tiklar() {
            ReusableMethods.wait(20);
        shoppingCartPage.onboardingbutton.click();

    }
     */

    @When("Acilan onboarding {string} butonuna tiklar")
    public void acilan_onboarding_butonuna_tiklar(String buttonText) {
        ReusableMethods.clickButtonByText(buttonText);
        ReusableMethods.wait(1);
    }

    @Then("Ziyaretci sepete ekle butonuna tiklar ve {string} yazisini görerek dogrular")
        public void ziyaretci_sepete_ekle_butonuna_tiklar_ve_yazisini_görerek_dogrular(String mesaj) {
            shoppingCartPage.sepeteEkleButon.click();
            ReusableMethods.wait(5);
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

