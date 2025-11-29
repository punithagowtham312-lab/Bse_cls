package com.app.exe;

import com.app.base.Base;
import com.app.excel.ExcelRead;
import com.app.locator.BookHotel;
import com.app.locator.LoginPage;
import com.app.pageexe.PageExe;

public class Execution   {
public static void main(String[] args) {
	
	//Git command 
	//Git 2nd command 
	//Git tester1 changes 
	//Git changes move via eclipse. 
	//
	Base base = new Base();
	base.launchBrowser("chrome");
    Base.openUrl("https://adactinhotelapp.com/");
	PageExe.username();
	PageExe.password();
	PageExe.clickLoginButton();
	PageExe.selectLocation();
	PageExe.selectHotels();
	PageExe.selectRoom();
	PageExe.selectNumberofRooms();
	PageExe.enterCheckInDate();
	PageExe.enterCheckoutDate();
	PageExe.selectAdultsroom();
	PageExe.selectChildroom();
	PageExe.clickSearch();
	PageExe.selectHotelRadioBn();
	PageExe.continuebtn();
	PageExe.firstName1();
	PageExe.lastname();
	PageExe.address1();
	PageExe.ccNum1();
	PageExe.ccType1();
	PageExe.ccExpMonth1();
	PageExe.selectYear();
	PageExe.ccvNumlast();
	PageExe.bookNowLast();
	PageExe.printOrderId();
	}
}
