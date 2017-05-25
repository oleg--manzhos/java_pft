package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateNewContact() {
        Contacts before = app.contact().all();
        app.goTo().contactCreationPage();
        ContactData contact = new ContactData().withLastName("C1").withLastName("C2")
                .withMiddleName("C3").withNickName("C++");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
    }
}
