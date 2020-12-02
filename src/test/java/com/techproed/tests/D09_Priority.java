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

public class D09_Priority {


    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri 	yapin
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest=> Sayfa basliginin “youtube” olmadigini dogrulayin

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test (priority=5)
    public void titleTest() {
        //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://www.youtube.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    @Test
    public void imageTest() {
        //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin

        driver.get("https://www.youtube.com");
        WebElement logo = driver.findElement(By.xpath("(//div[@id='logo-icon-container'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void searchBoxUlasmaTesti() {
        //	○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        driver.get("https://www.youtube.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());

    }

    @Test (priority=10)
    public void wrongTitleTest(){
        //	○ wrongTitleTest=> Sayfa basliginin “youtube” olmadigini dogrulayin
        driver.get("https://www.youtube.com");
        String actualTitle=driver.getTitle();
        String yanlisTitle="youtube";
        Assert.assertFalse(actualTitle.equals(yanlisTitle));

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
