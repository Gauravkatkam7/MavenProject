package PB_Module1_Login;

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
	
	public void inpPBMobNumPagemobNum(String mobilenumber)
	{
		mobNum.sendKeys(mobilenumber);
	}
	
	public void clickPBMobNumPageSignInBtn()
	{
		signInWithPwd.click();
	}











}
