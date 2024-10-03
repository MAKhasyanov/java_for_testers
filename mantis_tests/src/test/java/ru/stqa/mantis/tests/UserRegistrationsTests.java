package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;

public class UserRegistrationsTests extends TestBase{

    @ParameterizedTest
    @ValueSource(strings ={"test3"})
    void canRegisterUser(String username) throws InterruptedException {

        var email=String.format("%s@localhost",username);
//         создать пользователя (адрес) на почтовом сервере (JamesHelper)
        app.jamesCli().addUser(email,"password");
//         заполняем форму создания и отправляем (браузер)
        app.browser().fillFormForUsers(username,email);
        Thread.sleep(1000);
//         ждём почту (MailHelper)
        var messages= app.mail().receive(email,
                "password",
                Duration.ofSeconds(10));
//         извлекаем ссылку из письма
        Thread.sleep(1000);
        var url=app.mail().canExtractUrl(email, "password");
        Assertions.assertEquals(1,messages.size());
//         проходим по ссылке и завершаем регистрацию (браузер)
        app.browser().finalRegistrationUser(username,"password", url);
//         проверяем, что пользователь может залогиниться (HttpSessionHelper)
        app.http().login(username, "password");
        Assertions.assertTrue(app.http().isLoggedIn());
        app.mail().drain(email, "password");
    }
}
