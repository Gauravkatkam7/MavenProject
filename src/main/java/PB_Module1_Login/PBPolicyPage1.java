package PB_Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPolicyPage1 {
	
	@FindBy(xpath="//span[text()='Access all of policies']")private WebElement myPolicies;
	@FindBy(xpath="//h3[text()='Your Policies']")private WebElement yourPolicies;
	WebDriver driver1;
	
	public PBPolicyPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void clickPBPolicyPage1MyPolicies()
	{
		myPolicies.click();
	}

	public String getTextPBPolicyPage1YourPolicies()
	{
		String text = yourPolicies.getText();
		
		return text;
	}
}
