package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D18_CreateHotelRoom extends TestBase {

    @Test
    public void roomCreationTest() throws InterruptedException {
        // 1. Tests packagenin altına class olusturun: HotelRoomCreation
        // 2. Bir metod olusturun: RoomCreateTest()
        // 3. http://qa-environment.crystalkeyhotels.com adresine gidin.
        driver.get("http://qa-environment.crystalkeyhotels.com");
        // 4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //				a. Username : manager 				b. Password  : Manager2!

        driver.findElement(By.linkText("Log in")).click();
        WebElement usernameTextBox=driver.findElement(By.id("UserName"));
        usernameTextBox.sendKeys("manager");

        WebElement passwordtextBox=driver.findElement(By.id("Password"));
        passwordtextBox.sendKeys("Manager2!");
        // 5. Login butonuna tıklayın.

        driver.findElement(By.id("btnSubmit")).click();
        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Hotel Management']")).click();
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();
        driver.findElement(By.xpath("//*[text()='Add Hotelroom ']")).click();



        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        WebElement idDropDown=driver.findElement(By.id("IDHotel"));
        Select select=new Select(idDropDown);
        select.selectByValue("1016");

        WebElement codeWebElementi=driver.findElement(By.id("Code"));
        Actions actions=new Actions(driver);

        actions.click(codeWebElementi)
                .sendKeys("06100")
                .sendKeys(Keys.TAB)
                .sendKeys("Double with Child Room")
                .sendKeys(Keys.TAB)
                .sendKeys("London")
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("cok guzel oda");

        WebElement besYuzButonu=driver.findElement(By.linkText("500"));
        Thread.sleep(5000);
        WebElement priceTextBox=driver.findElement(By.id("Price"));

        actions.dragAndDrop(besYuzButonu,priceTextBox).perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement roomTypeDropDown=driver.findElement(By.id("IDGroupRoomType"));
        Select select1=new Select(roomTypeDropDown);
        select1.selectByIndex(2);

        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        driver.findElement(By.id("MaxChildCount")).sendKeys("2");

        // 8. Save butonuna basin.
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(10000);
        // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//*[text()='HotelRoom was inserted successfully']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());
        //10. OK butonuna tıklayın.

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        //11. Hotel rooms linkine tıklayın.
        actions.sendKeys(Keys.HOME).perform();
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();
        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..

        WebElement hotelRoomListYaziElementi=driver.findElement(By.xpath("(//*[text()='List Of Hotelrooms'])[2]"));
        Assert.assertTrue(hotelRoomListYaziElementi.isDisplayed());


    }
}
