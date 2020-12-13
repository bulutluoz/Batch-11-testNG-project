package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class D16_windowHandleHomeWork extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        // 2."Login Portal" a  kadar asagi inin
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='Login Portal']")).click();

        // 4.Diger window'a gecin

        String ilkSayfaHandle=driver.getWindowHandle();
        Set<String> tumSayfaHandleKumesi=driver.getWindowHandles();
        String ikinciSayfaHandle="";
        for (String w:tumSayfaHandleKumesi
             ) {
            if (!w.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=w;
            }
        }

        driver.switchTo().window(ikinciSayfaHandle);
        // ."username" ve  "password" kutularina deger yazdirin
        // 6."login" butonuna basin
        Faker faker=new Faker();
        WebElement usernameTextBox=driver.findElement(By.id("text"));
        actions.click(usernameTextBox)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.ENTER)
                .perform();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String alertyazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(alertyazisi,"validation failed");
        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        // Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandle);
        // 10.Ilk sayfaya donuldugunu test edin
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"http://webdriveruniversity.com/");
    }
}
