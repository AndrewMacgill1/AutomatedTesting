package pomTesting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactsPage {
	

	@FindBy(how = How.NAME, using = "your-name")
	private WebElement nameTextBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wpcf7-f375-p28-o1\"]/form/p[5]/input")
	private WebElement sendButton;
	
	public void ContactRequest(WebDriver driver, String name, String email, String subject, String message) throws InterruptedException {
				
		Actions builder = new Actions(driver);
		nameTextBox.click();
		
		builder.sendKeys(name).perform();
		builder.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		builder.sendKeys(email).perform();
		builder.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		builder.sendKeys(subject).perform();
		builder.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		builder.sendKeys(message).perform();
		
		sendButton.click();
		
		Thread.sleep(5000);
	}

}
