package com.intrum.tests.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.intrum.tests.helpers.TestCaseContext.getBrowser;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Wait {

    public static final int DEFAULT_LOCATE_ELEMENT_TIME = 60;

    public Wait() {
    }

    private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(getBrowser(), (long) timeout);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public WebElement forElementToBeDisplayed(By elementLocator, String elementsName) {
        ExpectedCondition<WebElement> condition = visibilityOfElementLocated(elementLocator);
        String timeoutMessage = elementsName + " wasn't displayed after " + DEFAULT_LOCATE_ELEMENT_TIME + " seconds.";
        waitUntilCondition(condition, timeoutMessage, DEFAULT_LOCATE_ELEMENT_TIME);
        return getBrowser().findElement(elementLocator);
    }
}
