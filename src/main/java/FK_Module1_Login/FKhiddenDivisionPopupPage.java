package FK_Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FKhiddenDivisionPopupPage {

	@FindBy(xpath="//button[@class=\"_2KpZ6l _2doB4z\"]") private WebElement close;

	public FKhiddenDivisionPopupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickFKhiddenDivisionPopupPageCloseBtn()
	{
		close.click();
	}
}
