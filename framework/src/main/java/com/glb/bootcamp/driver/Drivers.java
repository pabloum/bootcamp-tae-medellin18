package com.glb.bootcamp.driver;

import com.glb.bootcamp.browser.Browsers;
import com.glb.bootcamp.logger.Loggeable;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Drivers manages the creation of different {@link org.openqa.selenium.WebDriver} instances, supporting parallel execution
 * by using {@link ThreadLocal} to store the webdriver instance per thread.
 */
public final class Drivers implements Loggeable {

    private static final ThreadLocal<Driver> DRIVERS = new ThreadLocal<>();

    /**
     * Creates an instance of {@link Driver}.
     * The {@link org.openqa.selenium.WebDriver} instance will be instantiated with the desired browser capabilities.
     *
     * @param browsers the {@link Browsers}
     * @return the {@link Driver}
     * @throws MalformedURLException if the URL of the remote server is invalid
     */
    public static void populateDriver(Browsers browsers) throws MalformedURLException {
        if (DRIVERS.get() == null) {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), browsers.getCapabilities());
            remoteWebDriver.manage().timeouts().implicitlyWait(1, SECONDS);
            remoteWebDriver.manage().timeouts().pageLoadTimeout(30, SECONDS);
            remoteWebDriver.manage().timeouts().setScriptTimeout(30, SECONDS);
            remoteWebDriver.manage().window().maximize();
            DRIVERS.set(new Driver(browsers, remoteWebDriver));
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
     * The browser will be closed.
     */
    public static void disposeDriver() {
        DRIVERS.get().getWebDriver().quit();
    }

}
