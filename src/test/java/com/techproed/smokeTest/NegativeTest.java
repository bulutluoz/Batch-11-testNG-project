package com.techproed.smokeTest;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {

    //3 Farkli test Methodunda 3 senaryoyu test et
    //				- yanlisSifre
    //				- yanlisKulllanici
    //				- yanlisSifreKullanici
    //2 http://qa-environment.crystalkeyhotels.com adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et
        Faker faker=new Faker();

    public void giris(){
        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();
    }


    @Test
    public void yanlisSifreTesti(){
        giris();
        WebElement userNameTexBox=driver.findElement(By.id("UserName"));
        userNameTexBox.sendKeys("manager");
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys(faker.internet().password()+ Keys.ENTER);
        WebElement girilemediUyarisiWebElementi=driver.findElement(By.xpath("//*[text()='Try again please']"));
        Assert.assertEquals(girilemediUyarisiWebElementi.getText(),"Try again please");
    }


    @Test
    public void yanlisKullaniciAdiTesti(){
        giris();
        WebElement userNameTexBox=driver.findElement(By.id("UserName"));
        userNameTexBox.sendKeys(faker.name().firstName());
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("Manager2!"+Keys.ENTER);
        WebElement girilemediUyarisiWebElementi=driver.findElement(By.xpath("//*[text()='Try again please']"));
        Assert.assertEquals(girilemediUyarisiWebElementi.getText(),"Try again please");

    }

    @Test
    public void yanlisKullaniciAdiVeSifreTesti(){
        giris();
        WebElement userNameTexBox=driver.findElement(By.id("UserName"));
        userNameTexBox.sendKeys(faker.name().firstName());
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys(faker.internet().password()+ Keys.ENTER);
        WebElement girilemediUyarisiWebElementi=driver.findElement(By.xpath("//*[text()='Try again please']"));
        Assert.assertEquals(girilemediUyarisiWebElementi.getText(),"Try again please");


    }


}
