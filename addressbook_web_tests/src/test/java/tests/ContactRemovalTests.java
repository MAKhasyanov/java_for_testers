package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {


        if (app.hbm().getContactCount() == 0) {
            app.contacts().CreateContact(new ContactData("", "First", "Middle", "Last", "Nick", "", "", "+79260660091", "", "", "", "", ""));
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
            app.hbm().CreateContact(new ContactData("", "First", "Middle", "Last", "Nick", "", "", "+79260660091","" , "", "", "", ""));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0,app.hbm().getContactCount());

    }
    @Test
    void  canRemoveContactFromGroup() throws SQLException {
        if(app.hbm().getContactCount()==0){
            app.contacts().CreateContact(new ContactData("", "", "", "", "", "src/test/resources/images/cat.jpeg","" , "","" , "", "", "", ""));
        }
        if (app.hbm().getGroupCount()==0){
            app.hbm().CreateGroup(new GroupData("", "name", "header", "footer"));
        }

        var group=app.hbm().getGroupList().get(0);
        var contact=app.hbm().getContactList().get(0);

        var oldRelated=app.hbm().getContactsInGroup(group);

        if(oldRelated.size()==0){
            app.contacts().CreateContact(contact, group);
            oldRelated=app.hbm().getContactsInGroup(group);
        }
        app.jdbc().removeContactInGroup(Integer.parseInt(group.id()));

        var newRelated=app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size()-1,newRelated.size());


    }

}
