package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrsytalHotelPage {

    WebDriver driver;

    public CrsytalHotelPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLogIn;

    @FindBy(id="UserName")
    public WebElement userNameTexBox;

    @FindBy(id="Password")
    public WebElement passwordTextBox;

    @FindBy(id="btnSubmit")
    public WebElement ikinciLoginButonu;

}
