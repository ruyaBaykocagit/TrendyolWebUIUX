package utilities;

import driver.DriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class ReusableMethods {

    private static final Logger logger = LoggerFactory.getLogger(ReusableMethods.class);
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }


    public static void takeScreenshot(WebDriver driver, String name) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
    }


    //========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = DriverManager.getDriver().getWindowHandle();
        for (String handle : DriverManager.getDriver().getWindowHandles()) {
            DriverManager.getDriver().switchTo().window(handle);
            if (DriverManager.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        DriverManager.getDriver().switchTo().window(origin);
    }

    // wait
    public static void wait(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep calismadi");
        }


    }
         //Sayfa kaynak kodu içinde verilen metnin geçtiğini doğrular.

    public static void verifyTextExistsOnPage(String expectedText) {
        String pageSource = DriverManager.getDriver().getPageSource();
        Assert.assertTrue("Beklenen metin sayfa kaynağında bulunamadı: " + expectedText,
                pageSource.contains(expectedText));
    }


    public static void clickButtonByText(String buttonText) {
        WebDriver driver = DriverManager.getDriver();
        WebElement button = driver.findElement(By.xpath("//*[normalize-space(text())='" + buttonText + "']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }


        //aratilan ürün listesindeki ilk ürüne tikla
    public static void clickFirstVisibleProduct(List<WebElement> productList) {
        // Ürün listesi boş mu kontrol et
        Assert.assertFalse("Ürün listesi boş, tıklanacak ürün bulunamadı", productList.isEmpty());
        WebElement firstProduct = productList.get(0);
        Assert.assertTrue("İlk ürün görünmüyor", firstProduct.isDisplayed());
        wait(2);
        firstProduct.click();
    }

    //------------------yeni sekme son handle
    public static void switchToLastWindow() {
        WebDriver driver = DriverManager.getDriver();
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(windowList.size() - 1));
    }

        //-------------fiyat karsilastirma
    public static double parsePriceStringToDouble(String fiyat) {
        if (fiyat == null || fiyat.isEmpty()) {
            throw new IllegalArgumentException("Fiyat string'i boş olamaz");
        }
        try {
            // "2.582,88 TL" → 2582.88
            String temizFiyat = fiyat.replaceAll("[^\\d,\\.]", "").trim();
            NumberFormat format = NumberFormat.getInstance(new Locale("tr", "TR"));
            return format.parse(temizFiyat).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException("Fiyat parse edilemedi: " + fiyat, e);
        }
    }

//-------------------
private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    public static void click(WebElement locator) {
        WebDriver driver = DriverManager.getDriver();
        WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void sendKeysWithEnter(WebElement element, String text) {
        WebDriver driver = DriverManager.getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputElement = wait.until(ExpectedConditions.visibilityOf(element));

        inputElement.clear();

        // 0.5 saniye bekle
        ReusableMethods.wait(1);

        inputElement.sendKeys(text + Keys.ENTER);

        // Gönderim sonrası 0.5 saniye bekle
        ReusableMethods.wait(1);
    }




    public static void assertElementVisible(WebElement element, String elementName) {
        Allure.step(elementName + " elementinin görünürlüğü doğrulanıyor.");
        logger.info("{} görünürlük kontrolü.", elementName);
        Assert.assertTrue(elementName + " görünür değil!", element.isDisplayed());
    }

    // URL'nin beklenen ile başlayıp başlamadığını doğrula
    public static void assertUrlStartsWith(String actualUrl, String expectedStart) {
        Allure.step("URL doğrulaması: '" + actualUrl + "' adresi '" + expectedStart + "' ile başlıyor mu?");
        logger.info("URL doğrulama: Beklenen başlangıç '{}', Gerçek URL '{}'", expectedStart, actualUrl);
        Assert.assertTrue("URL beklenen ile başlamıyor! Gerçek URL: " + actualUrl,
                actualUrl.startsWith(expectedStart));
    }

    // Uyarı mesajının görünürlüğünü doğrula
    public static void assertWarningMessageVisible(WebElement warningElement, String expectedMessage) {
        Allure.step("Uyarı mesajı '" + expectedMessage + "' görünür mü kontrol ediliyor.");
        logger.info("Uyarı mesajı görünürlük kontrolü: '{}'", expectedMessage);
        Assert.assertTrue("Uyarı mesajı görünür değil: " + expectedMessage, warningElement.isDisplayed());
    }



}



















