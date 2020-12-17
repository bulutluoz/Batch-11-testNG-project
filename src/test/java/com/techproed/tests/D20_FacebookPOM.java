package com.techproed.tests;

import com.techproed.pages.FaceBookPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class D20_FacebookPOM extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement userTextBox= driver.findElement(By.id("email"));
        userTextBox.sendKeys("mehmet@gmail.com");

        WebElement passwordTexBox=driver.findElement(By.id("pass"));
        passwordTexBox.sendKeys("12345");

        WebElement loginButton=driver.findElement(By.id("u_0_b"));
        loginButton.click();

        Thread.sleep(10000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.facebook.com");
        //1.adimdaki hedef locater'lardan kurtulmak
        // bunun icin pages paketi altindaki ilgili page'de ihtiyac duydugum tum lacate islemlerini yapip
        // burada sadece kullanacagim

        FaceBookPage faceBookPage =new FaceBookPage(driver);
        faceBookPage.userTextBox.sendKeys("mehmet@gmail.com");
        faceBookPage.passwordTextBox.sendKeys("12345");
        faceBookPage.loginButonu.click();

        Thread.sleep(10000);

    }


    @Test
    public void test3() throws InterruptedException {

        driver.get(ConfigReader.getProperty("facebook_url"));
        FaceBookPage faceBookPage=new FaceBookPage(driver);
        faceBookPage.userTextBox.sendKeys(ConfigReader.getProperty("fb_user"));
        faceBookPage.passwordTextBox.sendKeys(ConfigReader.getProperty("fb_pass"));
        faceBookPage.loginButonu.click();
        Thread.sleep(10000);
    }

}
