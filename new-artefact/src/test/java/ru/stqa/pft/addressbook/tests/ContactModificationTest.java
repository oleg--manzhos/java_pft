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
public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void setPreconditions(){
        app.goTo().groupPage();
        if (!app.contact().isThereAContact()){
            app.contact().create(new ContactDataGroup("#$%%^@#", "#$%$%", "@DC$%", "e23$$#"));
        }
    }

    @Test
    public void testContactModification(){

        ContactDataGroup contact = new ContactDataGroup("C1", "L.", "Lewis", "Beater");
        List<ContactDataGroup> before = app.contact().getContactList();
        int index = before.size() - 1;
        app.contact().selectContact(index);
        app.contact().initContactModification();
        app.contact().fillContactCreationForm(contact);
        app.contact().submitContactModificationForm();
        app.contact().homePage();
        List<ContactDataGroup> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);

        Comparator<? super ContactDataGroup> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
