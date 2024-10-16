package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class BrowserHelper extends HelperBase{
    public BrowserHelper(ApplicationManager manager) {
        super(manager);
    }
    public void fillFormForUsers(String username, String email) {
        openLoginPage();
        createNewAccount(username,email);
    }
    private void createNewAccount(String username, String email) {
        click(By.cssSelector(".back-to-login-link"));
        type(By.name("username"),username);
        type(By.name("email"),email);
        click(By.cssSelector(".width-40"));
    }
    private void openLoginPage() {
        manager.driver().get(String.format("%s/login_page.php",manager.property("web.baseUrl")));
    }
    public void finalRegistrationUser(String url, String username, String password) {
        openLink(url);
        fillFields(username, password);
    }
    public void fillFields(String username, String password) {
        type(By.cssSelector("#password"),password);
        type(By.cssSelector("#password-confirm"),password);
        click(By.cssSelector(".width-100"));
    }
    public void openLink(String url) {
        manager.driver().get(url);
    }
}
