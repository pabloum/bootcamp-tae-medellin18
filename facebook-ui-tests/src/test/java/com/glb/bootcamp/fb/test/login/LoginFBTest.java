package com.glb.bootcamp.fb.test.login;

import com.glb.bootcamp.fb.pages.HomeFBPage;
import com.glb.bootcamp.fb.pages.LoginFBPage;
import com.glb.bootcamp.testsuite.BaseTestSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginFBTest extends BaseTestSuite {

    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    @Test
    public void testSuccessfulLogin() {
        HomeFBPage home = new LoginFBPage().login(USERNAME, PASSWORD);
        assertTrue(home.hasProfileName(), "Unable to login to Facebook, please check the logs.");
    }
}