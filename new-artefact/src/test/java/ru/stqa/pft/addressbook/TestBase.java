package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class TestBase {
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

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    protected void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void initNewGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    protected void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    protected void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    protected void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    protected void fillContactCreationForm(ContactDataGroup contactDataGroup) {
        driver.findElement(By.name("firstname")).sendKeys(contactDataGroup.getcName());
        driver.findElement(By.name("middlename")).sendKeys(contactDataGroup.getcMiddleName());
        driver.findElement(By.name("lastname")).sendKeys(contactDataGroup.getcLastName());
        driver.findElement(By.name("nickname")).sendKeys(contactDataGroup.getcNickName());
    }

    protected void submitContactCreationPage(){
        driver.findElement(By.xpath("//input[@value='Enter']")).click();
    }

    protected void gotoContactCreationPage() {
        driver.findElement(By.linkText("add new")).click();
    }

    protected void selectGroup(){
        driver.findElement(By.name("selected[]")).click();
    }

    protected void deleteGroup(){
        driver.findElement(By.name("delete")).click();
    }
}
