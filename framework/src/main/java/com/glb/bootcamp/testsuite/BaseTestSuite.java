package com.glb.bootcamp.testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import static com.glb.bootcamp.browser.Browsers.CHROME;
import static com.glb.bootcamp.driver.Drivers.disposeDriver;
import static com.glb.bootcamp.driver.Drivers.populateDriver;
import static com.glb.bootcamp.server.SeleniumStandaloneServer.SERVER;
import static org.testng.Assert.fail;

/**
 *
 */
public class BaseTestSuite {

    @BeforeClass
    public void suiteSetUp() {
        SERVER.start();
    }

    @AfterClass
    public void suiteTearDown() {
        SERVER.stop();
    }

    @BeforeMethod
    public void testSetUp(Method method) {
        try {
            // TODO Get browser name for an external source or system variables
            populateDriver(CHROME);
        } catch (MalformedURLException e) {
            fail("Unable to create an instance of the driver, please check the configuration.", e);
        }
    }

    @AfterMethod
    public void testTearDown() {
        disposeDriver();
    }
}
