package com.intrum.tests.pages;

import com.intrum.tests.constants.navigation.MenuSections;
import com.intrum.tests.helpers.Wait;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

import static com.intrum.tests.helpers.TestCaseContext.getBrowser;
import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.cssSelector;

public class BasePage {

    private static final By ACCEPT_ALL_COOKIES_BUTTON = cssSelector("[id='onetrust-accept-btn-handler']");

    private static final By DROPDOWN = cssSelector("select");

    private static final By PAGE_TITLE = cssSelector("h1");

    private static final By TEXT_AREA = cssSelector("textarea");

    protected static final By INPUT_FIELD = cssSelector("input");

    protected Navigation navigationMenu;

    protected Wait wait;

    public BasePage() {
        this.wait = new Wait();
        this.navigationMenu = new Navigation();
    }

    protected void click(By element) {
        getBrowser().findElement(element).click();
    }

    protected void validateTitle(String expectedTitle) {
        String title = wait.forElementToBeDisplayed(PAGE_TITLE, "Page title").getText();
        assertThat(format("Page title is not correct, expected: %s, but was: %s", expectedTitle, title),
                title, is(expectedTitle));
    }

    protected void navigateTo(MenuSections section) {
        this.navigationMenu.selectSectionByName(section);
    }

    protected void fillInputField(By element, String value) {
        getBrowser().findElement(element).findElement(INPUT_FIELD).sendKeys(value);
    }

    public void clearInputField(By element) {
        getBrowser().findElement(element).findElement(INPUT_FIELD).clear();
    }

    public void clearTextAreaField(By element) {
        getBrowser().findElement(element).findElement(TEXT_AREA).clear();
    }

    public void fillTextAreaField(By element, String value) {
        getBrowser().findElement(element).findElement(TEXT_AREA).sendKeys(value);
    }

    public void selectValueFromDropDown(By element, String value) {
        Select dropdown = new Select(getBrowser().findElement(element).findElement(DROPDOWN));
        dropdown.selectByValue(value);
    }

    protected void acceptAllCookies() {
        wait.forElementToBeDisplayed(ACCEPT_ALL_COOKIES_BUTTON, "Accept all cookies button")
                .sendKeys(Keys.ENTER);
    }

    public boolean isElementDisplayed(By element) {
        try {
            getBrowser().findElement(element).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(By element) {
        try {
            getBrowser().findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void checkIfElementVisibilitySoft(By element, boolean visibility, SoftAssertions softAssertions) {
        boolean check;
        try {
            getBrowser().findElement(element).isDisplayed();
            check = true;
        } catch (NoSuchElementException e) {
            check = false;
        }
        softAssertions.assertThat(check).as("Visibility of: " + element).isEqualTo(visibility);
    }
}
