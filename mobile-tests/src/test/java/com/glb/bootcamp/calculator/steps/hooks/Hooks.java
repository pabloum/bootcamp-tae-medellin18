package com.glb.bootcamp.calculator.steps.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;

import static com.glb.bootcamp.driver.Drivers.disposeDriver;
import static com.glb.bootcamp.driver.Drivers.populateDriver;
import static com.glb.bootcamp.properties.TestProperties.TEST_PROPERTIES;

/**
 * Hooks for set up and tear down steps.
 */
public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {
        populateDriver(TEST_PROPERTIES.getPlatform(), TEST_PROPERTIES.getBrowser());
    }

    @After
    public void tearDown() {
        disposeDriver();
    }
}
