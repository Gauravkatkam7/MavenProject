package PB_Module2_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBHomePage {

	@FindBy(xpath="//div[text()='My Account']")private WebElement myAcc;
	@FindBy(xpath="//div[@class=\"shadowHandlerBox\"]")private WebElement termInsurance; 
	public PBHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPBHomePagemyAcc()
	{
		return myAcc;
	}
	
	public void clickPBHomePageTermInsurance()
	{
		termInsurance.click();
	}
}
