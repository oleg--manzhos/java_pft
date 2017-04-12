package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
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

    public void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:1234/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        if (driver != null){
            driver.quit();
        }
    }

    public void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void fillContactCreationForm(ContactDataGroup contactDataGroup) {
        driver.findElement(By.name("firstname")).sendKeys(contactDataGroup.getcName());
        driver.findElement(By.name("middlename")).sendKeys(contactDataGroup.getcMiddleName());
        driver.findElement(By.name("lastname")).sendKeys(contactDataGroup.getcLastName());
        driver.findElement(By.name("nickname")).sendKeys(contactDataGroup.getcNickName());
    }

    public void submitContactCreationPage(){
        driver.findElement(By.xpath("//input[@value='Enter']")).click();
    }

    public void gotoContactCreationPage() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void selectGroup(){
       driver.findElement(By.name("selected[]")).click();
    }

    public void deleteGroup(){
      driver.findElement(By.name("delete")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
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
        groupHelper.returnToGroupPage();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void gotoGroupPage() {
        navigationHelper.gotoGroupPage();
    }
}
