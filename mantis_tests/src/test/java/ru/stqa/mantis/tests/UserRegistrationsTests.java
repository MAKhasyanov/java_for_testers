package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;

public class UserRegistrationsTests extends TestBase{

    @ParameterizedTest
    @ValueSource(strings ={"test989"})
    void canRegisterUser(String username) throws InterruptedException {

        var email=String.format("%s@localhost",username);
        app.jamesCli().addUser(email,"password");
        app.browser().fillFormForUsers(username,email);
        Thread.sleep(1000);
        var messages= app.mail().receive(email,
                "password",
                Duration.ofSeconds(10));
        Thread.sleep(1000);
        var url=app.mail().canExtractUrl(email, "password");
        Assertions.assertEquals(1,messages.size());
        app.browser().finalRegistrationUser(url,username,"password");
        app.http().login(username, "password");
        Assertions.assertTrue(app.http().isLoggedIn());
  //      app.mail().drain(email, "password");
    }
}
