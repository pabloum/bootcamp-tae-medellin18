package com.glb.bootcamp.fb.pages;

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
        goTo("http://www.facebook.com");
    }

    /**
     * This method allow to do a login against Facebook app.
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
