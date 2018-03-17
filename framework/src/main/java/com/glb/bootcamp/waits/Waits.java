package com.glb.bootcamp.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.glb.bootcamp.driver.Drivers.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Waits supports the explicit waiting operation, using {@link WebDriverWait} and {@link ExpectedConditions}.
 */
public final class Waits {

    /**
     * Verifies if an element is clickable before clicking on it.
     *
     * @param webElement the {@link WebElement}
     * @return the {@link WebElement}
     */
    public static WebElement isClickable(WebElement webElement) {
        return waiting().until(elementToBeClickable(webElement));
    }

    /**
     * Verifies if an element is visible before interacting with it.
     *
     * @param webElement the {@link WebElement}
     * @return the {@link WebElement}
     */
    public static WebElement isVisible(WebElement webElement) {
        return waiting().until(visibilityOf(webElement));
    }

    /**
     * Verifies if an element is present in the page.
     *
     * @param by the {@link By} to search for the element
     * @return the {@link WebElement}
     */
    public static WebElement isElementPresent(By by) {
        return waiting().until(presenceOfElementLocated(by));
    }

    /**
     * Verifies if the expected text is present in the element.
     *
     * @param webElement the {@link WebElement}
     * @param text       the expected text
     * @return {@code TRUE} if the text is present
     */
    public static boolean isTextPresent(WebElement webElement, String text) {
        return waiting().until(textToBePresentInElement(webElement, text));
    }

    private static WebDriverWait waiting() {
        return getDriver().getWebDriverWait();
    }

}
