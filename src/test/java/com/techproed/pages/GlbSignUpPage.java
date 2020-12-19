package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

   public GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="email")
    public WebElement email;

    @FindBy(xpath="//input[@id='name']")
    public WebElement name;

    @FindBy(xpath="//input[@id='mobile']")
    public WebElement mobile;

    @FindBy(xpath="//input[@id='password']")
    public WebElement passText;

    @FindBy(xpath="//input[@id='re_password']")
    public WebElement repassText;

    @FindBy(xpath="//button[@value='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successTex;


}
