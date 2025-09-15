package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
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
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassParallel {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public void browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver.set(new ChromeDriver(options));
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();
	}

//	public void browserLaunch(String browser, int positionX) {
//	    if (browser.equalsIgnoreCase("chrome")) {
//	        WebDriverManager.chromedriver().setup();
//	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--disable-notifications");
//	        options.addArguments("window-size=1200,800");
//	        options.addArguments("window-position=" + positionX + ",0");
//	        driver.set(new ChromeDriver(options));
//	    }
//	    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//	
	public static void TabIndex(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath("(//*[@tabindex='0'])[" + index + "]"));
		jsclick(driver, element);
	}

	public void clickRoleButtonByIndex(int index) {
		getDriver().findElement(By.xpath("(//*[@role='button'])[" + index + "]")).click();
	}

	public void clickCheckboxByIndex(int index) {
		WebElement checkbox = getDriver().findElement(By.xpath("(//*[@role='checkbox'])[" + index + "]"));
		checkbox.click();
	}

	public void DateclickOk(int index) {
		WebElement element = getDriver().findElement(By.xpath("(//*[@role='button'])[" + index + "]"));
		element.click();
		getDriver().findElement(By.xpath("//*[text()='OK']")).click();
	}

	public void inputareasindex(int index, String text) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		By locator = By.xpath("(//*[@autocomplete='off'])[" + index + "]");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		jsclick(element);
		element.sendKeys(text);
	}

	public void radiobutton(int index) {
		WebElement radioBtn = getDriver().findElement(By.xpath("(//*[@role='radio'])[" + index + "]"));
		radioBtn.click();
	}

	public void switchEnable(int index) {
		WebElement swtic = getDriver().findElement(By.xpath("(//*[@role='switch'])[" + index + "]"));
		swtic.click();
	}

	public void Eyeicon2() {
		WebElement actionButton = getDriver().findElement(By.xpath("(//span[text()='Actions']/following::flt-semantics[@role='button'])[1]"));
		actionButton.click();
	}

	public void performLogout2() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element3 = getDriver().findElement(By.xpath("(//*[@role='button'])[1]/following::*[5]"));
		js.executeScript("arguments[0].click();", element3);
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='group']")));
		WebElement logbt = getDriver().findElement(By.xpath("//*[@role='group']"));
		js.executeScript("arguments[0].click();", logbt);
		getDriver().findElement(By.xpath("//*[text()='Logout']")).click();
	}

	public void clearAndTypeText(String xpath, String newText) {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		jsclick(element);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element.sendKeys(newText);
	}

	public void downloadicon(int index) {
		WebElement element = getDriver().findElement(By.xpath("(//*[@role='button'])[" + index + "]"));
		element.click();
	}

	public void NextButton() {
		getDriver().findElement(By.xpath("(//*[text()='Next'])[1]")).click();
	}

	public void SubmitButton() {
		getDriver().findElement(By.xpath("(//*[text()='Submit'])[1]")).click();
	}

	public void MarkForCorrectionButton() {
		getDriver().findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Mark for Correction')])[1]")).click();
	}

	public WebElement getAutocompleteOffElementByIndex(int index) {
		return getDriver().findElement(By.xpath("(//*[@autocomplete='off'])[" + index + "]"));
	}

	public void Update() {
		getDriver().findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Update')])[1]")).click();
	}

	public void Escalate() {
		getDriver().findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Escalate')])[1]")).click();
	}

	public void Needinfo() {
		getDriver().findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Need Information')])[1]")).click();
	}

	public void Reassign() {
		getDriver().findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'Reassign')])[1]")).click();
	}

	public void Texthome(String text) {
		getDriver().findElement(By.xpath("(//flt-semantics[@role='button' and contains(text(),'" + text + "')])[1]")).click();
	}

	public void clicking(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public void clickAutoCompleteByIndex(int index) {
		List<WebElement> elements = getDriver().findElements(By.xpath("//*[@autocomplete='off']"));
		if (index <= 0 || index > elements.size()) return;
		WebElement el = elements.get(index - 1);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", el);
		try {
			el.click();
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", el);
		}
	}

	public void jsclick(WebElement element) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
	}

	public void clearAndTypeAutoCompleteByIndex(int index, String newText) throws InterruptedException {
		String xpath = "(//*[@autocomplete='off'])[" + index + "]";
		WebElement qq = getDriver().findElement(By.xpath(xpath));
		jsclick(qq);
		Thread.sleep(500);
		qq.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		qq.sendKeys(newText);
	}

	public void History() {
		WebElement element = getDriver().findElement(By.xpath("(//*[text()='History'])[1]"));
		jsclick(element);
	}

	public void threedot() {
		WebElement element = getDriver().findElement(By.xpath("(//*[@tabindex='0'])[16]"));
		jsclick(element);
	}

	public void threedot3() {
		WebElement element = getDriver().findElement(By.xpath("(//*[@tabindex='0'])[18]"));
		jsclick(element);
	}

	public void threedot4() {
		WebElement element = getDriver().findElement(By.xpath("(//*[@tabindex='0'])[19]"));
		jsclick(element);
	}

	public void threedot2() {
		WebElement element = getDriver().findElement(By.xpath("(//*[@tabindex='0'])[14]"));
		jsclick(element);
	}

	public void textpath(String text) {
		WebElement element = getDriver().findElement(By.xpath("(//*[text()='" + text + "'])[1]"));
		jsclick(element);
	}

	public void Details() {
		WebElement element = getDriver().findElement(By.xpath("(//*[text()='Details'])[1]"));
		jsclick(element);
	}

	public void Dwloadbtn() {
		WebElement element = getDriver().findElement(By.xpath("(//*[text()='Download'])[1]"));
		jsclick(element);
	}


	public void EditButton() {
		getDriver().findElement(By.xpath("(//*[text()='Edit'])[1]")).click();
	}

	public void replace(WebElement element, String text) {
		jsclick(element);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		element.sendKeys(text);
	}

	public void typing(String text) {
		WebElement input = getDriver().findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
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


	public void selectdate(int dateButtonIndex) {
		try {
			waitWithTimeout(10);

			WebElement dateInput = getDriver().findElement(By.xpath("//*[@aria-label='YYYY-MM-DD']"));
			dateInput.click();

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			WebElement date = getDriver().findElement(By.xpath("(//*[@role='button'])[" + dateButtonIndex + "]"));
			js.executeScript("arguments[0].click();", date);

			waitWithTimeout(10);

			WebElement okButton = getDriver().findElement(By.xpath("//*[text()='OK']"));
			okButton.click();

		} catch (Exception e) {
			System.out.println("Date selection failed: " + e.getMessage());
		}
	}


	public void backbutton() {
		try {
			WebElement button = getDriver().findElement(By.xpath("(//*[@role='button'])[4]"));
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
			Thread.sleep(500);
		}
	}

	public void EyeButton() {
		try {
			By eyeButton = By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]");
			getDriver().findElement(eyeButton).click();
		} catch (Exception e) {
			System.out.println("Eye button click failed: " + e.getMessage());
		}
	}

	public void performLogin(String email, String password) throws InterruptedException {
		thread();

		WebElement emailField = getDriver().findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(emailField);
		wait(100);
		emailField.sendKeys(email);

		thread();
		Actions ac = new Actions(getDriver());
		ac.sendKeys(Keys.TAB).perform();

		wait(500);
		Thread.sleep(500);

		WebElement passwordField = getDriver().findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			passwordField.sendKeys(password);
		} catch (StaleElementReferenceException e) {
			passwordField = getDriver().findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
			passwordField.sendKeys(password);
		}

		wait(500);

		WebElement loginButton = getDriver().findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(loginButton);
	}

	public void performLogout() throws InterruptedException {
		WebElement logoutIcon = getDriver().findElement(By.xpath("(//*[@role='button'])[3]"));
		buttonClick(logoutIcon);

		WebElement logoutDropdown = getDriver().findElement(By.xpath("//*[@role='group']"));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", logoutDropdown);

		thread();

		WebElement logoutButton = getDriver().findElement(By.xpath("//*[text()='Logout']"));
		buttonClick(logoutButton);
	}


	public void tabb(int times, int delay) throws InterruptedException {
		Actions actions = new Actions(getDriver());
		for (int i = 0; i < times; i++) {
			actions.sendKeys(Keys.TAB).perform();
			Thread.sleep(delay);
		}
	}

	public void tabb() throws InterruptedException {
		tabb(30, 100);
	}

	public void urlLaunch(String url) {
		getDriver().get(url);
	}

	public static void threadone() throws InterruptedException {
		Thread.sleep(500);
	}

	public static void threadhalf() throws InterruptedException {
		Thread.sleep(500);
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	}

	public WebDriverWait wait2() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	}

	public WebDriverWait waitWithTimeout(int timeoutInSeconds) {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
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

	public void windowshandling() {
		Set<String> winhandles = getDriver().getWindowHandles();
		List<String> allWin = new LinkedList<>(winhandles);
		getDriver().switchTo().window(allWin.get(1));
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



	public void actionsMethods(WebElement element, String value) {
		Actions ac = new Actions(getDriver());
		if (value.equalsIgnoreCase("click")) {
			ac.click(element).build().perform();
		} else if (value.equalsIgnoreCase("doubleclick")) {
			ac.doubleClick(element).build().perform();
		} else if (value.equalsIgnoreCase("contextclick")) {
			ac.contextClick(element).build().perform();
		} else if (value.equalsIgnoreCase("movetoelement")) {
			ac.moveToElement(element).build().perform();
		}
	}

	public void navigationRefresh() {
		getDriver().navigate().refresh();
	}

	public void navigationback() {
		getDriver().navigate().back();
	}

	public void maximize() {
		getDriver().manage().window().maximize();
	}

	public void sendText(WebElement keys, String user) {
		keys.sendKeys(user);
	}

	public void buttonClick(WebElement button) {
		button.click();
	}

	public void screenCapture(String capture) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
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
		Alert alert = getDriver().switchTo().alert();
		switch (type) {
		case "Accept" -> alert.accept();
		case "Dismiss" -> alert.dismiss();
		}
	}

	public void alertMethods(String alertt) {
		Alert a = getDriver().switchTo().alert();
		if (alertt.equalsIgnoreCase("Accept")) {
			a.accept();
		} else if (alertt.equalsIgnoreCase("Dismiss")) {
			a.dismiss();
		}
	}

	public void frame(WebElement element) {
		getDriver().switchTo().frame(element);
	}

	public void winHandles() {
		Set<String> windowHandles = getDriver().getWindowHandles();
		for (String handles : windowHandles) {
			getDriver().switchTo().window(handles);
		}
	}

	public void switchWindows(int index) {
		Set<String> allWindowsID = getDriver().getWindowHandles();
		List<String> list = new LinkedList<>(allWindowsID);
		String childWindowsID = list.get(index);
		getDriver().switchTo().window(childWindowsID);
	}

	public void win(int index) {
		Set<String> windowHandles = getDriver().getWindowHandles();
		List<String> li = new LinkedList<>(windowHandles);
		String child = li.get(index);
		getDriver().switchTo().window(child);
	}

	public void wait(int index) {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void urlnavigate(String url) {
		getDriver().navigate().to(url);
	}

	public void waits(int seconds) {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public String getWindowsID(int index) {
		Set<String> allWindowsID = getDriver().getWindowHandles();
		List<String> list = new LinkedList<>(allWindowsID);
		return list.get(index);
	}

	public void switchtoWindows(String childWindowsID) {
		getDriver().switchTo().window(childWindowsID);
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


	public void windowhandles() {
		Set<String> windowHandles = getDriver().getWindowHandles();
		System.out.println(windowHandles);
		for (String a : windowHandles) {
			System.out.println(a);
			getDriver().switchTo().window(a);
			String title = getDriver().getTitle();
			System.out.println(title);
		}
	}

	public void quitbrowser() {
		getDriver().quit();
	}

	public void implicitwait(int duration) {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}

	public void clickk(WebElement clickkk) {
		clickkk.click();
	}
}