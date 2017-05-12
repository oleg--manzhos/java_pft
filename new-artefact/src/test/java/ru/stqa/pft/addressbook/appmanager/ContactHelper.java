package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactDataGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class ContactHelper extends HelperBase {

    ContactHelper(WebDriver driver){
        super(driver);
    }

    public void fillContactCreationForm(ContactDataGroup contactDataGroup) {
        type(By.name("firstname"), contactDataGroup.getcName());
        type(By.name("middlename"), contactDataGroup.getcMiddleName());
        type(By.name("lastname"), contactDataGroup.getcLastName());
        type(By.name("nickname"), contactDataGroup.getcNickName());
    }

    public void submitContactCreationPage(){
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

    public void createContact(ContactDataGroup data) {
        fillContactCreationForm(data);
        submitContactCreationPage();
        goToHomePage();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void applyContactDeletion() {
        acceptAlert();
    }

    public void goToHomePage() {
        click(By.linkText("home"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public List<ContactDataGroup> getContactList() {
        List<ContactDataGroup> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']/td[2]"));
        for (WebElement element:elements){
            String name = element.getText();
            int id = Integer.parseInt(driver.findElement(By.cssSelector("input[type=checkbox][value]")).getAttribute("value"));
            ContactDataGroup contact = new ContactDataGroup(id, "C1", null,null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}

