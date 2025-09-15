
package org.Nonpo;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Nonpo_Process3 extends BaseClass {
	
	ExtentReports extent;
	ExtentTest test;
	
	
	
	@BeforeClass
	private void reportSetup() {
	    ExtentSparkReporter spark = new ExtentSparkReporter("test-output/Flowstax_Login_Report.html");
	    extent = new ExtentReports();
	    extent.attachReporter(spark);
	    extent.setSystemInfo("Project", "Flowstax_Nonpo_Process");
	    extent.setSystemInfo("Tester", "Asik14");
	}
	
	
	
	
	@Test
	private void LaunchBrowser() throws IOException, AWTException, InterruptedException {


		browserLaunch("chrome");
		urlLaunch("https://staging.flow.stax.run/#/login");
		maximize();
	}				

	@Test	     // or After class		
	private void LoginFunctionality() throws InterruptedException, AWTException, IOException {


		waits(5000);


		WebElement user = driver.findElement(By.xpath("//*[@aria-label='Enter registered email']"));
		wait(10);

		user.click();
		Thread.sleep(1000);
		user.sendKeys("branch_npo@gmail.com");

		wait(50);

		try {
			java.awt.Robot r = new java.awt.Robot();
			for (int i = 0; i < 1; i++) { r.keyPress(KeyEvent.VK_TAB);  Thread.sleep(200); }
		} catch (Exception e) {	
			e.printStackTrace();
		}



		wait(50);
		WebElement pass = driver.findElement(By.xpath("//flt-semantics[@aria-label='Enter Password']//input[@data-semantics-role='text-field']"));
		try {
			pass.sendKeys("P$2EorwK5cyc@Ar-8NOT");
		} catch (StaleElementReferenceException e) {
		}


		wait(100);	

		WebElement loginbutn = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(10);
		buttonClick(loginbutn);



		thread();

	}

		// ************************ADD NEW **********************************************


	@Test
	private void addNewcreation() throws InterruptedException, AWTException, IOException {

		waitWithTimeout(driver, 30);


		thread();

		driver.findElement(By.xpath("//*[text()='Add New']")).click();

		thread();


		// Create Robot instance
		java.awt.Robot robot = new java.awt.Robot();

		// Press Ctrl and Minus key 3 times to zoom out
		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(500);
		}


		WebElement jss = driver.findElement(By.xpath("//*[text()='Please select']"));


		jsclick(driver, jss);
		wait(500);


		driver.findElement(By.xpath("//*[text()='Petty Cash']")).click();
		wait(1000);

		WebElement element = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));

		// JS click to make it visible if hidden or obstructed
		jsclick(driver, element);

		// Additional step to ensure it gets focus
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

		wait(1000); // Optional, but good for slow UIs


		//INVOICE  NUM 


		element.sendKeys("BRJ4LTU");
		thread();




		driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]")).click();


		wait(1000);


		driver.findElement(By.xpath("(//*[@role='button'])[13]")).click();

		wait(500);

		driver.findElement(By.xpath("//*[text()='OK']")).click();


		wait(500);

		driver.findElement(By.xpath("(//*[@role='button'])[1]")).click();
		wait(500);


		driver.findElement(By.xpath("//*[text()='Vendor Id']")).click();

		wait(500);


		WebElement element2 = driver.findElement(By.xpath("//*[@aria-label='Search for Vendor Id']"));


		actions.moveToElement(element2).click().perform();

		wait(1000); // Optional, but good for slow UIs

		element2.sendKeys("1");
		thread();
		thread();


		waitWithTimeout(driver, 20);

		driver.findElement(By.xpath("//*[text()='Please select']")).click();

		wait(500);


		driver.findElement(By.xpath("//*[text()='USD']")).click();
		wait(500);



		driver.findElement(By.xpath("(//*[@autocomplete='off'])[6]")).sendKeys("Testing - Description");
		wait(500);



		WebElement quantity = driver.findElement(By.xpath("(//*[@autocomplete='off'])[11]"));
		buttonClick(quantity);
		wait(2000);

		sendText(quantity, "62.62");


		wait(2000);


		WebElement price = driver.findElement(By.xpath("(//*[@autocomplete='off'])[10]"));
		buttonClick(price);
		wait(2000);
		sendText(price ,"56565.95");



		thread();



		driver.findElement(By.xpath("(//*[@autocomplete='off'])[6]/following::*")).click();
		wait(500);


		driver.findElement(By.xpath("//*[text()='ATM - NCR']")).click();
		wait(2000);



		WebElement element5 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[6]/following::flt-semantics[starts-with(@id,'flt-semantic-node-')][5]"));
		jsclick(driver, element5);

		wait(2000);

		WebElement element3 = driver.findElement(By.xpath("//*[text()='1B00300003']"));
		jsclick(driver, element3);

		thread();



		waitWithTimeout(driver, 20);

		WebElement element4 = driver.findElement(By.xpath("((//*[@autocomplete='off'])[11]/following::flt-semantics[@role='button'])[1]"));
		jsclick(driver, element4);

		thread();

		WebElement element6 = driver.findElement(By.xpath("//*[text()='The field is required']"));
		jsclick(driver, element6);


		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='5']")).click();




		waitWithTimeout(driver, 20);


		driver.findElement(By.xpath("(//*[@data-semantics-role='text-field'])[32]")).click();



		Thread.sleep(1000);

		java.awt.Robot r11 = new java.awt.Robot();
		r11.setAutoDelay(800);

		StringSelection file11 = new StringSelection("C:\\Users\\jainu\\Downloads\\Test2.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file11, null);

		r11.keyPress(KeyEvent.VK_CONTROL);

		r11.keyPress(KeyEvent.VK_V);

		Thread.sleep(500);
		r11.keyPress(KeyEvent.VK_ENTER);

		thread();

		// 2nd upload 


		driver.findElement(By.xpath("(//*[@data-semantics-role='text-field'])[32]")).click();



		Thread.sleep(1000);

		java.awt.Robot r111 = new java.awt.Robot();
		r111.setAutoDelay(800);

		StringSelection file111 = new StringSelection("C:\\Users\\jainu\\Downloads\\Testpdf123.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file111, null);

		r111.keyPress(KeyEvent.VK_CONTROL);

		r111.keyPress(KeyEvent.VK_V);

		Thread.sleep(500);
		r111.keyPress(KeyEvent.VK_ENTER);




		thread();
		driver.findElement(By.xpath("//*[text()='Next']")).click();


	}


		//EYE
	    @Test
		private void editAction() throws InterruptedException, AWTException, IOException {


		thread();
		thread();
		waitWithTimeout(driver, 20);


		Actions actionsjh = new Actions(driver);

		for (int i = 0; i < 30; i++) {
			actionsjh.sendKeys(Keys.TAB).perform();
			Thread.sleep(250);
		}


		thread();

		waitWithTimeout(driver, 20);


		WebElement jsc = driver.findElement(By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]"));

		// Scroll the element into view using JavaScript
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'});", jsc);

		// Then click the element
		jsc.click();


		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='History']")).click();



		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Edit']")).click();

		waitWithTimeout(driver, 20);

		Thread.sleep(1000);



		// DUPLICATE ROW

		driver.findElement(By.xpath("(//*[text()='Show menu'])[1]")).click();
		waitWithTimeout(driver, 20);

		Thread.sleep(500);

		driver.findElement(By.xpath("//*[text()='Duplicate Row']")).click();



		thread();


		//ADD ROW
		driver.findElement(By.xpath("//*[text()='Add Row']")).click();

		waitWithTimeout(driver, 20);

		Thread.sleep(1000);


		driver.findElement(By.xpath("(//*[@autocomplete='off'])[24]")).sendKeys("Testing - Description 3");


		Thread.sleep(1000);

		WebElement quantity1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[28]"));
		buttonClick(quantity1);
		wait(2000);

		sendText(quantity1, "262.89");


		Thread.sleep(1000);


		WebElement price1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[29]"));
		buttonClick(price1);
		wait(2000);
		sendText(price1 ,"65.5");



		thread();



		driver.findElement(By.xpath("(//*[@autocomplete='off'])[6]/following::*[85]")).click();
		wait(500);
		Thread.sleep(500);

		waitWithTimeout(driver, 20);

		driver.findElement(By.xpath("//*[text()='Dummy Desc code ']")).click();
		wait(2000);



		// DUPLICATE ROW

		Thread.sleep(500);

		driver.findElement(By.xpath("(//*[text()='Show menu'])[3]")).click();
		waitWithTimeout(driver, 20);

		driver.findElement(By.xpath("//*[text()='Duplicate Row']")).click();


		thread();

		//		// 2nd upload 
		//
		//
		//		driver.findElement(By.xpath("(//*[@data-semantics-role='text-field'])[49]")).click();
		//
		//
		//
		//		Thread.sleep(1000);
		//
		//		java.awt.Robot iuytrfgh = new java.awt.Robot();
		//		iuytrfgh.setAutoDelay(800);
		//
		//		StringSelection lkjh = new StringSelection("C:\\Users\\jainu\\Downloads\\Testpdf123.pdf");
		//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(lkjh, null);
		//
		//		iuytrfgh.keyPress(KeyEvent.VK_CONTROL);
		//
		//		iuytrfgh.keyPress(KeyEvent.VK_V);
		//
		//		Thread.sleep(500);
		//		iuytrfgh.keyPress(KeyEvent.VK_ENTER);




		thread();
		driver.findElement(By.xpath("//*[text()='Next']")).click();

		/*

		WebElement element51 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[6]/following::flt-semantics[starts-with(@id,'flt-semantic-node-')][5]"));
		jsclick(driver, element51);

		wait(2000);

		WebElement element31 = driver.findElement(By.xpath("//*[text()='1B00300003']"));
		jsclick(driver, element31);

		thread();

		 */



		//BACK BUTTON
		Thread.sleep(1000);

		waitWithTimeout(driver, 20);

		Thread.sleep(2000);

		WebElement KKJJ = driver.findElement(By.xpath("(//*[@role='button'])[4]"));
		jsclick(driver, KKJJ);




		thread();
		thread();

		Actions actionsjh1 = new Actions(driver);

		for (int i = 0; i < 30; i++) {
			actionsjh1.sendKeys(Keys.TAB).perform();
			Thread.sleep(150);
		}


		thread();

		waitWithTimeout(driver, 20);
	    }
	    
	    

	    @Test
		private void submitScreen() throws InterruptedException, AWTException, IOException {


		driver.findElement(By.xpath("(//*[text()='Submit'])[1]")).click();


		waitWithTimeout(driver, 20);

		// DUPLICATE ROW

		driver.findElement(By.xpath("(//*[text()='Show menu'])[3]")).click();
		waitWithTimeout(driver, 20);

		driver.findElement(By.xpath("//*[text()='Duplicate Row']")).click();


		thread();

		//		// INVOCE EDIT 
		//		WebElement element1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		//
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		//
		//		waitWithTimeout(driver, 10);
		//
		//		element1.click();  // or element1.sendKeys("text");
		//
		//
		//	
		//		thread();
		//		waitWithTimeout(driver, 20);
		//
		//		driver.findElement(By.xpath("//*[text()='Test2.png']")).click();
		//
		//		thread();
		driver.findElement(By.xpath("//*[text()='Next']")).click();


		waitWithTimeout(driver, 20);

		thread();
		Thread.sleep(1000);

		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement logbt = driver.findElement(By.xpath("//*[@role='group']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logbt);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();

	    }
		
		@Test
		private void moveToStage_FinanceAuthorizer() throws InterruptedException, AWTException, IOException {



		//LOGIN 


		thread();
		WebElement user1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(user1);
		wait(100);
		user1.sendKeys("finance_authorizer_npo@gmail.com");

		thread();

		Actions ac = new Actions(driver);

		for (int i = 0; i < 1; i++) {
			ac.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement jh = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			jh.sendKeys("bbJyL6et2OCjao4hy30B");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement loginbutn1 = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(loginbutn1);



		waitWithTimeout(driver, 20);


		//driver.findElement(By.xpath("//*[text()='Non PO Process']")).click();

		//EYE


		thread();
		waitWithTimeout(driver, 20);


		thread();

		Actions act = new Actions(driver);
		for (int i = 0; i < 30; i++) {
			act.sendKeys(Keys.TAB).perform();
			Thread.sleep(150);
		}


		Thread.sleep(1000);

		
		driver.findElement(By.xpath("(//*[text()='Approve'])[1]")).click();

		wait(2000);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@autocomplete='off']")).sendKeys("Testing - Approve 1 ");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();


		waitWithTimeout(driver, 20);

		thread();
		thread();




		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement logbt1 = driver.findElement(By.xpath("//*[@role='group']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logbt1);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();


		}
		
		
		@Test
		private void stageMovement_Dcfo() throws InterruptedException, AWTException, IOException {



		//LOGIN 


		thread();
		WebElement user11 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(user11);
		wait(100);
		user11.sendKeys("dcfo_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			Actions ac = new Actions(driver);
			ac.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement jh1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			jh1.sendKeys("Pn!NskTNlvfJa8k~TRb$");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement lkjh = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(lkjh);


		thread();
		thread();

		Actions acc = new Actions(driver);

		for (int i = 0; i < 30; i++) {
			acc.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}




		waitWithTimeout(driver, 20);


		WebElement jsc1 = driver.findElement(By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]"));

		// Scroll the element into view using JavaScript
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'});", jsc1);

		// Then click the element
		jsc1.click();


		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='History']")).click();


		}
		
		@Test
		private void edit_Dcfo() throws InterruptedException, AWTException, IOException {


		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Edit']")).click();

		waitWithTimeout(driver, 20);

		Thread.sleep(1000);

		// INVOCE EDIT 
		WebElement element1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));

		sendText(element1, "123");


		thread();
		waitWithTimeout(driver, 20);

		driver.findElement(By.xpath("//*[text()='Next']")).click();

		//driver.findElement(By.xpath("//*[text()='Test2.png']")).click();


		thread();


		driver.findElement(By.xpath("(//*[text()='Approve'])[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@autocomplete='off']")).sendKeys("Testing - Approve 2");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();


		waitWithTimeout(driver, 20);

		thread();
		thread();




		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement ytr = driver.findElement(By.xpath("//*[@role='group']"));
		JavascriptExecutor jss = (JavascriptExecutor)driver;
		jss.executeScript("arguments[0].click();", ytr);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();


		
		}
		
		
		@Test
		private void stageMovement_cfo() throws InterruptedException, AWTException, IOException {


			

		//LOGIN 


		thread();
		WebElement nbv = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(nbv);
		wait(100);
		nbv.sendKeys("cfo_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			Actions acc = new Actions(driver);
			acc.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement poiuh = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			poiuh.sendKeys("9JnmmenusfeIqPebx~m~");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement oiuy = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(oiuy);


		thread();
		thread();

		Actions acct = new Actions(driver);

		for (int i = 0; i < 30; i++) {
			acct.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}


		waitWithTimeout(driver, 20);


		WebElement lkjhji = driver.findElement(By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]"));

		// Scroll the element into view using JavaScript
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'});", lkjhji);

		// Then click the element
		lkjhji.click();


		Thread.sleep(1000);


		driver.findElement(By.xpath("//*[text()='View Flow']")).click();

		thread();
		thread();


		driver.findElement(By.xpath("//*[@role='button']")).click();


		wait(1000);

		//DOWNLOAD
		driver.findElement(By.xpath("(//*[@role='button'])[6]")).click();



		thread();


		driver.findElement(By.xpath("(//*[text()='Approve'])[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@autocomplete='off']")).sendKeys("Testing - Approve 3");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();


		waitWithTimeout(driver, 20);

		thread();
		thread();




		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement mnbv = driver.findElement(By.xpath("//*[@role='group']"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;

		js1.executeScript("arguments[0].click();", mnbv);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();

		}
		

		@Test
		private void stageMovement_dceo() throws InterruptedException, AWTException, IOException {

		//LOGIN 


		thread();
		WebElement qwe = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(qwe);
		wait(100);
		qwe.sendKeys("dceo_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			Actions ac2 = new Actions(driver);

			ac2.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement qwer = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			qwer.sendKeys("I4xKC2BBKV@5syekUwx7");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement werew = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(werew);


		thread();
		thread();

		Actions LKK = new Actions(driver);

		for (int i = 0; i < 30; i++) {
			LKK.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}




		waitWithTimeout(driver, 20);

		
		}
		
		@Test
		private void editDceo() throws InterruptedException, AWTException, IOException {

		WebElement oiuyt = driver.findElement(By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]"));

		// Scroll the element into view using JavaScript
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'});", oiuyt);

		// Then click the element
		oiuyt.click();


		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='History']")).click();



		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Edit']")).click();

		waitWithTimeout(driver, 20);

		Thread.sleep(2000);

		// INVOCE EDIT 
		WebElement kjhgf = driver.findElement(By.xpath("//*[@aria-label='Petty Cash']"));

		jsclick(driver, kjhgf);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='Other Registered Vendors']")).click();




		thread();
		waitWithTimeout(driver, 20);

		driver.findElement(By.xpath("//*[text()='Next']")).click();



		thread();


		driver.findElement(By.xpath("(//*[text()='Approve'])[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@autocomplete='off']")).sendKeys("Testing - Approve 4");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();


		waitWithTimeout(driver, 20);

		thread();
		thread();
		
		

		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement mnbv1 = driver.findElement(By.xpath("//*[@role='group']"));
		JavascriptExecutor js4 = (JavascriptExecutor)driver;
		js4.executeScript("arguments[0].click();", mnbv1);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();


		}
		
		
		
		@Test
		private void stage_Ceo() throws InterruptedException, AWTException, IOException {



		//LOGIN 


		thread();
		WebElement qwe1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(qwe1);
		wait(100);
		qwe1.sendKeys("ceo_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			Actions ac5 = new Actions(driver);

			ac5.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement asdfg = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			asdfg.sendKeys("lBwHwJLyQX7qW#!OO~1A");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement bvcx = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(bvcx);


		thread();
		thread();

		Actions kjh = new Actions(driver);

		for (int i = 0; i < 30; i++) {
			kjh.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}


		driver.findElement(By.xpath("(//*[text()='Approve'])[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@autocomplete='off']")).sendKeys("Testing - Approve 4");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();


		waitWithTimeout(driver, 20);

		thread();

		

		thread();
		
		

		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement nbvrty = driver.findElement(By.xpath("//*[@role='group']"));
		JavascriptExecutor js7 = (JavascriptExecutor)driver;

		js7.executeScript("arguments[0].click();", nbvrty);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();



		
		}
		
		@Test
		private void stageFinancereconcile() throws InterruptedException, AWTException, IOException {



		//LOGIN 


		thread();
		WebElement oiuyk = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(oiuyk);
		wait(100);
		oiuyk.sendKeys("finance_reconcile_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			Actions acc = new Actions(driver);

			acc.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement asdqq = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			asdqq.sendKeys("I9y0qsXlTx2u37ygJwis");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement lokj = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(lokj);


		thread();
		thread();

		Actions qwqq = new Actions(driver);

		for (int i = 0; i < 30; i++) {
			qwqq.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}


		
		waitWithTimeout(driver, 20);


		WebElement kjyh = driver.findElement(By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]"));

		// Scroll the element into view using JavaScript
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'});", kjyh);

		// Then click the element
		kjyh.click();


		Thread.sleep(2000);
		
		
		WebElement downloadBtn = driver.findElement(By.xpath("(//*[text()='Download'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downloadBtn);
		downloadBtn.click();		
		
		
		
		
		thread();
		thread();

		driver.findElement(By.xpath("(//*[text()='Reconcile'])[1]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]")).sendKeys("Testing - Reconcile");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='Next']")).click();
		
		

		thread();

		

		thread();
		
		

		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement a1 = driver.findElement(By.xpath("//*[@role='group']"));
		
		JavascriptExecutor jss9 = (JavascriptExecutor)driver;

		jss9.executeScript("arguments[0].click();", a1);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();


		}
		
		
		@Test
		private void stage_Branch() throws InterruptedException, AWTException, IOException {

		//LOGIN 


		thread();
		WebElement b1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(b1);
		wait(100);
		b1.sendKeys("branch_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			Actions ackc = new Actions(driver);

			ackc.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement c1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			c1.sendKeys("P$2EorwK5cyc@Ar-8NOT");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement ka = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(ka);


		thread();
		thread();

		Actions oiuyk5 = new Actions(driver);

		for (int i = 0; i < 30; i++) {
			oiuyk5.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}


		driver.findElement(By.xpath("//*[text()='Reconcile']")).click();

	
		
		waitWithTimeout(driver, 20);


		WebElement oiuyt1 = driver.findElement(By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]"));

		// Scroll the element into view using JavaScript
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'});", oiuyt1);

		// Then click the element
		oiuyt1.click();


		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='History']")).click();


		extent.flush();

		
		



	}

}