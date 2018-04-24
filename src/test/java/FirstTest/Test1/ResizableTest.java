package FirstTest.Test1;

import java.io.IOException;

import Constants.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ResizableTest {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
		driver = new ChromeDriver();
	}
	
	@Test
	public void secondTest() throws InterruptedException, IOException {
		driver.get(Constants.DemoQASiteURL + Constants.Resizable);
		WebElement boxResizer = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		Actions builder = new Actions(driver);
		
		Thread.sleep(3000);
		
		builder.moveToElement(boxResizer).clickAndHold().moveByOffset(300, 100).perform();
		
		Thread.sleep(3000);
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}