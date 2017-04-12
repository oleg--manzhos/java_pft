package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by omanzhos on 4/4/2017.
 */
public class CreateGroupTest extends TestBase {

    @Test
    public void testCreateGroup(){
        app.gotoGroupPage();
        app.initNewGroupCreation();
        app.fillGroupForm(new GroupData("One test group", "Group header 1", "Group footer 1"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }


}
