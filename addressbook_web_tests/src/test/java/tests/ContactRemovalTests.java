package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {


        if (app.contacts().getCount() == 0) {
            app.contacts().CreateContact(new ContactData("First", "Middle", "Last", "Nick", "+79260660091"));
        }
        int contactCount = app.contacts().getCount();
        app.contacts().RemoveContact();

        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }
    @Test
    void canRemoveAllContactsAtOnce(){
        if (app.contacts().getCount() == 0) {
            app.contacts().CreateContact(new ContactData("First", "Middle", "Last", "Nick", "+79260660091"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0,app.contacts().getCount());

    }
}
