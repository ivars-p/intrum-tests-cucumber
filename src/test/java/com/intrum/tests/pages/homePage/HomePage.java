package com.intrum.tests.pages.homePage;

import com.intrum.tests.constants.navigation.MenuSections;
import com.intrum.tests.pages.BasePage;
import org.slf4j.Logger;

import static com.intrum.tests.constants.navigation.PageTitles.HOME_PAGE_TITLE;
import static com.intrum.tests.helpers.TestCaseContext.getBrowser;
import static com.intrum.tests.helpers.TestCaseContext.getCONFIG;
import static java.lang.String.format;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.slf4j.LoggerFactory.getLogger;

public class HomePage extends BasePage {

    private static final Logger LOGGER = getLogger(HomePage.class);

    public HomePage() {
        initElements(getBrowser(), this);
    }

    public HomePage verify() {
        validateTitle(HOME_PAGE_TITLE.toString());
        return this;
    }

    public HomePage startHomePageTest() {
        LOGGER.info(format("Open URL: %s", getCONFIG().getDefaultIntrumLatviaUrl()));
        getBrowser().get(getCONFIG().getDefaultIntrumLatviaUrl());
        this.acceptAllCookies();
        this.verify();
        return this;
    }

    public HomePagePromise navigateToPage(MenuSections menuSection) {
        navigateTo(menuSection);
        return new HomePagePromise();
    }
}
