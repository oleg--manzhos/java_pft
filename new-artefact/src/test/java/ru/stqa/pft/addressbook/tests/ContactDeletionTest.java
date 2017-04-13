package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by omanzhos on 4/13/2017.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getContactHelper().contactSelection();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().applyContactDeletion();
    }
}
