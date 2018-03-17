Feature: Android Contacts

@tags addNewContact
Scenario: Add a new contact to the existent ones

Given I open the Android Contacts
When I tap on add new contact
And I type the contact name as "Pepito Bootcamp 3"
And I type the contact phone number as "1234567890"
And I type the contact email as "pepito.bootcamp@chicago123.com"
And I tap on save contact
Then the contact is created