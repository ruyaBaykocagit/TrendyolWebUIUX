package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides WebDriver management for Chrome browser.
 * Contains Chrome-specific settings and configurations.
 */
public class ChromeDriverManager extends BaseDriverManager {
    private static final Logger logger = LoggerFactory.getLogger(ChromeDriverManager.class);


    /**
     * Creates a Chrome-specific WebDriver instance.
     * Applies customized settings through ChromeOptions.
     * @return Configured ChromeDriver instance
     */
    @Override
    protected WebDriver createSpecificDriver() {
        try {
            logger.info("Creating ChromeDriver instance");
            ChromeOptions options = createChromeOptions();
            WebDriver driver = new ChromeDriver(options);
            logger.debug("ChromeDriver created successfully");
            return driver;
        } catch (Exception e) {
            logger.error("Error occurred while creating ChromeDriver: {}", e.getMessage());
            throw new RuntimeException("Failed to create ChromeDriver", e);
        }
    }

    /**
     * Creates Chrome-specific settings.
     * Adds necessary arguments for security, performance, and user experience.
     * @return Configured ChromeOptions object
     */
    private ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // Security settings
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Headless mode settings
        // options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // User experience settings
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");

        // Security and performance settings
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-features=IsolateOrigins,site-per-process");
        options.addArguments("--disable-site-isolation-trials");

        return options;
    }
}
