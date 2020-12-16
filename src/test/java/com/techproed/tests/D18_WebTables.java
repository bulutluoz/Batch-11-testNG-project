package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

        System.out.println(satirlarListesi.get(3).getText());
     // listeden elemani almadan locate ederek 4.satiri yazdirin
        WebElement dorduncuSatir=driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(dorduncuSatir.getText());


    }

    @Test
    public void printCells(){
        //● printCells() metodu oluşturun //td


        login();
        List<WebElement> tumHucrelerListesi=driver.findElements(By.xpath("//tbody//td"));
        //				○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println("tablodaki hucre sayisi : " + tumHucrelerListesi.size());
        //				○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        for (WebElement w: tumHucrelerListesi
             ) {
            System.out.println(w.getText());
        }

    }

    @Test
    public void printColumns(){
        //● printColumns() metodu oluşturun

        login();
        //				○ table body’sinde bulunan toplam sutun(column) sayısını bulun.

        List<WebElement> basliklarList =driver.findElements(By.xpath("//thead//th"));
        int sutunSayisi=basliklarList.size(); // 9


        //	○ 5.column daki elementleri konsolda yazdırın.

        List<WebElement> allSutun = driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement w: allSutun
        ) {
            System.out.println(w.getText());
        }

        //	○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        // her sutunun basina sutun header'ini yazsin

        for ( int i=1; i<=sutunSayisi; i++){


            List<WebElement>allsutun= driver.findElements(By.xpath("//tbody//td[" + i +"]"));
            WebElement sutunBasligi=driver.findElement(By.xpath("//thead//th[" + i + "]"));
            System.out.println(sutunBasligi.getText());

            for (WebElement w:allsutun) {
                System.out.println(w.getText());
            }
        }

    }

    @Test
    public void asd(){
        login();

        // 1.den 9.ya kadar sutun basliklarini yazdiralim

        for (int i=1; i<=9 ; i++){

            WebElement ucuncuSutunBasligi=driver.findElement(By.xpath("//thead//th[" + i + " ]"));
            System.out.println(ucuncuSutunBasligi.getText());
        }

    }

    public String printData(int satir,int sutun){
        //1. Bir metod oluşturun : printData(int row, int column);
        // a. Satır(row) ve sütun(column) numarasını girdiğinizde,
        // printData metodu bu  hücredeki(cell) veriyi yazdırmalıdır.

        WebElement yazdirilacakData=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(yazdirilacakData.getText());


        return yazdirilacakData.getText();
    }

    @Test
    public void printDataTest(){
        //2. Baska bir Test metodu oluşturun: printDataTest();
        // a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
        // b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        // c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
        login();

        //yazdirilanin NewYork oldugunu test edin

        Assert.assertEquals(printData(3,5),"NewYork");

    }

}
