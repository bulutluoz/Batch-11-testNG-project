package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // java ile dosya okuyabilmek icin FileInputStream kullaniyoruz
        // Ancak bunun icin okuyacagimiz dosyanin yoluna ihtiyacimiz var
        // okunacak dosya yolunu bulup String path degiskenine atiyoruz
        String path=".\\src\\test\\java\\resources\\ulkeler.xlsx";
        // dosyamizi javaya okutabilmek icin FileInputStream kullanip parametre olark path'i giriyoruz
        FileInputStream fileInputStream=new FileInputStream(path);

        //Excelde dataya ulasmak icin cell(hucre)'ye ulasmamiz gerekiyor
        // Bunun icin sirasiyla workbook olusturup parametre olarak fileInputStream objesini giriyoruz
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        // workbook dan sonra ilgili sayfaya gitmek icin Sheet objesi olusturuyoruz
        Sheet sheet=workbook.getSheetAt(0);
        // ilgili satira gitmak icin Row objesi olusturuyoruz
        Row row=sheet.getRow(0);
        // Hucreye gitmek icin Cell objesi olusturuyoruz
        Cell cell=row.getCell(0);
        //Ulastigimiz data Cell objesi formatindadir. yazdirmak istedigimizde yazdirabiliriz ancak maniple edemeyiz
        // data uzerinde assert veya manipulasyon yapmak istyorsak once datayi toString() methodu ile Stringe ceviririz.
        System.out.println(cell);

        String hucre=cell.toString();
        System.out.println(hucre);

    }

    @Test
    public void readExcel2() throws IOException {

        String path="./src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook=WorkbookFactory.create(fileInputStream);
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheetAt(0).getRow(0).getCell(1));
        // 		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String birinciSatirIkinciHucre=workbook.getSheetAt(0).getRow(0).getCell(1).toString();
        System.out.println(birinciSatirIkinciHucre);
        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        // kabil,Kabil,KABIL

        String ikinciSatirDorduncuHucre=workbook.getSheetAt(0).getRow(1).getCell(3).toString().toLowerCase();
        Assert.assertEquals(ikinciSatirDorduncuHucre,"kabil");

        //- Satir sayisini bulalim
        System.out.println(workbook.getSheetAt(0).getLastRowNum());

        // - Fiziki olarak kullanilan satir sayisini bulun(index degil sayma sayilari kullanilir)
        System.out.println("son satir numarasi " + workbook.getSheetAt(1).getLastRowNum());
        System.out.println("fiziki kullanilan satir sayisi : "+workbook.getSheetAt(1).getPhysicalNumberOfRows());
        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        // her bir ulke icin /her satir icin
        // 0.index ulke adi ve 1.index baskent adi

        String ulkeAdi="";
        String  baskent="";
        Map<String,String> baskentler=new HashMap<>();

        for (int i=1; i<=workbook.getSheetAt(0).getLastRowNum();i++){
            ulkeAdi=workbook.getSheetAt(0).getRow(i).getCell(0).toString();
            baskent=workbook.getSheetAt(0).getRow(i).getCell(1).toString();
            baskentler.put(ulkeAdi,baskent);
        }

        System.out.println(baskentler);
        // 1=Afghanistan,Kabul,Afganistan,Kabil
    }



}
