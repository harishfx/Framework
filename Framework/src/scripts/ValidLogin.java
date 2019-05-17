package scripts;

import org.testng.annotations.Test;
import generics.BaseTest;
import generics.Lib;
import pompages.LoginPage;

public class ValidLogin extends BaseTest
{
	@Test
	public void testLogin()
	{
		LoginPage login=new LoginPage(driver);
		login.setUserName(Lib.getCellValue("ValidLogin", 1, 0));
		login.setPassword(Lib.getCellValue("ValidLogin", 1, 1));
		login.clickLogin();
		
		
	}

}
