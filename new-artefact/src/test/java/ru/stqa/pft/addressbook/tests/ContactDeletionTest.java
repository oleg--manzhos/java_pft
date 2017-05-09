package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by omanzhos on 4/13/2017.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactDataGroup("#$%%^@#", "#$%$%", "@DC$%", "e23$$#"));
        }
        List<GroupData> before = app.getContactHelper().getContactList();
        app.getContactHelper().contactSelection();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().applyContactDeletion();
    }
}
