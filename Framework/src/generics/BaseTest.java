package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant
{
	public static WebDriver driver;
	static
	{
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(IE_KEY, IE_PATH);
	}
	
	@BeforeMethod
	public void openApplication() 
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get(Lib.getPropertyValue("URL"));
		String timeout = Lib.getPropertyValue("ImplictTimeout");
		long wait=Long.parseLong(timeout);
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		
				
	}
	
	@AfterMethod
	public void closeApplication(ITestResult res)
	{
		if(ITestResult.FAILURE==res.getStatus())
		{
			Lib.captureScreenshot(driver, res.getName());
		}
		
		driver.close();
	}

}
