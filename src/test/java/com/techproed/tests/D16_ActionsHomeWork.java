package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class D16_ActionsHomeWork extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1."http://webdriveruniversity.com/Actions" sayfasina gidin

        driver.get("http://webdriveruniversity.com/Actions");
        // 2."Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement HO1=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(HO1).perform();

        // 3."Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();

        Thread.sleep(5000);

        // 4.Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        // 5.Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        // 6."Click and hold" kutusuna basili tutun
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement clickAndHold=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();

        // 7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());
        // 8. "Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();

    }
}
