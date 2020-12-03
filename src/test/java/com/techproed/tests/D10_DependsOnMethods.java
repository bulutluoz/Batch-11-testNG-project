package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D10_DependsOnMethods {

    //● Bir class oluşturun: DependsOnTest
    //● https://www.walmart.com/ adresine gidin.
    //		1. Test : Wallmart ana sayfaya gittiginizi test edin
    //		2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin
    //		ve aramanizin gerceklestigini Test edin
    //		3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $6.65
    //		oldugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void homePageTest(){
        driver.get("https://www.walmart.com/");
        //		1. Test : Wallmart ana sayfaya gittiginizi test edin
        WebElement logo=driver.findElement(By.className("z_a"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test (dependsOnMethods = "homePageTest")
    public void searchTest(){
        //		2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin
        //		ve aramanizin gerceklestigini Test edin
        WebElement searchBox=driver.findElement(By.id("global-search-input"));
        searchBox.sendKeys("Nutella");
        searchBox.submit();
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains("Nutella"));

    }

    @Test (dependsOnMethods = "searchTest")
    public void fiyatTesti(){
        //		3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $6.65
        //		oldugunu test edin
        driver.findElement(By.xpath("(//img[@data-pnodetype='item-pimg'])[1]")).click();
        WebElement fiyat=driver.findElement(By.xpath("(//span[@class='price-group'])[1]"));
        Assert.assertEquals(fiyat.getText(),"$6.65");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
