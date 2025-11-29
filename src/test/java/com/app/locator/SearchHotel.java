package com.app.locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchHotel extends LoginPage {
	
	public static WebElement Location() {
	return driver.findElement(By.xpath("//select[@name='location']"));
	}
	
	public static WebElement Hotels () {
	return driver.findElement(By.xpath("//select[@name='hotels']"));
	}
	
	//room type
	public static WebElement roomType() {
	return driver.findElement(By.xpath("//select[@name='room_type']"));
	}
	
	//Number of rooms
	public static WebElement Numberofrooms() {
	return driver.findElement(By.xpath("//select[@name='room_nos']"));
	}
	
	//click
	public static WebElement datepick() {
	return driver.findElement(By.xpath("//input[@id='datepick_in']"));
	}

	public static WebElement dateinclear() {
	return driver.findElement(By.xpath("//input[@id='datepick_in']"));
	}
	
	public static WebElement dateout() {
    return driver.findElement(By.xpath("//input[@id='datepick_out']"));
	}
	
	public static WebElement dateoutclear() {
	return driver.findElement(By.xpath("//input[@id='datepick_out']"));
	}
	
	public static WebElement datepickout() {
	return driver.findElement(By.xpath("//input[@id='datepick_out']"));
	}
	
	public static WebElement adult() {
			return driver.findElement(By.xpath("//select[@id='adult_room']"));
	}
	
	public static WebElement ChildrenperRoom() {
			return driver.findElement(By.xpath("//select[@id='child_room']"));
	}
	
	public static WebElement submitButton() {
		return	driver.findElement(By.xpath("//input[@id='Submit']"));
	}			
}
