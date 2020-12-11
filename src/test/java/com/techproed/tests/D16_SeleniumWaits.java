package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D16_SeleniumWaits extends TestBase {

    @Test
    public void test1(){
        driver.get("https:\\www.youtube.com");
        WebElement logo=driver.findElement(By.xpath("(//div[@id='logo-icon-container'])[1]"));

       // WebElement olmayaElelemnt=driver.findElement(By.id("olmayan"));
    }

    @Test
    public void implicitlyWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini test edin.
        WebElement sonucYaziElementi=driver.findElement(By.id("message"));
        //<p id="message">It's gone!</p>

        Assert.assertTrue(sonucYaziElementi.isDisplayed());
        //6. Add buttonuna basin

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement sonucYaziElementi2=driver.findElement(By.id("message"));
        //<p id="message">It's back!</p>
        Assert.assertTrue(sonucYaziElementi2.isDisplayed());
    }


    @Test
    public void ExplicitlyWait(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.

        WebDriverWait wait=new WebDriverWait(driver,30);

        WebElement removeButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapCheckbox()']")));
        removeButton.click();

        //5. “It’s gone!” mesajinin goruntulendigini test edin.

        WebElement itsGoneYazisielementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGoneYazisielementi.isDisplayed());

        //6. Add buttonuna basin

        removeButton.click();

        //7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackYazisiElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assert.assertTrue(itsBackYazisiElementi.isDisplayed());
    }
}
