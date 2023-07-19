package PB_Module2_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBTermInsurancePage {

	@FindBy(xpath="//img[@src=\"https://static.pbcdn.in/term-cdn/images/images/Covid_virus.svg\"]")private WebElement img;
	
	public PBTermInsurancePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean getPBTermInsurancePageImg()
	{
		boolean result = img.isDisplayed();
		return result;
	}












}
