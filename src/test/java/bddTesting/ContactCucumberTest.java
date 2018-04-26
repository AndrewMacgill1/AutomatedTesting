package bddTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Constants.Constants;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pomTesting.AutocompletePage;
import cucumber.api.java.en.Then;

public class ContactCucumberTest {

	WebDriver driver;
	AutocompletePage autocompletepage;
	
	@Given("^an autocomplete scenario$")
	public void an_autocomplete_scenario() {
		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
		driver = new ChromeDriver();
		driver.get(Constants.DemoQASiteURL + Constants.Autocomplete);
	}
	
	@When("^I search for part of a word$")
	public void i_search_for_part_of_a_word() throws InterruptedException {
		autocompletepage = PageFactory.initElements(driver, AutocompletePage.class);
		autocompletepage.searchForString(driver, "script");
	}
	
	@Then("^the word is autofilled$")
	public void the_word_is_autofilled() {
		String actualResult = autocompletepage.checkString();
		String expectedResult = "JavaScript";
		
		assertEquals(expectedResult,actualResult);
	}
	
}
