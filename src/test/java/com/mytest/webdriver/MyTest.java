package com.mytest.webdriver;

import org.openqa.selenium.WebElement;
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
    public  void SetUP(){
        driver=new FirefoxDriver();
    }

    @Test
    public void GotoPage(){

        driver.get("https://twitter.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("signin-email")).sendKeys("qatestllc@gmail.com");
        driver.findElement(By.id("signin-password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"front-container\"]/div[2]/div[2]/form/table/tbody/tr/td[2]/button")).click();
    //    String text = driver.findElement(By.className("message-text")).getText();
    //    Assert.assertEquals(text,"Введённые адрес электронной почты и пароль не совпадают с сохранёнными в нашей базе данных. Проверьте правильность введённых данных и повторите попытку.");
    }

    @AfterClass
    public void CloseDriver() {
        driver.close();
    }
}
