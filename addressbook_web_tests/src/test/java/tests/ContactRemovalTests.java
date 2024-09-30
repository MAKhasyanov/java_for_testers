package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {


        if (app.hbm().getContactCount() == 0) {
            app.contacts().CreateContact(new ContactData("", "First", "Middle", "Last", "Nick", "+79260660091",""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd =new Random();
        var index= rnd.nextInt(oldContacts.size());
        app.contacts().RemoveContact(oldContacts.get(index));
        var newContacts= app.hbm().getContactList();
        var expectedList= new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }
    @Test
    void canRemoveAllContactsAtOnce(){
        if (app.hbm().getContactCount() == 0) {
            app.hbm().CreateContact(new ContactData("", "First", "Middle", "Last", "Nick", "+79260660091",""));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0,app.hbm().getContactCount());

    }
}
