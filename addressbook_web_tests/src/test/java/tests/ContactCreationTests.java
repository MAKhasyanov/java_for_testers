package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of());
        for (var firstname: List.of("","First name")){
            for (var middlename:List.of("","Middle name")){
                for(var lastname:List.of("","Last name")){
                    for (var nickname:List.of("","Nickname")){
                        for(var mobile:List.of("","")){
                            result.add(new ContactData()
                                    .withFirstName(firstname)
                                  // .withMiddleName(middlename)
                                    .withLastName(lastname)
                                  //  .withNickname(nickname)
                                    .withMobile(mobile))
                            ;
                        }
                    }
                }
            }
        }
        for (int i=0;i<3;i++) {
            result.add(new ContactData()
                    .withFirstName(randomString(i*10))
                   // .withMiddleName(randomString(i*10))
                    .withLastName(randomString(i*10))
                  //  .withNickname(randomString(i*10))
                    .withMobile(randomString(i*10)));
        }
        return result;
    }



    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().CreateContact(contact);
        var newContacts= app.contacts().getList();


        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList=new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()).withFirstName(contact.firstname()).withLastName(contact.lastname()).withMobile(contact.mobile()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "First name'","","","","")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactCount=app.contacts().getCount();
        app.contacts().CreateContact(contact);
        int newContactCount=app.contacts().getCount();
        Assertions.assertEquals(contactCount,newContactCount);
    }

}
