package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

/**
 * Created by omanzhos on 4/4/2017.
 */
public class CreateGroupTest extends TestBase{

    @Test
    public void testCreateGroup(){
        gotoGroupPage();
        initNewGroupCreation();
        fillGroupForm(new GroupData("One test group", "Group header 1", "Group footer 1"));
        submitGroupCreation();
        returnToGroupPage();
    }


}
