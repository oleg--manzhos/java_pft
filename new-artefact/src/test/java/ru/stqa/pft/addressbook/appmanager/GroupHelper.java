package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class GroupHelper extends HelperBase{

    GroupHelper(WebDriver driver) {
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

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void selectGroup(){
        click(By.name("selected[]"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void initGroupModification(){
        click(By.name("edit"));
    }

    public void createGroup(GroupData data) {
        initNewGroupCreation();
        fillGroupForm(data);
        submitGroupCreation();
        returnToGroupPage();
    }


    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();

    }
}
