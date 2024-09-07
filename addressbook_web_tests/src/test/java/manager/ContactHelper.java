package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase{

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }
    public void CreateContact(ContactData contact) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactsPage();

    }
    public void RemoveContact(){
        openContactsPage();
        deleteContact();

    }

    private void deleteContact() {
        selectContact();
        click(By.xpath("//input[@value='Delete']"));
    }

    private void returnToContactsPage() {
        click(By.linkText("home"));
    }

    private void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("mobile"), contact.mobile());
    }

    private void initContactCreation() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }

    private void openContactsPage() {
        if (!manager.isElementPresernt(By.name("new"))) {
            returnToContactsPage();
        }
    }

    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresernt(By.name("selected[]"));
    }

    public void modifyContact(ContactData modify) {
        openContactsPage();
        selectContact();
        initContactModification();
        fillContactForm(modify);
        submitContactModification();
        returnToContactsPage();
    }

    private void submitContactModification() {
        click(By.xpath("//input[@name='update']"));
    }

    private void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }
}
