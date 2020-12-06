package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D11_Homework {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){

        // 1. https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // 2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
        // title : Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more
        String actualTitle=driver.getTitle();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(actualTitle,"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more","title yanlis amazon sayfasinda degilsin");

        // 3. kategori dropdown'indan Books kategorisini secin
        //    arama kutusuna history yazdirip aratin

        WebElement dropDown= driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));

        Select select=new Select(dropDown);
        select.selectByVisibleText("Books");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("History"+ Keys.ENTER);

        // 4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin

        WebElement ikinciKitap= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        WebElement besinciKitap=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[5]"));

        softAssert.assertTrue(ikinciKitap.getText().contains("History"));
        softAssert.assertTrue(besinciKitap.getText().contains("History"));

        // 5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin
        WebElement sonucYazisiElement= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisi=sonucYazisiElement.getText();
        int indexOver=sonucYazisi.indexOf("over");
        sonucYazisi=sonucYazisi.substring(indexOver+5);

        int indexSpace=sonucYazisi.indexOf(" ");
        sonucYazisi=sonucYazisi.substring(0,indexSpace);


        sonucYazisi=sonucYazisi.replaceAll("\\D","");
        int sonucSayisi=Integer.parseInt(sonucYazisi);


        softAssert.assertTrue(sonucSayisi>10000);

        softAssert.assertAll();
    }







    @AfterClass
    public void tearDown(){


        driver.close();
    }
}
