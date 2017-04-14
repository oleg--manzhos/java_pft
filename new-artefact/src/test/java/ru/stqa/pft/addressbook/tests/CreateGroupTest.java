package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by omanzhos on 4/4/2017.
 */
public class CreateGroupTest extends TestBase {

    @Test
    public void testCreateGroup(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("One test group", null, "Group footer 1"));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returnToGroupPage();
    }


}
