package utilities;

import java.time.Duration;

/**
 * Utility class containing timeout constants for various wait operations.
 * Prevents instantiation as it's a utility class.
 */
public final class TimeoutConstants {
    // Private constructor to prevent instantiation
    private TimeoutConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Explicit Wait Timeouts
    public static final Duration EXPLICIT_WAIT_SHORT = Duration.ofSeconds(5);
    public static final Duration EXPLICIT_WAIT_MEDIUM = Duration.ofSeconds(10);
    public static final Duration EXPLICIT_WAIT_LONG = Duration.ofSeconds(20);
    public static final Duration EXPLICIT_WAIT_VERY_LONG = Duration.ofSeconds(30);

    // Implicit Wait Timeouts
    public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);

    // Page Load Timeouts
    public static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(30);
    public static final Duration PAGE_LOAD_TIMEOUT_LONG = Duration.ofSeconds(60);

    // Script Timeouts
    public static final Duration SCRIPT_TIMEOUT = Duration.ofSeconds(30);

    // Polling Intervals
    public static final Duration POLLING_INTERVAL_SHORT = Duration.ofMillis(250);
    public static final Duration POLLING_INTERVAL_MEDIUM = Duration.ofMillis(500);
    public static final Duration POLLING_INTERVAL_LONG = Duration.ofSeconds(1);

    // Retry Timeouts
    public static final Duration RETRY_TIMEOUT = Duration.ofSeconds(10);
    public static final int RETRY_COUNT = 3;

    // Ajax Call Timeouts
    public static final Duration AJAX_ELEMENT_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration AJAX_PAGE_LOAD_TIMEOUT = Duration.ofSeconds(20);

    // Animation Timeouts
    public static final Duration ANIMATION_TIMEOUT = Duration.ofSeconds(2);
}
