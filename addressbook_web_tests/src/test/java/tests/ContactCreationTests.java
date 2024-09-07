package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void canCreateContactWithFirstName() {
        app.contacts().CreateContact(new ContactData().withFirstName("First name"));
    }

    @Test
    public void canCreateContactWithMiddleName() {
        app.contacts().CreateContact(new ContactData().withMiddleName("Middle name"));
    }

    @Test
    public void canCreateContact() {
        app.contacts().CreateContact(new ContactData("First name","Middle name","Last name","Nickname","89260660091"));
    }
}
