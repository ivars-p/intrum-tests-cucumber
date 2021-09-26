package com.intrum.tests.helpers;

import com.intrum.tests.config.Config;
import org.openqa.selenium.WebDriver;

public class TestCaseContext {

    private static ThreadLocal<WebDriver> BROWSER = new ThreadLocal<>();

    private static ThreadLocal<User> USER = new ThreadLocal<>();

    private static Config CONFIG = Config.getInstance();

    public static WebDriver getBrowser() {
        return BROWSER.get();
    }

    public static void setBrowser(WebDriver browser) {
        BROWSER.set(browser);
    }

    public static User getUser() {
        return USER.get();
    }

    public static void setUser(User user) {
        USER.set(user);
    }

    public static Config getCONFIG() {
        return TestCaseContext.CONFIG;
    }
}
