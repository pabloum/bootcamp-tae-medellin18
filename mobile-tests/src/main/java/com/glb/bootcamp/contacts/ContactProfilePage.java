package com.glb.bootcamp.contacts;

import com.glb.bootcamp.pageobject.PageObjectBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static com.glb.bootcamp.waits.Waits.isElementPresent;
import static com.glb.bootcamp.waits.Waits.isVisible;
import static io.appium.java_client.MobileBy.AccessibilityId;

/**
 * ContactProfilePage - Implemented in class by trainees.
 */
public class ContactProfilePage extends PageObjectBase {

    @AndroidFindBy(id = "title_gradient")
    private WebElement nameField;

    /*@AndroidFindBy(id = "")
    private WebElement optionsButton;

    @AndroidFindBy(id = "")
    private WebElement deleteButton;*/

    public boolean hasName() {
        return isVisible(nameField).isDisplayed();
    }

    public boolean hasPhone(String phone) {
        try {
            isElementPresent(AccessibilityId("Call Mobile " + phone));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasEmail(String email) {
        try {
            isElementPresent(AccessibilityId("Email Home " + email));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
