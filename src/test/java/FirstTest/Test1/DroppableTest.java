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


public class DroppableTest {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
		driver = new ChromeDriver();
	}
	
	@Test
	public void droppableTest() throws InterruptedException, IOException {
		driver.get(Constants.DemoQASiteURL + Constants.Droppable);
		WebElement droppableBox = driver.findElement(By.xpath("//*[@id=\"draggableview\"]"));
		WebElement droppableTarget = driver.findElement(By.xpath("//*[@id=\"droppableview\"]"));
		Actions builder = new Actions(driver);
		
		Thread.sleep(3000);
				
		builder.dragAndDrop(droppableBox, droppableTarget).perform();
		
		
		Thread.sleep(3000);
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}