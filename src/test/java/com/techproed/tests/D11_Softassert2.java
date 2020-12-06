package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class D11_Softassert2 {
    // Yeni bir Class Olusturun : D10_SoftAssert2
    //1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)",
    // "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
    // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
    // "Singapore (dollar)","Thailand (baht)"

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin

        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        // 3. Login kutusuna “username” yazin
        WebElement userNameBox= driver.findElement(By.id("user_login"));
        userNameBox.sendKeys("username");
        // 4. Password kutusuna “password” yazin
        WebElement paswordBox=driver.findElement(By.id("user_password"));
        paswordBox.sendKeys("password");
        // 5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();
        // 6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin

        WebElement dropDown=driver.findElement(By.id("pc_currency"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");

        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin

        SoftAssert softAssert=new SoftAssert();
        String expectedResult="Eurozone (Euro)";
        String actualresult=select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualresult,expectedResult,"Eurozone  secimi yanlis");



        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)",
        // "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
        // "Singapore (dollar)","Thailand (baht)"

        List<WebElement> tumOpsiyonlar= select.getOptions();
        List<String> tumOpsiyonlarString = new ArrayList<String>();

        for (WebElement w:tumOpsiyonlar
             ) {

            tumOpsiyonlarString.add(w.getText());
        }

        List<String > expectedOptionsList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)", "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)", "Singapore (dollar)","Thailand (baht)");
        System.out.println(expectedOptionsList);

        softAssert.assertEquals(tumOpsiyonlarString,expectedOptionsList,"options listesi actual ile uyusmuyor");

        softAssert.assertAll();
    }


    @AfterClass
    public void tearDown(){


        driver.close();
    }

}
