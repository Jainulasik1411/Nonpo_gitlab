package org.baseclass;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
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
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	
	public static WebDriver driver;

	
	public void browserLaunch(String browser) {


		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");  // Ensure Chrome starts maximized
			driver = new ChromeDriver(options);


		} 

		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();  // Maximize window for Edge
		}



		else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
	}
	
	public void Date(int index) {
	    try {
	        String xpath = "(//*[@role='button'])[" + index + "]"; // dynamic XPath
	        driver.findElement(By.xpath(xpath)).click();
	    } catch (Exception e) {
	        System.out.println("Unable to click button at index: " + index);
	        e.printStackTrace();
	    }
	}
	
	
	// Reusable method to click the OK button
	public void clickOkButton() {
	    try {
	        driver.findElement(By.xpath("//*[text()='OK']")).click();
	    } catch (Exception e) {
	        System.out.println("Unable to click OK button");
	        e.printStackTrace();
	    }
	}
	public static void TabIndex(WebDriver driver, int index) {
	    WebElement element = driver.findElement(By.xpath("(//*[@tabindex='0'])[" + index + "]"));
	    jsclick(driver, element);
	}
	
	public static void clickRoleButtonByIndex(WebDriver driver, int index) {
		 WebElement element =  driver.findElement(By.xpath("(//*[@role='button'])[" + index + "]"));
	    jsclick(driver, element);
	}
	
	public void clickCheckboxByIndex(int index) {
	    try {
	        WebElement checkbox = driver.findElement(By.xpath("(//*[@role='checkbox'])[" + index + "]"));
	        checkbox.click();
	    } catch (Exception e) {
	        System.out.println("Failed to click checkbox at index " + index + ": " + e.getMessage());
	    }
	}
	
	public static void DateclickOk(int index) {
	    WebElement element = driver.findElement(By.xpath("(//*[@role='button'])[" + index + "]"));
	    element.click();
	    driver.findElement(By.xpath("//*[text()='OK']")).click();

	}
	
	
	// Usage
	public static void inputareasindex(WebDriver driver, int index, String text) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    By locator = By.xpath("(//*[@autocomplete='off'])[" + index + "]");

	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

	    jsclick(driver, element);
	    	    element.sendKeys(text); // First-time input — no need to clear
	}

	public static void radiobutton(WebDriver driver, int index) {
	    WebElement radioBtn = driver.findElement(By.xpath("(//*[@role='radio'])[" + index + "]"));
	    radioBtn.click();
	}
	
	public static void switchEnable(int index) {
	    WebElement swtic = driver.findElement(By.xpath("(//*[@role='switch'])[" + index + "]"));
	    jsclick(driver, swtic);
	}
	
	public void Eyeicon2() {
	    WebElement actionButton = driver.findElement(By.xpath("(//span[text()='Actions']/following::flt-semantics[@role='button'])[1]"));
	    actionButton.click();
	}
	
	public void Eyeicon3() {
	    WebElement actionButton = driver.findElement(By.xpath("(//span[text()='Actions']/following::flt-semantics[@role='button'])[2]"));
	    actionButton.click();
	}
	
	//(//span[text()='Actions']/following::flt-semantics[@role='button'])[2]

	
	public void performLogout2(JavascriptExecutor js) {
	    // Click the main menu button
	    WebElement element3 = driver.findElement(By.xpath("(//*[@role='button'])[1]/following::*[5]"));
	    js.executeScript("arguments[0].click();", element3);

	    waitWithTimeout(driver, 10); // custom wait (should ideally wait for visibility of group)

	    // Click the logout option group
	    WebElement logbt = driver.findElement(By.xpath("//*[@role='group']"));
	    js.executeScript("arguments[0].click();", logbt);

	    // pause method — assume it's Thread.sleep

	    // Click the final 'Logout' confirmation
	    driver.findElement(By.xpath("//*[text()='Logout']")).click();
	}

	public void clearAndTypeText(WebDriver driver, String xpath, String newText) {
	    WebElement element = driver.findElement(By.xpath(xpath));

jsclick(driver, element);
	    element.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
	    element.sendKeys(newText); // Type new text
	}
	
	public static void downloadicon(int index) {
	    WebElement element = driver.findElement(By.xpath("(//*[@role='button'])[" + index + "]"));
	    element.click();
	}

	
	public static void NextButton() {
	    driver.findElement(By.xpath("(//*[text()='Next'])[1]")).click();
	}

	public static void SubmitButton() {
	    driver.findElement(By.xpath("(//*[text()='Submit'])[1]")).click();
	}
	
	public static void MarkForCorrectionButton() {
	    driver.findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Mark for Correction')])[1]")).click();
	}
	
	public static WebElement getAutocompleteOffElementByIndex(WebDriver driver, int index) {
	    return driver.findElement(By.xpath("(//*[@autocomplete='off'])[" + index + "]"));
	}

	public static void Update() {
	    driver.findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Update')])[1]")).click();
	}
	

	public static void Escalate() {
	    driver.findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Escalate')])[1]")).click();
	}
	
	public static void Needinfo() {
	    driver.findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Need Information')])[1]")).click();
	}
	
	public static void Reassign() {
	    driver.findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Reassign')])[1]")).click();
	}
	
	public static void Texthome(String text) {
	    driver.findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'" + text + "')])[1]")).click();
	}

	public static void clicking(String xpath) {
	    driver.findElement(By.xpath(xpath)).click();
	}
	public static void clickAutoCompleteByIndex(int index) {
	    try {
	        List<WebElement> elements = driver.findElements(By.xpath("//*[@autocomplete='off']"));

	        if (index <= 0 || index > elements.size()) {
	            System.out.println("Invalid index: " + index);
	            return;
	        }

	        WebElement el = elements.get(index - 1); // adjust index

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);

	        try {
	            el.click();
	        } catch (ElementClickInterceptedException e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
	        }

	    } catch (Exception e) {
	        System.out.println("Click failed: " + e.getMessage());
	    }
	}
	
	public static void clearAndTypeAutoCompleteByIndex(int index, String newText) throws InterruptedException {
	    String xpath = "(//*[@autocomplete='off'])[" + index + "]";
	    WebElement qq = driver.findElement(By.xpath(xpath));
	   jsclick(driver, qq);
	    threadhalf();
	    qq.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all existing text
	    qq.sendKeys(newText); // Enter new text
	}
	
	public static void History() {
	    WebElement element = driver.findElement(By.xpath("(//*[text()='History'])[1]"));
	    jsclick(driver, element);
	}
	
	public static void threedot() {
	    WebElement element = driver.findElement(By.xpath("(//*[@tabindex='0'])[16]"));
	    jsclick(driver, element);
	}
	
	public static void threedotkbzpycenter() {
	    WebElement element = driver.findElement(By.xpath("(//*[@tabindex='0'])[15]"));
	    jsclick(driver, element);
	}
	
	public static void threedotycverfi() {
	    WebElement element = driver.findElement(By.xpath("(//*[@tabindex='0'])[13]"));
	    jsclick(driver, element);
	}
	
	
	public static void threedot3() {
	    WebElement element = driver.findElement(By.xpath("(//*[@tabindex='0'])[18]"));
	    jsclick(driver, element);
	}
	
	public static void threedot4() {
	    WebElement element = driver.findElement(By.xpath("(//*[@tabindex='0'])[19]"));
	    jsclick(driver, element);
	}
	
	public static void threedot2() {
	    WebElement element = driver.findElement(By.xpath("(//*[@tabindex='0'])[14]"));
	    jsclick(driver, element);
	}
	
	public static void textpath(String text) {
	    WebElement element = driver.findElement(By.xpath("(//*[text()='" + text + "'])[1]"));

jsclick(driver, element);
	}

	
	public static void Details() {
	    WebElement elementt = driver.findElement(By.xpath("(//*[text()='Details'])[1]"));
	    jsclick(driver, elementt);
	}
	public static void Dwloadbtn() {
	    WebElement elementt = driver.findElement(By.xpath("(//*[text()='Download'])[1]"));
	    jsclick(driver, elementt);
	}
	


	public static void EditButton() {
	    driver.findElement(By.xpath("(//*[text()='Edit'])[1]")).click();
	}

	public static void replace(WebElement element, String text) {
		    jsclick(driver, element); // Ensure focus
		    element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); // Clear existing
		    element.sendKeys(text); // Enter new value
		}

	public static void typing(String text) {
	    WebElement input = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
	    input.sendKeys(text);
	}

	
	
	
	public void PleaseSelect(WebDriver driver) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Please select'])[1]")));
	        element.click();
	    } catch (Exception e) {
	        System.out.println("Unable to click 'Please select': " + e.getMessage());
	    }
	}

	public static void uploadFilepng() throws AWTException {
	    String filePath = "C:\\Users\\jainu\\Downloads\\Test2.png";  // ✅ Mandatory path set here

	    if (filePath == null || filePath.trim().isEmpty()) {
	        System.err.println("File path is mandatory for upload.");
	        return;
	    }

	    // Copy file path to clipboard
	    StringSelection file = new StringSelection(filePath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

	    // Paste and hit Enter using Robot
	    java.awt.Robot r = new java.awt.Robot();
	    r.setAutoDelay(1000);

	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_CONTROL);

	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public static void uploadfilePdf() throws AWTException {
	    String filePath = "C:\\Users\\jainu\\Downloads\\Testpdf123.pdf";  // ✅ Fixed PDF file path

	    if (filePath == null || filePath.trim().isEmpty()) {
	        System.err.println("File path is mandatory for upload.");
	        return;
	    }

	    // Copy PDF file path to clipboard
	    StringSelection file = new StringSelection(filePath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

	    // Use Robot to paste and press Enter
	    java.awt.Robot r = new java.awt.Robot();
	    r.setAutoDelay(1000);

	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_CONTROL);

	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}


	
	public void selectdate(WebDriver driver, int dateButtonIndex) {
	    try {
	        // Wait until date field is clickable
	        waitWithTimeout(driver, 10);

	        // Click the date input field
	        WebElement dateInput = driver.findElement(By.xpath("//*[@aria-label='YYYY-MM-DD']"));
	        dateInput.click();

	        // Wait and click a date using JavaScriptExecutor
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement date = driver.findElement(By.xpath("(//*[@role='button'])[" + dateButtonIndex + "]"));
	        js.executeScript("arguments[0].click();", date);

	        waitWithTimeout(driver, 10);

	        // Click the OK button to confirm
	        WebElement okButton = driver.findElement(By.xpath("//*[text()='OK']"));
	        okButton.click();

	    } catch (Exception e) {
	        System.out.println("Date selection failed: " + e.getMessage());
	    }
	}

	public void backbutton() {
	    try {
	        WebElement button = driver.findElement(By.xpath("(//*[@role='button'])[4]"));
	        button.click();
	    } catch (Exception e) {
	        System.out.println("Unable to click the 4th role='button' element.");
	        e.printStackTrace();
	    }
	}
	
	public void zoomOut(int times) throws Exception {
	    java.awt.Robot robot = new java.awt.Robot();
	    for (int i = 0; i < times; i++) {
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_MINUS);
	        robot.keyRelease(KeyEvent.VK_MINUS);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        Thread.sleep(500); // Optional delay
	    }
	}

	
	public void EyeButton() {
	    try {
	        By eyeButton = By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]");
	        driver.findElement(eyeButton).click();
	    } catch (Exception e) {
	        System.out.println("Eye button click failed: " + e.getMessage());
	    }
	}
	
	
	public void performLogin(String email, String password) throws InterruptedException {
	    thread();

	    // Enter email
	    WebElement emailField = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
	    buttonClick(emailField);
	    wait(100);
	    emailField.sendKeys(email);

	    // Press TAB to shift focus
	    thread();
	    Actions ac = new Actions(driver);
	    ac.sendKeys(Keys.TAB).perform();

	    wait(500);
	    Thread.sleep(500); // Extra delay for password field

	    // Enter password
	    WebElement passwordField = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
	    try {
	        passwordField.sendKeys(password);
	    } catch (StaleElementReferenceException e) {
	        // Optionally re-find and retry
	        passwordField = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
	        passwordField.sendKeys(password);
	    }

	    wait(500);

	    // Click Login button
	    WebElement loginButton = driver.findElement(By.xpath("//*[text()='Login']"));
	    wait(100);
	    buttonClick(loginButton);
	}


	public void performLogout() throws InterruptedException {
	    // Click the main logout icon/button
	    WebElement logoutIcon = driver.findElement(By.xpath("(//*[@role='button'])[3]"));
	    buttonClick(logoutIcon); // Reusable click

	    // Click on group dropdown if needed (JS click)
	    WebElement logoutDropdown = driver.findElement(By.xpath("//*[@role='group']"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", logoutDropdown);

	    thread(); // Wait for dropdown animation or rendering

	    // Click on actual Logout link/button
	    WebElement logoutButton = driver.findElement(By.xpath("//*[text()='Logout']"));
	    buttonClick(logoutButton);
	}

	public void tabb(int times, int delay) throws InterruptedException {
	    Actions actions = new Actions(driver);
	    for (int i = 0; i < times; i++) {
	        actions.sendKeys(Keys.TAB).perform();
	        Thread.sleep(delay);
	    }
	}

	// Overloaded method with fixed default values
	public void tabb() throws InterruptedException {
	    tabb(30, 100); // Default: 30 TABs with 100ms delay
	}

	
	public void urlLaunch(String url) {
	    driver.get(url);  // Correct way with ThreadLocal
	}
	
	


	public static void threadone() throws InterruptedException {
		Thread.sleep(500);
	}
	
	
	public static void threadhalf() throws InterruptedException {
		Thread.sleep(500);
	}
	
	

	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	}


	
	
	public WebDriverWait wait2() {
	    return new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	public WebDriverWait waitWithTimeout(WebDriver driver, int timeoutInSeconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	}
	
	
	
	public static String getCellData(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);

        String cellValue = "";
        if (cell.getCellType() == CellType.STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            cellValue = String.valueOf((int) cell.getNumericCellValue());
        }
        workbook.close();
        fis.close();
        return cellValue;
    }

	
	
	public static void javaScriptex(String name, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (name.equalsIgnoreCase("Scroll up")) {
			js.executeScript("window.scrollBy(0, -1500)");
		}

		else if (name.equalsIgnoreCase("Scroll down")) {
			js.executeScript("window.scrollBy(0, 2500)");

		}

		else if (name.equalsIgnoreCase("move desired position")) {
			js.executeScript("arguments[0].scrollIntoView()", element);
		}

		else if (name.equalsIgnoreCase("Scroll top")) {
			js.executeScript("window.scrollTo(0,0)");
		} 

		else if (name.equalsIgnoreCase("Scroll bottom")) {
			js.executeAsyncScript("window.scroll(0,document.body.scrollHeight)");
		}

		else if (name.equalsIgnoreCase("click position")) {
			js.executeScript("arguments[0].click()", element);
		}
	}

	public static void Sleep() throws InterruptedException {

		Thread.sleep(2000);
	}

	public static void selectMethods(WebElement element, String name, String str, int index) {
		Select s = new Select(element);

		if (name.equalsIgnoreCase("index")) {
			s.selectByIndex(index);
		} else if (name.equalsIgnoreCase("text")) {
			s.selectByVisibleText(str);
		} else if (name.equalsIgnoreCase("value")) {
			s.selectByValue(str);
		}

	}

	public static void windowshandling() {
		Set<String> winhandles = driver.getWindowHandles();
		List<String> allWin = new LinkedList<>();
		allWin.addAll(winhandles);

		driver.switchTo().window(allWin.get(1));

	}
	
	
	public static void jsclick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
 

	public static void selectbyIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static void selectbyvalu(WebElement element, String valu) {
		Select s = new Select(element);
		s.selectByValue(valu);
	}

	public static void selectbyvisibletext(WebElement element, String tex) {
		Select s = new Select(element);
		s.selectByVisibleText(tex);
	}

	public static void thread() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	

	public static void actionsMethods(WebElement element, String value) {

		Actions ac = new Actions(driver);
		if (value.equalsIgnoreCase("click")) {
			ac.click(element).build().perform();
		}

		else if (value.equalsIgnoreCase("doubleclick")) {
			ac.doubleClick(element).build().perform();

		} else if (value.equalsIgnoreCase("contextclick")) {
			ac.contextClick(element).build().perform();

		} else if (value.equalsIgnoreCase("movetoelement")) {
			ac.moveToElement(element).build().perform();
		}

	}

	

	public static void navigationRefresh() {
		driver.navigate().refresh();

	}

	public static void navigationback() {
		driver.navigate().back();

	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public void sendText(WebElement keys, String user) {

		keys.sendKeys(user);

	}

	public static void buttonClick(WebElement button) {
		button.click();

	}

	public void screenCapture(String capture) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File a = ts.getScreenshotAs(OutputType.FILE);
		File b = new File("C:\\Users\\jainu\\OneDrive\\Desktop\\Screenshot\\" + capture + ".png");
		FileUtils.copyFile(a, b);

	}

	public void Robot(int value) throws AWTException {
		java.awt.Robot r = new java.awt.Robot();
		r.keyPress(value);
		r.keyRelease(value);
	}

	public void alert1(String type) {
		Alert alert = driver.switchTo().alert();

		switch (type) {
		case "Accept":
			alert.accept();
			break;

		case "Dismiss":
			alert.dismiss();
			break;

		default:
			break;
		}
	}

	public static void alertMethods(String alertt) {

		Alert a = driver.switchTo().alert();
		if (alertt.equalsIgnoreCase("Accept")) {
			a.accept();
		} else if (alertt.equalsIgnoreCase("Dismiss")) {
			a.dismiss();
		}
	}

	public static void frame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void winHandles() {

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handles : windowHandles) {
			driver.switchTo().window(handles);
		}
	}

	public static void switchWindows(int index) {

		Set<String> allWindowsID = driver.getWindowHandles();
		List<String> list = new LinkedList<String>();
		list.addAll(allWindowsID);
		// To get Particular values
		String childWindowsID = list.get(index);
		// To Switch To Windows
		driver.switchTo().window(childWindowsID);

	}


	public static void win (int index) {

		Set<String> windowHandles = driver.getWindowHandles();
		List<String>li = new LinkedList<String>();
		li.addAll(windowHandles);
		String child = li.get(index);
		driver.switchTo().window(child);

	}

	public static void wait (int index) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void urlnavigate (String url) {
		driver.navigate().to(url);
	}

	public static void waits(int num) {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}


	public static String getWindowsID(int index) {

		Set<String> allWindowsID = driver.getWindowHandles();
		List<String> list = new LinkedList<String>();
		list.addAll(allWindowsID);
		// To get Particular values
		String childWindowsID = list.get(index);
		return childWindowsID;
	}
	public void switchtoWindows(String childWindowsID) {

		// To Switch To Windows
		driver.switchTo().window(childWindowsID);
	}




	public void clear(WebElement delete) {

		delete.clear();

	}



	public static String readExcel(int rownum,int cellnum) throws IOException {

		String value = null;
		try {


			File f = new File("C:\\Users\\jainu\\OneDrive\\Desktop\\Testdata.xlsx"); 
			FileInputStream fis = new FileInputStream(f);
			Workbook wb  = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");

			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);

			org.apache.poi.ss.usermodel.CellType cellType = cell.getCellType();		


			switch (cellType) {
			case STRING:
				value = cell.getStringCellValue();
				break;


			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
					sdf.format(dateCellValue);
				}


				else {
					double numericCellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					value = valueOf.toString();
				}
				break;


			default:
				System.out.println("undefined format");
				break;
			}
		}catch(Exception e) {

		}

		return value;
	}



	public static void windowhandles() {

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		for (String a : windowHandles) {
			System.out.println(a);
			driver.switchTo().window(a);
			String title = driver.getTitle();
			System.out.println(title);

		}
	}

	public static void quitbrowser() {
		driver.quit();
	}


	public static void implicitwait(int duration) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}


	public static void clickk(WebElement clickkk) {
		clickkk.click();
	}
}
