package com.glb.bootcamp.bdd.pages;

import com.glb.bootcamp.pageobject.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginFBPage.
 */
public class LoginFBPage extends PageObjectBase {

    @FindBy(name = "email")
    private WebElement usernameInput;

    @FindBy(name = "pass")
    private WebElement passwordInput;

    @FindBy(css = "input[type='submit']")
    private WebElement loginButton;

    public LoginFBPage() {
        super();
    }

    /**
     * This method allow to do a login against Facebook browser.
     *
     * @param username the username
     * @param password the password
     * @return the {@link HomeFBPage}
     */
    public HomeFBPage login(String username, String password) {
        typeOn(usernameInput, username);
        typeOn(passwordInput, password);
        clickOn(loginButton);
        return new HomeFBPage();
    }
}
