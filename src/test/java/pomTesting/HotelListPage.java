package pomTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HotelListPage {
	
	@FindBy(how = How.XPATH, using = "//div[@id='body-section']/div[5]/div[3]/div/table/tbody/tr/td/div[2]/div/h4/a/b")
	private WebElement hotelChoice;

	
	public void chooseHotel() throws InterruptedException {
				
		Thread.sleep(3000);
		
		System.out.println(hotelChoice.isDisplayed());

		System.out.println(hotelChoice.isEnabled());

		System.out.println(hotelChoice.isSelected());
		
		hotelChoice.click();
		
		Thread.sleep(1000);
		
	}

}