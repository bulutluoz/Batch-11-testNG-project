package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.AccessibleObject;

public class D17_CreateHotel extends TestBase {

    @Test
    public void createHotel() throws InterruptedException {
        //1. Tests packagenin altına class olusturun: D17_CreateHotel
        //2. Bir metod olusturun: createHotel
        //3. qa-environment.crystalkeyhotels.com adresine git.
        driver.get("http://qa-environment.crystalkeyhotels.com ");
        driver.findElement(By.linkText("Log in")).click();
        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //				a. Username : manager
        //				b. Password : Manager2!
        WebElement usernameTextBox = driver.findElement(By.id("UserName"));
        usernameTextBox.sendKeys("manager");
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("Manager2!");
        //5. Login butonuna tıklayın.
        driver.findElement(By.id("btnSubmit")).click();
        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        driver.findElement(By.xpath("//*[text()='Hotel Management']")).click();
        driver.findElement(By.partialLinkText("Hotel List")).click();

        driver.findElement(By.xpath("//*[text()='Add Hotel ']")).click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        WebElement codeTextBox=driver.findElement(By.id("Code"));
        Actions actions=new Actions(driver);
        actions.click(codeTextBox)
                .sendKeys("06100")
                .sendKeys(Keys.TAB)
                .sendKeys("mehmet")
                .sendKeys(Keys.TAB)
                .sendKeys("ankara")
                .sendKeys(Keys.TAB)
                .sendKeys("5551234567")
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys("abc@gmail.com")
                .perform();
        WebElement dropDownElemneti=driver.findElement(By.id("IDGroup"));
        Select select=new Select(dropDownElemneti);
        select.selectByValue("1");

        //8. Save butonuna tıklayın.
        Thread.sleep(2000);
        driver.findElement(By.id("btnSubmit")).click();
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.

        Thread.sleep(2000);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[text()='Hotel was inserted successfully']"));
        String otelOlusturulduYazisi=sonucYaziElementi.getText();
        Thread.sleep(2000);
        Assert.assertEquals(otelOlusturulduYazisi,"Hotel was inserted successfully");

        //10. OK butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='OK']")).click();
    }

}
