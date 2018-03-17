package com.glb.bootcamp.testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import static com.glb.bootcamp.driver.Drivers.disposeDriver;
import static com.glb.bootcamp.driver.Drivers.populateDriver;
import static com.glb.bootcamp.platform.Platform.WEB;
import static com.glb.bootcamp.properties.TestProperties.TEST_PROPERTIES;
import static com.glb.bootcamp.server.SeleniumStandaloneServer.SERVER;
import static org.testng.Assert.fail;

/**
 * BaseTestSuite represents the base suite for all the test suites in the test automation project.
 * A new suite should inherit BaseTestSuite functionality.
 */
public class BaseTestSuite {

    @BeforeClass
    public void suiteSetUp() {
        if (WEB.equals(TEST_PROPERTIES.getPlatform())) {
            SERVER.start();
        }
    }

    @AfterClass
    public void suiteTearDown() {
        if (WEB.equals(TEST_PROPERTIES.getPlatform())) {
            SERVER.stop();
        }
    }

    @BeforeMethod
    public void testSetUp(Method method) {
        try {
            populateDriver(TEST_PROPERTIES.getPlatform(), TEST_PROPERTIES.getBrowser());
        } catch (MalformedURLException e) {
            fail("Unable to create an instance of the driver, please check the configuration.", e);
        }
    }

    @AfterMethod
    public void testTearDown() {
        disposeDriver();
    }

}
