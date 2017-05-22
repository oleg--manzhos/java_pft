package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void groupPresencePrecondition(){
        GroupData group = new GroupData().withName("New test").withHeader("New Group").withFooter("New footer");
        app.goTo().groupPage();
        if (! app.group().isThereAGroup()){
            app.group().create(group);
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().selectGroup(before.size() - 1);
        app.group().deleteGroup();
        app.group().groupPage();
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() - 1));

        assertThat(after, equalTo(before.withoutAdded(deletedGroup)));
    }
}