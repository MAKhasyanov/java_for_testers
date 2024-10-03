package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;
import java.util.stream.Stream;

import static java.lang.String.format;

public class UserCreationTests extends TestBase {

    DeveloperMailUser user;
    @Test
    void canCreateUser() {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());

//        app.browser().fillFormForUsers(user, email);
//        var messages = app.mail().receive(email,
//                password,
//                Duration.ofSeconds(10));
//        var url = app.mail().canExtractUrl(email, "password");
//        app.browser().finalRegistrationUser(user, password, url);
//        app.http().login(user, password);
    }
    @AfterEach
    void deleteMailUser(){
        app.developerMail().deleteUser(user);

    }
}
