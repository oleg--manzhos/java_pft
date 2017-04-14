package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;

/**
 * Created by omanzhos on 4/13/2017.
 */
public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification(){
        if (! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().gotoContactCreationPage();
            app.getContactHelper().createContact(new ContactDataGroup("#$%%^@#", "#$%$%", "@DC$%", "e23$$#"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactCreationForm(new ContactDataGroup("Lennox", "L.", "Lewis", "Beater"));
        app.getContactHelper().submitContactModificationForm();
        app.getContactHelper().returnToHomePage();
    }
}
