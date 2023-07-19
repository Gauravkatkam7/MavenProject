package PB_Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLoginPage {

	@FindBy(xpath="//a[text()='Sign in']")private WebElement signIn;
	
	public PBLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickPBLoginPagesignIn()
	{
		signIn.click();
	}
}
