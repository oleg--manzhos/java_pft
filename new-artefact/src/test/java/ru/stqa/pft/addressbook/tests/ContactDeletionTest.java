package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by omanzhos on 4/13/2017.
 */
public class ContactDeletionTest extends TestBase {

    ContactDataGroup contact = new ContactDataGroup().withLastName("C1").withLastName("#$%$%").withMiddleName("@DC$%").withNickName("e23$$#");

    @BeforeMethod
    public void setPreconditions(){
        app.contact().homePage();
        if (!app.contact().isThereAContact()){

            app.contact().create(contact);
        }
    }

    @Test
    public void testContactDeletion(){

        Contacts before = app.contact().all();
        ContactDataGroup deletedGroup = before.iterator().next();
        app.contact().contactSelection();
        app.contact().deleteSelectedContact();
        app.contact().applyContactDeletion();
        app.contact().homePage();
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.withoutAdded(deletedGroup)));
    }
}
