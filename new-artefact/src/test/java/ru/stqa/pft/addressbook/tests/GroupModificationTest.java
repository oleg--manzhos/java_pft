package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

        Groups before =  app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("New test group").withHeader("New Group header").withFooter("New footer 1");
        app.group().modify(group);
        Groups after =  app.group().all();
        Assert.assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.withoutAdded(modifiedGroup).withAdded(group)));
    }
}