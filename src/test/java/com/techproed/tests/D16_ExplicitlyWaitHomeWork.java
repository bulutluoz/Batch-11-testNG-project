package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D16_ExplicitlyWaitHomeWork extends TestBase {

    @Test
    public void enableTest(){

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));

        SoftAssert softAssert=new SoftAssert();

       softAssert.assertFalse(textBox.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        WebDriverWait wait=new WebDriverWait(driver,20);
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));




        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        softAssert.assertTrue(message.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        softAssert.assertTrue(textBox.isEnabled());

        softAssert.assertAll();
    }

    @Test
    public void demoqaTest(){
        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait=new WebDriverWait(driver,20);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        WebElement sonradanGorunen=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        Assert.assertTrue(sonradanGorunen.isDisplayed());

    }

}
