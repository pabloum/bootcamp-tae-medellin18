package com.glb.bootcamp.driver;

import com.glb.bootcamp.browser.Browsers;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Driver container of {@link WebDriver} instance and the {@link Browsers} information.
 */
public final class Driver {

    private Browsers browsers;

    private WebDriver webDriver;

    private WebDriverWait webDriverWait;

    /**
     * Default constructor.
     *
     * @param browsers  the browser information
     * @param webDriver the webdriver instance
     */
    public Driver(Browsers browsers, WebDriver webDriver) {
        this.browsers = browsers;
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 30);
        webDriverWait.pollingEvery(1, SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class);
    }

    public Browsers getBrowserName() {
        return browsers;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

}
