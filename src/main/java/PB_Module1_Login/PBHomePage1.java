package PB_Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Library.UtilityClass1;

public class PBHomePage1 {
	@FindBy(xpath="//div[text()='My Account']")private WebElement myAcc;
	@FindBy(xpath="//span[text()='Sign out']")private WebElement signOut;
	WebDriver driver1;
	
	public PBHomePage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	

	public void clickSignOutPBHomePage1()
	{
		signOut.click();
	}
	
	public WebElement openDDOptionsPBHomePage1myAcc()
	{
		return myAcc;
		//UtilityClass1.openDDOptionsPBHomePage1MyAcc(driver1, ele);
	}
	
	

}
