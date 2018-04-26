package pomTesting;

	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.junit.*;
	import static org.junit.Assert.*;
	import static org.hamcrest.CoreMatchers.*;
	import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Constants.Constants;

	public class temp {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private Actions builder = null;
	

	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
	    driver = new ChromeDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    builder = new Actions(driver);
	  }

	  @Test
	  public void testUntitledTestCase() throws Exception {
	    driver.get("https://www.phptravels.net/");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"s2id_autogen10\"]/a/span[1]")).click();
	 
	    builder.sendKeys("London").perform();
		
		Thread.sleep(1000);
		
		builder.sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(1000);
	    
	    driver.findElement(By.name("checkin")).click();
	    driver.findElement(By.xpath("//tr[5]/td[3]")).click();
	    driver.findElement(By.xpath("//tr[5]/td[3]")).click();
	    driver.findElement(By.xpath("//tr[5]/td[3]")).click();
	    driver.findElement(By.name("checkin")).click();
	    driver.findElement(By.name("checkout")).click();
	    driver.findElement(By.xpath("//div[15]/div/table/tbody/tr[5]/td[6]")).click();
	    driver.findElement(By.id("adults")).click();
	    new Select(driver.findElement(By.id("adults"))).selectByVisibleText("3");
	    driver.findElement(By.id("adults")).click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    driver.findElement(By.xpath("//div[@id='body-section']/div[5]/div[3]/div/table/tbody/tr/td/div[2]/div/h4/a/b")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

/*	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }*/
	}

	
