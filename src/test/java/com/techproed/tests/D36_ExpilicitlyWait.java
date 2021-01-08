package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D36_ExpilicitlyWait extends TestBase {
    //senkronization: internete veya uygulamaya bagli olarak yasan gecikmelerde locate etmek veya
    // kullanmak istedigimiz Webelementlere ulasmakta sorun yasayabiliriz.
    //Bu durumda uygun wait komutlari ile Driver ve uygulama arasindaki uyum problemleri(senkronization issue) cozulur

    // Thread.sleep : Hard wait yapar. Java komutlarini yazilan sure kadar bekletir.
    // Implicitly Wait : sayfadaki tum webelementlerinin locate islemleri  icin yazilan maximum sure kadar bekler
    //                  Maximim bekleme suresi asilirsa NoSuchElementException verir
    // Explicitly Wait : Belirli sarta baglanmis belirli Web Elementleri icin max.sureye kadar sartin saglanmasini bekler
    //                     Kullanmak icin wait objesi olusturmamiz gerekir
    // implicitly wait ve Explicitly wait dinamik wait olarak adlandirilir,
    // cunku istenen durum gerceklesirse maximunm surenin dolmasini beklemez

    @Test
    public void test1() throws InterruptedException {
        //https://demoqa.com/browser-windows adresine gidin
        driver.get("https://demoqa.com/browser-windows");
        //Alerts’e tiklayin
        driver.findElement(By.xpath("(//li[@id='item-1'])[2]")).click();
        //On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
        driver.findElement(By.id("timerAlertButton")).click();
        //Allert’in gorunur olmasini bekleyin
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.alertIsPresent());

        //Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin

        String alertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(alertYazisi,"This alert appeared after 5 seconds");
        //Ok diyerek alerti kapatin

        driver.switchTo().alert().accept();
    }

    @Test
    public void test2(){
        //https://demoqa.com/dynamic-properties adresine gidin
        driver.get("https://demoqa.com/dynamic-properties");

        //“Will enable 5 seconds” butonunun enable olmasini bekleyin

        WebDriverWait wait=new WebDriverWait(driver,20);
        // webelemnt locate edilebilir durumda ise 3 farkli sekilde explicitly wait yapabilirim
        //1- once webelenti locate edip sonra wait objesi ve webelemeti kullanabilirim
        //WebElement enableafter=driver.findElement(By.id("enableAfter"));
        //wait.until(ExpectedConditions.elementToBeClickable(enableafter));
        //2- once webelementi locate edip sonra  bekleme islemini de locator ile yapabilirim
        //WebElement enableafter=driver.findElement(By.id("enableAfter"));
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        //3- webelemnt locate etme ve bekleme isilemlerini ayni satirda yapabilirim
        WebElement enableAfter=wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));

        //“Will enable 5 seconds” butonunun enable oldugunu test edin

        Assert.assertTrue(enableAfter.isEnabled());
    }


    @Test
    public void test3(){
        //visibleAfter
        //https://demoqa.com/dynamic-properties adresine gidin
        driver.get("https://demoqa.com/dynamic-properties");
        //“Visible After 5 seconds” butonunun gorunur olmasini bekleyin

        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement sonradanCikan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        //“Visible After 5 seconds” butonunun gorunur oldugunu test edin
        Assert.assertTrue(sonradanCikan.isDisplayed());
    }


    @Test
    public void test4()  {
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //“Add Element” butona basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        //“Delete” butonu gorunur oluncaya kadar bekleyin
        WebDriverWait wait =new WebDriverWait(driver,20);
        WebElement delete=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='deleteElement()']")));
        //“Delete” butonunun gorunur oldugunu test edin
        Assert.assertTrue(delete.isDisplayed());
        //Delete butonuna basarak butonu silin
        delete.click();
        //Delete butonunun gorunmedigini test edin
       // delete butonu silindigi icin bu webelemente ulasilamaz, dolayisiyla da test yapilamaz
       //StaleElementReferenceException hatasi verir

       // Assert.assertFalse(delete.isDisplayed());


    }
}
