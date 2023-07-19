package PB_Module2_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyAccPage {

	@FindBy(xpath="//span[text()=' My profile ']")private WebElement myProfile;
	@FindBy(xpath="//span[text()='Access all of policies']") private WebElement myPolicies;
	@FindBy(xpath="//span[text()='Sign out']")private WebElement signOut;
	
	public PBMyAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickPBMyAccPageMyProfileBtn()
	{
		myProfile.click();
	}
	
	public void clickPBMyAccPageSignOut()
	{
		signOut.click();
	}
	
	public void clickPBMyAccPageMyPoliciesBtn()
	{
		myPolicies.click();
	}
	
}
