package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GlbHomePage {


    public GlbHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText="Sign In")
    public WebElement signInButonu;

    @FindBy(id="email")
    public  WebElement mail;

    @FindBy(id="password")
    public  WebElement password;


    @FindBy(xpath="//button[@value='Login']")
    public  WebElement loginButonu;

    @FindBy(xpath ="//div[@class='my_account_header']")
    public WebElement girisBasarili;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement girisBasarisiz;


}
