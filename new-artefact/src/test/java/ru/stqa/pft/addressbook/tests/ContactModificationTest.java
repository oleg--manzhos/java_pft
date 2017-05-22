package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by omanzhos on 4/13/2017.
 */
public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void setPreconditions(){
        app.goTo().groupPage();
        if (!app.contact().isThereAContact()){
            app.contact().create(new ContactDataGroup().withLastName("C1").withName("#$%$%").withMiddleName("@DC$%").withNickName("e23$$#"));
        }
    }

    @Test
    public void testContactModification(){
        ContactDataGroup contact = new ContactDataGroup().withName("C1").withMiddleName("L.")
                .withLastName("Lewis").withNickName("Beater");
        Contacts before = app.contact().all();
        int index = before.size() - 1;
        ContactDataGroup modifiedContact = before.iterator().next();

        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
    }
}
