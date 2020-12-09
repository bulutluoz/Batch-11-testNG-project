package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class D14_KeyBoardActions2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");

        Actions actions=new Actions(driver);
        WebElement userNameBox=driver.findElement(By.id("email"));

        actions.click(userNameBox)
                .sendKeys("mehmet")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(5000);


    }
}
