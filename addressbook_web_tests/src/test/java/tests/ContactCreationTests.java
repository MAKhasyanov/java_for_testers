package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>(List.of());
//        for (var firstname: List.of("","First name")){
//            for (var middlename:List.of("","Middle name")){
//                for(var lastname:List.of("","Last name")){
//                    for (var nickname:List.of("","Nickname")){
//                              result.add(new ContactData()
//                                    .withFirstName(firstname)
//                                  // .withMiddleName(middlename)
//                                    .withLastName(lastname)
//                                  //  .withNickname(address)
//                                   // .withMobile(mobile)
//                                    .withPhoto(CommonFunctions.randomFile("src/test/resources/images")))
//                            ;
//
//                    }
//                }
//            }
//        }
//        for (int i=0;i<3;i++) {
//            result.add(new ContactData()
//                    .withFirstName(CommonFunctions.randomString(i*10))
//                   // .withMiddleName(randomString(i*10))
//                    .withLastName(CommonFunctions.randomString(i*10))
//                  //  .withNickname(randomString(i*10))
//                    .withMobile(CommonFunctions.randomString(i*10))
//                    .withPhoto(CommonFunctions.randomFile("src/test/resources/images")));
//        }
        var mapper=new XmlMapper();

        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;
    }



    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().CreateContact(contact);
        var newContacts= app.hbm().getContactList();

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList=new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "First name'","","","", "","" ,"", "","", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        long contactCount=app.hbm().getContactCount();
        app.contacts().CreateContact(contact);
        long newContactCount=app.hbm().getContactCount();
        Assertions.assertEquals(contactCount,newContactCount);
    }

    @Test
    void canCreateContactInGroup(){
        var contact =new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withAddress(CommonFunctions.randomString(10));
        if (app.hbm().getGroupCount()==0){
            app.groups().CreateGroup(new GroupData("", "name", "header", "footer"));
        }
        var group =app.hbm().getGroupList().get(0);

        var oldRelated=app.hbm().getContactsInGroup(group);
        app.contacts().CreateContact(contact,group);
        var newRelated=app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size()+1,newRelated.size());
    }
    @Test
    void  canAddContactInGroup() throws SQLException {
        if (app.hbm().getContactCount() == 0) {
            app.contacts().CreateContact(new ContactData("", "", "", "", "", "src/test/resources/images/cat.jpeg", " ", " ", " "," ", " ", " ", " "));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.groups().CreateGroup(new GroupData("", "name", "header", "footer"));
        }

        var contacts = app.hbm().getContactList();
        var groups = app.hbm().getGroupList();

        var group = app.jdbc().checkGroupHaveContact(groups);
        if (group == null) {
            app.groups().CreateGroup(new GroupData("", "name", "header", "footer"));
            groups = app.hbm().getGroupList();
            group = app.jdbc().checkGroupHaveContact(groups);
        }

        var contact = app.jdbc().checkContactHaveGroup(contacts);
        if (contact == null) {
            app.contacts().CreateContact(new ContactData("", "", "", "", "", "src/test/resources/images/cat.jpeg", "", "", "","", "", "", ""));
            contacts = app.hbm().getContactList();
            contact = app.jdbc().checkContactHaveGroup(contacts);
        }

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().addContactInGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());

    }

}
