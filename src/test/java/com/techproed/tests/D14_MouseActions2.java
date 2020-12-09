package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D14_MouseActions2 extends TestBase {

    @Test
    public void test() throws InterruptedException {


        //1- http://uitestpractice.com/Students/Actions adresine gidelim

        driver.get("http://uitestpractice.com/Students/Actions");

        // 2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim

        Actions actions=new Actions(driver);

        WebElement renkDegistir=driver.findElement(By.id("div2"));

        actions.moveToElement(renkDegistir).perform();
        Thread.sleep(5000);


        // 3- Click Me butonuna click yapalim ve cikan alertteki mesajin "Clicked !!" oldugunu dogrulayalim

        WebElement clickMe=driver.findElement(By.name("click"));
        actions.click(clickMe).perform();
        Thread.sleep(3000);

        SoftAssert softAssert=new SoftAssert();
        String allertYazisi=driver.switchTo().alert().getText();
        softAssert.assertEquals(allertYazisi,"Clicked !!");

        driver.switchTo().alert().accept();
        // 4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim

        WebElement doubleClick=driver.findElement(By.name("dblClick"));
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(3000);

        String doubleClickAllertYazisi=driver.switchTo().alert().getText();
        softAssert.assertEquals(doubleClickAllertYazisi,"Double Clicked !!");
        driver.switchTo().alert().accept();

        // 5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef kutuda "Dropped!" yazildigini dogrulayin

        WebElement tasinacakElement=driver.findElement(By.id("draggable"));
        WebElement tasimaHedefElementi = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(tasinacakElement,tasimaHedefElementi).perform();

        String hedefElementYazisi=tasimaHedefElementi.getText();

        softAssert.assertEquals(hedefElementYazisi,"Dropped!");

        Thread.sleep(5000);
        softAssert.assertAll();
    }
}
