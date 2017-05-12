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
public class GroupModificationTest extends TestBase{

    @BeforeMethod
    public void groupPresencePrecondition(){
        app.goTo().groupPage();
        if (! app.group().isThereAGroup()){
            app.group().create(new GroupData().withHeader("New test").withHeader("New Group").withFooter("New footer"));
        }
    }

    @Test
    public void testGroupModification(){

        List<GroupData> before =  app.group().getGroupList();
        int index = before.size() - 1;
        GroupData group = new GroupData().withId(before.get(index).getId()).withName("New test group").withHeader("New Group header").withFooter("New footer 1");
        app.group().modify(index, group);
        List<GroupData> after =  app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}