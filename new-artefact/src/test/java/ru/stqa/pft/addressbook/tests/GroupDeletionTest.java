package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void groupPresencePrecondition(){
        app.goTo().groupPage();
        if (! app.group().isThereAGroup()){
            app.group().create(new GroupData("New test", "New Group", "New footer"));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().getGroupList();
        app.group().selectGroup(before.size() - 1);
        app.group().delete();
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}