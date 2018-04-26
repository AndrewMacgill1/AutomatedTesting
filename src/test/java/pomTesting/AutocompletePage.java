package pomTesting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AutocompletePage {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tagss\"]")
	private WebElement textfield;
	
	public void searchForString(WebDriver driver, String script) throws InterruptedException {
				
		Actions builder = new Actions(driver);
		textfield.click();
		
		builder.sendKeys(script).perform();
		Thread.sleep(1000);
		builder.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(200);
		builder.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(200);
		builder.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		builder.sendKeys(Keys.ENTER).perform();
	}

	public String checkString() {
		
		String resultingWord;
		
		resultingWord = textfield.getAttribute("input");
		System.out.println(resultingWord);
		return resultingWord;
		
	}

}