package PB_Module2_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBProfilePage {

	@FindBy(xpath="//input[@name=\"personName\"]")private WebElement fullName;
	@FindBy(xpath="//input[@name=\"email\"]")private WebElement email;
	
	public PBProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public String getPBProfilePageFullName()
	{
		
		String actName = fullName.getAttribute("value");
		return actName;
	}
	
	public String getPBProfilePageEmail()
	{
		String value = email.getAttribute("value");
		return value;
		
	}
}
