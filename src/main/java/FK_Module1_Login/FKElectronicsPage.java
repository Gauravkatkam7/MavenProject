package FK_Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FKElectronicsPage {

	@FindBy(xpath="//a[text()='Gaming']")private WebElement gaming;
	
	public FKElectronicsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickFKElectronicsPageGaming()
	{
		gaming.click();
	}
}
