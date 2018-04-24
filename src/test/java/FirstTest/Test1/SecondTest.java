package FirstTest.Test1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import Constants.Constants;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SecondTest {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
		driver = new ChromeDriver();
	}
	
	@Test
	public void secondTest() throws InterruptedException, IOException {
		driver.get(Constants.DemoQASiteURL + Constants.Draggable);
		WebElement box = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		Actions builder = new Actions(driver);
		
		Thread.sleep(5000);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dest = "C:\\Users\\Admin\\AutomatedTesting\\name.png";

		File finaldest = new File(dest);
		
		FileUtils.copyFile(scrFile,finaldest);
		
		builder.dragAndDropBy(box, 100, 50).perform();
		
		
		
		Thread.sleep(3000);
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}