package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase{

    @Test
    public void canRemoveContact() {
        if(!app.contacts().isContactPresent()){
            app.contacts().CreateContact(new ContactData("First", "Middle", "Last", "Nick", "+79260660091"));
        }
        app.contacts().RemoveContact();
    }
}
