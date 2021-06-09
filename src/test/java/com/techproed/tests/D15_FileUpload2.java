package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D15_FileUpload2 extends TestBase {

    //Tests packagenin altina bir class oluşturun : D14_UploadFile
    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //4. Yuklemek istediginiz dosyayi secelim.
    //5. Upload butonuna basalim.
    //6. “File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/upload/");
        // dosya sec butonunu locate edin ve masaustundeki FLOWER.jpg dosyasinin yolunu olusturun

        WebElement dosyaSecButonu= driver.findElement(By.id("uploadfile_0"));

        String homePath= System.getProperty("user.home");
        String filePath= homePath+"\\Desktop\\FLOWER.jpg";

        dosyaSecButonu.sendKeys(filePath);
        Thread.sleep(10000);

        WebElement upLoadButonu=driver.findElement(By.id("submitbutton"));
        upLoadButonu.click();

        Thread.sleep(5000);

        WebElement sonucYaziElementi=driver.findElement(By.tagName("h3"));

        Assert.assertEquals(sonucYaziElementi.getText(),"1 file\n" +
                "has been successfully uploaded.");


    }
}
