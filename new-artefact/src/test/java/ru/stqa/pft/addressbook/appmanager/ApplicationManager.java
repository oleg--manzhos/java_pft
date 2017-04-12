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
public class ApplicationManager{

    WebDriver driver;

    public void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:1234/addressbook/");
        login("admin", "secret");
    }

    public void stop() {
        if (driver != null){
            driver.quit();
        }
    }

    private void login(String username, String password) {
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    protected void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initNewGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
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
}
