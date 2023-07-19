package FK_Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FKHomePage {

	@FindBy(xpath="//div[text()='Electronics']")private WebElement electronics;
	WebDriver driver1;
	
	public FKHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void openDDOptionsFKHomePageelectronics()
	{
		Actions act=new Actions(driver1);
		act.moveToElement(electronics).perform();
	}
}
