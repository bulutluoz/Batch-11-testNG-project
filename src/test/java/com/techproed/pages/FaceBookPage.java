package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage {
    WebDriver driver;

    //1. adim parametre olarak Webdriver driver kullanabilecegim bir Constructor olusturmaliyim
    public FaceBookPage(WebDriver driver){

    // driver'i bu sayfada kontrol edebilmek icin bu sayfada da bir driver olusturmaliyim
    // olusturacagim driver'i instance olarak olusturuyorum ki class'in her yerinde kullanabileyim
    this.driver=driver;
    // 16.satirda benim test Class'indan parametre olarak gonderdigim driver'i bu sayfadaki driver'a atiyor
        PageFactory.initElements(driver,this);

    }


    @FindBy(id="email")
    public WebElement userTextBox;

    @FindBy(id="pass")
    public WebElement passwordTextBox;

    @FindBy(id="u_0_b")
    public WebElement loginButonu;



}
