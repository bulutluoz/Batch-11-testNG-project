package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D16_IFrameHomeWork extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //“Our Products” butonuna basin

        driver.switchTo().frame("frame");
        driver.findElement(By.linkText("Our Products")).click();

        //“Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        //Popup mesajini yazdirin
        String message=driver.findElement(By.className("modal-body")).getText();
        System.out.println("pop up mesaji : "+ message);
        //“close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        //"WebdriverUniversity.com (IFrame)" linkini tiklayin

        driver.switchTo().defaultContent();
        driver.findElement(By.partialLinkText("WebdriverUniversity")).click();

        Thread.sleep(5000);
        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin

        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"http://webdriveruniversity.com/index.html");

    }

}
