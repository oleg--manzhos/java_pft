package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

    public void groupPage() {
        click(By.linkText("group page"));
    }

    public void selectGroup(int index){
         driver.findElements(By.name("selected[]")).get(index).click();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void initGroupModification(){
        click(By.name("edit"));
    }

    public void create(GroupData data) {
        initNewGroupCreation();
        fillGroupForm(data);
        submitGroupCreation();
        groupPage();
    }

    public void modify(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupPage();
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element:elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }
}
