package tests;

import static org.junit.Assert.*;
import Constants.Constants;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FirstTest {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String LoginData = Constants.Path_TestData + Constants.File_TestData;
	
	public void driverSelector(String browser) {
		
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.ChromeDriver);
			driver = new ChromeDriver();
		}
		else if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.GeckoDriver);
			driver = new FirefoxDriver();
		}
		else if (browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", Constants.EdgeDriver);
			driver = new EdgeDriver();
		}
		else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", Constants.IEDriver);
			driver = new InternetExplorerDriver();
		}
		else {
			//default to chrome driver
			System.setProperty("webdriver.chrome.driver", Constants.ChromeDriver);
			driver = new ChromeDriver();
		}
	}
	
	
	@Before
	public void setUp() {
//		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
//		driver = new ChromeDriver();
		report = new ExtentReports(Constants.ExtentReport);
		test = report.startTest("StartingTest");
	}
	
	@Test
	public void firstTest() throws InterruptedException, IOException {
		
		FileInputStream file = null;
		file = new FileInputStream(LoginData);
		XSSFWorkbook workbook = null;
		workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		
		for (int i = 1; i < 4; i++) {
			
			
			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);
			Cell getBrowser = sheet.getRow(i).getCell(2);
		
			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();
			String browser = getBrowser.getStringCellValue();
			
			driverSelector(browser);
		
			driver.get(Constants.DemoSiteURL);
			test.log(LogStatus.INFO, "navigate to demosite homepage");
		
			driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/input")).click();
			driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/input")).sendKeys(user);
		
			test.log(LogStatus.INFO, "inputting new username");
		
			driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/input")).click();
			driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/input")).sendKeys(pass);
		
			test.log(LogStatus.INFO, "inputting new password");
		
			driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/input")).click();
		
			test.log(LogStatus.INFO, "Saving new user");
		
			driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[4]")).click();
			Thread.sleep(1000);
		
			test.log(LogStatus.INFO, "navigate to login");
		
			driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input")).click();
			driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input")).sendKeys(user);
		
			test.log(LogStatus.INFO, "Entering username on login screen");
		
			driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input")).click();
			driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input")).sendKeys(pass);
		
			test.log(LogStatus.INFO, "Entering password in login screen");
		
			driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[3]/td[2]/input")).click();
		
			test.log(LogStatus.INFO, "Saving login, testing if it exists");
		
			String title = driver.findElement(By.xpath("/html/body/big/blockquote/blockquote/div/h2/font/center/b")).getText();
		
			String expected = "**Successful Login**";
			assertEquals(expected,title);
			test.log(LogStatus.PASS,"Successfully created a user and logged in with it");
			
			driver.quit();
		
		
		}
		
		workbook.close();
		
	}
	
	
	@After
	public void tearDown() {
		report.endTest(test);
		report.flush();
//		driver.quit();
		
	}
}