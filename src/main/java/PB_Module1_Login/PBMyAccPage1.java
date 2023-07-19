package PB_Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyAccPage1 {

	@FindBy(xpath="//span[text()=' My profile ']")private WebElement myProfile;
	@FindBy(xpath="//span[text()='Sign out']")private WebElement signOut;
	
	public PBMyAccPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickPBMyAccPage1myProfile()
	{
		myProfile.click();
	}
	
	public void signOutPBMyAccPage1SignOut()
	{
		signOut.click();
	}
	
	









}
