package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver){
        super(driver);
   }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

}
