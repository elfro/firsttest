package com.mytest.webdriver;

import com.maps.uiMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by USER on 20.07.2016.
 */

public class MyTest {

    private WebDriver driver;

    @BeforeClass
    public  void SetUP() {
        driver=new FirefoxDriver();
//        driver=new ChromeDriver();
    }

    @Test
    public void GotoPage(){

        driver.get(uiMap.URL_HOME);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id(uiMap.HOME_EMAIL_ID)).sendKeys("qatestllc@gmail.com");
        driver.findElement(By.id(uiMap.HOME_PASSWORD_ID)).sendKeys("123456");
        driver.findElement(By.xpath(uiMap.HOME_SIGNIN_XPath)).click();
        String text = driver.findElement(By.className("message-text")).getText();
        Assert.assertEquals(text,"The email and password you entered did not match our records. Please double-check and try again.");
    }

    @AfterClass
    public void CloseDriver() {
        driver.close();
    }
}
