package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.SeleniumGenerics;

public class DashboardPage extends SeleniumGenerics {
	
	
	// POM -- Object repo for UI webElements 
	
	private WebDriver driver;
	
	public DashboardPage(WebDriver pageDriver) 
	{
		this.driver = pageDriver;
	}
	
	//1. Locate WebElement 
		
	@FindBy(xpath = "//h4[text()='Product Management']")
	WebElement ProductMangamentEle;
	
	
	//2. Write page methods
	public void clickProductManagement() 
	{
		clickElement(ProductMangamentEle);
	}

}
