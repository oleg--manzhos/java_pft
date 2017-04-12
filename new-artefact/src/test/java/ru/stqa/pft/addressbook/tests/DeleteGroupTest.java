package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class DeleteGroupTest extends TestBase {

    @Test
    public void testGroupDeletion(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getNavigationHelper().returnToGroupPage();

    }

}
