package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests  extends TestBase{

    @Test
    void testPhones(){
        var contacts=app.hbm().getContactList();
        var expected=contacts.stream().collect(Collectors.toMap(ContactData::id, contact->
            Stream.of(contact.home(),contact.mobile(),contact.work(),contact.secondary())
                    .filter(s->s!=null && ! "".equals(s))
                    .collect(Collectors.joining("\n"))
        ));
        var phones=app.contacts().getPhones();
        Assertions.assertEquals(expected,phones);
//        for (var contact:contacts){
// //       var contact=contacts.get(0);
//  //      var phones=app.contacts().getPhones(contact);
//        var expected= Stream.of(contact.home(),contact.mobile(),contact.work(),contact.secondary())
//                .filter(s->s!=null && ! "".equals(s))
//                .collect(Collectors.joining("\n"));
//        Assertions.assertEquals(expected,phones.get(contact.id()));
//    }
}

    @Test
    void testEmails(){
        var contacts=app.hbm().getContactList();
        var contact=contacts.get(0);
        var emails=app.contacts().getEmails(contact);
        var expected=Stream.of(contact.email(),contact.email2(),contact.email3()).
                filter(s->s!=null && !s.equals("")).
                collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, emails);
    }
    @Test
    void testAddress() {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var address = app.contacts().getAddress(contact);
        var expected = Stream.of(contact.address()).
                filter(s -> s != null && !s.equals("")).
                collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, address);
    }
}
