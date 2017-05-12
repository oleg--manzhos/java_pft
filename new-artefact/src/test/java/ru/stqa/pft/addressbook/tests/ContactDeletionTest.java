package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;

import java.util.Comparator;
import java.util.List;

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

        List<ContactDataGroup> before = app.contact().getContactList();
        app.contact().contactSelection();
        app.contact().deleteSelectedContact();
        app.contact().applyContactDeletion();
        app.contact().homePage();
        List<ContactDataGroup> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        after.add(contact);
        Comparator<? super ContactDataGroup> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
