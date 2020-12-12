package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D16_Faker extends TestBase {

    @Test
    public void test(){

        Faker faker=new Faker();
        String isim=faker.internet().password();
        System.out.println(isim);

    }

    @Test
    public void facebookUserTest() throws InterruptedException {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com/");
        //“create new account”  butonuna basin
        driver.findElement(By.id("u_0_2")).click();
        //“firstName” giris kutusuna bir isim yazin
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();

        String email=faker.internet().emailAddress();

         actions.click(isimKutusu)
                 .sendKeys(faker.name().firstName())
                 .sendKeys(Keys.TAB)
                 .sendKeys(faker.name().lastName())
                 .sendKeys(Keys.TAB)
                 .sendKeys(email)
                 .sendKeys(Keys.TAB)
                 .sendKeys(email)
                 .sendKeys(Keys.TAB)
                 .sendKeys(faker.internet().password())
                 .perform();


        WebElement gunDropDown=driver.findElement(By.name("birthday_day"));
        Select select=new Select(gunDropDown);
        select.selectByValue("12");

        WebElement ayDropDown=driver.findElement(By.name("birthday_month"));
        Select select1=new Select(ayDropDown);
        select1.selectByValue("6");

        WebElement yilDropDown=driver.findElement(By.name("birthday_year"));
        Select select2=new Select(yilDropDown);
        select2.selectByValue("1956");


        //Cinsiyeti secin
        WebElement erkekRadioButton=driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        erkekRadioButton.click();
        WebElement ozelRadioButton=driver.findElement(By.xpath("(//input[@name='sex'])[3]"));
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.

        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(ozelRadioButton.isSelected());



    }


}
