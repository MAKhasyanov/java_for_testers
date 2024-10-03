package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;

import static java.lang.String.format;

public class UserCreationTests extends TestBase {

    DeveloperMailUser user;
    @Test
    void canCreateUser() throws InterruptedException {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());

        app.browser().fillFormForUsers(user.name(), email);

        var message = app.developerMail().receive(user, Duration.ofSeconds(10));

        var url = app.mail().extractUrl(message);
        app.browser().finalRegistrationUser(url,user.token(), password);
        app.http().login(user.name(), password);
    }
    @AfterEach
    void deleteMailUser(){
        app.developerMail().deleteUser(user);

    }
}
