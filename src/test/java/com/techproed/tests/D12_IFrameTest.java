package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D12_IFrameTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void iFrameTest(){

        //● https://the-internet.herokuapp.com/iframe adresine gidin.

        driver.get("https://the-internet.herokuapp.com/iframe");

        //		○ “An IFrame containing….” textinin ulasilabilir oldugunu dogrulayin ve yazdirin
        SoftAssert softAssert=new SoftAssert();

        WebElement anIFrameYazisiElementi=driver.findElement(By.tagName("h3"));
        softAssert.assertTrue(anIFrameYazisiElementi.isEnabled());
        System.out.println(anIFrameYazisiElementi.getText());

        //		○ Text Box’a “Merhaba Dunya!” yazin.

        driver.switchTo().frame("mce_0_ifr");
        //artik iframe'in icindeyim

        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        //		○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin
        //	ve 	konsolda yazdirin.

        // 46.satirda iframe'in icine girmistik, simdi iframe'in disinda bir islem yapmak istiyorsak
        // once iframe'den cikmamiz gerekiyor.

        driver.switchTo().defaultContent();
        WebElement elemantalYazisiElementi=driver.findElement(By.linkText("Elemental Selenium"));
        softAssert.assertTrue(elemantalYazisiElementi.isDisplayed());
        System.out.println(elemantalYazisiElementi.getText());

        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
