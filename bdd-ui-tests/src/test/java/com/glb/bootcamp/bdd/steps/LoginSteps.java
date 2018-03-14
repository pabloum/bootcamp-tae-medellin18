package com.glb.bootcamp.bdd.steps;

import com.glb.bootcamp.bdd.pages.HomeFBPage;
import com.glb.bootcamp.bdd.pages.LoginFBPage;
import com.glb.bootcamp.pageobject.PageObjectBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

/**
 * LoginSteps..
 */
public class LoginSteps extends PageObjectBase{

    private HomeFBPage homeFBPage;

    @When("^I type the username \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void typeUsernameAndPassword(String username, String password) {
        homeFBPage = new LoginFBPage().login(username, password);
    }

    @Then("^I'm successfully logged in into Facebook$")
    public void successfullyLoggedInInto() {
        assertTrue(homeFBPage.hasProfileName(), "The user is not logged in into Facebook.");
    }

}
