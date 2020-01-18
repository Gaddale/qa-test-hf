package com.hellofresh.challenge;

import static java.lang.System.getenv;

// Set As system property or env variable
public enum Configuration {
//    BROWSER("BROWSER", "chrome"),
//    TEST_ENV("URL", "http://automationpractice.com/index.php"),
    PASSWORD("PASSWORD", "12345"),
    SELENIUM_HUB_URL("SELENIUM_HUB_URL", "http://jens-test-w7.ad.testnet.jeppesensystems.com:4444/wd/hub"),
    IMPLICIT_WAIT("WAIT_TIME", "10" );

    private final String value;

    Configuration(String mode, String defaultValue) {
        if (getenv(mode) != null)
            this.value = getenv(mode);
        else
            this.value = defaultValue;
    }

    public String getValue() {
        return this.value;
    }
}
