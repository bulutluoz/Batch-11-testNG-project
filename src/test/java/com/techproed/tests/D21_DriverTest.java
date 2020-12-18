package com.techproed.tests;


import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class D21_DriverTest {

    @Test
    public void test(){

        Driver.getDriver().get("https://www.youtube.com");

        Driver.getDriver().get("https://www.amazon.com");

        Driver.getDriver().get("https://www.bestbuy.com");


        Driver.closeDriver();




    }



}
