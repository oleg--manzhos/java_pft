package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDataGroup;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class ApplicationManager {

    WebDriver driver;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;

    public void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:1234/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        if (driver != null){
            driver.quit();
        }
    }

    public void returnToHomePage() {
        navigationHelper.returnToHomePage();
    }

    public void fillContactCreationForm(ContactDataGroup contactDataGroup){
        contactHelper.fillContactCreationForm(contactDataGroup);
    }

    public void submitContactCreationPage(){
        contactHelper.submitContactCreationPage();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }


    public void selectGroup(){
       groupHelper.selectGroup();
    }

    public void deleteGroup(){
      groupHelper.deleteGroup();
    }

    public void submitGroupCreation() {
        groupHelper.submitGroupCreation();
    }

    public void fillGroupForm(GroupData groupData) {
        groupHelper.fillGroupForm(groupData);
    }

    public void initNewGroupCreation() {
        groupHelper.initNewGroupCreation();
    }

    public void returnToGroupPage() {
        navigationHelper.returnToGroupPage();
    }

    public void gotoGroupPage() {
        navigationHelper.gotoGroupPage();
    }

    public void gotoContactCreationPage(){
        navigationHelper.gotoContactCreationPage();
    }
}
