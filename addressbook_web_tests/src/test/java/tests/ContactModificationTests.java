package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase{

    @Test
    public void canModifyContact() {
        if(app.contacts().getCount()==0){
            app.contacts().CreateContact(new ContactData("First", "Middle", "Last", "Nick", "+79260660091"));
        }
        app.contacts().modifyContact(new ContactData().withFirstName("Modify"));
    }
}
