package com.app.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelRead {
	public static String readExcel(int i, int j) {
        
        String value = null;
		try {
			File f = new File("C:\\Users\\punit\\eclipse-workspace\\maven\\Bse_cls\\src\\test\\resources\\TestData\\HotelBooking.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(j);
			// System.out.println(cell);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
				//System.out.println(value);
			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					// System.out.println(dateCellValue);
					SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
					value = sm.format(dateCellValue);
					//System.out.println(value);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value = String.valueOf(l);
					System.out.println(value);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
    }
	
/*	public static void readProp() {
		try {
			FileReader Read = new FileReader("C:\\Users\\punit\\eclipse-workspace\\maven\\Bse_cls\\src\\test\\resources\\TestData\\config.properties");
			Properties prop = new Properties();
			try {
				prop.load(Read);
				String url = prop.getProperty("url");
				String username = prop.getProperty("username");
				String password = prop.getProperty("password");
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get(url);
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
				WebElement loginbtn = driver.findElement(By.xpath("//input[@id='login']"));
				loginbtn.click();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}} */
}
