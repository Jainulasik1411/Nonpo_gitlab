
package org.Nonpo;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

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

public class Nonpo_Process_Branch_Withdraw_deny_Reject_Flow2 extends BaseClass {

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



		// ************************ADD NEW **********************************************


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

		WebElement invoiceField = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));

		// Step 2: Click on it using JavaScript and Actions (for safety)
		jsclick(driver, invoiceField); // your custom JS click method

		Actions actions = new Actions(driver);
		actions.moveToElement(invoiceField).click().perform();

		// Step 3: Wait for 1 second (you mentioned using wait or thread)
		wait(1000); // or thread(); if wait is not defined

		// Step 4: Generate unique invoice number using timestamp
		String timestamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
		String invoiceNumber = "INV" + timestamp;

		// Step 5: Send the unique invoice number into the field
		invoiceField.sendKeys(invoiceNumber);

		// Step 6: Add thread sleep if needed
		thread();



		driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]")).click();


		wait(1000);


		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();

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
		
		
		driver.findElement(By.xpath("//span[contains(text(), '100000') and contains(text(), 'A.MGR Co. Pte Ltd')]")).click();
		thread();


		waitWithTimeout(driver, 20);

		driver.findElement(By.xpath("//*[text()='Please select']")).click();

		wait(500);

