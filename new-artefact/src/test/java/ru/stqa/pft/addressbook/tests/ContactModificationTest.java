package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
            app.contact().create(new ContactData().withLastName("C1").withName("#$%$%").withMiddleName("@DC$%").withNickName("e23$$#"));
        }
    }

    @Test
    public void testContactModification(){
        ContactData contact = new ContactData().withName("C1").withMiddleName("L.")
                .withLastName("Lewis").withNickName("Beater");
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        app.contact().modify(contact);

        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size()+1);

        assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
    }
}
