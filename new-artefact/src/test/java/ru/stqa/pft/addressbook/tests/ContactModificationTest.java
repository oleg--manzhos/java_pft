package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by omanzhos on 4/13/2017.
 */
public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification(){
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactDataGroup("#$%%^@#", "#$%$%", "@DC$%", "e23$$#"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactCreationForm(new ContactDataGroup("Lennox", "L.", "Lewis", "Beater"));
        app.getContactHelper().submitContactModificationForm();
        app.getContactHelper().returnToHomePage();
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size());
    }
}
