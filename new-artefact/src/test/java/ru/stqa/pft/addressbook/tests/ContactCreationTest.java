package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDataGroup;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateNewContact() {
        app.getNavigationHelper().gotoContactCreationPage();
        app.getContactHelper().fillContactCreationForm(new ContactDataGroup("Barry", "G.", "Allen", "Flash"));
        app.getContactHelper().submitContactCreationPage();
        app.getNavigationHelper().returnToHomePage();
    }
}
