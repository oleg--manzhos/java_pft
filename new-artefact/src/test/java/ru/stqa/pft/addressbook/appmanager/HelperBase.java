package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by omanzhos on 4/12/2017.
 */
public class HelperBase {

    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void type (By locator, String text) {
        click(locator);
        if (text != null) {
             String existingText = driver.findElement(locator).getAttribute("value");
             if (!text.equals(existingText)){
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public boolean isElementPresent(By locator){
        try{
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
}
