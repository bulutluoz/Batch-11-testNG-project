package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class D13_WindowsHandle1 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe\n");
        // elemental Selenium linkine tiklayalim
        // 1.adim driver ile gittigimiz sayfanin windowHandle'ini alip bir String degiskene kaydedelim
        String ilkSayfaWindowHandle=driver.getWindowHandle();

        // 2.adim diger sayfayi acan linki locate edip click islemi yaptim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        // 3. adim getWindowHandles() komutu ile acik olan tum window'larin windowHgandle'larini alip bir kumeye koyalim
        Set<String> tumHandleKumesi=driver.getWindowHandles();

        //4. adim : kume icerisindeki 2 windowhandle'dan 1 sayfaninkine esit olamayani bulup 2.sayfa olarak tanimlayalim

        String ikincisayfaWindowHandle="";

        for (String w: tumHandleKumesi
             ) {
            if (!w.equals(ilkSayfaWindowHandle)){
                ikincisayfaWindowHandle=w;
            }
        }
        // 5.adim artik iki sayfanin da windowHandle'ina sahibim.
        // istedigim gibi sayfalar arsinda gecis yapabilirim

        driver.switchTo().window(ikincisayfaWindowHandle);
        // h1 tagindaki yazinin Elemental Selenium oldugunu test edelim

        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(yaziElementi.getText(),"Elemental Selenium");
    }
}
