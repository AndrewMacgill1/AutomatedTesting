package bddTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Constants.Constants;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pomTesting.HotelListPage;
import pomTesting.PHPHomepage;
import cucumber.api.java.en.Then;

public class HotelTesting {

	WebDriver driver;
	PHPHomepage homepage;
	HotelListPage hotelsPage;
	
	@Given("^search criteria$")
	public void search_criteria() {
		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
		driver = new ChromeDriver();
		driver.get(Constants.PHPHotelsURL);
	}
	
	@When("^I fill in the form$")
	public void i_fill_in_the_form() throws InterruptedException {
		homepage = PageFactory.initElements(driver, PHPHomepage.class);
		homepage.enterLocation(driver, "London");
		homepage.enterArrivalDate();
		homepage.enterLeaveDate();
		homepage.numberOfAdults(driver);
		homepage.submitSearch();
		homepage.chooseHotel();
		homepage.refineStartDate(driver);
		homepage.refineEndDate();
		homepage.refineAdults(driver);
		homepage.modifyChange();
		homepage.chooseRoom(driver);
	}
	
	@Then("^I am directed to my hotel choice$")
	public void I_am_directed_to_my_hotel_choice() {
		String currentURL = driver.getCurrentUrl();
		String expectedURL = Constants.LatestHotelURL;
		assertEquals(expectedURL,currentURL);
	}
		
}