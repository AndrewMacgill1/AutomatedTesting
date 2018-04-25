package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import Constants.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class CookieTest {
	
	WebDriver driver;
	Actions builder;
	String email = "apmacgill@outlook.com";
	String password = "AMac130279961";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
		driver = new ChromeDriver();
		builder = new Actions(driver);
	}
	
	@Test
	public void cookieTest() throws InterruptedException, IOException, ParseException {
		
		
		login();
		createCookie();
		logout();
		navigateAway();
		loadCookie();
		
				
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public void login() throws InterruptedException {
		
		driver.get(Constants.BBCSiteURL);
		WebElement signInBox = driver.findElement(By.xpath("//*[@id=\"idcta-link\"]"));
		signInBox.click();
		
		WebElement emailBox = driver.findElement(By.xpath("//*[@id=\"user-identifier-input\"]"));
		emailBox.click();
		
		builder.sendKeys(email).perform();
		
		builder.sendKeys(Keys.TAB).perform();
		
		Thread.sleep(500);
		
		builder.sendKeys(password).perform();
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
		
		checkLogin();
		
	}
	
	public void checkLogin() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"idcta-link\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"idcta-link\"]")).click();
		
		Thread.sleep(500);
		
		String greeting = driver.findElement(By.xpath("//*[@id=\"orb-modules\"]/div[1]/div/div/div[1]/div[1]/div/div/div/h1")).getText();
		
		if(greeting.contains("Your account")) {
			
			System.out.println("Successful Login");
			
		}
		
	}
	
	public void createCookie() throws IOException {
		
		File f;
		BufferedWriter buff;
		
		f = new File("browser.data");
		f.delete();
		f.createNewFile();
		
		buff = new BufferedWriter(new FileWriter(f));
		
		for(Cookie cook : driver.manage().getCookies()) {
			
			buff.write(cook.getName() + ";" + cook.getValue() + ";" + cook.getDomain() + ";" + cook.getPath() + ";" + cook.getExpiry() + ";" + cook.isSecure());
			buff.newLine();
			
		}
		
		if(buff != null) {
			buff.close();
		}
		
	}
	
	public void logout() {
		
		driver.findElement(By.xpath("//*[@id=\"orb-modules\"]/div[1]/div/div/div[1]/div[1]/div/div/div/div/nav/ul/li[3]/a/span")).click();
		
	}
	
	public void navigateAway() throws InterruptedException {
		
		driver.get(Constants.GoogleURL);
		builder.sendKeys("Automated Testing Is Dull").perform();
		
		Thread.sleep(1000);
	}
	
	@SuppressWarnings("resource")
	public void loadCookie() throws IOException, ParseException, InterruptedException {
		
		File f = new File("browser.data");
		BufferedReader buffread = new BufferedReader(new FileReader(f));
		String line;
		
		while ((line = buffread.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(line, ";");
			while (str.hasMoreTokens()) {
				String name = str.nextToken();
				String value = str.nextToken();
				String domain = str.nextToken();
				String path = str.nextToken();
				Date expiry = null;
				String dt;
				
				if(!(dt = str.nextToken()).equals("null")) {
					expiry = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(dt);
				}
				boolean isSecure = new Boolean(str.nextToken()).booleanValue();
				Cookie cook = new Cookie(name, value, domain, path, expiry, isSecure);
				driver.manage().addCookie(cook);
			}
		}
		
		Thread.sleep(500);
		
		driver.get(Constants.BBCSiteURL);
		
		Thread.sleep(500);
		
		checkLogin();
	}
	
}