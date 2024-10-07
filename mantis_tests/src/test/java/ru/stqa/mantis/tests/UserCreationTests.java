package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;


public class UserCreationTests extends TestBase {

    DeveloperMailUser user;
    @Test
    void canCreateUser()  {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());

       app.browser().fillFormForUsers(user.name(), email);
//        Thread.sleep(1000);
       var message = app.developerMail().receive(user, Duration.ofSeconds(20));
//
        var url = app.mail().extractUrl(message);
        app.browser().finalRegistrationUser(url,user.token(), password);
        app.http().login(user.name(), password);
    }
    @AfterEach
    void deleteMailUser(){
        app.developerMail().deleteUser(user);

    }
}
