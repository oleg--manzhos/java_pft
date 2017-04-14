package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("New test", "New Group", "New footer"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("New test group", "New Group header", "New footer 1"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}