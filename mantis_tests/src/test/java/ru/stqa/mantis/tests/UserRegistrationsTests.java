package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;

public class UserRegistrationsTests extends TestBase{

    @ParameterizedTest
    @ValueSource(strings ={"test9431"})
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
    @Test
    void canRegisterNewUserRest() {
        DeveloperMailUser newUser = new DeveloperMailUser().withName(CommonFunctions.randomString(7))
                .withEmail(String.format("%s@localhost", CommonFunctions.randomString(6)))
                .withPassword("password");
        app.jamesApi().addUser(newUser.email(), newUser.password());

        app.rest().createUser(newUser);

        var messages = app.mail().receive(newUser.email(), newUser.password(), Duration.ofSeconds(20));
        var url = app.mail().extractUrl(messages.get(0).content());

         app.browser().openLink(url);
        app.browser().fillFields(newUser.name(),newUser.password());

        app.http().login(newUser.name(), newUser.password());
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
