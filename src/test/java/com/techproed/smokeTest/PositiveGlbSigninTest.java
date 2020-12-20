package com.techproed.smokeTest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveGlbSigninTest {

    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("gt_signUp_url"));
        GlbHomePage glbHomePage=new GlbHomePage();
        glbHomePage.signInButonu.click();
        glbHomePage.mail.sendKeys(ConfigReader.getProperty("gt_email"));
        glbHomePage.password.sendKeys(ConfigReader.getProperty("gt_pasword"));
        glbHomePage.loginButonu.click();
        Thread.sleep(3000);
        Assert.assertEquals(glbHomePage.girisBasarili.getText(),ConfigReader.getProperty("gt_giris_basarili_yazi"));

        Driver.closeDriver();

    }
}
