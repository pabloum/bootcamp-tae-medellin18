package com.glb.bootcamp.bdd.steps.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;

import static com.glb.bootcamp.browser.Browsers.CHROME;
import static com.glb.bootcamp.driver.Drivers.disposeDriver;
import static com.glb.bootcamp.driver.Drivers.populateDriver;
import static com.glb.bootcamp.platform.Platform.WEB;
import static com.glb.bootcamp.server.SeleniumStandaloneServer.SERVER;

/**
 * Hooks for set up and tear down steps.
 */
public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {
        SERVER.start();
        populateDriver(WEB, CHROME);
    }

    @After
    public void tearDown() {
        disposeDriver();
        SERVER.stop();
    }
}
