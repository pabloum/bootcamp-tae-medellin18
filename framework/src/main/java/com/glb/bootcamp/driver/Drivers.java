package com.glb.bootcamp.driver;

import com.glb.bootcamp.browser.Browsers;
import com.glb.bootcamp.logger.Loggeable;
import com.glb.bootcamp.platform.Platform;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.glb.bootcamp.properties.TestProperties.TEST_PROPERTIES;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Drivers manages the creation of different {@link org.openqa.selenium.WebDriver} instances, supporting parallel execution
 * by using {@link ThreadLocal} to store the WebDriver instance per thread.
 */
public final class Drivers implements Loggeable {

    private static final ThreadLocal<Driver> DRIVERS = new ThreadLocal<>();

    /**
     * Creates an instance of {@link Driver}.
     * The {@link org.openqa.selenium.WebDriver} instance will be instantiated with the desired platform capabilities.
     *
     * @param platform the {@link Platform}
     * @param browsers the {@link Browsers}
     * @return the {@link Driver}
     * @throws MalformedURLException if the URL of the remote server is invalid
     */
    public static void populateDriver(Platform platform, Browsers browsers) throws MalformedURLException {
        if (DRIVERS.get() == null) {
            WebDriver driver;
            switch (platform) {
                case MOBILE:
                    driver = new AppiumDriver(new URL(TEST_PROPERTIES.getRemoteAppiumUrl()), browsers.getCapabilities());
                    break;
                case WEB: {
                    driver = new RemoteWebDriver(new URL(TEST_PROPERTIES.getRemoteServerUrl()), browsers.getCapabilities());
                    driver.manage().timeouts().pageLoadTimeout(TEST_PROPERTIES.getPageLoadTimeout(), SECONDS);
                    driver.manage().timeouts().setScriptTimeout(TEST_PROPERTIES.getScriptTimeout(), SECONDS);
                    driver.manage().window().maximize();
                }
                break;
                default:
                    driver = new RemoteWebDriver((URL) null, null);
            }
            driver.manage().timeouts().implicitlyWait(TEST_PROPERTIES.getImplicitWait(), SECONDS);
            DRIVERS.set(new Driver(platform, browsers, driver));
        }
    }

    /**
     * Gets the instance previously created and stored at thread-level of the driver.
     *
     * @return the {@link Driver}
     */
    public static Driver getDriver() {
        return DRIVERS.get();
    }

    /**
     * Dispose the driver, releasing the session between the client and the server.
     * The platform will be closed.
     */
    public static void disposeDriver() {
        DRIVERS.get().getWebDriver().quit();
    }

}
