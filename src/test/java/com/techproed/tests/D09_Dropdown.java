package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class D09_Dropdown {

    // Bir class oluşturun: DropDown
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    //		1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //		2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //		3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin
    //			ve yazdırın
    //		4.Tüm dropdown değerleri(value) yazdırın
    //		5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
    //			True , degilse False yazdırın.

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void DropdownTesti(){
        //		1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        //1. adim dropdown webelemntini locate edelim

        WebElement dropDown=driver.findElement(By.xpath("//select[@id='dropdown']"));

        // 2.adim Select object'i olusturalim ve locate ettigimiz Webelement'i parametre olarak objeye ekledik

        Select select = new Select(dropDown);

        // 3. adim varolan 3 yontemden herhangi biri ile istedigimiz kategoriyi secelim

        select.selectByIndex(1);
        String ilkSecilenOpsiyon= select.getFirstSelectedOption().getText();

        //sectigimiz option'in "Opsiyon1" oldugunu test edin

        Assert.assertEquals(ilkSecilenOpsiyon,"Option 1");

    }

    @Test
    public void test02(){
        //		2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropDown);
        select.selectByValue("2");

        String ikinciSecilenOpsiyon=select.getFirstSelectedOption().getText();
        //sectigimiz opsiyonun Option 2 oldugunu test edelim

        Assert.assertEquals(ikinciSecilenOpsiyon,"Option 2");
    }

    @Test
    public void tumListe(){
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropDown);

        List<WebElement> listeninTamami = select.getOptions();

        for (WebElement w : listeninTamami
             ) {
            System.out.println(w.getText());
        }
        //		5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
        //			True , degilse False yazdırın.

        int listeninBoyutu=listeninTamami.size();

        if (listeninBoyutu==4){
            System.out.println("True");
        } else {
            System.out.println("False");
        }


    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
