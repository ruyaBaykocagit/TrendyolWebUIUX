package driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.TimeoutConstants;

import java.time.Duration;

/**
 * Base class for WebDriver management.
 * Manages WebDriver instances in a thread-safe manner.
 */
public abstract class BaseDriverManager implements DriverManager {
    /** Thread-safe WebDriver instance */
    protected final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(BaseDriverManager.class);

    /**
     * Returns the WebDriver instance. Creates a new instance if none exists.
     * @return WebDriver instance
     */
    @Override
    public WebDriver getDriver() {
        if (driver.get() == null) {
            logger.info("Creating new WebDriver instance");
            try {
                driver.set(createDriver());
                logger.debug("WebDriver created successfully");
            } catch (Exception e) {
                logger.error("Error occurred while creating WebDriver: {}", e.getMessage());
                throw new RuntimeException("Failed to initialize WebDriver", e);
            }
        }
        return driver.get();
    }

    /**
     * Closes and cleans up the current WebDriver instance.
     * Deletes all cookies and closes the browser.
     */
    @Override
    public void quitDriver() {
        if (hasDriver()) {
            try {
                WebDriver currentDriver = driver.get();
                logger.info("Closing WebDriver");
                currentDriver.manage().deleteAllCookies();
                currentDriver.quit();
                logger.debug("WebDriver closed successfully");
            } catch (Exception e) {
                logger.error("Error occurred while closing WebDriver: {}", e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }

    /**
     * Checks if a WebDriver instance exists.
     * @return true if WebDriver instance exists, false otherwise
     */
    @Override
    public boolean hasDriver() {
        return driver.get() != null;
    }


    /**
     * Creates a specific WebDriver instance.
     * Must be implemented by subclasses.
     * @return Created WebDriver instance
     */
    protected abstract WebDriver createSpecificDriver();

    /**
     * Creates and configures a new WebDriver instance.
     * @return Configured WebDriver instance
     */
    @Override
    public WebDriver createDriver() {
        try {
            WebDriver webDriver = createSpecificDriver();
            configureDriver(webDriver);
            return webDriver;
        } catch (Exception e) {
            logger.error("Error occurred while creating driver: {}", e.getMessage());
            throw new RuntimeException("Failed to create driver", e);
        }
    }

    /**
     * Configures the WebDriver instance.
     * Sets up window size, timeout durations, and other basic settings.
     * @param webDriver WebDriver instance to configure
     */
    private void configureDriver(WebDriver webDriver) {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeoutConstants.RETRY_TIMEOUT.getSeconds()));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeoutConstants.PAGE_LOAD_TIMEOUT.getSeconds()));
        logger.debug("Driver configuration completed");
    }
}