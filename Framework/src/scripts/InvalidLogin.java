package scripts;

import org.testng.annotations.Test;

import generics.BaseTest;
import generics.Lib;
import pompages.LoginPage;

public class InvalidLogin extends BaseTest
{
	@Test
	public void testInvalidLogin() throws Exception 
	{
		LoginPage login=new LoginPage(driver);
		for(int i=1;i<=Lib.getRowCount("InvalidLogin");i++)
		{
			login.setUserName(Lib.getCellValue("InvalidLogin", i, 0));
			login.setPassword(Lib.getCellValue("InvalidLogin", i, 1));
			login.clickLogin();
			Thread.sleep(1000);
			login.clear();
			
			
		}
	}

}
