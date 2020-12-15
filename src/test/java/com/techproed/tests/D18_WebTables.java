package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class D18_WebTables extends TestBase {


    public void login(){
        //● http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin adresine gidin
        // ○ Username : manager
        // ○ Password : Manager2!
        driver.get("http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager");
        driver.findElement(By.id("Password")).sendKeys("Manager2!"+ Keys.ENTER);

    }



    @Test
    public void tableTest() throws InterruptedException {
        login();
        Thread.sleep(5000);
        //	Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tBody=driver.findElement(By.xpath("//tbody"));

        // not: table body'si tek bir WebElement olarak locate edilebilir ve getTex() ile yazdirildiginda
        // body'de bulunan tum datalari yazdirir. Fakat bu datalar uzerinde ben manipulation yapamam

        System.out.println(tBody.getText());
        //	Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        // not: sutun sayisini bulmak icin sayfadaki thead icndeki headers(basliklar)i saymamiz yeterli
        // bunun icin bir list olusturup bu list'e xpath olarak //theader//th yazip basliklari aldik

        List <WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//th"));

        System.out.println("Tablodaki sutun sayisi : " + basliklarListesi.size());
        //headers(basliklar)'i yazdiralim

        for (WebElement w: basliklarListesi
             ) {
            System.out.println(w.getText());
        }

    }
    @Test
    public void printRows(){
        login();
     //				○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));

     //				○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        for (WebElement w:satirlarListesi
             ) {
            System.out.println(w.getText());
        }
     //				○ 4.satirdaki(row) elementleri konsolda yazdırın.

        System.out.println(satirlarListesi.get(4).getText());
     // listeden elemani almadan locate ederek 4.satiri yazdirin


    }


}
