package PB_Module1_Login;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBProfilePage1 {

	@FindBy(xpath="//input[@name='personName']")private WebElement fullName;
	@FindBy(xpath="//input[@name='email']")private WebElement email;
	
	WebDriver driver1;
	public PBProfilePage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getActualName()
	{
		String actualResult = fullName.getAttribute("value");
		
		return actualResult;
	}
	
	public String getActualEmail()
	{
		String actulaEmail = email.getAttribute("value");
		return actulaEmail;
	}
}
