package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D12_IFrame {

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
        driver.get("https://html.com/tags/iframe/");
        //1.adim iFrame'e nasil gecis yapacagimiza(switch) karar veririz
        //  index,id,webElement olarak locate ederiz
        //  biz bu soruda 3.yolu tercih ettik


        WebElement iFrame=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));

        // 2. adim iFrame'e switchTo() ile gecis yapiyoruz

        driver.switchTo().frame(iFrame);

        // 3. adim : iframe icinde istedigimiz WebElementinini locate edip istedigimiz islemi yapabiliriz

        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

    }




    @AfterClass
    public void tearDown(){
        //driver.close();
    }

}
