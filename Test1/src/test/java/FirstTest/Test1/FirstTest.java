package FirstTest.Test1;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.xpath.XPath;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FirstTest {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String LoginData = "C:\\Users\\Admin\\AutomatedTesting\\DDT\\LoginData.xlsx";
	
	//ExcelUtils.setExcelFile(LoginData,"LoginDetails");
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\AutomatedTesting\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		report = new ExtentReports("C:\\Users\\Admin\\AutomatedTesting\\ExtentReport\\reportName.html");
		test = report.startTest("StartingTest");
	}
	
	@Test
	public void firstTest() throws InterruptedException, IOException {
		
		FileInputStream file = null;
		file = new FileInputStream(LoginData);
		XSSFWorkbook workbook = null;
		workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Cell username = sheet.getRow(1).getCell(0);
		Cell password = sheet.getRow(1).getCell(1);
		
		String user = username.getStringCellValue();
		String pass = password.getStringCellValue();
		
		driver.get("http://asp.thedemosite.co.uk/");
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
		
	}
	
	
	@After
	public void tearDown() {
		report.endTest(test);
		report.flush();
		driver.quit();
		
	}
}
