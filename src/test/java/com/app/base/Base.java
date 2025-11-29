package com.app.base;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.excel.ExcelRead;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver = null;
	public static  JavascriptExecutor js;
	public static Actions actions;

	// **** 1. Launch Browser ****
	public WebDriver launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else {
			throw new IllegalArgumentException("Invalid browser: " + browserName);
		}
	//	driver.manage().timeouts().implicitlyWait(0, null);
		return driver;
	}

	// **** 2. Open URL ****
	public static void openUrl(String url) {
		driver.get(url);
	}

	// **** 3. Get Page Title ****
	public String getPageTitle() {
		return driver.getTitle();
	}

	// **** 4. Find Element ****
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	// **** 5. Find Elements ****
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	// **** 6. Click ****
	public void click(By locator) {
		getElement(locator).click();
	}

	// **** 7. Send Keys ****
	public void type(WebElement locator, String text) {
		
		locator.clear();
		locator.sendKeys(text);
	}

	// **** 8. Get Text ****
	public String getText(By locator) {
		return getElement(locator).getText();
	}

//	// **** 9. Wait for Element ****
//	public WebElement waitForElement(By locator, int timeout) {
//		//WebDriverWait wait = new WebDriverWait(driver, 0);
//		//return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	}

	// **** 10. Select Dropdown by VisibleText ****
	public void selectByVisibleText(By locator, String text) {
		Select dropdown = new Select(getElement(locator));
		dropdown.selectByVisibleText(text);
	}

	// **** 11. Mouse Hover ****
	public void mouseHover(By locator) {
		Actions actions = new Actions(driver);
		actions.moveToElement(getElement(locator)).perform();
	}

	// **** 12. Drag and Drop ****
	public void dragAndDrop(By source, By target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(getElement(source), getElement(target)).perform();
	}

	// **** 13. Switch to Frame ****
	public void switchToFrame(By locator) {
		driver.switchTo().frame(getElement(locator));
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// **** 14. Handle Alert ****
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	// **** 15. Take Screenshot ****
	public void takeScreenshot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/" + fileName + ".png");
		FileUtils.copyFile(source, destination);
	}

	// **** 16. Scroll ****
	public void scrollToElement(By locator) {
		WebElement element = getElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollBy1(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	// **** 17. Close Browser ****
	public void closeBrowser() {
		driver.quit();
	}

	

	// 1. Click element
	public void clickElement1(WebElement element) {
		element.click();
	}

	// 2. Enter text (with clear)
	public void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	// 3. Get text
	public String getText(WebElement element) {
		return element.getText();
	}

	// 4. Get attribute value
	public String getAttribute(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	// 5. Check if displayed
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// 6. Check if enabled
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	// 7. Check if selected (for checkbox/radio)
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	// 8. Select dropdown by visible text
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 9. Select dropdown by index
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// 10. Select dropdown by value
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 11. Get selected dropdown option
	public String getSelectedDropdownOption(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	// 1. Click using JS
	public void clickElementByJS(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	// 2. Send keys using JS
	public void sendKeysByJS(WebElement element, String value) {
		js.executeScript("arguments[0].value='" + value + "';", element);
	}

	// 3. Scroll to an element
	public void scrollToElement1(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// 4. Scroll to bottom of page
	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// 5. Scroll by pixels
	public void scrollBy(int x, int y) {
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	// 6. Highlight element (useful for debugging)
	public void highlightElement(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	// 7. Get page title using JS
	public String getTitleByJS() {
		return js.executeScript("return document.title;").toString();
	}

	// 8. Refresh page using JS
	public void refreshPage() {
		js.executeScript("history.go(0);");
	}

	// 9. Get inner text of the page
	public String getPageInnerText() {
		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	// 10. Zoom page
	public void zoomPage(String zoomPercentage) {
		js.executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
	}

//	// 1. Implicit Wait
//	public void setImplicitWait(long timeInSeconds) {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
//	}
//
//	// 2. Wait for element to be visible
//	public WebElement waitForElementVisible(By locator, int timeout) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	}
//
//	// 3. Wait for element to be clickable
//	public WebElement waitForElementClickable(By locator, int timeout) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		return wait.until(ExpectedConditions.elementToBeClickable(locator));
//	}
//
//	// 4. Wait for presence of element
//	public WebElement waitForPresence(By locator, int timeout) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//	}
//
//	// 5. Wait for URL to contain text
//	public boolean waitForURLContains(String partialUrl, int timeout) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		return wait.until(ExpectedConditions.urlContains(partialUrl));
//	}

//	// 6. Wait for title to contain text
//	public boolean waitForTitleContains(String title, int timeout) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		return wait.until(ExpectedConditions.titleContains(title));
//	}
//
//	// 7. Wait for alert to be present
//	public Alert waitForAlert(int timeout) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		return wait.until(ExpectedConditions.alertIsPresent());
//	}

	/*
	 * // 8. Fluent Wait for WebElement public WebElement fluentWait(final By
	 * locator, int timeout, int pollingTime) { FluentWait<WebDriver> wait = new
	 * FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
	 * .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(
	 * NoSuchElementException.class);
	 * 
	 * return wait.until(new Function<WebDriver, WebElement>() { public WebElement
	 * apply(WebDriver driver) { return driver.findElement(locator); } }); }
	 */

	// 1. Mouse Hover
	public void mouseHover(WebElement element) {
		actions.moveToElement(element).perform();
	}

	// 2. Click on Element
	public void clickElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	// 3. Right Click (Context Click)
	public void rightClick1(WebElement element) {
		actions.contextClick(element).perform();
	}

	// 4. Double Click
	public void doubleClick1(WebElement element) {
		actions.doubleClick(element).perform();
	}

	// 5. Drag and Drop (by target element)
	public void dragAndDrop1(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}

	// 6. Drag and Drop by offset
	public void dragAndDropByOffset(WebElement element, int xOffset, int yOffset) {
		actions.dragAndDropBy(element, xOffset, yOffset).perform();
	}

	// 7. Click and Hold + Release (Manual drag)
	public void clickAndHoldRelease(WebElement source, WebElement target) {
		actions.clickAndHold(source).moveToElement(target).release().perform();
	}

	// 8. Send Keys to Element
	public void sendKeys(WebElement element, String text) {
		actions.moveToElement(element).click().sendKeys(text).perform();
	}

	// 9. Keyboard Events (like Ctrl + A)
	public void keyPress(WebElement element, Keys key) {
		actions.moveToElement(element).sendKeys(key).perform();
	}

	// 10. Scroll to Element (Actions-based)
	public void scrollToElement(WebElement element) {
		actions.moveToElement(element).perform();
	}

	// 1. Get Single CSS Value
	public String getCssValue(WebElement element, String propertyName) {
		return element.getCssValue(propertyName);
	}

	// 2. Compare CSS Value with Expected
	public boolean isCssValueEqual(WebElement element, String propertyName, String expectedValue) {
		return element.getCssValue(propertyName).equalsIgnoreCase(expectedValue);
	}

	// 3. Get Background Color
	public String getBackgroundColor(WebElement element) {
		return element.getCssValue("background-color");
	}

	// 4. Get Font Size
	public String getFontSize(WebElement element) {
		return element.getCssValue("font-size");
	}

	// 5. Get Font Family
	public String getFontFamily(WebElement element) {
		return element.getCssValue("font-family");
	}

	// 6. Get Color
	public String getColor(WebElement element) {
		return element.getCssValue("color");
	}

	// 7. Validate Font Weight (bold check)
	public boolean isBold(WebElement element) {
		String fontWeight = element.getCssValue("font-weight");
		return fontWeight.equals("bold") || Integer.parseInt(fontWeight) >= 700;
	}

	// 1. Full Page Screenshot
	public String takeFullPageScreenshot(String fileName) throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = "./screenshots/" + fileName + "_" + timestamp + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination; // return path if needed
	}

	// 2. Element Screenshot (only specific element)
	public String takeElementScreenshot(WebElement element, String fileName) throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File source = element.getScreenshotAs(OutputType.FILE);
		String destination = "./screenshots/" + fileName + "_" + timestamp + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

	// 1. Get Current Date (default format: yyyy-MM-dd)
	public static String getCurrentDate() {
		return LocalDate.now().toString();
	}

	// 2. Get Current Date in Custom Format
	public static String getCurrentDate(String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.now().format(formatter);
	}

	// 3. Get Current Date and Time
	public static String getCurrentDateTime(String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDateTime.now().format(formatter);
	}

	// 4. Add days to current date
	public static String addDaysToCurrentDate(int days, String pattern) {
		LocalDate date = LocalDate.now().plusDays(days);
		return date.format(DateTimeFormatter.ofPattern(pattern));
	}

	// 5. Subtract days from current date
	public static String subtractDaysFromCurrentDate(int days, String pattern) {
		LocalDate date = LocalDate.now().minusDays(days);
		return date.format(DateTimeFormatter.ofPattern(pattern));
	}

	// 6. Convert Date String to Another Format
	public static String convertDateFormat(String dateStr, String fromFormat, String toFormat) throws ParseException {
		SimpleDateFormat sdfSource = new SimpleDateFormat(fromFormat);
		Date date = sdfSource.parse(dateStr);
		SimpleDateFormat sdfTarget = new SimpleDateFormat(toFormat);
		return sdfTarget.format(date);
	}

	// 7. Get future/past date using Calendar (legacy support)
	public static String getFutureDate(int days, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		return sdf.format(cal.getTime());
	}

	// 8. Validate date format
	public static boolean isValidDate(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
		try {
			sdf.parse(dateStr);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	// 1. Get Browser Window Size
	public Dimension getBrowserSize() {
		return driver.manage().window().getSize();
	}

	// 2. Set Browser Window Size
	public void setBrowserSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);
	}

	// 3. Get WebElement Size
	public Dimension getElementSize(WebElement element) {
		return element.getSize();
	}

	// 4. Get Element Width
	public int getElementWidth(WebElement element) {
		return element.getSize().getWidth();
	}

	// 5. Get Element Height
	public int getElementHeight(WebElement element) {
		return element.getSize().getHeight();
	}

	// 6. Compare Two Element Sizes
	public boolean isElementSizeEqual(WebElement element1, WebElement element2) {
		return element1.getSize().equals(element2.getSize());
	}

	// 7. Validate Browser Size (Example: Responsive UI Testing)
	public boolean isBrowserSize(int expectedWidth, int expectedHeight) {
		Dimension size = driver.manage().window().getSize();
		return size.getWidth() == expectedWidth && size.getHeight() == expectedHeight;
	}

	// 1. Move Pointer to Element (Hover)
	public void moveToElement(WebElement element) {
		actions.moveToElement(element).perform();
	}

	// 2. Move Pointer by Offset
	public void moveByOffset(int xOffset, int yOffset) {
		actions.moveByOffset(xOffset, yOffset).perform();
	}

	// 3. Click and Hold (like dragging start)
	public void clickAndHold(WebElement element) {
		actions.clickAndHold(element).perform();
	}

	// 4. Release Pointer
	public void release() {
		actions.release().perform();
	}

	// 5. Drag and Drop using Pointer
	public void dragAndDrop(WebElement source, WebElement target) {
		actions.clickAndHold(source).moveToElement(target).release().perform();
	}

	// 6. Right Click (Context Menu)
	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}

	// 7. Double Click
	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}

	// 1. Basic ChromeOptions (Default)
	public static ChromeOptions getDefaultOptions() {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--start-maximized");
		//options.addArguments("--disable-notifications");
		return options;
	}

	// 2. Headless Mode
	public static ChromeOptions getHeadlessOptions() {
		ChromeOptions options = getDefaultOptions();
		//options.addArguments("--headless=new"); // new headless mode
		//options.addArguments("--disable-gpu");
		return options;
	}

	// 3. Incognito Mode
	//public static ChromeOptions getIncognitoOptions() {
		ChromeOptions options = getDefaultOptions();
		//options.addArguments("--incognito");
		//return options;
	//}

	// 4. Disable Images (for performance testing)
	public static ChromeOptions getDisableImagesOptions() {
		ChromeOptions options = getDefaultOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.managed_default_content_settings.images", 2);
		//options.setExperimentalOption("prefs", prefs);
		return options;
	}

	// 5. Custom Download Directory
	public static ChromeOptions getCustomDownloadDirOptions(String downloadPath) {
		ChromeOptions options = getDefaultOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadPath);
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.directory_upgrade", true);
		prefs.put("safebrowsing.enabled", true);
		//options.setExperimentalOption("prefs", prefs);
		return options;
	}

	// 6. Remote Debugging Port
	public static ChromeOptions getRemoteDebuggingOptions(int port) {
		ChromeOptions options = getDefaultOptions();
		//options.addArguments("--remote-debugging-port=" + port);
		return options;
	}

	public void type(WebElement element, String sheetName, int row, int col) {
	    String value = ExcelRead.readExcel(row, col);  // read value from Excel
	    element.sendKeys(value);                      // type Excel value
	}
	
	private static WebElement radioButton;

	public static WebElement getRadioButton() {
	    return radioButton;
	}
	public WebElement waitForElement(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}

