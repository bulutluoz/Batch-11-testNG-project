package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class D19_WebTablesHomework extends TestBase {

    @Test
    public void test(){
        //Bir Class olusturun D19_WebtablesHomework
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> headerList =driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));

        for (WebElement w:headerList
        ) {
            System.out.println(w.getText());
        }
        //  3.sutunun basligini yazdirin
        WebElement header3Sutun = driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]"));
        System.out.println("3.sutun basligi : " + header3Sutun.getText());
        //  4. Tablodaki tum datalari yazdirin
        WebElement tableBody = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println("====Tum Body====");
        System.out.println(tableBody.getText());
        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("====Tum Hucreler====");
        List<WebElement> tumHucreler =driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement each:tumHucreler
        ) {
            System.out.println(each.getText());
        }
        System.out.println("tablodaki tum hucre sayisi : " + tumHucreler.size());

        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki Satir Sayisi :  " + satirlarListesi.size());
        //  7. Tablodaki sutun sayisini yazdirin

        System.out.println("Tablodaki sutun sayisi : " + headerList.size());
        //  8. Tablodaki 3.kolonu yazdirin
        for (int i=1; i<=satirlarListesi.size();i++){
            WebElement element =driver.findElement(By.xpath("((//div[@class='rt-tr-group'])[" +i+ "]//div//div)[3]"));
            System.out.println(element.getText());
        }


        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        int salaryninSutunNumarasi = 0;

        for (int i = 1; i < headerList.size(); i++) {

            if (headerList.get(i).getText().equals("Salary")) {
                salaryninSutunNumarasi = i;
            }
        }
        salaryninSutunNumarasi++;
        System.out.println("Salarynin sutun numarasi = " + salaryninSutunNumarasi);

        int kierraSatirSayisi=0;
        for (int i=1;i<satirlarListesi.size();i++){
            // ((//div[@class='rt-tr-group'])[1]//div//div)[1]  1.satirin 1.kolonu

            String elementYolu = "((//div[@class='rt-tr-group'])["+i+"]//div//div)[1]";

            WebElement element = driver.findElement(By.xpath(elementYolu));

            if (element.getText().equals("Kierra")){
                kierraSatirSayisi=i;
            }

        }

        System.out.println("Kierra satir Sayisi = " + kierraSatirSayisi);
        String arananSalaryXpath="((//div[@class='rt-tr-group'])["+kierraSatirSayisi+"]//div//div)["+salaryninSutunNumarasi+"] ";
        WebElement arananSalary=driver.findElement(By.xpath(arananSalaryXpath));
        System.out.println("Ismi kierra olan kisinin Salary'si : " + arananSalary.getText());


        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //    sayisini girdigimde bana datayi yazdirsin


    }
}
