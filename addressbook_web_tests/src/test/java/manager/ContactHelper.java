package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

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
    public void RemoveContact(ContactData contact){
        openContactsPage();
        selectContact(contact);
        deleteContact();

    }

    private void deleteContact() {
        removeSelectedContacts();
        returnToContactsPage();
    }

    private void removeSelectedContacts() {
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
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.mobile());
        attach(By.name("photo"), contact.photo());
    }

    private void initContactCreation() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }

    private void openContactsPage() {
        if (!manager.isElementPresernt(By.linkText("Last name"))) {
            returnToContactsPage();
        }
    }

    public void modifyContact(ContactData contact,ContactData modify) {
        openContactsPage();
        selectContact(contact);
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

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']",contact.id())));
    }

    public int getCount() {
        openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        openContactsPage();
        selectAllContacts();
        removeSelectedContacts();
    }

    private void selectAllContacts() {
        var checkboxes= manager.driver.findElements(By.name("selected[]"));
        for (var checkbox:checkboxes){
            checkbox.click();
        }
    }

    public List<ContactData> getList() {
        openContactsPage();
        var contacts=new ArrayList<ContactData>();
        var tr=manager.driver.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for (var td:tr) {
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("id");
            var ln = td.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var fn = td.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var ad = td.findElement(By.cssSelector("td:nth-child(4)")).getText();
            var ph = td.findElement(By.cssSelector("td:nth-child(6)")).getText();

            contacts.add(new ContactData().withId(id).withFirstName(fn).withLastName(ln).withAddress(ad).withMobile(ph));
        }
        return contacts;
    }
}
