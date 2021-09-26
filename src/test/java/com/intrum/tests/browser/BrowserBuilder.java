package com.intrum.tests.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;

import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

public class BrowserBuilder {

    private static final Logger LOGGER = getLogger(BrowserBuilder.class);

    private String browserName;

    public BrowserBuilder() {
    }

    public BrowserBuilder setBrowserName(String browserName) {
        this.browserName = browserName;
        return this;
    }

    public WebDriver build() {
        switch (browserName) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--window-size=1920,1200");

                LOGGER.info(format("Initiated driver for browser - %s", browserName));
                return new ChromeDriver(options);
            default:
                LOGGER.error(format("There is no available browser with such name - %s", browserName));
                throw new Error("There is no such browser");
        }
    }
}
