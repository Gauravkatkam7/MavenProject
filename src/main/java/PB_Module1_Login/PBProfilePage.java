package PB_Module1_Login;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBProfilePage {

	@FindBy(xpath="//input[@name=\"personName\"]")private WebElement fullName;
	WebDriver driver1;
	
	public PBProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void switchToChildBrowser()
	{
		Set<String> allid = driver1.getWindowHandles();
		ArrayList<String>ar=new ArrayList<String>(allid);
		driver1.switchTo().window(ar.get(1));
	}
	
	public String getActualResult()
	{
		String actualResult = fullName.getAttribute("value");
		
		return actualResult;
	}

}
