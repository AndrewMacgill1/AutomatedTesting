package tests;

import static org.junit.Assert.*;

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
import org.openqa.selenium.support.ui.Select;


public class RegistrationTest {
	
	WebDriver driver;
	Select countrydropdown;
	Select monthdropdown;
	Select daydropdown;
	Select yeardropdown;
	String username = "AndrewMacgill002";
	String password = "AmAcG1||'s Pa$$w0Rd";
	String email = "andrew.macgill002@qa.com";
	String description = "Absolute pure G";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
		driver = new ChromeDriver();
	}
	
	@Test
	public void registrationTest() throws InterruptedException, IOException {
		driver.get(Constants.DemoQASiteURL + Constants.Registration);
		Actions builder = new Actions(driver);
		
		WebElement firstNameTextBox = driver.findElement(By.xpath("//*[@id=\"name_3_firstname\"]"));
		firstNameTextBox.sendKeys("Andrew");
		
		Thread.sleep(500);
		
		WebElement lastNameTextBox = driver.findElement(By.xpath("//*[@id=\"name_3_lastname\"]"));
		lastNameTextBox.sendKeys("Macgill");
		
		Thread.sleep(500);
		
		WebElement singleRadioButton = driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[2]/div/div/input[1]"));
		singleRadioButton.click();
		
		Thread.sleep(500);
		
		WebElement danceButton = driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[3]/div/div/input[1]"));
		WebElement cricketButton = driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[3]/div/div/input[3]"));
		builder.moveToElement(danceButton).click().perform();
		builder.moveToElement(cricketButton).click().perform();
		
		Thread.sleep(500);
		
		countrydropdown = new Select(driver.findElement(By.xpath("//*[@id=\"dropdown_7\"]")));
		countrydropdown.selectByIndex(191);
		
		Thread.sleep(500);
		
		monthdropdown = new Select(driver.findElement(By.xpath("//*[@id=\"mm_date_8\"]")));
		monthdropdown.selectByIndex(2);
		
		Thread.sleep(500);
		
		daydropdown = new Select(driver.findElement(By.xpath("//*[@id=\"dd_date_8\"]")));
		daydropdown.selectByIndex(1);
		
		Thread.sleep(500);
		
		yeardropdown = new Select(driver.findElement(By.xpath("//*[@id=\"yy_date_8\"]")));
		yeardropdown.selectByIndex(20);
		
		Thread.sleep(500);
		
		WebElement phoneNumberTextBox = driver.findElement(By.xpath("//*[@id=\"phone_9\"]"));
		phoneNumberTextBox.sendKeys("07786533402");
		
		Thread.sleep(500);
		
		WebElement usernameTextBox = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		usernameTextBox.sendKeys(username);
		
		Thread.sleep(500);
		
		WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"email_1\"]"));
		emailTextBox.sendKeys(email);
		
		Thread.sleep(500);
		
//		Insert profile pic here
		
		Thread.sleep(500);
		
		WebElement aboutYourselfTextBox = driver.findElement(By.xpath("//*[@id=\"description\"]"));
		aboutYourselfTextBox.sendKeys(description);
		
		Thread.sleep(500);
		
		WebElement passwordTextBox = driver.findElement(By.xpath("//*[@id=\"password_2\"]"));
		passwordTextBox.sendKeys(password);
		
		Thread.sleep(500);
		
		WebElement reenterpasswordTextBox = driver.findElement(By.xpath("//*[@id=\"confirm_password_password_2\"]"));
		reenterpasswordTextBox.sendKeys(password);
		
		Thread.sleep(500);
		
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[14]/div/input"));
		submitButton.click();
		
		Thread.sleep(5000);
		
		String dispMessage = driver.findElement(By.xpath("//*[@id=\"post-49\"]/div/p")).getText();
		
		assertEquals("Thank you for your registration",dispMessage);
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}