package driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory class for creating WebDriver managers.
 * Creates appropriate DriverManager instances for different browser types.
 */
public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    /**
     * Private constructor to prevent instantiation.
     * All methods are static, implementing singleton pattern.
     */
    private DriverFactory() {
        // Private constructor to prevent instantiation
    }

    /**
     * Creates an appropriate DriverManager instance for the specified browser type.
     * @param type Type of driver to create (CHROME, FIREFOX, etc.)
     * @return DriverManager instance for the specified browser type
     * @throws IllegalArgumentException for unsupported browser types
     */
    public static DriverManager getManager(DriverType type) {
        logger.info("Creating driver manager for type: {}", type);
        try {
            DriverManager driverManager = createDriverManager(type);
            logger.debug("Driver manager created successfully for type: {}", type);
            return driverManager;
        } catch (Exception e) {
            logger.error("Error occurred while creating driver manager for type {}: {}", type, e.getMessage());
            throw new IllegalArgumentException("Unsupported browser type: " + type, e);
        }
    }

    /**
     * Creates a DriverManager instance based on the browser type.
     * @param type Type of driver to create
     * @return DriverManager instance for the specified browser type
     * @throws IllegalArgumentException for unsupported browser types
     */
    private static DriverManager createDriverManager(DriverType type) {
        return switch (type) {
            case CHROME -> new ChromeDriverManager();
            case FIREFOX -> new FirefoxDriverManager();
            default -> throw new IllegalArgumentException("Unsupported browser type: " + type);
        };
    }
}


























