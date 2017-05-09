package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateNewContact() {
        app.getNavigationHelper().gotoContactCreationPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test1", "test2", "test3");
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() - 1);
    }
}
