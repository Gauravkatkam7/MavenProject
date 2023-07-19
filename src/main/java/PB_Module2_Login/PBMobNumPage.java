package PB_Module2_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMobNumPage {

	@FindBy(xpath="(//input[@type=\"number\"])[2]")private WebElement mobNum;
	@FindBy(xpath="(//span[text()='Sign in with Password'])[2]")private WebElement signInWithPwd;

	public PBMobNumPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpPBMobNumPageMobNum(String mobileNumber)
	{
		mobNum.sendKeys(mobileNumber);
	}
	
	public void clickPBMobNumPageSignInWithPwdBtn()
	{
		signInWithPwd.click();
	}














}
