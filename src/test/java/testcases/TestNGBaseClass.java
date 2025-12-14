package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import common.ExcelConfig;
import common.ExtentReport;
import common.SeleniumGenerics;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProductPage;

public class TestNGBaseClass extends SeleniumGenerics{

	
	public WebDriver driver = null;
	public ExcelConfig excel = null;
	public DashboardPage _DashboardPage = null;
	public LoginPage _LoginPage = null;
	public ProductPage _ProductPage = null;
	
	
	@BeforeMethod
	public void beforeMethod() 
	{
		sa = new SoftAssert();
		hmap.clear();
		driver = openBrowser("Chrome", "https://playground.bsparksoftwaretechnologies.com/");
		
		//_DashboardPage = new DashboardPage(driver);
		//_LoginPage = new LoginPage(driver);
		
		_DashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		_LoginPage = PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	
	@AfterMethod
	public void afterMethod() 
	{
		quitBrowser(driver);
	}
	
	@BeforeSuite
	public void beforeSuite() 
	{
		ExtentReport.startReport();
	}
	
	@AfterSuite
	public void afterSuite() 
	{
		ExtentReport.endReport();
	}
	
	
}
