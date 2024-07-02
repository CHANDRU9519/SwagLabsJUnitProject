package org.global;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

// Driver and Window Maximize
	public void getDriver(String browserType) {

		switch (browserType) {

		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("InValid Type");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

// Getting URL
	public void getUrl(String url) {
		driver.get(url);
	}

//Navigate to new URL
	public void navigateUrl(String url) {
		driver.navigate().to(url);
	}

//Navigate - Forward 
	public void forwardUrl() {
		driver.navigate().forward();
	}

//Navigate - Backward 
	public void backwardUrl() {
		driver.navigate().forward();
	}

//Refresh the Page
	public void refreshPage() {
		driver.navigate().refresh();
	}

// For Clicking the WebElement
	public void pressClick(WebElement element) {
		element.click();
	}

// Clear the Value entered in the Element
	public void clean(WebElement element) {
		element.clear();
	}

// To Maximize the Window
	public void windowsMax() {
		driver.manage().window().maximize();
	}

//To set dimension of the Window
	public void windowSize(int length, int breadth) {
		Dimension d = new Dimension(length, breadth);
		driver.manage().window().setSize(d);
	}

//To set position of the Window
	public void windowPosition(int x, int y) {
		Point p = new Point(x, y);
		driver.manage().window().setPosition(p);
	}

// To Send Text
	public void textSend(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

//To TakeScreenshot and Copy File from one place to another place
	public void screenCapture(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("D:\\Program Screenshot\\" + name + ".png");
		FileUtils.copyFile(source, target);
	}

// To Switch to New Frame using WebElement Reference
	public void frameBasedElement(WebElement element) {
		driver.switchTo().frame(element);
	}

//To switch to New Frame using Frame Name
	public void frameBasedName(String name) {
		driver.switchTo().frame(name);
	}

//To switch to New Frame using Index
	public void frameBasedName(int index) {
		driver.switchTo().frame(index);
	}

//To switch to Default Frame
	public void defaultFrame() {
		driver.switchTo().defaultContent();
	}

//To switch to Parent Frame of the Current Frame
	public void parentFrame() {
		driver.switchTo().parentFrame();
	}

// Select By Value
	public void selectValue(WebElement element, String i) {
		Select s = new Select(element);
		s.selectByValue(i);
	}

// Select By Index
	public void selectIndex(WebElement element, int value) {
		Select s = new Select(element);
		s.selectByIndex(value);
	}

// Select By VisibleText
	public void selectVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

//To get the Options
	public void optionsGet(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement optionsText : options) {
			String text = optionsText.getText();
			System.out.println(text);
		}
	}

//To know whether the options is Multiple or Not
	public void multipleOrNot(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

//To get First selected options
	public void firstSelected(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelect = s.getFirstSelectedOption();
		System.out.println(firstSelect);
	}

//To get All selected options
	public void allSelected(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectOptions = s.getAllSelectedOptions();
		for (int i = 0; i < allSelectOptions.size(); i++) {
			WebElement options = allSelectOptions.get(i);
			String optionValue = options.getText();
			System.out.println(optionValue);
		}
	}

// To Switch Windows (Windows Priority based on the time it opens)
	public void switchWindows(int index) {
		Set<String> allWindowsID = driver.getWindowHandles();
		List<String> list = new LinkedList<String>();
		list.addAll(allWindowsID);
		// To get Particular values
		String childWindowsID = list.get(index);
		// To Switch To Windows
		driver.switchTo().window(childWindowsID);
	}

// To get Window ID
	public String getWindowsID(int index) {
		Set<String> allWindowsID = driver.getWindowHandles();
		List<String> list = new LinkedList<String>();
		list.addAll(allWindowsID);
		// To get Particular values
		String childWindowsID = list.get(index);
		return childWindowsID;
	}

// To Switch To Particular Windows
	public void switchtoWindows(String childWindowsID) {
		driver.switchTo().window(childWindowsID);
	}

// To Send Text Using JavaScript
	public void textSendByJs(WebElement element, String keysToSend) {
		js.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);
	}

//To Get the Text of the SendKeys Using JavaSript
	public void getKeysByJs(WebElement element) {
		Object textInSendKeys = js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(textInSendKeys);
	}

// To Scroll UP or DOWN
	public void scroll(WebElement element, String Up_Down) {
		switch (Up_Down) {
		case "Up":
			js.executeScript("arguments[0].scrollIntoView(false)", element);
			break;

		case "Down":
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			break;

		default:
			System.err.println("InValid Type");
			break;
		}
	}

//To Scroll Top or End of WebPage
	public void scrollToporEnd(String Top_End) {
		switch (Top_End) {
		case "Top":
			js.executeScript("window.scroll(0,0))");
			break;
		case "Down":
			js.executeScript("window.scrollTo(0,document.body.scrollHeight))");
			break;
		default:
			break;
		}
	}

// To get value from Excel
	public String readExcell(int rownum, int cellnum) throws IOException {

		// To Locate File (Excel)
		File file = new File("D:\\Documents\\Adactin Task.xlsx");

		// To get File as a Input Data
		FileInputStream stream = new FileInputStream(file); // throws FileNotFoundException

		// To Define WorkBook
		Workbook book = new XSSFWorkbook(stream); // throws IOException

		// To Get Sheet from Workbook
		Sheet sheet = book.getSheet("Sheet1");

		// To get Row from Sheet
		Row row = sheet.getRow(rownum);

		// To Get Cell from Row
		Cell cell = row.getCell(cellnum);

		// To Find Cell TYpe
		CellType cellType = cell.getCellType();

		String value = null;

		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
				value = simple.format(dateCellValue);

			} else {

				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf((long) numericCellValue);
				value = valueOf.toString();
			}
			break;

		default:
			break;
		}
		book.close();
		return value;
	}

//For Holding the execution
	public void hold(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}

//To implicit Wait 
	public void iWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

//To getAttribute
	public String elementAttribute(WebElement element, String name) {
		return element.getAttribute(name);
	}

//To  getText
	public String elementText(WebElement element) {
		return element.getText();
	}

// Alert - OK or CANCEL
	public void alert(String OK_CANCEL) {
		Alert a = driver.switchTo().alert();
		switch (OK_CANCEL) {
		case "OK":
			a.accept();
			break;

		case "CANCEL":
			a.dismiss();
			break;
		default:
			break;
		}
	}

//Action - MouseOver
	public void mouseOverAction(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target);
	}

//Action - Click
	public void clickAction(WebElement target) {
		Actions a = new Actions(driver);
		a.click().perform();
	}

//Action - DoubleClick
	public void doubleClickAction(WebElement target) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}

//Action - RightClick
	public void rightClickAction(WebElement target) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}

//Action - Drag and Drop	
	public void doubleClickAction(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	
	public void close() {
		driver.close();
	}

}