//		driver.findElement(By.xpath("//*[@aria-label='Search']")).sendKeys("USD");
//		threadhalf();
		
		WebElement element8 = driver.findElement(By.xpath("//*[text()='USD']"));
		
		jsclick(driver, element8);
		
		wait(500);

		
		thread();


		driver.findElement(By.xpath("(//*[@autocomplete='off'])[6]")).sendKeys("Testing - Description");
		wait(1200);
		
		

		WebElement quantity = driver.findElement(By.xpath("(//*[@autocomplete='off'])[11]"));
		buttonClick(quantity);
		wait(2000);

		sendText(quantity, "1200.12");


		wait(2000);


		WebElement price = driver.findElement(By.xpath("(//*[@autocomplete='off'])[10]"));
		buttonClick(price);
		wait(2000);
		sendText(price ,"1028.35");



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
		waitWithTimeout(driver, 10);

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




		thread();
		thread();
		waitWithTimeout(driver, 20);


		Actions actionsjh = new Actions(driver);


		// EYE ICON

		for (int i = 0; i < 30; i++) {
			actionsjh.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}
		
		tabb();


		WebElement jsc = driver.findElement(By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]"));

		// Scroll the element into view using JavaScript
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'});", jsc);

		// Then click the element
		jsc.click();



		// VIEW FLOW 

		Thread.sleep(1500);


		driver.findElement(By.xpath("//*[text()='View Flow']")).click();

		thread();
		thread();


		driver.findElement(By.xpath("//*[@role='button']")).click();

		thread();

		//SUBMIT 


		waitWithTimeout(driver, 20);


		driver.findElement(By.xpath("(//*[text()='Submit'])[1]")).click();


		waitWithTimeout(driver, 20);

		// DUPLICATE ROW

		driver.findElement(By.xpath("(//*[text()='Show menu'])[1]")).click();
		waitWithTimeout(driver, 20);

		driver.findElement(By.xpath("//*[text()='Duplicate Row']")).click();


		thread();


		driver.findElement(By.xpath("//*[text()='Next']")).click();

		thread();
		thread();


		// WITHDRAWNS


		for (int i = 0; i < 30; i++) {
			actionsjh.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}


		waitWithTimeout(driver, 20);


		driver.findElement(By.xpath("(//*[text()='Withdraw'])[1]")).click();


		driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]")).sendKeys("Testing - Withdrawn");


		thread();
		driver.findElement(By.xpath("//*[text()='Next']")).click();


		thread();


		// EYE ICON

		for (int i = 0; i < 30; i++) {
			actionsjh.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}


		WebElement jsc1 = driver.findElement(By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]"));

		// Scroll the element into view using JavaScript
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'});", jsc1);

		// Then click the element
		jsc1.click();



		// VIEW FLOW 

		Thread.sleep(1500);


		driver.findElement(By.xpath("//*[text()='View Flow']")).click();

		thread();
		thread();


		driver.findElement(By.xpath("//*[@role='button']")).click();

		thread();




		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Edit']")).click();

		waitWithTimeout(driver, 20);

		Thread.sleep(1000);


		// DELETE ROW

		driver.findElement(By.xpath("(//*[@role='checkbox'])[3]")).click();


		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='Delete']")).click();



		thread();

		WebElement quantity1 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[11]"));
		buttonClick(quantity1);
		quantity1.click(); // ensure focus
		quantity1.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
		quantity1.sendKeys("1"); // replace with 1

		thread();
		driver.findElement(By.xpath("//*[text()='Next']")).click();


		thread();
		thread();

		/*

		//BACK BUTTON
		Thread.sleep(2000);

		waitWithTimeout(driver, 20);


		WebElement KKJJ = driver.findElement(By.xpath("(//*[@role='button'])[4]"));
		jsclick(driver, KKJJ);


		thread();
		thread();

		// EYE ICON

		for (int i = 0; i < 30; i++) {
			actionsjh.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}


		WebElement jhg = driver.findElement(By.xpath("//flt-semantics[@role='button' and @tabindex='0' and contains(@style, 'transform: matrix(1, 0, 0, 1, 50, 7.5)')]"));

		// Scroll the element into view using JavaScript
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'});", jhg);

		// Then click the element
		jhg.click();

		 */

		// VIEW FLOW 



		driver.findElement(By.xpath("//*[text()='View Flow']")).click();

		thread();
		thread();


		driver.findElement(By.xpath("//*[@role='button']")).click();

		thread();
		thread();


		//SUBMIT 




		driver.findElement(By.xpath("(//*[text()='Submit'])[1]")).click();


		Thread.sleep(5000);
		thread();

		driver.findElement(By.xpath("//*[text()='Next']")).click();



		thread();
		thread();

		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement logbt = driver.findElement(By.xpath("//*[@role='group']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logbt);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();




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

		thread();
		thread();


		waitWithTimeout(driver, 20);

		for (int i = 0; i < 30; i++) {
			actionsjh.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}



		// FINANCE AUTHORIOZER



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
		js.executeScript("arguments[0].click();", logbt1);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();




		//LOGIN 


		thread();
		WebElement user11 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(user11);
		wait(100);
		user11.sendKeys("dcfo_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
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


		// DCFO - USER GRUP


		Thread.sleep(1000);


		driver.findElement(By.xpath("(//*[text()='Deny'])[1]")).click();

		wait(2000);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@autocomplete='off']")).sendKeys("Testing - Deny ");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();


		waitWithTimeout(driver, 20);

		thread();
		thread();


		//Logout
		WebElement element = driver.findElement(By.xpath("(//*[@role='button'])[3]"));
		jsclick(driver, element);


		WebElement mnbv = driver.findElement(By.xpath("//*[@role='group']"));
		js.executeScript("arguments[0].click();", mnbv);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();




		//LOGIN 


		thread();
		WebElement jhgf = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(jhgf);
		wait(100);
		jhgf.sendKeys("branch_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			ac.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement kjhg = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			kjhg.sendKeys("P$2EorwK5cyc@Ar-8NOT");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement oijhgh = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(oijhgh);


		// SUBMIT 2


		thread();
		thread();

		for (int i = 0; i < 30; i++) {
			acc.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}




		driver.findElement(By.xpath("(//*[text()='Submit'])[1]")).click();

		wait(2000);

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//*[@autocomplete='off'])[32]")).sendKeys("Testing - Submit ");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();


		thread();
		thread();


		//Logout
		WebElement element7 = driver.findElement(By.xpath("(//*[@role='button'])[3]"));
		jsclick(driver, element7);


		WebElement we = driver.findElement(By.xpath("//*[@role='group']"));
		js.executeScript("arguments[0].click();", we);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();




		//LOGIN 


		thread();
		WebElement ertyu = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(ertyu);
		wait(100);
		ertyu.sendKeys("finance_authorizer_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			ac.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement rtyui = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			rtyui.sendKeys("bbJyL6et2OCjao4hy30B");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement mnbvj = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(mnbvj);

		thread();
		thread();


		waitWithTimeout(driver, 20);

		for (int i = 0; i < 30; i++) {
			actionsjh.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}



		// FINANCE AUTHORIOZER



		driver.findElement(By.xpath("(//*[text()='Approve'])[1]")).click();

		wait(2000);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@autocomplete='off']")).sendKeys("Testing - After Denied - Approve 1 ");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();


		waitWithTimeout(driver, 20);

		thread();
		thread();



		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement lkjhg7 = driver.findElement(By.xpath("//*[@role='group']"));
		js.executeScript("arguments[0].click();", lkjhg7);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();




		//LOGIN 


		thread();
		WebElement kjhgf5 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(kjhgf5);
		wait(100);
		kjhgf5.sendKeys("dcfo_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			ac.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement iuy2 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			iuy2.sendKeys("Pn!NskTNlvfJa8k~TRb$");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement fgh2 = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(fgh2);


		thread();
		thread();


		for (int i = 0; i < 30; i++) {
			acc.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}


		// DCFO - USER GRUP


		Thread.sleep(1000);


		driver.findElement(By.xpath("(//*[text()='Approve'])[1]")).click();

		wait(2000);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@autocomplete='off']")).sendKeys("Testing - After Denied - Approve 2");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();



		//REJECT 

		thread();
		thread();



		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement MNBV9 = driver.findElement(By.xpath("//*[@role='group']"));
		js.executeScript("arguments[0].click();", MNBV9);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();




		//LOGIN 


		thread();
		WebElement POIUYYT6 = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(POIUYYT6);
		wait(100);
		POIUYYT6.sendKeys("finance_reconcile_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			ac.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement OIUYTR = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			OIUYTR.sendKeys("I9y0qsXlTx2u37ygJwis");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement hjj = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(hjj);


		thread();
		thread();


		for (int i = 0; i < 30; i++) {
			acc.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}


		// RECONCILE


		Thread.sleep(1000);


		driver.findElement(By.xpath("(//*[text()='Reject'])[1]")).click();

		wait(2000);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@autocomplete='off']")).sendKeys("Testing - Reject");

		wait(500);

		driver.findElement(By.xpath("//*[text()='Next']")).click();




		thread();
		thread();


		//Logout
		driver.findElement(By.xpath("(//*[@role='button'])[3]")).click();


		WebElement xcvbn = driver.findElement(By.xpath("//*[@role='group']"));
		js.executeScript("arguments[0].click();", xcvbn);

		thread();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();




		//LOGIN 


		thread();
		WebElement vcx = driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]"));
		buttonClick(vcx);
		wait(100);
		vcx.sendKeys("branch_npo@gmail.com");

		thread();


		for (int i = 0; i < 1; i++) {
			ac.sendKeys(Keys.TAB).perform();
		}



		wait(500);
		Thread.sleep(500);


		WebElement jhgfd = driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]"));
		try {
			jhgfd.sendKeys("P$2EorwK5cyc@Ar-8NOT");
		} catch (StaleElementReferenceException e) {
		}




		wait(500);


		WebElement asdty = driver.findElement(By.xpath("//*[text()='Login']"));
		wait(100);
		buttonClick(asdty);


		// SUBMIT 2


		thread();
		thread();

		for (int i = 0; i < 30; i++) {
			acc.sendKeys(Keys.TAB).perform();
			Thread.sleep(100);
		}




	 EyeButton();
	 threadhalf();
	 History();
	 threadhalf();

	 downloadicon(1);




		extent.flush();






	}

}