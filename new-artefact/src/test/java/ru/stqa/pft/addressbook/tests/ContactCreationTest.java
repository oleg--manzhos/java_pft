package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;

import java.util.Comparator;
import java.util.List;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateNewContact() {

        List<ContactDataGroup> before = app.contact().getContactList();
        app.goTo().contactCreationPage();
        ContactDataGroup contact = new ContactDataGroup().withLastName("C1").withLastName("C2")
                .withMiddleName("C3").withNickName("C++");
        app.contact().create(contact);
        List<ContactDataGroup> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactDataGroup> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
