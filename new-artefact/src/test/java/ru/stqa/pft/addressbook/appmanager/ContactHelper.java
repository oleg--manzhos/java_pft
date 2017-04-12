package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactDataGroup;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper (WebDriver driver){
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
}
