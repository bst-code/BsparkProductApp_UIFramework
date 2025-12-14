package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.ExcelConfig;
import common.PrintUtills;

public class LoginTest extends TestNGBaseClass {

	@BeforeClass
	public void beforeClass() 
	{
		excel = new ExcelConfig("LoginPage");
	}

	@Test(enabled = false)
	public void verifyWithValidCredentials() 
	{

		try {

			excel.getData("TC001");
			_DashboardPage.clickProductManagement();
			//_LoginPage.loginWithValidData("admin", "admin", "product-management");
			_LoginPage.loginWithValidData(hmap.get("UserName"), hmap.get("Password"), hmap.get("expectedText"));
		}
		catch(Exception e) 
		{
			PrintUtills.logError("Exception occured please check");
		}
		finally 
		{
			checkAssertAll();
		}
	}


	@Test
	public void verifyWithEmptyData() 
	{
		try {
			excel.getData("TC002");
			_DashboardPage.clickProductManagement();
			_LoginPage.loginWithInValidData("","", hmap.get("expectedErrorMsg"));

		}
		catch(Exception e) 
		{
			PrintUtills.logError("Exception occured please check");
		}
		finally 
		{
			checkAssertAll();
		}
	}


	@Test
	public void verifyWithValidUserNameAndInvalidPassword() 
	{
		try {
			excel.getData("TC003");
			_DashboardPage.clickProductManagement();
			_LoginPage.loginWithInValidData(hmap.get("UserName"), hmap.get("Password"), hmap.get("expectedErrorMsg"));

		}
		catch(Exception e) 
		{
			PrintUtills.logError("Exception occured please check");
		}
		finally 
		{
			checkAssertAll();
		}
	}
}
