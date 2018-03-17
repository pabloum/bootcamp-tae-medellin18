package com.glb.bootcamp.contacts;

import com.glb.bootcamp.pageobject.PageObjectBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * ContactsListPage - Implemented in class by trainees.
 */
public class ContactsListPage extends PageObjectBase {

    @AndroidFindBy(id = "floating_action_button")
    private WebElement addNewContactButton;

    @AndroidFindBy(id = "left_button")
    private WebElement keepLocalButton;

    public AddNewContactPage clickAddNewContact() {
        clickOn(addNewContactButton);
        clickOn(keepLocalButton);
        return new AddNewContactPage();
    }

}
