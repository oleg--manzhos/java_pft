package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by omanzhos on 4/13/2017.
 */
public class ContactDeletionTest extends TestBase {

    ContactData contact = new ContactData().withLastName("C1").withLastName("#$%$%").withMiddleName("@DC$%").withNickName("e23$$#");

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
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.withoutAdded(deletedContact)));
    }
}
