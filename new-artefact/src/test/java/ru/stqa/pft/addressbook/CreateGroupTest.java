package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by omanzhos on 4/4/2017.
 */
public class CreateGroupTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:1234/addressbook/");
        login("admin", "secret");
    }

    private void login(String username, String password) {
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testCreateGroup(){
        gotoGroupPage();
        initNewGroupCreation();
        fillGroupForm(new GroupData("One test group", "Group header 1", "Group footer 1"));
        submitGroupCreation();
        returnToGroupPage();
    }

    @Test
    public void testCreateNewContact() {
        gotoContactCreationPage();
        fillContactCreationForm(new ContactDataGroup("Barry", "G.", "Allen", "Flash"));
        submitContactCreationPage();
        returnToHomePage();
    }

    private void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void initNewGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    private void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    private void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    private void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    private void fillContactCreationForm(ContactDataGroup contactDataGroup) {
        driver.findElement(By.name("firstname")).sendKeys(contactDataGroup.getcName());
        driver.findElement(By.name("middlename")).sendKeys(contactDataGroup.getcMiddleName());
        driver.findElement(By.name("lastname")).sendKeys(contactDataGroup.getcLastName());
        driver.findElement(By.name("nickname")).sendKeys(contactDataGroup.getcNickName());
    }

    private void submitContactCreationPage(){
        driver.findElement(By.xpath("//input[@value='Enter']")).click();
    }

    private void gotoContactCreationPage() {
        driver.findElement(By.linkText("add new")).click();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
