package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initNewGroupCreation() {
        click(By.name("new"));
    }

    public void deleteGroup(){
        click(By.name("delete"));
    }

    public void selectGroup(){
        click(By.name("selected[]"));
    }
}
