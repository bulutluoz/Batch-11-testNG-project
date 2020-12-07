package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D11_SoftAssert1 {

    //Yeni bir Class Olusturun : D11_SoftAssert1
    //
    //1. “http://https://www.sahibinden.com/” Adresine gidi
    // 2. Basliginin "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" oldugunu dogrulayin
    // 3. search kutusuna araba yazip arattirin
    // 4.	bulunan sonuc sayisini yazdirin
    // 5.	sonuc yazisinin "araba" icerdigini dogrulayin
    //6.	Tumunu temizle linkini tiklayin
    //7.	Bulunan sonucu yazdirin
    //8.	Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test01(){
        driver.get("https://www.sahibinden.com/");
        SoftAssert softAssert = new SoftAssert();
        // 2. Basliginin "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" oldugunu dogrulayin
        String expectedTitle="Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri";
        String actualTitle= driver.getTitle();

        softAssert.assertEquals(actualTitle,expectedTitle,"anasayfa title'i istedigim gibi degil");

        // 3. search kutusuna araba yazip arattirin
        WebElement searchBox=driver.findElement(By.id("searchText"));
        searchBox.sendKeys("araba" + Keys.ENTER);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='result-text estimated-result-text']"));
        // 4.	bulunan sonuc sayisini yazdirin
        System.out.println(sonucYaziElementi.getText());
        // 5.	sonuc yazisinin "araba" icerdigini dogrulayin

        softAssert.assertTrue(sonucYaziElementi.getText().contains("araba"),"arama sonuc sayisi araba kelimesi icermiyor");

        //6.	Tumunu temizle linkini tiklayin
        driver.findElement(By.linkText("Tümünü Temizle")).click();
        //7.	Bulunan sonucu yazdirin
        WebElement sonucYaziElementi2=driver.findElement(By.className("result-text"));
        System.out.println(sonucYaziElementi2.getText());

        //8.	Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin

        softAssert.assertFalse(sonucYaziElementi2.getText().contains("araba"),"son test basarisiz");

        softAssert.assertAll();
        System.out.println("bu satir calisir mi?");
    }

    @AfterClass
    public void tearDown(){

        driver.close();
    }
}
