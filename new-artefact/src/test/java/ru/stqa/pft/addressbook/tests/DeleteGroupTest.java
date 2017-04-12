package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class DeleteGroupTest extends TestBase {

    @Test
    public void testCroupDeletion(){
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteGroup();
        app.returnToGroupPage();

    }

}
