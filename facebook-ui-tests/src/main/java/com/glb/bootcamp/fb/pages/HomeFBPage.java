package com.glb.bootcamp.fb.pages;

import com.glb.bootcamp.pageobject.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HomeFBPage.
 */
public class HomeFBPage extends PageObjectBase {

    @FindBy(css = "a._2s25._606w")
    private WebElement profileNameSpan;

    public Object clickOnProfileName() {
        clickOn(profileNameSpan);
        return new Object(); // A new PO should be returned - ProfilePage (?)
    }

    public boolean hasProfileName() {
        return profileNameSpan.isDisplayed() && profileNameSpan.isEnabled();
    }
}
