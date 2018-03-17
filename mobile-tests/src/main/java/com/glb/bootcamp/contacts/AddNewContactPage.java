package com.glb.bootcamp.contacts;

import com.glb.bootcamp.pageobject.PageObjectBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * AddNewContactPage - Implemented in class by trainees.
 */
public class AddNewContactPage extends PageObjectBase {

    @AndroidFindBy(xpath = "//*[@resource-id='com.android.contacts:id/names']//android.widget.EditText[1]")
    private WebElement nameField;

    @AndroidFindBy(xpath = "//*[@resource-id='com.android.contacts:id/phone_numbers']//android.widget.EditText[1]")
    private WebElement phoneField;

    @AndroidFindBy(xpath = "//*[@resource-id='com.android.contacts:id/emails']//android.widget.EditText[1]")
    private WebElement emailField;

    @AndroidFindBy(accessibility = "Save")
    private WebElement saveContactButton;

    public AddNewContactPage typeName(String name) {
        typeOn(nameField, name);
        return this;
    }

    public AddNewContactPage typePhone(String phone) {
        typeOn(phoneField, phone);
        return this;
    }

    public AddNewContactPage typeEmail(String email) {
        typeOn(emailField, email);
        return this;
    }

    public ContactProfilePage saveContact() {
        clickOn(saveContactButton);
        return new ContactProfilePage();
    }

}
