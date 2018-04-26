package pomTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemoQAPage {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"menu-item-64\"]/a")
	private WebElement contactTab;
	
	public void goToContactsPage(WebDriver driver) {
		contactTab.click();
	}

}
