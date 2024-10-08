package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void CreateContact(ContactData contact, GroupData group) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToContactsPage();

    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
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
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
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
        initContactModification(contact);
        fillContactForm(modify);
        submitContactModification();
        returnToContactsPage();
    }

    private void submitContactModification() {
        click(By.xpath("//input[@name='update']"));
    }

    private void initContactModification(ContactData contact) {
        click(By.cssSelector(String.format("[href=\"edit.php?id=%s\"]",contact.id())));
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

    public void addContactInGroup(ContactData contact,GroupData group) {
        openContactsPage();
        selectContact(contact);
        selectGroupForContact(group);
        submitAddingContactToGroup();
    }

    private void submitAddingContactToGroup() {
        click(By.name("add"));
    }

    private void selectGroupForContact(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    public String getPhones(ContactData contact) {
       return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]",contact.id()))).getText();
    }

    public Map<String,String> getPhones() {
        var result=new HashMap<String,String>();
        List<WebElement> rows =manager.driver.findElements(By.name("entry"));
        for (WebElement row:rows){
            var id=row.findElement(By.tagName("input")).getAttribute("id");
            var phones=row.findElements(By.tagName("td")).get(5).getText();
            result.put(id,phones);
        }
        return result;
    }

    public String getEmails(ContactData contact) {
        return manager.driver.findElement(By.xpath
                        (String.format("//input[@id='%s']/../../td[5]", contact.id()))).
                getText();
    }

    public Object getAddress(ContactData contact) {
        return manager.driver.findElement(By.xpath
                        (String.format("//input[@id='%s']/../../td[4]", contact.id()))).
                getText();
    }
}
