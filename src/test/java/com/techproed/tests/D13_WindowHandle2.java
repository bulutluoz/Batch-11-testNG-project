package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class D13_WindowHandle2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement sayfaYazisiElementi=driver.findElement(By.tagName("h3"));


        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sayfaYazisiElementi.getText(),"Opening a new window");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualSayfaTitle=driver.getTitle();
        softAssert.assertEquals(actualSayfaTitle,"The Internet");

            Thread.sleep(5000);
        //● Click Here butonuna basın.
            driver.findElement(By.linkText("Click Here")).click();
            //1.adim ilk sayfanin handle ini al
            String ilkSayfaWindowHandle=driver.getWindowHandle();
            //2.adim acik tum sayfalarin handle'larini alip bir kumeye koyu
            Set<String> tumsayfaHandleKumesi=driver.getWindowHandles();
            //3.adim kumede 1.sayfa handle'ina esit olmayan handle'i bul ve bunu ikinciSayfaHandle'i olarak ata
            String ikinciSayfaHandle="";

            for (String w:tumsayfaHandleKumesi
             ) {
            if (!w.equals(ilkSayfaWindowHandle)){
                ikinciSayfaHandle=w;
            }
        }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

            driver.switchTo().window(ikinciSayfaHandle);
        // artik 2.sayfadayim
            String ikinciSayfaTitle=driver.getTitle();
            softAssert.assertEquals(ikinciSayfaTitle,"New Window");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

            WebElement ikinciSayfaYaziElementi=driver.findElement(By.tagName("h3"));
            softAssert.assertEquals(ikinciSayfaYaziElementi.getText(),"New Window");
          Thread.sleep(5000);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaWindowHandle);

        softAssert.assertEquals(actualSayfaTitle,"The Internet");
        Thread.sleep(5000);
        softAssert.assertAll();
    }
}
