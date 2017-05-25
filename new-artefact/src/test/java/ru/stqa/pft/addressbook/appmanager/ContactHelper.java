package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactDataGroup;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class ContactHelper extends HelperBase {

    ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactCreationForm(ContactData contactDataGroup) {
        type(By.name("firstname"), contactDataGroup.getcName());
        type(By.name("middlename"), contactDataGroup.getcMiddleName());
        type(By.name("lastname"), contactDataGroup.getcLastName());
        type(By.name("nickname"), contactDataGroup.getcNickName());
    }

    public void submitContactCreationPage() {
        click(By.xpath("//input[@value='Enter']"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@title='Edit']"));
    }

    public void submitContactModificationForm() {
        click(By.name("update"));
    }

    public void contactSelection() {
        click(By.name("selected[]"));
    }

    public void create(ContactData data) {
        fillContactCreationForm(data);
        submitContactCreationPage();
        homePage();
    }

    public void modify(ContactData contact) {
        initContactModification();
        fillContactCreationForm(contact);
        submitContactModificationForm();
        homePage();
    }

    public void delete(ContactData contact) {
        selectContact(contact.getId());
        deleteSelectedContact();
        applyContactDeletion();
        homePage();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void applyContactDeletion() {
        acceptAlert();
    }

    public void homePage() {
        click(By.linkText("home"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement>cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String AllPhones = cells.get(5).getText();
            contacts.add(new ContactData().withId(id).withName("C1").withLastName(null).withMiddleName(null)
                    .withNickName(null).withAllPhones(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstName = driver.findElement(By.name("firstmane")).getAttribute("value");
        String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        driver.navigate().back();

        return new ContactData().withId(contact.getId()).withName(firstName)
                .withLastName(lastName).withHomePhone(home).withMobilePhone(mobile)
                .withWorkPhone(work);
    }

    private void initContactModificationById(int id){
        WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

        //driver.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
        //driver.findElement(By.xpath(String.format("//tr[.//input[@value='%s]]/td[8]/a", id))).click();
        //driver.findElement(By.cssSelector(String.format("a [href='edit.php?id=%s']", id))).click();

    }
}

