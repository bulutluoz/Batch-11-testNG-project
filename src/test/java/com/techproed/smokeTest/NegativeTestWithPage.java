package com.techproed.smokeTest;

import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class NegativeTestWithPage extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //3 Farkli test Methodunda 3 senaryoyu test et
        //				- yanlisSifre

        //2 http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");
        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        crsytalHotelPage.ilkLogIn.click();
        crsytalHotelPage.userNameTexBox.sendKeys("manager");
        crsytalHotelPage.passwordTextBox.sendKeys("manager");
        //3) Login butonuna bas
        crsytalHotelPage.ikinciLoginButonu.click();
        //4) Verilen senaryolar ile giris yapilamadigini test et

        Thread.sleep(10000);
    }
}
