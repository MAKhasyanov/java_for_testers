package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.stream.Stream;

import static java.lang.String.format;

public class UserCreationTests extends TestBase{

    public static Stream<String> randomUser() {
        return Stream.of(CommonFunctions.randomString(8));}

        @ParameterizedTest
        @MethodSource("randomUser")
        void canCreateUser (String user){
                var email=String.format("%s@localhost",user);
                var password = "password";
                app.jamesApi().addUser(email,password);
                app.browser().fillFormForUsers(user,email);
                var messages= app.mail().receive(email,
                        password,
                        Duration.ofSeconds(10));
            var url=app.mail().canExtractUrl(email, "password");
                app.browser().finalRegistrationUser(user,password, url);
                app.http().login(user, password); }
}
