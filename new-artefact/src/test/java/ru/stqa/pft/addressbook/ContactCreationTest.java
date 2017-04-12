package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateNewContact() {
        gotoContactCreationPage();
        fillContactCreationForm(new ContactDataGroup("Barry", "G.", "Allen", "Flash"));
        submitContactCreationPage();
        returnToHomePage();
    }
}
