package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.PrintUtills;
import common.SeleniumGenerics;

public class LoginPage extends SeleniumGenerics {

	
	private WebDriver driver;
	
	public LoginPage(WebDriver pageDriver) 
	{
		this.driver = pageDriver;
	}
	
	// locate element
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userNameEle;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordEle;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButtonEle;
	
	@FindBy(xpath = "//p[@class='error']")
	WebElement errorMsgEle;
	
	// pagemethod
	
	public void loginWithValidData(String userName, String pwd, String expectedData) 
	{
	  enterText(userNameEle, userName);
	  enterText(passwordEle, pwd);
	  clickElement(loginButtonEle);
	  
	 String currentURL =  getBrowserCurrentURL(driver);
	 if(currentURL.contains(expectedData))
	 {
		 PrintUtills.logMsg("Login success");
	 }else 
	 {
		 PrintUtills.logError("Login Failed");
	 }
		
	}
	
	public void loginWithInValidData(String userName, String pwd, String expecteError) 
	{
	  enterText(userNameEle, userName);
	  enterText(passwordEle, pwd);
	  clickElement(loginButtonEle);
	  
	 String actualValue =  getElementText(errorMsgEle);
	 if(actualValue.equals(expecteError))
	 {
		 PrintUtills.logMsg("Error message matched");
	 }else 
	 {
		 PrintUtills.logError("Error message not matched");
	 }
		
	}
	
	
}
