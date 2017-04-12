package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class DeleteGroupTest extends TestBase {

    @Test
    public void testCroupDeletion(){
        gotoGroupPage();
        selectGroup();
        deleteGroup();
        returnToGroupPage();

    }

}
