package pomTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PHPHomepage {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen10\"]/a/span[1]")
	private WebElement locationTextbox;
	
	@FindBy(how = How.NAME, using = "checkin")
	private WebElement checkinDate;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[14]/div[1]/table/tbody/tr[5]/td[4]")
	private WebElement arrivalDay;
	
	@FindBy(how = How.NAME, using = "checkout")
	private WebElement checkoutDate;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[15]/div[1]/table/tbody/tr[5]/td[6]")
	private WebElement twoDaysLater;
	
	@FindBy(how = How.NAME, using = "adults")
	private WebElement adultDropdown;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"HOTELS\"]/form/div[3]/div[3]/button")
	private WebElement submitButton;
	
	@FindBy(how = How.XPATH, using = "//div[@id='body-section']/div[5]/div[3]/div/table/tbody/tr/td/div[2]/div/h4/a/b")
	private WebElement hotelChoice;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ROOMS\"]/div/table/tbody/tr[1]/td/div[2]/div[3]/div[3]/button")
	private WebElement bookNow;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div[4]/div/div[2]/form/div[1]/div/input")
	private WebElement startDayCalendar;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[17]/div[1]/table/tbody/tr[5]/td[6]")
	private WebElement startDayNumber;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div[4]/div/div[2]/form/div[2]/div/input")
	private WebElement endDayCalendar;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[19]/div[1]/table/tbody/tr[6]/td[1]")
	private WebElement endDayNumber;
	
	public void enterLocation(WebDriver driver, String location) throws InterruptedException {
				
		Actions builder = new Actions(driver);
		locationTextbox.click();
		
		builder.sendKeys(location).perform();
		
		Thread.sleep(1000);
		
		builder.sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(1000);
		
	}
	
public void enterArrivalDate() throws InterruptedException {
		

		checkinDate.click();
		
		Thread.sleep(1000);
		
		arrivalDay.click();
		
		Thread.sleep(1000);
		
	}
	
	public void enterLeaveDate() throws InterruptedException {
		

		checkoutDate.click();
		
		Thread.sleep(1000);
		
		twoDaysLater.click();
		
		Thread.sleep(1000);
		
	}
	
	public void numberOfAdults(WebDriver driver) throws InterruptedException {
		
		Actions builder = new Actions(driver);
		adultDropdown.click();
		
		builder.sendKeys(Keys.ARROW_DOWN).perform();
		
		Thread.sleep(1000);
		
		builder.sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(1000);
		
	}

	public void submitSearch() {
		submitButton.click();
	}
	
	public void chooseHotel() {
		hotelChoice.click();
	}
	
	public void refineStartDate(WebDriver driver) throws InterruptedException {

		Actions builder = new Actions(driver);
		
		for (int i = 0; i < 30 ; i++) {
			builder.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(50);
		}
		startDayCalendar.click();
		Thread.sleep(500);
		startDayNumber.click();
		Thread.sleep(500);
	}
	
	public void refineEndDate() throws InterruptedException {
		endDayCalendar.click();
		Thread.sleep(500);
		endDayNumber.click();
		Thread.sleep(500);
	}
	
	public void chooseRoom() throws InterruptedException {
				
		bookNow.click();
		
		Thread.sleep(5000);
	}

}
