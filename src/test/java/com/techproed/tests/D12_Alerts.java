package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D12_Alerts {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void acceptAlert() throws InterruptedException {

        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //● Bir metod olusturun: acceptAlert
        // 			○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //“You successfuly clicked an alert” oldugunu test edin.

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String sonucYazisi=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(sonucYazisi,"You successfuly clicked an alert");

    }

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //● Bir metod olusturun: dismissAlert
        //			○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının 									“successfuly” icermedigini test edin.
        //             “successfuly” icermedigini test edin.
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        String sonucYazisi=driver.findElement(By.id("result")).getText();
        Assert.assertFalse(sonucYazisi.contains("successfuly"));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        //● Bir metod olusturun: sendKeysAlert
        //			○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //			tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("mehmet");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        Thread.sleep(3000);

        String sonucYazisi=driver.findElement(By.id("result")).getText();
        Assert.assertTrue(sonucYazisi.contains("mehmet"));

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
