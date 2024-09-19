package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase{

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of());
        for (var firstname: List.of("","First name")){
            for (var middlename:List.of("","Middle name")){
                for(var lastname:List.of("","Last name")){
                    for (var nickname:List.of("","Nickname")){
                        for(var mobile:List.of("","+79260660091")){
                            result.add(new ContactData(firstname,middlename,lastname,nickname,mobile));
                        }
                    }
                }
            }
        }
        for (int i=0;i<5;i++) {
            result.add(new ContactData(randomString(i*10),randomString(i*10),randomString(i*10),randomString(i*10),randomString(i*10)));
        }
        return result;
    }



    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount=app.contacts().getCount();
        app.contacts().CreateContact(contact);
        int newContactCount=app.contacts().getCount();
        Assertions.assertEquals(contactCount+1,newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("First name'","","","","")));
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
