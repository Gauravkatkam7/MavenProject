package PB_Module2_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPolicyPage {

	@FindBy(xpath="//h3[text()='Your Policies']")private WebElement yourPolicies;
	
	public PBPolicyPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getPBPolicyPageYourPolicies()
	{
		String text = yourPolicies.getText();
		return text;
	}
}
