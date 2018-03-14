package com.glb.bootcamp.bdd.steps;

import cucumber.api.java.en.Given;

import static com.glb.bootcamp.driver.Drivers.getDriver;

/**
 * CommonSteps.
 */
public class CommonSteps {

    @Given("^I navigate to \"([^\"]*)\"$")
    public void navigateTo(String url) {
        getDriver().getWebDriver().get(url);
    }
}
