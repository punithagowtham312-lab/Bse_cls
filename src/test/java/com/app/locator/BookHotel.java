package com.app.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookHotel extends Confirmation{
	public static WebElement firstName() {
	return driver.findElement(By.xpath("//input[@id='first_name']"));
	}
	
	public static WebElement lastName() {
    return driver.findElement(By.xpath("//input[@name='last_name']"));
	}
	
	public static WebElement address() {
    return driver.findElement(By.xpath("//textarea[@name='address']"));
	}
	
	public static WebElement ccNum() {
    return driver.findElement(By.xpath("//input[@name='cc_num']"));
	}
	
	public static WebElement ccType() {
    return driver.findElement(By.xpath("//select[@id='cc_type']"));
	}
	
	public static WebElement ccExpMonth() {
	 return driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
	}
	
	public static WebElement year() {
		 return driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
	}
	public static WebElement ccvNoLast() {
		 return driver.findElement(By.xpath("//input[@id='cc_cvv']"));
	}
	public static WebElement bookNow() {
			return driver.findElement(By.xpath("//input[@id='book_now']"));
			}
}
