package com.app.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Confirmation extends SearchHotel {

	 public static WebElement selectHotelRadioButton () {
 		return driver.findElement(By.id("radiobutton_0"));
	 }
	 public static WebElement continuebutton() {
	    return driver.findElement(By.id("continue"));	
	    }
}
