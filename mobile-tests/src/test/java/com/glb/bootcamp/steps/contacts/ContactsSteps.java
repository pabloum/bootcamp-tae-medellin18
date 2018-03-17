package com.glb.bootcamp.steps.contacts;

import com.glb.bootcamp.contacts.AddNewContactPage;
import com.glb.bootcamp.contacts.ContactProfilePage;
import com.glb.bootcamp.contacts.ContactsListPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

/**
 * ContactsSteps - Implemented in class by trainees.
 */
public class ContactsSteps {

    private ContactsListPage contactsListPage;
    private AddNewContactPage addNewContactPage;
    private ContactProfilePage contactProfilePage;

    private String name;
    private String phoneNumber;
    private String email;

    @Given("^I open the Android Contacts$")
    public void iOpenTheAndroidContacts() {
        contactsListPage = new ContactsListPage();
    }

    @When("^I tap on add new contact$")
    public void iTapOnAddNewContact() {
        addNewContactPage = contactsListPage.clickAddNewContact();
    }

    @When("^I type the contact name as \"([^\"]*)\"$")
    public void iTypeTheContactNameAs(String name) {
        this.name = name;
        addNewContactPage.typeName(name);
    }

    @When("^I type the contact phone number as \"([^\"]*)\"$")
    public void iTypeTheContactPhoneNumberAs(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        addNewContactPage.typePhone(phoneNumber);
    }

    @When("^I type the contact email as \"([^\"]*)\"$")
    public void iTypeTheContactEmailAs(String email) {
        this.email = email;
        addNewContactPage.typeEmail(email);
    }

    @When("^I tap on save contact$")
    public void iTapOnSaveContact() {
        contactProfilePage = addNewContactPage.saveContact();
    }

    @Then("^the contact is created$")
    public void theContactIsCreated() {
        assertTrue(contactProfilePage.hasName());
        assertTrue(contactProfilePage.hasPhone(phoneNumber));
        assertTrue(contactProfilePage.hasEmail(email));
    }
}
