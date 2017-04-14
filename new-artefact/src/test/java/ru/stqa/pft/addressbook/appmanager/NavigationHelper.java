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
        if (isElementPresent(By.tagName("h1"))
            && driver.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
            return;
        }
            click(By.linkText("groups"));
    }


    public void gotoContactCreationPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
                && isElementPresent(By.name("submit"))) {
            return;
        }
        click(By.linkText("add new"));
    }
}
