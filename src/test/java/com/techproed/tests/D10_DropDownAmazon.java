package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D10_DropDownAmazon {
    //● https://www.amazon.com/ adresine gidin.
    //		- Test 1
    //			Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 27 oldugunu test edin
    //		-Test 2
    //			1. Kategori menusunden Books secenegini  secin
    //			2. Arama kutusuna Java yazin ve aratin
    //			3. Bulunan sonuc sayisini yazdirin
    //			4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void sayfayaGit(){
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void test01(){
        //			Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);
        List<WebElement> tumListe= select.getOptions();

        int kategoriSayisi=tumListe.size()-1;
        Assert.assertEquals(kategoriSayisi,27);

    }

    @Test
    public void javaTest(){
        //		-Test 2
        //			1. Kategori menusunden Books secenegini  secin
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Books");

        //			2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);

        //			3. Bulunan sonuc sayisini yazdirin

        WebElement sonucSayisi =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());
        //			4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonucSayisi.getText().contains("Java"));

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
