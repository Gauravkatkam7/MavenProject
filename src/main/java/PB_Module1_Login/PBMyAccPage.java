package PB_Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyAccPage {

	@FindBy(xpath="//span[text()=' My profile ']")private WebElement myProfile;
	
	public PBMyAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickPBMyAccPagemyProfile()
	{
		myProfile.click();
	}
}
