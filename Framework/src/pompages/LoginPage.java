package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(name="username")
	WebElement unTB;
	
	@FindBy(name="pwd")
	WebElement pwTB;
	
	@FindBy(id="loginButton")
	WebElement lnBTN;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pwd)
	{
		pwTB.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		lnBTN.click();
	}
	
	public void clear()
	{
		
		unTB.clear();
		pwTB.clear();
	}

}
