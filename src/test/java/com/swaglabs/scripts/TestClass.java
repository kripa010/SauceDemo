package com.swaglabs.scripts;
import java.io.IOException;

import org.testng.annotations.Test;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.utilities.Excelutility;

public class TestClass extends TestBase {
	Loginpage objLogin;
	@Test
	public void verifyValidLogin() throws IOException
	{
		objLogin = new Loginpage(driver);
		String username= Excelutility.getCellData(0, 0);
		String password=Excelutility.getCellData(0, 1);
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
	}
		

}


