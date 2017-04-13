package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class NavigationHelper extends HelperBase{

    NavigationHelper(WebDriver driver){
        super(driver);
   }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void gotoContactCreationPage() {
        click(By.linkText("add new"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }
}
