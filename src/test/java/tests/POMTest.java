package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Constants.Constants;
import pomTesting.ContactsPage;
import pomTesting.DemoQAPage;

public class POMTest {
	
	WebDriver driver;

	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
		driver = new ChromeDriver();

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testContactsPage() throws InterruptedException {
		driver.get(Constants.DemoQASiteURL);
		DemoQAPage homepage = PageFactory.initElements(driver,DemoQAPage.class);
		homepage.goToContactsPage(driver);
		ContactsPage contactspage = PageFactory.initElements(driver, ContactsPage.class);
		contactspage.ContactRequest(driver, "Andrew", "user@qa.com","complaint","Not a big fan of little Kev");
		
		String success = "Your message was sent successfully. Thanks.";
		
		WebElement display = driver.findElement(By.xpath("//*[@id=\"wpcf7-f375-p28-o1\"]/form/div[2]"));
		
		assertEquals(success, display.getText());
	}
	

}
