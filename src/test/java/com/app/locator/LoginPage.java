package com.app.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.app.base.Base;

public class LoginPage extends Base {
	public static WebElement getUsername() {
		return driver.findElement(By.xpath("//input[@id='username']"));
	}
	public static WebElement getPassword() {
		return driver.findElement(By.xpath("//input[@id='password']"));
}
	public static WebElement clickButton() {
    return driver.findElement(By.xpath("//input[@id='login']"));
	}
}
