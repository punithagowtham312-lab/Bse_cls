package com.app.pageexe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.app.base.Base;
import com.app.excel.ExcelRead;
import com.app.locator.BookHotel;
import com.app.locator.Confirmation;
import com.app.locator.LoginPage;
import com.app.locator.SearchHotel;

public class PageExe extends BookHotel {
	
	public static void username() {
		new Base().type(LoginPage.getUsername(),"Sheet1",0,0);
	}

	public static void password() {
		new Base().type(LoginPage.getPassword(),"Sheet1", 1, 0);
	}
	
	public static void clickLoginButton() {
	    new Base().clickElement(LoginPage.clickButton());
	}
	
	public static void selectLocation() {
	    new Base().selectByVisibleText(SearchHotel.Location(),"Adelaide");
	}
	
	public static void selectHotels() {
	    new Base().selectByVisibleText(SearchHotel.Hotels(),"Hotel Sunshine");
	}
	
	public static void selectRoom() {
	    new Base().selectByIndex(SearchHotel.roomType(),2);
	}
	public static void selectNumberofRooms() {
	    new Base().selectByIndex(SearchHotel.Numberofrooms(),3);
	}
	
	public static void enterCheckInDate() {
		WebElement ele = SearchHotel.datepick();
	    ele.clear();                       
	    new Base().enterText(ele, "20/11/2025");
	}
	
	public static void enterCheckoutDate() {
		WebElement ele = SearchHotel.dateout();
	    ele.clear();                       
	    new Base().enterText(ele, "22/11/2025");
	}
	
	public static void selectAdultsroom() {
	    new Base().selectByIndex(SearchHotel.adult(),3);
	}
	
	public static void selectChildroom() {
	    new Base().selectByVisibleText(SearchHotel.ChildrenperRoom(),"2 - Two");
	}
	
	public static void clickSearch() {
	    new Base().clickElement(SearchHotel.submitButton());
	}
	
	public static void selectHotelRadioBn() {
		 new Base().clickElement(Confirmation.selectHotelRadioButton());
	}
	
	public static void continuebtn() {
	  new Base().clickElement(Confirmation.continuebutton());
    }
	
	public static void firstName1() {
		new Base().type(BookHotel.firstName(),"Sheet1",2,0);
    }
	
	public static void lastname() {
		new Base().type(BookHotel.lastName(),"Sheet1",3,0);
	}
	
	public static void address1() {
		new Base().type(BookHotel.address(), "Sheet1",4,0);
	}
	
	public static void ccNum1() {
		new Base().type(BookHotel.ccNum(),"Sheet1",5,0);
	}
	
	public static void ccType1() {
	    new Base().selectByVisibleText(BookHotel.ccType(),"VISA");
	}
	
	public static void ccExpMonth1() {
	    new Base().selectByVisibleText(BookHotel.ccExpMonth(),"January");
	}
	
	public static void selectYear() {
	    new Base().selectByVisibleText(BookHotel.year(),"2030");
	}
	
	public static void ccvNumlast() {
		new Base().type(BookHotel.ccvNoLast(),"Sheet1",6,0);
	}
	
	public static void bookNowLast() {
	    new Base().clickElement(BookHotel.bookNow());
	}
	
	public static void printOrderId() {
	    Base base = new Base();
	    WebElement orderId = base.waitForElement(By.xpath("//input[@id='order_no']"));
	    System.out.println("Order ID: " + orderId.getAttribute("value"));
	}
}
