package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;

import java.util.Comparator;
import java.util.List;

/**
 * Created by omanzhos on 4/13/2017.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getContactHelper().goToHomePage();
        ContactDataGroup contact = new ContactDataGroup("C1", "#$%$%", "@DC$%", "e23$$#");
        if (!app.getContactHelper().isThereAContact()){

            app.getContactHelper().createContact(contact);
        }
        List<ContactDataGroup> before = app.getContactHelper().getContactList();
        app.getContactHelper().contactSelection();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().applyContactDeletion();
        app.getContactHelper().goToHomePage();
        List<ContactDataGroup> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        after.add(contact);
        Comparator<? super ContactDataGroup> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
