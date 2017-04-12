package ru.stqa.pft.addressbook;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
    }

    @Test
    public void testCreateGroup(){
        driver.get("http://localhost:1234/addressbook/");
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).sendKeys("One test group");
        driver.findElement(By.name("group_header")).sendKeys("Group header 1");
        driver.findElement(By.name("group_footer")).sendKeys("Group footer 1");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }

    @Test
    public void testCreateNewContact() {
        driver.get("http://localhost:1234/addressbook/");
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).sendKeys("Barry");
        driver.findElement(By.name("middlename")).sendKeys("G.");
        driver.findElement(By.name("lastname")).sendKeys("Allen");
        driver.findElement(By.name("nickname")).sendKeys("Flash");
        driver.findElement(By.xpath("//input[@value='Enter']")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
